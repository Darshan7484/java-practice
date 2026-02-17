public class StudentGrade {
    public static void main(String[] args) {

        // Store names
        String[] names = {"Rahul","Anita","Kiran","Meena","Arjun"};

        // Store marks
        int[] marks = {85, 72, 90, 60, 45};

        // Loop to display details
        for(int i=0;i<names.length;i++) {

            char grade;

            if(marks[i] >= 80)
                grade = 'A';
            else if(marks[i] >= 60)
                grade = 'B';
            else if(marks[i] >= 50)
                grade = 'C';
            else
                grade = 'F';

            System.out.println(
                "Name: " + names[i] +
                "  Marks: " + marks[i] +
                "  Grade: " + grade
            );
        }
    }
}
