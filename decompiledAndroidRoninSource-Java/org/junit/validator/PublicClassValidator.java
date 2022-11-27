package org.junit.validator;

import java.util.Collections;
import java.util.List;
import org.junit.runners.model.TestClass;

public class PublicClassValidator
  implements TestClassValidator
{
  private static final List<Exception> NO_VALIDATION_ERRORS = ;
  
  public List<Exception> validateTestClass(TestClass paramTestClass)
  {
    if (paramTestClass.isPublic()) {
      return NO_VALIDATION_ERRORS;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The class ");
    localStringBuilder.append(paramTestClass.getName());
    localStringBuilder.append(" is not public.");
    return Collections.singletonList(new Exception(localStringBuilder.toString()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\validator\PublicClassValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */