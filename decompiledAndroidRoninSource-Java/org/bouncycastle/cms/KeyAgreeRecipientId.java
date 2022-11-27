package org.bouncycastle.cms;

import java.math.BigInteger;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.cert.selector.X509CertificateHolderSelector;

public class KeyAgreeRecipientId
  extends RecipientId
{
  private X509CertificateHolderSelector baseSelector;
  
  public KeyAgreeRecipientId(X500Name paramX500Name, BigInteger paramBigInteger)
  {
    this(paramX500Name, paramBigInteger, null);
  }
  
  public KeyAgreeRecipientId(X500Name paramX500Name, BigInteger paramBigInteger, byte[] paramArrayOfByte)
  {
    this(new X509CertificateHolderSelector(paramX500Name, paramBigInteger, paramArrayOfByte));
  }
  
  private KeyAgreeRecipientId(X509CertificateHolderSelector paramX509CertificateHolderSelector)
  {
    super(2);
    this.baseSelector = paramX509CertificateHolderSelector;
  }
  
  public KeyAgreeRecipientId(byte[] paramArrayOfByte)
  {
    this(null, null, paramArrayOfByte);
  }
  
  public Object clone()
  {
    return new KeyAgreeRecipientId(this.baseSelector);
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof KeyAgreeRecipientId)) {
      return false;
    }
    paramObject = (KeyAgreeRecipientId)paramObject;
    return this.baseSelector.equals(((KeyAgreeRecipientId)paramObject).baseSelector);
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
    if ((paramObject instanceof KeyAgreeRecipientInformation)) {
      return ((KeyAgreeRecipientInformation)paramObject).getRID().equals(this);
    }
    return this.baseSelector.match(paramObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\KeyAgreeRecipientId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */