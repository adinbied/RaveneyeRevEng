package com.xiaomi.push;

import android.util.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ba
{
  private static final Map<Class<?>, Class<?>> a;
  
  static
  {
    HashMap localHashMap = new HashMap();
    a = localHashMap;
    localHashMap.put(Boolean.class, Boolean.TYPE);
    a.put(Byte.class, Byte.TYPE);
    a.put(Character.class, Character.TYPE);
    a.put(Short.class, Short.TYPE);
    a.put(Integer.class, Integer.TYPE);
    a.put(Float.class, Float.TYPE);
    a.put(Long.class, Long.TYPE);
    a.put(Double.class, Double.TYPE);
    a.put(Boolean.TYPE, Boolean.TYPE);
    a.put(Byte.TYPE, Byte.TYPE);
    a.put(Character.TYPE, Character.TYPE);
    a.put(Short.TYPE, Short.TYPE);
    a.put(Integer.TYPE, Integer.TYPE);
    a.put(Float.TYPE, Float.TYPE);
    a.put(Long.TYPE, Long.TYPE);
    a.put(Double.TYPE, Double.TYPE);
  }
  
  public static <T> T a(Class<? extends Object> paramClass, Object paramObject, String paramString)
  {
    Field localField = null;
    Object localObject = paramClass;
    paramClass = localField;
    label8:
    while (paramClass == null) {}
    try
    {
      localField = ((Class)localObject).getDeclaredField(paramString);
      paramClass = localField;
      localField.setAccessible(true);
      paramClass = localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    localObject = ((Class)localObject).getSuperclass();
    if (localObject != null) {
      break label8;
    }
    throw new NoSuchFieldException();
    paramClass.setAccessible(true);
    return (T)paramClass.get(paramObject);
  }
  
  public static <T> T a(Class<? extends Object> paramClass, String paramString)
  {
    try
    {
      paramClass = a(paramClass, null, paramString);
      return paramClass;
    }
    catch (IllegalAccessException paramClass)
    {
      paramClass.printStackTrace();
      return null;
    }
    catch (NoSuchFieldException paramClass)
    {
      paramClass.printStackTrace();
    }
    return null;
  }
  
  public static <T> T a(Class<?> paramClass, String paramString, Object... paramVarArgs)
  {
    return (T)a(paramClass, paramString, a(paramVarArgs)).invoke(null, a(paramVarArgs));
  }
  
  public static <T> T a(Object paramObject, String paramString)
  {
    try
    {
      paramObject = a(paramObject.getClass(), paramObject, paramString);
      return (T)paramObject;
    }
    catch (IllegalAccessException paramObject)
    {
      ((IllegalAccessException)paramObject).printStackTrace();
    }
    catch (NoSuchFieldException paramObject)
    {
      ((NoSuchFieldException)paramObject).printStackTrace();
    }
    return null;
  }
  
  public static <T> T a(Object paramObject, String paramString, Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = b(paramObject, paramString, paramVarArgs);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Meet exception when call Method '");
      localStringBuilder.append(paramString);
      localStringBuilder.append("' in ");
      localStringBuilder.append(paramObject);
      Log.w("JavaCalls", localStringBuilder.toString(), paramVarArgs);
    }
    return null;
  }
  
  public static <T> T a(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = a(t.a(null, paramString1), null, paramString2);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (IllegalAccessException paramString1)
    {
      paramString1.printStackTrace();
      return null;
    }
    catch (NoSuchFieldException paramString1)
    {
      paramString1.printStackTrace();
    }
    return null;
  }
  
  public static <T> T a(String paramString1, String paramString2, Object... paramVarArgs)
  {
    try
    {
      paramVarArgs = a(t.a(null, paramString1), paramString2, paramVarArgs);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Meet exception when call Method '");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("' in ");
      localStringBuilder.append(paramString1);
      Log.w("JavaCalls", localStringBuilder.toString(), paramVarArgs);
    }
    return null;
  }
  
  private static Method a(Class<?> paramClass, String paramString, Class<?>... paramVarArgs)
  {
    Method localMethod = a(paramClass.getDeclaredMethods(), paramString, paramVarArgs);
    if (localMethod == null)
    {
      if (paramClass.getSuperclass() != null) {
        return a(paramClass.getSuperclass(), paramString, paramVarArgs);
      }
      throw new NoSuchMethodException();
    }
    localMethod.setAccessible(true);
    return localMethod;
  }
  
  private static Method a(Method[] paramArrayOfMethod, String paramString, Class<?>[] paramArrayOfClass)
  {
    if (paramString != null)
    {
      int j = paramArrayOfMethod.length;
      int i = 0;
      while (i < j)
      {
        Method localMethod = paramArrayOfMethod[i];
        if ((localMethod.getName().equals(paramString)) && (a(localMethod.getParameterTypes(), paramArrayOfClass))) {
          return localMethod;
        }
        i += 1;
      }
      return null;
    }
    throw new NullPointerException("Method name must not be null.");
  }
  
  private static boolean a(Class<?>[] paramArrayOfClass1, Class<?>[] paramArrayOfClass2)
  {
    boolean bool = true;
    if (paramArrayOfClass1 == null)
    {
      if (paramArrayOfClass2 != null)
      {
        if (paramArrayOfClass2.length == 0) {
          return true;
        }
        bool = false;
      }
      return bool;
    }
    if (paramArrayOfClass2 == null) {
      return paramArrayOfClass1.length == 0;
    }
    if (paramArrayOfClass1.length != paramArrayOfClass2.length) {
      return false;
    }
    int i = 0;
    while (i < paramArrayOfClass1.length)
    {
      if ((paramArrayOfClass2[i] != null) && (!paramArrayOfClass1[i].isAssignableFrom(paramArrayOfClass2[i])) && ((!a.containsKey(paramArrayOfClass1[i])) || (!((Class)a.get(paramArrayOfClass1[i])).equals(a.get(paramArrayOfClass2[i]))))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  private static Class<?>[] a(Object... paramVarArgs)
  {
    Class[] arrayOfClass = null;
    Object localObject = arrayOfClass;
    if (paramVarArgs != null)
    {
      localObject = arrayOfClass;
      if (paramVarArgs.length > 0)
      {
        arrayOfClass = new Class[paramVarArgs.length];
        int i = 0;
        while (i < paramVarArgs.length)
        {
          localObject = paramVarArgs[i];
          if ((localObject != null) && ((localObject instanceof a)))
          {
            arrayOfClass[i] = ((a)localObject).jdField_a_of_type_JavaLangClass;
          }
          else
          {
            if (localObject == null) {
              localObject = null;
            } else {
              localObject = localObject.getClass();
            }
            arrayOfClass[i] = localObject;
          }
          i += 1;
        }
        localObject = arrayOfClass;
      }
    }
    return (Class<?>[])localObject;
  }
  
  private static Object[] a(Object... paramVarArgs)
  {
    if ((paramVarArgs != null) && (paramVarArgs.length > 0))
    {
      Object[] arrayOfObject = new Object[paramVarArgs.length];
      int i = 0;
      for (;;)
      {
        localObject = arrayOfObject;
        if (i >= paramVarArgs.length) {
          break;
        }
        localObject = paramVarArgs[i];
        if ((localObject != null) && ((localObject instanceof a))) {
          arrayOfObject[i] = ((a)localObject).jdField_a_of_type_JavaLangObject;
        } else {
          arrayOfObject[i] = localObject;
        }
        i += 1;
      }
    }
    Object localObject = null;
    return (Object[])localObject;
  }
  
  public static <T> T b(Object paramObject, String paramString, Object... paramVarArgs)
  {
    return (T)a(paramObject.getClass(), paramString, a(paramVarArgs)).invoke(paramObject, a(paramVarArgs));
  }
  
  public static class a<T>
  {
    public final Class<? extends T> a;
    public final T a;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\ba.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */