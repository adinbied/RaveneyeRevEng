package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.concurrent.atomic.AtomicInteger;

public class OperatorTakeLastOne<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorTakeLastOne<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private static class Holder
  {
    static final OperatorTakeLastOne<Object> INSTANCE = new OperatorTakeLastOne();
  }
  
  private static class ParentSubscriber<T>
    extends Subscriber<T>
  {
    private static final Object ABSENT = new Object();
    private static final int NOT_REQUESTED_COMPLETED = 1;
    private static final int NOT_REQUESTED_NOT_COMPLETED = 0;
    private static final int REQUESTED_COMPLETED = 3;
    private static final int REQUESTED_NOT_COMPLETED = 2;
    private final Subscriber<? super T> child;
    private T last = ABSENT;
    private final AtomicInteger state = new AtomicInteger(0);
    
    ParentSubscriber(Subscriber<? super T> paramSubscriber)
    {
      this.child = paramSubscriber;
    }
    
    /* Error */
    private void emit()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
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
    
    public void onNext(T paramT)
    {
      this.last = paramT;
    }
    
    /* Error */
    void requestMore(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTakeLastOne.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */