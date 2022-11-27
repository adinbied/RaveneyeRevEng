package io.flutter.plugin.platform;

import android.view.View;

public abstract interface PlatformView
{
  public abstract void dispose();
  
  public abstract View getView();
  
  public abstract void onFlutterViewAttached(View paramView);
  
  public abstract void onFlutterViewDetached();
  
  public abstract void onInputConnectionLocked();
  
  public abstract void onInputConnectionUnlocked();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\platform\PlatformView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */