package com.idlefish.flutterboost.containers;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.idlefish.flutterboost.FlutterBoost;
import com.idlefish.flutterboost.XFlutterView;
import io.flutter.embedding.android.FlutterView.FlutterEngineAttachmentListener;
import io.flutter.embedding.android.SplashScreen;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

public class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener = new FlutterView.FlutterEngineAttachmentListener()
  {
    public void onFlutterEngineAttachedToFlutterView(FlutterEngine paramAnonymousFlutterEngine)
    {
      FlutterSplashView.this.flutterView.removeFlutterEngineAttachmentListener(this);
    }
    
    public void onFlutterEngineDetachedFromFlutterView() {}
  };
  private XFlutterView flutterView;
  private Handler handler = new Handler();
  private FlutterEngine mFlutterEngine;
  private final FlutterUiDisplayListener onFirstFrameRenderedListener = new FlutterUiDisplayListener()
  {
    /* Error */
    public void onFlutterUiDisplayed()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onFlutterUiNoLongerDisplayed() {}
  };
  private final Runnable onTransitionComplete = new Runnable()
  {
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  private String previousCompletedSplashIsolate;
  private SplashScreen splashScreen;
  private Bundle splashScreenState;
  private View splashScreenView;
  private String transitioningIsolateId;
  
  public FlutterSplashView(Context paramContext)
  {
    this(paramContext, null, 0);
  }
  
  public FlutterSplashView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FlutterSplashView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setSaveEnabled(true);
    if (this.mFlutterEngine == null) {
      this.mFlutterEngine = FlutterBoost.instance().engineProvider();
    }
  }
  
  private boolean hasSplashCompleted()
  {
    return false;
  }
  
  /* Error */
  private void transitionToFlutter()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void displayFlutterViewWithSplash(XFlutterView arg1, SplashScreen arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onAttach()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onDetach()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDetachedFromWindow()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\idlefish\flutterboost\containers\FlutterSplashView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */