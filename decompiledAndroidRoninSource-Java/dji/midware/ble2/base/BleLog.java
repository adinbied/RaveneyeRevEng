package dji.midware.ble2.base;

import dji.log.RoninLog;
import dji.midware.ble2.BleConstants;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class BleLog
{
  private static final String DEBUG_MESSAGE = "BLE DEBUG:";
  private static final String ERROR_MESSAGE = "BLE ERROR:";
  private static final String LOGNAME = "BLELog";
  private static final String TAG = "BleLog";
  private static SimpleDateFormat formatData = new SimpleDateFormat("HH:mm:ss.SSS", Locale.CHINA);
  
  public static void logD(String paramString)
  {
    if (BleConstants.DEBUG)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[time:");
      localStringBuilder.append(formatData.format(new Date()));
      localStringBuilder.append("]");
      localStringBuilder.append("BLE DEBUG:");
      localStringBuilder.append(":");
      localStringBuilder.append(paramString);
      RoninLog.logWriteD("BleLog", localStringBuilder.toString(), "BLELog", new Object[0]);
    }
  }
  
  public static void logE(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[time:");
    localStringBuilder.append(formatData.format(new Date()));
    localStringBuilder.append("]");
    localStringBuilder.append("BLE ERROR:");
    localStringBuilder.append(":");
    localStringBuilder.append(paramString);
    RoninLog.logWriteE("BleLog", localStringBuilder.toString(), "BLELog", new Object[0]);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */