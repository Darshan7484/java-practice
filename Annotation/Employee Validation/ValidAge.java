import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidAge {
    int min() default 18;
    int max() default 60;
    String message() default "Age must be between 18 and 60";
}
