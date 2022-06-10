import java.util.*;

class Task1 {
  public void takeDate() {
    Boolean flag = false;
    int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    Scanner myObj = new Scanner(System.in);
    System.out.print("Введите номер месяца (0 - январь, 11 - декабрь): ");
    String number = myObj.nextLine();
    int month = Integer.valueOf(number);
    while(flag == false) {
      if(month < 0 || month > 11) {
        System.out.print("Неверный ввод! Введите номер от 0 до 11: ");
       number = myObj.nextLine();
       month = Integer.valueOf(number);
      } else {
        flag = true;
      }
    }
    System.out.print("В этом месяце: " + days[month] + " дней!");
    myObj.close();
  }
}