package io.flutter.app;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.FlutterView.Provider;

public class FlutterFragmentActivity
  extends FragmentActivity
  implements FlutterView.Provider, PluginRegistry, FlutterActivityDelegate.ViewFactory
{
  private final FlutterActivityDelegate delegate;
  private final FlutterActivityEvents eventDelegate;
  private final PluginRegistry pluginRegistry;
  private final FlutterView.Provider viewProvider;
  
  public FlutterFragmentActivity()
  {
    FlutterActivityDelegate localFlutterActivityDelegate = new FlutterActivityDelegate(this, this);
    this.delegate = localFlutterActivityDelegate;
    this.eventDelegate = localFlutterActivityDelegate;
    this.viewProvider = localFlutterActivityDelegate;
    this.pluginRegistry = localFlutterActivityDelegate;
  }
  
  public FlutterNativeView createFlutterNativeView()
  {
    return null;
  }
  
  public FlutterView createFlutterView(Context paramContext)
  {
    return null;
  }
  
  public FlutterView getFlutterView()
  {
    return this.viewProvider.getFlutterView();
  }
  
  public final boolean hasPlugin(String paramString)
  {
    return this.pluginRegistry.hasPlugin(paramString);
  }
  
  /* Error */
  protected void onActivityResult(int arg1, int arg2, android.content.Intent arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onBackPressed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onConfigurationChanged(android.content.res.Configuration arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onCreate(android.os.Bundle arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onDestroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onLowMemory()
  {
    this.eventDelegate.onLowMemory();
  }
  
  /* Error */
  protected void onNewIntent(android.content.Intent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onPause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onPostResume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onRequestPermissionsResult(int arg1, String[] arg2, int[] arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onStart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onStop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void onTrimMemory(int paramInt)
  {
    this.eventDelegate.onTrimMemory(paramInt);
  }
  
  public void onUserLeaveHint()
  {
    this.eventDelegate.onUserLeaveHint();
  }
  
  public final PluginRegistry.Registrar registrarFor(String paramString)
  {
    return this.pluginRegistry.registrarFor(paramString);
  }
  
  public boolean retainFlutterNativeView()
  {
    return false;
  }
  
  public final <T> T valuePublishedByPlugin(String paramString)
  {
    return (T)this.pluginRegistry.valuePublishedByPlugin(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\app\FlutterFragmentActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */