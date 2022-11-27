package dji.internal.version;

import java.util.LinkedList;
import java.util.List;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class VersionController
{
  private static final String TAG = "VersionController";
  private static VersionController instance;
  private DJIVersionCamera djiVersionCamera;
  private DJIVersionRC djiVersionRC;
  private String lastVersion;
  private List<VersionChangeObserver> listenerList = new LinkedList();
  private DJIVersionPlatform versionPlatform;
  
  /* Error */
  private void checkVersion(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static VersionController getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new VersionController();
      }
      VersionController localVersionController = instance;
      return localVersionController;
    }
    finally {}
  }
  
  /* Error */
  private void invokeListeners(String arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public boolean addListener(VersionChangeObserver paramVersionChangeObserver)
  {
    return this.listenerList.add(paramVersionChangeObserver);
  }
  
  public void cleanListeners()
  {
    this.listenerList.clear();
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String getCameraVersion()
  {
    return null;
  }
  
  public DJIVersionRC getDJIVersionRC()
  {
    return this.djiVersionRC;
  }
  
  public String getFirmwarePackageVersion()
  {
    return this.lastVersion;
  }
  
  /* Error */
  public void init(android.content.Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJIVersionCamera paramDJIVersionCamera) {}
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJIVersionPlatform paramDJIVersionPlatform)
  {
    checkVersion(this.versionPlatform.getVersion());
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJIVersionRC paramDJIVersionRC) {}
  
  public boolean removeListener(VersionChangeObserver paramVersionChangeObserver)
  {
    return this.listenerList.remove(paramVersionChangeObserver);
  }
  
  public static enum Key
  {
    static
    {
      Key localKey = new Key("Product", 0);
      Product = localKey;
      $VALUES = new Key[] { localKey };
    }
    
    private Key() {}
  }
  
  public static abstract interface VersionChangeObserver
  {
    public abstract void onVersionChange(String paramString1, String paramString2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\VersionController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */