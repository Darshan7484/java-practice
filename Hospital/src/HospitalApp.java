import java.sql.*;
import java.util.Scanner;

public class HospitalApp {

    static final String url = "jdbc:mysql://localhost:3306/hospital_db?useSSL=false&serverTimezone=UTC";
    static final String user = "root";
    static final String password = "YOUR_PASSWORD"; // change this

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        try (Connection con = DriverManager.getConnection(url, user, password)) {

            while (true) {

                System.out.println("\n===== HOSPITAL MENU =====");
                System.out.println("1. Add Patient");
                System.out.println("2. Add Phone Number");
                System.out.println("3. Add Address");
                System.out.println("4. View Patients");
                System.out.println("5. Exit");
                System.out.print("Choose option: ");

                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1:
                        addPatient(con);
                        break;

                    case 2:
                        addPhone(con);
                        break;

                    case 3:
                        addAddress(con);
                        break;

                    case 4:
                        viewPatients(con);
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice!");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 1️⃣ Add Patient
    static void addPatient(Connection con) throws SQLException {

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        String query = "INSERT INTO Patient(name, age, gender) VALUES (?, ?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setString(1, name);
        ps.setInt(2, age);
        ps.setString(3, gender);

        ps.executeUpdate();
        System.out.println("Patient Added Successfully!");
    }

    // 2️⃣ Add Phone
    static void addPhone(Connection con) throws SQLException {

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Phone Number: ");
        String phone = sc.nextLine();

        String query = "INSERT INTO Patient_Phone(patient_id, phone) VALUES (?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, patientId);
        ps.setString(2, phone);

        ps.executeUpdate();
        System.out.println("Phone Added Successfully!");
    }

    // 3️⃣ Add Address
    static void addAddress(Connection con) throws SQLException {

        System.out.print("Enter Patient ID: ");
        int patientId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        String query = "INSERT INTO Patient_Address(patient_id, address) VALUES (?, ?)";

        PreparedStatement ps = con.prepareStatement(query);
        ps.setInt(1, patientId);
        ps.setString(2, address);

        ps.executeUpdate();
        System.out.println("Address Added Successfully!");
    }

    // 4️⃣ View Patients
    static void viewPatients(Connection con) throws SQLException {

        String query = "SELECT * FROM Patient";
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        System.out.println("\n--- Patient List ---");

        while (rs.next()) {
            System.out.println(
                    rs.getInt("patient_id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("age") + " | " +
                    rs.getString("gender")
            );
        }
    }
}