package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

class BatteryState
{
  static final int VELOCITY_CHARGING = 2;
  static final int VELOCITY_FULL = 3;
  static final int VELOCITY_UNPLUGGED = 1;
  private final Float level;
  private final boolean powerConnected;
  
  private BatteryState(Float paramFloat, boolean paramBoolean)
  {
    this.powerConnected = paramBoolean;
    this.level = paramFloat;
  }
  
  public static BatteryState get(Context paramContext)
  {
    IntentFilter localIntentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    Object localObject = null;
    paramContext = paramContext.registerReceiver(null, localIntentFilter);
    boolean bool;
    if (paramContext != null)
    {
      bool = isPowerConnected(paramContext);
      paramContext = getLevel(paramContext);
    }
    else
    {
      bool = false;
      paramContext = (Context)localObject;
    }
    return new BatteryState(paramContext, bool);
  }
  
  private static Float getLevel(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("level", -1);
    int j = paramIntent.getIntExtra("scale", -1);
    if ((i != -1) && (j != -1)) {
      return Float.valueOf(i / j);
    }
    return null;
  }
  
  private static boolean isPowerConnected(Intent paramIntent)
  {
    int i = paramIntent.getIntExtra("status", -1);
    boolean bool = false;
    if (i == -1) {
      return false;
    }
    if ((i == 2) || (i == 5)) {
      bool = true;
    }
    return bool;
  }
  
  public Float getBatteryLevel()
  {
    return this.level;
  }
  
  public int getBatteryVelocity()
  {
    if (this.powerConnected)
    {
      Float localFloat = this.level;
      if (localFloat != null)
      {
        if (localFloat.floatValue() < 0.99D) {
          return 2;
        }
        return 3;
      }
    }
    return 1;
  }
  
  boolean isPowerConnected()
  {
    return this.powerConnected;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\BatteryState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */