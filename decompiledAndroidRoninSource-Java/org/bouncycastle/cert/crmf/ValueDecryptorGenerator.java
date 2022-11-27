package org.bouncycastle.cert.crmf;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.InputDecryptor;

public abstract interface ValueDecryptorGenerator
{
  public abstract InputDecryptor getValueDecryptor(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
    throws CRMFException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\ValueDecryptorGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */