package com.jakewharton.rxbinding2.internal;

public enum Notification
{
  static
  {
    Notification localNotification = new Notification("INSTANCE", 0);
    INSTANCE = localNotification;
    $VALUES = new Notification[] { localNotification };
  }
  
  private Notification() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\jakewharton\rxbinding2\internal\Notification.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */