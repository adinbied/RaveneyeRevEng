package org.bouncycastle.crypto.params;

public class GOST3410KeyParameters
  extends AsymmetricKeyParameter
{
  private GOST3410Parameters params;
  
  public GOST3410KeyParameters(boolean paramBoolean, GOST3410Parameters paramGOST3410Parameters)
  {
    super(paramBoolean);
    this.params = paramGOST3410Parameters;
  }
  
  public GOST3410Parameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\GOST3410KeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */