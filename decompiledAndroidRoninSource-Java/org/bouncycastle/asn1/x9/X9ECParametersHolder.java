package org.bouncycastle.asn1.x9;

public abstract class X9ECParametersHolder
{
  private X9ECParameters params;
  
  protected abstract X9ECParameters createParameters();
  
  public X9ECParameters getParameters()
  {
    try
    {
      if (this.params == null) {
        this.params = createParameters();
      }
      X9ECParameters localX9ECParameters = this.params;
      return localX9ECParameters;
    }
    finally {}
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x9\X9ECParametersHolder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */