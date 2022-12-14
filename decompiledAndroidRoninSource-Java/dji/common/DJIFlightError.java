package dji.common;

public enum DJIFlightError
{
  static
  {
    FLAG_HD_ERROR = new DJIFlightError("FLAG_HD_ERROR", 2);
    FLAG_NO_VIDEO_SIGNAL = new DJIFlightError("FLAG_NO_VIDEO_SIGNAL", 3);
    FLAG_MC_DATA_ERROR = new DJIFlightError("FLAG_MC_DATA_ERROR", 4);
    FLAG_IMU_CALI = new DJIFlightError("FLAG_IMU_CALI", 5);
    FLAG_CAMERA_ENCRYPT_ERROR = new DJIFlightError("FLAG_CAMERA_ENCRYPT_ERROR", 6);
    FLAG_COMPASS_ERROR = new DJIFlightError("FLAG_COMPASS_ERROR", 7);
    FLAG_ESC_ERROR_SKY = new DJIFlightError("FLAG_ESC_ERROR_SKY", 8);
    FLAG_ESC_ERROR = new DJIFlightError("FLAG_ESC_ERROR", 9);
    FLAG_COMPASS_DISTURB = new DJIFlightError("FLAG_COMPASS_DISTURB", 10);
    FLAG_BAROMETER_DEAD = new DJIFlightError("FLAG_BAROMETER_DEAD", 11);
    FLAG_FRONT_VISION_CALI = new DJIFlightError("FLAG_FRONT_VISION_CALI", 12);
    FLAG_DOWN_VISION_CALI = new DJIFlightError("FLAG_DOWN_VISION_CALI", 13);
    FLAG_VISION_ERROR = new DJIFlightError("FLAG_VISION_ERROR", 14);
    FLAG_BATTERY_CONN_EXCEPTION = new DJIFlightError("FLAG_BATTERY_CONN_EXCEPTION", 15);
    FLAG_BATTERY_EXCEPTION = new DJIFlightError("FLAG_BATTERY_EXCEPTION", 16);
    FLAG_BATTERY_BROKEN = new DJIFlightError("FLAG_BATTERY_BROKEN", 17);
    FLAG_BATTERY_OVER_CURRENT = new DJIFlightError("FLAG_BATTERY_OVER_CURRENT", 18);
    FLAG_BATTERY_OVER_TEMP = new DJIFlightError("FLAG_BATTERY_OVER_TEMP", 19);
    FLAG_BATTERY_LOW_TEMP = new DJIFlightError("FLAG_BATTERY_LOW_TEMP", 20);
    FLAG_BATTERY_SELF_RELEASE = new DJIFlightError("FLAG_BATTERY_SELF_RELEASE", 21);
    FLAG_IMU_INITIALIZING = new DJIFlightError("FLAG_IMU_INITIALIZING", 22);
    FLAG_SENSOR_ERROR = new DJIFlightError("FLAG_SENSOR_ERROR", 23);
    FLAG_IMU_ERROR = new DJIFlightError("FLAG_IMU_ERROR", 24);
    FLAG_IMU_COMPASS_ERROR = new DJIFlightError("FLAG_IMU_COMPASS_ERROR", 25);
    FLAG_IMU_HEATING = new DJIFlightError("FLAG_IMU_HEATING", 26);
    FLAG_DEVICE_LOCK = new DJIFlightError("FLAG_DEVICE_LOCK", 27);
    FLAG_CANT_TAKEOFF_NOVICE = new DJIFlightError("FLAG_CANT_TAKEOFF_NOVICE", 28);
    FLAG_CANT_TAKEOFF = new DJIFlightError("FLAG_CANT_TAKEOFF", 29);
    FLAG_SERIOUS_LOW_VOLTAGE_LANDING = new DJIFlightError("FLAG_SERIOUS_LOW_VOLTAGE_LANDING", 30);
    FLAG_SERIOUS_LOW_VOLTAGE = new DJIFlightError("FLAG_SERIOUS_LOW_VOLTAGE", 31);
    FLAG_SERIOUS_LOW_POWER_LANDING = new DJIFlightError("FLAG_SERIOUS_LOW_POWER_LANDING", 32);
    FLAG_SERIOUS_LOW_POWER = new DJIFlightError("FLAG_SERIOUS_LOW_POWER", 33);
    FLAG_SMART_LOW_POWER_LANDING = new DJIFlightError("FLAG_SMART_LOW_POWER_LANDING", 34);
    FLAG_SMART_LOW_POWER = new DJIFlightError("FLAG_SMART_LOW_POWER", 35);
    FLAG_LOW_VOLTAGE = new DJIFlightError("FLAG_LOW_VOLTAGE", 36);
    FLAG_NOT_ENOUGH_FORCE = new DJIFlightError("FLAG_NOT_ENOUGH_FORCE", 37);
    FLAG_NEED_UPDATE = new DJIFlightError("FLAG_NEED_UPDATE", 38);
    FLAG_GOHOME_FAILED = new DJIFlightError("FLAG_GOHOME_FAILED", 39);
    FLAG_FAILSAFE_GOHOME = new DJIFlightError("FLAG_FAILSAFE_GOHOME", 40);
    FLAG_FAILSAFE = new DJIFlightError("FLAG_FAILSAFE", 41);
    FLAG_PRIORITY_LOWPOWER_GOHO = new DJIFlightError("FLAG_PRIORITY_LOWPOWER_GOHO", 42);
    FLAG_LOW_POWER_GOHOME = new DJIFlightError("FLAG_LOW_POWER_GOHOME", 43);
    FLAG_LOW_POWER = new DJIFlightError("FLAG_LOW_POWER", 44);
    FLAG_LOW_RC_POWER = new DJIFlightError("FLAG_LOW_RC_POWER", 45);
    FLAG_LOW_RC_SIGNAL = new DJIFlightError("FLAG_LOW_RC_SIGNAL", 46);
    FLAG_LOW_RADIO_SIGNAL = new DJIFlightError("FLAG_LOW_RADIO_SIGNAL", 47);
    FLAG_GIMBAL_STUCK = new DJIFlightError("FLAG_GIMBAL_STUCK", 48);
    FLAG_NON_GPS = new DJIFlightError("FLAG_NON_GPS", 49);
    FLAG_ATTI_STATE = new DJIFlightError("FLAG_ATTI_STATE", 50);
    FLAG_CHLSTATUS_POOR = new DJIFlightError("FLAG_CHLSTATUS_POOR", 51);
    FLAG_PRIORITY_GOHOME = new DJIFlightError("FLAG_PRIORITY_GOHOME", 52);
    FLAG_GOHOME = new DJIFlightError("FLAG_GOHOME", 53);
    FLAG_MOTOR_BLOCK = new DJIFlightError("FLAG_MOTOR_BLOCK", 54);
    FLAG_PROPELLER_CATAPULT = new DJIFlightError("FLAG_PROPELLER_CATAPULT", 55);
    DJIFlightError localDJIFlightError = new DJIFlightError("INIT_STATUS", 56);
    INIT_STATUS = localDJIFlightError;
    $VALUES = new DJIFlightError[] { FLAG_DISCONNECT, FLAG_USB_MODE, FLAG_HD_ERROR, FLAG_NO_VIDEO_SIGNAL, FLAG_MC_DATA_ERROR, FLAG_IMU_CALI, FLAG_CAMERA_ENCRYPT_ERROR, FLAG_COMPASS_ERROR, FLAG_ESC_ERROR_SKY, FLAG_ESC_ERROR, FLAG_COMPASS_DISTURB, FLAG_BAROMETER_DEAD, FLAG_FRONT_VISION_CALI, FLAG_DOWN_VISION_CALI, FLAG_VISION_ERROR, FLAG_BATTERY_CONN_EXCEPTION, FLAG_BATTERY_EXCEPTION, FLAG_BATTERY_BROKEN, FLAG_BATTERY_OVER_CURRENT, FLAG_BATTERY_OVER_TEMP, FLAG_BATTERY_LOW_TEMP, FLAG_BATTERY_SELF_RELEASE, FLAG_IMU_INITIALIZING, FLAG_SENSOR_ERROR, FLAG_IMU_ERROR, FLAG_IMU_COMPASS_ERROR, FLAG_IMU_HEATING, FLAG_DEVICE_LOCK, FLAG_CANT_TAKEOFF_NOVICE, FLAG_CANT_TAKEOFF, FLAG_SERIOUS_LOW_VOLTAGE_LANDING, FLAG_SERIOUS_LOW_VOLTAGE, FLAG_SERIOUS_LOW_POWER_LANDING, FLAG_SERIOUS_LOW_POWER, FLAG_SMART_LOW_POWER_LANDING, FLAG_SMART_LOW_POWER, FLAG_LOW_VOLTAGE, FLAG_NOT_ENOUGH_FORCE, FLAG_NEED_UPDATE, FLAG_GOHOME_FAILED, FLAG_FAILSAFE_GOHOME, FLAG_FAILSAFE, FLAG_PRIORITY_LOWPOWER_GOHO, FLAG_LOW_POWER_GOHOME, FLAG_LOW_POWER, FLAG_LOW_RC_POWER, FLAG_LOW_RC_SIGNAL, FLAG_LOW_RADIO_SIGNAL, FLAG_GIMBAL_STUCK, FLAG_NON_GPS, FLAG_ATTI_STATE, FLAG_CHLSTATUS_POOR, FLAG_PRIORITY_GOHOME, FLAG_GOHOME, FLAG_MOTOR_BLOCK, FLAG_PROPELLER_CATAPULT, localDJIFlightError };
  }
  
  private DJIFlightError() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\DJIFlightError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */