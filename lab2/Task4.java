import java.util.*;

class Task4 {
  public void calculateNum() {
  /*
  Organize entering integers until the first negative number. Count the product of all entered even numbers.  
  */
  Scanner myObj = new Scanner(System.in);
  int []numbers=new int[1000];
  int curNumber = 0;
  int i = 0;
  int evenNumbers = 1;

  while(curNumber >= 0) {
    System.out.print("Enter num: ");
    curNumber = myObj.nextInt();
    if(curNumber > 0) {
      numbers[i] = curNumber;
      i++;
    }
  }

  for(int j = 0; j < i; j++) {
    if(numbers[j] %2 == 0) {
      evenNumbers = evenNumbers * numbers[j];
    }
  }
  System.out.print("Product of all entered even numbers: " + evenNumbers);
    
    
  }
}