package org.junit.experimental.theories;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.internal.Assignments;
import org.junit.experimental.theories.internal.ParameterizedAssertionError;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.runners.model.TestClass;

public class Theories
  extends BlockJUnit4ClassRunner
{
  public Theories(Class<?> paramClass)
    throws InitializationError
  {
    super(paramClass);
  }
  
  private void validateDataPointFields(List<Throwable> paramList)
  {
    Field[] arrayOfField = getTestClass().getJavaClass().getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    while (i < j)
    {
      Field localField = arrayOfField[i];
      if ((localField.getAnnotation(DataPoint.class) != null) || (localField.getAnnotation(DataPoints.class) != null))
      {
        StringBuilder localStringBuilder;
        if (!Modifier.isStatic(localField.getModifiers()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DataPoint field ");
          localStringBuilder.append(localField.getName());
          localStringBuilder.append(" must be static");
          paramList.add(new Error(localStringBuilder.toString()));
        }
        if (!Modifier.isPublic(localField.getModifiers()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DataPoint field ");
          localStringBuilder.append(localField.getName());
          localStringBuilder.append(" must be public");
          paramList.add(new Error(localStringBuilder.toString()));
        }
      }
      i += 1;
    }
  }
  
  private void validateDataPointMethods(List<Throwable> paramList)
  {
    Method[] arrayOfMethod = getTestClass().getJavaClass().getDeclaredMethods();
    int j = arrayOfMethod.length;
    int i = 0;
    while (i < j)
    {
      Method localMethod = arrayOfMethod[i];
      if ((localMethod.getAnnotation(DataPoint.class) != null) || (localMethod.getAnnotation(DataPoints.class) != null))
      {
        StringBuilder localStringBuilder;
        if (!Modifier.isStatic(localMethod.getModifiers()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DataPoint method ");
          localStringBuilder.append(localMethod.getName());
          localStringBuilder.append(" must be static");
          paramList.add(new Error(localStringBuilder.toString()));
        }
        if (!Modifier.isPublic(localMethod.getModifiers()))
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("DataPoint method ");
          localStringBuilder.append(localMethod.getName());
          localStringBuilder.append(" must be public");
          paramList.add(new Error(localStringBuilder.toString()));
        }
      }
      i += 1;
    }
  }
  
  private void validateParameterSupplier(Class<? extends ParameterSupplier> paramClass, List<Throwable> paramList)
  {
    Object localObject = paramClass.getConstructors();
    if (localObject.length != 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ParameterSupplier ");
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append(" must have only one constructor (either empty or taking only a TestClass)");
      paramList.add(new Error(((StringBuilder)localObject).toString()));
      return;
    }
    localObject = localObject[0].getParameterTypes();
    if ((localObject.length != 0) && (!localObject[0].equals(TestClass.class)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ParameterSupplier ");
      ((StringBuilder)localObject).append(paramClass.getName());
      ((StringBuilder)localObject).append(" constructor must take either nothing or a single TestClass instance");
      paramList.add(new Error(((StringBuilder)localObject).toString()));
    }
  }
  
  protected void collectInitializationErrors(List<Throwable> paramList)
  {
    super.collectInitializationErrors(paramList);
    validateDataPointFields(paramList);
    validateDataPointMethods(paramList);
  }
  
  protected List<FrameworkMethod> computeTestMethods()
  {
    ArrayList localArrayList = new ArrayList(super.computeTestMethods());
    List localList = getTestClass().getAnnotatedMethods(Theory.class);
    localArrayList.removeAll(localList);
    localArrayList.addAll(localList);
    return localArrayList;
  }
  
  public Statement methodBlock(FrameworkMethod paramFrameworkMethod)
  {
    return new TheoryAnchor(paramFrameworkMethod, getTestClass());
  }
  
  protected void validateConstructor(List<Throwable> paramList)
  {
    validateOnlyOneConstructor(paramList);
  }
  
  protected void validateTestMethods(List<Throwable> paramList)
  {
    Iterator localIterator = computeTestMethods().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (FrameworkMethod)localIterator.next();
      if (((FrameworkMethod)localObject).getAnnotation(Theory.class) != null)
      {
        ((FrameworkMethod)localObject).validatePublicVoid(false, paramList);
        ((FrameworkMethod)localObject).validateNoTypeParametersOnArgs(paramList);
      }
      else
      {
        ((FrameworkMethod)localObject).validatePublicVoidNoArg(false, paramList);
      }
      localObject = ParameterSignature.signatures(((FrameworkMethod)localObject).getMethod()).iterator();
      while (((Iterator)localObject).hasNext())
      {
        ParametersSuppliedBy localParametersSuppliedBy = (ParametersSuppliedBy)((ParameterSignature)((Iterator)localObject).next()).findDeepAnnotation(ParametersSuppliedBy.class);
        if (localParametersSuppliedBy != null) {
          validateParameterSupplier(localParametersSuppliedBy.value(), paramList);
        }
      }
    }
  }
  
  public static class TheoryAnchor
    extends Statement
  {
    private List<AssumptionViolatedException> fInvalidParameters = new ArrayList();
    private int successes = 0;
    private final TestClass testClass;
    private final FrameworkMethod testMethod;
    
    public TheoryAnchor(FrameworkMethod paramFrameworkMethod, TestClass paramTestClass)
    {
      this.testMethod = paramFrameworkMethod;
      this.testClass = paramTestClass;
    }
    
    private TestClass getTestClass()
    {
      return this.testClass;
    }
    
    private Statement methodCompletesWithParameters(final FrameworkMethod paramFrameworkMethod, final Assignments paramAssignments, final Object paramObject)
    {
      new Statement()
      {
        public void evaluate()
          throws Throwable
        {
          Object[] arrayOfObject = paramAssignments.getMethodArguments();
          if (!Theories.TheoryAnchor.this.nullsOk()) {
            Assume.assumeNotNull(arrayOfObject);
          }
          paramFrameworkMethod.invokeExplosively(paramObject, arrayOfObject);
        }
      };
    }
    
    private boolean nullsOk()
    {
      Theory localTheory = (Theory)this.testMethod.getMethod().getAnnotation(Theory.class);
      if (localTheory == null) {
        return false;
      }
      return localTheory.nullsAccepted();
    }
    
    public void evaluate()
      throws Throwable
    {
      runWithAssignment(Assignments.allUnassigned(this.testMethod.getMethod(), getTestClass()));
      int i;
      if (this.testMethod.getAnnotation(Theory.class) != null) {
        i = 1;
      } else {
        i = 0;
      }
      if ((this.successes == 0) && (i != 0))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Never found parameters that satisfied method assumptions.  Violated assumptions: ");
        localStringBuilder.append(this.fInvalidParameters);
        Assert.fail(localStringBuilder.toString());
      }
    }
    
    protected void handleAssumptionViolation(AssumptionViolatedException paramAssumptionViolatedException)
    {
      this.fInvalidParameters.add(paramAssumptionViolatedException);
    }
    
    protected void handleDataPointSuccess()
    {
      this.successes += 1;
    }
    
    protected void reportParameterizedError(Throwable paramThrowable, Object... paramVarArgs)
      throws Throwable
    {
      if (paramVarArgs.length == 0) {
        throw paramThrowable;
      }
      throw new ParameterizedAssertionError(paramThrowable, this.testMethod.getName(), paramVarArgs);
    }
    
    protected void runWithAssignment(Assignments paramAssignments)
      throws Throwable
    {
      if (!paramAssignments.isComplete())
      {
        runWithIncompleteAssignment(paramAssignments);
        return;
      }
      runWithCompleteAssignment(paramAssignments);
    }
    
    protected void runWithCompleteAssignment(final Assignments paramAssignments)
      throws Throwable
    {
      new BlockJUnit4ClassRunner(getTestClass().getJavaClass())
      {
        protected void collectInitializationErrors(List<Throwable> paramAnonymousList) {}
        
        public Object createTest()
          throws Exception
        {
          Object[] arrayOfObject = paramAssignments.getConstructorArguments();
          if (!Theories.TheoryAnchor.this.nullsOk()) {
            Assume.assumeNotNull(arrayOfObject);
          }
          return getTestClass().getOnlyConstructor().newInstance(arrayOfObject);
        }
        
        public Statement methodBlock(FrameworkMethod paramAnonymousFrameworkMethod)
        {
          new Statement()
          {
            /* Error */
            public void evaluate()
              throws Throwable
            {
              // Byte code:
              //   0: aload_0
              //   1: getfield 26	org/junit/experimental/theories/Theories$TheoryAnchor$1$1:val$statement	Lorg/junit/runners/model/Statement;
              //   4: invokevirtual 36	org/junit/runners/model/Statement:evaluate	()V
              //   7: aload_0
              //   8: getfield 24	org/junit/experimental/theories/Theories$TheoryAnchor$1$1:this$1	Lorg/junit/experimental/theories/Theories$TheoryAnchor$1;
              //   11: getfield 40	org/junit/experimental/theories/Theories$TheoryAnchor$1:this$0	Lorg/junit/experimental/theories/Theories$TheoryAnchor;
              //   14: invokevirtual 43	org/junit/experimental/theories/Theories$TheoryAnchor:handleDataPointSuccess	()V
              //   17: return
              //   18: astore_1
              //   19: aload_0
              //   20: getfield 24	org/junit/experimental/theories/Theories$TheoryAnchor$1$1:this$1	Lorg/junit/experimental/theories/Theories$TheoryAnchor$1;
              //   23: getfield 40	org/junit/experimental/theories/Theories$TheoryAnchor$1:this$0	Lorg/junit/experimental/theories/Theories$TheoryAnchor;
              //   26: aload_1
              //   27: aload_0
              //   28: getfield 24	org/junit/experimental/theories/Theories$TheoryAnchor$1$1:this$1	Lorg/junit/experimental/theories/Theories$TheoryAnchor$1;
              //   31: getfield 47	org/junit/experimental/theories/Theories$TheoryAnchor$1:val$complete	Lorg/junit/experimental/theories/internal/Assignments;
              //   34: aload_0
              //   35: getfield 24	org/junit/experimental/theories/Theories$TheoryAnchor$1$1:this$1	Lorg/junit/experimental/theories/Theories$TheoryAnchor$1;
              //   38: getfield 40	org/junit/experimental/theories/Theories$TheoryAnchor$1:this$0	Lorg/junit/experimental/theories/Theories$TheoryAnchor;
              //   41: invokestatic 51	org/junit/experimental/theories/Theories$TheoryAnchor:access$000	(Lorg/junit/experimental/theories/Theories$TheoryAnchor;)Z
              //   44: invokevirtual 57	org/junit/experimental/theories/internal/Assignments:getArgumentStrings	(Z)[Ljava/lang/Object;
              //   47: invokevirtual 61	org/junit/experimental/theories/Theories$TheoryAnchor:reportParameterizedError	(Ljava/lang/Throwable;[Ljava/lang/Object;)V
              //   50: return
              //   51: astore_1
              //   52: aload_0
              //   53: getfield 24	org/junit/experimental/theories/Theories$TheoryAnchor$1$1:this$1	Lorg/junit/experimental/theories/Theories$TheoryAnchor$1;
              //   56: getfield 40	org/junit/experimental/theories/Theories$TheoryAnchor$1:this$0	Lorg/junit/experimental/theories/Theories$TheoryAnchor;
              //   59: aload_1
              //   60: invokevirtual 65	org/junit/experimental/theories/Theories$TheoryAnchor:handleAssumptionViolation	(Lorg/junit/internal/AssumptionViolatedException;)V
              //   63: return
              // Local variable table:
              //   start	length	slot	name	signature
              //   0	64	0	this	1
              //   18	9	1	localThrowable	Throwable
              //   51	9	1	localAssumptionViolatedException	AssumptionViolatedException
              // Exception table:
              //   from	to	target	type
              //   0	17	18	finally
              //   0	17	51	org/junit/internal/AssumptionViolatedException
            }
          };
        }
        
        protected Statement methodInvoker(FrameworkMethod paramAnonymousFrameworkMethod, Object paramAnonymousObject)
        {
          return Theories.TheoryAnchor.this.methodCompletesWithParameters(paramAnonymousFrameworkMethod, paramAssignments, paramAnonymousObject);
        }
      }.methodBlock(this.testMethod).evaluate();
    }
    
    protected void runWithIncompleteAssignment(Assignments paramAssignments)
      throws Throwable
    {
      Iterator localIterator = paramAssignments.potentialsForNextUnassigned().iterator();
      while (localIterator.hasNext()) {
        runWithAssignment(paramAssignments.assignNext((PotentialAssignment)localIterator.next()));
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\theories\Theories.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */