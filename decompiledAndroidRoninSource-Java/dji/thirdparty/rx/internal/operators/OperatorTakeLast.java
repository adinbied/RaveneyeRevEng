package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import java.util.Deque;

public final class OperatorTakeLast<T>
  implements Observable.Operator<T, T>
{
  final int count;
  
  public OperatorTakeLast(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.count = paramInt;
      return;
    }
    throw new IndexOutOfBoundsException("count cannot be negative");
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTakeLast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */