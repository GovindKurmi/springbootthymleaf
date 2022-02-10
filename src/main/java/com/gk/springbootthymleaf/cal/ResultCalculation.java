package com.gk.springbootthymleaf.cal;

import org.springframework.stereotype.Component;

import com.gk.springbootthymleaf.model.Marks;
import com.gk.springbootthymleaf.model.Student;

@Component
public class ResultCalculation {

	public Marks getMarks(Student stud) {
		int cmarks = Integer.parseInt(stud.getChemistry()) + Integer.parseInt(stud.getCpracticle());
		int pmarks = Integer.parseInt(stud.getPhysics()) + Integer.parseInt(stud.getPpracticle());
		Marks marks = new Marks();
		marks.setCmarks(cmarks);
		marks.setPmarks(pmarks);
		int gtotal = Integer.parseInt(stud.getHindi()) + Integer.parseInt(stud.getEnglish())
				+ Integer.parseInt(stud.getMaths()) + cmarks + pmarks;
		double percentage = (Double.valueOf(gtotal) / 5);
		marks.setGrandTotal(gtotal);
		marks.setPercentage(percentage);
		marks.setRemark("DISTN");
		String result = getResult(marks, stud);
		marks.setResult(result);
		String grade = getGrade(percentage);
		marks.setGrade(grade);
		return marks;
	}

	private String getGrade(double percentage) {
		String grade = "";
		if (percentage > 85) {
			grade = "A+";
		} else if (percentage > 75 && percentage < 85) {
			grade = "A";
		} else if (percentage > 55 && percentage < 75) {
			grade = "B";
		} else {
			grade = "C";
		}
		return grade;
	}

	private String getResult(Marks marks, Student stud) {
		int hindi = Integer.parseInt(stud.getHindi());
		int english = Integer.parseInt(stud.getEnglish());
		int chemistry = Integer.parseInt(stud.getChemistry());
		int physics = Integer.parseInt(stud.getPhysics());
		int maths = Integer.parseInt(stud.getMaths());
		String result = "";
		if (hindi >= 33 && english >= 33 && chemistry >= 22 && physics >= 22 && maths >= 33) {
			result = "PASS";
		} else {
			result = "FAIL";
		}
		return result;
	}

}
