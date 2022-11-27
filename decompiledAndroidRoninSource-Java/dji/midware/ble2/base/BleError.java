package dji.midware.ble2.base;

public class BleError
{
  private BleCode code;
  private String description;
  
  public BleError(BleCode paramBleCode, String paramString)
  {
    this.code = paramBleCode;
    this.description = paramString;
  }
  
  public BleCode getCode()
  {
    return this.code;
  }
  
  public void setCode(BleCode paramBleCode)
  {
    this.code = paramBleCode;
  }
  
  public String toString()
  {
    return null;
  }
  
  public static enum BleCode
  {
    static
    {
      GATT = new BleCode("GATT", 1);
      STATE = new BleCode("STATE", 2);
      BleCode localBleCode = new BleCode("OTHER", 3);
      OTHER = localBleCode;
      $VALUES = new BleCode[] { TIMEOUT, GATT, STATE, localBleCode };
    }
    
    private BleCode() {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleError.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */