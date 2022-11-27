package org.bouncycastle.cert.crmf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.crmf.AttributeTypeAndValue;
import org.bouncycastle.asn1.crmf.CertReqMsg;
import org.bouncycastle.asn1.crmf.CertRequest;
import org.bouncycastle.asn1.crmf.CertTemplate;
import org.bouncycastle.asn1.crmf.CertTemplateBuilder;
import org.bouncycastle.asn1.crmf.OptionalValidity;
import org.bouncycastle.asn1.crmf.POPOPrivKey;
import org.bouncycastle.asn1.crmf.ProofOfPossession;
import org.bouncycastle.asn1.crmf.SubsequentMessage;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.Time;
import org.bouncycastle.cert.CertIOException;
import org.bouncycastle.operator.ContentSigner;

public class CertificateRequestMessageBuilder
{
  private final BigInteger certReqId;
  private List controls;
  private ExtensionsGenerator extGenerator;
  private char[] password;
  private PKMACBuilder pkmacBuilder;
  private ASN1Null popRaVerified;
  private ContentSigner popSigner;
  private POPOPrivKey popoPrivKey;
  private GeneralName sender;
  private CertTemplateBuilder templateBuilder;
  
  public CertificateRequestMessageBuilder(BigInteger paramBigInteger)
  {
    this.certReqId = paramBigInteger;
    this.extGenerator = new ExtensionsGenerator();
    this.templateBuilder = new CertTemplateBuilder();
    this.controls = new ArrayList();
  }
  
  private Time createTime(Date paramDate)
  {
    if (paramDate != null) {
      return new Time(paramDate);
    }
    return null;
  }
  
  public CertificateRequestMessageBuilder addControl(Control paramControl)
  {
    this.controls.add(paramControl);
    return this;
  }
  
  public CertificateRequestMessageBuilder addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
    throws CertIOException
  {
    CRMFUtil.addExtension(this.extGenerator, paramASN1ObjectIdentifier, paramBoolean, paramASN1Encodable);
    return this;
  }
  
  public CertificateRequestMessageBuilder addExtension(ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, byte[] paramArrayOfByte)
  {
    this.extGenerator.addExtension(paramASN1ObjectIdentifier, paramBoolean, paramArrayOfByte);
    return this;
  }
  
  public CertificateRequestMessage build()
    throws CRMFException
  {
    Object localObject1 = new ASN1EncodableVector();
    ((ASN1EncodableVector)localObject1).add(new ASN1Integer(this.certReqId));
    if (!this.extGenerator.isEmpty()) {
      this.templateBuilder.setExtensions(this.extGenerator.generate());
    }
    ((ASN1EncodableVector)localObject1).add(this.templateBuilder.build());
    Object localObject2;
    if (!this.controls.isEmpty())
    {
      localASN1EncodableVector = new ASN1EncodableVector();
      localObject2 = this.controls.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Control localControl = (Control)((Iterator)localObject2).next();
        localASN1EncodableVector.add(new AttributeTypeAndValue(localControl.getType(), localControl.getValue()));
      }
      ((ASN1EncodableVector)localObject1).add(new DERSequence(localASN1EncodableVector));
    }
    localObject1 = CertRequest.getInstance(new DERSequence((ASN1EncodableVector)localObject1));
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add((ASN1Encodable)localObject1);
    if (this.popSigner != null)
    {
      localObject2 = ((CertRequest)localObject1).getCertTemplate();
      if ((((CertTemplate)localObject2).getSubject() != null) && (((CertTemplate)localObject2).getPublicKey() != null))
      {
        localObject1 = new ProofOfPossession(new ProofOfPossessionSigningKeyBuilder((CertRequest)localObject1).build(this.popSigner));
      }
      else
      {
        localObject1 = new ProofOfPossessionSigningKeyBuilder(((CertRequest)localObject1).getCertTemplate().getPublicKey());
        localObject2 = this.sender;
        if (localObject2 != null) {
          ((ProofOfPossessionSigningKeyBuilder)localObject1).setSender((GeneralName)localObject2);
        } else {
          ((ProofOfPossessionSigningKeyBuilder)localObject1).setPublicKeyMac(new PKMACValueGenerator(this.pkmacBuilder), this.password);
        }
        localObject1 = new ProofOfPossession(((ProofOfPossessionSigningKeyBuilder)localObject1).build(this.popSigner));
      }
    }
    else
    {
      localObject1 = this.popoPrivKey;
      if (localObject1 != null)
      {
        localASN1EncodableVector.add(new ProofOfPossession(2, (POPOPrivKey)localObject1));
        break label346;
      }
      if (this.popRaVerified == null) {
        break label346;
      }
      localObject1 = new ProofOfPossession();
    }
    localASN1EncodableVector.add((ASN1Encodable)localObject1);
    label346:
    return new CertificateRequestMessage(CertReqMsg.getInstance(new DERSequence(localASN1EncodableVector)));
  }
  
  public CertificateRequestMessageBuilder setAuthInfoPKMAC(PKMACBuilder paramPKMACBuilder, char[] paramArrayOfChar)
  {
    this.pkmacBuilder = paramPKMACBuilder;
    this.password = paramArrayOfChar;
    return this;
  }
  
  public CertificateRequestMessageBuilder setAuthInfoSender(X500Name paramX500Name)
  {
    return setAuthInfoSender(new GeneralName(paramX500Name));
  }
  
  public CertificateRequestMessageBuilder setAuthInfoSender(GeneralName paramGeneralName)
  {
    this.sender = paramGeneralName;
    return this;
  }
  
  public CertificateRequestMessageBuilder setIssuer(X500Name paramX500Name)
  {
    if (paramX500Name != null) {
      this.templateBuilder.setIssuer(paramX500Name);
    }
    return this;
  }
  
  public CertificateRequestMessageBuilder setProofOfPossessionRaVerified()
  {
    if ((this.popSigner == null) && (this.popoPrivKey == null))
    {
      this.popRaVerified = DERNull.INSTANCE;
      return this;
    }
    throw new IllegalStateException("only one proof of possession allowed");
  }
  
  public CertificateRequestMessageBuilder setProofOfPossessionSigningKeySigner(ContentSigner paramContentSigner)
  {
    if ((this.popoPrivKey == null) && (this.popRaVerified == null))
    {
      this.popSigner = paramContentSigner;
      return this;
    }
    throw new IllegalStateException("only one proof of possession allowed");
  }
  
  public CertificateRequestMessageBuilder setProofOfPossessionSubsequentMessage(SubsequentMessage paramSubsequentMessage)
  {
    if ((this.popSigner == null) && (this.popRaVerified == null))
    {
      this.popoPrivKey = new POPOPrivKey(paramSubsequentMessage);
      return this;
    }
    throw new IllegalStateException("only one proof of possession allowed");
  }
  
  public CertificateRequestMessageBuilder setPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    if (paramSubjectPublicKeyInfo != null) {
      this.templateBuilder.setPublicKey(paramSubjectPublicKeyInfo);
    }
    return this;
  }
  
  public CertificateRequestMessageBuilder setSerialNumber(BigInteger paramBigInteger)
  {
    if (paramBigInteger != null) {
      this.templateBuilder.setSerialNumber(new ASN1Integer(paramBigInteger));
    }
    return this;
  }
  
  public CertificateRequestMessageBuilder setSubject(X500Name paramX500Name)
  {
    if (paramX500Name != null) {
      this.templateBuilder.setSubject(paramX500Name);
    }
    return this;
  }
  
  public CertificateRequestMessageBuilder setValidity(Date paramDate1, Date paramDate2)
  {
    this.templateBuilder.setValidity(new OptionalValidity(createTime(paramDate1), createTime(paramDate2)));
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\CertificateRequestMessageBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */