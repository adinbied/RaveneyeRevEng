package org.bouncycastle.pqc.crypto.rainbow;

public class RainbowPublicKeyParameters
  extends RainbowKeyParameters
{
  private short[][] coeffquadratic;
  private short[] coeffscalar;
  private short[][] coeffsingular;
  
  public RainbowPublicKeyParameters(int paramInt, short[][] paramArrayOfShort1, short[][] paramArrayOfShort2, short[] paramArrayOfShort)
  {
    super(false, paramInt);
    this.coeffquadratic = paramArrayOfShort1;
    this.coeffsingular = paramArrayOfShort2;
    this.coeffscalar = paramArrayOfShort;
  }
  
  public short[][] getCoeffQuadratic()
  {
    return this.coeffquadratic;
  }
  
  public short[] getCoeffScalar()
  {
    return this.coeffscalar;
  }
  
  public short[][] getCoeffSingular()
  {
    return this.coeffsingular;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\rainbow\RainbowPublicKeyParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */