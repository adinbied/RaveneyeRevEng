package org.bouncycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.BEROctetStringGenerator;
import org.bouncycastle.asn1.BERSet;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cms.OtherRevocationInfoFormat;
import org.bouncycastle.asn1.ocsp.OCSPResponse;
import org.bouncycastle.asn1.ocsp.OCSPResponseStatus;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.io.Streams;
import org.bouncycastle.util.io.TeeInputStream;
import org.bouncycastle.util.io.TeeOutputStream;

class CMSUtils
{
  private static final Set<String> des;
  
  static
  {
    HashSet localHashSet = new HashSet();
    des = localHashSet;
    localHashSet.add("DES");
    des.add("DESEDE");
    des.add(OIWObjectIdentifiers.desCBC.getId());
    des.add(PKCSObjectIdentifiers.des_EDE3_CBC.getId());
    des.add(PKCSObjectIdentifiers.des_EDE3_CBC.getId());
    des.add(PKCSObjectIdentifiers.id_alg_CMS3DESwrap.getId());
  }
  
  static InputStream attachDigestsToInputStream(Collection paramCollection, InputStream paramInputStream)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      paramInputStream = new TeeInputStream(paramInputStream, ((DigestCalculator)paramCollection.next()).getOutputStream());
    }
    return paramInputStream;
  }
  
  static OutputStream attachSignersToOutputStream(Collection paramCollection, OutputStream paramOutputStream)
  {
    paramCollection = paramCollection.iterator();
    while (paramCollection.hasNext()) {
      paramOutputStream = getSafeTeeOutputStream(paramOutputStream, ((SignerInfoGenerator)paramCollection.next()).getCalculatingOutputStream());
    }
    return paramOutputStream;
  }
  
  static OutputStream createBEROctetOutputStream(OutputStream paramOutputStream, int paramInt1, boolean paramBoolean, int paramInt2)
    throws IOException
  {
    paramOutputStream = new BEROctetStringGenerator(paramOutputStream, paramInt1, paramBoolean);
    if (paramInt2 != 0) {
      return paramOutputStream.getOctetOutputStream(new byte[paramInt2]);
    }
    return paramOutputStream.getOctetOutputStream();
  }
  
  static ASN1Set createBerSetFromList(List paramList)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localASN1EncodableVector.add((ASN1Encodable)paramList.next());
    }
    return new BERSet(localASN1EncodableVector);
  }
  
  static ASN1Set createDerSetFromList(List paramList)
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localASN1EncodableVector.add((ASN1Encodable)paramList.next());
    }
    return new DERSet(localASN1EncodableVector);
  }
  
  static List getAttributeCertificatesFromStore(Store paramStore)
    throws CMSException
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramStore = paramStore.getMatches(null).iterator();
      while (paramStore.hasNext()) {
        localArrayList.add(new DERTaggedObject(false, 2, ((X509AttributeCertificateHolder)paramStore.next()).toASN1Structure()));
      }
      return localArrayList;
    }
    catch (ClassCastException paramStore)
    {
      throw new CMSException("error processing certs", paramStore);
    }
  }
  
  static List getCRLsFromStore(Store paramStore)
    throws CMSException
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      Iterator localIterator = paramStore.getMatches(null).iterator();
      if (localIterator.hasNext())
      {
        paramStore = localIterator.next();
        if ((paramStore instanceof X509CRLHolder)) {
          paramStore = ((X509CRLHolder)paramStore).toASN1Structure();
        }
        for (;;)
        {
          localArrayList.add(paramStore);
          break;
          if ((paramStore instanceof OtherRevocationInfoFormat))
          {
            paramStore = OtherRevocationInfoFormat.getInstance(paramStore);
            validateInfoFormat(paramStore);
            localArrayList.add(new DERTaggedObject(false, 1, paramStore));
            break;
          }
          boolean bool = paramStore instanceof ASN1TaggedObject;
          if (!bool) {
            break;
          }
        }
      }
      return localArrayList;
    }
    catch (ClassCastException paramStore)
    {
      throw new CMSException("error processing certs", paramStore);
    }
  }
  
  static List getCertificatesFromStore(Store paramStore)
    throws CMSException
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramStore = paramStore.getMatches(null).iterator();
      while (paramStore.hasNext()) {
        localArrayList.add(((X509CertificateHolder)paramStore.next()).toASN1Structure());
      }
      return localArrayList;
    }
    catch (ClassCastException paramStore)
    {
      throw new CMSException("error processing certs", paramStore);
    }
  }
  
  static Collection getOthersFromStore(ASN1ObjectIdentifier paramASN1ObjectIdentifier, Store paramStore)
  {
    ArrayList localArrayList = new ArrayList();
    paramStore = paramStore.getMatches(null).iterator();
    while (paramStore.hasNext())
    {
      OtherRevocationInfoFormat localOtherRevocationInfoFormat = new OtherRevocationInfoFormat(paramASN1ObjectIdentifier, (ASN1Encodable)paramStore.next());
      validateInfoFormat(localOtherRevocationInfoFormat);
      localArrayList.add(new DERTaggedObject(false, 1, localOtherRevocationInfoFormat));
    }
    return localArrayList;
  }
  
  static OutputStream getSafeOutputStream(OutputStream paramOutputStream)
  {
    Object localObject = paramOutputStream;
    if (paramOutputStream == null) {
      localObject = new NullOutputStream();
    }
    return (OutputStream)localObject;
  }
  
  static OutputStream getSafeTeeOutputStream(OutputStream paramOutputStream1, OutputStream paramOutputStream2)
  {
    if (paramOutputStream1 == null) {
      return getSafeOutputStream(paramOutputStream2);
    }
    if (paramOutputStream2 == null) {
      return getSafeOutputStream(paramOutputStream1);
    }
    return new TeeOutputStream(paramOutputStream1, paramOutputStream2);
  }
  
  static boolean isDES(String paramString)
  {
    paramString = Strings.toUpperCase(paramString);
    return des.contains(paramString);
  }
  
  static boolean isEquivalent(AlgorithmIdentifier paramAlgorithmIdentifier1, AlgorithmIdentifier paramAlgorithmIdentifier2)
  {
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (paramAlgorithmIdentifier1 != null)
    {
      if (paramAlgorithmIdentifier2 == null) {
        return false;
      }
      if (!paramAlgorithmIdentifier1.getAlgorithm().equals(paramAlgorithmIdentifier2.getAlgorithm())) {
        return false;
      }
      paramAlgorithmIdentifier1 = paramAlgorithmIdentifier1.getParameters();
      paramAlgorithmIdentifier2 = paramAlgorithmIdentifier2.getParameters();
      if (paramAlgorithmIdentifier1 != null)
      {
        if (!paramAlgorithmIdentifier1.equals(paramAlgorithmIdentifier2))
        {
          bool1 = bool2;
          if (paramAlgorithmIdentifier1.equals(DERNull.INSTANCE))
          {
            bool1 = bool2;
            if (paramAlgorithmIdentifier2 != null) {}
          }
        }
        else
        {
          bool1 = true;
        }
        return bool1;
      }
      if (paramAlgorithmIdentifier2 != null)
      {
        bool1 = bool3;
        if (!paramAlgorithmIdentifier2.equals(DERNull.INSTANCE)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  static ContentInfo readContentInfo(InputStream paramInputStream)
    throws CMSException
  {
    return readContentInfo(new ASN1InputStream(paramInputStream));
  }
  
  private static ContentInfo readContentInfo(ASN1InputStream paramASN1InputStream)
    throws CMSException
  {
    try
    {
      paramASN1InputStream = ContentInfo.getInstance(paramASN1InputStream.readObject());
      if (paramASN1InputStream != null) {
        return paramASN1InputStream;
      }
      throw new CMSException("No content found.");
    }
    catch (IllegalArgumentException paramASN1InputStream)
    {
      throw new CMSException("Malformed content.", paramASN1InputStream);
    }
    catch (ClassCastException paramASN1InputStream)
    {
      throw new CMSException("Malformed content.", paramASN1InputStream);
    }
    catch (IOException paramASN1InputStream)
    {
      throw new CMSException("IOException reading content.", paramASN1InputStream);
    }
  }
  
  static ContentInfo readContentInfo(byte[] paramArrayOfByte)
    throws CMSException
  {
    return readContentInfo(new ASN1InputStream(paramArrayOfByte));
  }
  
  public static byte[] streamToByteArray(InputStream paramInputStream)
    throws IOException
  {
    return Streams.readAll(paramInputStream);
  }
  
  public static byte[] streamToByteArray(InputStream paramInputStream, int paramInt)
    throws IOException
  {
    return Streams.readAllLimited(paramInputStream, paramInt);
  }
  
  private static void validateInfoFormat(OtherRevocationInfoFormat paramOtherRevocationInfoFormat)
  {
    if (CMSObjectIdentifiers.id_ri_ocsp_response.equals(paramOtherRevocationInfoFormat.getInfoFormat()))
    {
      if (OCSPResponse.getInstance(paramOtherRevocationInfoFormat.getInfo()).getResponseStatus().getValue().intValue() == 0) {
        return;
      }
      throw new IllegalArgumentException("cannot add unsuccessful OCSP response to CMS SignedData");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */