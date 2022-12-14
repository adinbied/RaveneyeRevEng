package org.junit.internal.runners.model;

import java.util.Iterator;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.MultipleFailureException;

public class EachTestNotifier
{
  private final Description description;
  private final RunNotifier notifier;
  
  public EachTestNotifier(RunNotifier paramRunNotifier, Description paramDescription)
  {
    this.notifier = paramRunNotifier;
    this.description = paramDescription;
  }
  
  private void addMultipleFailureException(MultipleFailureException paramMultipleFailureException)
  {
    paramMultipleFailureException = paramMultipleFailureException.getFailures().iterator();
    while (paramMultipleFailureException.hasNext()) {
      addFailure((Throwable)paramMultipleFailureException.next());
    }
  }
  
  public void addFailedAssumption(AssumptionViolatedException paramAssumptionViolatedException)
  {
    this.notifier.fireTestAssumptionFailed(new Failure(this.description, paramAssumptionViolatedException));
  }
  
  public void addFailure(Throwable paramThrowable)
  {
    if ((paramThrowable instanceof MultipleFailureException))
    {
      addMultipleFailureException((MultipleFailureException)paramThrowable);
      return;
    }
    this.notifier.fireTestFailure(new Failure(this.description, paramThrowable));
  }
  
  public void fireTestFinished()
  {
    this.notifier.fireTestFinished(this.description);
  }
  
  public void fireTestIgnored()
  {
    this.notifier.fireTestIgnored(this.description);
  }
  
  public void fireTestStarted()
  {
    this.notifier.fireTestStarted(this.description);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\runners\model\EachTestNotifier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */