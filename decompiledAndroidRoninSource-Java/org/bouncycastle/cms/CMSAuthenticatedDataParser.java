package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.AuthenticatedDataParser;
import org.bouncycastle.asn1.cms.CMSAttributes;
import org.bouncycastle.asn1.cms.ContentInfoParser;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Arrays;

public class CMSAuthenticatedDataParser
  extends CMSContentInfoParser
{
  private boolean authAttrNotRead = true;
  private ASN1Set authAttrSet;
  private AttributeTable authAttrs;
  AuthenticatedDataParser authData;
  private byte[] mac;
  private AlgorithmIdentifier macAlg;
  private OriginatorInformation originatorInfo;
  RecipientInformationStore recipientInfoStore;
  private boolean unauthAttrNotRead;
  private AttributeTable unauthAttrs;
  
  public CMSAuthenticatedDataParser(InputStream paramInputStream)
    throws CMSException, IOException
  {
    this(paramInputStream, null);
  }
  
  public CMSAuthenticatedDataParser(InputStream paramInputStream, DigestCalculatorProvider paramDigestCalculatorProvider)
    throws CMSException, IOException
  {
    super(paramInputStream);
    paramInputStream = new AuthenticatedDataParser((ASN1SequenceParser)this._contentInfo.getContent(16));
    this.authData = paramInputStream;
    paramInputStream = paramInputStream.getOriginatorInfo();
    if (paramInputStream != null) {
      this.originatorInfo = new OriginatorInformation(paramInputStream);
    }
    paramInputStream = ASN1Set.getInstance(this.authData.getRecipientInfos().toASN1Primitive());
    this.macAlg = this.authData.getMacAlgorithm();
    AlgorithmIdentifier localAlgorithmIdentifier = this.authData.getDigestAlgorithm();
    if (localAlgorithmIdentifier != null)
    {
      if (paramDigestCalculatorProvider != null)
      {
        CMSProcessableInputStream localCMSProcessableInputStream = new CMSProcessableInputStream(((ASN1OctetStringParser)this.authData.getEncapsulatedContentInfo().getContent(4)).getOctetStream());
        try
        {
          paramDigestCalculatorProvider = new CMSEnvelopedHelper.CMSDigestAuthenticatedSecureReadable(paramDigestCalculatorProvider.get(localAlgorithmIdentifier), localCMSProcessableInputStream);
          this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(paramInputStream, this.macAlg, paramDigestCalculatorProvider, new AuthAttributesProvider()
          {
            public ASN1Set getAuthAttributes()
            {
              try
              {
                ASN1Set localASN1Set = CMSAuthenticatedDataParser.this.getAuthAttrSet();
                return localASN1Set;
              }
              catch (IOException localIOException)
              {
                for (;;) {}
              }
              throw new IllegalStateException("can't parse authenticated attributes!");
            }
          });
          return;
        }
        catch (OperatorCreationException paramInputStream)
        {
          paramDigestCalculatorProvider = new StringBuilder();
          paramDigestCalculatorProvider.append("unable to create digest calculator: ");
          paramDigestCalculatorProvider.append(paramInputStream.getMessage());
          throw new CMSException(paramDigestCalculatorProvider.toString(), paramInputStream);
        }
      }
      throw new CMSException("a digest calculator provider is required if authenticated attributes are present");
    }
    paramDigestCalculatorProvider = new CMSProcessableInputStream(((ASN1OctetStringParser)this.authData.getEncapsulatedContentInfo().getContent(4)).getOctetStream());
    paramDigestCalculatorProvider = new CMSEnvelopedHelper.CMSAuthenticatedSecureReadable(this.macAlg, paramDigestCalculatorProvider);
    this.recipientInfoStore = CMSEnvelopedHelper.buildRecipientInformationStore(paramInputStream, this.macAlg, paramDigestCalculatorProvider);
  }
  
  public CMSAuthenticatedDataParser(byte[] paramArrayOfByte)
    throws CMSException, IOException
  {
    this(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public CMSAuthenticatedDataParser(byte[] paramArrayOfByte, DigestCalculatorProvider paramDigestCalculatorProvider)
    throws CMSException, IOException
  {
    this(new ByteArrayInputStream(paramArrayOfByte), paramDigestCalculatorProvider);
  }
  
  private byte[] encodeObj(ASN1Encodable paramASN1Encodable)
    throws IOException
  {
    if (paramASN1Encodable != null) {
      return paramASN1Encodable.toASN1Primitive().getEncoded();
    }
    return null;
  }
  
  private ASN1Set getAuthAttrSet()
    throws IOException
  {
    if ((this.authAttrs == null) && (this.authAttrNotRead))
    {
      ASN1SetParser localASN1SetParser = this.authData.getAuthAttrs();
      if (localASN1SetParser != null) {
        this.authAttrSet = ((ASN1Set)localASN1SetParser.toASN1Primitive());
      }
      this.authAttrNotRead = false;
    }
    return this.authAttrSet;
  }
  
  public AttributeTable getAuthAttrs()
    throws IOException
  {
    if ((this.authAttrs == null) && (this.authAttrNotRead))
    {
      ASN1Set localASN1Set = getAuthAttrSet();
      if (localASN1Set != null) {
        this.authAttrs = new AttributeTable(localASN1Set);
      }
    }
    return this.authAttrs;
  }
  
  public byte[] getContentDigest()
  {
    AttributeTable localAttributeTable = this.authAttrs;
    if (localAttributeTable != null) {
      return ASN1OctetString.getInstance(localAttributeTable.get(CMSAttributes.messageDigest).getAttrValues().getObjectAt(0)).getOctets();
    }
    return null;
  }
  
  public byte[] getMac()
    throws IOException
  {
    if (this.mac == null)
    {
      getAuthAttrs();
      this.mac = this.authData.getMac().getOctets();
    }
    return Arrays.clone(this.mac);
  }
  
  public String getMacAlgOID()
  {
    return this.macAlg.getAlgorithm().toString();
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
    throws IOException
  {
    if ((this.unauthAttrs == null) && (this.unauthAttrNotRead))
    {
      ASN1SetParser localASN1SetParser = this.authData.getUnauthAttrs();
      this.unauthAttrNotRead = false;
      if (localASN1SetParser != null)
      {
        ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
        for (;;)
        {
          ASN1Encodable localASN1Encodable = localASN1SetParser.readObject();
          if (localASN1Encodable == null) {
            break;
          }
          localASN1EncodableVector.add(((ASN1SequenceParser)localASN1Encodable).toASN1Primitive());
        }
        this.unauthAttrs = new AttributeTable(new DERSet(localASN1EncodableVector));
      }
    }
    return this.unauthAttrs;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSAuthenticatedDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */