package org.junit.validator;

import java.util.Collections;
import java.util.List;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public abstract class AnnotationValidator
{
  private static final List<Exception> NO_VALIDATION_ERRORS = ;
  
  public List<Exception> validateAnnotatedClass(TestClass paramTestClass)
  {
    return NO_VALIDATION_ERRORS;
  }
  
  public List<Exception> validateAnnotatedField(FrameworkField paramFrameworkField)
  {
    return NO_VALIDATION_ERRORS;
  }
  
  public List<Exception> validateAnnotatedMethod(FrameworkMethod paramFrameworkMethod)
  {
    return NO_VALIDATION_ERRORS;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\validator\AnnotationValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */