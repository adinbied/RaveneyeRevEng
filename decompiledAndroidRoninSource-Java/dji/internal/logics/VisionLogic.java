package dji.internal.logics;

import dji.common.bus.EventBus;
import dji.common.bus.LogicEventBus;
import dji.midware.data.model.P3.Data2100GetPushCheckStatus;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.schedulers.Schedulers;

public class VisionLogic
{
  private static final String ABNORMAL = "Abnormal";
  private static final String BACK_VISION_CALI = "Backward Vision Sensor Calibration Error";
  private static final String DOWN_VISION_CALI = "Downward Vision Sensor Calibration Error";
  private static final String FRONT_VISION_CALI = "Forward Vision Sensor Calibration Error";
  private static final String NORMAL = "Normal";
  private static final String VISION_ERROR = "Vision System Error";
  private volatile Message previousMessage;
  
  private VisionLogic()
  {
    updateVisionStatus();
    Subscription localSubscription = LogicEventBus.getInstance().register(Data2100GetPushCheckStatus.class).subscribeOn(Schedulers.computation()).subscribe(new -..Lambda.VisionLogic.2hCsukFmbIEMy3f_VodEqsW1EQE(this));
    LogicManager.getInstance().addSubscription(localSubscription);
  }
  
  public static VisionLogic getInstance()
  {
    return HOLDER.instance;
  }
  
  /* Error */
  private void updateVisionStatus()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init()
  {
    this.previousMessage = null;
  }
  
  private static final class HOLDER
  {
    private static VisionLogic instance = new VisionLogic(null);
  }
  
  public static final class VisionEvent
  {
    private Message message;
    
    public VisionEvent(Message paramMessage)
    {
      this.message = paramMessage;
    }
    
    public Message getMessage()
    {
      return this.message;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\VisionLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */