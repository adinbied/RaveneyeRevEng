package dji.common.bus;

public class LogicEventBus
{
  public static EventBus<Object> getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  private static class LazyHolder
  {
    private static final EventBus<Object> INSTANCE = BusFactory.createRepeating(1000);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\bus\LogicEventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */