package dji.sdksharedlib;

import dji.internal.mock.MockDJISDKCache;
import dji.sdksharedlib.hardware.DJISDKCacheHWAbstractionLayer;
import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.listener.DJIParamAccessListener;
import dji.sdksharedlib.listener.DJISDKCacheInteractionListener;
import dji.sdksharedlib.listener.DJISDKCacheListenerLayer;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import dji.sdksharedlib.store.DJISDKCacheStoreLayer;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.functions.Action1;
import dji.thirdparty.rx.subscriptions.CompositeSubscription;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DJISDKCache
  implements IDJISDKCache
{
  private static final String TAG = "DJISDKCache";
  public DJISDKCacheHWAbstractionLayer halLayer;
  protected final List<DJISDKCacheInteractionListener> interactionListenerList = new CopyOnWriteArrayList();
  protected boolean isInitialized = false;
  public DJISDKCacheListenerLayer listenerLayer;
  public DJISDKCacheStoreLayer storeLayer;
  private CompositeSubscription subscriptions = new CompositeSubscription();
  
  public static DJISDKCache getInstance()
  {
    if ("release".toLowerCase().equals("mock")) {
      return MockDJISDKCache.getInstance();
    }
    return SingletonHolder.instance;
  }
  
  /* Error */
  public void addMockAbstraction(int arg1, String arg2, Class<? extends dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction> arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void addSubscription(Subscription paramSubscription)
  {
    this.subscriptions.add(paramSubscription);
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public DJISDKCacheParamValue getAvailableValue(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  /* Error */
  public void getValue(DJISDKCacheKey arg1, dji.sdksharedlib.listener.DJIGetCallback arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected DJIParamAccessListener getValueChangeListener()
  {
    new DJIParamAccessListener()
    {
      /* Error */
      public void onValueChange(DJISDKCacheKey arg1, DJISDKCacheParamValue arg2, DJISDKCacheParamValue arg3)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void performAction(DJISDKCacheKey arg1, dji.sdksharedlib.listener.DJIActionCallback arg2, Object... arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean removeInteractionListener(DJISDKCacheInteractionListener paramDJISDKCacheInteractionListener)
  {
    return this.interactionListenerList.remove(paramDJISDKCacheInteractionListener);
  }
  
  public void removeSubscription(Subscription paramSubscription)
  {
    this.subscriptions.remove(paramSubscription);
  }
  
  /* Error */
  public void setInteractionListener(DJISDKCacheInteractionListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void setValue(DJISDKCacheKey arg1, Object arg2, dji.sdksharedlib.listener.DJISetCallback arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean startListeningForUpdates(DJISDKCacheKey paramDJISDKCacheKey, DJIParamAccessListener paramDJIParamAccessListener, boolean paramBoolean)
  {
    return false;
  }
  
  public void stopListening(DJIParamAccessListener paramDJIParamAccessListener)
  {
    this.listenerLayer.stopListening(paramDJIParamAccessListener);
  }
  
  public void stopListeningOnKey(DJISDKCacheKey paramDJISDKCacheKey, DJIParamAccessListener paramDJIParamAccessListener)
  {
    this.listenerLayer.stopListeningOnKeyPath(paramDJISDKCacheKey, paramDJIParamAccessListener);
  }
  
  private static class SingletonHolder
  {
    private static DJISDKCache instance = new DJISDKCache();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\DJISDKCache.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */