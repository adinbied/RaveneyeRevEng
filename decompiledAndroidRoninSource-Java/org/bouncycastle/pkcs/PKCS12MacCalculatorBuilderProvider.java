package org.bouncycastle.pkcs;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public abstract interface PKCS12MacCalculatorBuilderProvider
{
  public abstract PKCS12MacCalculatorBuilder get(AlgorithmIdentifier paramAlgorithmIdentifier);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS12MacCalculatorBuilderProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */