package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

public class NHPublicKeyParameters
  extends AsymmetricKeyParameter
{
  final byte[] pubData;
  
  public NHPublicKeyParameters(byte[] paramArrayOfByte)
  {
    super(false);
    this.pubData = Arrays.clone(paramArrayOfByte);
  }
  
  public byte[] getPubData()
  {
    return Arrays.clone(this.pubData);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\newhope\NHPublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */