package org.bouncycastle.crypto.params;

public class DSAKeyParameters
  extends AsymmetricKeyParameter
{
  private DSAParameters params;
  
  public DSAKeyParameters(boolean paramBoolean, DSAParameters paramDSAParameters)
  {
    super(paramBoolean);
    this.params = paramDSAParameters;
  }
  
  public DSAParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\DSAKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */