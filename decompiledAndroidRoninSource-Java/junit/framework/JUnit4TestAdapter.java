package junit.framework;

import java.util.List;
import org.junit.runner.Describable;
import org.junit.runner.Description;
import org.junit.runner.Request;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;

public class JUnit4TestAdapter
  implements Test, Filterable, Sortable, Describable
{
  private final JUnit4TestAdapterCache fCache;
  private final Class<?> fNewTestClass;
  private final Runner fRunner;
  
  public JUnit4TestAdapter(Class<?> paramClass)
  {
    this(paramClass, JUnit4TestAdapterCache.getDefault());
  }
  
  public JUnit4TestAdapter(Class<?> paramClass, JUnit4TestAdapterCache paramJUnit4TestAdapterCache)
  {
    this.fCache = paramJUnit4TestAdapterCache;
    this.fNewTestClass = paramClass;
    this.fRunner = Request.classWithoutSuiteMethod(paramClass).getRunner();
  }
  
  private boolean isIgnored(Description paramDescription)
  {
    return false;
  }
  
  private Description removeIgnored(Description paramDescription)
  {
    return null;
  }
  
  public int countTestCases()
  {
    return this.fRunner.testCount();
  }
  
  public void filter(Filter paramFilter)
    throws NoTestsRemainException
  {
    paramFilter.apply(this.fRunner);
  }
  
  public Description getDescription()
  {
    return null;
  }
  
  public Class<?> getTestClass()
  {
    return this.fNewTestClass;
  }
  
  public List<Test> getTests()
  {
    return null;
  }
  
  /* Error */
  public void run(TestResult arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void sort(Sorter paramSorter)
  {
    paramSorter.apply(this.fRunner);
  }
  
  public String toString()
  {
    return this.fNewTestClass.getName();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\junit\framework\JUnit4TestAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */