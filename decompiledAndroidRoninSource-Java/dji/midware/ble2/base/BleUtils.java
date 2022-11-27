package dji.midware.ble2.base;

import android.text.TextUtils;

public class BleUtils
{
  public static final int MIN_ADDRESS_LENGTH = 4;
  
  public static boolean compareAddressIsEqual(String paramString1, String paramString2)
  {
    boolean bool3 = TextUtils.isEmpty(paramString1);
    boolean bool1 = false;
    boolean bool2 = false;
    if (!bool3)
    {
      if (TextUtils.isEmpty(paramString2)) {
        return false;
      }
      bool1 = bool2;
      if (paramString1.length() == paramString2.length())
      {
        bool1 = bool2;
        if (paramString1.length() > 4)
        {
          bool1 = bool2;
          if (paramString1.substring(0, paramString1.length() - 4).equals(paramString2.substring(0, paramString2.length() - 4))) {
            bool1 = true;
          }
        }
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ConnectKnown compareAddressIsEqual = ");
      localStringBuilder.append(bool1);
      localStringBuilder.append(" , address1 = ");
      localStringBuilder.append(paramString1);
      localStringBuilder.append(" , address2 = ");
      localStringBuilder.append(paramString2);
      BleLog.logD(localStringBuilder.toString());
    }
    return bool1;
  }
  
  public static int getDeviceTypeId(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      return (paramArrayOfByte[11] & 0xF0) >> 4;
    }
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */