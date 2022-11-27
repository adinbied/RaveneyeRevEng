package io.flutter.view;

import io.flutter.embedding.engine.FlutterJNI;

public final class FlutterCallbackInformation
{
  public final String callbackClassName;
  public final String callbackLibraryPath;
  public final String callbackName;
  
  private FlutterCallbackInformation(String paramString1, String paramString2, String paramString3)
  {
    this.callbackName = paramString1;
    this.callbackClassName = paramString2;
    this.callbackLibraryPath = paramString3;
  }
  
  public static FlutterCallbackInformation lookupCallbackInformation(long paramLong)
  {
    return FlutterJNI.nativeLookupCallbackInformation(paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\view\FlutterCallbackInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */