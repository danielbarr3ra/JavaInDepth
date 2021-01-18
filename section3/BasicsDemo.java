import java.math.BigDecimal;

class BasicsDemo {
  //1.Naming rules
  //first char letter, _, $, 
  //rest letter, _, $ numbers
  //no reserve keywords
  int id1 = 0;
  int id = 0;
  int Id = 0;
  int ID = 0;

  void foo() {}
  void Foo() {}

  static void print() {
    System.out.println("\n\nInside print ...");
    System.out.println("Hello, world!!"); // Advance cursor to beginning of next line
    System.out.println();                 // Print empty line
    System.out.print("Hello, world!!");   // Cursor stayed after the printed string
    System.out.println("Hello,");
    System.out.print(" ");                // Print a space
    System.out.print("world!!");
  }

  static void primitives() {
    System.out.println("\n\nInside primitives....");
    long intHex = 0x0041L;
    System.out.println("intHex: " + intHex);

    int intBinary = 0b01000_001;
    System.out.println("intBinary: " + intBinary);

    int intOctal = 0101;
    System.out.println("intOctal: " + intOctal);

    int charInt = 'A';
    char charHex = 0x0041;
    char charBinary = 0b01000_001;

    System.out.println("int " + charInt);
    System.out.println("charHex " + charHex);
    System.out.println("charBin " + charBinary);

  }
  static void typeCasting() {
    System.out.println("\nInside typeCasting ...");
    // Explicit casting
    long y = 42;
    //int x = y;
    int x = (int)y;
    
    // Information loss due to out-of-range assignment
    byte narrowdByte = (byte) 123456;
    System.out.println("narrowdByte: " + narrowdByte); 
  
    // Truncation
    int iTruncated = (int)0.99;
    System.out.println("iTruncated: " + iTruncated); 
  
    // Implicit cast (int to long)
    y = x;
  
    // Implicit cast (char to int)
    char cChar = 'A';
    int iInt = cChar; 
    System.out.println("iInt: " + iInt);
  
    // byte to char using an explicit cast
    byte bByte = 65;
    cChar = (char)bByte; // special conversion (widening from byte --> int followed by narrowing from int --> char)
    System.out.println("cChar: " + cChar);
}

static int count = 25;
//static int[] scores; //initialzied to nulll;
static void arrays() {
  System.out.println("\nInside arrays....");
  //int[] scores = new int[4];
  // could also be int scores[]
  int[] scores = new int[4]; // initialization of object
  scores[0] = 90;
  scores[1] = 70;
  scores[2] = 80;
  scores[3] = (int) 80.3;  
  //scores = new int[] {90,60,80,30};
  //scores = {90,70,80,100} only in declaration statement
   // only in declartaion

  System.out.println("Midterm 1: " + scores[0]);
  System.out.println("Midterm 2: " + scores[1]);
  System.out.println("finel: " + scores[2]);
  System.out.println("project: " + scores[3]);
  System.out.println("# exams " + scores.length);
  /*
  // could aslo create array this way
  // should not specify the size of array
  System.out.println("_------------_");
  int[] scores2 = new int[] {90,(int) 71.333,80,80};
  System.out.println("Midterm 1: " + scores2[0]);
  System.out.println("Midterm 2: " + scores2[1]);
  System.out.println("finel: " + scores2[2]);
  System.out.println("project: " + scores2[3]);
  //this one is simpler
  System.out.println("-_______________-");
  int[] scores3 = {90, (int) 83.333, 40,80};
  System.out.println("Midterm 1: " + scores3[0]);
  System.out.println("Midterm 2: " + scores3[1]);
  System.out.println("finel: " + scores3[2]);
  System.out.println("project: " + scores3[3]);
  */

  Student[] students = new Student[3];
  students[0] = new Student();
  
  students[1] = new Student();
  students[2] = new Student();

  students[0].name = "John";
  students[1].name = "raj";
  students[2].name = "annita";

  System.out.println("Student 1: " + students[0].name);
  System.out.println("Student 2: " + students[1].name);
  System.out.println("Student 3: " + students[2].name);

  System.out.println("...........................");

  Student[] students2 = new Student[] {new Student(),new Student(),new Student()};
  System.out.println("Student2 1: " + students2[0]);
  System.out.println("Student2 2: " + students2[1]);
  System.out.println("Student2 3: " + students2[2]);

  System.out.println("...........................");

  Student[] students3 = {new Student(),new Student(),new Student()};
  System.out.println("Student3 1: " + students3[0]);
  System.out.println("Student3 2: " + students3[1]);
  System.out.println("Student3 3: " + students3[2]);
}

static void threeDimensionalArrays() {
  System.out.println("\nInside threeDimensionalArrays ...");
  int[][][] unitsSold = new int[][][]{ 
                    { // New York
                    {0,0,0,0}, // Jan
                    {0,0,0,0}, // Feb
                    {0,0,0,0}, // Mar
                    {0,850,0,0}// Apr	
                    },
                    { // San Francisco
                    {0,0,0,0}, // Jan
                    {0,0,0,0}, // Feb
                    {0,0,0,0}, // Mar
                    {0,0,0,0}  // Apr
                    },
                    { 
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
                    },
                    {
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0},
                    {0,0,0,0}
                    }
                  };
                        
 System.out.println("unitsSold[0][3][1]: " + unitsSold[0][3][1]);
}

static double sum(double x, double y) {
  //return (float)(x+y);
  return x+y;
}

static double avg(double x, double y) {
  double sum = sum(x,y);
  return sum/2;
}

static boolean search(int[] list, int key){
  return true;
}

static void go(int[] array) {
  System.out.println("array[0] " + array[0]);
  System.out.println("array[1] " + array[1]);
  array[1] = 22;
}

static void go(int i) {
  System.out.println("int i " + i);
}

static void go(short i) {
  System.out.println("short i " + i);
}
public static void main(String[] args){
  /*count = 25;
  if (count < 45) {
  
  }
  */
  /*
    print();
    int i = 6;
    int j = 2;
    System.out.println(i+j);
    System.out.println(i-j);
    System.out.println(i*j);
    System.out.println(i/j);
    System.out.println(i%j);
    
    primitives();
    System.out.println(1-0.9);
    System.out.println(0.1+0.2);
    // 0.1~0.000110001100110011 will be rounding error

    double price = 1000;
    double discountPercent = 0.9;
    double discountAmount = price*discountPercent;
    System.out.println(price - discountAmount);
    System.out.println(price * (1-discountPercent));

    BigDecimal first = new BigDecimal("0.1");
    BigDecimal second = new BigDecimal("0.2");
    System.out.println(first.add(second));
  
    typeCasting();
    arrays();
    */
    //threeDimensionalArrays();
  /*
  float d = (float) sum(3.0f,(float)2.0);
  System.out.println(d);
  double d2 = avg(3.0,2.0);
  System.out.println(d2);
  //int[] listed = {1,2};
  search(new int[]{1,2},2);*/
 int[] array = new int[]{1,2};
 go(array);
 System.out.println("array[1] " + array[1]);

 go(1000);

 byte b = 22;
 go(b);
  

  }
}