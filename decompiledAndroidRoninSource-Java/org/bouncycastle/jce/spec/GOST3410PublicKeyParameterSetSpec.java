package org.bouncycastle.jce.spec;

import java.math.BigInteger;

public class GOST3410PublicKeyParameterSetSpec
{
  private BigInteger a;
  private BigInteger p;
  private BigInteger q;
  
  public GOST3410PublicKeyParameterSetSpec(BigInteger paramBigInteger1, BigInteger paramBigInteger2, BigInteger paramBigInteger3)
  {
    this.p = paramBigInteger1;
    this.q = paramBigInteger2;
    this.a = paramBigInteger3;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool3 = paramObject instanceof GOST3410PublicKeyParameterSetSpec;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramObject = (GOST3410PublicKeyParameterSetSpec)paramObject;
      bool1 = bool2;
      if (this.a.equals(((GOST3410PublicKeyParameterSetSpec)paramObject).a))
      {
        bool1 = bool2;
        if (this.p.equals(((GOST3410PublicKeyParameterSetSpec)paramObject).p))
        {
          bool1 = bool2;
          if (this.q.equals(((GOST3410PublicKeyParameterSetSpec)paramObject).q)) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public BigInteger getA()
  {
    return this.a;
  }
  
  public BigInteger getP()
  {
    return this.p;
  }
  
  public BigInteger getQ()
  {
    return this.q;
  }
  
  public int hashCode()
  {
    return this.a.hashCode() ^ this.p.hashCode() ^ this.q.hashCode();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\GOST3410PublicKeyParameterSetSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */