package io.flutter.plugin.platform;

import android.view.View;
import io.flutter.view.AccessibilityBridge;

public abstract interface PlatformViewsAccessibilityDelegate
{
  public abstract void attachAccessibilityBridge(AccessibilityBridge paramAccessibilityBridge);
  
  public abstract void detachAccessibiltyBridge();
  
  public abstract View getPlatformViewById(Integer paramInteger);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\platform\PlatformViewsAccessibilityDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */