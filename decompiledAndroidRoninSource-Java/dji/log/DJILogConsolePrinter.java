package dji.log;

import android.content.Context;

class DJILogConsolePrinter
{
  private DJILogConsoleConfig config;
  
  private String formatMsg(int paramInt, String paramString1, String paramString2)
  {
    return null;
  }
  
  private String formatTag(int paramInt, String paramString)
  {
    return null;
  }
  
  public void init(Context paramContext, DJILogConsoleConfig paramDJILogConsoleConfig)
  {
    DJILogConsoleConfig localDJILogConsoleConfig = paramDJILogConsoleConfig;
    if (paramDJILogConsoleConfig == null) {
      localDJILogConsoleConfig = new DJILogConsoleConfig.Builder(paramContext).build();
    }
    this.config = localDJILogConsoleConfig;
  }
  
  /* Error */
  void println(int arg1, String arg2, String arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\log\DJILogConsolePrinter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */