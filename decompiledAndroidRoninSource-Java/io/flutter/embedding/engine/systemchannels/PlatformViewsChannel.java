package io.flutter.embedding.engine.systemchannels;

import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.StandardMethodCodec;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.ByteBuffer;

public class PlatformViewsChannel
{
  private static final String TAG = "PlatformViewsChannel";
  private final MethodChannel channel;
  private PlatformViewsHandler handler;
  private final MethodChannel.MethodCallHandler parsingHandler = new MethodChannel.MethodCallHandler()
  {
    /* Error */
    private void clearFocus(io.flutter.plugin.common.MethodCall arg1, MethodChannel.Result arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    private void create(io.flutter.plugin.common.MethodCall arg1, MethodChannel.Result arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    private void dispose(io.flutter.plugin.common.MethodCall arg1, MethodChannel.Result arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    private void resize(io.flutter.plugin.common.MethodCall arg1, MethodChannel.Result arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    private void setDirection(io.flutter.plugin.common.MethodCall arg1, MethodChannel.Result arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    private void touch(io.flutter.plugin.common.MethodCall arg1, MethodChannel.Result arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    /* Error */
    public void onMethodCall(io.flutter.plugin.common.MethodCall arg1, MethodChannel.Result arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  };
  
  public PlatformViewsChannel(DartExecutor paramDartExecutor)
  {
    paramDartExecutor = new MethodChannel(paramDartExecutor, "flutter/platform_views", StandardMethodCodec.INSTANCE);
    this.channel = paramDartExecutor;
    paramDartExecutor.setMethodCallHandler(this.parsingHandler);
  }
  
  private static String detailedExceptionString(Exception paramException)
  {
    StringWriter localStringWriter = new StringWriter();
    paramException.printStackTrace(new PrintWriter(localStringWriter));
    return localStringWriter.toString();
  }
  
  /* Error */
  public void invokeViewFocused(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setPlatformViewsHandler(PlatformViewsHandler paramPlatformViewsHandler)
  {
    this.handler = paramPlatformViewsHandler;
  }
  
  public static class PlatformViewCreationRequest
  {
    public final int direction;
    public final double logicalHeight;
    public final double logicalWidth;
    public final ByteBuffer params;
    public final int viewId;
    public final String viewType;
    
    public PlatformViewCreationRequest(int paramInt1, String paramString, double paramDouble1, double paramDouble2, int paramInt2, ByteBuffer paramByteBuffer)
    {
      this.viewId = paramInt1;
      this.viewType = paramString;
      this.logicalWidth = paramDouble1;
      this.logicalHeight = paramDouble2;
      this.direction = paramInt2;
      this.params = paramByteBuffer;
    }
  }
  
  public static class PlatformViewResizeRequest
  {
    public final double newLogicalHeight;
    public final double newLogicalWidth;
    public final int viewId;
    
    public PlatformViewResizeRequest(int paramInt, double paramDouble1, double paramDouble2)
    {
      this.viewId = paramInt;
      this.newLogicalWidth = paramDouble1;
      this.newLogicalHeight = paramDouble2;
    }
  }
  
  public static class PlatformViewTouch
  {
    public final int action;
    public final int buttonState;
    public final int deviceId;
    public final Number downTime;
    public final int edgeFlags;
    public final Number eventTime;
    public final int flags;
    public final int metaState;
    public final int pointerCount;
    public final Object rawPointerCoords;
    public final Object rawPointerPropertiesList;
    public final int source;
    public final int viewId;
    public final float xPrecision;
    public final float yPrecision;
    
    PlatformViewTouch(int paramInt1, Number paramNumber1, Number paramNumber2, int paramInt2, int paramInt3, Object paramObject1, Object paramObject2, int paramInt4, int paramInt5, float paramFloat1, float paramFloat2, int paramInt6, int paramInt7, int paramInt8, int paramInt9)
    {
      this.viewId = paramInt1;
      this.downTime = paramNumber1;
      this.eventTime = paramNumber2;
      this.action = paramInt2;
      this.pointerCount = paramInt3;
      this.rawPointerPropertiesList = paramObject1;
      this.rawPointerCoords = paramObject2;
      this.metaState = paramInt4;
      this.buttonState = paramInt5;
      this.xPrecision = paramFloat1;
      this.yPrecision = paramFloat2;
      this.deviceId = paramInt6;
      this.edgeFlags = paramInt7;
      this.source = paramInt8;
      this.flags = paramInt9;
    }
  }
  
  public static abstract interface PlatformViewsHandler
  {
    public abstract void clearFocus(int paramInt);
    
    public abstract long createPlatformView(PlatformViewsChannel.PlatformViewCreationRequest paramPlatformViewCreationRequest);
    
    public abstract void disposePlatformView(int paramInt);
    
    public abstract void onTouch(PlatformViewsChannel.PlatformViewTouch paramPlatformViewTouch);
    
    public abstract void resizePlatformView(PlatformViewsChannel.PlatformViewResizeRequest paramPlatformViewResizeRequest, Runnable paramRunnable);
    
    public abstract void setDirection(int paramInt1, int paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\systemchannels\PlatformViewsChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */