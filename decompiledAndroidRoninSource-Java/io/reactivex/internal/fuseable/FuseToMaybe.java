package io.reactivex.internal.fuseable;

import io.reactivex.Maybe;

public abstract interface FuseToMaybe<T>
{
  public abstract Maybe<T> fuseToMaybe();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\internal\fuseable\FuseToMaybe.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */