package dji.thirdparty.rx.observables;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action1;

public abstract class ConnectableObservable<T>
  extends Observable<T>
{
  protected ConnectableObservable(Observable.OnSubscribe<T> paramOnSubscribe)
  {
    super(paramOnSubscribe);
  }
  
  public Observable<T> autoConnect()
  {
    return autoConnect(1);
  }
  
  public Observable<T> autoConnect(int paramInt)
  {
    return null;
  }
  
  public Observable<T> autoConnect(int paramInt, Action1<? super Subscription> paramAction1)
  {
    return null;
  }
  
  public final Subscription connect()
  {
    return null;
  }
  
  public abstract void connect(Action1<? super Subscription> paramAction1);
  
  public Observable<T> refCount()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\observables\ConnectableObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */