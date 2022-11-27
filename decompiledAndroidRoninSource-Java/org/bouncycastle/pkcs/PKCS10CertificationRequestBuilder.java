package org.bouncycastle.pkcs;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.pkcs.Attribute;
import org.bouncycastle.asn1.pkcs.CertificationRequest;
import org.bouncycastle.asn1.pkcs.CertificationRequestInfo;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.ContentSigner;

public class PKCS10CertificationRequestBuilder
{
  private List attributes = new ArrayList();
  private boolean leaveOffEmpty = false;
  private SubjectPublicKeyInfo publicKeyInfo;
  private X500Name subject;
  
  public PKCS10CertificationRequestBuilder(X500Name paramX500Name, SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    this.subject = paramX500Name;
    this.publicKeyInfo = paramSubjectPublicKeyInfo;
  }
  
  public PKCS10CertificationRequestBuilder(PKCS10CertificationRequestBuilder paramPKCS10CertificationRequestBuilder)
  {
    this.publicKeyInfo = paramPKCS10CertificationRequestBuilder.publicKeyInfo;
    this.subject = paramPKCS10CertificationRequestBuilder.subject;
    this.leaveOffEmpty = paramPKCS10CertificationRequestBuilder.leaveOffEmpty;
    this.attributes = new ArrayList(paramPKCS10CertificationRequestBuilder.attributes);
  }
  
  public PKCS10CertificationRequestBuilder addAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.attributes.add(new Attribute(paramASN1ObjectIdentifier, new DERSet(paramASN1Encodable)));
    return this;
  }
  
  public PKCS10CertificationRequestBuilder addAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    this.attributes.add(new Attribute(paramASN1ObjectIdentifier, new DERSet(paramArrayOfASN1Encodable)));
    return this;
  }
  
  public PKCS10CertificationRequest build(ContentSigner paramContentSigner)
  {
    Object localObject1;
    Object localObject2;
    if (this.attributes.isEmpty())
    {
      if (this.leaveOffEmpty) {
        localObject1 = new CertificationRequestInfo(this.subject, this.publicKeyInfo, null);
      } else {
        localObject1 = new CertificationRequestInfo(this.subject, this.publicKeyInfo, new DERSet());
      }
    }
    else
    {
      localObject1 = new ASN1EncodableVector();
      localObject2 = this.attributes.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((ASN1EncodableVector)localObject1).add(Attribute.getInstance(((Iterator)localObject2).next()));
      }
      localObject1 = new CertificationRequestInfo(this.subject, this.publicKeyInfo, new DERSet((ASN1EncodableVector)localObject1));
    }
    try
    {
      localObject2 = paramContentSigner.getOutputStream();
      ((OutputStream)localObject2).write(((CertificationRequestInfo)localObject1).getEncoded("DER"));
      ((OutputStream)localObject2).close();
      paramContentSigner = new PKCS10CertificationRequest(new CertificationRequest((CertificationRequestInfo)localObject1, paramContentSigner.getAlgorithmIdentifier(), new DERBitString(paramContentSigner.getSignature())));
      return paramContentSigner;
    }
    catch (IOException paramContentSigner)
    {
      for (;;) {}
    }
    throw new IllegalStateException("cannot produce certification request signature");
  }
  
  public PKCS10CertificationRequestBuilder setAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    Iterator localIterator = this.attributes.iterator();
    while (localIterator.hasNext()) {
      if (((Attribute)localIterator.next()).getAttrType().equals(paramASN1ObjectIdentifier))
      {
        paramASN1Encodable = new StringBuilder();
        paramASN1Encodable.append("Attribute ");
        paramASN1Encodable.append(paramASN1ObjectIdentifier.toString());
        paramASN1Encodable.append(" is already set");
        throw new IllegalStateException(paramASN1Encodable.toString());
      }
    }
    addAttribute(paramASN1ObjectIdentifier, paramASN1Encodable);
    return this;
  }
  
  public PKCS10CertificationRequestBuilder setAttribute(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable[] paramArrayOfASN1Encodable)
  {
    Iterator localIterator = this.attributes.iterator();
    while (localIterator.hasNext()) {
      if (((Attribute)localIterator.next()).getAttrType().equals(paramASN1ObjectIdentifier))
      {
        paramArrayOfASN1Encodable = new StringBuilder();
        paramArrayOfASN1Encodable.append("Attribute ");
        paramArrayOfASN1Encodable.append(paramASN1ObjectIdentifier.toString());
        paramArrayOfASN1Encodable.append(" is already set");
        throw new IllegalStateException(paramArrayOfASN1Encodable.toString());
      }
    }
    addAttribute(paramASN1ObjectIdentifier, paramArrayOfASN1Encodable);
    return this;
  }
  
  public PKCS10CertificationRequestBuilder setLeaveOffEmptyAttributes(boolean paramBoolean)
  {
    this.leaveOffEmpty = paramBoolean;
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS10CertificationRequestBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */