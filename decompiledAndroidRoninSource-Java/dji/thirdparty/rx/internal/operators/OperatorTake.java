package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.concurrent.atomic.AtomicLong;

public final class OperatorTake<T>
  implements Observable.Operator<T, T>
{
  final int limit;
  
  public OperatorTake(int paramInt)
  {
    if (paramInt >= 0)
    {
      this.limit = paramInt;
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("limit >= 0 required but it was ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorTake.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */