
import java.util.Scanner;


class Person {
    String name;
    double salary;

    void getData() {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter Salary: ");
        salary = sc.nextDouble();
        sc.close();
    }
}


class Employee extends Person {

    void display() {
        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + name);
        System.out.println("Salary: " + salary);
    }
}


public class Exampleinheritence {
    public static void main(String[] args) {

        Employee emp = new Employee(); 

        emp.getData();   
        emp.display();   
}
}