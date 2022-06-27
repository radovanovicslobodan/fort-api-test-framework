package fort_blueprint.core.customby;

import org.openqa.selenium.By;
import org.openqa.selenium.support.AbstractFindByBuilder;
import org.openqa.selenium.support.PageFactoryFinder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@PageFactoryFinder(FindByTestId.FindByCustomBuilder.class)

public @interface FindByTestId {

    String value();

    public static class FindByCustomBuilder extends AbstractFindByBuilder {
        public By buildIt(Object annotation, Field field) {
            FindByTestId findBy = (FindByTestId) annotation;
            return CustomBy.testId(findBy.value());
        }

    }
}
