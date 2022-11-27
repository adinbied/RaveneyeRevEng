package org.junit.experimental.theories.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.experimental.theories.PotentialAssignment.CouldNotGenerateValueException;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public class AllMembersSupplier
  extends ParameterSupplier
{
  private final TestClass clazz;
  
  public AllMembersSupplier(TestClass paramTestClass)
  {
    this.clazz = paramTestClass;
  }
  
  private void addArrayValues(ParameterSignature paramParameterSignature, String paramString, List<PotentialAssignment> paramList, Object paramObject)
  {
    int i = 0;
    while (i < Array.getLength(paramObject))
    {
      Object localObject = Array.get(paramObject, i);
      if (paramParameterSignature.canAcceptValue(localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        paramList.add(PotentialAssignment.forValue(localStringBuilder.toString(), localObject));
      }
      i += 1;
    }
  }
  
  private void addDataPointsValues(Class<?> paramClass, ParameterSignature paramParameterSignature, String paramString, List<PotentialAssignment> paramList, Object paramObject)
  {
    if (paramClass.isArray())
    {
      addArrayValues(paramParameterSignature, paramString, paramList, paramObject);
      return;
    }
    if (Iterable.class.isAssignableFrom(paramClass)) {
      addIterableValues(paramParameterSignature, paramString, paramList, (Iterable)paramObject);
    }
  }
  
  private void addIterableValues(ParameterSignature paramParameterSignature, String paramString, List<PotentialAssignment> paramList, Iterable<?> paramIterable)
  {
    paramIterable = paramIterable.iterator();
    int i = 0;
    while (paramIterable.hasNext())
    {
      Object localObject = paramIterable.next();
      if (paramParameterSignature.canAcceptValue(localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramString);
        localStringBuilder.append("[");
        localStringBuilder.append(i);
        localStringBuilder.append("]");
        paramList.add(PotentialAssignment.forValue(localStringBuilder.toString(), localObject));
      }
      i += 1;
    }
  }
  
  private void addMultiPointFields(ParameterSignature paramParameterSignature, List<PotentialAssignment> paramList)
  {
    Iterator localIterator = getDataPointsFields(paramParameterSignature).iterator();
    while (localIterator.hasNext())
    {
      Field localField = (Field)localIterator.next();
      addDataPointsValues(localField.getType(), paramParameterSignature, localField.getName(), paramList, getStaticFieldValue(localField));
    }
  }
  
  private void addMultiPointMethods(ParameterSignature paramParameterSignature, List<PotentialAssignment> paramList)
    throws Throwable
  {
    Iterator localIterator = getDataPointsMethods(paramParameterSignature).iterator();
    while (localIterator.hasNext())
    {
      FrameworkMethod localFrameworkMethod = (FrameworkMethod)localIterator.next();
      Class localClass = localFrameworkMethod.getReturnType();
      if (((localClass.isArray()) && (paramParameterSignature.canPotentiallyAcceptType(localClass.getComponentType()))) || (Iterable.class.isAssignableFrom(localClass))) {
        try
        {
          addDataPointsValues(localClass, paramParameterSignature, localFrameworkMethod.getName(), paramList, localFrameworkMethod.invokeExplosively(null, new Object[0]));
        }
        finally
        {
          paramList = (DataPoints)localFrameworkMethod.getAnnotation(DataPoints.class);
          if ((paramList != null) && (isAssignableToAnyOf(paramList.ignoredExceptions(), paramParameterSignature))) {
            return;
          }
        }
      }
    }
  }
  
  private void addSinglePointFields(ParameterSignature paramParameterSignature, List<PotentialAssignment> paramList)
  {
    Iterator localIterator = getSingleDataPointFields(paramParameterSignature).iterator();
    while (localIterator.hasNext())
    {
      Field localField = (Field)localIterator.next();
      Object localObject = getStaticFieldValue(localField);
      if (paramParameterSignature.canAcceptValue(localObject)) {
        paramList.add(PotentialAssignment.forValue(localField.getName(), localObject));
      }
    }
  }
  
  private void addSinglePointMethods(ParameterSignature paramParameterSignature, List<PotentialAssignment> paramList)
  {
    Iterator localIterator = getSingleDataPointMethods(paramParameterSignature).iterator();
    while (localIterator.hasNext())
    {
      FrameworkMethod localFrameworkMethod = (FrameworkMethod)localIterator.next();
      if (paramParameterSignature.canAcceptType(localFrameworkMethod.getType())) {
        paramList.add(new MethodParameterValue(localFrameworkMethod, null));
      }
    }
  }
  
  private Object getStaticFieldValue(Field paramField)
  {
    try
    {
      paramField = paramField.get(null);
      return paramField;
    }
    catch (IllegalArgumentException paramField)
    {
      for (;;) {}
    }
    catch (IllegalAccessException paramField)
    {
      for (;;) {}
    }
    throw new RuntimeException("unexpected: getFields returned an inaccessible field");
    throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
  }
  
  private static boolean isAssignableToAnyOf(Class<?>[] paramArrayOfClass, Object paramObject)
  {
    int j = paramArrayOfClass.length;
    int i = 0;
    while (i < j)
    {
      if (paramArrayOfClass[i].isAssignableFrom(paramObject.getClass())) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  protected Collection<Field> getDataPointsFields(ParameterSignature paramParameterSignature)
  {
    Object localObject = this.clazz.getAnnotatedFields(DataPoints.class);
    paramParameterSignature = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramParameterSignature.add(((FrameworkField)((Iterator)localObject).next()).getField());
    }
    return paramParameterSignature;
  }
  
  protected Collection<FrameworkMethod> getDataPointsMethods(ParameterSignature paramParameterSignature)
  {
    return this.clazz.getAnnotatedMethods(DataPoints.class);
  }
  
  protected Collection<Field> getSingleDataPointFields(ParameterSignature paramParameterSignature)
  {
    Object localObject = this.clazz.getAnnotatedFields(DataPoint.class);
    paramParameterSignature = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      paramParameterSignature.add(((FrameworkField)((Iterator)localObject).next()).getField());
    }
    return paramParameterSignature;
  }
  
  protected Collection<FrameworkMethod> getSingleDataPointMethods(ParameterSignature paramParameterSignature)
  {
    return this.clazz.getAnnotatedMethods(DataPoint.class);
  }
  
  public List<PotentialAssignment> getValueSources(ParameterSignature paramParameterSignature)
    throws Throwable
  {
    ArrayList localArrayList = new ArrayList();
    addSinglePointFields(paramParameterSignature, localArrayList);
    addMultiPointFields(paramParameterSignature, localArrayList);
    addSinglePointMethods(paramParameterSignature, localArrayList);
    addMultiPointMethods(paramParameterSignature, localArrayList);
    return localArrayList;
  }
  
  static class MethodParameterValue
    extends PotentialAssignment
  {
    private final FrameworkMethod method;
    
    private MethodParameterValue(FrameworkMethod paramFrameworkMethod)
    {
      this.method = paramFrameworkMethod;
    }
    
    public String getDescription()
      throws PotentialAssignment.CouldNotGenerateValueException
    {
      return this.method.getName();
    }
    
    /* Error */
    public Object getValue()
      throws PotentialAssignment.CouldNotGenerateValueException
    {
      // Byte code:
      //   0: iconst_0
      //   1: istore_1
      //   2: aload_0
      //   3: getfield 16	org/junit/experimental/theories/internal/AllMembersSupplier$MethodParameterValue:method	Lorg/junit/runners/model/FrameworkMethod;
      //   6: aconst_null
      //   7: iconst_0
      //   8: anewarray 38	java/lang/Object
      //   11: invokevirtual 42	org/junit/runners/model/FrameworkMethod:invokeExplosively	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
      //   14: astore_2
      //   15: aload_2
      //   16: areturn
      //   17: astore_2
      //   18: aload_0
      //   19: getfield 16	org/junit/experimental/theories/internal/AllMembersSupplier$MethodParameterValue:method	Lorg/junit/runners/model/FrameworkMethod;
      //   22: ldc 44
      //   24: invokevirtual 48	org/junit/runners/model/FrameworkMethod:getAnnotation	(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;
      //   27: checkcast 44	org/junit/experimental/theories/DataPoint
      //   30: astore_3
      //   31: aload_3
      //   32: ifnull +16 -> 48
      //   35: aload_3
      //   36: invokeinterface 52 1 0
      //   41: aload_2
      //   42: invokestatic 56	org/junit/experimental/theories/internal/AllMembersSupplier:access$000	([Ljava/lang/Class;Ljava/lang/Object;)Z
      //   45: ifne +5 -> 50
      //   48: iconst_1
      //   49: istore_1
      //   50: iload_1
      //   51: invokestatic 62	org/junit/Assume:assumeTrue	(Z)V
      //   54: new 24	org/junit/experimental/theories/PotentialAssignment$CouldNotGenerateValueException
      //   57: dup
      //   58: aload_2
      //   59: invokespecial 65	org/junit/experimental/theories/PotentialAssignment$CouldNotGenerateValueException:<init>	(Ljava/lang/Throwable;)V
      //   62: athrow
      //   63: new 67	java/lang/RuntimeException
      //   66: dup
      //   67: ldc 69
      //   69: invokespecial 72	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   72: athrow
      //   73: new 67	java/lang/RuntimeException
      //   76: dup
      //   77: ldc 74
      //   79: invokespecial 72	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   82: athrow
      //   83: astore_2
      //   84: goto -11 -> 73
      //   87: astore_2
      //   88: goto -25 -> 63
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	91	0	this	MethodParameterValue
      //   1	50	1	bool	boolean
      //   14	2	2	localObject1	Object
      //   17	42	2	localObject2	Object
      //   83	1	2	localIllegalArgumentException	IllegalArgumentException
      //   87	1	2	localIllegalAccessException	IllegalAccessException
      //   30	6	3	localDataPoint	DataPoint
      // Exception table:
      //   from	to	target	type
      //   2	15	17	finally
      //   2	15	83	java/lang/IllegalArgumentException
      //   2	15	87	java/lang/IllegalAccessException
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\experimental\theories\internal\AllMembersSupplier.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */