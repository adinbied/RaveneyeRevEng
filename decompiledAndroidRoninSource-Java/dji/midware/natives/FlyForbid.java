package dji.midware.natives;

import dji.log.RoninLog;

public class FlyForbid
{
  static
  {
    try
    {
      System.loadLibrary("FlyForbid");
      RoninLog.d("FlyForbid", "load lib success", new Object[0]);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      RoninLog.d("FlyForbid", "Couldn't load lib", new Object[0]);
    }
  }
  
  public static native FlyForbidParam native_CheckNearForbidPoints(double paramDouble1, double paramDouble2, Object paramObject);
  
  public static native String native_getFlyfrbDbAc();
  
  public static native boolean native_intersectSegCircle(double paramDouble1, double paramDouble2, double paramDouble3, int paramInt);
  
  public static class FlyForbidParam
  {
    public double[] ForbidCountry;
    public double[] ForbidLat;
    public double[] ForbidLon;
    public double[] ForbidRadius;
    public double[] ForbidType;
    public int count;
    
    /* Error */
    public void SetForbidPoint(double[] arg1, double[] arg2, double[] arg3, double[] arg4, double[] arg5, int arg6)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\natives\FlyForbid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */