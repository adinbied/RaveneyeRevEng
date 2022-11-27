package org.bouncycastle.cert.crmf;

public abstract interface EncryptedValuePadder
{
  public abstract byte[] getPaddedData(byte[] paramArrayOfByte);
  
  public abstract byte[] getUnpaddedData(byte[] paramArrayOfByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\EncryptedValuePadder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */