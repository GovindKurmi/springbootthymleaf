package com.gk.springbootthymleaf.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Student {
	@Id
	@NotNull(message = "please enter roll numer")
	private int rollno;
	@NotBlank(message = "name should not blank")
	@Size(min = 3, max = 14, message = "char length should be 3 to 14")
	private String name;
	@NotBlank(message = "fathername should not be blank")
	@Size(min = 3, max = 14, message = "char length should be 3 to 14")
	private String fatherName;
	@NotBlank(message = "hindi mark should not be blank")
	private String hindi;
	@NotBlank(message = "fathername should not be blank")
	private String english;
	@NotBlank(message = "chemistry mark should not be blank")
	private String chemistry;
	@NotBlank(message = "physics mark should not be blank")
	private String physics;
	@NotBlank(message = "maths mark should not be blank")
	private String maths;
	@NotBlank(message = "cpracticle should not be blank")
	private String cpracticle;
	@NotBlank(message = "ppracticle should not be blank")
	@Size(min = 0,max = 25)
	private String ppracticle;
	@NotBlank(message = "application should not be blank")
	private String application;

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getCpracticle() {
		return cpracticle;
	}

	public void setCpracticle(String cpracticle) {
		this.cpracticle = cpracticle;
	}

	public String getPpracticle() {
		return ppracticle;
	}

	public void setPpracticle(String ppracticle) {
		this.ppracticle = ppracticle;
	}

	public String getHindi() {
		return hindi;
	}

	public void setHindi(String hindi) {
		this.hindi = hindi;
	}

	public String getEnglish() {
		return english;
	}

	public void setEnglish(String english) {
		this.english = english;
	}

	public String getChemistry() {
		return chemistry;
	}

	public void setChemistry(String chemistry) {
		this.chemistry = chemistry;
	}

	public String getPhysics() {
		return physics;
	}

	public void setPhysics(String physics) {
		this.physics = physics;
	}

	public String getMaths() {
		return maths;
	}

	public void setMaths(String maths) {
		this.maths = maths;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

}
