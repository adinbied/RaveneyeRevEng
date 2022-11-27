package dji.thirdparty.okhttp3.internal;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class OptionalMethod<T>
{
  private final String methodName;
  private final Class[] methodParams;
  private final Class<?> returnType;
  
  public OptionalMethod(Class<?> paramClass, String paramString, Class... paramVarArgs)
  {
    this.returnType = paramClass;
    this.methodName = paramString;
    this.methodParams = paramVarArgs;
  }
  
  private Method getMethod(Class<?> paramClass)
  {
    return null;
  }
  
  private static Method getPublicMethod(Class<?> paramClass, String paramString, Class[] paramArrayOfClass)
  {
    for (;;)
    {
      try
      {
        paramClass = paramClass.getMethod(paramString, paramArrayOfClass);
      }
      catch (NoSuchMethodException paramClass)
      {
        int i;
        return null;
      }
      try
      {
        i = paramClass.getModifiers();
        if ((i & 0x1) == 0) {
          return null;
        }
      }
      catch (NoSuchMethodException paramString) {}
    }
    return paramClass;
  }
  
  public Object invoke(T paramT, Object... paramVarArgs)
    throws InvocationTargetException
  {
    return null;
  }
  
  public Object invokeOptional(T paramT, Object... paramVarArgs)
    throws InvocationTargetException
  {
    return null;
  }
  
  public Object invokeOptionalWithoutCheckedException(T paramT, Object... paramVarArgs)
  {
    return null;
  }
  
  public Object invokeWithoutCheckedException(T paramT, Object... paramVarArgs)
  {
    return null;
  }
  
  public boolean isSupported(T paramT)
  {
    return getMethod(paramT.getClass()) != null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\internal\OptionalMethod.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */