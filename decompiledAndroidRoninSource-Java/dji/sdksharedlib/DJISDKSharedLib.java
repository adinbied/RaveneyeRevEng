package dji.sdksharedlib;

public class DJISDKSharedLib
{
  public final String TAG = "DJISDKSharedLib";
  
  public static DJISDKSharedLib getInstance()
  {
    return SingletonHolder.instance;
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void init(android.content.Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static class SingletonHolder
  {
    private static DJISDKSharedLib instance = new DJISDKSharedLib();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\DJISDKSharedLib.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */