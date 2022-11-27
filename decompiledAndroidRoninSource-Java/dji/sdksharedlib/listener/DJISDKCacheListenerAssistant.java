package dji.sdksharedlib.listener;

public class DJISDKCacheListenerAssistant
{
  private boolean isRunInMainThread = true;
  
  public DJISDKCacheListenerAssistant(boolean paramBoolean)
  {
    this.isRunInMainThread = paramBoolean;
  }
  
  public boolean getThread()
  {
    return this.isRunInMainThread;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\listener\DJISDKCacheListenerAssistant.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */