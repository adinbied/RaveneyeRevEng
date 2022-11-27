package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action1;
import java.util.concurrent.atomic.AtomicLong;

public class OperatorOnBackpressureDrop<T>
  implements Observable.Operator<T, T>
{
  final Action1<? super T> onDrop;
  
  OperatorOnBackpressureDrop()
  {
    this(null);
  }
  
  public OperatorOnBackpressureDrop(Action1<? super T> paramAction1)
  {
    this.onDrop = paramAction1;
  }
  
  public static <T> OperatorOnBackpressureDrop<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private static final class Holder
  {
    static final OperatorOnBackpressureDrop<Object> INSTANCE = new OperatorOnBackpressureDrop();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorOnBackpressureDrop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */