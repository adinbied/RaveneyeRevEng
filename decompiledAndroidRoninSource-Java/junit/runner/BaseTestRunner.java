package junit.runner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Properties;
import junit.framework.Test;
import junit.framework.TestListener;

public abstract class BaseTestRunner
  implements TestListener
{
  public static final String SUITE_METHODNAME = "suite";
  private static Properties fPreferences;
  static boolean fgFilterStack = true;
  static int fgMaxMessageLength = getPreference("maxmessage", 500);
  boolean fLoading = true;
  
  static boolean filterLine(String paramString)
  {
    int i = 0;
    while (i < 8)
    {
      if (paramString.indexOf(new String[] { "junit.framework.TestCase", "junit.framework.TestResult", "junit.framework.TestSuite", "junit.framework.Assert.", "junit.swingui.TestRunner", "junit.awtui.TestRunner", "junit.textui.TestRunner", "java.lang.reflect.Method.invoke(" }[i]) > 0) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static String getFilteredTrace(String paramString)
  {
    if (showStackRaw()) {
      return paramString;
    }
    StringWriter localStringWriter = new StringWriter();
    PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
    BufferedReader localBufferedReader = new BufferedReader(new StringReader(paramString));
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        if (!filterLine(str)) {
          localPrintWriter.println(str);
        }
      }
      return localStringWriter.toString();
    }
    catch (Exception localException) {}
    return paramString;
  }
  
  public static String getFilteredTrace(Throwable paramThrowable)
  {
    StringWriter localStringWriter = new StringWriter();
    paramThrowable.printStackTrace(new PrintWriter(localStringWriter));
    return getFilteredTrace(localStringWriter.toString());
  }
  
  public static int getPreference(String paramString, int paramInt)
  {
    paramString = getPreference(paramString);
    if (paramString == null) {
      return paramInt;
    }
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (NumberFormatException paramString) {}
    return paramInt;
  }
  
  public static String getPreference(String paramString)
  {
    return getPreferences().getProperty(paramString);
  }
  
  protected static Properties getPreferences()
  {
    if (fPreferences == null)
    {
      Properties localProperties = new Properties();
      fPreferences = localProperties;
      localProperties.put("loading", "true");
      fPreferences.put("filterstack", "true");
      readPreferences();
    }
    return fPreferences;
  }
  
  private static File getPreferencesFile()
  {
    return new File(System.getProperty("user.home"), "junit.properties");
  }
  
  /* Error */
  private static void readPreferences()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_1
    //   2: new 158	java/io/FileInputStream
    //   5: dup
    //   6: invokestatic 160	junit/runner/BaseTestRunner:getPreferencesFile	()Ljava/io/File;
    //   9: invokespecial 163	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   12: astore_0
    //   13: new 121	java/util/Properties
    //   16: dup
    //   17: invokestatic 119	junit/runner/BaseTestRunner:getPreferences	()Ljava/util/Properties;
    //   20: invokespecial 166	java/util/Properties:<init>	(Ljava/util/Properties;)V
    //   23: invokestatic 169	junit/runner/BaseTestRunner:setPreferences	(Ljava/util/Properties;)V
    //   26: invokestatic 119	junit/runner/BaseTestRunner:getPreferences	()Ljava/util/Properties;
    //   29: aload_0
    //   30: invokevirtual 173	java/util/Properties:load	(Ljava/io/InputStream;)V
    //   33: aload_0
    //   34: invokevirtual 178	java/io/InputStream:close	()V
    //   37: return
    //   38: astore_1
    //   39: goto +9 -> 48
    //   42: goto +16 -> 58
    //   45: astore_1
    //   46: aconst_null
    //   47: astore_0
    //   48: aload_0
    //   49: ifnull +7 -> 56
    //   52: aload_0
    //   53: invokevirtual 178	java/io/InputStream:close	()V
    //   56: aload_1
    //   57: athrow
    //   58: aload_0
    //   59: ifnull +7 -> 66
    //   62: aload_0
    //   63: invokevirtual 178	java/io/InputStream:close	()V
    //   66: return
    //   67: astore_0
    //   68: aload_1
    //   69: astore_0
    //   70: goto -12 -> 58
    //   73: astore_1
    //   74: goto -32 -> 42
    //   77: astore_0
    //   78: return
    //   79: astore_0
    //   80: goto -24 -> 56
    // Local variable table:
    //   start	length	slot	name	signature
    //   12	51	0	localFileInputStream	java.io.FileInputStream
    //   67	1	0	localIOException1	IOException
    //   69	1	0	localObject1	Object
    //   77	1	0	localIOException2	IOException
    //   79	1	0	localIOException3	IOException
    //   1	1	1	localObject2	Object
    //   38	1	1	localObject3	Object
    //   45	24	1	localObject4	Object
    //   73	1	1	localIOException4	IOException
    // Exception table:
    //   from	to	target	type
    //   13	33	38	finally
    //   2	13	45	finally
    //   2	13	67	java/io/IOException
    //   13	33	73	java/io/IOException
    //   33	37	77	java/io/IOException
    //   62	66	77	java/io/IOException
    //   52	56	79	java/io/IOException
  }
  
  public static void savePreferences()
    throws IOException
  {
    FileOutputStream localFileOutputStream = new FileOutputStream(getPreferencesFile());
    try
    {
      getPreferences().store(localFileOutputStream, "");
      return;
    }
    finally
    {
      localFileOutputStream.close();
    }
  }
  
  public static void setPreference(String paramString1, String paramString2)
  {
    getPreferences().put(paramString1, paramString2);
  }
  
  protected static void setPreferences(Properties paramProperties)
  {
    fPreferences = paramProperties;
  }
  
  protected static boolean showStackRaw()
  {
    return (!getPreference("filterstack").equals("true")) || (!fgFilterStack);
  }
  
  public static String truncate(String paramString)
  {
    Object localObject = paramString;
    if (fgMaxMessageLength != -1)
    {
      localObject = paramString;
      if (paramString.length() > fgMaxMessageLength)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString.substring(0, fgMaxMessageLength));
        ((StringBuilder)localObject).append("...");
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    return (String)localObject;
  }
  
  /* Error */
  public void addError(Test arg1, Throwable arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addFailure(Test arg1, junit.framework.AssertionFailedError arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  protected void clearStatus() {}
  
  public String elapsedTimeAsString(long paramLong)
  {
    return null;
  }
  
  public void endTest(Test paramTest)
  {
    try
    {
      testEnded(paramTest.toString());
      return;
    }
    finally
    {
      paramTest = finally;
      throw paramTest;
    }
  }
  
  public String extractClassName(String paramString)
  {
    return null;
  }
  
  public Test getTest(String paramString)
  {
    return null;
  }
  
  protected Class<?> loadSuiteClass(String paramString)
    throws ClassNotFoundException
  {
    return Class.forName(paramString);
  }
  
  protected String processArguments(String[] paramArrayOfString)
  {
    return null;
  }
  
  protected abstract void runFailed(String paramString);
  
  public void setLoading(boolean paramBoolean)
  {
    this.fLoading = paramBoolean;
  }
  
  public void startTest(Test paramTest)
  {
    try
    {
      testStarted(paramTest.toString());
      return;
    }
    finally
    {
      paramTest = finally;
      throw paramTest;
    }
  }
  
  public abstract void testEnded(String paramString);
  
  public abstract void testFailed(int paramInt, Test paramTest, Throwable paramThrowable);
  
  public abstract void testStarted(String paramString);
  
  protected boolean useReloadingTestSuiteLoader()
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\runner\BaseTestRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */