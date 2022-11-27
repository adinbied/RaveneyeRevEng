package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKeyParameters
  extends McElieceKeyParameters
{
  private GF2Matrix g;
  private int n;
  private int t;
  
  public McEliecePublicKeyParameters(int paramInt1, int paramInt2, GF2Matrix paramGF2Matrix)
  {
    super(false, null);
    this.n = paramInt1;
    this.t = paramInt2;
    this.g = new GF2Matrix(paramGF2Matrix);
  }
  
  public GF2Matrix getG()
  {
    return this.g;
  }
  
  public int getK()
  {
    return this.g.getNumRows();
  }
  
  public int getN()
  {
    return this.n;
  }
  
  public int getT()
  {
    return this.t;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McEliecePublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */