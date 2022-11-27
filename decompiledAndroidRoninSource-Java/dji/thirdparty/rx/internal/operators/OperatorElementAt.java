package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import java.util.concurrent.atomic.AtomicBoolean;

public final class OperatorElementAt<T>
  implements Observable.Operator<T, T>
{
  final T defaultValue;
  final boolean hasDefault;
  final int index;
  
  public OperatorElementAt(int paramInt)
  {
    this(paramInt, null, false);
  }
  
  public OperatorElementAt(int paramInt, T paramT)
  {
    this(paramInt, paramT, true);
  }
  
  private OperatorElementAt(int paramInt, T paramT, boolean paramBoolean)
  {
    if (paramInt >= 0)
    {
      this.index = paramInt;
      this.defaultValue = paramT;
      this.hasDefault = paramBoolean;
      return;
    }
    paramT = new StringBuilder();
    paramT.append(paramInt);
    paramT.append(" is out of bounds");
    throw new IndexOutOfBoundsException(paramT.toString());
  }
  
  public Subscriber<? super T> call(Subscriber<? super T> paramSubscriber)
  {
    return null;
  }
  
  static class InnerProducer
    extends AtomicBoolean
    implements Producer
  {
    private static final long serialVersionUID = 1L;
    final Producer actual;
    
    public InnerProducer(Producer paramProducer)
    {
      this.actual = paramProducer;
    }
    
    /* Error */
    public void request(long arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorElementAt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */