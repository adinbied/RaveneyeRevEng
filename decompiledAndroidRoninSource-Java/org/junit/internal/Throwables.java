package org.junit.internal;

public final class Throwables
{
  private static <T extends Throwable> void rethrow(Throwable paramThrowable)
    throws Throwable
  {
    throw paramThrowable;
  }
  
  public static Exception rethrowAsException(Throwable paramThrowable)
    throws Exception
  {
    rethrow(paramThrowable);
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\junit\internal\Throwables.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */