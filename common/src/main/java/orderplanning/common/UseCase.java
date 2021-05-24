package orderplanning.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Application core uses dedicated interfaces called “ports” to communicate with the outside world.
 * They allow the entry or exiting of data to and from the application.
 * <p>
 * Input ports (Use cases) are the abstract definition of what the user would like to do in application.
 * Just like the domain objects, use cases are also a part of the application core
 * and do not have any dependency on the other components.
 * All the business logic, validations are happening in the use of case classes.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UseCase {

    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     *
     * @return the suggested component name, if any (or empty String otherwise)
     */
    @AliasFor(annotation = Component.class)
    String value() default "";

}
