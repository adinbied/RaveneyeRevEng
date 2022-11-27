package com.xiaomi.clientreport.data;

import org.json.JSONObject;

public class EventClientReport
  extends a
{
  public String eventContent;
  public String eventId;
  public long eventTime;
  public int eventType;
  
  public static EventClientReport getBlankInstance()
  {
    return new EventClientReport();
  }
  
  public JSONObject toJson()
  {
    return null;
  }
  
  public String toJsonString()
  {
    return super.toJsonString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\clientreport\data\EventClientReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */