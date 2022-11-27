package org.bouncycastle.operator;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public abstract interface InputDecryptorProvider
{
  public abstract InputDecryptor get(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws OperatorCreationException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\InputDecryptorProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */