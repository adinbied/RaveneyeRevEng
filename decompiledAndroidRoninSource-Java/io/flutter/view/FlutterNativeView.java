package io.flutter.view;

import android.app.Activity;
import android.content.Context;
import io.flutter.app.FlutterPluginRegistry;
import io.flutter.embedding.engine.FlutterEngine.EngineLifecycleListener;
import io.flutter.embedding.engine.FlutterJNI;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.plugin.common.BinaryMessenger;

public class FlutterNativeView
  implements BinaryMessenger
{
  private static final String TAG = "FlutterNativeView";
  private boolean applicationIsRunning;
  private final DartExecutor dartExecutor;
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
  private final Context mContext;
  private final FlutterJNI mFlutterJNI;
  private FlutterView mFlutterView;
  private final FlutterPluginRegistry mPluginRegistry;
  
  public FlutterNativeView(Context paramContext)
  {
    this(paramContext, false);
  }
  
  public FlutterNativeView(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.mPluginRegistry = new FlutterPluginRegistry(this, paramContext);
    FlutterJNI localFlutterJNI = new FlutterJNI();
    this.mFlutterJNI = localFlutterJNI;
    localFlutterJNI.addIsDisplayingFlutterUiListener(this.flutterUiDisplayListener);
    this.dartExecutor = new DartExecutor(this.mFlutterJNI, paramContext.getAssets());
    this.mFlutterJNI.addEngineLifecycleListener(new EngineLifecycleListenerImpl(null));
    attach(this, paramBoolean);
    assertAttached();
  }
  
  private void attach(FlutterNativeView paramFlutterNativeView, boolean paramBoolean)
  {
    this.mFlutterJNI.attachToNative(paramBoolean);
    this.dartExecutor.onAttachedToJNI();
  }
  
  public static String getObservatoryUri()
  {
    return FlutterJNI.getObservatoryUri();
  }
  
  /* Error */
  public void assertAttached()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void attachViewAndActivity(FlutterView paramFlutterView, Activity paramActivity)
  {
    this.mFlutterView = paramFlutterView;
    this.mPluginRegistry.attach(paramFlutterView, paramActivity);
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void detachFromFlutterView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DartExecutor getDartExecutor()
  {
    return this.dartExecutor;
  }
  
  FlutterJNI getFlutterJNI()
  {
    return this.mFlutterJNI;
  }
  
  public FlutterPluginRegistry getPluginRegistry()
  {
    return this.mPluginRegistry;
  }
  
  public boolean isApplicationRunning()
  {
    return this.applicationIsRunning;
  }
  
  public boolean isAttached()
  {
    return this.mFlutterJNI.isAttached();
  }
  
  /* Error */
  public void runFromBundle(FlutterRunArguments arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void send(String arg1, java.nio.ByteBuffer arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void send(String arg1, java.nio.ByteBuffer arg2, io.flutter.plugin.common.BinaryMessenger.BinaryReply arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setMessageHandler(String arg1, io.flutter.plugin.common.BinaryMessenger.BinaryMessageHandler arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private final class EngineLifecycleListenerImpl
    implements FlutterEngine.EngineLifecycleListener
  {
    private EngineLifecycleListenerImpl() {}
    
    /* Error */
    public void onPreEngineRestart()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\view\FlutterNativeView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */