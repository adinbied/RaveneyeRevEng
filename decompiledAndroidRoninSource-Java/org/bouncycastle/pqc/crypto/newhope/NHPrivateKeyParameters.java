package org.bouncycastle.pqc.crypto.newhope;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

public class NHPrivateKeyParameters
  extends AsymmetricKeyParameter
{
  final short[] secData;
  
  public NHPrivateKeyParameters(short[] paramArrayOfShort)
  {
    super(true);
    this.secData = Arrays.clone(paramArrayOfShort);
  }
  
  public short[] getSecData()
  {
    return Arrays.clone(this.secData);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\newhope\NHPrivateKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */