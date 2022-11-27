package dji.midware;

import android.content.Context;
import android.text.TextUtils;
import dji.midware.component.DJIComponentManager;
import dji.midware.data.manager.P3.DJIProductManager;
import dji.midware.data.manager.P3.ServiceManager;
import dji.midware.media.DJIVideoDataRecver;
import dji.midware.media.DJIVideoDataRecver.DJIDecoderType;
import dji.midware.natives.FPVController;
import dji.midware.wsbridge.BridgeWSConnectionManager;
import dji.publics.DJIObject.DJICrashHandler;
import java.lang.ref.WeakReference;

public class MidWare
{
  public static final boolean GO = true;
  public static String bridgeIP = "";
  public static WeakReference<Context> context;
  public final String TAG = "MidWare";
  
  public static void destroy()
  {
    WeakReference localWeakReference = context;
    if (localWeakReference != null) {
      localWeakReference.clear();
    }
  }
  
  public static void init(Context paramContext)
  {
    context = new WeakReference(paramContext);
    FPVController.loadLibrary();
    DJICrashHandler.getInstance().init(paramContext);
    ServiceManager.setContext(paramContext);
    ServiceManager.createInstance();
    ServiceManager.getInstance().init();
    DJIVideoDataRecver.getInstance().setDecoderType(DJIVideoDataRecver.DJIDecoderType.Hardware);
    DJIProductManager.build(paramContext);
    ServiceManager.getInstance().start();
    DJIComponentManager.getInstance().init(paramContext);
    Lifecycle.broadcastCreate(paramContext, "com.dji.lifecycle.application");
    if (isBridgeEnabled()) {
      BridgeWSConnectionManager.getInstance();
    }
  }
  
  public static boolean isBridgeEnabled()
  {
    return (!TextUtils.isEmpty("")) || (!TextUtils.isEmpty(bridgeIP));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\MidWare.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */