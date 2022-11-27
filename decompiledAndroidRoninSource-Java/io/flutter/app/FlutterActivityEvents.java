package io.flutter.app;

import android.content.ComponentCallbacks2;
import android.content.Intent;
import android.os.Bundle;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;

public abstract interface FlutterActivityEvents
  extends ComponentCallbacks2, PluginRegistry.ActivityResultListener, PluginRegistry.RequestPermissionsResultListener
{
  public abstract boolean onBackPressed();
  
  public abstract void onCreate(Bundle paramBundle);
  
  public abstract void onDestroy();
  
  public abstract void onNewIntent(Intent paramIntent);
  
  public abstract void onPause();
  
  public abstract void onPostResume();
  
  public abstract void onResume();
  
  public abstract void onStart();
  
  public abstract void onStop();
  
  public abstract void onUserLeaveHint();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\app\FlutterActivityEvents.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */