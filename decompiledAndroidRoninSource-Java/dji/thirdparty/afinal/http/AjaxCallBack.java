package dji.thirdparty.afinal.http;

public abstract class AjaxCallBack<T>
{
  private boolean progress = true;
  private int rate = 1000;
  
  public int getRate()
  {
    return this.rate;
  }
  
  public boolean isProgress()
  {
    return this.progress;
  }
  
  public abstract void onFailure(Throwable paramThrowable, int paramInt, String paramString);
  
  public abstract void onLoading(long paramLong1, long paramLong2);
  
  public abstract void onStart(boolean paramBoolean);
  
  public abstract void onSuccess(T paramT);
  
  public AjaxCallBack<T> progress(boolean paramBoolean, int paramInt)
  {
    this.progress = paramBoolean;
    this.rate = paramInt;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\http\AjaxCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */