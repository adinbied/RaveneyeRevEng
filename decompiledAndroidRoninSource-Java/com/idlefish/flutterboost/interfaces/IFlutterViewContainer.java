package com.idlefish.flutterboost.interfaces;

import android.app.Activity;
import com.idlefish.flutterboost.containers.FlutterSplashView;
import java.util.Map;

public abstract interface IFlutterViewContainer
{
  public static final String RESULT_KEY = "_flutter_result_";
  
  public abstract void finishContainer(Map<String, Object> paramMap);
  
  public abstract FlutterSplashView getBoostFlutterView();
  
  public abstract String getContainerUrl();
  
  public abstract Map<String, Object> getContainerUrlParams();
  
  public abstract Activity getContextActivity();
  
  public abstract void onContainerHidden();
  
  public abstract void onContainerShown();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\interfaces\IFlutterViewContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */