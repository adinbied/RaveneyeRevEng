package com.google.gson.internal;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public abstract class UnsafeAllocator
{
  static void assertInstantiable(Class<?> paramClass)
  {
    int i = paramClass.getModifiers();
    if (!Modifier.isInterface(i))
    {
      if (!Modifier.isAbstract(i)) {
        return;
      }
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("Abstract class can't be instantiated! Class name: ");
      localStringBuilder.append(paramClass.getName());
      throw new UnsupportedOperationException(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Interface can't be instantiated! Interface name: ");
    localStringBuilder.append(paramClass.getName());
    throw new UnsupportedOperationException(localStringBuilder.toString());
  }
  
  public static UnsafeAllocator create()
  {
    try
    {
      localObject1 = Class.forName("sun.misc.Unsafe");
      final Object localObject2 = ((Class)localObject1).getDeclaredField("theUnsafe");
      ((Field)localObject2).setAccessible(true);
      localObject2 = ((Field)localObject2).get(null);
      localObject1 = new UnsafeAllocator()
      {
        public <T> T newInstance(Class<T> paramAnonymousClass)
          throws Exception
        {
          assertInstantiable(paramAnonymousClass);
          return (T)UnsafeAllocator.this.invoke(localObject2, new Object[] { paramAnonymousClass });
        }
      };
      return (UnsafeAllocator)localObject1;
    }
    catch (Exception localException1)
    {
      Object localObject1;
      final int i;
      label133:
      label171:
      for (;;) {}
    }
    try
    {
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", new Class[] { Class.class });
      ((Method)localObject1).setAccessible(true);
      i = ((Integer)((Method)localObject1).invoke(null, new Object[] { Object.class })).intValue();
      localObject1 = ObjectStreamClass.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Integer.TYPE });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new UnsafeAllocator()
      {
        public <T> T newInstance(Class<T> paramAnonymousClass)
          throws Exception
        {
          assertInstantiable(paramAnonymousClass);
          return (T)UnsafeAllocator.this.invoke(null, new Object[] { paramAnonymousClass, Integer.valueOf(i) });
        }
      };
      return (UnsafeAllocator)localObject1;
    }
    catch (Exception localException2)
    {
      break label133;
    }
    try
    {
      localObject1 = ObjectInputStream.class.getDeclaredMethod("newInstance", new Class[] { Class.class, Class.class });
      ((Method)localObject1).setAccessible(true);
      localObject1 = new UnsafeAllocator()
      {
        public <T> T newInstance(Class<T> paramAnonymousClass)
          throws Exception
        {
          assertInstantiable(paramAnonymousClass);
          return (T)UnsafeAllocator.this.invoke(null, new Object[] { paramAnonymousClass, Object.class });
        }
      };
      return (UnsafeAllocator)localObject1;
    }
    catch (Exception localException3)
    {
      break label171;
    }
    new UnsafeAllocator()
    {
      public <T> T newInstance(Class<T> paramAnonymousClass)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Cannot allocate ");
        localStringBuilder.append(paramAnonymousClass);
        throw new UnsupportedOperationException(localStringBuilder.toString());
      }
    };
  }
  
  public abstract <T> T newInstance(Class<T> paramClass)
    throws Exception;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\internal\UnsafeAllocator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */