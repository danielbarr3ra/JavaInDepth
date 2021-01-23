public class StudentUtil {
  public static double[] calculateGPA(int[] studentIdList, char[][] studentsGrades) {
    //will store gpas here
    double[] studentGPAs = new double[studentIdList.length];

    int indexStudent = 0;
    
    for (char[] student : studentsGrades) {
      double studentTotal = 0; //initialized the total for each student
      double classesTeken = 0; //initialized classes taken to 0
      
      for (char letterGrade : student) {
        classesTeken++; //adding the class
        switch(letterGrade) {
          case 'A':
            studentTotal += 4;
            break;
          case 'B':
            studentTotal += 3;
            break;
          case 'C':
            studentTotal += 2;
            break;
        }
      }
      studentGPAs[indexStudent] = studentTotal/classesTeken;
      indexStudent ++;
    }

    return studentGPAs;
  }
  
  public static int[] getStudentsByGPA(double lower, double higher, int[] studentIdList, char[][] studentsGrades) {
    if (lower > higher || higher < 0 || lower < 0){
      return null;
    }
    //invoke it
    double[] studentGPAs = calculateGPA(studentIdList, studentsGrades);

    //check size of the result
    int howManyinRange = 0;
    for (double aGPA : studentGPAs) {
      if (aGPA <= higher && aGPA >= lower){
        howManyinRange ++;
      }
    }

    //create array of result
    int[] studentsInRange = new int[howManyinRange];

    //loop through for the original id
    for (int index = 0, student = 0; index < studentIdList.length; index++){
      if (studentGPAs[index] <= higher && studentGPAs[index] >= lower){
        studentsInRange[student] = studentIdList[index];
        student +=1;
      }
    }
    return studentsInRange;
  }

  public static void main(String[] args) {
    System.out.println("Lets Check first method");
    int[] studentList = new int[]{1001,1002,1003,1004};
    char[][] studentGrades = new char[][]{{'A','B','B'},{'A','A','A','A','A','B'},{'C','C','C','A','A','C'},{'A','C'}};
    double[] GPAs = calculateGPA(studentList,studentGrades);
    for(double GPA: GPAs){
      System.out.println(GPA);
    }
    System.out.println("Lets check second method");
    double higher = 2.7;
    double lower = 2.5;
    int[] students = getStudentsByGPA(lower,higher,studentList,studentGrades);
    for (int id : students) {
      System.out.println(id);
    }
  }
}