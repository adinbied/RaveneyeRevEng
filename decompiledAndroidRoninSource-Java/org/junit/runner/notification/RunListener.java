package org.junit.runner.notification;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.runner.Description;
import org.junit.runner.Result;

public class RunListener
{
  public void testAssumptionFailure(Failure paramFailure) {}
  
  public void testFailure(Failure paramFailure)
    throws Exception
  {}
  
  public void testFinished(Description paramDescription)
    throws Exception
  {}
  
  public void testIgnored(Description paramDescription)
    throws Exception
  {}
  
  public void testRunFinished(Result paramResult)
    throws Exception
  {}
  
  public void testRunStarted(Description paramDescription)
    throws Exception
  {}
  
  public void testStarted(Description paramDescription)
    throws Exception
  {}
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface ThreadSafe {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\notification\RunListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */