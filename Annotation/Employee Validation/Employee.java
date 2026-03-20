public class Employee {

    @ValidName
    private String name;

    @ValidEmail
    private String email;

    @ValidPhone
    private String phone;

    @ValidAge(min = 18, max = 60)
    private int age;

    @ValidSalary(min = 10000)
    private double salary;

    public Employee(String name, String email, String phone, int age, double salary) {
        this.name   = name;
        this.email  = email;
        this.phone  = phone;
        this.age    = age;
        this.salary = salary;
    }

    public String getName() { return name; }
}
