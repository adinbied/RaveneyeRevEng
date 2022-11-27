package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;

public final class OperatorSerialize<T>
  implements Observable.Operator<T, T>
{
  public static <T> OperatorSerialize<T> instance()
  {
    return Holder.INSTANCE;
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  private static final class Holder
  {
    static final OperatorSerialize<Object> INSTANCE = new OperatorSerialize();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorSerialize.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */