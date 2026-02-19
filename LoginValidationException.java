import java.util.Scanner;

// Custom Exception class
class InvalidLoginException extends Exception {
    public InvalidLoginException(String message) {
        super(message);
    }
}

public class LoginValidationException {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter username: ");
            String username = sc.nextLine();

            System.out.print("Enter password: ");
            String password = sc.nextLine();

            // Check login
            if (!username.equals("admin") || !password.equals("1234")) {
                throw new InvalidLoginException("Invalid Username or Password!");
            }

            System.out.println("Login Successful");

        } catch (InvalidLoginException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}

