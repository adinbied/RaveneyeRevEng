package dji.midware.natives;

import dji.log.RoninLog;

public class GroudStation
{
  static
  {
    try
    {
      System.loadLibrary("GroudStation");
      RoninLog.d("GroudStation", "load lib suc", new Object[0]);
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      localUnsatisfiedLinkError.printStackTrace();
      RoninLog.d("GroudStation", "Couldn't load lib", new Object[0]);
    }
  }
  
  public static void loadLibrary() {}
  
  public static short native_calcCrc16(byte[] paramArrayOfByte)
  {
    return native_calcCrc16(paramArrayOfByte, paramArrayOfByte.length);
  }
  
  public static native short native_calcCrc16(byte[] paramArrayOfByte, int paramInt);
  
  public static native byte native_calcCrc8(byte[] paramArrayOfByte);
  
  public static native int native_checkCRCForData(byte[] paramArrayOfByte);
  
  public static native byte[] native_decodeData(byte[] paramArrayOfByte);
  
  public static native byte[] native_encodeData(byte[] paramArrayOfByte);
  
  public static native byte[] native_getCRCFromData(byte[] paramArrayOfByte);
  
  public static native long native_hashFromString(byte[] paramArrayOfByte);
  
  public static native byte[] native_rcDataDeal(byte[] paramArrayOfByte, int paramInt);
  
  public static native boolean native_verifyCrc16(byte[] paramArrayOfByte);
  
  public static native boolean native_verifyCrc8(byte[] paramArrayOfByte);
  
  public static native int[] native_yuv422ToImage(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\natives\GroudStation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */