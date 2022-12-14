package org.junit.runner;

import java.io.PrintStream;
import junit.framework.Test;
import junit.runner.Version;
import org.junit.internal.JUnitSystem;
import org.junit.internal.RealSystem;
import org.junit.internal.TextListener;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.notification.RunListener;
import org.junit.runner.notification.RunNotifier;

public class JUnitCore
{
  private final RunNotifier notifier = new RunNotifier();
  
  static Computer defaultComputer()
  {
    return new Computer();
  }
  
  public static void main(String... paramVarArgs)
  {
    System.exit(new JUnitCore().runMain(new RealSystem(), paramVarArgs).wasSuccessful() ^ true);
  }
  
  public static Result runClasses(Computer paramComputer, Class<?>... paramVarArgs)
  {
    return new JUnitCore().run(paramComputer, paramVarArgs);
  }
  
  public static Result runClasses(Class<?>... paramVarArgs)
  {
    return runClasses(defaultComputer(), paramVarArgs);
  }
  
  public void addListener(RunListener paramRunListener)
  {
    this.notifier.addListener(paramRunListener);
  }
  
  public String getVersion()
  {
    return Version.id();
  }
  
  public void removeListener(RunListener paramRunListener)
  {
    this.notifier.removeListener(paramRunListener);
  }
  
  public Result run(Test paramTest)
  {
    return run(new JUnit38ClassRunner(paramTest));
  }
  
  public Result run(Computer paramComputer, Class<?>... paramVarArgs)
  {
    return run(Request.classes(paramComputer, paramVarArgs));
  }
  
  public Result run(Request paramRequest)
  {
    return run(paramRequest.getRunner());
  }
  
  public Result run(Runner paramRunner)
  {
    Result localResult = new Result();
    RunListener localRunListener = localResult.createListener();
    this.notifier.addFirstListener(localRunListener);
    try
    {
      this.notifier.fireTestRunStarted(paramRunner.getDescription());
      paramRunner.run(this.notifier);
      this.notifier.fireTestRunFinished(localResult);
      return localResult;
    }
    finally
    {
      removeListener(localRunListener);
    }
  }
  
  public Result run(Class<?>... paramVarArgs)
  {
    return run(defaultComputer(), paramVarArgs);
  }
  
  Result runMain(JUnitSystem paramJUnitSystem, String... paramVarArgs)
  {
    PrintStream localPrintStream = paramJUnitSystem.out();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("JUnit version ");
    localStringBuilder.append(Version.id());
    localPrintStream.println(localStringBuilder.toString());
    paramVarArgs = JUnitCommandLineParseResult.parse(paramVarArgs);
    addListener(new TextListener(paramJUnitSystem));
    return run(paramVarArgs.createRequest(defaultComputer()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\JUnitCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */