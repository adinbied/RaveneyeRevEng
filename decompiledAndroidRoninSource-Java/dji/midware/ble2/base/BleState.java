package dji.midware.ble2.base;

public enum BleState
{
  private int value;
  
  static
  {
    CONNECTING = new BleState("CONNECTING", 1, 1);
    CONNECTED = new BleState("CONNECTED", 2, 2);
    DISCONNECTING = new BleState("DISCONNECTING", 3, 3);
    BLE_ON = new BleState("BLE_ON", 4, 12);
    BleState localBleState = new BleState("BLE_OFF", 5, 10);
    BLE_OFF = localBleState;
    $VALUES = new BleState[] { DISCONNECTED, CONNECTING, CONNECTED, DISCONNECTING, BLE_ON, localBleState };
  }
  
  private BleState(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static BleState getEnum(int paramInt)
  {
    BleState[] arrayOfBleState = values();
    int j = arrayOfBleState.length;
    int i = 0;
    while (i < j)
    {
      BleState localBleState = arrayOfBleState[i];
      if (localBleState.getValue() == paramInt) {
        return localBleState;
      }
      i += 1;
    }
    return DISCONNECTED;
  }
  
  public static int getState(BleState paramBleState)
  {
    return paramBleState.getValue();
  }
  
  public int getValue()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\midware\ble2\base\BleState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */