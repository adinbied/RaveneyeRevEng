package dji.midware.util;

import org.greenrobot.eventbus.EventBus;

public class DJIEventBusUtil
{
  public static void register(Object paramObject)
  {
    if (!EventBus.getDefault().isRegistered(paramObject)) {
      EventBus.getDefault().register(paramObject);
    }
  }
  
  public static void unRegister(Object paramObject)
  {
    if (EventBus.getDefault().isRegistered(paramObject)) {
      EventBus.getDefault().unregister(paramObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\DJIEventBusUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */