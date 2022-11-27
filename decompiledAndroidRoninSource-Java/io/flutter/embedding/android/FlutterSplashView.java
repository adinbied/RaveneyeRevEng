package io.flutter.embedding.android;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.BaseSavedState;
import android.widget.FrameLayout;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;

final class FlutterSplashView
  extends FrameLayout
{
  private static String TAG = "FlutterSplashView";
  private final FlutterView.FlutterEngineAttachmentListener flutterEngineAttachmentListener = new FlutterView.FlutterEngineAttachmentListener()
  {
    /* Error */
    public void onFlutterEngineAttachedToFlutterView(io.flutter.embedding.engine.FlutterEngine arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public void onFlutterEngineDetachedFromFlutterView() {}
  };
  private final FlutterUiDisplayListener flutterUiDisplayListener = new FlutterUiDisplayListener()
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
  private FlutterView flutterView;
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
  }
  
  private boolean hasSplashCompleted()
  {
    return false;
  }
  
  private boolean isSplashScreenNeededNow()
  {
    return false;
  }
  
  private boolean isSplashScreenTransitionNeededNow()
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
  
  private boolean wasPreviousSplashTransitionInterrupted()
  {
    return false;
  }
  
  /* Error */
  public void displayFlutterViewWithSplash(FlutterView arg1, SplashScreen arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onRestoreInstanceState(Parcelable arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected Parcelable onSaveInstanceState()
  {
    return null;
  }
  
  public static class SavedState
    extends View.BaseSavedState
  {
    public static Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator()
    {
      public FlutterSplashView.SavedState createFromParcel(Parcel paramAnonymousParcel)
      {
        return new FlutterSplashView.SavedState(paramAnonymousParcel);
      }
      
      public FlutterSplashView.SavedState[] newArray(int paramAnonymousInt)
      {
        return new FlutterSplashView.SavedState[paramAnonymousInt];
      }
    };
    private String previousCompletedSplashIsolate;
    private Bundle splashScreenState;
    
    SavedState(Parcel paramParcel)
    {
      super();
      this.previousCompletedSplashIsolate = paramParcel.readString();
      this.splashScreenState = paramParcel.readBundle(getClass().getClassLoader());
    }
    
    SavedState(Parcelable paramParcelable)
    {
      super();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      super.writeToParcel(paramParcel, paramInt);
      paramParcel.writeString(this.previousCompletedSplashIsolate);
      paramParcel.writeBundle(this.splashScreenState);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\android\FlutterSplashView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */