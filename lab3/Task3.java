import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Task3 {
  public void findDollars() {

  Scanner myObj = new Scanner(System.in);
  System.out.print("Введите предложение: ");
  String sentance = myObj.nextLine();

  Pattern pattern = Pattern.compile("\\$\\d+\\.\\d\\d");
  Matcher matcher = pattern.matcher(sentance);

    // Find all matches
    while (matcher.find()) {
      String match = matcher.group();
      System.out.print("US currency: "+ match + "\n"); 
    }
  }
}