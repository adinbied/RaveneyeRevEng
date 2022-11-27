package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public final class MaybeFromFuture<T>
  extends Maybe<T>
{
  final Future<? extends T> future;
  final long timeout;
  final TimeUnit unit;
  
  public MaybeFromFuture(Future<? extends T> paramFuture, long paramLong, TimeUnit paramTimeUnit)
  {
    this.future = paramFuture;
    this.timeout = paramLong;
    this.unit = paramTimeUnit;
  }
  
  /* Error */
  protected void subscribeActual(io.reactivex.MaybeObserver<? super T> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeFromFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */