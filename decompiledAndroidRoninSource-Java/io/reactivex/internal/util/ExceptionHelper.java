package io.reactivex.internal.util;

import io.reactivex.exceptions.CompositeException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ExceptionHelper
{
  public static final Throwable TERMINATED = new Termination();
  
  private ExceptionHelper()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static <T> boolean addThrowable(AtomicReference<Throwable> paramAtomicReference, Throwable paramThrowable)
  {
    Throwable localThrowable;
    Object localObject;
    do
    {
      localThrowable = (Throwable)paramAtomicReference.get();
      if (localThrowable == TERMINATED) {
        return false;
      }
      if (localThrowable == null) {
        localObject = paramThrowable;
      } else {
        localObject = new CompositeException(new Throwable[] { localThrowable, paramThrowable });
      }
    } while (!paramAtomicReference.compareAndSet(localThrowable, localObject));
    return true;
  }
  
  public static List<Throwable> flatten(Throwable paramThrowable)
  {
    ArrayList localArrayList = new ArrayList();
    ArrayDeque localArrayDeque = new ArrayDeque();
    localArrayDeque.offer(paramThrowable);
    while (!localArrayDeque.isEmpty())
    {
      paramThrowable = (Throwable)localArrayDeque.removeFirst();
      if ((paramThrowable instanceof CompositeException))
      {
        paramThrowable = ((CompositeException)paramThrowable).getExceptions();
        int i = paramThrowable.size() - 1;
        while (i >= 0)
        {
          localArrayDeque.offerFirst(paramThrowable.get(i));
          i -= 1;
        }
      }
      else
      {
        localArrayList.add(paramThrowable);
      }
    }
    return localArrayList;
  }
  
  public static <T> Throwable terminate(AtomicReference<Throwable> paramAtomicReference)
  {
    Throwable localThrowable2 = (Throwable)paramAtomicReference.get();
    Throwable localThrowable3 = TERMINATED;
    Throwable localThrowable1 = localThrowable2;
    if (localThrowable2 != localThrowable3) {
      localThrowable1 = (Throwable)paramAtomicReference.getAndSet(localThrowable3);
    }
    return localThrowable1;
  }
  
  public static <E extends Throwable> Exception throwIfThrowable(Throwable paramThrowable)
    throws Throwable
  {
    if ((paramThrowable instanceof Exception)) {
      return (Exception)paramThrowable;
    }
    throw paramThrowable;
  }
  
  public static String timeoutMessage(long paramLong, TimeUnit paramTimeUnit)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("The source did not signal an event for ");
    localStringBuilder.append(paramLong);
    localStringBuilder.append(" ");
    localStringBuilder.append(paramTimeUnit.toString().toLowerCase());
    localStringBuilder.append(" and has been terminated.");
    return localStringBuilder.toString();
  }
  
  public static RuntimeException wrapOrThrow(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof Error))
    {
      if ((paramThrowable instanceof RuntimeException)) {
        return (RuntimeException)paramThrowable;
      }
      return new RuntimeException(paramThrowable);
    }
    throw ((Error)paramThrowable);
  }
  
  static final class Termination
    extends Throwable
  {
    private static final long serialVersionUID = -4649703670690200604L;
    
    Termination()
    {
      super();
    }
    
    public Throwable fillInStackTrace()
    {
      return this;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\interna\\util\ExceptionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */