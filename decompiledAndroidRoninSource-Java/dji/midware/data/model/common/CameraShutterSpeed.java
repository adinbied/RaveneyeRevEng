package dji.midware.data.model.common;

import dji.midware.util.BytesUtil;

public class CameraShutterSpeed
{
  public byte[] data;
  public int decimalPart;
  public int integerPart;
  public boolean isReciprocal;
  
  public CameraShutterSpeed(int paramInt1, boolean paramBoolean, int paramInt2)
  {
    this.integerPart = paramInt1;
    this.isReciprocal = paramBoolean;
    this.decimalPart = paramInt2;
    this.data = getBytes();
  }
  
  public CameraShutterSpeed(byte[] paramArrayOfByte)
  {
    this.data = paramArrayOfByte;
    boolean bool = false;
    int i = ((Integer)BytesUtil.get(paramArrayOfByte, 0, 2, Integer.class)).intValue();
    if (((Integer)BytesUtil.get(paramArrayOfByte, 0, 2, Integer.class)).intValue() >> 15 == 1) {
      bool = true;
    }
    int j = ((Integer)BytesUtil.get(paramArrayOfByte, 2, 1, Integer.class)).intValue();
    this.integerPart = (i & 0xFFFF7FFF);
    this.isReciprocal = bool;
    this.decimalPart = j;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public byte[] getBytes()
  {
    return null;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\common\CameraShutterSpeed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */