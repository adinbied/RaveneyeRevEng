package dji.sdksharedlib.hardware.abstractions.airlink.lb;

import dji.common.error.DJIError;
import dji.common.util.LatchHelper;
import dji.midware.data.model.P3.DataDm368GetPushStatus;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import org.greenrobot.eventbus.EventBus;

public class LB2AbstractionHelper
{
  private static final int EXT_VIDEO_SOURCE = 0;
  private static final int LB_VIDEO_SOURCE = 1;
  private static final int NORMAL_VIDEO_SOURCE = 2;
  private static final int RETRY_TIMES_MAX = 3;
  private static final String TAG = "DJILB2Helper";
  private final int INVALID_PERCENT = -1;
  int dualPercentCache;
  boolean isEXTVideoInputPortEnabled;
  private final LatchHelper latch = LatchHelper.getInstance();
  private Lightbridge2Abstraction lb2AirLink;
  int lbPercentCache;
  private DataDm368GetPushStatus pushStatus = DataDm368GetPushStatus.getInstance();
  private int retryTimes;
  
  public LB2AbstractionHelper(Lightbridge2Abstraction paramLightbridge2Abstraction)
  {
    this.lb2AirLink = paramLightbridge2Abstraction;
  }
  
  /* Error */
  private void encodeModeChangeToDual()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void encodeModeChangeToSingle()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void refreshCacheAndUpdateVideoChannel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private DJIError refreshLBPercentCache()
  {
    return null;
  }
  
  /* Error */
  private void updateVideoChannel()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void destroy()
  {
    EventBus.getDefault().unregister(this);
  }
  
  /* Error */
  public void onDualPercentChange(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onEXTVideoInputPortEnabledChange(boolean arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  @org.greenrobot.eventbus.Subscribe(threadMode=org.greenrobot.eventbus.ThreadMode.BACKGROUND)
  public void onEvent3BackgroundThread(dji.midware.usb.P3.LB2VideoController.EncodeMode arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onLBPercentChange(int arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public DJIError refreshCache()
  {
    return null;
  }
  
  /* Error */
  public void setup()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\hardware\abstractions\airlink\lb\LB2AbstractionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */