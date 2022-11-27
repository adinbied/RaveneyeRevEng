package org.bouncycastle.crypto.agreement.kdf;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.crypto.DerivationParameters;

public class DHKDFParameters
  implements DerivationParameters
{
  private ASN1ObjectIdentifier algorithm;
  private byte[] extraInfo;
  private int keySize;
  private byte[] z;
  
  public DHKDFParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt, byte[] paramArrayOfByte)
  {
    this(paramASN1ObjectIdentifier, paramInt, paramArrayOfByte, null);
  }
  
  public DHKDFParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier, int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.algorithm = paramASN1ObjectIdentifier;
    this.keySize = paramInt;
    this.z = paramArrayOfByte1;
    this.extraInfo = paramArrayOfByte2;
  }
  
  public ASN1ObjectIdentifier getAlgorithm()
  {
    return this.algorithm;
  }
  
  public byte[] getExtraInfo()
  {
    return this.extraInfo;
  }
  
  public int getKeySize()
  {
    return this.keySize;
  }
  
  public byte[] getZ()
  {
    return this.z;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\agreement\kdf\DHKDFParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */