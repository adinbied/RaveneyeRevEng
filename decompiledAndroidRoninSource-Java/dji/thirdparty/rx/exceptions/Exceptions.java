package dji.thirdparty.rx.exceptions;

import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.SingleSubscriber;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class Exceptions
{
  private static final int MAX_DEPTH = 25;
  
  private Exceptions()
  {
    throw new IllegalStateException("No instances!");
  }
  
  public static void addCause(Throwable paramThrowable1, Throwable paramThrowable2)
  {
    HashSet localHashSet = new HashSet();
    int i = 0;
    Throwable localThrowable;
    for (;;)
    {
      localThrowable = paramThrowable1;
      if (paramThrowable1.getCause() == null) {
        break;
      }
      if (i >= 25) {
        return;
      }
      paramThrowable1 = paramThrowable1.getCause();
      if (localHashSet.contains(paramThrowable1.getCause()))
      {
        localThrowable = paramThrowable1;
        break;
      }
      localHashSet.add(paramThrowable1.getCause());
      i += 1;
    }
    try
    {
      localThrowable.initCause(paramThrowable2);
      return;
    }
    finally {}
  }
  
  public static Throwable getFinalCause(Throwable paramThrowable)
  {
    int i = 0;
    while (paramThrowable.getCause() != null)
    {
      if (i >= 25) {
        return new RuntimeException("Stack too deep to get final cause");
      }
      paramThrowable = paramThrowable.getCause();
      i += 1;
    }
    return paramThrowable;
  }
  
  public static RuntimeException propagate(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof RuntimeException))
    {
      if ((paramThrowable instanceof Error)) {
        throw ((Error)paramThrowable);
      }
      throw new RuntimeException(paramThrowable);
    }
    throw ((RuntimeException)paramThrowable);
  }
  
  public static void throwIfAny(List<? extends Throwable> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      if (paramList.size() == 1)
      {
        paramList = (Throwable)paramList.get(0);
        if (!(paramList instanceof RuntimeException))
        {
          if ((paramList instanceof Error)) {
            throw ((Error)paramList);
          }
          throw new RuntimeException(paramList);
        }
        throw ((RuntimeException)paramList);
      }
      throw new CompositeException("Multiple exceptions", paramList);
    }
  }
  
  public static void throwIfFatal(Throwable paramThrowable)
  {
    if (!(paramThrowable instanceof OnErrorNotImplementedException))
    {
      if (!(paramThrowable instanceof OnErrorFailedException))
      {
        if (!(paramThrowable instanceof StackOverflowError))
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
        throw ((StackOverflowError)paramThrowable);
      }
      throw ((OnErrorFailedException)paramThrowable);
    }
    throw ((OnErrorNotImplementedException)paramThrowable);
  }
  
  public static void throwOrReport(Throwable paramThrowable, Observer<?> paramObserver)
  {
    throwIfFatal(paramThrowable);
    paramObserver.onError(paramThrowable);
  }
  
  public static void throwOrReport(Throwable paramThrowable, Observer<?> paramObserver, Object paramObject)
  {
    throwIfFatal(paramThrowable);
    paramObserver.onError(OnErrorThrowable.addValueAsLastCause(paramThrowable, paramObject));
  }
  
  public static void throwOrReport(Throwable paramThrowable, SingleSubscriber<?> paramSingleSubscriber)
  {
    throwIfFatal(paramThrowable);
    paramSingleSubscriber.onError(paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\exceptions\Exceptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */