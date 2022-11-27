package com.google.firebase.crashlytics.internal.common;

public enum DeliveryMechanism
{
  private final int id;
  
  static
  {
    TEST_DISTRIBUTION = new DeliveryMechanism("TEST_DISTRIBUTION", 2, 3);
    DeliveryMechanism localDeliveryMechanism = new DeliveryMechanism("APP_STORE", 3, 4);
    APP_STORE = localDeliveryMechanism;
    $VALUES = new DeliveryMechanism[] { DEVELOPER, USER_SIDELOAD, TEST_DISTRIBUTION, localDeliveryMechanism };
  }
  
  private DeliveryMechanism(int paramInt)
  {
    this.id = paramInt;
  }
  
  public static DeliveryMechanism determineFrom(String paramString)
  {
    if (paramString != null) {
      return APP_STORE;
    }
    return DEVELOPER;
  }
  
  public int getId()
  {
    return this.id;
  }
  
  public String toString()
  {
    return Integer.toString(this.id);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\DeliveryMechanism.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */