package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.concurrent.atomic.AtomicBoolean;

public final class OperatorSingle<T>
  implements Observable.Operator<T, T>
{
  private final T defaultValue;
  private final boolean hasDefaultValue;
  
  OperatorSingle()
  {
    this(false, null);
  }
  
  public OperatorSingle(T paramT)
  {
    this(true, paramT);
  }
  
  private OperatorSingle(boolean paramBoolean, T paramT)
  {
    this.hasDefaultValue = paramBoolean;
    this.defaultValue = paramT;
  }
  
  public static <T> OperatorSingle<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private static class Holder
  {
    static final OperatorSingle<?> INSTANCE = new OperatorSingle();
  }
  
  private static final class ParentSubscriber<T>
    extends Subscriber<T>
  {
    private final Subscriber<? super T> child;
    private final T defaultValue;
    private final boolean hasDefaultValue;
    private boolean hasTooManyElements = false;
    private boolean isNonEmpty = false;
    private T value;
    
    ParentSubscriber(Subscriber<? super T> paramSubscriber, boolean paramBoolean, T paramT)
    {
      this.child = paramSubscriber;
      this.hasDefaultValue = paramBoolean;
      this.defaultValue = paramT;
    }
    
    /* Error */
    public void onCompleted()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.child.onError(paramThrowable);
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    void requestMore(long paramLong)
    {
      request(paramLong);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */