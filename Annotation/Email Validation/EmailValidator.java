import java.lang.reflect.Field;

public class EmailValidator {

    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        for (Field field : clazz.getDeclaredFields()) {
            if (field.isAnnotationPresent(ValidEmail.class)) {
                field.setAccessible(true);
                String value = (String) field.get(obj);
                ValidEmail annotation = field.getAnnotation(ValidEmail.class);

                if (value == null || !value.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$")) {
                    System.out.println("❌ Validation Failed  → " + field.getName() + " : \"" + value + "\" → " + annotation.message());
                } else {
                    System.out.println("✅ Validation Passed  → " + field.getName() + " : \"" + value + "\"");
                }
            }
        }
    }
}
