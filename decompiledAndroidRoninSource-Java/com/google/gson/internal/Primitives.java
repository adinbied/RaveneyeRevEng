package com.google.gson.internal;

import java.lang.reflect.Type;

public final class Primitives
{
  public static boolean isPrimitive(Type paramType)
  {
    return ((paramType instanceof Class)) && (((Class)paramType).isPrimitive());
  }
  
  public static boolean isWrapperType(Type paramType)
  {
    return (paramType == Integer.class) || (paramType == Float.class) || (paramType == Byte.class) || (paramType == Double.class) || (paramType == Long.class) || (paramType == Character.class) || (paramType == Boolean.class) || (paramType == Short.class) || (paramType == Void.class);
  }
  
  public static <T> Class<T> unwrap(Class<T> paramClass)
  {
    if (paramClass == Integer.class) {
      return Integer.TYPE;
    }
    if (paramClass == Float.class) {
      return Float.TYPE;
    }
    if (paramClass == Byte.class) {
      return Byte.TYPE;
    }
    if (paramClass == Double.class) {
      return Double.TYPE;
    }
    if (paramClass == Long.class) {
      return Long.TYPE;
    }
    if (paramClass == Character.class) {
      return Character.TYPE;
    }
    if (paramClass == Boolean.class) {
      return Boolean.TYPE;
    }
    if (paramClass == Short.class) {
      return Short.TYPE;
    }
    Object localObject = paramClass;
    if (paramClass == Void.class) {
      localObject = Void.TYPE;
    }
    return (Class<T>)localObject;
  }
  
  public static <T> Class<T> wrap(Class<T> paramClass)
  {
    if (paramClass == Integer.TYPE) {
      return Integer.class;
    }
    if (paramClass == Float.TYPE) {
      return Float.class;
    }
    if (paramClass == Byte.TYPE) {
      return Byte.class;
    }
    if (paramClass == Double.TYPE) {
      return Double.class;
    }
    if (paramClass == Long.TYPE) {
      return Long.class;
    }
    if (paramClass == Character.TYPE) {
      return Character.class;
    }
    if (paramClass == Boolean.TYPE) {
      return Boolean.class;
    }
    if (paramClass == Short.TYPE) {
      return Short.class;
    }
    Object localObject = paramClass;
    if (paramClass == Void.TYPE) {
      localObject = Void.class;
    }
    return (Class<T>)localObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\internal\Primitives.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */