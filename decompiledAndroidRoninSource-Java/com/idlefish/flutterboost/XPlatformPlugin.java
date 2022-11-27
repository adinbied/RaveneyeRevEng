package com.idlefish.flutterboost;

import android.app.Activity;
import android.graphics.Rect;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.AppSwitcherDescription;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.ClipboardContentFormat;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.HapticFeedbackType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.PlatformMessageHandler;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SoundType;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemChromeStyle;
import io.flutter.embedding.engine.systemchannels.PlatformChannel.SystemUiOverlay;
import java.util.ArrayList;
import java.util.List;

public class XPlatformPlugin
{
  public static final int DEFAULT_SYSTEM_UI = 1280;
  private Activity activity;
  private PlatformChannel.SystemChromeStyle currentTheme;
  private int mEnabledOverlays;
  private PlatformChannel.PlatformMessageHandler mPlatformMessageHandler;
  private PlatformChannel platformChannel;
  
  public XPlatformPlugin(PlatformChannel paramPlatformChannel)
  {
    PlatformChannel.PlatformMessageHandler local1 = new PlatformChannel.PlatformMessageHandler()
    {
      public CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat paramAnonymousClipboardContentFormat)
      {
        return XPlatformPlugin.this.getClipboardData(paramAnonymousClipboardContentFormat);
      }
      
      public List<Rect> getSystemGestureExclusionRects()
      {
        return XPlatformPlugin.this.getSystemGestureExclusionRects();
      }
      
      public void playSystemSound(PlatformChannel.SoundType paramAnonymousSoundType)
      {
        XPlatformPlugin.this.playSystemSound(paramAnonymousSoundType);
      }
      
      public void popSystemNavigator()
      {
        XPlatformPlugin.this.popSystemNavigator();
      }
      
      public void restoreSystemUiOverlays()
      {
        XPlatformPlugin.this.restoreSystemChromeSystemUIOverlays();
      }
      
      public void setApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription paramAnonymousAppSwitcherDescription)
      {
        XPlatformPlugin.this.setSystemChromeApplicationSwitcherDescription(paramAnonymousAppSwitcherDescription);
      }
      
      public void setClipboardData(String paramAnonymousString)
      {
        XPlatformPlugin.this.setClipboardData(paramAnonymousString);
      }
      
      public void setPreferredOrientations(int paramAnonymousInt)
      {
        XPlatformPlugin.this.setSystemChromePreferredOrientations(paramAnonymousInt);
      }
      
      public void setSystemGestureExclusionRects(ArrayList<Rect> paramAnonymousArrayList)
      {
        XPlatformPlugin.this.setSystemGestureExclusionRects(paramAnonymousArrayList);
      }
      
      public void setSystemUiOverlayStyle(PlatformChannel.SystemChromeStyle paramAnonymousSystemChromeStyle)
      {
        XPlatformPlugin.this.setSystemChromeSystemUIOverlayStyle(paramAnonymousSystemChromeStyle);
      }
      
      public void showSystemOverlays(List<PlatformChannel.SystemUiOverlay> paramAnonymousList)
      {
        XPlatformPlugin.this.setSystemChromeEnabledSystemUIOverlays(paramAnonymousList);
      }
      
      public void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType paramAnonymousHapticFeedbackType)
      {
        XPlatformPlugin.this.vibrateHapticFeedback(paramAnonymousHapticFeedbackType);
      }
    };
    this.mPlatformMessageHandler = local1;
    this.platformChannel = paramPlatformChannel;
    paramPlatformChannel.setPlatformMessageHandler(local1);
    this.mEnabledOverlays = 1280;
  }
  
  private CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat paramClipboardContentFormat)
  {
    return null;
  }
  
  private List<Rect> getSystemGestureExclusionRects()
  {
    return null;
  }
  
  /* Error */
  private void playSystemSound(PlatformChannel.SoundType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void popSystemNavigator()
  {
    this.activity.finish();
  }
  
  private void restoreSystemChromeSystemUIOverlays()
  {
    updateSystemUiOverlays();
  }
  
  /* Error */
  private void setClipboardData(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setSystemChromeApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setSystemChromeEnabledSystemUIOverlays(List<PlatformChannel.SystemUiOverlay> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private void setSystemChromePreferredOrientations(int paramInt)
  {
    this.activity.setRequestedOrientation(paramInt);
  }
  
  /* Error */
  private void setSystemChromeSystemUIOverlayStyle(PlatformChannel.SystemChromeStyle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void setSystemGestureExclusionRects(ArrayList<Rect> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void attachToActivity(Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void detachActivity(Activity paramActivity)
  {
    if (paramActivity == this.activity) {
      this.activity = null;
    }
  }
  
  /* Error */
  public void updateSystemUiOverlays()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\XPlatformPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */