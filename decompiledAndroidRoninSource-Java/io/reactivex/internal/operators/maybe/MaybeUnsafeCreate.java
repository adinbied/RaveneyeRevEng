package io.reactivex.internal.operators.maybe;

import io.reactivex.MaybeObserver;
import io.reactivex.MaybeSource;

public final class MaybeUnsafeCreate<T>
  extends AbstractMaybeWithUpstream<T, T>
{
  public MaybeUnsafeCreate(MaybeSource<T> paramMaybeSource)
  {
    super(paramMaybeSource);
  }
  
  protected void subscribeActual(MaybeObserver<? super T> paramMaybeObserver)
  {
    this.source.subscribe(paramMaybeObserver);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\MaybeUnsafeCreate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */