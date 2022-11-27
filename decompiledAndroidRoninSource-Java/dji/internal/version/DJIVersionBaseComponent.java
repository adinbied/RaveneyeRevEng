package dji.internal.version;

import android.os.Handler;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class DJIVersionBaseComponent
{
  private static final String TAG = "DJIVersionBaseComponent";
  private static final boolean showLog = false;
  private String componentVersion = null;
  private ArrayList<DJIDeviceVersion> djiDeviceVersionList = null;
  private String djiDeviceVersionListSaveKey = null;
  private Runnable getVersionRunnable = null;
  private Handler handler = null;
  private boolean isGettingVersion = false;
  
  private int checkMatch(DJIModelUpgradePackList.DJIUpgradePack paramDJIUpgradePack, ArrayList<DJIDeviceVersion> paramArrayList)
  {
    return 0;
  }
  
  public static String getErrorInfoFromException(Exception paramException)
  {
    try
    {
      StringWriter localStringWriter = new StringWriter();
      paramException.printStackTrace(new PrintWriter(localStringWriter));
      paramException = new StringBuilder();
      paramException.append("\r\n");
      paramException.append(localStringWriter.toString());
      paramException.append("\r\n");
      paramException = paramException.toString();
      return paramException;
    }
    catch (Exception paramException)
    {
      for (;;) {}
    }
    return "bad getErrorInfoFromException";
  }
  
  private ArrayList<DJIDeviceVersion> getLocalDJIDeviceVersionList()
  {
    return null;
  }
  
  private String getLocalValue(String paramString)
    throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
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
  private void saveToLocalDJIDeviceVersionList(ArrayList<DJIDeviceVersion> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void setLocalValue(String arg1, String arg2)
    throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateComponentVersion()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract String getComponentName();
  
  public String getComponentVersion()
  {
    return this.componentVersion;
  }
  
  public String getDJIDeviceVersionListStr()
  {
    return null;
  }
  
  protected abstract ArrayList<DJIModelUpgradePackList.DJIUpgradePack> getDJIUpgradePackList(DJIModelUpgradePackList paramDJIModelUpgradePackList);
  
  protected abstract String[] getFirmwareList();
  
  protected abstract String getVersion(DJIModelUpgradePackList.DJIUpgradePack paramDJIUpgradePack);
  
  /* Error */
  public void init(android.content.Context arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Subscribe(threadMode=ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(DJIRemoteVersionInfo paramDJIRemoteVersionInfo)
  {
    updateComponentVersion();
  }
  
  /* Error */
  protected void requestGetVersionDelay()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void startGetVersion()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void testStartGetVersion()
  {
    startGetVersion();
  }
  
  /* Error */
  public void uninit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public static class DJIDeviceVersionList
  {
    public ArrayList<DJIDeviceVersion> list;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\DJIVersionBaseComponent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */