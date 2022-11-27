package com.huawei.hianalytics.global;

public enum AutoCollectEventType
{
  static
  {
    APP_FIRST_RUN = new AutoCollectEventType("APP_FIRST_RUN", 1);
    AutoCollectEventType localAutoCollectEventType = new AutoCollectEventType("APP_CRASH", 2);
    APP_CRASH = localAutoCollectEventType;
    $VALUES = new AutoCollectEventType[] { APP_UPGRADE, APP_FIRST_RUN, localAutoCollectEventType };
  }
  
  private AutoCollectEventType() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\global\AutoCollectEventType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */