package dji.midware.data.model.P3;

import dji.midware.data.manager.P3.DataBase;
import java.util.List;

public class DataFlycGetPushLedStatus
  extends DataBase
{
  private static final int MAX_NUM = 20;
  private static final int TIME_TICK = 20;
  private static DataFlycGetPushLedStatus instance;
  
  public static DataFlycGetPushLedStatus getInstance()
  {
    try
    {
      if (instance == null) {
        instance = new DataFlycGetPushLedStatus();
      }
      DataFlycGetPushLedStatus localDataFlycGetPushLedStatus = instance;
      return localDataFlycGetPushLedStatus;
    }
    finally {}
  }
  
  protected void doPack() {}
  
  public LED_REASON getLedReason()
  {
    return null;
  }
  
  public List<LedStatus> getLedStatus()
  {
    return null;
  }
  
  public static enum LED_COLOR
  {
    private int data = 0;
    
    static
    {
      GREEN = new LED_COLOR("GREEN", 2, 2);
      BLUE = new LED_COLOR("BLUE", 3, 3);
      YELLOW = new LED_COLOR("YELLOW", 4, 4);
      DEEP_RED = new LED_COLOR("DEEP_RED", 5, 5);
      CYAN = new LED_COLOR("CYAN", 6, 6);
      PURPLE = new LED_COLOR("PURPLE", 7, 7);
      WHITE = new LED_COLOR("WHITE", 8, 8);
      PURPLE1 = new LED_COLOR("PURPLE1", 9, 9);
      PURPLE2 = new LED_COLOR("PURPLE2", 10, 10);
      PURPLE3 = new LED_COLOR("PURPLE3", 11, 11);
      COLOR_ANY = new LED_COLOR("COLOR_ANY", 12, 12);
      LED_COLOR localLED_COLOR = new LED_COLOR("COLOR_UNDEFINED", 13, 13);
      COLOR_UNDEFINED = localLED_COLOR;
      $VALUES = new LED_COLOR[] { OFF, RED, GREEN, BLUE, YELLOW, DEEP_RED, CYAN, PURPLE, WHITE, PURPLE1, PURPLE2, PURPLE3, COLOR_ANY, localLED_COLOR };
    }
    
    private LED_COLOR(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static LED_COLOR find(int paramInt)
    {
      LED_COLOR localLED_COLOR = OFF;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localLED_COLOR;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static enum LED_REASON
  {
    private int data = 0;
    
    static
    {
      SET_COURSE_LOCK = new LED_REASON("SET_COURSE_LOCK", 2, 2);
      TEST_LED = new LED_REASON("TEST_LED", 3, 3);
      USB_IS_VALID = new LED_REASON("USB_IS_VALID", 4, 4);
      PACKING_FAIL = new LED_REASON("PACKING_FAIL", 5, 5);
      PACKING_NORMAL = new LED_REASON("PACKING_NORMAL", 6, 6);
      NO_ATTI = new LED_REASON("NO_ATTI", 7, 7);
      COMPASS_CALI_STEP0 = new LED_REASON("COMPASS_CALI_STEP0", 8, 8);
      COMPASS_CALI_STEP1 = new LED_REASON("COMPASS_CALI_STEP1", 9, 9);
      COMPASS_CALI_ERROR = new LED_REASON("COMPASS_CALI_ERROR", 10, 10);
      SENSOR_TEMP_NOT_READY = new LED_REASON("SENSOR_TEMP_NOT_READY", 11, 11);
      IMU_OR_GYRO_LOST = new LED_REASON("IMU_OR_GYRO_LOST", 12, 12);
      IMU_BAD_ATTI = new LED_REASON("IMU_BAD_ATTI", 13, 13);
      SYSTEM_ERROR = new LED_REASON("SYSTEM_ERROR", 14, 14);
      IMU_ERROR = new LED_REASON("IMU_ERROR", 15, 15);
      IMU_NEED_CALI = new LED_REASON("IMU_NEED_CALI", 16, 16);
      COMPASS_OUT_RANGE = new LED_REASON("COMPASS_OUT_RANGE", 17, 17);
      RC_COMPLETELY_LOST = new LED_REASON("RC_COMPLETELY_LOST", 18, 18);
      BATTERY_WARNING = new LED_REASON("BATTERY_WARNING", 19, 19);
      BATTERY_ERROR = new LED_REASON("BATTERY_ERROR", 20, 20);
      IMU_WARNING = new LED_REASON("IMU_WARNING", 21, 21);
      SET_FLY_LIMIT = new LED_REASON("SET_FLY_LIMIT", 22, 22);
      NORMAL_LED = new LED_REASON("NORMAL_LED", 23, 23);
      FDI_VIBRATE = new LED_REASON("FDI_VIBRATE", 24, 24);
      CODE_ERROR = new LED_REASON("CODE_ERROR", 25, 25);
      SYSTEM_RECONSTRUCTION = new LED_REASON("SYSTEM_RECONSTRUCTION", 26, 26);
      LED_REASON localLED_REASON = new LED_REASON("RECORDER_ERROR", 27, 27);
      RECORDER_ERROR = localLED_REASON;
      $VALUES = new LED_REASON[] { SET_HOME, SET_HOT_POINT, SET_COURSE_LOCK, TEST_LED, USB_IS_VALID, PACKING_FAIL, PACKING_NORMAL, NO_ATTI, COMPASS_CALI_STEP0, COMPASS_CALI_STEP1, COMPASS_CALI_ERROR, SENSOR_TEMP_NOT_READY, IMU_OR_GYRO_LOST, IMU_BAD_ATTI, SYSTEM_ERROR, IMU_ERROR, IMU_NEED_CALI, COMPASS_OUT_RANGE, RC_COMPLETELY_LOST, BATTERY_WARNING, BATTERY_ERROR, IMU_WARNING, SET_FLY_LIMIT, NORMAL_LED, FDI_VIBRATE, CODE_ERROR, SYSTEM_RECONSTRUCTION, localLED_REASON };
    }
    
    private LED_REASON(int paramInt)
    {
      this.data = paramInt;
    }
    
    public static LED_REASON find(int paramInt)
    {
      LED_REASON localLED_REASON = NORMAL_LED;
      int i = 0;
      while (i < values().length)
      {
        if (values()[i]._equals(paramInt)) {
          return values()[i];
        }
        i += 1;
      }
      return localLED_REASON;
    }
    
    public boolean _equals(int paramInt)
    {
      return this.data == paramInt;
    }
    
    public int value()
    {
      return this.data;
    }
  }
  
  public static class LedStatus
  {
    public DataFlycGetPushLedStatus.LED_COLOR mColor = DataFlycGetPushLedStatus.LED_COLOR.OFF;
    public int mInterval = 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\P3\DataFlycGetPushLedStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */