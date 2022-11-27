package com.xiaomi.clientreport.data;

import org.json.JSONObject;

public class PerfClientReport
  extends a
{
  private static final long DEFAULT_VALUE = -1L;
  public int code;
  public long perfCounts = -1L;
  public long perfLatencies = -1L;
  
  public static PerfClientReport getBlankInstance()
  {
    return new PerfClientReport();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\clientreport\data\PerfClientReport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */