package io.flutter.plugin.common;

public final class MethodCall
{
  public final Object arguments;
  public final String method;
  
  public MethodCall(String paramString, Object paramObject)
  {
    this.method = paramString;
    this.arguments = paramObject;
  }
  
  public <T> T argument(String paramString)
  {
    return null;
  }
  
  public <T> T arguments()
  {
    return (T)this.arguments;
  }
  
  public boolean hasArgument(String paramString)
  {
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\common\MethodCall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */