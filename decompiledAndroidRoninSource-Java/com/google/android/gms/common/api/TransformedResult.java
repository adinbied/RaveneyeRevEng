package com.google.android.gms.common.api;

public abstract class TransformedResult<R extends Result>
{
  public abstract void andFinally(ResultCallbacks<? super R> paramResultCallbacks);
  
  public abstract <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> paramResultTransform);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\TransformedResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */