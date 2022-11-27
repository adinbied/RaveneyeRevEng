package io.reactivex;

public abstract interface Emitter<T>
{
  public abstract void onComplete();
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onNext(T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\Emitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */