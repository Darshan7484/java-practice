import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidName {
    String message() default "Name must contain only letters and spaces (min 2 chars)";
}
