package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.Operator;
import dji.thirdparty.rx.Observer;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.functions.Func3;
import dji.thirdparty.rx.functions.Func4;
import dji.thirdparty.rx.functions.Func5;
import dji.thirdparty.rx.functions.Func6;
import dji.thirdparty.rx.functions.Func7;
import dji.thirdparty.rx.functions.Func8;
import dji.thirdparty.rx.functions.Func9;
import dji.thirdparty.rx.functions.FuncN;
import dji.thirdparty.rx.functions.Functions;
import dji.thirdparty.rx.internal.util.RxRingBuffer;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.concurrent.atomic.AtomicLong;

public final class OperatorZip<R>
  implements Observable.Operator<R, Observable<?>[]>
{
  final FuncN<? extends R> zipFunction;
  
  public OperatorZip(Func2 paramFunc2)
  {
    this.zipFunction = Functions.fromFunc(paramFunc2);
  }
  
  public OperatorZip(Func3 paramFunc3)
  {
    this.zipFunction = Functions.fromFunc(paramFunc3);
  }
  
  public OperatorZip(Func4 paramFunc4)
  {
    this.zipFunction = Functions.fromFunc(paramFunc4);
  }
  
  public OperatorZip(Func5 paramFunc5)
  {
    this.zipFunction = Functions.fromFunc(paramFunc5);
  }
  
  public OperatorZip(Func6 paramFunc6)
  {
    this.zipFunction = Functions.fromFunc(paramFunc6);
  }
  
  public OperatorZip(Func7 paramFunc7)
  {
    this.zipFunction = Functions.fromFunc(paramFunc7);
  }
  
  public OperatorZip(Func8 paramFunc8)
  {
    this.zipFunction = Functions.fromFunc(paramFunc8);
  }
  
  public OperatorZip(Func9 paramFunc9)
  {
    this.zipFunction = Functions.fromFunc(paramFunc9);
  }
  
  public OperatorZip(FuncN<? extends R> paramFuncN)
  {
    this.zipFunction = paramFuncN;
  }
  
  public Subscriber<? super Observable[]> call(Subscriber<? super R> paramSubscriber)
  {
    return null;
  }
  
  static final class Zip<R>
    extends AtomicLong
  {
    static final int THRESHOLD = (int)(RxRingBuffer.SIZE * 0.7D);
    private static final long serialVersionUID = 5995274816189928317L;
    final Observer<? super R> child;
    private final CompositeSubscription childSubscription;
    int emitted;
    private AtomicLong requested;
    private volatile Object[] subscribers;
    private final FuncN<? extends R> zipFunction;
    
    public Zip(Subscriber<? super R> paramSubscriber, FuncN<? extends R> paramFuncN)
    {
      CompositeSubscription localCompositeSubscription = new CompositeSubscription();
      this.childSubscription = localCompositeSubscription;
      this.emitted = 0;
      this.child = paramSubscriber;
      this.zipFunction = paramFuncN;
      paramSubscriber.add(localCompositeSubscription);
    }
    
    /* Error */
    public void start(Observable[] arg1, AtomicLong arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    void tick()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    final class InnerSubscriber
      extends Subscriber
    {
      final RxRingBuffer items = RxRingBuffer.getSpmcInstance();
      
      InnerSubscriber() {}
      
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
        OperatorZip.Zip.this.child.onError(paramThrowable);
      }
      
      /* Error */
      public void onNext(Object arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      public void onStart()
      {
        request(RxRingBuffer.SIZE);
      }
      
      public void requestMore(long paramLong)
      {
        request(paramLong);
      }
    }
  }
  
  private static final class ZipProducer<R>
    extends AtomicLong
    implements Producer
  {
    private static final long serialVersionUID = -1216676403723546796L;
    private OperatorZip.Zip<R> zipper;
    
    public ZipProducer(OperatorZip.Zip<R> paramZip)
    {
      this.zipper = paramZip;
    }
    
    public void request(long paramLong)
    {
      BackpressureUtils.getAndAddRequest(this, paramLong);
      this.zipper.tick();
    }
  }
  
  private final class ZipSubscriber
    extends Subscriber<Observable[]>
  {
    final Subscriber<? super R> child;
    final OperatorZip.ZipProducer<R> producer;
    boolean started = false;
    final OperatorZip.Zip<R> zipper;
    
    public ZipSubscriber(OperatorZip.Zip<R> paramZip, OperatorZip.ZipProducer<R> paramZipProducer)
    {
      this.child = paramZip;
      this.zipper = paramZipProducer;
      OperatorZip.ZipProducer localZipProducer;
      this.producer = localZipProducer;
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
    public void onNext(Observable[] arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorZip.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */