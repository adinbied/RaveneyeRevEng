package org.bouncycastle.tsp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.cms.ContentInfo;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.asn1.x509.ExtendedKeyUsage;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.asn1.x509.KeyPurposeId;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cms.SignerInformation;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Integers;

public class TSPUtil
{
  private static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
  private static final Map digestLengths = new HashMap();
  private static final Map digestNames = new HashMap();
  
  static
  {
    digestLengths.put(PKCSObjectIdentifiers.md5.getId(), Integers.valueOf(16));
    digestLengths.put(OIWObjectIdentifiers.idSHA1.getId(), Integers.valueOf(20));
    digestLengths.put(NISTObjectIdentifiers.id_sha224.getId(), Integers.valueOf(28));
    digestLengths.put(NISTObjectIdentifiers.id_sha256.getId(), Integers.valueOf(32));
    digestLengths.put(NISTObjectIdentifiers.id_sha384.getId(), Integers.valueOf(48));
    digestLengths.put(NISTObjectIdentifiers.id_sha512.getId(), Integers.valueOf(64));
    digestLengths.put(TeleTrusTObjectIdentifiers.ripemd128.getId(), Integers.valueOf(16));
    digestLengths.put(TeleTrusTObjectIdentifiers.ripemd160.getId(), Integers.valueOf(20));
    digestLengths.put(TeleTrusTObjectIdentifiers.ripemd256.getId(), Integers.valueOf(32));
    digestLengths.put(CryptoProObjectIdentifiers.gostR3411.getId(), Integers.valueOf(32));
    digestNames.put(PKCSObjectIdentifiers.md5.getId(), "MD5");
    digestNames.put(OIWObjectIdentifiers.idSHA1.getId(), "SHA1");
    digestNames.put(NISTObjectIdentifiers.id_sha224.getId(), "SHA224");
    digestNames.put(NISTObjectIdentifiers.id_sha256.getId(), "SHA256");
    digestNames.put(NISTObjectIdentifiers.id_sha384.getId(), "SHA384");
    digestNames.put(NISTObjectIdentifiers.id_sha512.getId(), "SHA512");
    digestNames.put(PKCSObjectIdentifiers.sha1WithRSAEncryption.getId(), "SHA1");
    digestNames.put(PKCSObjectIdentifiers.sha224WithRSAEncryption.getId(), "SHA224");
    digestNames.put(PKCSObjectIdentifiers.sha256WithRSAEncryption.getId(), "SHA256");
    digestNames.put(PKCSObjectIdentifiers.sha384WithRSAEncryption.getId(), "SHA384");
    digestNames.put(PKCSObjectIdentifiers.sha512WithRSAEncryption.getId(), "SHA512");
    digestNames.put(TeleTrusTObjectIdentifiers.ripemd128.getId(), "RIPEMD128");
    digestNames.put(TeleTrusTObjectIdentifiers.ripemd160.getId(), "RIPEMD160");
    digestNames.put(TeleTrusTObjectIdentifiers.ripemd256.getId(), "RIPEMD256");
    digestNames.put(CryptoProObjectIdentifiers.gostR3411.getId(), "GOST3411");
  }
  
  static void addExtension(ExtensionsGenerator paramExtensionsGenerator, ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
    throws TSPIOException
  {
    try
    {
      paramExtensionsGenerator.addExtension(paramASN1ObjectIdentifier, paramBoolean, paramASN1Encodable);
      return;
    }
    catch (IOException paramExtensionsGenerator)
    {
      paramASN1ObjectIdentifier = new StringBuilder();
      paramASN1ObjectIdentifier.append("cannot encode extension: ");
      paramASN1ObjectIdentifier.append(paramExtensionsGenerator.getMessage());
      throw new TSPIOException(paramASN1ObjectIdentifier.toString(), paramExtensionsGenerator);
    }
  }
  
  static int getDigestLength(String paramString)
    throws TSPException
  {
    paramString = (Integer)digestLengths.get(paramString);
    if (paramString != null) {
      return paramString.intValue();
    }
    throw new TSPException("digest algorithm cannot be found.");
  }
  
  static List getExtensionOIDs(Extensions paramExtensions)
  {
    if (paramExtensions == null) {
      return EMPTY_LIST;
    }
    return Collections.unmodifiableList(java.util.Arrays.asList(paramExtensions.getExtensionOIDs()));
  }
  
  public static Collection getSignatureTimestamps(SignerInformation paramSignerInformation, DigestCalculatorProvider paramDigestCalculatorProvider)
    throws TSPValidationException
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = paramSignerInformation.getUnsignedAttributes();
    if (localObject != null)
    {
      localObject = ((AttributeTable)localObject).getAll(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken);
      int i = 0;
      while (i < ((ASN1EncodableVector)localObject).size())
      {
        ASN1Set localASN1Set = ((Attribute)((ASN1EncodableVector)localObject).get(i)).getAttrValues();
        int j = 0;
        for (;;)
        {
          if (j >= localASN1Set.size()) {
            break label195;
          }
          try
          {
            TimeStampToken localTimeStampToken = new TimeStampToken(ContentInfo.getInstance(localASN1Set.getObjectAt(j)));
            TimeStampTokenInfo localTimeStampTokenInfo = localTimeStampToken.getTimeStampInfo();
            DigestCalculator localDigestCalculator = paramDigestCalculatorProvider.get(localTimeStampTokenInfo.getHashAlgorithm());
            OutputStream localOutputStream = localDigestCalculator.getOutputStream();
            localOutputStream.write(paramSignerInformation.getSignature());
            localOutputStream.close();
            if (org.bouncycastle.util.Arrays.constantTimeAreEqual(localDigestCalculator.getDigest(), localTimeStampTokenInfo.getMessageImprintDigest()))
            {
              localArrayList.add(localTimeStampToken);
              j += 1;
            }
            else
            {
              throw new TSPValidationException("Incorrect digest in message imprint");
            }
          }
          catch (OperatorCreationException paramSignerInformation)
          {
            for (;;) {}
          }
          catch (Exception paramSignerInformation)
          {
            label195:
            for (;;) {}
          }
        }
        throw new TSPValidationException("Timestamp could not be parsed");
        throw new TSPValidationException("Unknown hash algorithm specified in timestamp");
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public static void validateCertificate(X509CertificateHolder paramX509CertificateHolder)
    throws TSPValidationException
  {
    if (paramX509CertificateHolder.toASN1Structure().getVersionNumber() == 3)
    {
      paramX509CertificateHolder = paramX509CertificateHolder.getExtension(Extension.extendedKeyUsage);
      if (paramX509CertificateHolder != null)
      {
        if (paramX509CertificateHolder.isCritical())
        {
          paramX509CertificateHolder = ExtendedKeyUsage.getInstance(paramX509CertificateHolder.getParsedValue());
          if ((paramX509CertificateHolder.hasKeyPurposeId(KeyPurposeId.id_kp_timeStamping)) && (paramX509CertificateHolder.size() == 1)) {
            return;
          }
          throw new TSPValidationException("ExtendedKeyUsage not solely time stamping.");
        }
        throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension marked as critical.");
      }
      throw new TSPValidationException("Certificate must have an ExtendedKeyUsage extension.");
    }
    throw new IllegalArgumentException("Certificate must have an ExtendedKeyUsage extension.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\TSPUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */