package io.flutter.embedding.engine.plugins.service;

import android.app.Service;
import androidx.lifecycle.Lifecycle;

public abstract interface ServiceControlSurface
{
  public abstract void attachToService(Service paramService, Lifecycle paramLifecycle, boolean paramBoolean);
  
  public abstract void detachFromService();
  
  public abstract void onMoveToBackground();
  
  public abstract void onMoveToForeground();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\plugins\service\ServiceControlSurface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */