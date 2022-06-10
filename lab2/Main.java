import java.util.*;

class Main {
  public static void main(String[] args) {
  Scanner myObj = new Scanner(System.in);
  System.out.print("Enter task # (1-5): ");
  String nextIntString = myObj.nextLine(); //get the number as a single line
  int task = Integer.parseInt(nextIntString); //convert the string to an int

    if(task == 1) {
      Task1 t1 = new Task1();
      t1.takeDate();
    } else if(task == 2) { 
      Task2 t2 = new Task2();
      t2.calculateNum();
    } else if(task == 3) {
      Task3 t3 = new Task3();
      t3.findNum();
    } else if(task == 4) {
      Task4 t4 = new Task4();
      t4.calculateNum();
    } else if(task == 5) {
      Task5 t5 = new Task5();
      t5.carsDisplay();
    }


    myObj.close();
  
    
  }
}