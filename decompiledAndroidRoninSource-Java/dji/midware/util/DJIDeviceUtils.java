package dji.midware.util;

import android.os.Build;

public class DJIDeviceUtils
{
  public static boolean isZS600Device()
  {
    return (Build.DEVICE != null) && (Build.DEVICE.startsWith("zs600"));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midwar\\util\DJIDeviceUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */