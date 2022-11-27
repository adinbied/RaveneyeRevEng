package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

public class SPHINCSPrivateKeyParameters
  extends AsymmetricKeyParameter
{
  private final byte[] keyData;
  
  public SPHINCSPrivateKeyParameters(byte[] paramArrayOfByte)
  {
    super(true);
    this.keyData = Arrays.clone(paramArrayOfByte);
  }
  
  public byte[] getKeyData()
  {
    return Arrays.clone(this.keyData);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\sphincs\SPHINCSPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */