package org.bouncycastle.pqc.crypto.mceliece;

import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKeyParameters
  extends McElieceCCA2KeyParameters
{
  private GF2Matrix matrixG;
  private int n;
  private int t;
  
  public McElieceCCA2PublicKeyParameters(int paramInt1, int paramInt2, GF2Matrix paramGF2Matrix, String paramString)
  {
    super(false, paramString);
    this.n = paramInt1;
    this.t = paramInt2;
    this.matrixG = new GF2Matrix(paramGF2Matrix);
  }
  
  public GF2Matrix getG()
  {
    return this.matrixG;
  }
  
  public int getK()
  {
    return this.matrixG.getNumRows();
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\mceliece\McElieceCCA2PublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */