import java.util.*;

class Car {
  private int yearOfProd;
  private double engineCapacity;

  public Car() {
    this.yearOfProd = 2002;
    this.engineCapacity = 200.0;
  }

  public Car(int year, double engCap) {
    this.yearOfProd = year;
    this.engineCapacity = engCap;
  }

  public int getYear() {
    return this.yearOfProd;
  }

  public double getCapacity() {
    return this.engineCapacity;
  }

  public void getInfo() {
    System.out.print("Year of production: " + this.yearOfProd + "\n");
    System.out.print("Engine capacity: " + this.engineCapacity + "\n");
  }
  
}

class Task5 {
  public void carsDisplay() {
  /*
Create class Car with fields type, year of production and engine capacity. Create and initialize four instances of class Car. Display cars
•certain model year  (enter year in the console);
•ordered by the field year.  
  */
  Car c1 = new Car();
  Car c2 = new Car(2010, 400.0);
  Car c3 = new Car(2010, 320.0);
  Car c4 = new Car(2022, 800.0);

  Boolean found = false;

  Car[] cars = new Car[4];
  cars[0] = c1;
  cars[1] = c2;
  cars[2] = c3;
  cars[3] = c4;

  Scanner myObj = new Scanner(System.in);
  System.out.print("Enter year of production: ");
  int year = myObj.nextInt();

  for(int i = 0; i < 4; i++) {
    if(cars[i].getYear() == year) {
      cars[i].getInfo();
      found = true;
    }
  }

  if(found == false) {
    System.out.print("No models produced in " + year);
  }

  myObj.close();
  
  }
}