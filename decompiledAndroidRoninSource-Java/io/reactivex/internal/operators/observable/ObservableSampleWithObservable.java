package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableSampleWithObservable<T>
  extends AbstractObservableWithUpstream<T, T>
{
  final boolean emitLast;
  final ObservableSource<?> other;
  
  public ObservableSampleWithObservable(ObservableSource<T> paramObservableSource, ObservableSource<?> paramObservableSource1, boolean paramBoolean)
  {
    super(paramObservableSource);
    this.other = paramObservableSource1;
    this.emitLast = paramBoolean;
  }
  
  /* Error */
  public void subscribeActual(Observer<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  static final class SampleMainEmitLast<T>
    extends ObservableSampleWithObservable.SampleMainObserver<T>
  {
    private static final long serialVersionUID = -3029755663834015785L;
    volatile boolean done;
    final AtomicInteger wip = new AtomicInteger();
    
    SampleMainEmitLast(Observer<? super T> paramObserver, ObservableSource<?> paramObservableSource)
    {
      super(paramObservableSource);
    }
    
    /* Error */
    void completion()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  static final class SampleMainNoLast<T>
    extends ObservableSampleWithObservable.SampleMainObserver<T>
  {
    private static final long serialVersionUID = -3029755663834015785L;
    
    SampleMainNoLast(Observer<? super T> paramObserver, ObservableSource<?> paramObservableSource)
    {
      super(paramObservableSource);
    }
    
    void completion()
    {
      this.downstream.onComplete();
    }
    
    void run()
    {
      emit();
    }
  }
  
  static abstract class SampleMainObserver<T>
    extends AtomicReference<T>
    implements Observer<T>, Disposable
  {
    private static final long serialVersionUID = -3517602651313910099L;
    final Observer<? super T> downstream;
    final AtomicReference<Disposable> other = new AtomicReference();
    final ObservableSource<?> sampler;
    Disposable upstream;
    
    SampleMainObserver(Observer<? super T> paramObserver, ObservableSource<?> paramObservableSource)
    {
      this.downstream = paramObserver;
      this.sampler = paramObservableSource;
    }
    
    /* Error */
    public void complete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    abstract void completion();
    
    /* Error */
    public void dispose()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void emit()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void error(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public boolean isDisposed()
    {
      return false;
    }
    
    /* Error */
    public void onComplete()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onError(Throwable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onNext(T paramT)
    {
      lazySet(paramT);
    }
    
    /* Error */
    public void onSubscribe(Disposable arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    abstract void run();
    
    boolean setOther(Disposable paramDisposable)
    {
      return DisposableHelper.setOnce(this.other, paramDisposable);
    }
  }
  
  static final class SamplerObserver<T>
    implements Observer<Object>
  {
    final ObservableSampleWithObservable.SampleMainObserver<T> parent;
    
    SamplerObserver(ObservableSampleWithObservable.SampleMainObserver<T> paramSampleMainObserver)
    {
      this.parent = paramSampleMainObserver;
    }
    
    public void onComplete()
    {
      this.parent.complete();
    }
    
    public void onError(Throwable paramThrowable)
    {
      this.parent.error(paramThrowable);
    }
    
    public void onNext(Object paramObject)
    {
      this.parent.run();
    }
    
    public void onSubscribe(Disposable paramDisposable)
    {
      this.parent.setOther(paramDisposable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\observable\ObservableSampleWithObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */