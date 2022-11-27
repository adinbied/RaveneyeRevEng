package com.huawei.hms.activity;

import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;

public abstract interface a
{
  public abstract void onBridgeActivityCreate(Activity paramActivity);
  
  public abstract void onBridgeActivityDestroy();
  
  public abstract boolean onBridgeActivityResult(int paramInt1, int paramInt2, Intent paramIntent);
  
  public abstract void onBridgeConfigurationChanged();
  
  public abstract void onKeyUp(int paramInt, KeyEvent paramKeyEvent);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\activity\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */