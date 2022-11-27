package dji.common.bus;

import dji.thirdparty.rx.subjects.BehaviorSubject;
import dji.thirdparty.rx.subjects.PublishSubject;
import dji.thirdparty.rx.subjects.ReplaySubject;

public class BusFactory
{
  public static <T> EventBus<T> createRepeating(int paramInt)
  {
    return new EventBus(ReplaySubject.createWithSize(paramInt));
  }
  
  public static <T> EventBus<T> createSimple()
  {
    return new EventBus(PublishSubject.create());
  }
  
  public static <T> EventBus<T> createWithLatest()
  {
    return new EventBus(BehaviorSubject.create());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\bus\BusFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */