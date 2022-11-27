package io.reactivex.flowables;

import io.reactivex.Flowable;

public abstract class GroupedFlowable<K, T>
  extends Flowable<T>
{
  final K key;
  
  protected GroupedFlowable(K paramK)
  {
    this.key = paramK;
  }
  
  public K getKey()
  {
    return (K)this.key;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\flowables\GroupedFlowable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */