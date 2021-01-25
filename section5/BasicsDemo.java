package JavaInDepth.section5.basics;
import java.util.Date;
import java.util.ArrayList;

class BasicsDemo {
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
  System.out.println("\n\nInside primitives ..."); 
  // literals demo
  int intHex = 0x0041;
  System.out.println("intHex: " + intHex);
  int intBinary = 0b01000001;
  System.out.println("intBinary: " + intBinary);
  int intChar = 'A'; // holds decimal equivalent, which is 65
  System.out.println("intChar: " + intChar);
  int intUnderscore = 1_23_456;
  System.out.println("intUnderscore: " + intUnderscore);
  
  char charA = 'A';
  System.out.println("charA: " + charA);
  char charInt = 65;
  System.out.println("charInt: " + charInt);
  char charUnicode1 = '\u0041'; // 4 * (16 power 1 )+ 1 * (16 power 0)
  System.out.println("charUnicode1: " + charUnicode1);
  char charUnicode2 = 0x41;     // 4 * (16 power 1 )+ 1 * (16 power 0)
  System.out.println("charUnicode2: " + charUnicode2);
  char charBinary = 0b01000001; // binary corresponding to decimal 65
  System.out.println("charBinary: " + charBinary);	  		  	  
  }

  static void typeCasting() {
    System.out.println("\nInside typeCasting ...");
    // Explicit casting
    long y = 42;
    //int x = y;
    int x = (int)y;
    
    // Information loss due to out-of-range assignment
    byte narrowdByte = (byte)123456;
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

static void arrays() {
   System.out.println("\nInside arrays ...");
   int[] myArray = new int[]{9, 11, 2, 5, 4, 4, 6};
     System.out.println("myArray.length: " + myArray.length);
   System.out.println("myArray[1]: " + myArray[1]);
   System.out.println("myArray[7]: " + myArray[7]);	   
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

static void varargsOverload(boolean b, int i, int j, int k){
   System.out.println("\nInside varargsOverload without varargs ...");
}
static void varargsOverload(boolean b, int... list){
   System.out.println("\nInside varargsOverload with varargs ...");
   System.out.println("list.length: " + list.length);
}	

  
static void preAndPost() {
  System.out.println("\n Inside Pre and post");
  int x = 5;
  /*
  int y = x--;
  System.out.println("y: " + y + ", x: " + x );
  */
  int index = 0;
  int[] array = new int[3];
  array[index++] = 10;
  array[index++] = 20;
  array[index++] = 30;
  System.out.println(index);
}


static void compoundArithmeticAssignment() {
  int x = 100;
  System.out.println(" x += 5: " + (x+=5));
  System.out.println(" x -= 5: " + (x-=5));
  System.out.println(" x *= 5: " + (x*=5));
  System.out.println(" x /= 5: " + (x/=5));
  System.out.println(" x %= 5: " + (x%=5));

  //invalid
  System.out.println("x=+5: " + (x =+5 ));
  System.out.println("x=-5: " + (x =+5 ));
  /*
  System.out.println("x=/5: " + (x =/5 ));
  System.out.println("x=*5: " + (x =*5 ));
  System.out.println("x=%5: " + (x =%5 ));
  */

}

static void isOddOrEven(int i){
  System.out.println((i%2 == 2)?0:1);
}

static void charTypePromotion() {
  System.out.println("\nInside charTypePromotion ...");
  char char1 = 50; // utf16 value 2;
  System.out.println("char1: " + char1);
  System.out.println("(73 - char 1) " + (73-char1)); //char promoted  to int
  System.out.println("char1 - '3': " + (char1 - '3'));// 
  System.out.println("('a' + 'b'): " + ('a' +'b')); // a b are promoted to ints
  //97 and 98 are added
}

static void comparasionOperators(){
    int age = 20;
    /*if (age >21) {
      System.out.println("Graduate student");
    }*/
    System.out.println("age > 21: " + (age > 21));
    System.out.println("age >= 21: " + (age >= 21));
    System.out.println("age < 21: " + (age < 21));
    System.out.println("age <= 21: " + (age <= 21));
    System.out.println("age == 21: " + (age == 21));
    System.out.println("age != 21: " + (age != 21));

    boolean isInternational = true;
    //System.out.println("isInternational <= true: " + (isInternational <= 21));
    System.out.println("isInternational == true: " + (isInternational == true));
    System.out.println("isInternational != true: " + (isInternational != true));

    Student s1 = new Student(1000, "Dheeru");
    Student s2 = new Student(1000, "Dheeru");
    System.out.println("s1 == s2: " + (s1 == s2));
    System.out.println("s1 != s2: " + (s1 != s2));
    
    update(s1, "John");
  }

  static boolean update(Student s, String name ) {
    if (s != null && s.id > 1000){
      s.name = name;
    }
    return true;
  }

  static void logicalOperators() {
    System.out.println("\nInside logical Operaotrs ...");
    int age = 37;
    int salary = 95_000;
    boolean hasBadCredit = false;
    
    if ((age <= 35) && (salary > (90_00*10)) || (!hasBadCredit)){
      System.out.println("Loan approved");
    } else {
      System.out.println("Loan is not approved");
    }

    Student s1 = new Student(1001, "Raj");
    update(s1, "Dheeru");
  }
  /*
  static void bitwiseOperators(){
    int x = 1;
    int y = 3;

    System.out.println("X & y " + (x & y));
    System.out.println("X | y " + (x | y));
    System.out.println("X ^ y " + (x ^ y));
    System.out.println("~x " + (~x));
    System.out.println("true & false " + (true & false));
    //System.out.ptinln("X & y " + (x & y));

    char c1 = 'a'; // 61
    char c2 = 'b'; // 63
    System.out.println("c1 | c2 " + (c1 | c2));
  }
  */

  static boolean ifStatement(){
    boolean approved = false;
    int age = 88;
    int salary = 80000;
    boolean hasBadCredit = false;

    if ( age >= 25 && age <= 35 && salary >= 50000 ) {
      //approved = true;
      System.out.println(" age >= 25 && age <= 35 && salary >= 50000");
      return true;
    } else if ( age > 35  && age <= 45 && salary >= 70000) {
      System.out.println("age > 35  && age <= 45 && salary >= 70000 else if block");
      return true;
    } else if ( age > 45  && age <= 55 && salary >= 90000) {
      System.out.println(" age > 45  && age <= 55 && salary >= 90000 else if block");
      return true;
    } else {
      if (age > 55 && !hasBadCredit ) {
        approved = true;
        System.out.println("age > 55 && !hasBadCredit");
        return true;
      }
      //");
      return false;
    }

  }

  static void switchStatement(){
    System.out.println("\n Inside swithcExample...");
    //int month = 3;
    //Integer month = new Integer(3);
    byte month = 3;
    final byte month2 = 2;
    switch (month) {
      case 1: System.out.println("January");
              break;
      case 2: System.out.println("February");
              break;
      case 3: System.out.println("March");
              break;
      default: System.out.println("April");
    }
  }

  static void isTerneary(){
    int x = 1;
    int y = 2;
    int min = (x<y)?(x):(y);
    System.out.println("this is the min " + min);
  }

  static int min (int x, int y) {
    //int result = (x<y)? x: y;
    return (x<y)? x: y;
  }

  static void labeledBreak() {
    System.out.println("\nInside labeledBreak ..");
    int num = 0;
    outermost: for (int i = 0; i < 10; i++){
      for (int j = 0; j < 10; j++){
        if (i == 5 && j ==5){
          break outermost;
        }
        num ++;
      }
    }
    System.out.println("num: " + num);
  }

  static void labeledContinue(){
    System.out.println("\nInside labeled continue ..");
    int num = 0;
    outermost: for (int i = 0; i < 10; i++){
      for (int j = 0; j < 10; j++){
        if (i == 5 && j ==5){
          continue outermost;
        }
        num ++;
      }
    }
    System.out.println("num: " + num);
  }


  //rutatic
public static void main(String[] args) {
  Date date = new Date();
  ArrayList list;
  java.sql.Date date2;
  System.out.println("hey");
  }       
}