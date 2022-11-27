package org.bouncycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Generator;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetStringParser;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1SequenceParser;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1SetParser;
import org.bouncycastle.asn1.ASN1StreamParser;
import org.bouncycastle.asn1.BERSequenceGenerator;
import org.bouncycastle.asn1.BERSetParser;
import org.bouncycastle.asn1.BERTaggedObject;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfoParser;
import org.bouncycastle.asn1.cms.SignedDataParser;
import org.bouncycastle.asn1.cms.SignerInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.io.Streams;

public class CMSSignedDataParser
  extends CMSContentInfoParser
{
  private static final CMSSignedHelper HELPER = CMSSignedHelper.INSTANCE;
  private ASN1Set _certSet;
  private ASN1Set _crlSet;
  private boolean _isCertCrlParsed;
  private CMSTypedStream _signedContent;
  private ASN1ObjectIdentifier _signedContentType;
  private SignedDataParser _signedData;
  private SignerInformationStore _signerInfoStore;
  private Set<AlgorithmIdentifier> digestAlgorithms;
  private Map digests;
  
  public CMSSignedDataParser(DigestCalculatorProvider paramDigestCalculatorProvider, InputStream paramInputStream)
    throws CMSException
  {
    this(paramDigestCalculatorProvider, null, paramInputStream);
  }
  
  public CMSSignedDataParser(DigestCalculatorProvider paramDigestCalculatorProvider, CMSTypedStream paramCMSTypedStream, InputStream paramInputStream)
    throws CMSException
  {
    super(paramInputStream);
    for (;;)
    {
      try
      {
        this._signedContent = paramCMSTypedStream;
        this._signedData = SignedDataParser.getInstance(this._contentInfo.getContent(16));
        this.digests = new HashMap();
        paramInputStream = this._signedData.getDigestAlgorithms();
        localHashSet = new HashSet();
        localObject = paramInputStream.readObject();
        if (localObject != null)
        {
          localObject = AlgorithmIdentifier.getInstance(localObject);
          localHashSet.add(localObject);
        }
      }
      catch (IOException paramDigestCalculatorProvider)
      {
        HashSet localHashSet;
        Object localObject;
        DigestCalculator localDigestCalculator;
        paramCMSTypedStream = new StringBuilder();
        paramCMSTypedStream.append("io exception: ");
        paramCMSTypedStream.append(paramDigestCalculatorProvider.getMessage());
        throw new CMSException(paramCMSTypedStream.toString(), paramDigestCalculatorProvider);
      }
      try
      {
        localDigestCalculator = paramDigestCalculatorProvider.get((AlgorithmIdentifier)localObject);
        if (localDigestCalculator == null) {
          continue;
        }
        this.digests.put(((AlgorithmIdentifier)localObject).getAlgorithm(), localDigestCalculator);
      }
      catch (OperatorCreationException localOperatorCreationException) {}
      this.digestAlgorithms = Collections.unmodifiableSet(localHashSet);
      paramInputStream = this._signedData.getEncapContentInfo();
      paramDigestCalculatorProvider = paramInputStream.getContent(4);
      if ((paramDigestCalculatorProvider instanceof ASN1OctetStringParser))
      {
        paramDigestCalculatorProvider = (ASN1OctetStringParser)paramDigestCalculatorProvider;
        paramDigestCalculatorProvider = new CMSTypedStream(paramInputStream.getContentType(), paramDigestCalculatorProvider.getOctetStream());
        if (this._signedContent == null) {
          this._signedContent = paramDigestCalculatorProvider;
        } else {
          paramDigestCalculatorProvider.drain();
        }
      }
      else if (paramDigestCalculatorProvider != null)
      {
        paramDigestCalculatorProvider = new PKCS7TypedStream(paramInputStream.getContentType(), paramDigestCalculatorProvider);
        if (this._signedContent == null) {
          continue;
        }
        paramDigestCalculatorProvider.drain();
      }
      if (paramCMSTypedStream == null)
      {
        paramDigestCalculatorProvider = paramInputStream.getContentType();
        this._signedContentType = paramDigestCalculatorProvider;
        return;
      }
      paramDigestCalculatorProvider = this._signedContent.getContentType();
    }
  }
  
  public CMSSignedDataParser(DigestCalculatorProvider paramDigestCalculatorProvider, CMSTypedStream paramCMSTypedStream, byte[] paramArrayOfByte)
    throws CMSException
  {
    this(paramDigestCalculatorProvider, paramCMSTypedStream, new ByteArrayInputStream(paramArrayOfByte));
  }
  
  public CMSSignedDataParser(DigestCalculatorProvider paramDigestCalculatorProvider, byte[] paramArrayOfByte)
    throws CMSException
  {
    this(paramDigestCalculatorProvider, new ByteArrayInputStream(paramArrayOfByte));
  }
  
  private static ASN1Set getASN1Set(ASN1SetParser paramASN1SetParser)
  {
    if (paramASN1SetParser == null) {
      return null;
    }
    return ASN1Set.getInstance(paramASN1SetParser.toASN1Primitive());
  }
  
  private static void pipeEncapsulatedOctetString(ContentInfoParser paramContentInfoParser, OutputStream paramOutputStream)
    throws IOException
  {
    paramContentInfoParser = (ASN1OctetStringParser)paramContentInfoParser.getContent(4);
    if (paramContentInfoParser != null) {
      pipeOctetString(paramContentInfoParser, paramOutputStream);
    }
  }
  
  private static void pipeOctetString(ASN1OctetStringParser paramASN1OctetStringParser, OutputStream paramOutputStream)
    throws IOException
  {
    paramOutputStream = CMSUtils.createBEROctetOutputStream(paramOutputStream, 0, true, 0);
    Streams.pipeAll(paramASN1OctetStringParser.getOctetStream(), paramOutputStream);
    paramOutputStream.close();
  }
  
  private void populateCertCrlSets()
    throws CMSException
  {
    if (this._isCertCrlParsed) {
      return;
    }
    this._isCertCrlParsed = true;
    try
    {
      this._certSet = getASN1Set(this._signedData.getCertificates());
      this._crlSet = getASN1Set(this._signedData.getCrls());
      return;
    }
    catch (IOException localIOException)
    {
      throw new CMSException("problem parsing cert/crl sets", localIOException);
    }
  }
  
  public static OutputStream replaceCertificatesAndCRLs(InputStream paramInputStream, Store paramStore1, Store paramStore2, Store paramStore3, OutputStream paramOutputStream)
    throws CMSException, IOException
  {
    paramInputStream = SignedDataParser.getInstance(new ContentInfoParser((ASN1SequenceParser)new ASN1StreamParser(paramInputStream).readObject()).getContent(16));
    BERSequenceGenerator localBERSequenceGenerator1 = new BERSequenceGenerator(paramOutputStream);
    localBERSequenceGenerator1.addObject(CMSObjectIdentifiers.signedData);
    BERSequenceGenerator localBERSequenceGenerator2 = new BERSequenceGenerator(localBERSequenceGenerator1.getRawOutputStream(), 0, true);
    localBERSequenceGenerator2.addObject(paramInputStream.getVersion());
    localBERSequenceGenerator2.getRawOutputStream().write(paramInputStream.getDigestAlgorithms().toASN1Primitive().getEncoded());
    Object localObject = paramInputStream.getEncapContentInfo();
    BERSequenceGenerator localBERSequenceGenerator3 = new BERSequenceGenerator(localBERSequenceGenerator2.getRawOutputStream());
    localBERSequenceGenerator3.addObject(((ContentInfoParser)localObject).getContentType());
    pipeEncapsulatedOctetString((ContentInfoParser)localObject, localBERSequenceGenerator3.getRawOutputStream());
    localBERSequenceGenerator3.close();
    getASN1Set(paramInputStream.getCertificates());
    getASN1Set(paramInputStream.getCrls());
    if ((paramStore1 != null) || (paramStore3 != null))
    {
      localObject = new ArrayList();
      if (paramStore1 != null) {
        ((List)localObject).addAll(CMSUtils.getCertificatesFromStore(paramStore1));
      }
      if (paramStore3 != null) {
        ((List)localObject).addAll(CMSUtils.getAttributeCertificatesFromStore(paramStore3));
      }
      paramStore1 = CMSUtils.createBerSetFromList((List)localObject);
      if (paramStore1.size() > 0) {
        localBERSequenceGenerator2.getRawOutputStream().write(new DERTaggedObject(false, 0, paramStore1).getEncoded());
      }
    }
    if (paramStore2 != null)
    {
      paramStore1 = CMSUtils.createBerSetFromList(CMSUtils.getCRLsFromStore(paramStore2));
      if (paramStore1.size() > 0) {
        localBERSequenceGenerator2.getRawOutputStream().write(new DERTaggedObject(false, 1, paramStore1).getEncoded());
      }
    }
    localBERSequenceGenerator2.getRawOutputStream().write(paramInputStream.getSignerInfos().toASN1Primitive().getEncoded());
    localBERSequenceGenerator2.close();
    localBERSequenceGenerator1.close();
    return paramOutputStream;
  }
  
  public static OutputStream replaceSigners(InputStream paramInputStream, SignerInformationStore paramSignerInformationStore, OutputStream paramOutputStream)
    throws CMSException, IOException
  {
    Object localObject1 = SignedDataParser.getInstance(new ContentInfoParser((ASN1SequenceParser)new ASN1StreamParser(paramInputStream).readObject()).getContent(16));
    paramInputStream = new BERSequenceGenerator(paramOutputStream);
    paramInputStream.addObject(CMSObjectIdentifiers.signedData);
    BERSequenceGenerator localBERSequenceGenerator = new BERSequenceGenerator(paramInputStream.getRawOutputStream(), 0, true);
    localBERSequenceGenerator.addObject(((SignedDataParser)localObject1).getVersion());
    ((SignedDataParser)localObject1).getDigestAlgorithms().toASN1Primitive();
    Object localObject2 = new ASN1EncodableVector();
    Object localObject3 = paramSignerInformationStore.getSigners().iterator();
    while (((Iterator)localObject3).hasNext())
    {
      SignerInformation localSignerInformation = (SignerInformation)((Iterator)localObject3).next();
      ((ASN1EncodableVector)localObject2).add(CMSSignedHelper.INSTANCE.fixAlgID(localSignerInformation.getDigestAlgorithmID()));
    }
    localBERSequenceGenerator.getRawOutputStream().write(new DERSet((ASN1EncodableVector)localObject2).getEncoded());
    localObject2 = ((SignedDataParser)localObject1).getEncapContentInfo();
    localObject3 = new BERSequenceGenerator(localBERSequenceGenerator.getRawOutputStream());
    ((BERSequenceGenerator)localObject3).addObject(((ContentInfoParser)localObject2).getContentType());
    pipeEncapsulatedOctetString((ContentInfoParser)localObject2, ((BERSequenceGenerator)localObject3).getRawOutputStream());
    ((BERSequenceGenerator)localObject3).close();
    writeSetToGeneratorTagged(localBERSequenceGenerator, ((SignedDataParser)localObject1).getCertificates(), 0);
    writeSetToGeneratorTagged(localBERSequenceGenerator, ((SignedDataParser)localObject1).getCrls(), 1);
    localObject1 = new ASN1EncodableVector();
    paramSignerInformationStore = paramSignerInformationStore.getSigners().iterator();
    while (paramSignerInformationStore.hasNext()) {
      ((ASN1EncodableVector)localObject1).add(((SignerInformation)paramSignerInformationStore.next()).toASN1Structure());
    }
    localBERSequenceGenerator.getRawOutputStream().write(new DERSet((ASN1EncodableVector)localObject1).getEncoded());
    localBERSequenceGenerator.close();
    paramInputStream.close();
    return paramOutputStream;
  }
  
  private static void writeSetToGeneratorTagged(ASN1Generator paramASN1Generator, ASN1SetParser paramASN1SetParser, int paramInt)
    throws IOException
  {
    ASN1Set localASN1Set = getASN1Set(paramASN1SetParser);
    if (localASN1Set != null)
    {
      boolean bool = paramASN1SetParser instanceof BERSetParser;
      paramASN1Generator = paramASN1Generator.getRawOutputStream();
      if (bool)
      {
        paramASN1Generator.write(new BERTaggedObject(false, paramInt, localASN1Set).getEncoded());
        return;
      }
      paramASN1Generator.write(new DERTaggedObject(false, paramInt, localASN1Set).getEncoded());
    }
  }
  
  public Store getAttributeCertificates()
    throws CMSException
  {
    populateCertCrlSets();
    return HELPER.getAttributeCertificates(this._certSet);
  }
  
  public Store getCRLs()
    throws CMSException
  {
    populateCertCrlSets();
    return HELPER.getCRLs(this._crlSet);
  }
  
  public Store getCertificates()
    throws CMSException
  {
    populateCertCrlSets();
    return HELPER.getCertificates(this._certSet);
  }
  
  public Set<AlgorithmIdentifier> getDigestAlgorithmIDs()
  {
    return this.digestAlgorithms;
  }
  
  public Store getOtherRevocationInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
    throws CMSException
  {
    populateCertCrlSets();
    return HELPER.getOtherRevocationInfo(paramASN1ObjectIdentifier, this._crlSet);
  }
  
  public CMSTypedStream getSignedContent()
  {
    if (this._signedContent == null) {
      return null;
    }
    InputStream localInputStream = CMSUtils.attachDigestsToInputStream(this.digests.values(), this._signedContent.getContentStream());
    return new CMSTypedStream(this._signedContent.getContentType(), localInputStream);
  }
  
  public String getSignedContentTypeOID()
  {
    return this._signedContentType.getId();
  }
  
  public SignerInformationStore getSignerInfos()
    throws CMSException
  {
    if (this._signerInfoStore == null)
    {
      populateCertCrlSets();
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = new HashMap();
      Object localObject2 = this.digests.keySet().iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = ((Iterator)localObject2).next();
        ((Map)localObject1).put(localObject3, ((DigestCalculator)this.digests.get(localObject3)).getDigest());
      }
      try
      {
        localObject2 = this._signedData.getSignerInfos();
        for (;;)
        {
          localObject3 = ((ASN1SetParser)localObject2).readObject();
          if (localObject3 == null) {
            break;
          }
          localObject3 = SignerInfo.getInstance(((ASN1Encodable)localObject3).toASN1Primitive());
          byte[] arrayOfByte = (byte[])((Map)localObject1).get(((SignerInfo)localObject3).getDigestAlgorithm().getAlgorithm());
          localArrayList.add(new SignerInformation((SignerInfo)localObject3, this._signedContentType, null, arrayOfByte));
        }
        this._signerInfoStore = new SignerInformationStore(localArrayList);
      }
      catch (IOException localIOException)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("io exception: ");
        ((StringBuilder)localObject1).append(localIOException.getMessage());
        throw new CMSException(((StringBuilder)localObject1).toString(), localIOException);
      }
    }
    return this._signerInfoStore;
  }
  
  public int getVersion()
  {
    return this._signedData.getVersion().getValue().intValue();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSSignedDataParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */