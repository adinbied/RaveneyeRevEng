package dji.midware.data.model.common;

public enum DJICameraShutterSpeedType
{
  private int value;
  
  static
  {
    DJICameraShutterSpeedType_Auto = new DJICameraShutterSpeedType("DJICameraShutterSpeedType_Auto", 1, 1);
    DJICameraShutterSpeedType_MSHTR = new DJICameraShutterSpeedType("DJICameraShutterSpeedType_MSHTR", 2, 2);
    DJICameraShutterSpeedType_ESHTR = new DJICameraShutterSpeedType("DJICameraShutterSpeedType_ESHTR", 3, 3);
    DJICameraShutterSpeedType localDJICameraShutterSpeedType = new DJICameraShutterSpeedType("DJICameraShutterSpeedType_EFC", 4, 4);
    DJICameraShutterSpeedType_EFC = localDJICameraShutterSpeedType;
    $VALUES = new DJICameraShutterSpeedType[] { DJICameraShutterSpeedType_NotSupport, DJICameraShutterSpeedType_Auto, DJICameraShutterSpeedType_MSHTR, DJICameraShutterSpeedType_ESHTR, localDJICameraShutterSpeedType };
  }
  
  private DJICameraShutterSpeedType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static DJICameraShutterSpeedType find(int paramInt)
  {
    DJICameraShutterSpeedType[] arrayOfDJICameraShutterSpeedType = values();
    int j = arrayOfDJICameraShutterSpeedType.length;
    int i = 0;
    while (i < j)
    {
      DJICameraShutterSpeedType localDJICameraShutterSpeedType = arrayOfDJICameraShutterSpeedType[i];
      if (localDJICameraShutterSpeedType.value == paramInt) {
        return localDJICameraShutterSpeedType;
      }
      i += 1;
    }
    return DJICameraShutterSpeedType_NotSupport;
  }
  
  public int getValue()
  {
    return this.value;
  }
  
  public void setValue(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\common\DJICameraShutterSpeedType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */