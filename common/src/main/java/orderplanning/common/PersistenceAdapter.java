package orderplanning.common;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Application core uses dedicated interfaces called “ports” to communicate with the outside world.
 * They allow the entry or exiting of data to and from the application.
 * <p>
 * An output port is used by the application core to reach things outside
 * (like getting some data from a database). Persistence Adapter is an implementation of output port.
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface PersistenceAdapter {

    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     *
     * @return the suggested component name, if any (or empty String otherwise)
     */
    @AliasFor(annotation = Component.class)
    String value() default "";

}
