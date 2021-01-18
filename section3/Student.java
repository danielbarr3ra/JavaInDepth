/* 
Instance % Staticd
*/
class Student {
  static int studentCount;
  
  int id;
  String name;
  String gender;
  int age;
  long phone;
  double gpa;
  char degree;
  
  boolean international;
  double tuitionFees = 12000.0, internationalFees = 5000.0;
  
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
  void compute() {
  }
  public static void main(String[] args) {
    /*
    Student student1 = new Student(1000,"joan","male",18,223_456_7800L, 3.8,'B');
    Student student2 = new Student(1002,"Raj","male",21,223_456_7800L,3.5,'M',true);
    Student student3 = new Student(1003,"anita","female",20,2234568888L,4.0,'M',true);
    System.out.println("\nStudent.computeCount: " + Student.studentCount);

    System.out.println("\nName of student1: " + student1.name);
    System.out.println("\nName of student2: " + student2.name);
    System.out.println("\nName of student3: " + student3.name);

    student1.updateProfile("John");
    System.out.println("\nUpdated naem of student 1 " + student1.name);
    */
  }
}