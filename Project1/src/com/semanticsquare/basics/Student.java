package com.semanticsquare.basics;

public class Student {
  static int studentCount;
  
  private int id;
  private String name;

  public String getName(){
    return name;
  }
  public void setName(String name){
    this.name = name;
  }

  private String gender;

  public String getGender(){
    return gender;
  }
  public void setGender(String gender){
    if (gender.equals("male")){
      iGender = 1;
    } else if(gender.equals("female")){
      iGender = 2;
    } else if (gender.equals("transgender")){
      iGender = 3;
    }
    if (iGender == 0) {
      throw new IllegalArgumentException("InvalidGender");
    } else {
      this.gender = gender;
    }
  }

  private int iGender;
  private int age;
  private long phone;
  private double gpa;
  private char degree;
  
  private boolean international;
  private double tuitionFees = 12000.0, internationalFees = 5000.0;
  
  Student(){}
  //overloaded constructor for non international
  Student(int id, String name, String gender,int age, long phone, double gpa,
          char degree) {
    this(id, name, gender, age, phone, gpa, degree, false);      
    }
  Student(int id, String name, String gender,int age, long phone, double gpa,
          char degree, boolean international) {
    
    this.id = id;
    this.name = name; 
    this.gender = gender;
    this.age = age;
    this.phone = phone;
    this.gpa = gpa;
    this.degree = degree;
    
    this.international = international;

    studentCount += 1;
    int nextId = id + 1;

    if (international) {
      tuitionFees = tuitionFees + internationalFees;
    }
    System.out.println("\nid: " + this.id);
    System.out.println("next id: " + nextId);
    System.out.println("name: " +  this.name);
    System.out.println("gender: " +  this.gender);
    System.out.println("age: " + this.age);
    System.out.println("phone: " + this.phone);
    System.out.println("GPA: " + this.gpa);
    System.out.println("degree: " + this.degree);
    System.out.println("Tuition Fees " + this.tuitionFees);
    System.out.println("Student Count " + studentCount);
  }
  boolean updateProfile(String name) {
    this.name = name;
    return true;
  }
  boolean equals(Student s){
    return id == s.id;
  }
  void compute() {
  }
  public static void main(String[] args) {
  }
}