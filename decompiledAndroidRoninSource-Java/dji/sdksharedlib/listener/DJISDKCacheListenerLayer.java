package dji.sdksharedlib.listener;

import dji.sdksharedlib.keycatalog.DJISDKCacheKey;
import dji.sdksharedlib.store.DJISDKCacheParamValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DJISDKCacheListenerLayer
{
  private static final String TAG = "DJISDKCacheListenerLayer";
  private DJIParamAccessListener anyValueChangeListener;
  private ConcurrentHashMap<DJISDKCacheKey, ConcurrentHashMap<DJIParamAccessListener, DJISDKCacheListenerAssistant>> keyListenersMap = null;
  private Lock lock = new ReentrantLock();
  private ReentrantReadWriteLock mListenersLock = new ReentrantReadWriteLock();
  private ArrayList<OnChangeListener> onChangeListeners;
  private ReentrantLock recyleLock = new ReentrantLock();
  private List<ValueChangeRunnable> recyleRunnable;
  
  private Runnable getRunnable(DJIParamAccessListener paramDJIParamAccessListener, DJISDKCacheKey paramDJISDKCacheKey, DJISDKCacheParamValue paramDJISDKCacheParamValue1, DJISDKCacheParamValue paramDJISDKCacheParamValue2)
  {
    return null;
  }
  
  /* Error */
  private void notifyAddEvent(DJISDKCacheKey arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void notifyRemoveListenerEvent(DJISDKCacheKey arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void addOnChangeListener(OnChangeListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void destroy()
  {
    this.keyListenersMap = null;
    this.recyleRunnable = null;
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public int numberOfListenersOfKeyPath(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return 0;
  }
  
  /* Error */
  public void removeOnChangeListener(OnChangeListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public Set<DJIParamAccessListener> setOfListenersOfKeyPath(DJISDKCacheKey paramDJISDKCacheKey)
  {
    return null;
  }
  
  public void startListeningForUpdates(DJIParamAccessListener paramDJIParamAccessListener)
  {
    this.anyValueChangeListener = paramDJIParamAccessListener;
  }
  
  public boolean startListeningForUpdates(DJISDKCacheKey paramDJISDKCacheKey, DJIParamAccessListener paramDJIParamAccessListener)
  {
    return startListeningForUpdates(paramDJISDKCacheKey, paramDJIParamAccessListener, true);
  }
  
  public boolean startListeningForUpdates(DJISDKCacheKey paramDJISDKCacheKey, DJIParamAccessListener paramDJIParamAccessListener, boolean paramBoolean)
  {
    return false;
  }
  
  /* Error */
  public void stopListening(DJIParamAccessListener arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public boolean stopListeningOnKeyPath(DJISDKCacheKey paramDJISDKCacheKey, DJIParamAccessListener paramDJIParamAccessListener)
  {
    return false;
  }
  
  /* Error */
  public void valueChange(DJISDKCacheKey arg1, DJISDKCacheParamValue arg2, DJISDKCacheParamValue arg3)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public static abstract interface OnChangeListener
  {
    public abstract void onAdd(DJISDKCacheKey paramDJISDKCacheKey);
    
    public abstract void onRemove(DJISDKCacheKey paramDJISDKCacheKey);
  }
  
  private class ValueChangeRunnable
    implements Runnable
  {
    public DJISDKCacheKey key;
    public DJIParamAccessListener listener;
    public DJISDKCacheParamValue newValue;
    public DJISDKCacheParamValue oldValue;
    
    public ValueChangeRunnable() {}
    
    /* Error */
    public void reset()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\listener\DJISDKCacheListenerLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */