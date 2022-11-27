package dji.internal.logics;

import dji.common.bus.EventBus;
import dji.common.bus.LogicEventBus;
import dji.midware.data.config.P3.ProductType;
import dji.midware.data.model.P3.DataOsdGetPushCommon;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.schedulers.Schedulers;

public class CompassLogic
{
  private static final String ABNORMAL = "Abnormal";
  private static final String CALIBRATE = "Calibrate";
  private static final String CALIBRATE_COMPASS = "Calibrate Compass.";
  private static final String CHECK_DIRECTION = "Check the installation direction.";
  private static final String DETAILS = "Detail";
  private static final String KEEP_AWAY_DISTURBANCE = "Keep away from ground magnetic disturbance.";
  private static final String NORMAL = "Normal";
  private static final String RESTART = "Restart the aircraft.";
  private static final String UNKNOWN = "GPS status unknown.";
  private boolean compassError = false;
  private boolean needRefresh = true;
  private volatile Message previousButtonMessage;
  private volatile Message previousMessage;
  private int previousValue;
  
  private CompassLogic()
  {
    Subscription localSubscription1 = LogicEventBus.getInstance().register(ProductType.class).subscribeOn(Schedulers.computation()).subscribe(new -..Lambda.CompassLogic.1iBzUQCCRs6jXvXQb8bRwR9bFhs(this));
    Subscription localSubscription2 = LogicEventBus.getInstance().register(LogicManager.SensorShouldUpdateEvent.class).subscribeOn(Schedulers.computation()).subscribe(new -..Lambda.CompassLogic.qsUi3_AgTIBWqTfQoljQ3995h6U(this));
    Subscription localSubscription3 = LogicEventBus.getInstance().register(DataOsdGetPushCommon.class).subscribeOn(Schedulers.computation()).subscribe(new -..Lambda.CompassLogic.0uzcb9dpdyk_vWSaAc0o755XaWo(this));
    LogicManager.getInstance().addSubscription(localSubscription1);
    LogicManager.getInstance().addSubscription(localSubscription2);
    LogicManager.getInstance().addSubscription(localSubscription3);
  }
  
  public static CompassLogic getInstance()
  {
    return HOLDER.instance;
  }
  
  /* Error */
  private void updateCompass()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init()
  {
    this.previousMessage = null;
    this.previousButtonMessage = null;
  }
  
  public static final class CompassButtonEvent
  {
    private Message message;
    
    public CompassButtonEvent(Message paramMessage)
    {
      this.message = paramMessage;
    }
    
    public Message getMessage()
    {
      return this.message;
    }
  }
  
  public static final class CompassEvent
  {
    private Message message;
    
    public CompassEvent(Message paramMessage)
    {
      this.message = paramMessage;
    }
    
    public Message getMessage()
    {
      return this.message;
    }
  }
  
  private static final class HOLDER
  {
    private static CompassLogic instance = new CompassLogic(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\CompassLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */