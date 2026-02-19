import java.util.Scanner;

public class StudentGradeRuntime {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = new String[5];
        int[] marks = new int[5];

        
        for(int i=0;i<5;i++) {
            System.out.print("Enter student name: ");
            names[i] = sc.next();

            System.out.print("Enter marks: ");
            marks[i] = sc.nextInt();
        }

        System.out.println("\nStudent Details:");

       
        for(int i=0;i<5;i++) {

            char grade;

            if(marks[i] >= 80)
                grade = 'A';
            else if(marks[i] >= 60)
                grade = 'B';
            else if(marks[i] >= 35)
                grade = 'C';
            else
                grade = 'F';

            System.out.println(
                "Name: " + names[i] +
                "  Marks: " + marks[i] +
                "  Grade: " + grade
            );
        }

        sc.close();
    }
}
