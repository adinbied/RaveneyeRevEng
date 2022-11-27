package io.flutter.plugin.common;

public class FlutterException
  extends RuntimeException
{
  private static final String TAG = "FlutterException#";
  public final String code;
  public final Object details;
  
  FlutterException(String paramString1, String paramString2, Object paramObject)
  {
    super(paramString2);
    this.code = paramString1;
    this.details = paramObject;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\FlutterException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */