import java.util.*;

class MissingElementException extends Exception {
    public MissingElementException(String errorMessage) {
        super(errorMessage);
    }
}

class Person {
    private String surname;
    private String name;
    private String fatherName;
    private int age;

    public Person() {
        this.surname = "Кайдалова";
        this.name = "Анастасия";
        this.fatherName = "Романовна";
        this.age = 19;
    }

    public Person(String surname, String name, String fatherName, int age) {
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.age = age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public String getFullName() throws MissingElementException{
        if(this.surname == "" || this.name == "" || this.fatherName == ""){
            throw new MissingElementException("One parameter missing");
        } else {
            String FIO = this.surname + this.name + this.fatherName;
            return FIO;
        }
    }

    public int getAge() {
        return this.age;
    }

    public static Boolean isAdult(Person p) {
        if(p.getAge() >= 18) {
            return true;
        } else {
            return false;
        }
    }

}

class Student extends Person {
    private int group;
    private int[] grades;

    public Student() {
        this.setSurname("Кайдалова");
        this.setName("Анастасия");
        this.setFatherName("Романовна");
        this.setAge(20);
        this.group = 2;
        this.grades = new int[] {10, 20, 40, 60};
    }

    public Student(String surname, String name, String fatherName, int age, int group, int[] grades) {
        this.setSurname(surname);
        this.setName(name);
        this.setFatherName(fatherName);
        this.setAge(age);
        this.group = group;
        this.grades = grades;
    }

    public int getGroup() {
        return this.group;
    }

    public int[] getGrades() {
        return this.grades;
    }

    public int setGroup() {
        return this.group;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public void setGroup(int group) {
        this.group = group;
    }



    public int getMarksAverage() {
        int totalSum = 0;
        for(int i = 0; i < this.grades.length; i++) {
            totalSum += this.grades[i];
        }

        totalSum = totalSum/this.grades.length;

        return totalSum;
    }

    public Boolean isExcelentStudent() {
        if(getMarksAverage() >= 90) {
            return true;
        } else {
            return false;
        }

    }

    public static Student getBetterStudentByAverage(Student student1, Student student2, Student student3) {
        Student students[] = {student1, student2, student3};

        int grades1 = student1.getMarksAverage();
        int grades2 = student2.getMarksAverage();
        int grades3 = student3.getMarksAverage();

        int localMax = 0;
        int localIndex = 0;

        int finalGrades[] = {grades1, grades2, grades3};
        for(int j = 0; j < finalGrades.length; j++) {
            if(finalGrades[j] > localMax) {
                localMax = finalGrades[j];
                localIndex = j;
            }
        }

        return students[localIndex];
    }
}

class Task1 {
    public void takeSentance() {
        int[] grades1 = new int[]{10, 40, 34, 78};
        Student p1 = new Student("Litvinov", "Pavel", "Evgenyevich", 21, 2, grades1);

        int[] grades2 = new int[]{70, 40, 54, 18};
        Student p2 = new Student("Kaidalov", "Sergey", "Sanich", 41, 3, grades2);

        int[] grades3 = new int[]{100, 90, 99, 97};
        Student p3 = new Student("Mashchenko", "Nikita", "Alexandrovich", 20, 2, grades3);
        try{
            System.out.print(p1.getFullName());

            Student.getBetterStudentByAverage(p1, p2, p3);

        } catch(MissingElementException ex) {
            System.out.println("Caught the exception");

            // printing the message from InvalidAgeException object
            System.out.println("Exception occured: " + ex);
        }
    }
}