import java.util.*;

class Task2 {
  public void calculateNum() {
  /*
  Enter 10 integer numbers. Calculate the sum of first 5 elements if they are positive   or product of last 5 element in the other case.   
  */
  Scanner myObj = new Scanner(System.in);
  System.out.print("Введите число 1: ");
  int number1 = myObj.nextInt();
  System.out.print("Введите число 2: ");
  int number2 = myObj.nextInt();
  System.out.print("Введите число 3: ");
  int number3 = myObj.nextInt();
  System.out.print("Введите число 4: ");
  int number4 = myObj.nextInt();
  System.out.print("Введите число 5: ");
  int number5 = myObj.nextInt();
  System.out.print("Введите число 6: ");
  int number6 = myObj.nextInt();
  System.out.print("Введите число 7: ");
  int number7 = myObj.nextInt();
  System.out.print("Введите число 8: ");
  int number8 = myObj.nextInt();
  System.out.print("Введите число 9: ");
  int number9 = myObj.nextInt();
  System.out.print("Введите число 10: ");
  int number10 = myObj.nextInt();

  int sumOfFirstFive = number1 + number2 + number3 + number4 + number5;

  if(sumOfFirstFive >= 0) {
    System.out.print("Число позитивное!");
  } else {
    int productOfLastFive = number6 * number7 * number8 * number9 * number10;
    System.out.print("Произведение последних 5 чисел: " + productOfLastFive);
  }
    
  }
}