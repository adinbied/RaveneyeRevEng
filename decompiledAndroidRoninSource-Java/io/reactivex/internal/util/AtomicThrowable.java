package io.reactivex.internal.util;

import java.util.concurrent.atomic.AtomicReference;

public final class AtomicThrowable
  extends AtomicReference<Throwable>
{
  private static final long serialVersionUID = 3949248817947090603L;
  
  public boolean addThrowable(Throwable paramThrowable)
  {
    return ExceptionHelper.addThrowable(this, paramThrowable);
  }
  
  public boolean isTerminated()
  {
    return false;
  }
  
  public Throwable terminate()
  {
    return ExceptionHelper.terminate(this);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\AtomicThrowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */