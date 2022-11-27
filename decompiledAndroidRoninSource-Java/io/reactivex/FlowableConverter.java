package io.reactivex;

public abstract interface FlowableConverter<T, R>
{
  public abstract R apply(Flowable<T> paramFlowable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\FlowableConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */