import java.lang.reflect.Field;

public class EmployeeValidator {

    private static final String RESET  = "\u001B[0m";
    private static final String GREEN  = "\u001B[32m";
    private static final String RED    = "\u001B[31m";
    private static final String YELLOW = "\u001B[33m";
    private static final String CYAN   = "\u001B[36m";

    public static boolean validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();
        boolean allValid = true;

        System.out.println(CYAN + "  Field          Value                  Status" + RESET);
        System.out.println("  " + "-".repeat(60));

        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true);
            Object value = field.get(obj);
            String fieldName = String.format("%-15s", field.getName());

            // --- @ValidName ---
            if (field.isAnnotationPresent(ValidName.class)) {
                ValidName ann = field.getAnnotation(ValidName.class);
                String val = (String) value;
                boolean ok = val != null && val.matches("^[a-zA-Z ]{2,}$");
                printResult(fieldName, String.valueOf(val), ok, ann.message());
                if (!ok) allValid = false;
            }

            // --- @ValidEmail ---
            else if (field.isAnnotationPresent(ValidEmail.class)) {
                ValidEmail ann = field.getAnnotation(ValidEmail.class);
                String val = (String) value;
                boolean ok = val != null && val.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");
                printResult(fieldName, String.valueOf(val), ok, ann.message());
                if (!ok) allValid = false;
            }

            // --- @ValidPhone ---
            else if (field.isAnnotationPresent(ValidPhone.class)) {
                ValidPhone ann = field.getAnnotation(ValidPhone.class);
                String val = (String) value;
                boolean ok = val != null && val.matches("^[0-9]{10}$");
                printResult(fieldName, String.valueOf(val), ok, ann.message());
                if (!ok) allValid = false;
            }

            // --- @ValidAge ---
            else if (field.isAnnotationPresent(ValidAge.class)) {
                ValidAge ann = field.getAnnotation(ValidAge.class);
                int val = (int) value;
                boolean ok = val >= ann.min() && val <= ann.max();
                printResult(fieldName, String.valueOf(val), ok, ann.message());
                if (!ok) allValid = false;
            }

            // --- @ValidSalary ---
            else if (field.isAnnotationPresent(ValidSalary.class)) {
                ValidSalary ann = field.getAnnotation(ValidSalary.class);
                double val = (double) value;
                boolean ok = val >= ann.min();
                printResult(fieldName, String.valueOf(val), ok, ann.message());
                if (!ok) allValid = false;
            }
        }

        System.out.println("  " + "-".repeat(60));
        if (allValid) {
            System.out.println(GREEN + "  ✅ Employee is VALID" + RESET);
        } else {
            System.out.println(RED + "  ❌ Employee has INVALID fields" + RESET);
        }
        return allValid;
    }

    private static void printResult(String field, String value, boolean ok, String message) {
        String status = ok
            ? GREEN  + "✅ Valid" + RESET
            : RED    + "❌ " + message + RESET;
        String displayValue = String.format("%-22s", value);
        System.out.println("  " + YELLOW + field + RESET + " " + displayValue + " " + status);
    }
}
