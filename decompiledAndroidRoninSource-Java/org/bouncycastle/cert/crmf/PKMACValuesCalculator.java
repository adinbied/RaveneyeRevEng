package org.bouncycastle.cert.crmf;

import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public abstract interface PKMACValuesCalculator
{
  public abstract byte[] calculateDigest(byte[] paramArrayOfByte)
    throws CRMFException;
  
  public abstract byte[] calculateMac(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
    throws CRMFException;
  
  public abstract void setup(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
    throws CRMFException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\PKMACValuesCalculator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */