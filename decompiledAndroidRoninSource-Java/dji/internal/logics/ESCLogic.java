package dji.internal.logics;

import dji.common.bus.EventBus;
import dji.common.bus.LogicEventBus;
import dji.midware.data.model.P3.DataOsdGetPushCommon;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.schedulers.Schedulers;

public class ESCLogic
{
  private static final String ABNORMAL = "Abnormal";
  private static final String BAROMETER_ERROR = "Barometer Error. Land Aircraft Slowly.";
  private static final String ESC_ERROR = "ESCs Error.";
  private static final String ESC_ERROR_SKY = "ESCs Error. Return to Home Point Now.";
  private static final String NORMAL = "Normal";
  private volatile Message previousMessage;
  
  private ESCLogic()
  {
    Subscription localSubscription = LogicEventBus.getInstance().register(DataOsdGetPushCommon.class).subscribeOn(Schedulers.computation()).subscribe(new -..Lambda.ESCLogic.hTZuh3FvkBr2KRtB_G1ob0yLg8w(this));
    LogicManager.getInstance().addSubscription(localSubscription);
  }
  
  public static ESCLogic getInstance()
  {
    return HOLDER.instance;
  }
  
  /* Error */
  private void updateESCStatus()
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
  
  public static final class ESCEvent
  {
    private Message message;
    
    public ESCEvent(Message paramMessage)
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
    private static ESCLogic instance = new ESCLogic(null);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\ESCLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */