package org.junit.runners;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.internal.runners.rules.RuleMemberValidator;
import org.junit.internal.runners.statements.RunAfters;
import org.junit.internal.runners.statements.RunBefores;
import org.junit.rules.RunRules;
import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.Filterable;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.manipulation.Sortable;
import org.junit.runner.manipulation.Sorter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.RunnerScheduler;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;
import org.junit.validator.AnnotationsValidator;
import org.junit.validator.PublicClassValidator;
import org.junit.validator.TestClassValidator;

public abstract class ParentRunner<T>
  extends Runner
  implements Filterable, Sortable
{
  private static final List<TestClassValidator> VALIDATORS = Arrays.asList(new TestClassValidator[] { new AnnotationsValidator(), new PublicClassValidator() });
  private final Object childrenLock = new Object();
  private volatile Collection<T> filteredChildren = null;
  private volatile RunnerScheduler scheduler = new RunnerScheduler()
  {
    public void finished() {}
    
    public void schedule(Runnable paramAnonymousRunnable)
    {
      paramAnonymousRunnable.run();
    }
  };
  private final TestClass testClass = createTestClass(paramClass);
  
  protected ParentRunner(Class<?> paramClass)
    throws InitializationError
  {
    validate();
  }
  
  private void applyValidators(List<Throwable> paramList)
  {
    if (getTestClass().getJavaClass() != null)
    {
      Iterator localIterator = VALIDATORS.iterator();
      while (localIterator.hasNext()) {
        paramList.addAll(((TestClassValidator)localIterator.next()).validateTestClass(getTestClass()));
      }
    }
  }
  
  private boolean areAllChildrenIgnored()
  {
    Iterator localIterator = getFilteredChildren().iterator();
    while (localIterator.hasNext()) {
      if (!isIgnored(localIterator.next())) {
        return false;
      }
    }
    return true;
  }
  
  private Comparator<? super T> comparator(final Sorter paramSorter)
  {
    new Comparator()
    {
      public int compare(T paramAnonymousT1, T paramAnonymousT2)
      {
        return paramSorter.compare(ParentRunner.this.describeChild(paramAnonymousT1), ParentRunner.this.describeChild(paramAnonymousT2));
      }
    };
  }
  
  private Collection<T> getFilteredChildren()
  {
    if (this.filteredChildren == null) {
      synchronized (this.childrenLock)
      {
        if (this.filteredChildren == null) {
          this.filteredChildren = Collections.unmodifiableCollection(getChildren());
        }
      }
    }
    return this.filteredChildren;
  }
  
  private void runChildren(final RunNotifier paramRunNotifier)
  {
    RunnerScheduler localRunnerScheduler = this.scheduler;
    try
    {
      Iterator localIterator = getFilteredChildren().iterator();
      while (localIterator.hasNext()) {
        localRunnerScheduler.schedule(new Runnable()
        {
          public void run()
          {
            ParentRunner.this.runChild(this.val$each, paramRunNotifier);
          }
        });
      }
      return;
    }
    finally
    {
      localRunnerScheduler.finished();
    }
  }
  
  private boolean shouldRun(Filter paramFilter, T paramT)
  {
    return paramFilter.shouldRun(describeChild(paramT));
  }
  
  private void validate()
    throws InitializationError
  {
    ArrayList localArrayList = new ArrayList();
    collectInitializationErrors(localArrayList);
    if (localArrayList.isEmpty()) {
      return;
    }
    throw new InitializationError(localArrayList);
  }
  
  private void validateClassRules(List<Throwable> paramList)
  {
    RuleMemberValidator.CLASS_RULE_VALIDATOR.validate(getTestClass(), paramList);
    RuleMemberValidator.CLASS_RULE_METHOD_VALIDATOR.validate(getTestClass(), paramList);
  }
  
  private Statement withClassRules(Statement paramStatement)
  {
    List localList = classRules();
    if (localList.isEmpty()) {
      return paramStatement;
    }
    return new RunRules(paramStatement, localList, getDescription());
  }
  
  protected Statement childrenInvoker(final RunNotifier paramRunNotifier)
  {
    new Statement()
    {
      public void evaluate()
      {
        ParentRunner.this.runChildren(paramRunNotifier);
      }
    };
  }
  
  protected Statement classBlock(RunNotifier paramRunNotifier)
  {
    Statement localStatement = childrenInvoker(paramRunNotifier);
    paramRunNotifier = localStatement;
    if (!areAllChildrenIgnored()) {
      paramRunNotifier = withClassRules(withAfterClasses(withBeforeClasses(localStatement)));
    }
    return paramRunNotifier;
  }
  
  protected List<TestRule> classRules()
  {
    List localList = this.testClass.getAnnotatedMethodValues(null, ClassRule.class, TestRule.class);
    localList.addAll(this.testClass.getAnnotatedFieldValues(null, ClassRule.class, TestRule.class));
    return localList;
  }
  
  protected void collectInitializationErrors(List<Throwable> paramList)
  {
    validatePublicVoidNoArgMethods(BeforeClass.class, true, paramList);
    validatePublicVoidNoArgMethods(AfterClass.class, true, paramList);
    validateClassRules(paramList);
    applyValidators(paramList);
  }
  
  protected TestClass createTestClass(Class<?> paramClass)
  {
    return new TestClass(paramClass);
  }
  
  protected abstract Description describeChild(T paramT);
  
  public void filter(Filter paramFilter)
    throws NoTestsRemainException
  {
    synchronized (this.childrenLock)
    {
      ArrayList localArrayList = new ArrayList(getFilteredChildren());
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = localIterator.next();
        boolean bool = shouldRun(paramFilter, localObject2);
        if (bool) {}
        try
        {
          paramFilter.apply(localObject2);
        }
        catch (NoTestsRemainException localNoTestsRemainException)
        {
          for (;;) {}
        }
        localIterator.remove();
        continue;
        localIterator.remove();
      }
      this.filteredChildren = Collections.unmodifiableCollection(localArrayList);
      if (!this.filteredChildren.isEmpty()) {
        return;
      }
      throw new NoTestsRemainException();
    }
  }
  
  protected abstract List<T> getChildren();
  
  public Description getDescription()
  {
    Description localDescription = Description.createSuiteDescription(getName(), getRunnerAnnotations());
    Iterator localIterator = getFilteredChildren().iterator();
    while (localIterator.hasNext()) {
      localDescription.addChild(describeChild(localIterator.next()));
    }
    return localDescription;
  }
  
  protected String getName()
  {
    return this.testClass.getName();
  }
  
  protected Annotation[] getRunnerAnnotations()
  {
    return this.testClass.getAnnotations();
  }
  
  public final TestClass getTestClass()
  {
    return this.testClass;
  }
  
  protected boolean isIgnored(T paramT)
  {
    return false;
  }
  
  /* Error */
  public void run(RunNotifier paramRunNotifier)
  {
    // Byte code:
    //   0: new 304	org/junit/internal/runners/model/EachTestNotifier
    //   3: dup
    //   4: aload_1
    //   5: aload_0
    //   6: invokevirtual 209	org/junit/runners/ParentRunner:getDescription	()Lorg/junit/runner/Description;
    //   9: invokespecial 307	org/junit/internal/runners/model/EachTestNotifier:<init>	(Lorg/junit/runner/notification/RunNotifier;Lorg/junit/runner/Description;)V
    //   12: astore_2
    //   13: aload_0
    //   14: aload_1
    //   15: invokevirtual 309	org/junit/runners/ParentRunner:classBlock	(Lorg/junit/runner/notification/RunNotifier;)Lorg/junit/runners/model/Statement;
    //   18: invokevirtual 314	org/junit/runners/model/Statement:evaluate	()V
    //   21: return
    //   22: astore_1
    //   23: aload_2
    //   24: aload_1
    //   25: invokevirtual 318	org/junit/internal/runners/model/EachTestNotifier:addFailure	(Ljava/lang/Throwable;)V
    //   28: return
    //   29: astore_1
    //   30: aload_1
    //   31: athrow
    //   32: astore_1
    //   33: aload_2
    //   34: aload_1
    //   35: invokevirtual 322	org/junit/internal/runners/model/EachTestNotifier:addFailedAssumption	(Lorg/junit/internal/AssumptionViolatedException;)V
    //   38: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	this	ParentRunner
    //   0	39	1	paramRunNotifier	RunNotifier
    //   12	22	2	localEachTestNotifier	org.junit.internal.runners.model.EachTestNotifier
    // Exception table:
    //   from	to	target	type
    //   13	21	22	finally
    //   13	21	29	org/junit/runner/notification/StoppedByUserException
    //   13	21	32	org/junit/internal/AssumptionViolatedException
  }
  
  protected abstract void runChild(T paramT, RunNotifier paramRunNotifier);
  
  /* Error */
  protected final void runLeaf(Statement paramStatement, Description paramDescription, RunNotifier paramRunNotifier)
  {
    // Byte code:
    //   0: new 304	org/junit/internal/runners/model/EachTestNotifier
    //   3: dup
    //   4: aload_3
    //   5: aload_2
    //   6: invokespecial 307	org/junit/internal/runners/model/EachTestNotifier:<init>	(Lorg/junit/runner/notification/RunNotifier;Lorg/junit/runner/Description;)V
    //   9: astore_2
    //   10: aload_2
    //   11: invokevirtual 329	org/junit/internal/runners/model/EachTestNotifier:fireTestStarted	()V
    //   14: aload_1
    //   15: invokevirtual 314	org/junit/runners/model/Statement:evaluate	()V
    //   18: aload_2
    //   19: invokevirtual 332	org/junit/internal/runners/model/EachTestNotifier:fireTestFinished	()V
    //   22: return
    //   23: astore_1
    //   24: aload_2
    //   25: aload_1
    //   26: invokevirtual 318	org/junit/internal/runners/model/EachTestNotifier:addFailure	(Ljava/lang/Throwable;)V
    //   29: goto -11 -> 18
    //   32: astore_1
    //   33: aload_2
    //   34: aload_1
    //   35: invokevirtual 322	org/junit/internal/runners/model/EachTestNotifier:addFailedAssumption	(Lorg/junit/internal/AssumptionViolatedException;)V
    //   38: goto -20 -> 18
    //   41: astore_1
    //   42: aload_2
    //   43: invokevirtual 332	org/junit/internal/runners/model/EachTestNotifier:fireTestFinished	()V
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	ParentRunner
    //   0	48	1	paramStatement	Statement
    //   0	48	2	paramDescription	Description
    //   0	48	3	paramRunNotifier	RunNotifier
    // Exception table:
    //   from	to	target	type
    //   14	18	23	finally
    //   14	18	32	org/junit/internal/AssumptionViolatedException
    //   24	29	41	finally
    //   33	38	41	finally
  }
  
  public void setScheduler(RunnerScheduler paramRunnerScheduler)
  {
    this.scheduler = paramRunnerScheduler;
  }
  
  public void sort(Sorter paramSorter)
  {
    synchronized (this.childrenLock)
    {
      Object localObject2 = getFilteredChildren().iterator();
      while (((Iterator)localObject2).hasNext()) {
        paramSorter.apply(((Iterator)localObject2).next());
      }
      localObject2 = new ArrayList(getFilteredChildren());
      Collections.sort((List)localObject2, comparator(paramSorter));
      this.filteredChildren = Collections.unmodifiableCollection((Collection)localObject2);
      return;
    }
  }
  
  protected void validatePublicVoidNoArgMethods(Class<? extends Annotation> paramClass, boolean paramBoolean, List<Throwable> paramList)
  {
    paramClass = getTestClass().getAnnotatedMethods(paramClass).iterator();
    while (paramClass.hasNext()) {
      ((FrameworkMethod)paramClass.next()).validatePublicVoidNoArg(paramBoolean, paramList);
    }
  }
  
  protected Statement withAfterClasses(Statement paramStatement)
  {
    List localList = this.testClass.getAnnotatedMethods(AfterClass.class);
    if (localList.isEmpty()) {
      return paramStatement;
    }
    return new RunAfters(paramStatement, localList, null);
  }
  
  protected Statement withBeforeClasses(Statement paramStatement)
  {
    List localList = this.testClass.getAnnotatedMethods(BeforeClass.class);
    if (localList.isEmpty()) {
      return paramStatement;
    }
    return new RunBefores(paramStatement, localList, null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\ParentRunner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */