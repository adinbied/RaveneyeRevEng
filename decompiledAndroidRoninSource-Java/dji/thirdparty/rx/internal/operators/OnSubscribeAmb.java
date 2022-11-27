package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Producer;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.functions.Action0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;

public final class OnSubscribeAmb<T>
  implements Observable.OnSubscribe<T>
{
  final Iterable<? extends Observable<? extends T>> sources;
  
  private OnSubscribeAmb(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    this.sources = paramIterable;
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    localArrayList.add(paramObservable7);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    localArrayList.add(paramObservable7);
    localArrayList.add(paramObservable8);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Observable<? extends T> paramObservable1, Observable<? extends T> paramObservable2, Observable<? extends T> paramObservable3, Observable<? extends T> paramObservable4, Observable<? extends T> paramObservable5, Observable<? extends T> paramObservable6, Observable<? extends T> paramObservable7, Observable<? extends T> paramObservable8, Observable<? extends T> paramObservable9)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(paramObservable1);
    localArrayList.add(paramObservable2);
    localArrayList.add(paramObservable3);
    localArrayList.add(paramObservable4);
    localArrayList.add(paramObservable5);
    localArrayList.add(paramObservable6);
    localArrayList.add(paramObservable7);
    localArrayList.add(paramObservable8);
    localArrayList.add(paramObservable9);
    return amb(localArrayList);
  }
  
  public static <T> Observable.OnSubscribe<T> amb(Iterable<? extends Observable<? extends T>> paramIterable)
  {
    return new OnSubscribeAmb(paramIterable);
  }
  
  static <T> void unsubscribeAmbSubscribers(Collection<AmbSubscriber<T>> paramCollection)
  {
    if (!paramCollection.isEmpty())
    {
      Iterator localIterator = paramCollection.iterator();
      while (localIterator.hasNext()) {
        ((AmbSubscriber)localIterator.next()).unsubscribe();
      }
      paramCollection.clear();
    }
  }
  
  /* Error */
  public void call(Subscriber<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static final class AmbSubscriber<T>
    extends Subscriber<T>
  {
    private boolean chosen;
    private final OnSubscribeAmb.Selection<T> selection;
    private final Subscriber<? super T> subscriber;
    
    AmbSubscriber(long paramLong, Subscriber<? super T> paramSubscriber, OnSubscribeAmb.Selection<T> paramSelection)
    {
      this.subscriber = paramSubscriber;
      this.selection = paramSelection;
      request(paramLong);
    }
    
    private boolean isSelected()
    {
      return false;
    }
    
    private void requestMore(long paramLong)
    {
      request(paramLong);
    }
    
    /* Error */
    public void onCompleted()
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
    
    /* Error */
    public void onNext(T arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  private static class Selection<T>
  {
    final Collection<OnSubscribeAmb.AmbSubscriber<T>> ambSubscribers = new ConcurrentLinkedQueue();
    final AtomicReference<OnSubscribeAmb.AmbSubscriber<T>> choice = new AtomicReference();
    
    /* Error */
    public void unsubscribeLosers()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void unsubscribeOthers(OnSubscribeAmb.AmbSubscriber<T> arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OnSubscribeAmb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */