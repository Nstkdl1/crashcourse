import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class localTests {

    static Student s1;
    static Task1 t1;

    @BeforeAll
    static void setup() {
        s1 = new Student();
    }

    @Test
    void testFindBestStudent() throws MissingElementException {
        int[] grades1 = new int[]{10, 40, 34, 78};
        Student p1 = new Student("Litvinov", "Pavel", "Evgenyevich", 21, 2, grades1);

        int[] grades2 = new int[]{70, 40, 54, 18};
        Student p2 = new Student("Kaidalov", "Sergey", "Sanich", 41, 3, grades2);

        int[] grades3 = new int[]{100, 90, 99, 97};
        Student p3 = new Student("Mashchenko", "Nikita", "Alexandrovich", 20, 2, grades3);

        //use dollar amounts from the file at a constant rate of 7%
        assertEquals("MashchenkoNikitaAlexandrovich", s1.getBetterStudentByAverage(p1, p2, p3).getFullName(), "wrong value");
    }

    @Test
    void findIfStudentExcellent() {
        int[] grades1 = new int[]{10, 40, 34, 78};
        Student p1 = new Student("Litvinov", "Pavel", "Evgenyevich", 21, 2, grades1);

        assertEquals(false, p1.isExcelentStudent(), "wrong value");
    }

    @Test
    void findIfStudentExcellent2() {
        int[] grades1 = new int[]{100, 95, 100, 94};
        Student p1 = new Student("Litvinov", "Pavel", "Evgenyevich", 21, 2, grades1);

        //save $20,000 yearly at 7% for 10 years
        assertEquals(true, p1.isExcelentStudent(), "wrong value");
    }

    @Test
    void getBetterStudent() {
        int[] grades1 = new int[]{10, 40, 34, 78};
        Student p1 = new Student("Litvinov", "Pavel", "Evgenyevich", 21, 2, grades1);

        int[] grades2 = new int[]{70, 40, 54, 18};
        Student p2 = new Student("Kaidalov", "Sergey", "Sanich", 41, 3, grades2);

        int[] grades3 = new int[]{100, 90, 99, 97};
        Student p3 = new Student("Mashchenko", "Nikita", "Alexandrovich", 20, 2, grades3);

        //save $1000 yearly at 5% for 5 years
        Student best = Student.getBetterStudentByAverage(p1, p2, p3);
        assertEquals(p3.getGrades(), best.getGrades(), "wrong value");
    }

    @Test
    void getAvgTest() {

        int[] grades2 = new int[]{70, 40, 54, 18};
        Student p2 = new Student("Kaidalov", "Sergey", "Sanich", 41, 3, grades2);

        int avg = p2.getMarksAverage();
        //future value of $20,000 over 10 years at 7%
        assertEquals(45, avg, "wrong value");
    }

    @Test
    void isAdultTest() {

        int[] grades2 = new int[]{70, 40, 54, 18};
        Student p2 = new Student("Kaidalov", "Sergey", "Sanich", 41, 3, grades2);
        assertEquals(true, Student.isAdult(p2), "wrong value");
    }

    @Test
    void isAdultTest1() {

        int[] grades2 = new int[]{70, 40, 54, 18};
        Student p2 = new Student("Kaidalov", "Sergey", "Sanich", 12, 3, grades2);
        assertEquals(false, Student.isAdult(p2), "wrong value");
    }

}