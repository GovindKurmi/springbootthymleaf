package com.gk.springbootthymleaf.resource;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gk.springbootthymleaf.cal.ResultCalculation;
import com.gk.springbootthymleaf.model.Marks;
import com.gk.springbootthymleaf.model.Student;
import com.gk.springbootthymleaf.service.StudentService;

@Controller
public class StudentResource {
	@Autowired
	StudentService studentService;
	@Autowired
	ResultCalculation calculation;

	@RequestMapping("/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/viewresult", method = RequestMethod.POST)
	public ModelAndView save(@RequestParam("rollno") String rollno, @RequestParam("application") String application,
			RedirectAttributes redirAttrs) {
		ModelAndView modelAndView = new ModelAndView();

		try {
			Student student = studentService.getStudent(rollno);
			if (student.getRollno() != Integer.parseInt(rollno) || !student.getApplication().equals(application)) {
				modelAndView.addObject("error", "RollNumber and Application is not found");
				modelAndView.setViewName("index");
				return modelAndView;
			}
			Marks marks = calculation.getMarks(student);
			modelAndView.setViewName("userdata");
			modelAndView.addObject("student", student);
			modelAndView.addObject("marks", marks);
		} catch (Exception e) {
			modelAndView.addObject("error", "Roll Number is not found");
			modelAndView.setViewName("index");
			return modelAndView;
		}

		return modelAndView;
	}

	@RequestMapping(value = "/getstudent", method = RequestMethod.GET)
	public ModelAndView getStudent() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("addstudent");
		modelAndView.addObject("student", new Student());
		return modelAndView;
	}

	@RequestMapping(value = "/addstudent", method = RequestMethod.POST)
	public ModelAndView addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors() || Integer.parseInt(student.getCpracticle()) <= 0
				&& Integer.parseInt(student.getCpracticle()) >= 26) {
			modelAndView.setViewName("addstudent");
		} else {
			studentService.saveStudent(student);
			modelAndView.setViewName("index");
		}
		return modelAndView;
	}
}
