package org.junit.runners.parameterized;

import org.junit.runner.Runner;
import org.junit.runners.model.InitializationError;

public abstract interface ParametersRunnerFactory
{
  public abstract Runner createRunnerForTestWithParameters(TestWithParameters paramTestWithParameters)
    throws InitializationError;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\parameterized\ParametersRunnerFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */