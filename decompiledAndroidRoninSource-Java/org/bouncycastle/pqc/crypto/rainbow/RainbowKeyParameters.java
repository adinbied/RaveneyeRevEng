package org.bouncycastle.pqc.crypto.rainbow;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class RainbowKeyParameters
  extends AsymmetricKeyParameter
{
  private int docLength;
  
  public RainbowKeyParameters(boolean paramBoolean, int paramInt)
  {
    super(paramBoolean);
    this.docLength = paramInt;
  }
  
  public int getDocLength()
  {
    return this.docLength;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\rainbow\RainbowKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */