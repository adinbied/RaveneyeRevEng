package org.msgpack.core.buffer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

class DirectBufferAccess
{
  static Constructor byteBufferConstructor;
  static DirectBufferConstructorType directBufferConstructorType;
  static Class<?> directByteBufferClass;
  static Method mClean;
  static Method mCleaner;
  static Method mGetAddress;
  static Method memoryBlockWrapFromJni;
  
  static
  {
    for (;;)
    {
      try
      {
        localObject = ClassLoader.getSystemClassLoader().loadClass("java.nio.DirectByteBuffer");
        directByteBufferClass = (Class)localObject;
        localMethod = null;
      }
      catch (Exception localException)
      {
        Object localObject;
        Method localMethod;
        DirectBufferConstructorType localDirectBufferConstructorType;
        throw new RuntimeException(localException);
      }
      try
      {
        localObject = ((Class)localObject).getDeclaredConstructor(new Class[] { Long.TYPE, Integer.TYPE, Object.class });
        localDirectBufferConstructorType = DirectBufferConstructorType.ARGS_LONG_INT_REF;
      }
      catch (NoSuchMethodException localNoSuchMethodException1)
      {
        continue;
      }
      try
      {
        localObject = directByteBufferClass.getDeclaredConstructor(new Class[] { Long.TYPE, Integer.TYPE });
        localDirectBufferConstructorType = DirectBufferConstructorType.ARGS_LONG_INT;
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        continue;
      }
      try
      {
        localObject = directByteBufferClass.getDeclaredConstructor(new Class[] { Integer.TYPE, Integer.TYPE });
        localDirectBufferConstructorType = DirectBufferConstructorType.ARGS_INT_INT;
      }
      catch (NoSuchMethodException localNoSuchMethodException3) {}
    }
    localObject = Class.forName("java.nio.MemoryBlock");
    localMethod = ((Class)localObject).getDeclaredMethod("wrapFromJni", new Class[] { Integer.TYPE, Long.TYPE });
    localMethod.setAccessible(true);
    localObject = directByteBufferClass.getDeclaredConstructor(new Class[] { localObject, Integer.TYPE, Integer.TYPE });
    localDirectBufferConstructorType = DirectBufferConstructorType.ARGS_MB_INT_INT;
    byteBufferConstructor = (Constructor)localObject;
    directBufferConstructorType = localDirectBufferConstructorType;
    memoryBlockWrapFromJni = localMethod;
    if (localObject != null)
    {
      ((Constructor)localObject).setAccessible(true);
      localObject = directByteBufferClass.getDeclaredMethod("address", new Class[0]);
      mGetAddress = (Method)localObject;
      ((Method)localObject).setAccessible(true);
      localObject = directByteBufferClass.getDeclaredMethod("cleaner", new Class[0]);
      mCleaner = (Method)localObject;
      ((Method)localObject).setAccessible(true);
      localObject = mCleaner.getReturnType().getDeclaredMethod("clean", new Class[0]);
      mClean = (Method)localObject;
      ((Method)localObject).setAccessible(true);
      return;
    }
    throw new RuntimeException("Constructor of DirectByteBuffer is not found");
  }
  
  static void clean(Object paramObject)
  {
    try
    {
      paramObject = mCleaner.invoke(paramObject, new Object[0]);
      mClean.invoke(paramObject, new Object[0]);
      return;
    }
    finally {}
  }
  
  static long getAddress(Object paramObject)
  {
    try
    {
      long l = ((Long)mGetAddress.invoke(paramObject, new Object[0])).longValue();
      return l;
    }
    catch (InvocationTargetException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
    catch (IllegalAccessException paramObject)
    {
      throw new RuntimeException((Throwable)paramObject);
    }
  }
  
  static boolean isDirectByteBufferInstance(Object paramObject)
  {
    return directByteBufferClass.isInstance(paramObject);
  }
  
  static ByteBuffer newByteBuffer(long paramLong, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer)
  {
    try
    {
      int i = 1.$SwitchMap$org$msgpack$core$buffer$DirectBufferAccess$DirectBufferConstructorType[directBufferConstructorType.ordinal()];
      if (i != 1)
      {
        if (i != 2)
        {
          if (i != 3)
          {
            if (i == 4) {
              return (ByteBuffer)byteBufferConstructor.newInstance(new Object[] { memoryBlockWrapFromJni.invoke(null, new Object[] { Long.valueOf(paramLong + paramInt1), Integer.valueOf(paramInt2) }), Integer.valueOf(paramInt2), Integer.valueOf(0) });
            }
            throw new IllegalStateException("Unexpected value");
          }
          return (ByteBuffer)byteBufferConstructor.newInstance(new Object[] { Integer.valueOf((int)paramLong + paramInt1), Integer.valueOf(paramInt2) });
        }
        return (ByteBuffer)byteBufferConstructor.newInstance(new Object[] { Long.valueOf(paramLong + paramInt1), Integer.valueOf(paramInt2) });
      }
      paramByteBuffer = (ByteBuffer)byteBufferConstructor.newInstance(new Object[] { Long.valueOf(paramLong + paramInt1), Integer.valueOf(paramInt2), paramByteBuffer });
      return paramByteBuffer;
    }
    finally {}
  }
  
  static enum DirectBufferConstructorType
  {
    static
    {
      ARGS_LONG_INT = new DirectBufferConstructorType("ARGS_LONG_INT", 1);
      ARGS_INT_INT = new DirectBufferConstructorType("ARGS_INT_INT", 2);
      DirectBufferConstructorType localDirectBufferConstructorType = new DirectBufferConstructorType("ARGS_MB_INT_INT", 3);
      ARGS_MB_INT_INT = localDirectBufferConstructorType;
      $VALUES = new DirectBufferConstructorType[] { ARGS_LONG_INT_REF, ARGS_LONG_INT, ARGS_INT_INT, localDirectBufferConstructorType };
    }
    
    private DirectBufferConstructorType() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\core\buffer\DirectBufferAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */