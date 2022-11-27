package dji.logic.utils;

import android.location.Location;
import dji.midware.data.model.P3.DataWifiSetPowerMode;
import dji.midware.data.model.P3.DataWifiSetPowerMode.DJIWifiPowerMode;
import dji.midware.interfaces.DJIDataCallBack;
import java.util.ArrayList;
import java.util.Iterator;

public class DJICEAreas
{
  private static ArrayList<CEArea> areas;
  
  static
  {
    ArrayList localArrayList = new ArrayList();
    areas = localArrayList;
    localArrayList.add(new CEArea(55.529627D, 15.702531D, 2824707));
    areas.add(new CEArea(-29.63077D, 24.718358D, 1038280));
    areas.add(new CEArea(18.20013D, 78.10576D, 1585814));
    areas.add(new CEArea(24.41194D, 93.17285D, 1044521));
    areas.add(new CEArea(-23.950101D, 135.518546D, 4285467));
    areas.add(new CEArea(35.628727D, 129.950682D, 643505));
  }
  
  public static boolean isInCEArea(double paramDouble1, double paramDouble2)
  {
    float[] arrayOfFloat = new float[3];
    Iterator localIterator = areas.iterator();
    while (localIterator.hasNext())
    {
      CEArea localCEArea = (CEArea)localIterator.next();
      Location.distanceBetween(localCEArea.latitude, localCEArea.longtitude, paramDouble1, paramDouble2, arrayOfFloat);
      if (arrayOfFloat[0] <= localCEArea.radius) {
        return true;
      }
    }
    return false;
  }
  
  public static void startSetArea(boolean paramBoolean, DJIDataCallBack paramDJIDataCallBack)
  {
    DataWifiSetPowerMode.DJIWifiPowerMode localDJIWifiPowerMode;
    if (paramBoolean) {
      localDJIWifiPowerMode = DataWifiSetPowerMode.DJIWifiPowerMode.CE;
    } else {
      localDJIWifiPowerMode = DataWifiSetPowerMode.DJIWifiPowerMode.FCC;
    }
    DataWifiSetPowerMode.getInstance().setMode(localDJIWifiPowerMode).start(paramDJIDataCallBack);
  }
  
  private static class CEArea
  {
    protected double latitude;
    protected double longtitude;
    protected int radius;
    
    public CEArea(double paramDouble1, double paramDouble2, int paramInt)
    {
      this.latitude = paramDouble1;
      this.longtitude = paramDouble2;
      this.radius = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\logi\\utils\DJICEAreas.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */