package org.junit.validator;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Inherited
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidateWith
{
  Class<? extends AnnotationValidator> value();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\validator\ValidateWith.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */