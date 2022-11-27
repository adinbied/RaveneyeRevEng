package dji.sdksharedlib.listener;

public abstract interface DJISDKCacheInteractionListener
{
  public abstract void onActionCall(String paramString1, Integer paramInteger1, String paramString2, Integer paramInteger2, String paramString3, Object... paramVarArgs);
  
  public abstract void onGetterCall(String paramString1, Integer paramInteger1, String paramString2, Integer paramInteger2, String paramString3);
  
  public abstract void onSetterCall(String paramString1, Integer paramInteger1, String paramString2, Integer paramInteger2, String paramString3, Object paramObject);
  
  public abstract void onValueChange(String paramString1, Integer paramInteger1, String paramString2, Integer paramInteger2, String paramString3, Object paramObject1, Object paramObject2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\listener\DJISDKCacheInteractionListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */