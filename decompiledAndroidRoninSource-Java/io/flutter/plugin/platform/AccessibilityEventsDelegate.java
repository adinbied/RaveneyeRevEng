package io.flutter.plugin.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import io.flutter.view.AccessibilityBridge;

class AccessibilityEventsDelegate
{
  private AccessibilityBridge accessibilityBridge;
  
  public boolean requestSendAccessibilityEvent(View paramView1, View paramView2, AccessibilityEvent paramAccessibilityEvent)
  {
    return false;
  }
  
  void setAccessibilityBridge(AccessibilityBridge paramAccessibilityBridge)
  {
    this.accessibilityBridge = paramAccessibilityBridge;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\platform\AccessibilityEventsDelegate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */