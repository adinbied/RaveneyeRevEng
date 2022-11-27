package org.intellij.lang.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER, java.lang.annotation.ElementType.LOCAL_VARIABLE, java.lang.annotation.ElementType.ANNOTATION_TYPE, java.lang.annotation.ElementType.METHOD})
public @interface MagicConstant
{
  long[] flags() default {};
  
  Class flagsFromClass() default void.class;
  
  long[] intValues() default {};
  
  String[] stringValues() default {};
  
  Class valuesFromClass() default void.class;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\intellij\lang\annotations\MagicConstant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */