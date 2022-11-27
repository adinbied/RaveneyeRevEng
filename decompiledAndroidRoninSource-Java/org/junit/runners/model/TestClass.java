package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.internal.MethodSorter;

public class TestClass
  implements Annotatable
{
  private static final FieldComparator FIELD_COMPARATOR = new FieldComparator(null);
  private static final MethodComparator METHOD_COMPARATOR = new MethodComparator(null);
  private final Class<?> clazz;
  private final Map<Class<? extends Annotation>, List<FrameworkField>> fieldsForAnnotations;
  private final Map<Class<? extends Annotation>, List<FrameworkMethod>> methodsForAnnotations;
  
  public TestClass(Class<?> paramClass)
  {
    this.clazz = paramClass;
    if ((paramClass != null) && (paramClass.getConstructors().length > 1)) {
      throw new IllegalArgumentException("Test class can only have one constructor");
    }
    paramClass = new LinkedHashMap();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    scanAnnotatedMembers(paramClass, localLinkedHashMap);
    this.methodsForAnnotations = makeDeeplyUnmodifiable(paramClass);
    this.fieldsForAnnotations = makeDeeplyUnmodifiable(localLinkedHashMap);
  }
  
  protected static <T extends FrameworkMember<T>> void addToAnnotationLists(T paramT, Map<Class<? extends Annotation>, List<T>> paramMap)
  {
    Annotation[] arrayOfAnnotation = paramT.getAnnotations();
    int j = arrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = arrayOfAnnotation[i].annotationType();
      List localList = getAnnotatedMembers(paramMap, localClass, true);
      if (paramT.isShadowedBy(localList)) {
        return;
      }
      if (runsTopToBottom(localClass)) {
        localList.add(0, paramT);
      } else {
        localList.add(paramT);
      }
      i += 1;
    }
  }
  
  private <T> List<T> collectValues(Map<?, List<T>> paramMap)
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    paramMap = paramMap.values().iterator();
    while (paramMap.hasNext()) {
      localLinkedHashSet.addAll((List)paramMap.next());
    }
    return new ArrayList(localLinkedHashSet);
  }
  
  private static <T> List<T> getAnnotatedMembers(Map<Class<? extends Annotation>, List<T>> paramMap, Class<? extends Annotation> paramClass, boolean paramBoolean)
  {
    if ((!paramMap.containsKey(paramClass)) && (paramBoolean)) {
      paramMap.put(paramClass, new ArrayList());
    }
    paramClass = (List)paramMap.get(paramClass);
    paramMap = paramClass;
    if (paramClass == null) {
      paramMap = Collections.emptyList();
    }
    return paramMap;
  }
  
  private static Field[] getSortedDeclaredFields(Class<?> paramClass)
  {
    paramClass = paramClass.getDeclaredFields();
    Arrays.sort(paramClass, FIELD_COMPARATOR);
    return paramClass;
  }
  
  private static List<Class<?>> getSuperClasses(Class<?> paramClass)
  {
    ArrayList localArrayList = new ArrayList();
    while (paramClass != null)
    {
      localArrayList.add(paramClass);
      paramClass = paramClass.getSuperclass();
    }
    return localArrayList;
  }
  
  private static <T extends FrameworkMember<T>> Map<Class<? extends Annotation>, List<T>> makeDeeplyUnmodifiable(Map<Class<? extends Annotation>, List<T>> paramMap)
  {
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      localLinkedHashMap.put(localEntry.getKey(), Collections.unmodifiableList((List)localEntry.getValue()));
    }
    return Collections.unmodifiableMap(localLinkedHashMap);
  }
  
  private static boolean runsTopToBottom(Class<? extends Annotation> paramClass)
  {
    return (paramClass.equals(Before.class)) || (paramClass.equals(BeforeClass.class));
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject == null) {
      return false;
    }
    if (getClass() != paramObject.getClass()) {
      return false;
    }
    paramObject = (TestClass)paramObject;
    return this.clazz == ((TestClass)paramObject).clazz;
  }
  
  public <T> List<T> getAnnotatedFieldValues(Object paramObject, Class<? extends Annotation> paramClass, Class<T> paramClass1)
  {
    ArrayList localArrayList = new ArrayList();
    paramClass = getAnnotatedFields(paramClass).iterator();
    while (paramClass.hasNext())
    {
      Object localObject = (FrameworkField)paramClass.next();
      try
      {
        localObject = ((FrameworkField)localObject).get(paramObject);
        if (paramClass1.isInstance(localObject)) {
          localArrayList.add(paramClass1.cast(localObject));
        }
      }
      catch (IllegalAccessException paramObject)
      {
        throw new RuntimeException("How did getFields return a field we couldn't access?", (Throwable)paramObject);
      }
    }
    return localArrayList;
  }
  
  public List<FrameworkField> getAnnotatedFields()
  {
    return collectValues(this.fieldsForAnnotations);
  }
  
  public List<FrameworkField> getAnnotatedFields(Class<? extends Annotation> paramClass)
  {
    return Collections.unmodifiableList(getAnnotatedMembers(this.fieldsForAnnotations, paramClass, false));
  }
  
  /* Error */
  public <T> List<T> getAnnotatedMethodValues(Object paramObject, Class<? extends Annotation> paramClass, Class<T> paramClass1)
  {
    // Byte code:
    //   0: new 144	java/util/ArrayList
    //   3: dup
    //   4: invokespecial 152	java/util/ArrayList:<init>	()V
    //   7: astore 4
    //   9: aload_0
    //   10: aload_2
    //   11: invokevirtual 253	org/junit/runners/model/TestClass:getAnnotatedMethods	(Ljava/lang/Class;)Ljava/util/List;
    //   14: invokeinterface 228 1 0
    //   19: astore 5
    //   21: aload 5
    //   23: invokeinterface 132 1 0
    //   28: ifeq +88 -> 116
    //   31: aload 5
    //   33: invokeinterface 136 1 0
    //   38: checkcast 255	org/junit/runners/model/FrameworkMethod
    //   41: astore_2
    //   42: aload_3
    //   43: aload_2
    //   44: invokevirtual 258	org/junit/runners/model/FrameworkMethod:getReturnType	()Ljava/lang/Class;
    //   47: invokevirtual 261	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   50: ifeq -29 -> 21
    //   53: aload 4
    //   55: aload_3
    //   56: aload_2
    //   57: aload_1
    //   58: iconst_0
    //   59: anewarray 4	java/lang/Object
    //   62: invokevirtual 265	org/junit/runners/model/FrameworkMethod:invokeExplosively	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   65: invokevirtual 237	java/lang/Class:cast	(Ljava/lang/Object;)Ljava/lang/Object;
    //   68: invokeinterface 108 2 0
    //   73: pop
    //   74: goto -53 -> 21
    //   77: astore_1
    //   78: new 267	java/lang/StringBuilder
    //   81: dup
    //   82: invokespecial 268	java/lang/StringBuilder:<init>	()V
    //   85: astore_3
    //   86: aload_3
    //   87: ldc_w 270
    //   90: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_3
    //   95: aload_2
    //   96: invokevirtual 278	org/junit/runners/model/FrameworkMethod:getName	()Ljava/lang/String;
    //   99: invokevirtual 274	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   102: pop
    //   103: new 239	java/lang/RuntimeException
    //   106: dup
    //   107: aload_3
    //   108: invokevirtual 281	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aload_1
    //   112: invokespecial 244	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: athrow
    //   116: aload 4
    //   118: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	119	0	this	TestClass
    //   0	119	1	paramObject	Object
    //   0	119	2	paramClass	Class<? extends Annotation>
    //   0	119	3	paramClass1	Class<T>
    //   7	110	4	localArrayList	ArrayList
    //   19	13	5	localIterator	Iterator
    // Exception table:
    //   from	to	target	type
    //   42	74	77	finally
  }
  
  public List<FrameworkMethod> getAnnotatedMethods()
  {
    List localList = collectValues(this.methodsForAnnotations);
    Collections.sort(localList, METHOD_COMPARATOR);
    return localList;
  }
  
  public List<FrameworkMethod> getAnnotatedMethods(Class<? extends Annotation> paramClass)
  {
    return Collections.unmodifiableList(getAnnotatedMembers(this.methodsForAnnotations, paramClass, false));
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    Class localClass = this.clazz;
    if (localClass == null) {
      return null;
    }
    return localClass.getAnnotation(paramClass);
  }
  
  public Annotation[] getAnnotations()
  {
    Class localClass = this.clazz;
    if (localClass == null) {
      return new Annotation[0];
    }
    return localClass.getAnnotations();
  }
  
  public Class<?> getJavaClass()
  {
    return this.clazz;
  }
  
  public String getName()
  {
    Class localClass = this.clazz;
    if (localClass == null) {
      return "null";
    }
    return localClass.getName();
  }
  
  public Constructor<?> getOnlyConstructor()
  {
    Constructor[] arrayOfConstructor = this.clazz.getConstructors();
    Assert.assertEquals(1L, arrayOfConstructor.length);
    return arrayOfConstructor[0];
  }
  
  public int hashCode()
  {
    Class localClass = this.clazz;
    if (localClass == null) {
      return 0;
    }
    return localClass.hashCode();
  }
  
  public boolean isANonStaticInnerClass()
  {
    return (this.clazz.isMemberClass()) && (!Modifier.isStatic(this.clazz.getModifiers()));
  }
  
  public boolean isPublic()
  {
    return Modifier.isPublic(this.clazz.getModifiers());
  }
  
  protected void scanAnnotatedMembers(Map<Class<? extends Annotation>, List<FrameworkMethod>> paramMap, Map<Class<? extends Annotation>, List<FrameworkField>> paramMap1)
  {
    Iterator localIterator = getSuperClasses(this.clazz).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (Class)localIterator.next();
      Method[] arrayOfMethod = MethodSorter.getDeclaredMethods((Class)localObject);
      int k = arrayOfMethod.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        addToAnnotationLists(new FrameworkMethod(arrayOfMethod[i]), paramMap);
        i += 1;
      }
      localObject = getSortedDeclaredFields((Class)localObject);
      k = localObject.length;
      i = j;
      while (i < k)
      {
        addToAnnotationLists(new FrameworkField(localObject[i]), paramMap1);
        i += 1;
      }
    }
  }
  
  private static class FieldComparator
    implements Comparator<Field>
  {
    public int compare(Field paramField1, Field paramField2)
    {
      return paramField1.getName().compareTo(paramField2.getName());
    }
  }
  
  private static class MethodComparator
    implements Comparator<FrameworkMethod>
  {
    public int compare(FrameworkMethod paramFrameworkMethod1, FrameworkMethod paramFrameworkMethod2)
    {
      return MethodSorter.NAME_ASCENDING.compare(paramFrameworkMethod1.getMethod(), paramFrameworkMethod2.getMethod());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runners\model\TestClass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */