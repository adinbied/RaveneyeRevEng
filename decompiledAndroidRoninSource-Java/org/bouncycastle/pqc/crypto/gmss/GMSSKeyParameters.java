package org.bouncycastle.pqc.crypto.gmss;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class GMSSKeyParameters
  extends AsymmetricKeyParameter
{
  private GMSSParameters params;
  
  public GMSSKeyParameters(boolean paramBoolean, GMSSParameters paramGMSSParameters)
  {
    super(paramBoolean);
    this.params = paramGMSSParameters;
  }
  
  public GMSSParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\gmss\GMSSKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */