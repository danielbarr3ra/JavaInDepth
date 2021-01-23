import javax.sound.midi.MidiDeviceTransmitter;

public class Recursion {
  static int factorialNR(int n){
    if ( n == 0 || n ==1 ) {
      return 1;
    }
    int factorial = n;

    while ( n >= 2){
      factorial *= (n-1);
      n--;
    }

    return factorial;
  }

  static int factorialR(int n){
    if (n > 1){
      return factorialR(n-1)*n;
    }
    return 1;
  }

  static int binarySearch(int[] array, int lower, int higher, int key){
    if (lower == higher){
      if ( key == array[lower]){
        return lower;
      } else {
        return -1;
      }
    }

    int mid = (lower + higher) / 2;
    if (key == array[mid]){
      return mid;
    } else if (key > array[mid]){
      return binarySearch(array, mid + 1, higher, key);
    } else {
      return binarySearch(array, lower, mid - 1 , key);
    }
  }

 
  public static void main(String[] args) {
    /*for(int i = 0; i < 12; i++){
      System.out.println("factorial of " + i + " " + factorialNR(i));
    }

    for(int i = 0; i < 12; i++){
      System.out.println("Recursvie factorial of " + i + " " + factorialR(i));
    }
  }
  */
  int [] array =  new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16};
  System.out.println(binarySearch(array, 0, 13, 100));
  }
}