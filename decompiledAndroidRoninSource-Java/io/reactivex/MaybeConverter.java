package io.reactivex;

public abstract interface MaybeConverter<T, R>
{
  public abstract R apply(Maybe<T> paramMaybe);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\MaybeConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */