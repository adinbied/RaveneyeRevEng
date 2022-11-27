package io.flutter.embedding.engine;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Looper;
import android.view.Surface;
import io.flutter.embedding.engine.dart.PlatformMessageHandler;
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener;
import io.flutter.view.AccessibilityBridge.Action;
import io.flutter.view.FlutterCallbackInformation;
import java.nio.ByteBuffer;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FlutterJNI
{
  private static final String TAG = "FlutterJNI";
  private static AsyncWaitForVsyncDelegate asyncWaitForVsyncDelegate;
  private static String observatoryUri;
  private static float refreshRateFPS;
  private AccessibilityDelegate accessibilityDelegate;
  private final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners = new CopyOnWriteArraySet();
  private final Set<FlutterUiDisplayListener> flutterUiDisplayListeners = new CopyOnWriteArraySet();
  private final Looper mainLooper = Looper.getMainLooper();
  private Long nativePlatformViewId;
  private PlatformMessageHandler platformMessageHandler;
  
  private static void asyncWaitForVsync(long paramLong)
  {
    AsyncWaitForVsyncDelegate localAsyncWaitForVsyncDelegate = asyncWaitForVsyncDelegate;
    if (localAsyncWaitForVsyncDelegate != null)
    {
      localAsyncWaitForVsyncDelegate.asyncWaitForVsync(paramLong);
      return;
    }
    throw new IllegalStateException("An AsyncWaitForVsyncDelegate must be registered with FlutterJNI before asyncWaitForVsync() is invoked.");
  }
  
  /* Error */
  private void ensureAttachedToNative()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void ensureNotAttachedToNative()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void ensureRunningOnMainThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static String getObservatoryUri()
  {
    return observatoryUri;
  }
  
  private void handlePlatformMessage(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    PlatformMessageHandler localPlatformMessageHandler = this.platformMessageHandler;
    if (localPlatformMessageHandler != null) {
      localPlatformMessageHandler.handleMessageFromDart(paramString, paramArrayOfByte, paramInt);
    }
  }
  
  private void handlePlatformMessageResponse(int paramInt, byte[] paramArrayOfByte)
  {
    PlatformMessageHandler localPlatformMessageHandler = this.platformMessageHandler;
    if (localPlatformMessageHandler != null) {
      localPlatformMessageHandler.handlePlatformMessageResponse(paramInt, paramArrayOfByte);
    }
  }
  
  private native long nativeAttach(FlutterJNI paramFlutterJNI, boolean paramBoolean);
  
  private native void nativeDestroy(long paramLong);
  
  private native void nativeDispatchEmptyPlatformMessage(long paramLong, String paramString, int paramInt);
  
  private native void nativeDispatchPlatformMessage(long paramLong, String paramString, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2);
  
  private native void nativeDispatchPointerDataPacket(long paramLong, ByteBuffer paramByteBuffer, int paramInt);
  
  private native void nativeDispatchSemanticsAction(long paramLong, int paramInt1, int paramInt2, ByteBuffer paramByteBuffer, int paramInt3);
  
  private native Bitmap nativeGetBitmap(long paramLong);
  
  public static native void nativeInit(Context paramContext, String[] paramArrayOfString, String paramString1, String paramString2, String paramString3);
  
  private native void nativeInvokePlatformMessageEmptyResponseCallback(long paramLong, int paramInt);
  
  private native void nativeInvokePlatformMessageResponseCallback(long paramLong, int paramInt1, ByteBuffer paramByteBuffer, int paramInt2);
  
  public static native FlutterCallbackInformation nativeLookupCallbackInformation(long paramLong);
  
  private native void nativeMarkTextureFrameAvailable(long paramLong1, long paramLong2);
  
  public static native void nativeOnVsync(long paramLong1, long paramLong2, long paramLong3);
  
  public static native void nativeRecordStartTimestamp(long paramLong);
  
  private native void nativeRegisterTexture(long paramLong1, long paramLong2, SurfaceTexture paramSurfaceTexture);
  
  private native void nativeRunBundleAndSnapshotFromLibrary(long paramLong, String paramString1, String paramString2, String paramString3, AssetManager paramAssetManager);
  
  private native void nativeSetAccessibilityFeatures(long paramLong, int paramInt);
  
  private native void nativeSetSemanticsEnabled(long paramLong, boolean paramBoolean);
  
  private native void nativeSetViewportMetrics(long paramLong, float paramFloat, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8, int paramInt9, int paramInt10, int paramInt11, int paramInt12, int paramInt13, int paramInt14);
  
  private native void nativeSurfaceChanged(long paramLong, int paramInt1, int paramInt2);
  
  private native void nativeSurfaceCreated(long paramLong, Surface paramSurface);
  
  private native void nativeSurfaceDestroyed(long paramLong);
  
  private native void nativeUnregisterTexture(long paramLong1, long paramLong2);
  
  /* Error */
  private void onPreEngineRestart()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static void setAsyncWaitForVsyncDelegate(AsyncWaitForVsyncDelegate paramAsyncWaitForVsyncDelegate)
  {
    asyncWaitForVsyncDelegate = paramAsyncWaitForVsyncDelegate;
  }
  
  public static void setRefreshRateFPS(float paramFloat)
  {
    refreshRateFPS = paramFloat;
  }
  
  /* Error */
  private void updateCustomAccessibilityActions(ByteBuffer arg1, String[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateSemantics(ByteBuffer arg1, String[] arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addEngineLifecycleListener(FlutterEngine.EngineLifecycleListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void addIsDisplayingFlutterUiListener(FlutterUiDisplayListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void attachToNative(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void detachFromNativeAndReleaseResources()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dispatchEmptyPlatformMessage(String arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dispatchPlatformMessage(String arg1, ByteBuffer arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dispatchPointerDataPacket(ByteBuffer arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void dispatchSemanticsAction(int arg1, int arg2, ByteBuffer arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public void dispatchSemanticsAction(int paramInt, AccessibilityBridge.Action paramAction)
  {
    dispatchSemanticsAction(paramInt, paramAction, null);
  }
  
  /* Error */
  public void dispatchSemanticsAction(int arg1, AccessibilityBridge.Action arg2, Object arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public Bitmap getBitmap()
  {
    return null;
  }
  
  /* Error */
  public void invokePlatformMessageEmptyResponseCallback(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void invokePlatformMessageResponseCallback(int arg1, ByteBuffer arg2, int arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public boolean isAttached()
  {
    return this.nativePlatformViewId != null;
  }
  
  /* Error */
  public void markTextureFrameAvailable(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public native boolean nativeGetIsSoftwareRenderingEnabled();
  
  /* Error */
  void onFirstFrame()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  void onRenderingStopped()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onSurfaceChanged(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onSurfaceCreated(Surface arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onSurfaceDestroyed()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void registerTexture(long arg1, SurfaceTexture arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeEngineLifecycleListener(FlutterEngine.EngineLifecycleListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void removeIsDisplayingFlutterUiListener(FlutterUiDisplayListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void runBundleAndSnapshotFromLibrary(String arg1, String arg2, String arg3, AssetManager arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setAccessibilityDelegate(AccessibilityDelegate paramAccessibilityDelegate)
  {
    ensureRunningOnMainThread();
    this.accessibilityDelegate = paramAccessibilityDelegate;
  }
  
  /* Error */
  public void setAccessibilityFeatures(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setPlatformMessageHandler(PlatformMessageHandler paramPlatformMessageHandler)
  {
    ensureRunningOnMainThread();
    this.platformMessageHandler = paramPlatformMessageHandler;
  }
  
  /* Error */
  public void setSemanticsEnabled(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setViewportMetrics(float arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9, int arg10, int arg11, int arg12, int arg13, int arg14, int arg15)
  {
    // Byte code:
    //   0: return
    //   1: astore 16
    //   3: goto -3 -> 0
  }
  
  /* Error */
  public void unregisterTexture(long arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  public static abstract interface AccessibilityDelegate
  {
    public abstract void updateCustomAccessibilityActions(ByteBuffer paramByteBuffer, String[] paramArrayOfString);
    
    public abstract void updateSemantics(ByteBuffer paramByteBuffer, String[] paramArrayOfString);
  }
  
  public static abstract interface AsyncWaitForVsyncDelegate
  {
    public abstract void asyncWaitForVsync(long paramLong);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\FlutterJNI.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */