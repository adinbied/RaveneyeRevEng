package dji.internal.version;

import android.os.Handler;
import dji.midware.interfaces.DJIDataCallBack;
import dji.midware.util.BackgroundLooper;
import java.util.ArrayList;
import java.util.HashMap;

public class DJIDeviceVersionRequest
{
  private static final int MAX_RETRY = 3;
  private static final String TAG = "FirmwareVersionRequest";
  private ResultCallBack callback = null;
  private String[] firmwareList = null;
  private HashMap<String, DJIDeviceVersion> firmwareMap = null;
  private ArrayList<DJIDeviceVersion> firmwareVersionList = null;
  private Handler handler;
  private int retryTime;
  private ArrayList<DJIDeviceVersion> tmpList;
  
  public DJIDeviceVersionRequest(String[] paramArrayOfString, ResultCallBack paramResultCallBack)
  {
    int i = 0;
    this.retryTime = 0;
    this.firmwareList = paramArrayOfString;
    this.firmwareMap = new HashMap();
    this.firmwareVersionList = new ArrayList();
    int j = paramArrayOfString.length;
    while (i < j)
    {
      String str = paramArrayOfString[i];
      DJIDeviceVersion localDJIDeviceVersion = new DJIDeviceVersion(str);
      this.firmwareMap.put(str, localDJIDeviceVersion);
      this.firmwareVersionList.add(localDJIDeviceVersion);
      i += 1;
    }
    this.callback = paramResultCallBack;
    this.retryTime = 3;
    this.handler = new Handler(BackgroundLooper.getLooper());
    getDeviceVersionFromComponent();
  }
  
  /* Error */
  private void finishGetVersion(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void getDeviceVersionFromComponent()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void getNextDeviceVersion()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void log(String arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private class GetVersionCallBack
    implements DJIDataCallBack
  {
    private DJIDeviceVersion firmwareVersion;
    
    public GetVersionCallBack(DJIDeviceVersion paramDJIDeviceVersion)
    {
      this.firmwareVersion = paramDJIDeviceVersion;
    }
    
    /* Error */
    public void onFailure(dji.midware.data.config.P3.Ccode arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void onSuccess(Object arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
  
  public static abstract interface ResultCallBack
  {
    public abstract void onResultCallBack(boolean paramBoolean, ArrayList<DJIDeviceVersion> paramArrayList);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\version\DJIDeviceVersionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */