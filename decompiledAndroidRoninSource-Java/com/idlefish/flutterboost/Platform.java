package com.idlefish.flutterboost;

import android.app.Application;
import android.content.Context;
import com.idlefish.flutterboost.interfaces.IContainerRecord;
import com.idlefish.flutterboost.interfaces.IFlutterViewContainer;
import io.flutter.embedding.android.FlutterView.RenderMode;
import java.util.Map;

public abstract class Platform
{
  public FlutterBoost.BoostLifecycleListener lifecycleListener;
  
  public void closeContainer(IContainerRecord paramIContainerRecord, Map<String, Object> paramMap1, Map<String, Object> paramMap2)
  {
    if (paramIContainerRecord == null) {
      return;
    }
    paramIContainerRecord.getContainer().finishContainer(paramMap1);
  }
  
  public abstract String dartEntrypoint();
  
  public abstract Application getApplication();
  
  public abstract String initialRoute();
  
  public abstract boolean isDebug();
  
  public abstract void openContainer(Context paramContext, String paramString, Map<String, Object> paramMap1, int paramInt, Map<String, Object> paramMap2);
  
  public abstract FlutterView.RenderMode renderMode();
  
  public abstract int whenEngineStart();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\Platform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */