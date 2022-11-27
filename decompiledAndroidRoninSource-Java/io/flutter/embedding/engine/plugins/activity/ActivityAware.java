package io.flutter.embedding.engine.plugins.activity;

public abstract interface ActivityAware
{
  public abstract void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding);
  
  public abstract void onDetachedFromActivity();
  
  public abstract void onDetachedFromActivityForConfigChanges();
  
  public abstract void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\plugins\activity\ActivityAware.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */