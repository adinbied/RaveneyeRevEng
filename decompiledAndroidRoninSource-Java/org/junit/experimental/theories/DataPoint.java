package org.junit.experimental.theories;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.METHOD})
public @interface DataPoint
{
  Class<? extends Throwable>[] ignoredExceptions() default {};
  
  String[] value() default {};
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\theories\DataPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */