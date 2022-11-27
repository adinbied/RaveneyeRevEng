package io.flutter.embedding.engine.systemchannels;

import android.graphics.Rect;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.plugin.common.JSONMethodCodec;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PlatformChannel
{
  private static final String TAG = "PlatformChannel";
  public final MethodChannel channel;
  protected final MethodChannel.MethodCallHandler parsingMethodCallHandler = new MethodChannel.MethodCallHandler()
  {
    /* Error */
    public void onMethodCall(io.flutter.plugin.common.MethodCall arg1, io.flutter.plugin.common.MethodChannel.Result arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  };
  private PlatformMessageHandler platformMessageHandler;
  
  public PlatformChannel(DartExecutor paramDartExecutor)
  {
    paramDartExecutor = new MethodChannel(paramDartExecutor, "flutter/platform", JSONMethodCodec.INSTANCE);
    this.channel = paramDartExecutor;
    paramDartExecutor.setMethodCallHandler(this.parsingMethodCallHandler);
  }
  
  private AppSwitcherDescription decodeAppSwitcherDescription(JSONObject paramJSONObject)
    throws JSONException
  {
    return null;
  }
  
  private ArrayList<Rect> decodeExclusionRects(JSONArray paramJSONArray)
    throws JSONException
  {
    return null;
  }
  
  private int decodeOrientations(JSONArray paramJSONArray)
    throws JSONException, NoSuchFieldException
  {
    return 0;
  }
  
  private SystemChromeStyle decodeSystemChromeStyle(JSONObject paramJSONObject)
    throws JSONException, NoSuchFieldException
  {
    return null;
  }
  
  private List<SystemUiOverlay> decodeSystemUiOverlays(JSONArray paramJSONArray)
    throws JSONException, NoSuchFieldException
  {
    return null;
  }
  
  private ArrayList<HashMap<String, Integer>> encodeExclusionRects(List<Rect> paramList)
  {
    return null;
  }
  
  public void setPlatformMessageHandler(PlatformMessageHandler paramPlatformMessageHandler)
  {
    this.platformMessageHandler = paramPlatformMessageHandler;
  }
  
  public static class AppSwitcherDescription
  {
    public final int color;
    public final String label;
    
    public AppSwitcherDescription(int paramInt, String paramString)
    {
      this.color = paramInt;
      this.label = paramString;
    }
  }
  
  public static enum Brightness
  {
    private String encodedName;
    
    static
    {
      Brightness localBrightness = new Brightness("DARK", 1, "Brightness.dark");
      DARK = localBrightness;
      $VALUES = new Brightness[] { LIGHT, localBrightness };
    }
    
    private Brightness(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static Brightness fromValue(String paramString)
      throws NoSuchFieldException
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        Brightness localBrightness = localObject[i];
        if (localBrightness.encodedName.equals(paramString)) {
          return localBrightness;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No such Brightness: ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchFieldException(((StringBuilder)localObject).toString());
    }
  }
  
  public static enum ClipboardContentFormat
  {
    private String encodedName;
    
    static
    {
      ClipboardContentFormat localClipboardContentFormat = new ClipboardContentFormat("PLAIN_TEXT", 0, "text/plain");
      PLAIN_TEXT = localClipboardContentFormat;
      $VALUES = new ClipboardContentFormat[] { localClipboardContentFormat };
    }
    
    private ClipboardContentFormat(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static ClipboardContentFormat fromValue(String paramString)
      throws NoSuchFieldException
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        ClipboardContentFormat localClipboardContentFormat = localObject[i];
        if (localClipboardContentFormat.encodedName.equals(paramString)) {
          return localClipboardContentFormat;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No such ClipboardContentFormat: ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchFieldException(((StringBuilder)localObject).toString());
    }
  }
  
  public static enum DeviceOrientation
  {
    private String encodedName;
    
    static
    {
      PORTRAIT_DOWN = new DeviceOrientation("PORTRAIT_DOWN", 1, "DeviceOrientation.portraitDown");
      LANDSCAPE_LEFT = new DeviceOrientation("LANDSCAPE_LEFT", 2, "DeviceOrientation.landscapeLeft");
      DeviceOrientation localDeviceOrientation = new DeviceOrientation("LANDSCAPE_RIGHT", 3, "DeviceOrientation.landscapeRight");
      LANDSCAPE_RIGHT = localDeviceOrientation;
      $VALUES = new DeviceOrientation[] { PORTRAIT_UP, PORTRAIT_DOWN, LANDSCAPE_LEFT, localDeviceOrientation };
    }
    
    private DeviceOrientation(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static DeviceOrientation fromValue(String paramString)
      throws NoSuchFieldException
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        DeviceOrientation localDeviceOrientation = localObject[i];
        if (localDeviceOrientation.encodedName.equals(paramString)) {
          return localDeviceOrientation;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No such DeviceOrientation: ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchFieldException(((StringBuilder)localObject).toString());
    }
  }
  
  public static enum HapticFeedbackType
  {
    private final String encodedName;
    
    static
    {
      LIGHT_IMPACT = new HapticFeedbackType("LIGHT_IMPACT", 1, "HapticFeedbackType.lightImpact");
      MEDIUM_IMPACT = new HapticFeedbackType("MEDIUM_IMPACT", 2, "HapticFeedbackType.mediumImpact");
      HEAVY_IMPACT = new HapticFeedbackType("HEAVY_IMPACT", 3, "HapticFeedbackType.heavyImpact");
      HapticFeedbackType localHapticFeedbackType = new HapticFeedbackType("SELECTION_CLICK", 4, "HapticFeedbackType.selectionClick");
      SELECTION_CLICK = localHapticFeedbackType;
      $VALUES = new HapticFeedbackType[] { STANDARD, LIGHT_IMPACT, MEDIUM_IMPACT, HEAVY_IMPACT, localHapticFeedbackType };
    }
    
    private HapticFeedbackType(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static HapticFeedbackType fromValue(String paramString)
      throws NoSuchFieldException
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        HapticFeedbackType localHapticFeedbackType = localObject[i];
        if ((localHapticFeedbackType.encodedName != null) || (paramString != null))
        {
          String str = localHapticFeedbackType.encodedName;
          if ((str == null) || (!str.equals(paramString))) {}
        }
        else
        {
          return localHapticFeedbackType;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No such HapticFeedbackType: ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchFieldException(((StringBuilder)localObject).toString());
    }
  }
  
  public static abstract interface PlatformMessageHandler
  {
    public abstract CharSequence getClipboardData(PlatformChannel.ClipboardContentFormat paramClipboardContentFormat);
    
    public abstract List<Rect> getSystemGestureExclusionRects();
    
    public abstract void playSystemSound(PlatformChannel.SoundType paramSoundType);
    
    public abstract void popSystemNavigator();
    
    public abstract void restoreSystemUiOverlays();
    
    public abstract void setApplicationSwitcherDescription(PlatformChannel.AppSwitcherDescription paramAppSwitcherDescription);
    
    public abstract void setClipboardData(String paramString);
    
    public abstract void setPreferredOrientations(int paramInt);
    
    public abstract void setSystemGestureExclusionRects(ArrayList<Rect> paramArrayList);
    
    public abstract void setSystemUiOverlayStyle(PlatformChannel.SystemChromeStyle paramSystemChromeStyle);
    
    public abstract void showSystemOverlays(List<PlatformChannel.SystemUiOverlay> paramList);
    
    public abstract void vibrateHapticFeedback(PlatformChannel.HapticFeedbackType paramHapticFeedbackType);
  }
  
  public static enum SoundType
  {
    private final String encodedName;
    
    static
    {
      SoundType localSoundType = new SoundType("CLICK", 0, "SystemSoundType.click");
      CLICK = localSoundType;
      $VALUES = new SoundType[] { localSoundType };
    }
    
    private SoundType(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static SoundType fromValue(String paramString)
      throws NoSuchFieldException
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        SoundType localSoundType = localObject[i];
        if (localSoundType.encodedName.equals(paramString)) {
          return localSoundType;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No such SoundType: ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchFieldException(((StringBuilder)localObject).toString());
    }
  }
  
  public static class SystemChromeStyle
  {
    public final Integer statusBarColor;
    public final PlatformChannel.Brightness statusBarIconBrightness;
    public final Integer systemNavigationBarColor;
    public final Integer systemNavigationBarDividerColor;
    public final PlatformChannel.Brightness systemNavigationBarIconBrightness;
    
    public SystemChromeStyle(Integer paramInteger1, PlatformChannel.Brightness paramBrightness1, Integer paramInteger2, PlatformChannel.Brightness paramBrightness2, Integer paramInteger3)
    {
      this.statusBarColor = paramInteger1;
      this.statusBarIconBrightness = paramBrightness1;
      this.systemNavigationBarColor = paramInteger2;
      this.systemNavigationBarIconBrightness = paramBrightness2;
      this.systemNavigationBarDividerColor = paramInteger3;
    }
  }
  
  public static enum SystemUiOverlay
  {
    private String encodedName;
    
    static
    {
      SystemUiOverlay localSystemUiOverlay = new SystemUiOverlay("BOTTOM_OVERLAYS", 1, "SystemUiOverlay.bottom");
      BOTTOM_OVERLAYS = localSystemUiOverlay;
      $VALUES = new SystemUiOverlay[] { TOP_OVERLAYS, localSystemUiOverlay };
    }
    
    private SystemUiOverlay(String paramString)
    {
      this.encodedName = paramString;
    }
    
    static SystemUiOverlay fromValue(String paramString)
      throws NoSuchFieldException
    {
      Object localObject = values();
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        SystemUiOverlay localSystemUiOverlay = localObject[i];
        if (localSystemUiOverlay.encodedName.equals(paramString)) {
          return localSystemUiOverlay;
        }
        i += 1;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No such SystemUiOverlay: ");
      ((StringBuilder)localObject).append(paramString);
      throw new NoSuchFieldException(((StringBuilder)localObject).toString());
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\systemchannels\PlatformChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */