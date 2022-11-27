package io.reactivex.exceptions;

import io.reactivex.internal.util.ExceptionHelper;

public final class Exceptions
{
  private Exceptions()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static RuntimeException propagate(Throwable paramThrowable)
  {
    throw ExceptionHelper.wrapOrThrow(paramThrowable);
  }
  
  public static void throwIfFatal(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof VirtualMachineError))
    {
      if (!(paramThrowable instanceof ThreadDeath))
      {
        if (!(paramThrowable instanceof LinkageError)) {
          return;
        }
        throw ((LinkageError)paramThrowable);
      }
      throw ((ThreadDeath)paramThrowable);
    }
    throw ((VirtualMachineError)paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\exceptions\Exceptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */