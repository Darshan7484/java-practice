public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        Employee[] employees = {
            new Employee("Alice Johnson", "alice@company.com",  "9876543210", 30, 55000.0),  // All valid
            new Employee("Bob",           "bob-invalid",        "98765",      17, 8000.0),   // All invalid
            new Employee("Charlie Davis", "charlie@domain.org", "9123456780", 65, 75000.0),  // Age invalid
            new Employee("D1ana",         "diana@corp.com",     "9000000001", 28, 12000.0),  // Name invalid
        };

        System.out.println("\n╔══════════════════════════════════════════════════════════════╗");
        System.out.println(  "║           Employee Details Validator                         ║");
        System.out.println(  "╚══════════════════════════════════════════════════════════════╝\n");

        for (Employee emp : employees) {
            System.out.println("  Employee : " + emp.getName());
            EmployeeValidator.validate(emp);
            System.out.println();
        }
    }
}
