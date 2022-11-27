package com.google.android.gms.common.api;

public class Response<T extends Result>
{
  private T zzap;
  
  public Response() {}
  
  protected Response(T paramT)
  {
    this.zzap = paramT;
  }
  
  protected T getResult()
  {
    return this.zzap;
  }
  
  public void setResult(T paramT)
  {
    this.zzap = paramT;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\Response.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */