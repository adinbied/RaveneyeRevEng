package dji.midware.natives;

import dji.log.RoninLog;

public class UpgradeVerify
{
  static
  {
    try
    {
      System.loadLibrary("UpgradeVerify");
      RoninLog.d("UpgradeVerify", "load lib suc", new Object[0]);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      RoninLog.d("UpgradeVerify", "Couldn't load lib", new Object[0]);
    }
  }
  
  public static void loadLibrary() {}
  
  public static String native_getMD5Input(String paramString)
  {
    return native_getMD5Input(paramString, 0);
  }
  
  public static native String native_getMD5Input(String paramString, int paramInt);
  
  public static native boolean native_verifyCfg(String paramString1, String paramString2);
  
  public static native boolean native_verifyFile(String paramString1, String paramString2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\natives\UpgradeVerify.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */