package com.nineoldandroids.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

class ReflectiveProperty<T, V>
  extends Property<T, V>
{
  private static final String PREFIX_GET = "get";
  private static final String PREFIX_IS = "is";
  private static final String PREFIX_SET = "set";
  private Field mField;
  private Method mGetter;
  private Method mSetter;
  
  public ReflectiveProperty(Class<T> paramClass, Class<V> paramClass1, String paramString)
  {
    super(paramClass1, paramString);
    char c = Character.toUpperCase(paramString.charAt(0));
    Object localObject1 = paramString.substring(1);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(c);
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject1 = ((StringBuilder)localObject2).toString();
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("get");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    for (;;)
    {
      try
      {
        this.mGetter = paramClass.getMethod((String)localObject2, (Class[])null);
      }
      catch (NoSuchMethodException localNoSuchMethodException3)
      {
        continue;
      }
      try
      {
        localObject2 = paramClass.getDeclaredMethod((String)localObject2, (Class[])null);
        this.mGetter = ((Method)localObject2);
        ((Method)localObject2).setAccessible(true);
      }
      catch (NoSuchMethodException localNoSuchMethodException2) {}
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("is");
    ((StringBuilder)localObject2).append((String)localObject1);
    localObject2 = ((StringBuilder)localObject2).toString();
    for (;;)
    {
      try
      {
        this.mGetter = paramClass.getMethod((String)localObject2, (Class[])null);
      }
      catch (NoSuchMethodException localNoSuchMethodException4)
      {
        continue;
      }
      try
      {
        localObject2 = paramClass.getDeclaredMethod((String)localObject2, (Class[])null);
        this.mGetter = ((Method)localObject2);
        ((Method)localObject2).setAccessible(true);
        paramString = this.mGetter.getReturnType();
        if (typesMatch(paramClass1, paramString))
        {
          paramClass1 = new StringBuilder();
          paramClass1.append("set");
          paramClass1.append((String)localObject1);
          paramClass1 = paramClass1.toString();
        }
      }
      catch (NoSuchMethodException localNoSuchMethodException1) {}
    }
    try
    {
      paramClass = paramClass.getDeclaredMethod(paramClass1, new Class[] { paramString });
      this.mSetter = paramClass;
      paramClass.setAccessible(true);
      return;
    }
    catch (NoSuchMethodException paramClass)
    {
      return;
    }
    paramClass = new StringBuilder();
    paramClass.append("Underlying type (");
    paramClass.append(paramString);
    paramClass.append(") ");
    paramClass.append("does not match Property type (");
    paramClass.append(paramClass1);
    paramClass.append(")");
    throw new NoSuchPropertyException(paramClass.toString());
    try
    {
      paramClass = paramClass.getField(paramString);
      this.mField = paramClass;
      paramClass = paramClass.getType();
      if (typesMatch(paramClass1, paramClass)) {
        return;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Underlying type (");
      ((StringBuilder)localObject1).append(paramClass);
      ((StringBuilder)localObject1).append(") ");
      ((StringBuilder)localObject1).append("does not match Property type (");
      ((StringBuilder)localObject1).append(paramClass1);
      ((StringBuilder)localObject1).append(")");
      throw new NoSuchPropertyException(((StringBuilder)localObject1).toString());
    }
    catch (NoSuchFieldException paramClass)
    {
      for (;;) {}
    }
    paramClass = new StringBuilder();
    paramClass.append("No accessor method or field found for property with name ");
    paramClass.append(paramString);
    throw new NoSuchPropertyException(paramClass.toString());
  }
  
  private boolean typesMatch(Class<V> paramClass, Class paramClass1)
  {
    return false;
  }
  
  public V get(T paramT)
  {
    return null;
  }
  
  public boolean isReadOnly()
  {
    return false;
  }
  
  /* Error */
  public void set(T arg1, V arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\nineoldandroid\\util\ReflectiveProperty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */