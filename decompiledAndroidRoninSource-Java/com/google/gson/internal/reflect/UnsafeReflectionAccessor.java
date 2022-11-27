package com.google.gson.internal.reflect;

import com.google.gson.JsonIOException;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

final class UnsafeReflectionAccessor
  extends ReflectionAccessor
{
  private static Class unsafeClass;
  private final Field overrideField = getOverrideField();
  private final Object theUnsafe = getUnsafeInstance();
  
  private static Field getOverrideField()
  {
    try
    {
      Field localField = AccessibleObject.class.getDeclaredField("override");
      return localField;
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;) {}
    }
    return null;
  }
  
  private static Object getUnsafeInstance()
  {
    try
    {
      Object localObject = Class.forName("sun.misc.Unsafe");
      unsafeClass = (Class)localObject;
      localObject = ((Class)localObject).getDeclaredField("theUnsafe");
      ((Field)localObject).setAccessible(true);
      localObject = ((Field)localObject).get(null);
      return localObject;
    }
    catch (Exception localException) {}
    return null;
  }
  
  public void makeAccessible(AccessibleObject paramAccessibleObject)
  {
    if (!makeAccessibleWithUnsafe(paramAccessibleObject)) {
      try
      {
        paramAccessibleObject.setAccessible(true);
        return;
      }
      catch (SecurityException localSecurityException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Gson couldn't modify fields for ");
        localStringBuilder.append(paramAccessibleObject);
        localStringBuilder.append("\nand sun.misc.Unsafe not found.\nEither write a custom type adapter, or make fields accessible, or include sun.misc.Unsafe.");
        throw new JsonIOException(localStringBuilder.toString(), localSecurityException);
      }
    }
  }
  
  boolean makeAccessibleWithUnsafe(AccessibleObject paramAccessibleObject)
  {
    if ((this.theUnsafe != null) && (this.overrideField != null)) {}
    try
    {
      long l = ((Long)unsafeClass.getMethod("objectFieldOffset", new Class[] { Field.class }).invoke(this.theUnsafe, new Object[] { this.overrideField })).longValue();
      unsafeClass.getMethod("putBoolean", new Class[] { Object.class, Long.TYPE, Boolean.TYPE }).invoke(this.theUnsafe, new Object[] { paramAccessibleObject, Long.valueOf(l), Boolean.valueOf(true) });
      return true;
    }
    catch (Exception paramAccessibleObject) {}
    return false;
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\internal\reflect\UnsafeReflectionAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */