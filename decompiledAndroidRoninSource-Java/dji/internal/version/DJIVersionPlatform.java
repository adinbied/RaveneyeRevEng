package dji.internal.version;

import android.content.Context;
import dji.midware.component.DJIComponentManager.PlatformType;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DJIVersionPlatform
{
  private static final String TAG = "DJIVersionPlatform";
  private static final boolean showLog = false;
  private DJIVersionBaseComponent baseComponent = null;
  private Context context = null;
  private DJIComponentManager.PlatformType platformType = DJIComponentManager.PlatformType.None;
  
  private DJIVersionBaseComponent createComponentByComponentType(DJIComponentManager.PlatformType paramPlatformType)
  {
    return null;
  }
  
  /* Error */
  private void log(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void log(String arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateValue()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void destroy()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public String getVersion()
  {
    return null;
  }
  
  /* Error */
  public void init(Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJIVersionBaseComponent arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJIComponentManager.PlatformType paramPlatformType)
  {
    updateValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\DJIVersionPlatform.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */