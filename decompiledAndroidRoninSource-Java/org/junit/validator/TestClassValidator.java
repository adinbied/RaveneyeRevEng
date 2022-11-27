package org.junit.validator;

import java.util.List;
import org.junit.runners.model.TestClass;

public abstract interface TestClassValidator
{
  public abstract List<Exception> validateTestClass(TestClass paramTestClass);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\validator\TestClassValidator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */