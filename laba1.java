class Person {
  private String name;
  private int birthYear;
  
  public Person() {
    name = "Sanya";
    birthYear = 2002;
  }

  public Person(String givenName, int givenBirthYear) {
    this.name = givenName;
    this.birthYear = givenBirthYear;
  }

  public String getName() {
    return name;
  }

  public int getBirthYear() {
    return birthYear;
  }

  public void changeName(String newName) {
    this.name = newName;
  }

  public int age() {
    int personAge = 2022 - this.birthYear;
    return personAge;
  }

  public void input(String inputName, int inputBirthYear) {
    this.name = inputName;
    this.birthYear = inputBirthYear;
  }

  public void output() {
    System.out.println("Имя: " + this.getName());
    System.out.println("Год рождения: " + this.getBirthYear() + "\n");
  }
}

class Main {
  public static void main(String[] args) {
    // 1
    Person j = new Person();  
    System.out.println(j.getName());
    j.changeName("Nikitos");
    j.output();
    System.out.println("Возраст: " + j.age() + "\n");

    // 2
    Person je = new Person("Vasya", 2001);
    je.output();
    System.out.println("Возраст: " + je.age() + "\n");

    // 3
    Person jez = new Person();
    jez.input("Anton", 2000);
    jez.output();
    System.out.println("Возраст: " + jez.age() + "\n");

    //4
    Person jeze = new Person("Gavrila", 2004);
    jeze.output();
    jeze.changeName("Arkadii");
    jeze.output();
    System.out.println("Возраст: " + jeze.age() + "\n");

    //5
    Person jezeh = new Person("Pavel", 2001);
    jezeh.output();
    jezeh.input("Georgii", 1995);
    jezeh.output();
    System.out.println("Возраст: " + jezeh.age() + "\n");
    
  }
}