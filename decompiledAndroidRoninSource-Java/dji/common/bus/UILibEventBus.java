package dji.common.bus;

import java.util.Map;

public class UILibEventBus
{
  public static EventBus<Object> getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  private static class LazyHolder
  {
    private static final EventBus<Object> INSTANCE = ;
  }
  
  public static final class UILibEvent
  {
    private final String categoryName;
    private final String eventName;
    private final Map<String, Object> extras;
    
    public UILibEvent(String paramString1, String paramString2, Map<String, Object> paramMap)
    {
      this.eventName = paramString1;
      this.categoryName = paramString2;
      this.extras = paramMap;
    }
    
    public String getCategoryName()
    {
      return this.categoryName;
    }
    
    public String getEventName()
    {
      return this.eventName;
    }
    
    public Map<String, Object> getExtras()
    {
      return this.extras;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\bus\UILibEventBus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */