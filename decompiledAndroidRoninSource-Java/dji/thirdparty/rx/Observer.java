package dji.thirdparty.rx;

public abstract interface Observer<T>
{
  public abstract void onCompleted();
  
  public abstract void onError(Throwable paramThrowable);
  
  public abstract void onNext(T paramT);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\rx\Observer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */