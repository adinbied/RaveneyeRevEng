package io.reactivex;

public abstract interface SingleConverter<T, R>
{
  public abstract R apply(Single<T> paramSingle);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\SingleConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */