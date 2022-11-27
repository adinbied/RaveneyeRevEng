package dji.logic.receiver;

import android.content.BroadcastReceiver;

public class DJIPilotStartupReceiver
  extends BroadcastReceiver
{
  public static final String ACTION_GO4 = "dji.go4.STARTUP";
  public static final String ACTION_PILOT = "dji.pilot.STARTUP";
  public static boolean ANOTHER_DJIGO_STARTED = false;
  public static final String PACKAFE_GO4 = "dji.go.v4.debug";
  public static final String PACKAFE_PILOT = "dji.pilot.dev";
  
  /* Error */
  public void onReceive(android.content.Context arg1, android.content.Intent arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logic\receiver\DJIPilotStartupReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */