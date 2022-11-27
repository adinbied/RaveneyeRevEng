package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func0;
import java.util.ArrayList;
import java.util.List;

public final class OperatorBufferWithSingleObservable<T, TClosing>
  implements Observable.Operator<List<T>, T>
{
  final Func0<? extends Observable<? extends TClosing>> bufferClosingSelector;
  final int initialCapacity;
  
  public OperatorBufferWithSingleObservable(final Observable<? extends TClosing> paramObservable, int paramInt)
  {
    this.bufferClosingSelector = new Func0()
    {
      public Observable<? extends TClosing> call()
      {
        return paramObservable;
      }
    };
    this.initialCapacity = paramInt;
  }
  
  public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> paramFunc0, int paramInt)
  {
    this.bufferClosingSelector = paramFunc0;
    this.initialCapacity = paramInt;
  }
  
  public Subscriber<? super T> call(Subscriber<? super List<T>> paramSubscriber)
  {
    return null;
  }
  
  final class BufferingSubscriber
    extends Subscriber<T>
  {
    final Subscriber<? super List<T>> child;
    List<T> chunk;
    boolean done;
    
    public BufferingSubscriber()
    {
      Subscriber localSubscriber;
      this.child = localSubscriber;
      this.chunk = new ArrayList(OperatorBufferWithSingleObservable.this.initialCapacity);
    }
    
    /* Error */
    void emit()
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
      //   2: return
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorBufferWithSingleObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */