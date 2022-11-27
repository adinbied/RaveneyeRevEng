package junit.framework;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Enumeration;
import java.util.Vector;

public class TestSuite
  implements Test
{
  private String fName;
  private Vector<Test> fTests = new Vector(10);
  
  public TestSuite() {}
  
  public TestSuite(Class<?> paramClass)
  {
    addTestsFromTestCase(paramClass);
  }
  
  public TestSuite(Class<? extends TestCase> paramClass, String paramString)
  {
    this(paramClass);
    setName(paramString);
  }
  
  public TestSuite(String paramString)
  {
    setName(paramString);
  }
  
  public TestSuite(Class<?>... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      addTest(testCaseForClass(paramVarArgs[i]));
      i += 1;
    }
  }
  
  public TestSuite(Class<? extends TestCase>[] paramArrayOfClass, String paramString)
  {
    this(paramArrayOfClass);
    setName(paramString);
  }
  
  /* Error */
  private void addTestMethod(Method arg1, java.util.List<String> arg2, Class<?> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void addTestsFromTestCase(Class<?> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static Test createTest(Class<?> paramClass, String paramString)
  {
    try
    {
      Object localObject = getTestConstructor(paramClass);
      try
      {
        if (((Constructor)localObject).getParameterTypes().length == 0)
        {
          localObject = ((Constructor)localObject).newInstance(new Object[0]);
          paramClass = (Class<?>)localObject;
          if ((localObject instanceof TestCase))
          {
            ((TestCase)localObject).setName(paramString);
            paramClass = (Class<?>)localObject;
          }
        }
        else
        {
          paramClass = ((Constructor)localObject).newInstance(new Object[] { paramString });
        }
        return (Test)paramClass;
      }
      catch (IllegalAccessException paramClass)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot access test case: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" (");
        ((StringBuilder)localObject).append(exceptionToString(paramClass));
        ((StringBuilder)localObject).append(")");
        return warning(((StringBuilder)localObject).toString());
      }
      catch (InvocationTargetException paramClass)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Exception in constructor: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" (");
        ((StringBuilder)localObject).append(exceptionToString(paramClass.getTargetException()));
        ((StringBuilder)localObject).append(")");
        return warning(((StringBuilder)localObject).toString());
      }
      catch (InstantiationException paramClass)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Cannot instantiate test case: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" (");
        ((StringBuilder)localObject).append(exceptionToString(paramClass));
        ((StringBuilder)localObject).append(")");
        return warning(((StringBuilder)localObject).toString());
      }
    }
    catch (NoSuchMethodException paramString)
    {
      for (;;) {}
    }
    paramString = new StringBuilder();
    paramString.append("Class ");
    paramString.append(paramClass.getName());
    paramString.append(" has no public constructor TestCase(String name) or TestCase()");
    return warning(paramString.toString());
  }
  
  private static String exceptionToString(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  public static Constructor<?> getTestConstructor(Class<?> paramClass)
    throws NoSuchMethodException
  {
    try
    {
      Constructor localConstructor = paramClass.getConstructor(new Class[] { String.class });
      return localConstructor;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      for (;;) {}
    }
    return paramClass.getConstructor(new Class[0]);
  }
  
  private boolean isPublicTestMethod(Method paramMethod)
  {
    return false;
  }
  
  private boolean isTestMethod(Method paramMethod)
  {
    return false;
  }
  
  private Test testCaseForClass(Class<?> paramClass)
  {
    return null;
  }
  
  public static Test warning(final String paramString)
  {
    new TestCase("warning")
    {
      protected void runTest()
      {
        fail(paramString);
      }
    };
  }
  
  public void addTest(Test paramTest)
  {
    this.fTests.add(paramTest);
  }
  
  /* Error */
  public void addTestSuite(Class<? extends TestCase> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int countTestCases()
  {
    return 0;
  }
  
  public String getName()
  {
    return this.fName;
  }
  
  /* Error */
  public void run(TestResult arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void runTest(Test paramTest, TestResult paramTestResult)
  {
    paramTest.run(paramTestResult);
  }
  
  public void setName(String paramString)
  {
    this.fName = paramString;
  }
  
  public Test testAt(int paramInt)
  {
    return null;
  }
  
  public int testCount()
  {
    return this.fTests.size();
  }
  
  public Enumeration<Test> tests()
  {
    return this.fTests.elements();
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\framework\TestSuite.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */