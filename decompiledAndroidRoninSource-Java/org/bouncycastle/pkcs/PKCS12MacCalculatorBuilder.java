package org.bouncycastle.pkcs;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.OperatorCreationException;

public abstract interface PKCS12MacCalculatorBuilder
{
  public abstract MacCalculator build(char[] paramArrayOfChar)
    throws OperatorCreationException;
  
  public abstract AlgorithmIdentifier getDigestAlgorithmIdentifier();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS12MacCalculatorBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */