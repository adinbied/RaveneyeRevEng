package com.google.gson.internal.reflect;

import java.lang.reflect.AccessibleObject;

final class PreJava9ReflectionAccessor
  extends ReflectionAccessor
{
  public void makeAccessible(AccessibleObject paramAccessibleObject)
  {
    paramAccessibleObject.setAccessible(true);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\internal\reflect\PreJava9ReflectionAccessor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */