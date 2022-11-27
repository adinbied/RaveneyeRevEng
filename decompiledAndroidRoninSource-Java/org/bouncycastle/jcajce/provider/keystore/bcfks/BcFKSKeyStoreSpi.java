package org.bouncycastle.jcajce.provider.keystore.bcfks;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.bc.EncryptedObjectStoreData;
import org.bouncycastle.asn1.bc.EncryptedPrivateKeyData;
import org.bouncycastle.asn1.bc.EncryptedSecretKeyData;
import org.bouncycastle.asn1.bc.ObjectData;
import org.bouncycastle.asn1.bc.ObjectDataSequence;
import org.bouncycastle.asn1.bc.ObjectStore;
import org.bouncycastle.asn1.bc.ObjectStoreData;
import org.bouncycastle.asn1.bc.ObjectStoreIntegrityCheck;
import org.bouncycastle.asn1.bc.PbkdMacIntegrityCheck;
import org.bouncycastle.asn1.bc.SecretKeyData;
import org.bouncycastle.asn1.cms.CCMParameters;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.EncryptionScheme;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.pkcs.PBES2Parameters;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.PBEParametersGenerator;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

class BcFKSKeyStoreSpi
  extends KeyStoreSpi
{
  private static final BigInteger CERTIFICATE;
  private static final BigInteger PRIVATE_KEY;
  private static final BigInteger PROTECTED_PRIVATE_KEY = BigInteger.valueOf(3L);
  private static final BigInteger PROTECTED_SECRET_KEY = BigInteger.valueOf(4L);
  private static final BigInteger SECRET_KEY;
  private static final Map<String, ASN1ObjectIdentifier> oidMap = new HashMap();
  private static final Map<ASN1ObjectIdentifier, String> publicAlgMap = new HashMap();
  private Date creationDate;
  private final Map<String, ObjectData> entries = new HashMap();
  private AlgorithmIdentifier hmacAlgorithm;
  private KeyDerivationFunc hmacPkbdAlgorithm;
  private Date lastModifiedDate;
  private final Map<String, PrivateKey> privateKeyCache = new HashMap();
  private final BouncyCastleProvider provider;
  
  static
  {
    oidMap.put("DESEDE", OIWObjectIdentifiers.desEDE);
    oidMap.put("TRIPLEDES", OIWObjectIdentifiers.desEDE);
    oidMap.put("TDEA", OIWObjectIdentifiers.desEDE);
    oidMap.put("HMACSHA1", PKCSObjectIdentifiers.id_hmacWithSHA1);
    oidMap.put("HMACSHA224", PKCSObjectIdentifiers.id_hmacWithSHA224);
    oidMap.put("HMACSHA256", PKCSObjectIdentifiers.id_hmacWithSHA256);
    oidMap.put("HMACSHA384", PKCSObjectIdentifiers.id_hmacWithSHA384);
    oidMap.put("HMACSHA512", PKCSObjectIdentifiers.id_hmacWithSHA512);
    publicAlgMap.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
    publicAlgMap.put(X9ObjectIdentifiers.id_ecPublicKey, "EC");
    publicAlgMap.put(OIWObjectIdentifiers.elGamalAlgorithm, "DH");
    publicAlgMap.put(PKCSObjectIdentifiers.dhKeyAgreement, "DH");
    publicAlgMap.put(X9ObjectIdentifiers.id_dsa, "DSA");
    CERTIFICATE = BigInteger.valueOf(0L);
    PRIVATE_KEY = BigInteger.valueOf(1L);
    SECRET_KEY = BigInteger.valueOf(2L);
  }
  
  BcFKSKeyStoreSpi(BouncyCastleProvider paramBouncyCastleProvider)
  {
    this.provider = paramBouncyCastleProvider;
  }
  
  private byte[] calculateMac(byte[] paramArrayOfByte, AlgorithmIdentifier paramAlgorithmIdentifier, KeyDerivationFunc paramKeyDerivationFunc, char[] paramArrayOfChar)
    throws NoSuchAlgorithmException, IOException
  {
    String str = paramAlgorithmIdentifier.getAlgorithm().getId();
    paramAlgorithmIdentifier = this.provider;
    if (paramAlgorithmIdentifier != null) {
      paramAlgorithmIdentifier = Mac.getInstance(str, paramAlgorithmIdentifier);
    } else {
      paramAlgorithmIdentifier = Mac.getInstance(str);
    }
    if (paramArrayOfChar == null) {}
    try
    {
      paramArrayOfChar = new char[0];
      paramAlgorithmIdentifier.init(new SecretKeySpec(generateKey(paramKeyDerivationFunc, "INTEGRITY_CHECK", paramArrayOfChar), str));
      return paramAlgorithmIdentifier.doFinal(paramArrayOfByte);
    }
    catch (InvalidKeyException paramArrayOfByte)
    {
      paramAlgorithmIdentifier = new StringBuilder();
      paramAlgorithmIdentifier.append("Cannot set up MAC calculation: ");
      paramAlgorithmIdentifier.append(paramArrayOfByte.getMessage());
      throw new IOException(paramAlgorithmIdentifier.toString());
    }
  }
  
  private EncryptedPrivateKeyData createPrivateKeySequence(EncryptedPrivateKeyInfo paramEncryptedPrivateKeyInfo, java.security.cert.Certificate[] paramArrayOfCertificate)
    throws CertificateEncodingException
  {
    org.bouncycastle.asn1.x509.Certificate[] arrayOfCertificate = new org.bouncycastle.asn1.x509.Certificate[paramArrayOfCertificate.length];
    int i = 0;
    while (i != paramArrayOfCertificate.length)
    {
      arrayOfCertificate[i] = org.bouncycastle.asn1.x509.Certificate.getInstance(paramArrayOfCertificate[i].getEncoded());
      i += 1;
    }
    return new EncryptedPrivateKeyData(paramEncryptedPrivateKeyInfo, arrayOfCertificate);
  }
  
  private java.security.cert.Certificate decodeCertificate(Object paramObject)
  {
    BouncyCastleProvider localBouncyCastleProvider = this.provider;
    if (localBouncyCastleProvider != null) {}
    try
    {
      paramObject = CertificateFactory.getInstance("X.509", localBouncyCastleProvider).generateCertificate(new ByteArrayInputStream(org.bouncycastle.asn1.x509.Certificate.getInstance(paramObject).getEncoded()));
      return (java.security.cert.Certificate)paramObject;
    }
    catch (Exception paramObject)
    {
      try
      {
        paramObject = CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(org.bouncycastle.asn1.x509.Certificate.getInstance(paramObject).getEncoded()));
        return (java.security.cert.Certificate)paramObject;
      }
      catch (Exception paramObject) {}
      paramObject = paramObject;
      return null;
    }
    return null;
  }
  
  private byte[] decryptData(String paramString, AlgorithmIdentifier paramAlgorithmIdentifier, char[] paramArrayOfChar, byte[] paramArrayOfByte)
    throws IOException
  {
    if (paramAlgorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_PBES2))
    {
      Object localObject = PBES2Parameters.getInstance(paramAlgorithmIdentifier.getParameters());
      paramAlgorithmIdentifier = ((PBES2Parameters)localObject).getEncryptionScheme();
      if (paramAlgorithmIdentifier.getAlgorithm().equals(NISTObjectIdentifiers.id_aes256_CCM)) {
        try
        {
          CCMParameters localCCMParameters = CCMParameters.getInstance(paramAlgorithmIdentifier.getParameters());
          paramAlgorithmIdentifier = this.provider;
          AlgorithmParameters localAlgorithmParameters;
          if (paramAlgorithmIdentifier == null)
          {
            paramAlgorithmIdentifier = Cipher.getInstance("AES/CCM/NoPadding");
            localAlgorithmParameters = AlgorithmParameters.getInstance("CCM");
          }
          else
          {
            paramAlgorithmIdentifier = Cipher.getInstance("AES/CCM/NoPadding", this.provider);
            localAlgorithmParameters = AlgorithmParameters.getInstance("CCM", this.provider);
          }
          localAlgorithmParameters.init(localCCMParameters.getEncoded());
          localObject = ((PBES2Parameters)localObject).getKeyDerivationFunc();
          if (paramArrayOfChar == null) {
            paramArrayOfChar = new char[0];
          }
          paramAlgorithmIdentifier.init(2, new SecretKeySpec(generateKey((KeyDerivationFunc)localObject, paramString, paramArrayOfChar), "AES"), localAlgorithmParameters);
          paramString = paramAlgorithmIdentifier.doFinal(paramArrayOfByte);
          return paramString;
        }
        catch (Exception paramString)
        {
          throw new IOException(paramString.toString());
        }
      }
      throw new IOException("BCFKS KeyStore cannot recognize protection encryption algorithm.");
    }
    throw new IOException("BCFKS KeyStore cannot recognize protection algorithm.");
  }
  
  private Date extractCreationDate(ObjectData paramObjectData, Date paramDate)
  {
    try
    {
      paramObjectData = paramObjectData.getCreationDate().getDate();
      return paramObjectData;
    }
    catch (ParseException paramObjectData) {}
    return paramDate;
  }
  
  private byte[] generateKey(KeyDerivationFunc paramKeyDerivationFunc, String paramString, char[] paramArrayOfChar)
    throws IOException
  {
    paramArrayOfChar = PBEParametersGenerator.PKCS12PasswordToBytes(paramArrayOfChar);
    paramString = PBEParametersGenerator.PKCS12PasswordToBytes(paramString.toCharArray());
    PKCS5S2ParametersGenerator localPKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA512Digest());
    if (paramKeyDerivationFunc.getAlgorithm().equals(PKCSObjectIdentifiers.id_PBKDF2))
    {
      paramKeyDerivationFunc = PBKDF2Params.getInstance(paramKeyDerivationFunc.getParameters());
      if (paramKeyDerivationFunc.getPrf().getAlgorithm().equals(PKCSObjectIdentifiers.id_hmacWithSHA512))
      {
        localPKCS5S2ParametersGenerator.init(Arrays.concatenate(paramArrayOfChar, paramString), paramKeyDerivationFunc.getSalt(), paramKeyDerivationFunc.getIterationCount().intValue());
        return ((KeyParameter)localPKCS5S2ParametersGenerator.generateDerivedParameters(paramKeyDerivationFunc.getKeyLength().intValue() * 8)).getKey();
      }
      throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD PRF.");
    }
    throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD.");
  }
  
  private KeyDerivationFunc generatePkbdAlgorithmIdentifier(int paramInt)
  {
    byte[] arrayOfByte = new byte[64];
    getDefaultSecureRandom().nextBytes(arrayOfByte);
    return new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(arrayOfByte, 1024, paramInt, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE)));
  }
  
  private SecureRandom getDefaultSecureRandom()
  {
    return new SecureRandom();
  }
  
  private static String getPublicKeyAlg(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    String str = (String)publicAlgMap.get(paramASN1ObjectIdentifier);
    if (str != null) {
      return str;
    }
    return paramASN1ObjectIdentifier.getId();
  }
  
  private void verifyMac(byte[] paramArrayOfByte, PbkdMacIntegrityCheck paramPbkdMacIntegrityCheck, char[] paramArrayOfChar)
    throws NoSuchAlgorithmException, IOException
  {
    if (Arrays.constantTimeAreEqual(calculateMac(paramArrayOfByte, paramPbkdMacIntegrityCheck.getMacAlgorithm(), paramPbkdMacIntegrityCheck.getPbkdAlgorithm(), paramArrayOfChar), paramPbkdMacIntegrityCheck.getMac())) {
      return;
    }
    throw new IOException("BCFKS KeyStore corrupted: MAC calculation failed.");
  }
  
  public Enumeration<String> engineAliases()
  {
    new Enumeration()
    {
      public boolean hasMoreElements()
      {
        return this.val$it.hasNext();
      }
      
      public Object nextElement()
      {
        return this.val$it.next();
      }
    };
  }
  
  public boolean engineContainsAlias(String paramString)
  {
    if (paramString != null) {
      return this.entries.containsKey(paramString);
    }
    throw new NullPointerException("alias value is null");
  }
  
  public void engineDeleteEntry(String paramString)
    throws KeyStoreException
  {
    if ((ObjectData)this.entries.get(paramString) == null) {
      return;
    }
    this.privateKeyCache.remove(paramString);
    this.entries.remove(paramString);
    this.lastModifiedDate = new Date();
  }
  
  public java.security.cert.Certificate engineGetCertificate(String paramString)
  {
    paramString = (ObjectData)this.entries.get(paramString);
    if (paramString != null) {
      if ((!paramString.getType().equals(PRIVATE_KEY)) && (!paramString.getType().equals(PROTECTED_PRIVATE_KEY)))
      {
        if (paramString.getType().equals(CERTIFICATE)) {
          return decodeCertificate(paramString.getData());
        }
      }
      else {
        return decodeCertificate(EncryptedPrivateKeyData.getInstance(paramString.getData()).getCertificateChain()[0]);
      }
    }
    return null;
  }
  
  public String engineGetCertificateAlias(java.security.cert.Certificate paramCertificate)
  {
    if (paramCertificate == null) {
      return null;
    }
    for (;;)
    {
      try
      {
        paramCertificate = paramCertificate.getEncoded();
        Iterator localIterator = this.entries.keySet().iterator();
        if (localIterator.hasNext())
        {
          str = (String)localIterator.next();
          localObjectData = (ObjectData)this.entries.get(str);
          if (localObjectData.getType().equals(CERTIFICATE))
          {
            if (!Arrays.areEqual(localObjectData.getData(), paramCertificate)) {
              continue;
            }
            return str;
          }
          if (!localObjectData.getType().equals(PRIVATE_KEY)) {
            if (!localObjectData.getType().equals(PROTECTED_PRIVATE_KEY)) {
              continue;
            }
          }
        }
      }
      catch (CertificateEncodingException paramCertificate)
      {
        String str;
        ObjectData localObjectData;
        boolean bool;
        return null;
      }
      try
      {
        bool = Arrays.areEqual(EncryptedPrivateKeyData.getInstance(localObjectData.getData()).getCertificateChain()[0].toASN1Primitive().getEncoded(), paramCertificate);
        if (bool) {
          return str;
        }
      }
      catch (IOException localIOException) {}
    }
    return null;
  }
  
  public java.security.cert.Certificate[] engineGetCertificateChain(String paramString)
  {
    paramString = (ObjectData)this.entries.get(paramString);
    if ((paramString != null) && ((paramString.getType().equals(PRIVATE_KEY)) || (paramString.getType().equals(PROTECTED_PRIVATE_KEY))))
    {
      paramString = EncryptedPrivateKeyData.getInstance(paramString.getData()).getCertificateChain();
      int j = paramString.length;
      X509Certificate[] arrayOfX509Certificate = new X509Certificate[j];
      int i = 0;
      while (i != j)
      {
        arrayOfX509Certificate[i] = decodeCertificate(paramString[i]);
        i += 1;
      }
      return arrayOfX509Certificate;
    }
    return null;
  }
  
  public Date engineGetCreationDate(String paramString)
  {
    paramString = (ObjectData)this.entries.get(paramString);
    if (paramString != null) {}
    try
    {
      paramString = paramString.getLastModifiedDate().getDate();
      return paramString;
    }
    catch (ParseException paramString)
    {
      for (;;) {}
    }
    return new Date();
    return null;
  }
  
  public Key engineGetKey(String paramString, char[] paramArrayOfChar)
    throws NoSuchAlgorithmException, UnrecoverableKeyException
  {
    Object localObject = (ObjectData)this.entries.get(paramString);
    if (localObject != null)
    {
      if ((!((ObjectData)localObject).getType().equals(PRIVATE_KEY)) && (!((ObjectData)localObject).getType().equals(PROTECTED_PRIVATE_KEY)))
      {
        if ((!((ObjectData)localObject).getType().equals(SECRET_KEY)) && (!((ObjectData)localObject).getType().equals(PROTECTED_SECRET_KEY)))
        {
          paramArrayOfChar = new StringBuilder();
          paramArrayOfChar.append("BCFKS KeyStore unable to recover secret key (");
          paramArrayOfChar.append(paramString);
          paramArrayOfChar.append("): type not recognized");
          throw new UnrecoverableKeyException(paramArrayOfChar.toString());
        }
        localObject = EncryptedSecretKeyData.getInstance(((ObjectData)localObject).getData());
        try
        {
          localObject = SecretKeyData.getInstance(decryptData("SECRET_KEY_ENCRYPTION", ((EncryptedSecretKeyData)localObject).getKeyEncryptionAlgorithm(), paramArrayOfChar, ((EncryptedSecretKeyData)localObject).getEncryptedKeyData()));
          if (this.provider != null) {
            paramArrayOfChar = SecretKeyFactory.getInstance(((SecretKeyData)localObject).getKeyAlgorithm().getId(), this.provider);
          } else {
            paramArrayOfChar = SecretKeyFactory.getInstance(((SecretKeyData)localObject).getKeyAlgorithm().getId());
          }
          paramArrayOfChar = paramArrayOfChar.generateSecret(new SecretKeySpec(((SecretKeyData)localObject).getKeyBytes(), ((SecretKeyData)localObject).getKeyAlgorithm().getId()));
          return paramArrayOfChar;
        }
        catch (Exception paramArrayOfChar)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("BCFKS KeyStore unable to recover secret key (");
          ((StringBuilder)localObject).append(paramString);
          ((StringBuilder)localObject).append("): ");
          ((StringBuilder)localObject).append(paramArrayOfChar.getMessage());
          throw new UnrecoverableKeyException(((StringBuilder)localObject).toString());
        }
      }
      PrivateKey localPrivateKey = (PrivateKey)this.privateKeyCache.get(paramString);
      if (localPrivateKey != null) {
        return localPrivateKey;
      }
      localObject = EncryptedPrivateKeyInfo.getInstance(EncryptedPrivateKeyData.getInstance(((ObjectData)localObject).getData()).getEncryptedPrivateKeyInfo());
      try
      {
        localObject = PrivateKeyInfo.getInstance(decryptData("PRIVATE_KEY_ENCRYPTION", ((EncryptedPrivateKeyInfo)localObject).getEncryptionAlgorithm(), paramArrayOfChar, ((EncryptedPrivateKeyInfo)localObject).getEncryptedData()));
        if (this.provider != null) {
          paramArrayOfChar = KeyFactory.getInstance(((PrivateKeyInfo)localObject).getPrivateKeyAlgorithm().getAlgorithm().getId(), this.provider);
        } else {
          paramArrayOfChar = KeyFactory.getInstance(getPublicKeyAlg(((PrivateKeyInfo)localObject).getPrivateKeyAlgorithm().getAlgorithm()));
        }
        paramArrayOfChar = paramArrayOfChar.generatePrivate(new PKCS8EncodedKeySpec(((PrivateKeyInfo)localObject).getEncoded()));
        this.privateKeyCache.put(paramString, paramArrayOfChar);
        return paramArrayOfChar;
      }
      catch (Exception paramArrayOfChar)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("BCFKS KeyStore unable to recover private key (");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append("): ");
        ((StringBuilder)localObject).append(paramArrayOfChar.getMessage());
        throw new UnrecoverableKeyException(((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public boolean engineIsCertificateEntry(String paramString)
  {
    paramString = (ObjectData)this.entries.get(paramString);
    if (paramString != null) {
      return paramString.getType().equals(CERTIFICATE);
    }
    return false;
  }
  
  public boolean engineIsKeyEntry(String paramString)
  {
    paramString = (ObjectData)this.entries.get(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramString != null)
    {
      paramString = paramString.getType();
      if ((!paramString.equals(PRIVATE_KEY)) && (!paramString.equals(SECRET_KEY)) && (!paramString.equals(PROTECTED_PRIVATE_KEY)))
      {
        bool1 = bool2;
        if (!paramString.equals(PROTECTED_SECRET_KEY)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void engineLoad(InputStream paramInputStream, char[] paramArrayOfChar)
    throws IOException, NoSuchAlgorithmException, CertificateException
  {
    this.entries.clear();
    this.privateKeyCache.clear();
    this.creationDate = null;
    this.lastModifiedDate = null;
    this.hmacAlgorithm = null;
    if (paramInputStream == null)
    {
      paramInputStream = new Date();
      this.creationDate = paramInputStream;
      this.lastModifiedDate = paramInputStream;
      this.hmacAlgorithm = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, DERNull.INSTANCE);
      this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(64);
      return;
    }
    paramInputStream = ObjectStore.getInstance(new ASN1InputStream(paramInputStream).readObject());
    Object localObject = paramInputStream.getIntegrityCheck();
    if (((ObjectStoreIntegrityCheck)localObject).getType() == 0)
    {
      localObject = PbkdMacIntegrityCheck.getInstance(((ObjectStoreIntegrityCheck)localObject).getIntegrityCheck());
      this.hmacAlgorithm = ((PbkdMacIntegrityCheck)localObject).getMacAlgorithm();
      this.hmacPkbdAlgorithm = ((PbkdMacIntegrityCheck)localObject).getPbkdAlgorithm();
      verifyMac(paramInputStream.getStoreData().toASN1Primitive().getEncoded(), (PbkdMacIntegrityCheck)localObject, paramArrayOfChar);
      paramInputStream = paramInputStream.getStoreData();
      if ((paramInputStream instanceof EncryptedObjectStoreData))
      {
        paramInputStream = (EncryptedObjectStoreData)paramInputStream;
        paramInputStream = ObjectStoreData.getInstance(decryptData("STORE_ENCRYPTION", paramInputStream.getEncryptionAlgorithm(), paramArrayOfChar, paramInputStream.getEncryptedContent().getOctets()));
      }
      else
      {
        paramInputStream = ObjectStoreData.getInstance(paramInputStream);
      }
    }
    try
    {
      this.creationDate = paramInputStream.getCreationDate().getDate();
      this.lastModifiedDate = paramInputStream.getLastModifiedDate().getDate();
      if (paramInputStream.getIntegrityAlgorithm().equals(this.hmacAlgorithm))
      {
        paramInputStream = paramInputStream.getObjectDataSequence().iterator();
        while (paramInputStream.hasNext())
        {
          paramArrayOfChar = ObjectData.getInstance(paramInputStream.next());
          this.entries.put(paramArrayOfChar.getIdentifier(), paramArrayOfChar);
        }
        return;
      }
      throw new IOException("BCFKS KeyStore storeData integrity algorithm does not match store integrity algorithm.");
    }
    catch (ParseException paramInputStream)
    {
      for (;;) {}
    }
    throw new IOException("BCFKS KeyStore unable to parse store data information.");
    throw new IOException("BCFKS KeyStore unable to recognize integrity check.");
  }
  
  public void engineSetCertificateEntry(String paramString, java.security.cert.Certificate paramCertificate)
    throws KeyStoreException
  {
    Object localObject = (ObjectData)this.entries.get(paramString);
    Date localDate = new Date();
    if (localObject != null)
    {
      if (((ObjectData)localObject).getType().equals(CERTIFICATE))
      {
        localObject = extractCreationDate((ObjectData)localObject, localDate);
      }
      else
      {
        paramCertificate = new StringBuilder();
        paramCertificate.append("BCFKS KeyStore already has a key entry with alias ");
        paramCertificate.append(paramString);
        throw new KeyStoreException(paramCertificate.toString());
      }
    }
    else {
      localObject = localDate;
    }
    try
    {
      this.entries.put(paramString, new ObjectData(CERTIFICATE, paramString, (Date)localObject, localDate, paramCertificate.getEncoded(), null));
      this.lastModifiedDate = localDate;
      return;
    }
    catch (CertificateEncodingException paramString)
    {
      paramCertificate = new StringBuilder();
      paramCertificate.append("BCFKS KeyStore unable to handle certificate: ");
      paramCertificate.append(paramString.getMessage());
      throw new ExtKeyStoreException(paramCertificate.toString(), paramString);
    }
  }
  
  public void engineSetKeyEntry(String paramString, Key paramKey, char[] paramArrayOfChar, java.security.cert.Certificate[] paramArrayOfCertificate)
    throws KeyStoreException
  {
    Date localDate = new Date();
    Object localObject1 = (ObjectData)this.entries.get(paramString);
    if (localObject1 != null) {
      localObject1 = extractCreationDate((ObjectData)localObject1, localDate);
    } else {
      localObject1 = localDate;
    }
    this.privateKeyCache.remove(paramString);
    Object localObject3;
    Object localObject2;
    if ((paramKey instanceof PrivateKey))
    {
      if (paramArrayOfCertificate != null) {
        try
        {
          localObject3 = paramKey.getEncoded();
          localObject2 = generatePkbdAlgorithmIdentifier(32);
          if (paramArrayOfChar == null) {
            paramArrayOfChar = new char[0];
          }
          paramArrayOfChar = generateKey((KeyDerivationFunc)localObject2, "PRIVATE_KEY_ENCRYPTION", paramArrayOfChar);
          if (this.provider == null) {
            paramKey = Cipher.getInstance("AES/CCM/NoPadding");
          } else {
            paramKey = Cipher.getInstance("AES/CCM/NoPadding", this.provider);
          }
          paramKey.init(1, new SecretKeySpec(paramArrayOfChar, "AES"));
          paramArrayOfChar = paramKey.doFinal((byte[])localObject3);
          paramKey = paramKey.getParameters();
          paramKey = new PBES2Parameters((KeyDerivationFunc)localObject2, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_CCM, CCMParameters.getInstance(paramKey.getEncoded())));
          paramKey = createPrivateKeySequence(new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, paramKey), paramArrayOfChar), paramArrayOfCertificate);
          this.entries.put(paramString, new ObjectData(PRIVATE_KEY, paramString, (Date)localObject1, localDate, paramKey.getEncoded(), null));
        }
        catch (Exception paramString)
        {
          paramKey = new StringBuilder();
          paramKey.append("BCFKS KeyStore exception storing private key: ");
          paramKey.append(paramString.toString());
          throw new ExtKeyStoreException(paramKey.toString(), paramString);
        }
      }
      throw new KeyStoreException("BCFKS KeyStore requires a certificate chain for private key storage.");
    }
    if ((paramKey instanceof SecretKey))
    {
      if (paramArrayOfCertificate == null) {
        try
        {
          localObject2 = paramKey.getEncoded();
          paramArrayOfCertificate = generatePkbdAlgorithmIdentifier(32);
          if (paramArrayOfChar == null) {
            paramArrayOfChar = new char[0];
          }
          localObject3 = generateKey(paramArrayOfCertificate, "SECRET_KEY_ENCRYPTION", paramArrayOfChar);
          if (this.provider == null) {
            paramArrayOfChar = Cipher.getInstance("AES/CCM/NoPadding");
          } else {
            paramArrayOfChar = Cipher.getInstance("AES/CCM/NoPadding", this.provider);
          }
          paramArrayOfChar.init(1, new SecretKeySpec((byte[])localObject3, "AES"));
          paramKey = Strings.toUpperCase(paramKey.getAlgorithm());
          if (paramKey.indexOf("AES") > -1)
          {
            paramKey = paramArrayOfChar.doFinal(new SecretKeyData(NISTObjectIdentifiers.aes, (byte[])localObject2).getEncoded());
          }
          else
          {
            localObject3 = (ASN1ObjectIdentifier)oidMap.get(paramKey);
            if (localObject3 == null) {
              break label568;
            }
            paramKey = paramArrayOfChar.doFinal(new SecretKeyData((ASN1ObjectIdentifier)localObject3, (byte[])localObject2).getEncoded());
          }
          paramArrayOfChar = paramArrayOfChar.getParameters();
          paramArrayOfChar = new PBES2Parameters(paramArrayOfCertificate, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_CCM, CCMParameters.getInstance(paramArrayOfChar.getEncoded())));
          paramKey = new EncryptedSecretKeyData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, paramArrayOfChar), paramKey);
          this.entries.put(paramString, new ObjectData(SECRET_KEY, paramString, (Date)localObject1, localDate, paramKey.getEncoded(), null));
          this.lastModifiedDate = localDate;
          return;
          label568:
          paramString = new StringBuilder();
          paramString.append("BCFKS KeyStore cannot recognize secret key (");
          paramString.append(paramKey);
          paramString.append(") for storage.");
          throw new KeyStoreException(paramString.toString());
        }
        catch (Exception paramString)
        {
          paramKey = new StringBuilder();
          paramKey.append("BCFKS KeyStore exception storing private key: ");
          paramKey.append(paramString.toString());
          throw new ExtKeyStoreException(paramKey.toString(), paramString);
        }
      }
      throw new KeyStoreException("BCFKS KeyStore cannot store certificate chain with secret key.");
    }
    throw new KeyStoreException("BCFKS KeyStore unable to recognize key.");
  }
  
  public void engineSetKeyEntry(String paramString, byte[] paramArrayOfByte, java.security.cert.Certificate[] paramArrayOfCertificate)
    throws KeyStoreException
  {
    localDate = new Date();
    localObject = (ObjectData)this.entries.get(paramString);
    if (localObject != null) {
      localObject = extractCreationDate((ObjectData)localObject, localDate);
    } else {
      localObject = localDate;
    }
    if (paramArrayOfCertificate != null) {
      try
      {
        paramArrayOfByte = EncryptedPrivateKeyInfo.getInstance(paramArrayOfByte);
        try
        {
          this.privateKeyCache.remove(paramString);
          this.entries.put(paramString, new ObjectData(PROTECTED_PRIVATE_KEY, paramString, (Date)localObject, localDate, createPrivateKeySequence(paramArrayOfByte, paramArrayOfCertificate).getEncoded(), null));
        }
        catch (Exception paramString)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("BCFKS KeyStore exception storing protected private key: ");
          paramArrayOfByte.append(paramString.toString());
          throw new ExtKeyStoreException(paramArrayOfByte.toString(), paramString);
        }
        try
        {
          this.entries.put(paramString, new ObjectData(PROTECTED_SECRET_KEY, paramString, (Date)localObject, localDate, paramArrayOfByte, null));
          this.lastModifiedDate = localDate;
          return;
        }
        catch (Exception paramString)
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("BCFKS KeyStore exception storing protected private key: ");
          paramArrayOfByte.append(paramString.toString());
          throw new ExtKeyStoreException(paramArrayOfByte.toString(), paramString);
        }
      }
      catch (Exception paramString)
      {
        throw new ExtKeyStoreException("BCFKS KeyStore private key encoding must be an EncryptedPrivateKeyInfo.", paramString);
      }
    }
  }
  
  public int engineSize()
  {
    return this.entries.size();
  }
  
  public void engineStore(OutputStream paramOutputStream, char[] paramArrayOfChar)
    throws IOException, NoSuchAlgorithmException, CertificateException
  {
    Object localObject3 = (ObjectData[])this.entries.values().toArray(new ObjectData[this.entries.size()]);
    Object localObject2 = generatePkbdAlgorithmIdentifier(32);
    Object localObject1;
    if (paramArrayOfChar != null) {
      localObject1 = paramArrayOfChar;
    } else {
      localObject1 = new char[0];
    }
    byte[] arrayOfByte = generateKey((KeyDerivationFunc)localObject2, "STORE_ENCRYPTION", (char[])localObject1);
    localObject3 = new ObjectStoreData(this.hmacAlgorithm, this.creationDate, this.lastModifiedDate, new ObjectDataSequence((ObjectData[])localObject3), null);
    try
    {
      localObject1 = this.provider;
      if (localObject1 == null) {
        localObject1 = Cipher.getInstance("AES/CCM/NoPadding");
      } else {
        localObject1 = Cipher.getInstance("AES/CCM/NoPadding", this.provider);
      }
      ((Cipher)localObject1).init(1, new SecretKeySpec(arrayOfByte, "AES"));
      arrayOfByte = ((Cipher)localObject1).doFinal(((ObjectStoreData)localObject3).getEncoded());
      localObject1 = ((Cipher)localObject1).getParameters();
      localObject1 = new PBES2Parameters((KeyDerivationFunc)localObject2, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_CCM, CCMParameters.getInstance(((AlgorithmParameters)localObject1).getEncoded())));
      localObject1 = new EncryptedObjectStoreData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, (ASN1Encodable)localObject1), arrayOfByte);
      localObject2 = PBKDF2Params.getInstance(this.hmacPkbdAlgorithm.getParameters());
      arrayOfByte = new byte[((PBKDF2Params)localObject2).getSalt().length];
      getDefaultSecureRandom().nextBytes(arrayOfByte);
      this.hmacPkbdAlgorithm = new KeyDerivationFunc(this.hmacPkbdAlgorithm.getAlgorithm(), new PBKDF2Params(arrayOfByte, ((PBKDF2Params)localObject2).getIterationCount().intValue(), ((PBKDF2Params)localObject2).getKeyLength().intValue(), ((PBKDF2Params)localObject2).getPrf()));
      paramArrayOfChar = calculateMac(((EncryptedObjectStoreData)localObject1).getEncoded(), this.hmacAlgorithm, this.hmacPkbdAlgorithm, paramArrayOfChar);
      paramOutputStream.write(new ObjectStore((EncryptedObjectStoreData)localObject1, new ObjectStoreIntegrityCheck(new PbkdMacIntegrityCheck(this.hmacAlgorithm, this.hmacPkbdAlgorithm, paramArrayOfChar))).getEncoded());
      paramOutputStream.flush();
      return;
    }
    catch (InvalidKeyException paramOutputStream)
    {
      throw new IOException(paramOutputStream.toString());
    }
    catch (IllegalBlockSizeException paramOutputStream)
    {
      throw new IOException(paramOutputStream.toString());
    }
    catch (BadPaddingException paramOutputStream)
    {
      throw new IOException(paramOutputStream.toString());
    }
    catch (NoSuchPaddingException paramOutputStream)
    {
      throw new NoSuchAlgorithmException(paramOutputStream.toString());
    }
  }
  
  public static class Def
    extends BcFKSKeyStoreSpi
  {
    public Def()
    {
      super();
    }
  }
  
  private static class ExtKeyStoreException
    extends KeyStoreException
  {
    private final Throwable cause;
    
    ExtKeyStoreException(String paramString, Throwable paramThrowable)
    {
      super();
      this.cause = paramThrowable;
    }
    
    public Throwable getCause()
    {
      return this.cause;
    }
  }
  
  public static class Std
    extends BcFKSKeyStoreSpi
  {
    public Std()
    {
      super();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\keystore\bcfks\BcFKSKeyStoreSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */