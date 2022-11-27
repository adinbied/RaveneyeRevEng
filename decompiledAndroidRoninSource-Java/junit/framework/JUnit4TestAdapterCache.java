package junit.framework;

import java.util.HashMap;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

public class JUnit4TestAdapterCache
  extends HashMap<Description, Test>
{
  private static final JUnit4TestAdapterCache fInstance = new JUnit4TestAdapterCache();
  private static final long serialVersionUID = 1L;
  
  public static JUnit4TestAdapterCache getDefault()
  {
    return fInstance;
  }
  
  public Test asTest(Description paramDescription)
  {
    return null;
  }
  
  public List<Test> asTestList(Description paramDescription)
  {
    return null;
  }
  
  Test createTest(Description paramDescription)
  {
    return null;
  }
  
  public RunNotifier getNotifier(TestResult paramTestResult, JUnit4TestAdapter paramJUnit4TestAdapter)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\framework\JUnit4TestAdapterCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */