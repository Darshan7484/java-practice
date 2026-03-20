import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidSalary {
    double min() default 10000.0;
    String message() default "Salary must be a positive number and at least 10,000";
}
