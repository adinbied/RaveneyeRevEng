package org.bouncycastle.crypto.params;

public class GOST3410ValidationParameters
{
  private int c;
  private long cL;
  private int x0;
  private long x0L;
  
  public GOST3410ValidationParameters(int paramInt1, int paramInt2)
  {
    this.x0 = paramInt1;
    this.c = paramInt2;
  }
  
  public GOST3410ValidationParameters(long paramLong1, long paramLong2)
  {
    this.x0L = paramLong1;
    this.cL = paramLong2;
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof GOST3410ValidationParameters)) {
      return false;
    }
    paramObject = (GOST3410ValidationParameters)paramObject;
    if (((GOST3410ValidationParameters)paramObject).c != this.c) {
      return false;
    }
    if (((GOST3410ValidationParameters)paramObject).x0 != this.x0) {
      return false;
    }
    if (((GOST3410ValidationParameters)paramObject).cL != this.cL) {
      return false;
    }
    return ((GOST3410ValidationParameters)paramObject).x0L == this.x0L;
  }
  
  public int getC()
  {
    return this.c;
  }
  
  public long getCL()
  {
    return this.cL;
  }
  
  public int getX0()
  {
    return this.x0;
  }
  
  public long getX0L()
  {
    return this.x0L;
  }
  
  public int hashCode()
  {
    int i = this.x0;
    int j = this.c;
    long l = this.x0L;
    int k = (int)l;
    int m = (int)(l >> 32);
    l = this.cL;
    return i ^ j ^ k ^ m ^ (int)l ^ (int)(l >> 32);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\GOST3410ValidationParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */