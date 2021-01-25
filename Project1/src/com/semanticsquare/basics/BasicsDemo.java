package com.semanticsquare.basics;

public class BasicsDemo {
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

  public void foo(){
    System.out.println("Wassup foo");
  }

  static void stringExamples(){
    System.out.println("\nInside string Examples...");
    String s = "hello world!";
    System.out.println("length " +s.length());
    System.out.println("is empty" +s.isEmpty());
    System.out.println("equals(HelloWorld)" +s.equals("HELLO WORLD"));
    System.out.println("equalsignorecase(HelloWorld)" +s.equalsIgnoreCase("HELLO WORLD"));
    System.out.println("compareto(HelloWorld)" +s.compareTo("zELLO WORLD")); //
  
    //searching
    //Examing individual characters
    System.out.println("s.contains(HELLO WORLD)" + s.contains("HELLO WORLD"));
    System.out.println("s.contains(world!)" + s.contains("world!"));
    System.out.println("s.startswithd(HELLO WORLD!)" + s.startsWith("HELLO WORLD!"));
    System.out.println("s.starts withd (hello world!)" + s.startsWith("hello world!"));
    System.out.println("s.endswith (!)" + s.endsWith("!"));
    System.out.println("s.indexOf(\"lo\")" + s.indexOf("lo"));
    System.out.println("s.indexOf(\"o\")" + s.indexOf("o"));
    System.out.println("s.lastindexof(\"o\")" + s.lastIndexOf('o'));
    
    System.out.println("s.chartAt(4) + " + s.charAt(4));
    System.out.println("s.substring(4) + " + s.substring(4));
    System.out.println("s.substring(4,9) + " + s.substring(4,9));
    

    System.out.println("s.toUppercase(4) + " + s.toUpperCase());
    System.out.println("s.toLowercase(4) + " + s.toLowerCase());

    System.out.println("s.trim() + " + s.trim());

    System.out.println("s.replace(\"o\",\"r\")" + s.replace("o", "r"));

    System.out.println("s.split(\"o\":");
    String[] sa = s.split("o");
    for (String temp: sa) {
      System.out.println(temp);
    }

    System.out.println("String.valueOf(1.3): " + String.valueOf(1.3));
  }

  static void stringPool() {
    System.out.println("Inside strigPool...");
    String s1 = "hello!";
    String s2 = "hello!";
    String s3 = "hello!".intern(); //double interning
    String s4 = new String("hello!"); 
    String s5 = "lo!"; //if you add final, then the s5 is known at compile time

    System.out.println("s1 == s2: " + (s1 == s2)); //true
    System.out.println("s1 == s3: " + (s1 == s3)); //true
    System.out.println("s1 == s4: " + (s1 == s4)); //false
    System.out.println("s1 == s4.intern() : " + (s1 == s4.intern())); //true
    System.out.println("s1 == \"hel\" + \"lo\" " +(s1 == "hel"+"lo!") ); //true
    System.out.println("s1 == \"hel\" + s: " + (s1 == "hel" + s5)); //false

  }


  //rutatic
public static void main(String[] args) { 
  //labeledContinue();
  //new BasicsDemo().foo();
  //stringExamples();
  stringPool();
  }       
}