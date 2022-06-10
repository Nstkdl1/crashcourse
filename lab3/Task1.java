import java.util.*;

class Task1 {
  public void takeSentance() {
    Scanner myObj = new Scanner(System.in);
    System.out.print("Введите предложение из 5 слов: ");
    String sentance = myObj.nextLine(); 

    String words[] = sentance.split(" ");
    String maxWord = "";
    int curMax = 0;
    
    for(int i = 0 ; i < words.length; i++) {
      if(words[i].length() > curMax) {
        curMax = words[i].length();
        maxWord = words[i];
      }
    }

    System.out.print("Самое длинное слово: " + maxWord + "\n");
    System.out.print("Количество букв: " + curMax + "\n");
    String reverse = new     StringBuffer(words[1]).reverse().toString();
    System.out.print("Второе слово reversed: " + reverse + "\n");
    myObj.close();
  }
}