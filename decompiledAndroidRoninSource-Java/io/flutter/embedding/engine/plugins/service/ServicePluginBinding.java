package io.flutter.embedding.engine.plugins.service;

import android.app.Service;

public abstract interface ServicePluginBinding
{
  public abstract void addOnModeChangeListener(ServiceAware.OnModeChangeListener paramOnModeChangeListener);
  
  public abstract Object getLifecycle();
  
  public abstract Service getService();
  
  public abstract void removeOnModeChangeListener(ServiceAware.OnModeChangeListener paramOnModeChangeListener);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\plugins\service\ServicePluginBinding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */