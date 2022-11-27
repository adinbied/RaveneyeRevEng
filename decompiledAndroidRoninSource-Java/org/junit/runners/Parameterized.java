package org.junit.runners;

import java.lang.annotation.Annotation;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.junit.runner.Runner;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.TestClass;
import org.junit.runners.parameterized.BlockJUnit4ClassRunnerWithParametersFactory;
import org.junit.runners.parameterized.ParametersRunnerFactory;
import org.junit.runners.parameterized.TestWithParameters;

public class Parameterized
  extends Suite
{
  private static final ParametersRunnerFactory DEFAULT_FACTORY = new BlockJUnit4ClassRunnerWithParametersFactory();
  private static final List<Runner> NO_RUNNERS = Collections.emptyList();
  private final List<Runner> runners;
  
  public Parameterized(Class<?> paramClass)
    throws Throwable
  {
    super(paramClass, NO_RUNNERS);
    paramClass = getParametersRunnerFactory(paramClass);
    Parameters localParameters = (Parameters)getParametersMethod().getAnnotation(Parameters.class);
    this.runners = Collections.unmodifiableList(createRunnersForParameters(allParameters(), localParameters.name(), paramClass));
  }
  
  private Iterable<Object> allParameters()
    throws Throwable
  {
    Object localObject = getParametersMethod().invokeExplosively(null, new Object[0]);
    if ((localObject instanceof Iterable)) {
      return (Iterable)localObject;
    }
    if ((localObject instanceof Object[])) {
      return Arrays.asList((Object[])localObject);
    }
    throw parametersMethodReturnedWrongType();
  }
  
  private List<Runner> createRunnersForParameters(Iterable<Object> paramIterable, String paramString, ParametersRunnerFactory paramParametersRunnerFactory)
    throws InitializationError, Exception
  {
    try
    {
      paramString = createTestsForParameters(paramIterable, paramString);
      paramIterable = new ArrayList();
      paramString = paramString.iterator();
      while (paramString.hasNext()) {
        paramIterable.add(paramParametersRunnerFactory.createRunnerForTestWithParameters((TestWithParameters)paramString.next()));
      }
      return paramIterable;
    }
    catch (ClassCastException paramIterable)
    {
      for (;;) {}
    }
    throw parametersMethodReturnedWrongType();
  }
  
  private TestWithParameters createTestWithNotNormalizedParameters(String paramString, int paramInt, Object paramObject)
  {
    if ((paramObject instanceof Object[])) {
      paramObject = (Object[])paramObject;
    } else {
      paramObject = new Object[] { paramObject };
    }
    return createTestWithParameters(getTestClass(), paramString, paramInt, (Object[])paramObject);
  }
  
  private static TestWithParameters createTestWithParameters(TestClass paramTestClass, String paramString, int paramInt, Object[] paramArrayOfObject)
  {
    paramString = MessageFormat.format(paramString.replaceAll("\\{index\\}", Integer.toString(paramInt)), paramArrayOfObject);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[");
    localStringBuilder.append(paramString);
    localStringBuilder.append("]");
    return new TestWithParameters(localStringBuilder.toString(), paramTestClass, Arrays.asList(paramArrayOfObject));
  }
  
  private List<TestWithParameters> createTestsForParameters(Iterable<Object> paramIterable, String paramString)
    throws Exception
  {
    ArrayList localArrayList = new ArrayList();
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      localArrayList.add(createTestWithNotNormalizedParameters(paramString, i, paramIterable.next()));
      i += 1;
    }
    return localArrayList;
  }
  
  private FrameworkMethod getParametersMethod()
    throws Exception
  {
    Object localObject = getTestClass().getAnnotatedMethods(Parameters.class).iterator();
    while (((Iterator)localObject).hasNext())
    {
      FrameworkMethod localFrameworkMethod = (FrameworkMethod)((Iterator)localObject).next();
      if ((localFrameworkMethod.isStatic()) && (localFrameworkMethod.isPublic())) {
        return localFrameworkMethod;
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("No public static parameters method on class ");
    ((StringBuilder)localObject).append(getTestClass().getName());
    throw new Exception(((StringBuilder)localObject).toString());
  }
  
  private ParametersRunnerFactory getParametersRunnerFactory(Class<?> paramClass)
    throws InstantiationException, IllegalAccessException
  {
    paramClass = (UseParametersRunnerFactory)paramClass.getAnnotation(UseParametersRunnerFactory.class);
    if (paramClass == null) {
      return DEFAULT_FACTORY;
    }
    return (ParametersRunnerFactory)paramClass.value().newInstance();
  }
  
  private Exception parametersMethodReturnedWrongType()
    throws Exception
  {
    return new Exception(MessageFormat.format("{0}.{1}() must return an Iterable of arrays.", new Object[] { getTestClass().getName(), getParametersMethod().getName() }));
  }
  
  protected List<Runner> getChildren()
  {
    return this.runners;
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.FIELD})
  public static @interface Parameter
  {
    int value() default 0;
  }
  
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.METHOD})
  public static @interface Parameters
  {
    String name() default "{index}";
  }
  
  @Inherited
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface UseParametersRunnerFactory
  {
    Class<? extends ParametersRunnerFactory> value() default BlockJUnit4ClassRunnerWithParametersFactory.class;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\Parameterized.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */