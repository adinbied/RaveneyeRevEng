package org.junit.runner.notification;

import org.junit.runner.Description;
import org.junit.runner.Result;

@RunListener.ThreadSafe
final class SynchronizedRunListener
  extends RunListener
{
  private final RunListener listener;
  private final Object monitor;
  
  SynchronizedRunListener(RunListener paramRunListener, Object paramObject)
  {
    this.listener = paramRunListener;
    this.monitor = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof SynchronizedRunListener)) {
      return false;
    }
    paramObject = (SynchronizedRunListener)paramObject;
    return this.listener.equals(((SynchronizedRunListener)paramObject).listener);
  }
  
  public int hashCode()
  {
    return this.listener.hashCode();
  }
  
  public void testAssumptionFailure(Failure paramFailure)
  {
    synchronized (this.monitor)
    {
      this.listener.testAssumptionFailure(paramFailure);
      return;
    }
  }
  
  public void testFailure(Failure paramFailure)
    throws Exception
  {
    synchronized (this.monitor)
    {
      this.listener.testFailure(paramFailure);
      return;
    }
  }
  
  public void testFinished(Description paramDescription)
    throws Exception
  {
    synchronized (this.monitor)
    {
      this.listener.testFinished(paramDescription);
      return;
    }
  }
  
  public void testIgnored(Description paramDescription)
    throws Exception
  {
    synchronized (this.monitor)
    {
      this.listener.testIgnored(paramDescription);
      return;
    }
  }
  
  public void testRunFinished(Result paramResult)
    throws Exception
  {
    synchronized (this.monitor)
    {
      this.listener.testRunFinished(paramResult);
      return;
    }
  }
  
  public void testRunStarted(Description paramDescription)
    throws Exception
  {
    synchronized (this.monitor)
    {
      this.listener.testRunStarted(paramDescription);
      return;
    }
  }
  
  public void testStarted(Description paramDescription)
    throws Exception
  {
    synchronized (this.monitor)
    {
      this.listener.testStarted(paramDescription);
      return;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.listener.toString());
    localStringBuilder.append(" (with synchronization wrapper)");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\notification\SynchronizedRunListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */