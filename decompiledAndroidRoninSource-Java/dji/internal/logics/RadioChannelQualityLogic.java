package dji.internal.logics;

import dji.common.bus.EventBus;
import dji.common.bus.LogicEventBus;
import dji.midware.data.model.P3.DataOsdGetPushChannalStatus;
import dji.midware.data.model.P3.DataOsdGetPushChannalStatus.CHANNEL_STATUS;
import dji.midware.data.model.P3.DataWifiGetPushElecSignal;
import dji.midware.data.model.P3.DataWifiGetPushElecSignal.SIGNAL_STATUS;
import dji.thirdparty.rx.Observable;
import dji.thirdparty.rx.Subscription;
import dji.thirdparty.rx.schedulers.Schedulers;

public class RadioChannelQualityLogic
{
  private static final String FLY_WITH_CAUTION = "Strong Interference. Fly with caution.";
  private static final String GOOD = "Good";
  private static final String POOR = "Poor";
  private Message message;
  private volatile DataOsdGetPushChannalStatus.CHANNEL_STATUS previousValue1;
  private volatile DataWifiGetPushElecSignal.SIGNAL_STATUS previousValue2;
  
  private RadioChannelQualityLogic()
  {
    Subscription localSubscription1 = LogicEventBus.getInstance().register(DataOsdGetPushChannalStatus.class).subscribeOn(Schedulers.computation()).subscribe(new -..Lambda.RadioChannelQualityLogic.hfetm8E-KP1WbNCItpVDmaPaYMA(this));
    Subscription localSubscription2 = LogicEventBus.getInstance().register(DataWifiGetPushElecSignal.class).subscribeOn(Schedulers.computation()).subscribe(new -..Lambda.RadioChannelQualityLogic.kVS1FeN59Yw_R3xnGwhEmsN6zz4(this));
    LogicManager.getInstance().addSubscription(localSubscription1);
    LogicManager.getInstance().addSubscription(localSubscription2);
  }
  
  public static RadioChannelQualityLogic getInstance()
  {
    return HOLDER.instance;
  }
  
  private boolean isChannelPoor(DataOsdGetPushChannalStatus.CHANNEL_STATUS paramCHANNEL_STATUS)
  {
    return false;
  }
  
  private boolean isWifiSignalPoor(DataWifiGetPushElecSignal.SIGNAL_STATUS paramSIGNAL_STATUS)
  {
    return false;
  }
  
  /* Error */
  private void updateSensor1()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void updateSensor2()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void init()
  {
    this.previousValue1 = null;
    this.previousValue2 = null;
  }
  
  private static final class HOLDER
  {
    private static RadioChannelQualityLogic instance = new RadioChannelQualityLogic(null);
  }
  
  public static final class RadioChannelQualityEvent
  {
    private Message message;
    
    public RadioChannelQualityEvent(Message paramMessage)
    {
      this.message = paramMessage;
    }
    
    public Message getMessage()
    {
      return this.message;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\internal\logics\RadioChannelQualityLogic.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */