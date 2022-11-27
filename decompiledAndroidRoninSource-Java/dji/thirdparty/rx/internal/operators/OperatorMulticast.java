package dji.thirdparty.rx.internal.operators;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Subscriber;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action0;
import dji.thirdparty.rx.functions.Func0;
import dji.thirdparty.rx.observables.ConnectableObservable;
import dji.thirdparty.rx.subjects.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class OperatorMulticast<T, R>
  extends ConnectableObservable<R>
{
  final AtomicReference<Subject<? super T, ? extends R>> connectedSubject;
  final Object guard;
  Subscription guardedSubscription;
  final Observable<? extends T> source;
  final Func0<? extends Subject<? super T, ? extends R>> subjectFactory;
  Subscriber<T> subscription;
  final List<Subscriber<? super R>> waitingForConnect;
  
  public OperatorMulticast(Observable<? extends T> paramObservable, Func0<? extends Subject<? super T, ? extends R>> paramFunc0)
  {
    this(new Object(), new AtomicReference(), new ArrayList(), paramObservable, paramFunc0);
  }
  
  private OperatorMulticast(Object paramObject, final AtomicReference<Subject<? super T, ? extends R>> paramAtomicReference, final List<Subscriber<? super R>> paramList, Observable<? extends T> paramObservable, Func0<? extends Subject<? super T, ? extends R>> paramFunc0)
  {
    super(new Observable.OnSubscribe()
    {
      /* Error */
      public void call(Subscriber<? super R> arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
    });
    this.guard = paramObject;
    this.connectedSubject = paramAtomicReference;
    this.waitingForConnect = paramList;
    this.source = paramObservable;
    this.subjectFactory = paramFunc0;
  }
  
  /* Error */
  public void connect(dji.thirdparty.rx.functions.Action1<? super Subscription> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\internal\operators\OperatorMulticast.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */