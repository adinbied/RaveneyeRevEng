package org.bouncycastle.crypto.params;

public class ECKeyParameters
  extends AsymmetricKeyParameter
{
  ECDomainParameters params;
  
  protected ECKeyParameters(boolean paramBoolean, ECDomainParameters paramECDomainParameters)
  {
    super(paramBoolean);
    this.params = paramECDomainParameters;
  }
  
  public ECDomainParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\ECKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */