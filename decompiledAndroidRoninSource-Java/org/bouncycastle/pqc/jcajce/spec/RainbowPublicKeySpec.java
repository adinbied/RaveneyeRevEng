package org.bouncycastle.pqc.jcajce.spec;

import java.security.spec.KeySpec;

public class RainbowPublicKeySpec
  implements KeySpec
{
  private short[][] coeffquadratic;
  private short[] coeffscalar;
  private short[][] coeffsingular;
  private int docLength;
  
  public RainbowPublicKeySpec(int paramInt, short[][] paramArrayOfShort1, short[][] paramArrayOfShort2, short[] paramArrayOfShort)
  {
    this.docLength = paramInt;
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
  
  public int getDocLength()
  {
    return this.docLength;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\spec\RainbowPublicKeySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */