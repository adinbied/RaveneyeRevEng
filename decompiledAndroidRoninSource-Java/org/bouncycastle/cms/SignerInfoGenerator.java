package org.bouncycastle.cms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.SignerIdentifier;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.io.TeeOutputStream;

public class SignerInfoGenerator
{
  private byte[] calculatedDigest;
  private X509CertificateHolder certHolder;
  private final DigestAlgorithmIdentifierFinder digAlgFinder;
  private final DigestCalculator digester;
  private final CMSAttributeTableGenerator sAttrGen;
  private final CMSSignatureEncryptionAlgorithmFinder sigEncAlgFinder;
  private final ContentSigner signer;
  private final SignerIdentifier signerIdentifier;
  private final CMSAttributeTableGenerator unsAttrGen;
  
  SignerInfoGenerator(SignerIdentifier paramSignerIdentifier, ContentSigner paramContentSigner, DigestCalculatorProvider paramDigestCalculatorProvider, CMSSignatureEncryptionAlgorithmFinder paramCMSSignatureEncryptionAlgorithmFinder)
    throws OperatorCreationException
  {
    this(paramSignerIdentifier, paramContentSigner, paramDigestCalculatorProvider, paramCMSSignatureEncryptionAlgorithmFinder, false);
  }
  
  SignerInfoGenerator(SignerIdentifier paramSignerIdentifier, ContentSigner paramContentSigner, DigestCalculatorProvider paramDigestCalculatorProvider, CMSSignatureEncryptionAlgorithmFinder paramCMSSignatureEncryptionAlgorithmFinder, CMSAttributeTableGenerator paramCMSAttributeTableGenerator1, CMSAttributeTableGenerator paramCMSAttributeTableGenerator2)
    throws OperatorCreationException
  {
    DefaultDigestAlgorithmIdentifierFinder localDefaultDigestAlgorithmIdentifierFinder = new DefaultDigestAlgorithmIdentifierFinder();
    this.digAlgFinder = localDefaultDigestAlgorithmIdentifierFinder;
    this.calculatedDigest = null;
    this.signerIdentifier = paramSignerIdentifier;
    this.signer = paramContentSigner;
    if (paramDigestCalculatorProvider != null) {
      this.digester = paramDigestCalculatorProvider.get(localDefaultDigestAlgorithmIdentifierFinder.find(paramContentSigner.getAlgorithmIdentifier()));
    } else {
      this.digester = null;
    }
    this.sAttrGen = paramCMSAttributeTableGenerator1;
    this.unsAttrGen = paramCMSAttributeTableGenerator2;
    this.sigEncAlgFinder = paramCMSSignatureEncryptionAlgorithmFinder;
  }
  
  SignerInfoGenerator(SignerIdentifier paramSignerIdentifier, ContentSigner paramContentSigner, DigestCalculatorProvider paramDigestCalculatorProvider, CMSSignatureEncryptionAlgorithmFinder paramCMSSignatureEncryptionAlgorithmFinder, boolean paramBoolean)
    throws OperatorCreationException
  {
    DefaultDigestAlgorithmIdentifierFinder localDefaultDigestAlgorithmIdentifierFinder = new DefaultDigestAlgorithmIdentifierFinder();
    this.digAlgFinder = localDefaultDigestAlgorithmIdentifierFinder;
    this.calculatedDigest = null;
    this.signerIdentifier = paramSignerIdentifier;
    this.signer = paramContentSigner;
    if (paramDigestCalculatorProvider != null) {
      this.digester = paramDigestCalculatorProvider.get(localDefaultDigestAlgorithmIdentifierFinder.find(paramContentSigner.getAlgorithmIdentifier()));
    } else {
      this.digester = null;
    }
    if (paramBoolean) {
      this.sAttrGen = null;
    } else {
      this.sAttrGen = new DefaultSignedAttributeTableGenerator();
    }
    this.unsAttrGen = null;
    this.sigEncAlgFinder = paramCMSSignatureEncryptionAlgorithmFinder;
  }
  
  public SignerInfoGenerator(SignerInfoGenerator paramSignerInfoGenerator, CMSAttributeTableGenerator paramCMSAttributeTableGenerator1, CMSAttributeTableGenerator paramCMSAttributeTableGenerator2)
  {
    this.digAlgFinder = new DefaultDigestAlgorithmIdentifierFinder();
    this.calculatedDigest = null;
    this.signerIdentifier = paramSignerInfoGenerator.signerIdentifier;
    this.signer = paramSignerInfoGenerator.signer;
    this.digester = paramSignerInfoGenerator.digester;
    this.sigEncAlgFinder = paramSignerInfoGenerator.sigEncAlgFinder;
    this.sAttrGen = paramCMSAttributeTableGenerator1;
    this.unsAttrGen = paramCMSAttributeTableGenerator2;
  }
  
  private ASN1Set getAttributeSet(AttributeTable paramAttributeTable)
  {
    if (paramAttributeTable != null) {
      return new DERSet(paramAttributeTable.toASN1EncodableVector());
    }
    return null;
  }
  
  private Map getBaseParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier, AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2, byte[] paramArrayOfByte)
  {
    HashMap localHashMap = new HashMap();
    if (paramASN1ObjectIdentifier != null) {
      localHashMap.put("contentType", paramASN1ObjectIdentifier);
    }
    localHashMap.put("digestAlgID", paramAlgorithmIdentifier1);
    localHashMap.put("signatureAlgID", paramAlgorithmIdentifier2);
    localHashMap.put("digest", Arrays.clone(paramArrayOfByte));
    return localHashMap;
  }
  
  public SignerInfo generate(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws CMSException
  {
    for (;;)
    {
      try
      {
        AlgorithmIdentifier localAlgorithmIdentifier2 = this.sigEncAlgFinder.findEncryptionAlgorithm(this.signer.getAlgorithmIdentifier());
        AlgorithmIdentifier localAlgorithmIdentifier1;
        if (this.sAttrGen != null)
        {
          localAlgorithmIdentifier1 = this.digester.getAlgorithmIdentifier();
          this.calculatedDigest = this.digester.getDigest();
          localObject1 = getBaseParameters(paramASN1ObjectIdentifier, this.digester.getAlgorithmIdentifier(), localAlgorithmIdentifier2, this.calculatedDigest);
          localObject1 = getAttributeSet(this.sAttrGen.getAttributes(Collections.unmodifiableMap((Map)localObject1)));
          localObject2 = this.signer.getOutputStream();
          ((OutputStream)localObject2).write(((ASN1Set)localObject1).getEncoded("DER"));
          ((OutputStream)localObject2).close();
        }
        else
        {
          if (this.digester != null)
          {
            localAlgorithmIdentifier1 = this.digester.getAlgorithmIdentifier();
            this.calculatedDigest = this.digester.getDigest();
            break label285;
          }
          localAlgorithmIdentifier1 = this.digAlgFinder.find(this.signer.getAlgorithmIdentifier());
          this.calculatedDigest = null;
          break label285;
        }
        Object localObject2 = this.signer.getSignature();
        if (this.unsAttrGen == null) {
          break label290;
        }
        paramASN1ObjectIdentifier = getBaseParameters(paramASN1ObjectIdentifier, localAlgorithmIdentifier1, localAlgorithmIdentifier2, this.calculatedDigest);
        paramASN1ObjectIdentifier.put("encryptedDigest", Arrays.clone((byte[])localObject2));
        paramASN1ObjectIdentifier = getAttributeSet(this.unsAttrGen.getAttributes(Collections.unmodifiableMap(paramASN1ObjectIdentifier)));
        paramASN1ObjectIdentifier = new SignerInfo(this.signerIdentifier, localAlgorithmIdentifier1, (ASN1Set)localObject1, localAlgorithmIdentifier2, new DEROctetString((byte[])localObject2), paramASN1ObjectIdentifier);
        return paramASN1ObjectIdentifier;
      }
      catch (IOException paramASN1ObjectIdentifier)
      {
        throw new CMSException("encoding error.", paramASN1ObjectIdentifier);
      }
      label285:
      Object localObject1 = null;
      continue;
      label290:
      paramASN1ObjectIdentifier = null;
    }
  }
  
  public X509CertificateHolder getAssociatedCertificate()
  {
    return this.certHolder;
  }
  
  public byte[] getCalculatedDigest()
  {
    byte[] arrayOfByte = this.calculatedDigest;
    if (arrayOfByte != null) {
      return Arrays.clone(arrayOfByte);
    }
    return null;
  }
  
  public OutputStream getCalculatingOutputStream()
  {
    DigestCalculator localDigestCalculator = this.digester;
    if (localDigestCalculator != null)
    {
      if (this.sAttrGen == null) {
        return new TeeOutputStream(this.digester.getOutputStream(), this.signer.getOutputStream());
      }
      return localDigestCalculator.getOutputStream();
    }
    return this.signer.getOutputStream();
  }
  
  public AlgorithmIdentifier getDigestAlgorithm()
  {
    DigestCalculator localDigestCalculator = this.digester;
    if (localDigestCalculator != null) {
      return localDigestCalculator.getAlgorithmIdentifier();
    }
    return this.digAlgFinder.find(this.signer.getAlgorithmIdentifier());
  }
  
  public int getGeneratedVersion()
  {
    if (this.signerIdentifier.isTagged()) {
      return 3;
    }
    return 1;
  }
  
  public SignerIdentifier getSID()
  {
    return this.signerIdentifier;
  }
  
  public CMSAttributeTableGenerator getSignedAttributeTableGenerator()
  {
    return this.sAttrGen;
  }
  
  public CMSAttributeTableGenerator getUnsignedAttributeTableGenerator()
  {
    return this.unsAttrGen;
  }
  
  public boolean hasAssociatedCertificate()
  {
    return this.certHolder != null;
  }
  
  void setAssociatedCertificate(X509CertificateHolder paramX509CertificateHolder)
  {
    this.certHolder = paramX509CertificateHolder;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\SignerInfoGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */