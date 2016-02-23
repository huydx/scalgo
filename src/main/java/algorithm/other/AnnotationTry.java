package algorithm.other;

import java.lang.annotation.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTry {
    @Mutable(version = 2)
    public Integer prop1;

    public void testProp1() {
        System.out.println(Arrays.toString(AnnotationTry.class.getDeclaredAnnotations()));
    }

    public static void main(String[] args) {
        new AnnotationTry().testProp1();

        Class clazz = AnnotationTry.class;
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method: methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            for (Annotation annotation : annotations) {
                if (annotation.annotationType().equals(CallMe.class)) {
                    try {
                        method.invoke(null);
                    } catch (IllegalAccessException | InvocationTargetException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @CallMe
    static void test1() {
        System.out.println("test1");
    }
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CallMe {
}

@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.FIELD)
@interface Mutable {
    int version() default 1;
}

