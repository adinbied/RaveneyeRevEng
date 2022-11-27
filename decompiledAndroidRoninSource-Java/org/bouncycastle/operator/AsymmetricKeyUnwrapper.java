package org.bouncycastle.operator;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public abstract class AsymmetricKeyUnwrapper
  implements KeyUnwrapper
{
  private AlgorithmIdentifier algorithmId;
  
  protected AsymmetricKeyUnwrapper(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.algorithmId = paramAlgorithmIdentifier;
  }
  
  public AlgorithmIdentifier getAlgorithmIdentifier()
  {
    return this.algorithmId;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\AsymmetricKeyUnwrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */