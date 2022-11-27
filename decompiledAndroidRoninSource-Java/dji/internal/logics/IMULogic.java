package dji.internal.logics;

import dji.common.bus.EventBus;
import dji.common.bus.LogicEventBus;
import dji.midware.data.model.P3.DataFlycGetPushCheckStatus;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.schedulers.Schedulers;

public class IMULogic
{
  private static final String ABNORMAL = "Abnormal";
  private static final String CALIBRATE = "Calibrate IMU.";
  private static final String CHECK = "Check the installation direction.";
  private static final String NORMAL = "Normal";
  private static final String POSITION_ERROR = "IMU installation position Error.";
  private static final String RESTART = "Restart the aircraft.";
  private static final String UNKNOWN = "IMU unknown.";
  private static final String WARMING_UP = "Warming up.";
  private boolean gotValueOnce = false;
  private volatile Message previousMessage = null;
  private int previousValue;
  
  private IMULogic()
  {
    Subscription localSubscription = LogicEventBus.getInstance().register(LogicManager.SensorShouldUpdateEvent.class, DataFlycGetPushCheckStatus.class).subscribeOn(Schedulers.computation()).subscribe(new -..Lambda.IMULogic.up0WyrdhlWolIcdocGKVlC56UKo(this));
    LogicManager.getInstance().addSubscription(localSubscription);
  }
  
  public static IMULogic getInstance()
  {
    return HOLDER.instance;
  }
  
  /* Error */
  private void updateSensor()
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
    private static IMULogic instance = new IMULogic(null);
  }
  
  public static final class IMUEvent
  {
    private Message message;
    
    public IMUEvent(Message paramMessage)
    {
      this.message = paramMessage;
    }
    
    public Message getMessage()
    {
      return this.message;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\IMULogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */