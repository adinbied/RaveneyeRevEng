package org.bouncycastle.crypto.tls;

public class SupplementalDataEntry
{
  protected byte[] data;
  protected int dataType;
  
  public SupplementalDataEntry(int paramInt, byte[] paramArrayOfByte)
  {
    this.dataType = paramInt;
    this.data = paramArrayOfByte;
  }
  
  public byte[] getData()
  {
    return this.data;
  }
  
  public int getDataType()
  {
    return this.dataType;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\SupplementalDataEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */