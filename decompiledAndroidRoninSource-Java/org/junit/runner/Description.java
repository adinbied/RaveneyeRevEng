package org.junit.runner;

import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Description
  implements Serializable
{
  public static final Description EMPTY = new Description(null, "No Tests", new Annotation[0]);
  private static final Pattern METHOD_AND_CLASS_NAME_PATTERN = Pattern.compile("([\\s\\S]*)\\((.*)\\)");
  public static final Description TEST_MECHANISM = new Description(null, "Test mechanism", new Annotation[0]);
  private static final long serialVersionUID = 1L;
  private final Annotation[] fAnnotations;
  private final Collection<Description> fChildren = new ConcurrentLinkedQueue();
  private final String fDisplayName;
  private volatile Class<?> fTestClass;
  private final Serializable fUniqueId;
  
  private Description(Class<?> paramClass, String paramString, Serializable paramSerializable, Annotation... paramVarArgs)
  {
    if ((paramString != null) && (paramString.length() != 0))
    {
      if (paramSerializable != null)
      {
        this.fTestClass = paramClass;
        this.fDisplayName = paramString;
        this.fUniqueId = paramSerializable;
        this.fAnnotations = paramVarArgs;
        return;
      }
      throw new IllegalArgumentException("The unique id must not be null.");
    }
    throw new IllegalArgumentException("The display name must not be empty.");
  }
  
  private Description(Class<?> paramClass, String paramString, Annotation... paramVarArgs)
  {
    this(paramClass, paramString, paramString, paramVarArgs);
  }
  
  public static Description createSuiteDescription(Class<?> paramClass)
  {
    return new Description(paramClass, paramClass.getName(), paramClass.getAnnotations());
  }
  
  public static Description createSuiteDescription(String paramString, Serializable paramSerializable, Annotation... paramVarArgs)
  {
    return new Description(null, paramString, paramSerializable, paramVarArgs);
  }
  
  public static Description createSuiteDescription(String paramString, Annotation... paramVarArgs)
  {
    return new Description(null, paramString, paramVarArgs);
  }
  
  public static Description createTestDescription(Class<?> paramClass, String paramString)
  {
    return new Description(paramClass, formatDisplayName(paramString, paramClass.getName()), new Annotation[0]);
  }
  
  public static Description createTestDescription(Class<?> paramClass, String paramString, Annotation... paramVarArgs)
  {
    return new Description(paramClass, formatDisplayName(paramString, paramClass.getName()), paramVarArgs);
  }
  
  public static Description createTestDescription(String paramString1, String paramString2, Serializable paramSerializable)
  {
    return new Description(null, formatDisplayName(paramString2, paramString1), paramSerializable, new Annotation[0]);
  }
  
  public static Description createTestDescription(String paramString1, String paramString2, Annotation... paramVarArgs)
  {
    return new Description(null, formatDisplayName(paramString2, paramString1), paramVarArgs);
  }
  
  private static String formatDisplayName(String paramString1, String paramString2)
  {
    return String.format("%s(%s)", new Object[] { paramString1, paramString2 });
  }
  
  private String methodAndClassNamePatternGroupOrDefault(int paramInt, String paramString)
  {
    Matcher localMatcher = METHOD_AND_CLASS_NAME_PATTERN.matcher(toString());
    if (localMatcher.matches()) {
      paramString = localMatcher.group(paramInt);
    }
    return paramString;
  }
  
  public void addChild(Description paramDescription)
  {
    this.fChildren.add(paramDescription);
  }
  
  public Description childlessCopy()
  {
    return new Description(this.fTestClass, this.fDisplayName, this.fAnnotations);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof Description)) {
      return false;
    }
    paramObject = (Description)paramObject;
    return this.fUniqueId.equals(((Description)paramObject).fUniqueId);
  }
  
  public <T extends Annotation> T getAnnotation(Class<T> paramClass)
  {
    Annotation[] arrayOfAnnotation = this.fAnnotations;
    int j = arrayOfAnnotation.length;
    int i = 0;
    while (i < j)
    {
      Annotation localAnnotation = arrayOfAnnotation[i];
      if (localAnnotation.annotationType().equals(paramClass)) {
        return (Annotation)paramClass.cast(localAnnotation);
      }
      i += 1;
    }
    return null;
  }
  
  public Collection<Annotation> getAnnotations()
  {
    return Arrays.asList(this.fAnnotations);
  }
  
  public ArrayList<Description> getChildren()
  {
    return new ArrayList(this.fChildren);
  }
  
  public String getClassName()
  {
    if (this.fTestClass != null) {
      return this.fTestClass.getName();
    }
    return methodAndClassNamePatternGroupOrDefault(2, toString());
  }
  
  public String getDisplayName()
  {
    return this.fDisplayName;
  }
  
  public String getMethodName()
  {
    return methodAndClassNamePatternGroupOrDefault(1, null);
  }
  
  public Class<?> getTestClass()
  {
    if (this.fTestClass != null) {
      return this.fTestClass;
    }
    Object localObject = getClassName();
    if (localObject == null) {
      return null;
    }
    try
    {
      this.fTestClass = Class.forName((String)localObject, false, getClass().getClassLoader());
      localObject = this.fTestClass;
      return (Class<?>)localObject;
    }
    catch (ClassNotFoundException localClassNotFoundException) {}
    return null;
  }
  
  public int hashCode()
  {
    return this.fUniqueId.hashCode();
  }
  
  public boolean isEmpty()
  {
    return equals(EMPTY);
  }
  
  public boolean isSuite()
  {
    return isTest() ^ true;
  }
  
  public boolean isTest()
  {
    return this.fChildren.isEmpty();
  }
  
  public int testCount()
  {
    if (isTest()) {
      return 1;
    }
    int i = 0;
    Iterator localIterator = this.fChildren.iterator();
    while (localIterator.hasNext()) {
      i += ((Description)localIterator.next()).testCount();
    }
    return i;
  }
  
  public String toString()
  {
    return getDisplayName();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\runner\Description.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */