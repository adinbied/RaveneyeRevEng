package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class McElieceKeyParameters
  extends AsymmetricKeyParameter
{
  private McElieceParameters params;
  
  public McElieceKeyParameters(boolean paramBoolean, McElieceParameters paramMcElieceParameters)
  {
    super(paramBoolean);
    this.params = paramMcElieceParameters;
  }
  
  public McElieceParameters getParameters()
  {
    return this.params;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */