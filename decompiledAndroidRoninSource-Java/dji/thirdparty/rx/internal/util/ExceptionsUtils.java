package dji.thirdparty.rx.internal.util;

import dji.thirdparty.rx.exceptions.CompositeException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public enum ExceptionsUtils
{
  private static final Throwable TERMINATED = new Throwable("Terminated");
  
  private ExceptionsUtils() {}
  
  public static boolean addThrowable(AtomicReference<Throwable> paramAtomicReference, Throwable paramThrowable)
  {
    Throwable localThrowable;
    Object localObject;
    do
    {
      localThrowable = (Throwable)paramAtomicReference.get();
      if (localThrowable == TERMINATED) {
        return false;
      }
      if (localThrowable == null)
      {
        localObject = paramThrowable;
      }
      else if ((localThrowable instanceof CompositeException))
      {
        localObject = new ArrayList(((CompositeException)localThrowable).getExceptions());
        ((List)localObject).add(paramThrowable);
        localObject = new CompositeException((Collection)localObject);
      }
      else
      {
        localObject = new CompositeException(new Throwable[] { localThrowable, paramThrowable });
      }
    } while (!paramAtomicReference.compareAndSet(localThrowable, localObject));
    return true;
  }
  
  public static boolean isTerminated(Throwable paramThrowable)
  {
    return paramThrowable == TERMINATED;
  }
  
  public static boolean isTerminated(AtomicReference<Throwable> paramAtomicReference)
  {
    return isTerminated((Throwable)paramAtomicReference.get());
  }
  
  public static Throwable terminate(AtomicReference<Throwable> paramAtomicReference)
  {
    Throwable localThrowable2 = (Throwable)paramAtomicReference.get();
    Throwable localThrowable3 = TERMINATED;
    Throwable localThrowable1 = localThrowable2;
    if (localThrowable2 != localThrowable3) {
      localThrowable1 = (Throwable)paramAtomicReference.getAndSet(localThrowable3);
    }
    return localThrowable1;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\interna\\util\ExceptionsUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */