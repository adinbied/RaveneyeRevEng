package io.flutter.plugin.platform;

import android.content.Context;
import android.view.MotionEvent.PointerCoords;
import android.view.MotionEvent.PointerProperties;
import android.view.View;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewCreationRequest;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewsHandler;
import io.flutter.plugin.editing.TextInputPlugin;
import io.flutter.view.AccessibilityBridge;
import io.flutter.view.TextureRegistry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class PlatformViewsController
  implements PlatformViewsAccessibilityDelegate
{
  private static final int MINIMAL_SDK = 20;
  private static final String TAG = "PlatformViewsController";
  private final AccessibilityEventsDelegate accessibilityEventsDelegate = new AccessibilityEventsDelegate();
  private final PlatformViewsChannel.PlatformViewsHandler channelHandler = new PlatformViewsChannel.PlatformViewsHandler()
  {
    /* Error */
    private void ensureValidAndroidVersion()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void clearFocus(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    public long createPlatformView(PlatformViewsChannel.PlatformViewCreationRequest paramAnonymousPlatformViewCreationRequest)
    {
      return 277884275L;
    }
    
    /* Error */
    public void disposePlatformView(int arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onTouch(io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewTouch arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void resizePlatformView(io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewResizeRequest arg1, Runnable arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void setDirection(int arg1, int arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
  };
  private Context context;
  private final HashMap<Context, View> contextToPlatformView = new HashMap();
  private View flutterView;
  private PlatformViewsChannel platformViewsChannel;
  private final PlatformViewRegistryImpl registry = new PlatformViewRegistryImpl();
  private TextInputPlugin textInputPlugin;
  private TextureRegistry textureRegistry;
  final HashMap<Integer, VirtualDisplayController> vdControllers = new HashMap();
  
  /* Error */
  private void flushAllViews()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void lockInputConnection(VirtualDisplayController arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static MotionEvent.PointerCoords parsePointerCoords(Object paramObject, float paramFloat)
  {
    paramObject = (List)paramObject;
    MotionEvent.PointerCoords localPointerCoords = new MotionEvent.PointerCoords();
    localPointerCoords.orientation = ((float)((Double)((List)paramObject).get(0)).doubleValue());
    localPointerCoords.pressure = ((float)((Double)((List)paramObject).get(1)).doubleValue());
    localPointerCoords.size = ((float)((Double)((List)paramObject).get(2)).doubleValue());
    localPointerCoords.toolMajor = ((float)((Double)((List)paramObject).get(3)).doubleValue() * paramFloat);
    localPointerCoords.toolMinor = ((float)((Double)((List)paramObject).get(4)).doubleValue() * paramFloat);
    localPointerCoords.touchMajor = ((float)((Double)((List)paramObject).get(5)).doubleValue() * paramFloat);
    localPointerCoords.touchMinor = ((float)((Double)((List)paramObject).get(6)).doubleValue() * paramFloat);
    localPointerCoords.x = ((float)((Double)((List)paramObject).get(7)).doubleValue() * paramFloat);
    localPointerCoords.y = ((float)((Double)((List)paramObject).get(8)).doubleValue() * paramFloat);
    return localPointerCoords;
  }
  
  private static List<MotionEvent.PointerCoords> parsePointerCoordsList(Object paramObject, float paramFloat)
  {
    Object localObject = (List)paramObject;
    paramObject = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((List)paramObject).add(parsePointerCoords(((Iterator)localObject).next(), paramFloat));
    }
    return (List<MotionEvent.PointerCoords>)paramObject;
  }
  
  private static MotionEvent.PointerProperties parsePointerProperties(Object paramObject)
  {
    paramObject = (List)paramObject;
    MotionEvent.PointerProperties localPointerProperties = new MotionEvent.PointerProperties();
    localPointerProperties.id = ((Integer)((List)paramObject).get(0)).intValue();
    localPointerProperties.toolType = ((Integer)((List)paramObject).get(1)).intValue();
    return localPointerProperties;
  }
  
  private static List<MotionEvent.PointerProperties> parsePointerPropertiesList(Object paramObject)
  {
    Object localObject = (List)paramObject;
    paramObject = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((List)paramObject).add(parsePointerProperties(((Iterator)localObject).next()));
    }
    return (List<MotionEvent.PointerProperties>)paramObject;
  }
  
  private int toPhysicalPixels(double paramDouble)
  {
    return 0;
  }
  
  /* Error */
  private void unlockInputConnection(VirtualDisplayController arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static boolean validateDirection(int paramInt)
  {
    boolean bool = true;
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        return true;
      }
      bool = false;
    }
    return bool;
  }
  
  /* Error */
  private void validateVirtualDisplayDimensions(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void attach(Context arg1, TextureRegistry arg2, io.flutter.embedding.engine.dart.DartExecutor arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void attachAccessibilityBridge(AccessibilityBridge paramAccessibilityBridge)
  {
    this.accessibilityEventsDelegate.setAccessibilityBridge(paramAccessibilityBridge);
  }
  
  public void attachTextInputPlugin(TextInputPlugin paramTextInputPlugin)
  {
    this.textInputPlugin = paramTextInputPlugin;
  }
  
  /* Error */
  public void attachToView(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean checkInputConnectionProxy(View paramView)
  {
    return false;
  }
  
  /* Error */
  public void detach()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void detachAccessibiltyBridge()
  {
    this.accessibilityEventsDelegate.setAccessibilityBridge(null);
  }
  
  /* Error */
  public void detachFromView()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void detachTextInputPlugin()
  {
    this.textInputPlugin = null;
  }
  
  public View getPlatformViewById(Integer paramInteger)
  {
    return null;
  }
  
  public PlatformViewRegistry getRegistry()
  {
    return this.registry;
  }
  
  public void onFlutterViewDestroyed()
  {
    flushAllViews();
  }
  
  public void onPreEngineRestart()
  {
    flushAllViews();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\plugin\platform\PlatformViewsController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */