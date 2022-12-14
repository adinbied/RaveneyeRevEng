package org.bouncycastle.pkcs;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.asn1.pkcs.CertBag;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.SafeBag;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.CertificateList;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OutputEncryptor;

public class PKCS12SafeBagBuilder
{
  private ASN1EncodableVector bagAttrs = new ASN1EncodableVector();
  private ASN1ObjectIdentifier bagType = PKCSObjectIdentifiers.crlBag;
  private ASN1Encodable bagValue;
  
  public PKCS12SafeBagBuilder(PrivateKeyInfo paramPrivateKeyInfo)
  {
    this.bagValue = paramPrivateKeyInfo;
  }
  
  public PKCS12SafeBagBuilder(PrivateKeyInfo paramPrivateKeyInfo, OutputEncryptor paramOutputEncryptor)
  {
    this.bagValue = new PKCS8EncryptedPrivateKeyInfoBuilder(paramPrivateKeyInfo).build(paramOutputEncryptor).toASN1Structure();
  }
  
  public PKCS12SafeBagBuilder(Certificate paramCertificate)
    throws IOException
  {
    this.bagValue = new CertBag(PKCSObjectIdentifiers.x509Certificate, new DEROctetString(paramCertificate.getEncoded()));
  }
  
  public PKCS12SafeBagBuilder(CertificateList paramCertificateList)
    throws IOException
  {
    this.bagValue = new CertBag(PKCSObjectIdentifiers.x509Crl, new DEROctetString(paramCertificateList.getEncoded()));
  }
  
  public PKCS12SafeBagBuilder(X509CRLHolder paramX509CRLHolder)
    throws IOException
  {
    this(paramX509CRLHolder.toASN1Structure());
  }
  
  public PKCS12SafeBagBuilder(X509CertificateHolder paramX509CertificateHolder)
    throws IOException
  {
    this(paramX509CertificateHolder.toASN1Structure());
  }
  
  public PKCS12SafeBagBuilder addBagAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.bagAttrs.add(new Attribute(paramASN1ObjectIdentifier, new DERSet(paramASN1Encodable)));
    return this;
  }
  
  public PKCS12SafeBag build()
  {
    return new PKCS12SafeBag(new SafeBag(this.bagType, this.bagValue, new DERSet(this.bagAttrs)));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS12SafeBagBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */