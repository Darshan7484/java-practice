public class Main {
    public static void main(String[] args) throws IllegalAccessException {

        User user1 = new User("Alice",   "alice@example.com");   // valid
        User user2 = new User("Bob",     "bob-invalid-email");   // invalid
        User user3 = new User("Charlie", "charlie@domain.org");  // valid
        User user4 = new User("Diana",   null);                  // null

        System.out.println("===== Email Validation Results =====\n");

        System.out.println("User: " + user1.getName());
        EmailValidator.validate(user1);

        System.out.println("\nUser: " + user2.getName());
        EmailValidator.validate(user2);

        System.out.println("\nUser: " + user3.getName());
        EmailValidator.validate(user3);

        System.out.println("\nUser: " + user4.getName());
        EmailValidator.validate(user4);

        System.out.println("\n=====================================");
    }
}
