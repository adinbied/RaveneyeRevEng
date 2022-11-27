package io.reactivex.observables;

import io.reactivex.Observable;

public abstract class GroupedObservable<K, T>
  extends Observable<T>
{
  final K key;
  
  protected GroupedObservable(K paramK)
  {
    this.key = paramK;
  }
  
  public K getKey()
  {
    return (K)this.key;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\observables\GroupedObservable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */