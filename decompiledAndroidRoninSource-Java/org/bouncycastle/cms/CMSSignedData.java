package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.SignedData;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Encodable;
import org.bouncycastle.util.Store;

public class CMSSignedData
  implements Encodable
{
  private static final CMSSignedHelper HELPER = CMSSignedHelper.INSTANCE;
  ContentInfo contentInfo;
  private Map hashes;
  CMSTypedData signedContent;
  SignedData signedData;
  SignerInformationStore signerInfoStore;
  
  public CMSSignedData(InputStream paramInputStream)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramInputStream));
  }
  
  public CMSSignedData(Map paramMap, ContentInfo paramContentInfo)
    throws CMSException
  {
    this.hashes = paramMap;
    this.contentInfo = paramContentInfo;
    this.signedData = getSignedData();
  }
  
  public CMSSignedData(Map paramMap, byte[] paramArrayOfByte)
    throws CMSException
  {
    this(paramMap, CMSUtils.readContentInfo(paramArrayOfByte));
  }
  
  public CMSSignedData(ContentInfo paramContentInfo)
    throws CMSException
  {
    this.contentInfo = paramContentInfo;
    paramContentInfo = getSignedData();
    this.signedData = paramContentInfo;
    paramContentInfo = paramContentInfo.getEncapContentInfo().getContent();
    if (paramContentInfo != null)
    {
      if ((paramContentInfo instanceof ASN1OctetString)) {
        paramContentInfo = new CMSProcessableByteArray(this.signedData.getEncapContentInfo().getContentType(), ((ASN1OctetString)paramContentInfo).getOctets());
      } else {
        paramContentInfo = new PKCS7ProcessableObject(this.signedData.getEncapContentInfo().getContentType(), paramContentInfo);
      }
      this.signedContent = paramContentInfo;
      return;
    }
    this.signedContent = null;
  }
  
  public CMSSignedData(CMSProcessable paramCMSProcessable, InputStream paramInputStream)
    throws CMSException
  {
    this(paramCMSProcessable, CMSUtils.readContentInfo(new ASN1InputStream(paramInputStream)));
  }
  
  public CMSSignedData(final CMSProcessable paramCMSProcessable, ContentInfo paramContentInfo)
    throws CMSException
  {
    if ((paramCMSProcessable instanceof CMSTypedData)) {
      this.signedContent = ((CMSTypedData)paramCMSProcessable);
    } else {
      this.signedContent = new CMSTypedData()
      {
        public Object getContent()
        {
          return paramCMSProcessable.getContent();
        }
        
        public ASN1ObjectIdentifier getContentType()
        {
          return CMSSignedData.this.signedData.getEncapContentInfo().getContentType();
        }
        
        public void write(OutputStream paramAnonymousOutputStream)
          throws IOException, CMSException
        {
          paramCMSProcessable.write(paramAnonymousOutputStream);
        }
      };
    }
    this.contentInfo = paramContentInfo;
    this.signedData = getSignedData();
  }
  
  public CMSSignedData(CMSProcessable paramCMSProcessable, byte[] paramArrayOfByte)
    throws CMSException
  {
    this(paramCMSProcessable, CMSUtils.readContentInfo(paramArrayOfByte));
  }
  
  private CMSSignedData(CMSSignedData paramCMSSignedData)
  {
    this.signedData = paramCMSSignedData.signedData;
    this.contentInfo = paramCMSSignedData.contentInfo;
    this.signedContent = paramCMSSignedData.signedContent;
    this.signerInfoStore = paramCMSSignedData.signerInfoStore;
  }
  
  public CMSSignedData(byte[] paramArrayOfByte)
    throws CMSException
  {
    this(CMSUtils.readContentInfo(paramArrayOfByte));
  }
  
  private SignedData getSignedData()
    throws CMSException
  {
    try
    {
      SignedData localSignedData = SignedData.getInstance(this.contentInfo.getContent());
      return localSignedData;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      throw new CMSException("Malformed content.", localIllegalArgumentException);
    }
    catch (ClassCastException localClassCastException)
    {
      throw new CMSException("Malformed content.", localClassCastException);
    }
  }
  
  public static CMSSignedData replaceCertificatesAndCRLs(CMSSignedData paramCMSSignedData, Store paramStore1, Store paramStore2, Store paramStore3)
    throws CMSException
  {
    CMSSignedData localCMSSignedData = new CMSSignedData(paramCMSSignedData);
    if ((paramStore1 != null) || (paramStore2 != null))
    {
      ArrayList localArrayList = new ArrayList();
      if (paramStore1 != null) {
        localArrayList.addAll(CMSUtils.getCertificatesFromStore(paramStore1));
      }
      if (paramStore2 != null) {
        localArrayList.addAll(CMSUtils.getAttributeCertificatesFromStore(paramStore2));
      }
      paramStore1 = CMSUtils.createBerSetFromList(localArrayList);
      if (paramStore1.size() != 0) {}
    }
    else
    {
      paramStore1 = null;
    }
    if (paramStore3 != null)
    {
      paramStore2 = CMSUtils.createBerSetFromList(CMSUtils.getCRLsFromStore(paramStore3));
      if (paramStore2.size() != 0) {}
    }
    else
    {
      paramStore2 = null;
    }
    localCMSSignedData.signedData = new SignedData(paramCMSSignedData.signedData.getDigestAlgorithms(), paramCMSSignedData.signedData.getEncapContentInfo(), paramStore1, paramStore2, paramCMSSignedData.signedData.getSignerInfos());
    localCMSSignedData.contentInfo = new ContentInfo(localCMSSignedData.contentInfo.getContentType(), localCMSSignedData.signedData);
    return localCMSSignedData;
  }
  
  public static CMSSignedData replaceSigners(CMSSignedData paramCMSSignedData, SignerInformationStore paramSignerInformationStore)
  {
    CMSSignedData localCMSSignedData = new CMSSignedData(paramCMSSignedData);
    localCMSSignedData.signerInfoStore = paramSignerInformationStore;
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    Object localObject = new ASN1EncodableVector();
    paramSignerInformationStore = paramSignerInformationStore.getSigners().iterator();
    while (paramSignerInformationStore.hasNext())
    {
      SignerInformation localSignerInformation = (SignerInformation)paramSignerInformationStore.next();
      localASN1EncodableVector.add(CMSSignedHelper.INSTANCE.fixAlgID(localSignerInformation.getDigestAlgorithmID()));
      ((ASN1EncodableVector)localObject).add(localSignerInformation.toASN1Structure());
    }
    paramSignerInformationStore = new DERSet(localASN1EncodableVector);
    localObject = new DERSet((ASN1EncodableVector)localObject);
    paramCMSSignedData = (ASN1Sequence)paramCMSSignedData.signedData.toASN1Primitive();
    localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(paramCMSSignedData.getObjectAt(0));
    localASN1EncodableVector.add(paramSignerInformationStore);
    int i = 2;
    while (i != paramCMSSignedData.size() - 1)
    {
      localASN1EncodableVector.add(paramCMSSignedData.getObjectAt(i));
      i += 1;
    }
    localASN1EncodableVector.add((ASN1Encodable)localObject);
    localCMSSignedData.signedData = SignedData.getInstance(new BERSequence(localASN1EncodableVector));
    localCMSSignedData.contentInfo = new ContentInfo(localCMSSignedData.contentInfo.getContentType(), localCMSSignedData.signedData);
    return localCMSSignedData;
  }
  
  private boolean verifyCounterSignature(SignerInformation paramSignerInformation, SignerInformationVerifierProvider paramSignerInformationVerifierProvider)
    throws OperatorCreationException, CMSException
  {
    if (!paramSignerInformation.verify(paramSignerInformationVerifierProvider.get(paramSignerInformation.getSID()))) {
      return false;
    }
    paramSignerInformation = paramSignerInformation.getCounterSignatures().getSigners().iterator();
    while (paramSignerInformation.hasNext()) {
      if (!verifyCounterSignature((SignerInformation)paramSignerInformation.next(), paramSignerInformationVerifierProvider)) {
        return false;
      }
    }
    return true;
  }
  
  public Store<X509AttributeCertificateHolder> getAttributeCertificates()
  {
    return HELPER.getAttributeCertificates(this.signedData.getCertificates());
  }
  
  public Store<X509CRLHolder> getCRLs()
  {
    return HELPER.getCRLs(this.signedData.getCRLs());
  }
  
  public Store<X509CertificateHolder> getCertificates()
  {
    return HELPER.getCertificates(this.signedData.getCertificates());
  }
  
  public Set<AlgorithmIdentifier> getDigestAlgorithmIDs()
  {
    HashSet localHashSet = new HashSet(this.signedData.getDigestAlgorithms().size());
    Enumeration localEnumeration = this.signedData.getDigestAlgorithms().getObjects();
    while (localEnumeration.hasMoreElements()) {
      localHashSet.add(AlgorithmIdentifier.getInstance(localEnumeration.nextElement()));
    }
    return Collections.unmodifiableSet(localHashSet);
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.contentInfo.getEncoded();
  }
  
  public Store getOtherRevocationInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    return HELPER.getOtherRevocationInfo(paramASN1ObjectIdentifier, this.signedData.getCRLs());
  }
  
  public CMSTypedData getSignedContent()
  {
    return this.signedContent;
  }
  
  public String getSignedContentTypeOID()
  {
    return this.signedData.getEncapContentInfo().getContentType().getId();
  }
  
  public SignerInformationStore getSignerInfos()
  {
    if (this.signerInfoStore == null)
    {
      ASN1Set localASN1Set = this.signedData.getSignerInfos();
      ArrayList localArrayList = new ArrayList();
      int i = 0;
      while (i != localASN1Set.size())
      {
        SignerInfo localSignerInfo = SignerInfo.getInstance(localASN1Set.getObjectAt(i));
        ASN1ObjectIdentifier localASN1ObjectIdentifier = this.signedData.getEncapContentInfo().getContentType();
        Map localMap = this.hashes;
        if (localMap == null)
        {
          localArrayList.add(new SignerInformation(localSignerInfo, localASN1ObjectIdentifier, this.signedContent, null));
        }
        else
        {
          Object localObject;
          if ((localMap.keySet().iterator().next() instanceof String))
          {
            localMap = this.hashes;
            localObject = localSignerInfo.getDigestAlgorithm().getAlgorithm().getId();
          }
          else
          {
            localMap = this.hashes;
            localObject = localSignerInfo.getDigestAlgorithm().getAlgorithm();
          }
          localArrayList.add(new SignerInformation(localSignerInfo, localASN1ObjectIdentifier, null, (byte[])localMap.get(localObject)));
        }
        i += 1;
      }
      this.signerInfoStore = new SignerInformationStore(localArrayList);
    }
    return this.signerInfoStore;
  }
  
  public int getVersion()
  {
    return this.signedData.getVersion().getValue().intValue();
  }
  
  public boolean isCertificateManagementMessage()
  {
    return (this.signedData.getEncapContentInfo().getContent() == null) && (this.signedData.getSignerInfos().size() == 0);
  }
  
  public boolean isDetachedSignature()
  {
    return (this.signedData.getEncapContentInfo().getContent() == null) && (this.signedData.getSignerInfos().size() > 0);
  }
  
  public ContentInfo toASN1Structure()
  {
    return this.contentInfo;
  }
  
  public boolean verifySignatures(SignerInformationVerifierProvider paramSignerInformationVerifierProvider)
    throws CMSException
  {
    return verifySignatures(paramSignerInformationVerifierProvider, false);
  }
  
  public boolean verifySignatures(SignerInformationVerifierProvider paramSignerInformationVerifierProvider, boolean paramBoolean)
    throws CMSException
  {
    Object localObject1 = getSignerInfos().getSigners().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (SignerInformation)((Iterator)localObject1).next();
      try
      {
        if (!((SignerInformation)localObject2).verify(paramSignerInformationVerifierProvider.get(((SignerInformation)localObject2).getSID()))) {
          return false;
        }
        if (!paramBoolean)
        {
          localObject2 = ((SignerInformation)localObject2).getCounterSignatures().getSigners().iterator();
          boolean bool;
          do
          {
            if (!((Iterator)localObject2).hasNext()) {
              break;
            }
            bool = verifyCounterSignature((SignerInformation)((Iterator)localObject2).next(), paramSignerInformationVerifierProvider);
          } while (bool);
          return false;
        }
      }
      catch (OperatorCreationException paramSignerInformationVerifierProvider)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("failure in verifier provider: ");
        ((StringBuilder)localObject1).append(paramSignerInformationVerifierProvider.getMessage());
        throw new CMSException(((StringBuilder)localObject1).toString(), paramSignerInformationVerifierProvider);
      }
    }
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSSignedData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */