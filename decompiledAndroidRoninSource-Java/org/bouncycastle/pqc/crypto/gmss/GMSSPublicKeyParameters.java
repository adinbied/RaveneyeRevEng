package org.bouncycastle.pqc.crypto.gmss;

public class GMSSPublicKeyParameters
  extends GMSSKeyParameters
{
  private byte[] gmssPublicKey;
  
  public GMSSPublicKeyParameters(byte[] paramArrayOfByte, GMSSParameters paramGMSSParameters)
  {
    super(false, paramGMSSParameters);
    this.gmssPublicKey = paramArrayOfByte;
  }
  
  public byte[] getPublicKey()
  {
    return this.gmssPublicKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSPublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */