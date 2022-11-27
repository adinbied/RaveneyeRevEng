package dji.common.util;

import android.app.Application;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import dji.sdksharedlib.util.Util;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class LocationUtils
{
  private static Location currentBestLocation;
  private static LocationManager locationManager;
  
  public static double DegreeToRadian(double paramDouble)
  {
    return paramDouble * 3.141592653589793D / 180.0D;
  }
  
  public static double RadianToDegree(double paramDouble)
  {
    return paramDouble * 180.0D / 3.141592653589793D;
  }
  
  public static boolean checkLocationPermission()
  {
    boolean bool = false;
    try
    {
      i = Util.getApplication().getApplicationContext().checkCallingOrSelfPermission("android.permission.ACCESS_FINE_LOCATION");
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      localInvocationTargetException.printStackTrace();
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      localNoSuchMethodException.printStackTrace();
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      localClassNotFoundException.printStackTrace();
    }
    int i = 0;
    if (i == 0) {
      bool = true;
    }
    return bool;
  }
  
  public static boolean checkValidGPSCoordinate(double paramDouble1, double paramDouble2)
  {
    return (paramDouble1 >= -90.0D) && (paramDouble1 <= 90.0D) && (paramDouble2 >= -180.0D) && (paramDouble2 <= 180.0D);
  }
  
  private static double degreeToRadius(double paramDouble)
  {
    return paramDouble * 0.017453292519943295D;
  }
  
  public static double getDistanceInMeterFromTwoGPSLocations(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    paramDouble3 = degreeToRadius(paramDouble3 - paramDouble1);
    double d = degreeToRadius(paramDouble4 - paramDouble2) / 2.0D;
    paramDouble1 = Math.sin(d);
    d = Math.sin(d);
    paramDouble2 = Math.cos(degreeToRadius(paramDouble2));
    paramDouble4 = Math.cos(degreeToRadius(paramDouble4));
    paramDouble3 /= 2.0D;
    paramDouble1 = paramDouble1 * d + paramDouble2 * paramDouble4 * Math.sin(paramDouble3) * Math.sin(paramDouble3);
    return Math.atan2(Math.sqrt(paramDouble1), Math.sqrt(1.0D - paramDouble1)) * 2.0D * 6371000.0D;
  }
  
  public static Location getLastBestLocation()
  {
    Object localObject;
    if (locationManager == null) {
      try
      {
        localObject = Util.getApplication().getApplicationContext();
        try
        {
          locationManager = (LocationManager)Util.getApplication().getSystemService("location");
        }
        catch (IllegalAccessException localIllegalAccessException1) {}catch (InvocationTargetException localInvocationTargetException1) {}catch (NoSuchMethodException localNoSuchMethodException1) {}catch (ClassNotFoundException localClassNotFoundException1) {}
        localClassNotFoundException2.printStackTrace();
      }
      catch (IllegalAccessException localIllegalAccessException2)
      {
        localObject = null;
        localIllegalAccessException2.printStackTrace();
      }
      catch (InvocationTargetException localInvocationTargetException2)
      {
        localObject = null;
        localInvocationTargetException2.printStackTrace();
      }
      catch (NoSuchMethodException localNoSuchMethodException2)
      {
        localObject = null;
        localNoSuchMethodException2.printStackTrace();
      }
      catch (ClassNotFoundException localClassNotFoundException2)
      {
        localObject = null;
      }
    } else {
      localObject = null;
    }
    if ((((Context)localObject).checkCallingOrSelfPermission("gps") == 0) && (((Context)localObject).checkCallingOrSelfPermission("network") == 0))
    {
      localObject = locationManager.getLastKnownLocation("gps");
      Location localLocation1 = locationManager.getLastKnownLocation("network");
      long l1;
      if (localObject != null) {
        l1 = ((Location)localObject).getTime();
      } else {
        l1 = 0L;
      }
      long l2;
      if (localLocation1 != null) {
        l2 = localLocation1.getTime();
      } else {
        l2 = 0L;
      }
      if (0L < l1 - l2) {
        currentBestLocation = (Location)localObject;
      } else {
        currentBestLocation = localLocation1;
      }
      Location localLocation2 = currentBestLocation;
      if (localLocation2 == null)
      {
        if (localObject != null) {
          return (Location)localObject;
        }
        if (localLocation1 != null) {
          return localLocation1;
        }
        return null;
      }
      return localLocation2;
    }
    return null;
  }
  
  public static double gps2m(double paramDouble1, double paramDouble2, double paramDouble3, double paramDouble4)
  {
    double d = Math.toRadians(paramDouble3 - paramDouble1);
    paramDouble2 = Math.toRadians(paramDouble4 - paramDouble2);
    d /= 2.0D;
    paramDouble4 = Math.sin(d);
    d = Math.sin(d);
    paramDouble1 = Math.cos(Math.toRadians(paramDouble1));
    paramDouble3 = Math.cos(Math.toRadians(paramDouble3));
    paramDouble2 /= 2.0D;
    paramDouble1 = paramDouble4 * d + paramDouble1 * paramDouble3 * Math.sin(paramDouble2) * Math.sin(paramDouble2);
    return (float)(Math.atan2(Math.sqrt(paramDouble1), Math.sqrt(1.0D - paramDouble1)) * 2.0D * 6371000.0D);
  }
  
  public static boolean isInUSA()
  {
    return Locale.getDefault().getISO3Country().equals("USA");
  }
  
  public static boolean validateLatitude(double paramDouble)
  {
    return (paramDouble > 90.0D) || (paramDouble < -90.0D);
  }
  
  public static boolean validateLongitude(double paramDouble)
  {
    return (paramDouble > 180.0D) || (paramDouble < -180.0D);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\LocationUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */