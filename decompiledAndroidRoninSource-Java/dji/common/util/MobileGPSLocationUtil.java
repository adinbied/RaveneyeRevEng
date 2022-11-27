package dji.common.util;

import android.content.Context;
import android.location.LocationListener;
import android.location.LocationManager;

public class MobileGPSLocationUtil
{
  private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 1L;
  private static final long MIN_TIME_BW_UPDATES = 1000L;
  private static final String TAG = "MobileGPSLocationUtil";
  private Context activityContext;
  private LocationListener locationListener;
  private LocationManager locationManager;
  
  public MobileGPSLocationUtil(Context paramContext, LocationListener paramLocationListener)
  {
    this.activityContext = paramContext;
    this.locationListener = paramLocationListener;
  }
  
  /* Error */
  public void startUpdateLocation()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  public void stopUpdateLocation()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\MobileGPSLocationUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */