package org.junit.internal;

public class Classes
{
  public static Class<?> getClass(String paramString)
    throws ClassNotFoundException
  {
    return Class.forName(paramString, true, Thread.currentThread().getContextClassLoader());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\Classes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */