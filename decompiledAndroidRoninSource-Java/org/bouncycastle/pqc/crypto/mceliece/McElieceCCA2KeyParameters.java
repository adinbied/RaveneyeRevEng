package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class McElieceCCA2KeyParameters
  extends AsymmetricKeyParameter
{
  private String params;
  
  public McElieceCCA2KeyParameters(boolean paramBoolean, String paramString)
  {
    super(paramBoolean);
    this.params = paramString;
  }
  
  public String getDigest()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceCCA2KeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */