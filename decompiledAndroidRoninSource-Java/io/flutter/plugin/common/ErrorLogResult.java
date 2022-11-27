package io.flutter.plugin.common;

public class ErrorLogResult
  implements MethodChannel.Result
{
  private int level;
  private String tag;
  
  public ErrorLogResult(String paramString)
  {
    this(paramString, 5);
  }
  
  public ErrorLogResult(String paramString, int paramInt)
  {
    this.tag = paramString;
    this.level = paramInt;
  }
  
  /* Error */
  public void error(String arg1, String arg2, Object arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void notImplemented()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void success(Object paramObject) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\ErrorLogResult.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */