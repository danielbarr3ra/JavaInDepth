package com.semanticsquare.basics;

class StudentTest {



  public static void main(String[] args) {
    Student student1 = new Student(1000,"Joan","male",18,223_456_7800L, 3.8,'B');
    Student student2 = new Student(1002,"Raj","male",21,223_456_7800L,3.5,'M',true);
    Student student3 = new Student(1003,"anita","male",20,2234568888L,4.0,'M',true);
    student3.setGender("femle");
    System.out.println("\nStudent.computeCount: " + Student.studentCount);

    System.out.println("\nName of student1: " + student1.getName());
    System.out.println("\nName of student2: " + student2.getName());
    System.out.println("\nName of student3: " + student3.getName());

    student1.updateProfile("John");
    //System.out.println("\nUpdated naem of student 1 " + student1.name);


    Student student4 = new Student(1003,"anita","female",20,2234568888L,4.0,'M',true);
    boolean isDuplicate = student4.equals(student3);
    System.out.println("\n Sutdent 3 is equal to student 4? " + isDuplicate);

  //new BasicsDemo().foo();
  }
}