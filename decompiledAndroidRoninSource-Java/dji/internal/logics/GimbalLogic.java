package dji.internal.logics;

import dji.common.bus.EventBus;
import dji.common.bus.LogicEventBus;
import dji.midware.data.model.P3.DataGimbalGetPushParams;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.schedulers.Schedulers;

public class GimbalLogic
{
  private static final String ABNORMAL = "Abnormal";
  private static final String GIMBAL_STUCK = "Gimbal Motor Overloaded";
  private static final String GIMBAL_STUCK_TIP = "Remove gimbal clamp. Contact DJI Support if this error persists.";
  private static final String NORMAL = "Normal";
  private volatile Boolean previousValue;
  
  private GimbalLogic()
  {
    Subscription localSubscription = LogicEventBus.getInstance().register(DataGimbalGetPushParams.class).subscribeOn(Schedulers.computation()).subscribe(new -..Lambda.GimbalLogic.1NlGW8lIPX68YPGo3rVnho8xbFQ(this));
    LogicManager.getInstance().addSubscription(localSubscription);
  }
  
  public static GimbalLogic getInstance()
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
    this.previousValue = null;
  }
  
  public static final class GimbalEvent
  {
    private Message message;
    
    public GimbalEvent(Message paramMessage)
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
    private static GimbalLogic instance = new GimbalLogic(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\GimbalLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */