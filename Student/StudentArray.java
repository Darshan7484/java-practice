import java.util.*;

public class StudentArray {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String[] names = new String[5];
        int[] marks = new int[5];

        try {

            for(int i=0;i<5;i++){

                System.out.print("Enter student name: ");
                names[i] = sc.nextLine();

                System.out.print("Enter marks: ");
                marks[i] = sc.nextInt();
                sc.nextLine();

                if(marks[i] < 0 || marks[i] > 100)
                    throw new Exception("Marks must be 0-100");
            }

            System.out.println("\n--- Student Result ---");

            for(int i=0;i<5;i++){

                String grade;

                if(marks[i]>=90) grade="A";
                else if(marks[i]>=75) grade="B";
                else if(marks[i]>=50) grade="C";
                else grade="Fail";

                System.out.println(names[i]+"  "+marks[i]+"  Grade:"+grade);
            }

        } catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }

        sc.close();
    }
}