package com.google.firebase.encoders.annotations;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface ExtraProperty
{
  Class<?>[] allowedTypes() default {};
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\encoders\annotations\ExtraProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */