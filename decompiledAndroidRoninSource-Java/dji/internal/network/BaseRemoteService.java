package dji.internal.network;

public abstract class BaseRemoteService
{
  public static abstract interface SDKRemoteServiceCallback
  {
    public abstract void onFailure();
    
    public abstract void onSuccess(Object paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\network\BaseRemoteService.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */