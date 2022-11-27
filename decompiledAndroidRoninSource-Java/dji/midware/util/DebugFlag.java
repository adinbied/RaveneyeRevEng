package dji.midware.util;

import dji.log.RoninLog;

public class DebugFlag
{
  public static final boolean FACTORY_FLAG = false;
  public static final boolean FLAG = true;
  public static final boolean PRO_DEBUG = false;
  public static final boolean SETTINGS_DEBUG = false;
  
  public static final void printfLog(String paramString1, String paramString2)
  {
    String str = paramString1;
    if (paramString1 == null) {
      str = "Lightbridge";
    }
    RoninLog.d(str, paramString2, new Object[0]);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\DebugFlag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */