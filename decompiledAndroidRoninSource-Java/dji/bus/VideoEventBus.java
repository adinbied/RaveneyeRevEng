package dji.bus;

import dji.common.bus.BusFactory;
import dji.common.bus.EventBus;

public class VideoEventBus
{
  public static EventBus<Object> getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  private static class LazyHolder
  {
    private static final EventBus<Object> INSTANCE = ;
  }
  
  public static final class VideoFeedPhysicalSourceChangeEvent
  {
    private final int newPhysicalSource;
    private final Object videoFeed;
    
    public VideoFeedPhysicalSourceChangeEvent(Object paramObject, int paramInt)
    {
      this.videoFeed = paramObject;
      this.newPhysicalSource = paramInt;
    }
    
    public int getNewPhysicalSource()
    {
      return this.newPhysicalSource;
    }
    
    public Object getVideoFeed()
    {
      return this.videoFeed;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\bus\VideoEventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */