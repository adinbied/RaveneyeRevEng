package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Func1;
import dji.thirdparty.rx.functions.Func2;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.HashMap;
import java.util.Map;

public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R>
  implements Observable.OnSubscribe<R>
{
  final Observable<TLeft> left;
  final Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector;
  final Func2<TLeft, TRight, R> resultSelector;
  final Observable<TRight> right;
  final Func1<TRight, Observable<TRightDuration>> rightDurationSelector;
  
  public OnSubscribeJoin(Observable<TLeft> paramObservable, Observable<TRight> paramObservable1, Func1<TLeft, Observable<TLeftDuration>> paramFunc1, Func1<TRight, Observable<TRightDuration>> paramFunc11, Func2<TLeft, TRight, R> paramFunc2)
  {
    this.left = paramObservable;
    this.right = paramObservable1;
    this.leftDurationSelector = paramFunc1;
    this.rightDurationSelector = paramFunc11;
    this.resultSelector = paramFunc2;
  }
  
  /* Error */
  public void call(Subscriber<? super R> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  final class ResultSink
  {
    final CompositeSubscription group;
    final Object guard = new Object();
    boolean leftDone;
    int leftId;
    final Map<Integer, TLeft> leftMap;
    boolean rightDone;
    int rightId;
    final Map<Integer, TRight> rightMap;
    final Subscriber<? super R> subscriber;
    
    public ResultSink()
    {
      Subscriber localSubscriber;
      this.subscriber = localSubscriber;
      this.group = new CompositeSubscription();
      this.leftMap = new HashMap();
      this.rightMap = new HashMap();
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    final class LeftSubscriber
      extends Subscriber<TLeft>
    {
      LeftSubscriber() {}
      
      /* Error */
      protected void expire(int arg1, dji.thirdparty.rx.Subscription arg2)
      {
        // Byte code:
        //   0: return
        //   1: astore_2
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
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void onNext(TLeft arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      final class LeftDurationSubscriber
        extends Subscriber<TLeftDuration>
      {
        final int id;
        boolean once = true;
        
        public LeftDurationSubscriber(int paramInt)
        {
          this.id = paramInt;
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
          OnSubscribeJoin.ResultSink.LeftSubscriber.this.onError(paramThrowable);
        }
        
        public void onNext(TLeftDuration paramTLeftDuration)
        {
          onCompleted();
        }
      }
    }
    
    final class RightSubscriber
      extends Subscriber<TRight>
    {
      RightSubscriber() {}
      
      /* Error */
      void expire(int arg1, dji.thirdparty.rx.Subscription arg2)
      {
        // Byte code:
        //   0: return
        //   1: astore_2
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
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void onNext(TRight arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      final class RightDurationSubscriber
        extends Subscriber<TRightDuration>
      {
        final int id;
        boolean once = true;
        
        public RightDurationSubscriber(int paramInt)
        {
          this.id = paramInt;
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
          OnSubscribeJoin.ResultSink.RightSubscriber.this.onError(paramThrowable);
        }
        
        public void onNext(TRightDuration paramTRightDuration)
        {
          onCompleted();
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeJoin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */