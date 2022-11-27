package org.bouncycastle.cms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.cms.CMSObjectIdentifiers;
import org.bouncycastle.asn1.cms.OtherRevocationInfoFormat;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.cert.X509AttributeCertificateHolder;
import org.bouncycastle.cert.X509CRLHolder;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Store;

public class CMSSignedGenerator
{
  public static final String DATA = CMSObjectIdentifiers.data.getId();
  public static final String DIGEST_GOST3411;
  public static final String DIGEST_MD5;
  public static final String DIGEST_RIPEMD128;
  public static final String DIGEST_RIPEMD160;
  public static final String DIGEST_RIPEMD256;
  public static final String DIGEST_SHA1 = OIWObjectIdentifiers.idSHA1.getId();
  public static final String DIGEST_SHA224 = NISTObjectIdentifiers.id_sha224.getId();
  public static final String DIGEST_SHA256 = NISTObjectIdentifiers.id_sha256.getId();
  public static final String DIGEST_SHA384 = NISTObjectIdentifiers.id_sha384.getId();
  public static final String DIGEST_SHA512 = NISTObjectIdentifiers.id_sha512.getId();
  private static final Map EC_ALGORITHMS;
  public static final String ENCRYPTION_DSA;
  public static final String ENCRYPTION_ECDSA;
  private static final String ENCRYPTION_ECDSA_WITH_SHA1;
  private static final String ENCRYPTION_ECDSA_WITH_SHA224;
  private static final String ENCRYPTION_ECDSA_WITH_SHA256;
  private static final String ENCRYPTION_ECDSA_WITH_SHA384;
  private static final String ENCRYPTION_ECDSA_WITH_SHA512;
  public static final String ENCRYPTION_ECGOST3410;
  public static final String ENCRYPTION_GOST3410;
  public static final String ENCRYPTION_RSA;
  public static final String ENCRYPTION_RSA_PSS;
  private static final Set NO_PARAMS;
  protected List _signers = new ArrayList();
  protected List certs = new ArrayList();
  protected List crls = new ArrayList();
  protected Map digests = new HashMap();
  protected List signerGens = new ArrayList();
  
  static
  {
    DIGEST_MD5 = PKCSObjectIdentifiers.md5.getId();
    DIGEST_GOST3411 = CryptoProObjectIdentifiers.gostR3411.getId();
    DIGEST_RIPEMD128 = TeleTrusTObjectIdentifiers.ripemd128.getId();
    DIGEST_RIPEMD160 = TeleTrusTObjectIdentifiers.ripemd160.getId();
    DIGEST_RIPEMD256 = TeleTrusTObjectIdentifiers.ripemd256.getId();
    ENCRYPTION_RSA = PKCSObjectIdentifiers.rsaEncryption.getId();
    ENCRYPTION_DSA = X9ObjectIdentifiers.id_dsa_with_sha1.getId();
    ENCRYPTION_ECDSA = X9ObjectIdentifiers.ecdsa_with_SHA1.getId();
    ENCRYPTION_RSA_PSS = PKCSObjectIdentifiers.id_RSASSA_PSS.getId();
    ENCRYPTION_GOST3410 = CryptoProObjectIdentifiers.gostR3410_94.getId();
    ENCRYPTION_ECGOST3410 = CryptoProObjectIdentifiers.gostR3410_2001.getId();
    ENCRYPTION_ECDSA_WITH_SHA1 = X9ObjectIdentifiers.ecdsa_with_SHA1.getId();
    ENCRYPTION_ECDSA_WITH_SHA224 = X9ObjectIdentifiers.ecdsa_with_SHA224.getId();
    ENCRYPTION_ECDSA_WITH_SHA256 = X9ObjectIdentifiers.ecdsa_with_SHA256.getId();
    ENCRYPTION_ECDSA_WITH_SHA384 = X9ObjectIdentifiers.ecdsa_with_SHA384.getId();
    ENCRYPTION_ECDSA_WITH_SHA512 = X9ObjectIdentifiers.ecdsa_with_SHA512.getId();
    NO_PARAMS = new HashSet();
    EC_ALGORITHMS = new HashMap();
    NO_PARAMS.add(ENCRYPTION_DSA);
    NO_PARAMS.add(ENCRYPTION_ECDSA);
    NO_PARAMS.add(ENCRYPTION_ECDSA_WITH_SHA1);
    NO_PARAMS.add(ENCRYPTION_ECDSA_WITH_SHA224);
    NO_PARAMS.add(ENCRYPTION_ECDSA_WITH_SHA256);
    NO_PARAMS.add(ENCRYPTION_ECDSA_WITH_SHA384);
    NO_PARAMS.add(ENCRYPTION_ECDSA_WITH_SHA512);
    EC_ALGORITHMS.put(DIGEST_SHA1, ENCRYPTION_ECDSA_WITH_SHA1);
    EC_ALGORITHMS.put(DIGEST_SHA224, ENCRYPTION_ECDSA_WITH_SHA224);
    EC_ALGORITHMS.put(DIGEST_SHA256, ENCRYPTION_ECDSA_WITH_SHA256);
    EC_ALGORITHMS.put(DIGEST_SHA384, ENCRYPTION_ECDSA_WITH_SHA384);
    EC_ALGORITHMS.put(DIGEST_SHA512, ENCRYPTION_ECDSA_WITH_SHA512);
  }
  
  public void addAttributeCertificate(X509AttributeCertificateHolder paramX509AttributeCertificateHolder)
    throws CMSException
  {
    this.certs.add(new DERTaggedObject(false, 2, paramX509AttributeCertificateHolder.toASN1Structure()));
  }
  
  public void addAttributeCertificates(Store paramStore)
    throws CMSException
  {
    this.certs.addAll(CMSUtils.getAttributeCertificatesFromStore(paramStore));
  }
  
  public void addCRL(X509CRLHolder paramX509CRLHolder)
  {
    this.crls.add(paramX509CRLHolder.toASN1Structure());
  }
  
  public void addCRLs(Store paramStore)
    throws CMSException
  {
    this.crls.addAll(CMSUtils.getCRLsFromStore(paramStore));
  }
  
  public void addCertificate(X509CertificateHolder paramX509CertificateHolder)
    throws CMSException
  {
    this.certs.add(paramX509CertificateHolder.toASN1Structure());
  }
  
  public void addCertificates(Store paramStore)
    throws CMSException
  {
    this.certs.addAll(CMSUtils.getCertificatesFromStore(paramStore));
  }
  
  public void addOtherRevocationInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, ASN1Encodable paramASN1Encodable)
  {
    this.crls.add(new DERTaggedObject(false, 1, new OtherRevocationInfoFormat(paramASN1ObjectIdentifier, paramASN1Encodable)));
  }
  
  public void addOtherRevocationInfo(ASN1ObjectIdentifier paramASN1ObjectIdentifier, Store paramStore)
  {
    this.crls.addAll(CMSUtils.getOthersFromStore(paramASN1ObjectIdentifier, paramStore));
  }
  
  public void addSignerInfoGenerator(SignerInfoGenerator paramSignerInfoGenerator)
  {
    this.signerGens.add(paramSignerInfoGenerator);
  }
  
  public void addSigners(SignerInformationStore paramSignerInformationStore)
  {
    paramSignerInformationStore = paramSignerInformationStore.getSigners().iterator();
    while (paramSignerInformationStore.hasNext()) {
      this._signers.add(paramSignerInformationStore.next());
    }
  }
  
  protected Map getBaseParameters(ASN1ObjectIdentifier paramASN1ObjectIdentifier, AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("contentType", paramASN1ObjectIdentifier);
    localHashMap.put("digestAlgID", paramAlgorithmIdentifier);
    localHashMap.put("digest", Arrays.clone(paramArrayOfByte));
    return localHashMap;
  }
  
  public Map getGeneratedDigests()
  {
    return new HashMap(this.digests);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\CMSSignedGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */