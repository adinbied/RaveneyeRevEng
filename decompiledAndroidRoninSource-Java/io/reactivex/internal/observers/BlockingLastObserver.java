package io.reactivex.internal.observers;

public final class BlockingLastObserver<T>
  extends BlockingBaseObserver<T>
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\observers\BlockingLastObserver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */