import java.util.*;

class Task2 {
  public void removeWhiteSpace() {
    Scanner myObj = new Scanner(System.in);
    System.out.print("Введите предложение с большим количеством пробелов: ");
    
    String sentance = myObj.nextLine(); 
    String removeSpaces = sentance.replaceAll("\\s+", " ");
    System.out.println(removeSpaces);
    myObj.close();
  }
}