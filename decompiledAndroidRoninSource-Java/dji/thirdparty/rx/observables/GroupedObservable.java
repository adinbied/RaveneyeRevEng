package dji.thirdparty.rx.observables;

import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Observable.OnSubscribe;
import dji.thirdparty.rx.Subscriber;

public class GroupedObservable<K, T>
  extends Observable<T>
{
  private final K key;
  
  protected GroupedObservable(K paramK, Observable.OnSubscribe<T> paramOnSubscribe)
  {
    super(paramOnSubscribe);
    this.key = paramK;
  }
  
  public static <K, T> GroupedObservable<K, T> create(K paramK, Observable.OnSubscribe<T> paramOnSubscribe)
  {
    return new GroupedObservable(paramK, paramOnSubscribe);
  }
  
  public static <K, T> GroupedObservable<K, T> from(K paramK, Observable<T> paramObservable)
  {
    new GroupedObservable(paramK, new Observable.OnSubscribe()
    {
      public void call(Subscriber<? super T> paramAnonymousSubscriber)
      {
        this.val$o.unsafeSubscribe(paramAnonymousSubscriber);
      }
    });
  }
  
  public K getKey()
  {
    return (K)this.key;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\observables\GroupedObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */