package com.google.firebase.analytics.connector;

import android.os.Bundle;
import java.util.List;
import java.util.Map;
import java.util.Set;

public abstract interface AnalyticsConnector
{
  public abstract void clearConditionalUserProperty(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract List<ConditionalUserProperty> getConditionalUserProperties(String paramString1, String paramString2);
  
  public abstract int getMaxUserProperties(String paramString);
  
  public abstract Map<String, Object> getUserProperties(boolean paramBoolean);
  
  public abstract void logEvent(String paramString1, String paramString2, Bundle paramBundle);
  
  public abstract AnalyticsConnectorHandle registerAnalyticsConnectorListener(String paramString, AnalyticsConnectorListener paramAnalyticsConnectorListener);
  
  public abstract void setConditionalUserProperty(ConditionalUserProperty paramConditionalUserProperty);
  
  public abstract void setUserProperty(String paramString1, String paramString2, Object paramObject);
  
  public static abstract interface AnalyticsConnectorHandle
  {
    public abstract void registerEventNames(Set<String> paramSet);
    
    public abstract void unregister();
    
    public abstract void unregisterEventNames();
  }
  
  public static abstract interface AnalyticsConnectorListener
  {
    public abstract void onMessageTriggered(int paramInt, Bundle paramBundle);
  }
  
  public static class ConditionalUserProperty
  {
    public boolean active;
    public long creationTimestamp;
    public String expiredEventName;
    public Bundle expiredEventParams;
    public String name;
    public String origin;
    public long timeToLive;
    public String timedOutEventName;
    public Bundle timedOutEventParams;
    public String triggerEventName;
    public long triggerTimeout;
    public String triggeredEventName;
    public Bundle triggeredEventParams;
    public long triggeredTimestamp;
    public Object value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\analytics\connector\AnalyticsConnector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */