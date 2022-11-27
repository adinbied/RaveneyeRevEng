package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeSource;
import io.reactivex.internal.fuseable.HasUpstreamMaybeSource;

abstract class AbstractMaybeWithUpstream<T, R>
  extends Maybe<R>
  implements HasUpstreamMaybeSource<T>
{
  protected final MaybeSource<T> source;
  
  AbstractMaybeWithUpstream(MaybeSource<T> paramMaybeSource)
  {
    this.source = paramMaybeSource;
  }
  
  public final MaybeSource<T> source()
  {
    return this.source;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\operators\maybe\AbstractMaybeWithUpstream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */