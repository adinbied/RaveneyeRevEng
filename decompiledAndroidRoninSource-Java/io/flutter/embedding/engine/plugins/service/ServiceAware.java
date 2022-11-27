package io.flutter.embedding.engine.plugins.service;

public abstract interface ServiceAware
{
  public abstract void onAttachedToService(ServicePluginBinding paramServicePluginBinding);
  
  public abstract void onDetachedFromService();
  
  public static abstract interface OnModeChangeListener
  {
    public abstract void onMoveToBackground();
    
    public abstract void onMoveToForeground();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\plugins\service\ServiceAware.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */