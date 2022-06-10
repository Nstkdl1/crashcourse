import java.util.*;

class Task3 {
  public void findNum() {
  /*
    .Enter 5 integer numbers. Find
    •position of second positive number;
    •minimum and its position in the array.  
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
    

  int numbers[] = {number1, number2, number3, number4, number5};
  int positiveCounter = 0;
  int curMin = numbers[0];
  int curPosition = 0;
  Boolean foundItem = false;
    
    // finding position
    for(int i = 0; i < numbers.length; i++) {
      if(numbers[i] > 0) {
        positiveCounter++;
        if(positiveCounter == 2) {
          System.out.print("Позиция второго положительного элемента: " + i + "\n");
          foundItem = true;
        } 
      }
    }

    if(foundItem == false) {
      System.out.print("Позиция второго положительного элемента не найдена!\n");
    }

    // finding min element
    for(int i = 1; i < numbers.length; i++) {
      if(numbers[i] < curMin) {
        curMin = numbers[i];
        curPosition = i;
      }
    }
    System.out.print("Минимальный элемент: " + curMin + ", позиция: " + curPosition);
    

    
  }
}