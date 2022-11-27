package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiPredicate;
import io.reactivex.internal.disposables.ArrayCompositeDisposable;
import io.reactivex.internal.fuseable.FuseToObservable;
import io.reactivex.internal.queue.SpscLinkedArrayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class ObservableSequenceEqualSingle<T>
  extends Single<Boolean>
  implements FuseToObservable<Boolean>
{
  final int bufferSize;
  final BiPredicate<? super T, ? super T> comparer;
  final ObservableSource<? extends T> first;
  final ObservableSource<? extends T> second;
  
  public ObservableSequenceEqualSingle(ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, BiPredicate<? super T, ? super T> paramBiPredicate, int paramInt)
  {
    this.first = paramObservableSource1;
    this.second = paramObservableSource2;
    this.comparer = paramBiPredicate;
    this.bufferSize = paramInt;
  }
  
  public Observable<Boolean> fuseToObservable()
  {
    return null;
  }
  
  /* Error */
  public void subscribeActual(SingleObserver<? super Boolean> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class EqualCoordinator<T>
    extends AtomicInteger
    implements Disposable
  {
    private static final long serialVersionUID = -6178010334400373240L;
    volatile boolean cancelled;
    final BiPredicate<? super T, ? super T> comparer;
    final SingleObserver<? super Boolean> downstream;
    final ObservableSource<? extends T> first;
    final ObservableSequenceEqualSingle.EqualObserver<T>[] observers;
    final ArrayCompositeDisposable resources;
    final ObservableSource<? extends T> second;
    T v1;
    T v2;
    
    EqualCoordinator(SingleObserver<? super Boolean> paramSingleObserver, int paramInt, ObservableSource<? extends T> paramObservableSource1, ObservableSource<? extends T> paramObservableSource2, BiPredicate<? super T, ? super T> paramBiPredicate)
    {
      this.downstream = paramSingleObserver;
      this.first = paramObservableSource1;
      this.second = paramObservableSource2;
      this.comparer = paramBiPredicate;
      paramSingleObserver = new ObservableSequenceEqualSingle.EqualObserver[2];
      this.observers = paramSingleObserver;
      paramSingleObserver[0] = new ObservableSequenceEqualSingle.EqualObserver(this, 0, paramInt);
      paramSingleObserver[1] = new ObservableSequenceEqualSingle.EqualObserver(this, 1, paramInt);
      this.resources = new ArrayCompositeDisposable(2);
    }
    
    /* Error */
    void cancel(SpscLinkedArrayQueue<T> arg1, SpscLinkedArrayQueue<T> arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void drain()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    public boolean isDisposed()
    {
      return this.cancelled;
    }
    
    boolean setDisposable(Disposable paramDisposable, int paramInt)
    {
      return this.resources.setResource(paramInt, paramDisposable);
    }
    
    /* Error */
    void subscribe()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class EqualObserver<T>
    implements Observer<T>
  {
    volatile boolean done;
    Throwable error;
    final int index;
    final ObservableSequenceEqualSingle.EqualCoordinator<T> parent;
    final SpscLinkedArrayQueue<T> queue;
    
    EqualObserver(ObservableSequenceEqualSingle.EqualCoordinator<T> paramEqualCoordinator, int paramInt1, int paramInt2)
    {
      this.parent = paramEqualCoordinator;
      this.index = paramInt1;
      this.queue = new SpscLinkedArrayQueue(paramInt2);
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.error = paramThrowable;
      this.done = true;
      this.parent.drain();
    }
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.parent.setDisposable(paramDisposable, this.index);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSequenceEqualSingle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */