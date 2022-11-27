package org.junit.runner.notification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.junit.runner.Description;
import org.junit.runner.Result;

public class RunNotifier
{
  private final List<RunListener> listeners = new CopyOnWriteArrayList();
  private volatile boolean pleaseStop = false;
  
  private void fireTestFailures(List<RunListener> paramList, final List<Failure> paramList1)
  {
    if (!paramList1.isEmpty()) {
      new SafeNotifier(paramList, paramList1)
      {
        protected void notifyListener(RunListener paramAnonymousRunListener)
          throws Exception
        {
          Iterator localIterator = paramList1.iterator();
          while (localIterator.hasNext()) {
            paramAnonymousRunListener.testFailure((Failure)localIterator.next());
          }
        }
      }.run();
    }
  }
  
  public void addFirstListener(RunListener paramRunListener)
  {
    if (paramRunListener != null)
    {
      this.listeners.add(0, wrapIfNotThreadSafe(paramRunListener));
      return;
    }
    throw new NullPointerException("Cannot add a null listener");
  }
  
  public void addListener(RunListener paramRunListener)
  {
    if (paramRunListener != null)
    {
      this.listeners.add(wrapIfNotThreadSafe(paramRunListener));
      return;
    }
    throw new NullPointerException("Cannot add a null listener");
  }
  
  public void fireTestAssumptionFailed(final Failure paramFailure)
  {
    new SafeNotifier(paramFailure)
    {
      protected void notifyListener(RunListener paramAnonymousRunListener)
        throws Exception
      {
        paramAnonymousRunListener.testAssumptionFailure(paramFailure);
      }
    }.run();
  }
  
  public void fireTestFailure(Failure paramFailure)
  {
    fireTestFailures(this.listeners, Arrays.asList(new Failure[] { paramFailure }));
  }
  
  public void fireTestFinished(final Description paramDescription)
  {
    new SafeNotifier(paramDescription)
    {
      protected void notifyListener(RunListener paramAnonymousRunListener)
        throws Exception
      {
        paramAnonymousRunListener.testFinished(paramDescription);
      }
    }.run();
  }
  
  public void fireTestIgnored(final Description paramDescription)
  {
    new SafeNotifier(paramDescription)
    {
      protected void notifyListener(RunListener paramAnonymousRunListener)
        throws Exception
      {
        paramAnonymousRunListener.testIgnored(paramDescription);
      }
    }.run();
  }
  
  public void fireTestRunFinished(final Result paramResult)
  {
    new SafeNotifier(paramResult)
    {
      protected void notifyListener(RunListener paramAnonymousRunListener)
        throws Exception
      {
        paramAnonymousRunListener.testRunFinished(paramResult);
      }
    }.run();
  }
  
  public void fireTestRunStarted(final Description paramDescription)
  {
    new SafeNotifier(paramDescription)
    {
      protected void notifyListener(RunListener paramAnonymousRunListener)
        throws Exception
      {
        paramAnonymousRunListener.testRunStarted(paramDescription);
      }
    }.run();
  }
  
  public void fireTestStarted(final Description paramDescription)
    throws StoppedByUserException
  {
    if (!this.pleaseStop)
    {
      new SafeNotifier(paramDescription)
      {
        protected void notifyListener(RunListener paramAnonymousRunListener)
          throws Exception
        {
          paramAnonymousRunListener.testStarted(paramDescription);
        }
      }.run();
      return;
    }
    throw new StoppedByUserException();
  }
  
  public void pleaseStop()
  {
    this.pleaseStop = true;
  }
  
  public void removeListener(RunListener paramRunListener)
  {
    if (paramRunListener != null)
    {
      this.listeners.remove(wrapIfNotThreadSafe(paramRunListener));
      return;
    }
    throw new NullPointerException("Cannot remove a null listener");
  }
  
  RunListener wrapIfNotThreadSafe(RunListener paramRunListener)
  {
    if (paramRunListener.getClass().isAnnotationPresent(RunListener.ThreadSafe.class)) {
      return paramRunListener;
    }
    return new SynchronizedRunListener(paramRunListener, this);
  }
  
  private abstract class SafeNotifier
  {
    private final List<RunListener> currentListeners;
    
    SafeNotifier()
    {
      this(RunNotifier.this.listeners);
    }
    
    SafeNotifier()
    {
      List localList;
      this.currentListeners = localList;
    }
    
    protected abstract void notifyListener(RunListener paramRunListener)
      throws Exception;
    
    void run()
    {
      int i = this.currentListeners.size();
      ArrayList localArrayList1 = new ArrayList(i);
      ArrayList localArrayList2 = new ArrayList(i);
      Iterator localIterator = this.currentListeners.iterator();
      while (localIterator.hasNext())
      {
        RunListener localRunListener = (RunListener)localIterator.next();
        try
        {
          notifyListener(localRunListener);
          localArrayList1.add(localRunListener);
        }
        catch (Exception localException)
        {
          localArrayList2.add(new Failure(Description.TEST_MECHANISM, localException));
        }
      }
      RunNotifier.this.fireTestFailures(localArrayList1, localArrayList2);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\notification\RunNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */