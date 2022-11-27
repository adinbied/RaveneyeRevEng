package dji.sdksharedlib.hardware.extension;

public class DJISDKCacheCommonMergeSetCommand
{
  public DJISDKCacheCommonMergeCallback callback;
  public String index;
  public Number value;
  
  public DJISDKCacheCommonMergeSetCommand(String paramString, Number paramNumber, DJISDKCacheCommonMergeCallback paramDJISDKCacheCommonMergeCallback)
  {
    this.index = paramString;
    this.value = paramNumber;
    this.callback = paramDJISDKCacheCommonMergeCallback;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\extension\DJISDKCacheCommonMergeSetCommand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */