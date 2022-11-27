package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.AuthenticatedData;
import org.bouncycastle.asn1.cms.CMSAlgorithmProtection;
import org.bouncycastle.asn1.cms.CMSAttributes;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Encodable;

public class CMSAuthenticatedData
  implements Encodable
{
  private ASN1Set authAttrs;
  ContentInfo contentInfo;
  private byte[] mac;
  private AlgorithmIdentifier macAlg;
  private OriginatorInformation originatorInfo;
  RecipientInformationStore recipientInfoStore;
  private ASN1Set unauthAttrs;
  
  public CMSAuthenticatedData(InputStream paramInputStream)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramInputStream));
  }
  
  public CMSAuthenticatedData(InputStream paramInputStream, DigestCalculatorProvider paramDigestCalculatorProvider)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramInputStream), paramDigestCalculatorProvider);
  }
  
  public CMSAuthenticatedData(ContentInfo paramContentInfo)
    throws CMSException
  {
    this(paramContentInfo, null);
  }
  
  public CMSAuthenticatedData(ContentInfo paramContentInfo, DigestCalculatorProvider paramDigestCalculatorProvider)
    throws CMSException
  {
    this.contentInfo = paramContentInfo;
    AuthenticatedData localAuthenticatedData = AuthenticatedData.getInstance(paramContentInfo.getContent());
    if (localAuthenticatedData.getOriginatorInfo() != null) {
      this.originatorInfo = new OriginatorInformation(localAuthenticatedData.getOriginatorInfo());
    }
    paramContentInfo = localAuthenticatedData.getRecipientInfos();
    this.macAlg = localAuthenticatedData.getMacAlgorithm();
    this.authAttrs = localAuthenticatedData.getAuthAttrs();
    this.mac = localAuthenticatedData.getMac().getOctets();
    this.unauthAttrs = localAuthenticatedData.getUnauthAttrs();
    CMSProcessableByteArray localCMSProcessableByteArray = new CMSProcessableByteArray(ASN1OctetString.getInstance(localAuthenticatedData.getEncapsulatedContentInfo().getContent()).getOctets());
    Object localObject = this.authAttrs;
    if (localObject != null)
    {
      if (paramDigestCalculatorProvider != null)
      {
        localObject = new AttributeTable((ASN1Set)localObject).getAll(CMSAttributes.cmsAlgorithmProtect);
        if (((ASN1EncodableVector)localObject).size() <= 1)
        {
          if (((ASN1EncodableVector)localObject).size() > 0)
          {
            localObject = Attribute.getInstance(((ASN1EncodableVector)localObject).get(0));
            if (((Attribute)localObject).getAttrValues().size() == 1)
            {
              localObject = CMSAlgorithmProtection.getInstance(localObject.getAttributeValues()[0]);
              if (CMSUtils.isEquivalent(((CMSAlgorithmProtection)localObject).getDigestAlgorithm(), localAuthenticatedData.getDigestAlgorithm()))
              {
                if (!CMSUtils.isEquivalent(((CMSAlgorithmProtection)localObject).getMacAlgorithm(), this.macAlg)) {
                  throw new CMSException("CMS Algorithm Identifier Protection check failed for macAlgorithm");
                }
              }
              else {
                throw new CMSException("CMS Algorithm Identifier Protection check failed for digestAlgorithm");
              }
            }
            else
            {
              throw new CMSException("A cmsAlgorithmProtect attribute MUST contain exactly one value");
            }
          }
          try
          {
            paramDigestCalculatorProvider = new CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable(paramDigestCalculatorProvider.get(localAuthenticatedData.getDigestAlgorithm()), localCMSProcessableByteArray);
            this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(paramContentInfo, this.macAlg, paramDigestCalculatorProvider, new AuthAttributesProvider()
            {
              public ASN1Set getAuthAttributes()
              {
                return CMSAuthenticatedData.this.authAttrs;
              }
            });
            return;
          }
          catch (OperatorCreationException paramContentInfo)
          {
            paramDigestCalculatorProvider = new StringBuilder();
            paramDigestCalculatorProvider.append("unable to create digest calculator: ");
            paramDigestCalculatorProvider.append(paramContentInfo.getMessage());
            throw new CMSException(paramDigestCalculatorProvider.toString(), paramContentInfo);
          }
        }
        throw new CMSException("Only one instance of a cmsAlgorithmProtect attribute can be present");
      }
      throw new CMSException("a digest calculator provider is required if authenticated attributes are present");
    }
    paramDigestCalculatorProvider = new CMSEnvelopedHelper.CMSAuthenticatedSecureReadable(this.macAlg, localCMSProcessableByteArray);
    this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(paramContentInfo, this.macAlg, paramDigestCalculatorProvider);
  }
  
  public CMSAuthenticatedData(byte[] paramArrayOfByte)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramArrayOfByte));
  }
  
  public CMSAuthenticatedData(byte[] paramArrayOfByte, DigestCalculatorProvider paramDigestCalculatorProvider)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramArrayOfByte), paramDigestCalculatorProvider);
  }
  
  private byte[] encodeObj(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    if (paramASN1Encodable != null) {
      return paramASN1Encodable.toASN1Primitive().getEncoded();
    }
    return null;
  }
  
  public AttributeTable getAuthAttrs()
  {
    ASN1Set localASN1Set = this.authAttrs;
    if (localASN1Set == null) {
      return null;
    }
    return new AttributeTable(localASN1Set);
  }
  
  public byte[] getContentDigest()
  {
    if (this.authAttrs != null) {
      return ASN1OctetString.getInstance(getAuthAttrs().get(CMSAttributes.messageDigest).getAttrValues().getObjectAt(0)).getOctets();
    }
    return null;
  }
  
  public ContentInfo getContentInfo()
  {
    return this.contentInfo;
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.contentInfo.getEncoded();
  }
  
  public byte[] getMac()
  {
    return Arrays.clone(this.mac);
  }
  
  public String getMacAlgOID()
  {
    return this.macAlg.getAlgorithm().getId();
  }
  
  public byte[] getMacAlgParams()
  {
    try
    {
      byte[] arrayOfByte = encodeObj(this.macAlg.getParameters());
      return arrayOfByte;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception getting encryption parameters ");
      localStringBuilder.append(localException);
      throw new RuntimeException(localStringBuilder.toString());
    }
  }
  
  public AlgorithmIdentifier getMacAlgorithm()
  {
    return this.macAlg;
  }
  
  public OriginatorInformation getOriginatorInfo()
  {
    return this.originatorInfo;
  }
  
  public RecipientInformationStore getRecipientInfos()
  {
    return this.recipientInfoStore;
  }
  
  public AttributeTable getUnauthAttrs()
  {
    ASN1Set localASN1Set = this.unauthAttrs;
    if (localASN1Set == null) {
      return null;
    }
    return new AttributeTable(localASN1Set);
  }
  
  public ContentInfo toASN1Structure()
  {
    return this.contentInfo;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSAuthenticatedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */