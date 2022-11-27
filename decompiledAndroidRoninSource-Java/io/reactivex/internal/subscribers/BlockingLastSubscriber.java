package io.reactivex.internal.subscribers;

public final class BlockingLastSubscriber<T>
  extends BlockingBaseSubscriber<T>
{
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
    this.value = paramT;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\subscribers\BlockingLastSubscriber.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */