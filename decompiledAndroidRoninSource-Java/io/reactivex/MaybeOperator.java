package io.reactivex;

public abstract interface MaybeOperator<Downstream, Upstream>
{
  public abstract MaybeObserver<? super Upstream> apply(MaybeObserver<? super Downstream> paramMaybeObserver)
    throws Exception;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\MaybeOperator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */