package org.bouncycastle.pkcs;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.asn1.pkcs.CRLBag;
import org.bouncycastle.asn1.pkcs.CertBag;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.SafeBag;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;

public class PKCS12SafeBag
{
  public static final ASN1ObjectIdentifier friendlyNameAttribute = PKCSObjectIdentifiers.pkcs_9_at_friendlyName;
  public static final ASN1ObjectIdentifier localKeyIdAttribute = PKCSObjectIdentifiers.pkcs_9_at_localKeyId;
  private SafeBag safeBag;
  
  public PKCS12SafeBag(SafeBag paramSafeBag)
  {
    this.safeBag = paramSafeBag;
  }
  
  public Attribute[] getAttributes()
  {
    ASN1Set localASN1Set = this.safeBag.getBagAttributes();
    if (localASN1Set == null) {
      return null;
    }
    Attribute[] arrayOfAttribute = new Attribute[localASN1Set.size()];
    int i = 0;
    while (i != localASN1Set.size())
    {
      arrayOfAttribute[i] = Attribute.getInstance(localASN1Set.getObjectAt(i));
      i += 1;
    }
    return arrayOfAttribute;
  }
  
  public Object getBagValue()
  {
    if (getType().equals(PKCSObjectIdentifiers.pkcs8ShroudedKeyBag)) {
      return new PKCS8EncryptedPrivateKeyInfo(EncryptedPrivateKeyInfo.getInstance(this.safeBag.getBagValue()));
    }
    if (getType().equals(PKCSObjectIdentifiers.certBag)) {
      return new X509CertificateHolder(Certificate.getInstance(ASN1OctetString.getInstance(CertBag.getInstance(this.safeBag.getBagValue()).getCertValue()).getOctets()));
    }
    if (getType().equals(PKCSObjectIdentifiers.keyBag)) {
      return PrivateKeyInfo.getInstance(this.safeBag.getBagValue());
    }
    if (getType().equals(PKCSObjectIdentifiers.crlBag)) {
      return new X509CRLHolder(CertificateList.getInstance(ASN1OctetString.getInstance(CRLBag.getInstance(this.safeBag.getBagValue()).getCrlValue()).getOctets()));
    }
    return this.safeBag.getBagValue();
  }
  
  public ASN1ObjectIdentifier getType()
  {
    return this.safeBag.getBagId();
  }
  
  public SafeBag toASN1Structure()
  {
    return this.safeBag;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS12SafeBag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */