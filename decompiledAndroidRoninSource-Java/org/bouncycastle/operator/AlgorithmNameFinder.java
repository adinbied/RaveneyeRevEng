package org.bouncycastle.operator;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;

public abstract interface AlgorithmNameFinder
{
  public abstract String getAlgorithmName(ASN1ObjectIdentifier paramASN1ObjectIdentifier);
  
  public abstract String getAlgorithmName(AlgorithmIdentifier paramAlgorithmIdentifier);
  
  public abstract boolean hasAlgorithmName(ASN1ObjectIdentifier paramASN1ObjectIdentifier);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\AlgorithmNameFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */