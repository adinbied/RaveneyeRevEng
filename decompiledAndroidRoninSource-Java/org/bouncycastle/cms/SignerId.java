package org.bouncycastle.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.selector.X509CertificateHolderSelector;
import org.bouncycastle.util.Selector;

public class SignerId
  implements Selector
{
  private X509CertificateHolderSelector baseSelector;
  
  public SignerId(X500Name paramX500Name, BigInteger paramBigInteger)
  {
    this(paramX500Name, paramBigInteger, null);
  }
  
  public SignerId(X500Name paramX500Name, BigInteger paramBigInteger, byte[] paramArrayOfByte)
  {
    this(new X509CertificateHolderSelector(paramX500Name, paramBigInteger, paramArrayOfByte));
  }
  
  private SignerId(X509CertificateHolderSelector paramX509CertificateHolderSelector)
  {
    this.baseSelector = paramX509CertificateHolderSelector;
  }
  
  public SignerId(byte[] paramArrayOfByte)
  {
    this(null, null, paramArrayOfByte);
  }
  
  public Object clone()
  {
    return new SignerId(this.baseSelector);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof SignerId)) {
      return false;
    }
    paramObject = (SignerId)paramObject;
    return this.baseSelector.equals(((SignerId)paramObject).baseSelector);
  }
  
  public X500Name getIssuer()
  {
    return this.baseSelector.getIssuer();
  }
  
  public BigInteger getSerialNumber()
  {
    return this.baseSelector.getSerialNumber();
  }
  
  public byte[] getSubjectKeyIdentifier()
  {
    return this.baseSelector.getSubjectKeyIdentifier();
  }
  
  public int hashCode()
  {
    return this.baseSelector.hashCode();
  }
  
  public boolean match(Object paramObject)
  {
    if ((paramObject instanceof SignerInformation)) {
      return ((SignerInformation)paramObject).getSID().equals(this);
    }
    return this.baseSelector.match(paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\SignerId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */