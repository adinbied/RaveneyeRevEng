package org.bouncycastle.jcajce.provider.keystore.pkcs12;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore.LoadStoreParameter;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.InvalidKeySpecException;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.Vector;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.BEROctetString;
import org.bouncycastle.asn1.BEROutputStream;
import org.bouncycastle.asn1.DERBMPString;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.GOST28147Parameters;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.AuthenticatedSafe;
import org.bouncycastle.asn1.pkcs.CertBag;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.EncryptedData;
import org.bouncycastle.asn1.pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.EncryptionScheme;
import org.bouncycastle.asn1.pkcs.KeyDerivationFunc;
import org.bouncycastle.asn1.pkcs.MacData;
import org.bouncycastle.asn1.pkcs.PBES2Parameters;
import org.bouncycastle.asn1.pkcs.PBKDF2Params;
import org.bouncycastle.asn1.pkcs.PKCS12PBEParams;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.Pfx;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.pkcs.SafeBag;
import org.bouncycastle.asn1.util.ASN1Dump;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.AuthorityKeyIdentifier;
import org.bouncycastle.asn1.x509.DigestInfo;
import org.bouncycastle.asn1.x509.Extension;
import org.bouncycastle.asn1.x509.SubjectKeyIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.util.DigestFactory;
import org.bouncycastle.jcajce.PKCS12Key;
import org.bouncycastle.jcajce.PKCS12StoreParameter;
import org.bouncycastle.jcajce.spec.GOST28147ParameterSpec;
import org.bouncycastle.jcajce.spec.PBKDF2KeySpec;
import org.bouncycastle.jcajce.util.BCJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jce.interfaces.BCKeyStore;
import org.bouncycastle.jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.provider.JDKPKCS12StoreParameter;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.encoders.Hex;

public class PKCS12KeyStoreSpi
  extends KeyStoreSpi
  implements PKCSObjectIdentifiers, X509ObjectIdentifiers, BCKeyStore
{
  static final int CERTIFICATE = 1;
  static final int KEY = 2;
  static final int KEY_PRIVATE = 0;
  static final int KEY_PUBLIC = 1;
  static final int KEY_SECRET = 2;
  private static final int MIN_ITERATIONS = 1024;
  static final int NULL = 0;
  private static final int SALT_SIZE = 20;
  static final int SEALED = 4;
  static final int SECRET = 3;
  private static final DefaultSecretKeyProvider keySizeProvider = new DefaultSecretKeyProvider();
  private ASN1ObjectIdentifier certAlgorithm;
  private CertificateFactory certFact;
  private IgnoresCaseHashtable certs = new IgnoresCaseHashtable(null);
  private Hashtable chainCerts = new Hashtable();
  private final JcaJceHelper helper = new BCJcaJceHelper();
  private ASN1ObjectIdentifier keyAlgorithm;
  private Hashtable keyCerts = new Hashtable();
  private IgnoresCaseHashtable keys = new IgnoresCaseHashtable(null);
  private Hashtable localIds = new Hashtable();
  protected SecureRandom random = new SecureRandom();
  
  public PKCS12KeyStoreSpi(Provider paramProvider, ASN1ObjectIdentifier paramASN1ObjectIdentifier1, ASN1ObjectIdentifier paramASN1ObjectIdentifier2)
  {
    this.keyAlgorithm = paramASN1ObjectIdentifier1;
    this.certAlgorithm = paramASN1ObjectIdentifier2;
    if (paramProvider != null) {}
    for (;;)
    {
      try
      {
        paramProvider = CertificateFactory.getInstance("X.509", paramProvider);
        this.certFact = paramProvider;
        return;
      }
      catch (Exception paramProvider)
      {
        paramASN1ObjectIdentifier1 = new StringBuilder();
        paramASN1ObjectIdentifier1.append("can't create cert factory - ");
        paramASN1ObjectIdentifier1.append(paramProvider.toString());
        throw new IllegalArgumentException(paramASN1ObjectIdentifier1.toString());
      }
      paramProvider = CertificateFactory.getInstance("X.509");
    }
  }
  
  private byte[] calculatePbeMac(ASN1ObjectIdentifier paramASN1ObjectIdentifier, byte[] paramArrayOfByte1, int paramInt, char[] paramArrayOfChar, boolean paramBoolean, byte[] paramArrayOfByte2)
    throws Exception
  {
    paramArrayOfByte1 = new PBEParameterSpec(paramArrayOfByte1, paramInt);
    paramASN1ObjectIdentifier = this.helper.createMac(paramASN1ObjectIdentifier.getId());
    paramASN1ObjectIdentifier.init(new PKCS12Key(paramArrayOfChar, paramBoolean), paramArrayOfByte1);
    paramASN1ObjectIdentifier.update(paramArrayOfByte2);
    return paramASN1ObjectIdentifier.doFinal();
  }
  
  private Cipher createCipher(int paramInt, char[] paramArrayOfChar, AlgorithmIdentifier paramAlgorithmIdentifier)
    throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, InvalidAlgorithmParameterException, NoSuchProviderException
  {
    paramAlgorithmIdentifier = PBES2Parameters.getInstance(paramAlgorithmIdentifier.getParameters());
    Object localObject = PBKDF2Params.getInstance(paramAlgorithmIdentifier.getKeyDerivationFunc().getParameters());
    AlgorithmIdentifier localAlgorithmIdentifier = AlgorithmIdentifier.getInstance(paramAlgorithmIdentifier.getEncryptionScheme());
    SecretKeyFactory localSecretKeyFactory = this.helper.createSecretKeyFactory(paramAlgorithmIdentifier.getKeyDerivationFunc().getAlgorithm().getId());
    if (((PBKDF2Params)localObject).isDefaultPrf()) {
      paramArrayOfChar = localSecretKeyFactory.generateSecret(new PBEKeySpec(paramArrayOfChar, ((PBKDF2Params)localObject).getSalt(), ((PBKDF2Params)localObject).getIterationCount().intValue(), keySizeProvider.getKeySize(localAlgorithmIdentifier)));
    } else {
      paramArrayOfChar = localSecretKeyFactory.generateSecret(new PBKDF2KeySpec(paramArrayOfChar, ((PBKDF2Params)localObject).getSalt(), ((PBKDF2Params)localObject).getIterationCount().intValue(), keySizeProvider.getKeySize(localAlgorithmIdentifier), ((PBKDF2Params)localObject).getPrf()));
    }
    localObject = Cipher.getInstance(paramAlgorithmIdentifier.getEncryptionScheme().getAlgorithm().getId());
    AlgorithmIdentifier.getInstance(paramAlgorithmIdentifier.getEncryptionScheme());
    paramAlgorithmIdentifier = paramAlgorithmIdentifier.getEncryptionScheme().getParameters();
    if ((paramAlgorithmIdentifier instanceof ASN1OctetString))
    {
      paramAlgorithmIdentifier = new IvParameterSpec(ASN1OctetString.getInstance(paramAlgorithmIdentifier).getOctets());
    }
    else
    {
      paramAlgorithmIdentifier = GOST28147Parameters.getInstance(paramAlgorithmIdentifier);
      paramAlgorithmIdentifier = new GOST28147ParameterSpec(paramAlgorithmIdentifier.getEncryptionParamSet(), paramAlgorithmIdentifier.getIV());
    }
    ((Cipher)localObject).init(paramInt, paramArrayOfChar, paramAlgorithmIdentifier);
    return (Cipher)localObject;
  }
  
  private SubjectKeyIdentifier createSubjectKeyId(PublicKey paramPublicKey)
  {
    try
    {
      paramPublicKey = new SubjectKeyIdentifier(getDigest(SubjectPublicKeyInfo.getInstance(paramPublicKey.getEncoded())));
      return paramPublicKey;
    }
    catch (Exception paramPublicKey)
    {
      for (;;) {}
    }
    throw new RuntimeException("error creating key");
  }
  
  private void doStore(OutputStream paramOutputStream, char[] paramArrayOfChar, boolean paramBoolean)
    throws IOException
  {
    Object localObject1;
    Object localObject2;
    Object localObject4;
    Object localObject3;
    Object localObject6;
    Object localObject5;
    Object localObject7;
    int i;
    Object localObject8;
    Object localObject9;
    Object localObject10;
    Object localObject11;
    Object localObject12;
    ASN1EncodableVector localASN1EncodableVector;
    if (paramArrayOfChar != null)
    {
      localObject1 = new ASN1EncodableVector();
      localObject2 = this.keys.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        localObject4 = new byte[20];
        this.random.nextBytes((byte[])localObject4);
        localObject3 = (String)((Enumeration)localObject2).nextElement();
        localObject6 = (PrivateKey)this.keys.get((String)localObject3);
        localObject4 = new PKCS12PBEParams((byte[])localObject4, 1024);
        localObject5 = wrapKey(this.keyAlgorithm.getId(), (Key)localObject6, (PKCS12PBEParams)localObject4, paramArrayOfChar);
        localObject4 = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(this.keyAlgorithm, ((PKCS12PBEParams)localObject4).toASN1Primitive()), (byte[])localObject5);
        localObject5 = new ASN1EncodableVector();
        if ((localObject6 instanceof PKCS12BagAttributeCarrier))
        {
          localObject6 = (PKCS12BagAttributeCarrier)localObject6;
          localObject7 = (DERBMPString)((PKCS12BagAttributeCarrier)localObject6).getBagAttribute(pkcs_9_at_friendlyName);
          if ((localObject7 == null) || (!((DERBMPString)localObject7).getString().equals(localObject3))) {
            ((PKCS12BagAttributeCarrier)localObject6).setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString((String)localObject3));
          }
          if (((PKCS12BagAttributeCarrier)localObject6).getBagAttribute(pkcs_9_at_localKeyId) == null)
          {
            localObject7 = engineGetCertificate((String)localObject3);
            ((PKCS12BagAttributeCarrier)localObject6).setBagAttribute(pkcs_9_at_localKeyId, createSubjectKeyId(((Certificate)localObject7).getPublicKey()));
          }
          localObject7 = ((PKCS12BagAttributeCarrier)localObject6).getBagAttributeKeys();
          for (i = 0; ((Enumeration)localObject7).hasMoreElements(); i = 1)
          {
            localObject8 = (ASN1ObjectIdentifier)((Enumeration)localObject7).nextElement();
            localObject9 = new ASN1EncodableVector();
            ((ASN1EncodableVector)localObject9).add((ASN1Encodable)localObject8);
            ((ASN1EncodableVector)localObject9).add(new DERSet(((PKCS12BagAttributeCarrier)localObject6).getBagAttribute((ASN1ObjectIdentifier)localObject8)));
            ((ASN1EncodableVector)localObject5).add(new DERSequence((ASN1EncodableVector)localObject9));
          }
        }
        i = 0;
        if (i == 0)
        {
          localObject6 = new ASN1EncodableVector();
          localObject7 = engineGetCertificate((String)localObject3);
          ((ASN1EncodableVector)localObject6).add(pkcs_9_at_localKeyId);
          ((ASN1EncodableVector)localObject6).add(new DERSet(createSubjectKeyId(((Certificate)localObject7).getPublicKey())));
          ((ASN1EncodableVector)localObject5).add(new DERSequence((ASN1EncodableVector)localObject6));
          localObject6 = new ASN1EncodableVector();
          ((ASN1EncodableVector)localObject6).add(pkcs_9_at_friendlyName);
          ((ASN1EncodableVector)localObject6).add(new DERSet(new DERBMPString((String)localObject3)));
          ((ASN1EncodableVector)localObject5).add(new DERSequence((ASN1EncodableVector)localObject6));
        }
        ((ASN1EncodableVector)localObject1).add(new SafeBag(pkcs8ShroudedKeyBag, ((EncryptedPrivateKeyInfo)localObject4).toASN1Primitive(), new DERSet((ASN1EncodableVector)localObject5)));
      }
      localObject4 = new BEROctetString(new DERSequence((ASN1EncodableVector)localObject1).getEncoded("DER"));
      localObject1 = new byte[20];
      this.random.nextBytes((byte[])localObject1);
      localObject5 = new ASN1EncodableVector();
      localObject1 = new PKCS12PBEParams((byte[])localObject1, 1024);
      localObject6 = new AlgorithmIdentifier(this.certAlgorithm, ((PKCS12PBEParams)localObject1).toASN1Primitive());
      localObject3 = new Hashtable();
      localObject1 = this.keys.keys();
      while (((Enumeration)localObject1).hasMoreElements()) {
        try
        {
          localObject7 = (String)((Enumeration)localObject1).nextElement();
          localObject8 = engineGetCertificate((String)localObject7);
          localObject9 = new CertBag(x509Certificate, new DEROctetString(((Certificate)localObject8).getEncoded()));
          localObject10 = new ASN1EncodableVector();
          if (!(localObject8 instanceof PKCS12BagAttributeCarrier)) {
            break label2089;
          }
          localObject11 = (PKCS12BagAttributeCarrier)localObject8;
          localObject2 = (DERBMPString)((PKCS12BagAttributeCarrier)localObject11).getBagAttribute(pkcs_9_at_friendlyName);
          if (localObject2 != null) {
            if (((DERBMPString)localObject2).getString().equals(localObject7)) {
              break label2086;
            }
          }
          ((PKCS12BagAttributeCarrier)localObject11).setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString((String)localObject7));
          if (((PKCS12BagAttributeCarrier)localObject11).getBagAttribute(pkcs_9_at_localKeyId) == null) {
            ((PKCS12BagAttributeCarrier)localObject11).setBagAttribute(pkcs_9_at_localKeyId, createSubjectKeyId(((Certificate)localObject8).getPublicKey()));
          }
          localObject2 = ((PKCS12BagAttributeCarrier)localObject11).getBagAttributeKeys();
          for (i = 0; ((Enumeration)localObject2).hasMoreElements(); i = 1)
          {
            localObject12 = (ASN1ObjectIdentifier)((Enumeration)localObject2).nextElement();
            localASN1EncodableVector = new ASN1EncodableVector();
            localASN1EncodableVector.add((ASN1Encodable)localObject12);
            localASN1EncodableVector.add(new DERSet(((PKCS12BagAttributeCarrier)localObject11).getBagAttribute((ASN1ObjectIdentifier)localObject12)));
            ((ASN1EncodableVector)localObject10).add(new DERSequence(localASN1EncodableVector));
          }
          label845:
          if (i == 0)
          {
            localObject2 = new ASN1EncodableVector();
            ((ASN1EncodableVector)localObject2).add(pkcs_9_at_localKeyId);
            ((ASN1EncodableVector)localObject2).add(new DERSet(createSubjectKeyId(((Certificate)localObject8).getPublicKey())));
            ((ASN1EncodableVector)localObject10).add(new DERSequence((ASN1EncodableVector)localObject2));
            localObject2 = new ASN1EncodableVector();
            ((ASN1EncodableVector)localObject2).add(pkcs_9_at_friendlyName);
            ((ASN1EncodableVector)localObject2).add(new DERSet(new DERBMPString((String)localObject7)));
            ((ASN1EncodableVector)localObject10).add(new DERSequence((ASN1EncodableVector)localObject2));
          }
          ((ASN1EncodableVector)localObject5).add(new SafeBag(certBag, ((CertBag)localObject9).toASN1Primitive(), new DERSet((ASN1EncodableVector)localObject10)));
          ((Hashtable)localObject3).put(localObject8, localObject8);
        }
        catch (CertificateEncodingException paramOutputStream)
        {
          paramArrayOfChar = new StringBuilder();
          paramArrayOfChar.append("Error encoding certificate: ");
          paramArrayOfChar.append(paramOutputStream.toString());
          throw new IOException(paramArrayOfChar.toString());
        }
      }
      localObject1 = this.certs.keys();
      label1043:
      if (!((Enumeration)localObject1).hasMoreElements()) {}
    }
    for (;;)
    {
      try
      {
        localObject7 = (String)((Enumeration)localObject1).nextElement();
        localObject8 = (Certificate)this.certs.get((String)localObject7);
        if (this.keys.get((String)localObject7) != null) {
          break label1043;
        }
        localObject9 = new CertBag(x509Certificate, new DEROctetString(((Certificate)localObject8).getEncoded()));
        localObject10 = new ASN1EncodableVector();
        if (!(localObject8 instanceof PKCS12BagAttributeCarrier)) {
          break label2098;
        }
        localObject11 = (PKCS12BagAttributeCarrier)localObject8;
        localObject2 = (DERBMPString)((PKCS12BagAttributeCarrier)localObject11).getBagAttribute(pkcs_9_at_friendlyName);
        if ((localObject2 == null) || (!((DERBMPString)localObject2).getString().equals(localObject7))) {
          ((PKCS12BagAttributeCarrier)localObject11).setBagAttribute(pkcs_9_at_friendlyName, new DERBMPString((String)localObject7));
        }
        localObject2 = ((PKCS12BagAttributeCarrier)localObject11).getBagAttributeKeys();
        i = 0;
        if (!((Enumeration)localObject2).hasMoreElements()) {
          break label2095;
        }
        localObject12 = (ASN1ObjectIdentifier)((Enumeration)localObject2).nextElement();
        if (((ASN1ObjectIdentifier)localObject12).equals(PKCSObjectIdentifiers.pkcs_9_at_localKeyId)) {
          continue;
        }
        localASN1EncodableVector = new ASN1EncodableVector();
        localASN1EncodableVector.add((ASN1Encodable)localObject12);
        localASN1EncodableVector.add(new DERSet(((PKCS12BagAttributeCarrier)localObject11).getBagAttribute((ASN1ObjectIdentifier)localObject12)));
        ((ASN1EncodableVector)localObject10).add(new DERSequence(localASN1EncodableVector));
        i = 1;
        continue;
        if (i == 0)
        {
          localObject2 = new ASN1EncodableVector();
          ((ASN1EncodableVector)localObject2).add(pkcs_9_at_friendlyName);
          ((ASN1EncodableVector)localObject2).add(new DERSet(new DERBMPString((String)localObject7)));
          ((ASN1EncodableVector)localObject10).add(new DERSequence((ASN1EncodableVector)localObject2));
        }
        ((ASN1EncodableVector)localObject5).add(new SafeBag(certBag, ((CertBag)localObject9).toASN1Primitive(), new DERSet((ASN1EncodableVector)localObject10)));
        ((Hashtable)localObject3).put(localObject8, localObject8);
      }
      catch (CertificateEncodingException paramOutputStream)
      {
        paramArrayOfChar = new StringBuilder();
        paramArrayOfChar.append("Error encoding certificate: ");
        paramArrayOfChar.append(paramOutputStream.toString());
        throw new IOException(paramArrayOfChar.toString());
      }
      localObject7 = getUsedCertificateSet();
      localObject8 = this.chainCerts.keys();
      localObject1 = localObject3;
      while (((Enumeration)localObject8).hasMoreElements()) {
        try
        {
          localObject2 = (CertId)((Enumeration)localObject8).nextElement();
          localObject10 = (Certificate)this.chainCerts.get(localObject2);
          if ((((Set)localObject7).contains(localObject10)) && (((Hashtable)localObject1).get(localObject10) == null))
          {
            localObject3 = new CertBag(x509Certificate, new DEROctetString(((Certificate)localObject10).getEncoded()));
            localObject9 = new ASN1EncodableVector();
            localObject2 = localObject1;
            if ((localObject10 instanceof PKCS12BagAttributeCarrier))
            {
              localObject10 = (PKCS12BagAttributeCarrier)localObject10;
              localObject11 = ((PKCS12BagAttributeCarrier)localObject10).getBagAttributeKeys();
              for (;;)
              {
                localObject2 = localObject1;
                if (!((Enumeration)localObject11).hasMoreElements()) {
                  break;
                }
                localObject2 = (ASN1ObjectIdentifier)((Enumeration)localObject11).nextElement();
                if (!((ASN1ObjectIdentifier)localObject2).equals(PKCSObjectIdentifiers.pkcs_9_at_localKeyId))
                {
                  localObject12 = new ASN1EncodableVector();
                  ((ASN1EncodableVector)localObject12).add((ASN1Encodable)localObject2);
                  ((ASN1EncodableVector)localObject12).add(new DERSet(((PKCS12BagAttributeCarrier)localObject10).getBagAttribute((ASN1ObjectIdentifier)localObject2)));
                  ((ASN1EncodableVector)localObject9).add(new DERSequence((ASN1EncodableVector)localObject12));
                }
              }
            }
            ((ASN1EncodableVector)localObject5).add(new SafeBag(certBag, ((CertBag)localObject3).toASN1Primitive(), new DERSet((ASN1EncodableVector)localObject9)));
            localObject1 = localObject2;
          }
        }
        catch (CertificateEncodingException paramOutputStream)
        {
          paramArrayOfChar = new StringBuilder();
          paramArrayOfChar.append("Error encoding certificate: ");
          paramArrayOfChar.append(paramOutputStream.toString());
          throw new IOException(paramArrayOfChar.toString());
        }
      }
      localObject1 = cryptData(true, (AlgorithmIdentifier)localObject6, paramArrayOfChar, false, new DERSequence((ASN1EncodableVector)localObject5).getEncoded("DER"));
      localObject1 = new EncryptedData(data, (AlgorithmIdentifier)localObject6, new BEROctetString((byte[])localObject1));
      localObject2 = new AuthenticatedSafe(new ContentInfo[] { new ContentInfo(data, (ASN1Encodable)localObject4), new ContentInfo(encryptedData, ((EncryptedData)localObject1).toASN1Primitive()) });
      localObject3 = new ByteArrayOutputStream();
      if (paramBoolean) {
        localObject1 = new DEROutputStream((OutputStream)localObject3);
      } else {
        localObject1 = new BEROutputStream((OutputStream)localObject3);
      }
      ((DEROutputStream)localObject1).writeObject((ASN1Encodable)localObject2);
      localObject1 = ((ByteArrayOutputStream)localObject3).toByteArray();
      localObject1 = new ContentInfo(data, new BEROctetString((byte[])localObject1));
      localObject2 = new byte[20];
      this.random.nextBytes((byte[])localObject2);
      localObject3 = ((ASN1OctetString)((ContentInfo)localObject1).getContent()).getOctets();
      try
      {
        paramArrayOfChar = calculatePbeMac(id_SHA1, (byte[])localObject2, 1024, paramArrayOfChar, false, (byte[])localObject3);
        paramArrayOfChar = new MacData(new DigestInfo(new AlgorithmIdentifier(id_SHA1, DERNull.INSTANCE), paramArrayOfChar), (byte[])localObject2, 1024);
        paramArrayOfChar = new Pfx((ContentInfo)localObject1, paramArrayOfChar);
        if (paramBoolean) {
          paramOutputStream = new DEROutputStream(paramOutputStream);
        } else {
          paramOutputStream = new BEROutputStream(paramOutputStream);
        }
        paramOutputStream.writeObject(paramArrayOfChar);
        return;
      }
      catch (Exception paramOutputStream)
      {
        paramArrayOfChar = new StringBuilder();
        paramArrayOfChar.append("error constructing MAC: ");
        paramArrayOfChar.append(paramOutputStream.toString());
        throw new IOException(paramArrayOfChar.toString());
      }
      throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
      label2086:
      break;
      label2089:
      i = 0;
      break label845;
      label2095:
      continue;
      label2098:
      i = 0;
    }
  }
  
  private static byte[] getDigest(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
  {
    Digest localDigest = DigestFactory.createSHA1();
    byte[] arrayOfByte = new byte[localDigest.getDigestSize()];
    paramSubjectPublicKeyInfo = paramSubjectPublicKeyInfo.getPublicKeyData().getBytes();
    localDigest.update(paramSubjectPublicKeyInfo, 0, paramSubjectPublicKeyInfo.length);
    localDigest.doFinal(arrayOfByte, 0);
    return arrayOfByte;
  }
  
  private Set getUsedCertificateSet()
  {
    HashSet localHashSet = new HashSet();
    Enumeration localEnumeration = this.keys.keys();
    while (localEnumeration.hasMoreElements())
    {
      Certificate[] arrayOfCertificate = engineGetCertificateChain((String)localEnumeration.nextElement());
      int i = 0;
      while (i != arrayOfCertificate.length)
      {
        localHashSet.add(arrayOfCertificate[i]);
        i += 1;
      }
    }
    localEnumeration = this.certs.keys();
    while (localEnumeration.hasMoreElements()) {
      localHashSet.add(engineGetCertificate((String)localEnumeration.nextElement()));
    }
    return localHashSet;
  }
  
  protected byte[] cryptData(boolean paramBoolean1, AlgorithmIdentifier paramAlgorithmIdentifier, char[] paramArrayOfChar, boolean paramBoolean2, byte[] paramArrayOfByte)
    throws IOException
  {
    Object localObject = paramAlgorithmIdentifier.getAlgorithm();
    int i;
    if (paramBoolean1) {
      i = 1;
    } else {
      i = 2;
    }
    if (((ASN1ObjectIdentifier)localObject).on(PKCSObjectIdentifiers.pkcs_12PbeIds))
    {
      paramAlgorithmIdentifier = PKCS12PBEParams.getInstance(paramAlgorithmIdentifier.getParameters());
      new PBEKeySpec(paramArrayOfChar);
      try
      {
        paramAlgorithmIdentifier = new PBEParameterSpec(paramAlgorithmIdentifier.getIV(), paramAlgorithmIdentifier.getIterations().intValue());
        paramArrayOfChar = new PKCS12Key(paramArrayOfChar, paramBoolean2);
        localObject = this.helper.createCipher(((ASN1ObjectIdentifier)localObject).getId());
        ((Cipher)localObject).init(i, paramArrayOfChar, paramAlgorithmIdentifier);
        paramAlgorithmIdentifier = ((Cipher)localObject).doFinal(paramArrayOfByte);
        return paramAlgorithmIdentifier;
      }
      catch (Exception paramAlgorithmIdentifier)
      {
        paramArrayOfChar = new StringBuilder();
        paramArrayOfChar.append("exception decrypting data - ");
        paramArrayOfChar.append(paramAlgorithmIdentifier.toString());
        throw new IOException(paramArrayOfChar.toString());
      }
    }
    if (((ASN1ObjectIdentifier)localObject).equals(PKCSObjectIdentifiers.id_PBES2)) {
      try
      {
        paramAlgorithmIdentifier = createCipher(i, paramArrayOfChar, paramAlgorithmIdentifier).doFinal(paramArrayOfByte);
        return paramAlgorithmIdentifier;
      }
      catch (Exception paramAlgorithmIdentifier)
      {
        paramArrayOfChar = new StringBuilder();
        paramArrayOfChar.append("exception decrypting data - ");
        paramArrayOfChar.append(paramAlgorithmIdentifier.toString());
        throw new IOException(paramArrayOfChar.toString());
      }
    }
    paramAlgorithmIdentifier = new StringBuilder();
    paramAlgorithmIdentifier.append("unknown PBE algorithm: ");
    paramAlgorithmIdentifier.append(localObject);
    throw new IOException(paramAlgorithmIdentifier.toString());
  }
  
  public Enumeration engineAliases()
  {
    Hashtable localHashtable = new Hashtable();
    Enumeration localEnumeration = this.certs.keys();
    while (localEnumeration.hasMoreElements()) {
      localHashtable.put(localEnumeration.nextElement(), "cert");
    }
    localEnumeration = this.keys.keys();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      if (localHashtable.get(str) == null) {
        localHashtable.put(str, "key");
      }
    }
    return localHashtable.keys();
  }
  
  public boolean engineContainsAlias(String paramString)
  {
    return (this.certs.get(paramString) != null) || (this.keys.get(paramString) != null);
  }
  
  public void engineDeleteEntry(String paramString)
    throws KeyStoreException
  {
    Object localObject = (Key)this.keys.remove(paramString);
    Certificate localCertificate = (Certificate)this.certs.remove(paramString);
    if (localCertificate != null) {
      this.chainCerts.remove(new CertId(localCertificate.getPublicKey()));
    }
    if (localObject != null)
    {
      localObject = (String)this.localIds.remove(paramString);
      paramString = localCertificate;
      if (localObject != null) {
        paramString = (Certificate)this.keyCerts.remove(localObject);
      }
      if (paramString != null) {
        this.chainCerts.remove(new CertId(paramString.getPublicKey()));
      }
    }
  }
  
  public Certificate engineGetCertificate(String paramString)
  {
    if (paramString != null)
    {
      Certificate localCertificate = (Certificate)this.certs.get(paramString);
      Object localObject = localCertificate;
      if (localCertificate == null)
      {
        localObject = (String)this.localIds.get(paramString);
        if (localObject != null) {
          paramString = this.keyCerts.get(localObject);
        } else {
          paramString = this.keyCerts.get(paramString);
        }
        localObject = (Certificate)paramString;
      }
      return (Certificate)localObject;
    }
    throw new IllegalArgumentException("null alias passed to getCertificate.");
  }
  
  public String engineGetCertificateAlias(Certificate paramCertificate)
  {
    Enumeration localEnumeration1 = this.certs.elements();
    Enumeration localEnumeration2 = this.certs.keys();
    Certificate localCertificate;
    String str;
    while (localEnumeration1.hasMoreElements())
    {
      localCertificate = (Certificate)localEnumeration1.nextElement();
      str = (String)localEnumeration2.nextElement();
      if (localCertificate.equals(paramCertificate)) {
        return str;
      }
    }
    localEnumeration1 = this.keyCerts.elements();
    localEnumeration2 = this.keyCerts.keys();
    while (localEnumeration1.hasMoreElements())
    {
      localCertificate = (Certificate)localEnumeration1.nextElement();
      str = (String)localEnumeration2.nextElement();
      if (localCertificate.equals(paramCertificate)) {
        return str;
      }
    }
    return null;
  }
  
  public Certificate[] engineGetCertificateChain(String paramString)
  {
    if (paramString != null)
    {
      boolean bool = engineIsKeyEntry(paramString);
      Object localObject2 = null;
      if (!bool) {
        return null;
      }
      Object localObject1 = engineGetCertificate(paramString);
      paramString = (String)localObject2;
      if (localObject1 != null)
      {
        Vector localVector = new Vector();
        paramString = (String)localObject1;
        while (paramString != null)
        {
          X509Certificate localX509Certificate = (X509Certificate)paramString;
          localObject1 = localX509Certificate.getExtensionValue(Extension.authorityKeyIdentifier.getId());
          if (localObject1 != null) {
            try
            {
              localObject1 = AuthorityKeyIdentifier.getInstance(new ASN1InputStream(((ASN1OctetString)new ASN1InputStream((byte[])localObject1).readObject()).getOctets()).readObject());
              if (((AuthorityKeyIdentifier)localObject1).getKeyIdentifier() != null) {
                localObject1 = (Certificate)this.chainCerts.get(new CertId(((AuthorityKeyIdentifier)localObject1).getKeyIdentifier()));
              }
            }
            catch (IOException paramString)
            {
              throw new RuntimeException(paramString.toString());
            }
          }
          localObject1 = null;
          localObject2 = localObject1;
          if (localObject1 == null)
          {
            Principal localPrincipal = localX509Certificate.getIssuerDN();
            localObject2 = localObject1;
            if (!localPrincipal.equals(localX509Certificate.getSubjectDN()))
            {
              Enumeration localEnumeration = this.chainCerts.keys();
              for (;;)
              {
                localObject2 = localObject1;
                if (!localEnumeration.hasMoreElements()) {
                  break;
                }
                localObject2 = (X509Certificate)this.chainCerts.get(localEnumeration.nextElement());
                if (((X509Certificate)localObject2).getSubjectDN().equals(localPrincipal)) {}
                try
                {
                  localX509Certificate.verify(((X509Certificate)localObject2).getPublicKey());
                }
                catch (Exception localException)
                {
                  int j;
                  int i;
                  for (;;) {}
                }
              }
            }
          }
          if (localVector.contains(paramString)) {}
          do
          {
            paramString = null;
            break;
            localVector.addElement(paramString);
          } while (localObject2 == paramString);
          paramString = (String)localObject2;
        }
        j = localVector.size();
        localObject1 = new Certificate[j];
        i = 0;
        for (;;)
        {
          paramString = (String)localObject1;
          if (i == j) {
            break;
          }
          localObject1[i] = ((Certificate)localVector.elementAt(i));
          i += 1;
        }
      }
      return paramString;
    }
    throw new IllegalArgumentException("null alias passed to getCertificateChain.");
  }
  
  public Date engineGetCreationDate(String paramString)
  {
    if (paramString != null)
    {
      if ((this.keys.get(paramString) == null) && (this.certs.get(paramString) == null)) {
        return null;
      }
      return new Date();
    }
    throw new NullPointerException("alias == null");
  }
  
  public Key engineGetKey(String paramString, char[] paramArrayOfChar)
    throws NoSuchAlgorithmException, UnrecoverableKeyException
  {
    if (paramString != null) {
      return (Key)this.keys.get(paramString);
    }
    throw new IllegalArgumentException("null alias passed to getKey.");
  }
  
  public boolean engineIsCertificateEntry(String paramString)
  {
    return (this.certs.get(paramString) != null) && (this.keys.get(paramString) == null);
  }
  
  public boolean engineIsKeyEntry(String paramString)
  {
    return this.keys.get(paramString) != null;
  }
  
  public void engineLoad(InputStream paramInputStream, char[] paramArrayOfChar)
    throws IOException
  {
    if (paramInputStream == null) {
      return;
    }
    if (paramArrayOfChar != null)
    {
      paramInputStream = new BufferedInputStream(paramInputStream);
      paramInputStream.mark(10);
      if (paramInputStream.read() == 48)
      {
        paramInputStream.reset();
        Object localObject1 = Pfx.getInstance((ASN1Sequence)new ASN1InputStream(paramInputStream).readObject());
        paramInputStream = ((Pfx)localObject1).getAuthSafe();
        Vector localVector = new Vector();
        Object localObject4;
        Object localObject3;
        Object localObject2;
        Object localObject5;
        int j;
        if (((Pfx)localObject1).getMacData() != null)
        {
          localObject4 = ((Pfx)localObject1).getMacData();
          localObject3 = ((MacData)localObject4).getMac();
          localObject1 = ((DigestInfo)localObject3).getAlgorithmId();
          localObject2 = ((MacData)localObject4).getSalt();
          i = ((MacData)localObject4).getIterationCount().intValue();
          localObject4 = ((ASN1OctetString)paramInputStream.getContent()).getOctets();
          try
          {
            localObject5 = calculatePbeMac(((AlgorithmIdentifier)localObject1).getAlgorithm(), (byte[])localObject2, i, paramArrayOfChar, false, (byte[])localObject4);
            localObject3 = ((DigestInfo)localObject3).getDigest();
            if (!Arrays.constantTimeAreEqual((byte[])localObject5, (byte[])localObject3))
            {
              j = paramArrayOfChar.length;
              if (j <= 0)
              {
                if (Arrays.constantTimeAreEqual(calculatePbeMac(((AlgorithmIdentifier)localObject1).getAlgorithm(), (byte[])localObject2, i, paramArrayOfChar, true, (byte[])localObject4), (byte[])localObject3))
                {
                  bool = true;
                  break label268;
                }
                throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
              }
              throw new IOException("PKCS12 key store mac invalid - wrong password or corrupted file.");
            }
          }
          catch (Exception paramInputStream)
          {
            paramArrayOfChar = new StringBuilder();
            paramArrayOfChar.append("error constructing MAC: ");
            paramArrayOfChar.append(paramInputStream.toString());
            throw new IOException(paramArrayOfChar.toString());
          }
          catch (IOException paramInputStream)
          {
            throw paramInputStream;
          }
        }
        boolean bool = false;
        label268:
        this.keys = new IgnoresCaseHashtable(null);
        this.localIds = new Hashtable();
        Object localObject6;
        if (paramInputStream.getContentType().equals(data))
        {
          localObject5 = AuthenticatedSafe.getInstance(new ASN1InputStream(((ASN1OctetString)paramInputStream.getContent()).getOctets()).readObject()).getContentInfo();
          j = 0;
          i = 0;
          for (;;)
          {
            k = i;
            if (j == localObject5.length) {
              break;
            }
            Object localObject7;
            Object localObject8;
            Object localObject9;
            if (localObject5[j].getContentType().equals(data))
            {
              localObject4 = (ASN1Sequence)new ASN1InputStream(((ASN1OctetString)localObject5[j].getContent()).getOctets()).readObject();
              k = 0;
              while (k != ((ASN1Sequence)localObject4).size())
              {
                paramInputStream = SafeBag.getInstance(((ASN1Sequence)localObject4).getObjectAt(k));
                if (paramInputStream.getBagId().equals(pkcs8ShroudedKeyBag))
                {
                  localObject1 = EncryptedPrivateKeyInfo.getInstance(paramInputStream.getBagValue());
                  localObject6 = unwrapKey(((EncryptedPrivateKeyInfo)localObject1).getEncryptionAlgorithm(), ((EncryptedPrivateKeyInfo)localObject1).getEncryptedData(), paramArrayOfChar, bool);
                  localObject7 = (PKCS12BagAttributeCarrier)localObject6;
                  if (paramInputStream.getBagAttributes() != null)
                  {
                    localObject8 = paramInputStream.getBagAttributes().getObjects();
                    localObject1 = null;
                    paramInputStream = (InputStream)localObject1;
                    while (((Enumeration)localObject8).hasMoreElements())
                    {
                      localObject2 = (ASN1Sequence)((Enumeration)localObject8).nextElement();
                      localObject9 = (ASN1ObjectIdentifier)((ASN1Sequence)localObject2).getObjectAt(0);
                      localObject2 = (ASN1Set)((ASN1Sequence)localObject2).getObjectAt(1);
                      if (((ASN1Set)localObject2).size() > 0)
                      {
                        localObject2 = (ASN1Primitive)((ASN1Set)localObject2).getObjectAt(0);
                        localObject3 = ((PKCS12BagAttributeCarrier)localObject7).getBagAttribute((ASN1ObjectIdentifier)localObject9);
                        if (localObject3 != null)
                        {
                          if (!((ASN1Encodable)localObject3).toASN1Primitive().equals(localObject2)) {
                            throw new IOException("attempt to add existing attribute with different value");
                          }
                        }
                        else {
                          ((PKCS12BagAttributeCarrier)localObject7).setBagAttribute((ASN1ObjectIdentifier)localObject9, (ASN1Encodable)localObject2);
                        }
                      }
                      else
                      {
                        localObject2 = null;
                      }
                      if (((ASN1ObjectIdentifier)localObject9).equals(pkcs_9_at_friendlyName))
                      {
                        localObject3 = ((DERBMPString)localObject2).getString();
                        this.keys.put((String)localObject3, localObject6);
                      }
                      else
                      {
                        localObject3 = localObject1;
                        if (((ASN1ObjectIdentifier)localObject9).equals(pkcs_9_at_localKeyId))
                        {
                          paramInputStream = (ASN1OctetString)localObject2;
                          localObject3 = localObject1;
                        }
                      }
                      localObject1 = localObject3;
                    }
                  }
                  else
                  {
                    localObject1 = null;
                    paramInputStream = null;
                  }
                  if (paramInputStream != null)
                  {
                    paramInputStream = new String(Hex.encode(paramInputStream.getOctets()));
                    if (localObject1 == null) {
                      this.keys.put(paramInputStream, localObject6);
                    } else {
                      this.localIds.put(localObject1, paramInputStream);
                    }
                  }
                  else
                  {
                    this.keys.put("unmarked", localObject6);
                    i = 1;
                  }
                }
                else if (paramInputStream.getBagId().equals(certBag))
                {
                  localVector.addElement(paramInputStream);
                }
                else
                {
                  localObject1 = System.out;
                  localObject2 = new StringBuilder();
                  ((StringBuilder)localObject2).append("extra in data ");
                  ((StringBuilder)localObject2).append(paramInputStream.getBagId());
                  ((PrintStream)localObject1).println(((StringBuilder)localObject2).toString());
                  System.out.println(ASN1Dump.dumpAsString(paramInputStream));
                }
                k += 1;
              }
            }
            else if (localObject5[j].getContentType().equals(encryptedData))
            {
              paramInputStream = EncryptedData.getInstance(localObject5[j].getContent());
              paramInputStream = (ASN1Sequence)ASN1Primitive.fromByteArray(cryptData(false, paramInputStream.getEncryptionAlgorithm(), paramArrayOfChar, bool, paramInputStream.getContent().getOctets()));
              k = 0;
              while (k != paramInputStream.size())
              {
                localObject1 = SafeBag.getInstance(paramInputStream.getObjectAt(k));
                if (((SafeBag)localObject1).getBagId().equals(certBag))
                {
                  localVector.addElement(localObject1);
                }
                else if (((SafeBag)localObject1).getBagId().equals(pkcs8ShroudedKeyBag))
                {
                  localObject2 = EncryptedPrivateKeyInfo.getInstance(((SafeBag)localObject1).getBagValue());
                  localObject6 = unwrapKey(((EncryptedPrivateKeyInfo)localObject2).getEncryptionAlgorithm(), ((EncryptedPrivateKeyInfo)localObject2).getEncryptedData(), paramArrayOfChar, bool);
                  localObject7 = (PKCS12BagAttributeCarrier)localObject6;
                  localObject8 = ((SafeBag)localObject1).getBagAttributes().getObjects();
                  localObject2 = null;
                  for (localObject1 = null; ((Enumeration)localObject8).hasMoreElements(); localObject1 = localObject3)
                  {
                    localObject3 = (ASN1Sequence)((Enumeration)localObject8).nextElement();
                    localObject9 = (ASN1ObjectIdentifier)((ASN1Sequence)localObject3).getObjectAt(0);
                    localObject3 = (ASN1Set)((ASN1Sequence)localObject3).getObjectAt(1);
                    if (((ASN1Set)localObject3).size() > 0)
                    {
                      localObject4 = (ASN1Primitive)((ASN1Set)localObject3).getObjectAt(0);
                      localObject3 = ((PKCS12BagAttributeCarrier)localObject7).getBagAttribute((ASN1ObjectIdentifier)localObject9);
                      if (localObject3 != null)
                      {
                        if (!((ASN1Encodable)localObject3).toASN1Primitive().equals(localObject4)) {
                          throw new IOException("attempt to add existing attribute with different value");
                        }
                      }
                      else {
                        ((PKCS12BagAttributeCarrier)localObject7).setBagAttribute((ASN1ObjectIdentifier)localObject9, (ASN1Encodable)localObject4);
                      }
                    }
                    else
                    {
                      localObject4 = null;
                    }
                    if (((ASN1ObjectIdentifier)localObject9).equals(pkcs_9_at_friendlyName))
                    {
                      localObject3 = ((DERBMPString)localObject4).getString();
                      this.keys.put((String)localObject3, localObject6);
                    }
                    else
                    {
                      localObject3 = localObject1;
                      if (((ASN1ObjectIdentifier)localObject9).equals(pkcs_9_at_localKeyId))
                      {
                        localObject2 = (ASN1OctetString)localObject4;
                        localObject3 = localObject1;
                      }
                    }
                  }
                  localObject2 = new String(Hex.encode(((ASN1OctetString)localObject2).getOctets()));
                  if (localObject1 == null) {
                    this.keys.put((String)localObject2, localObject6);
                  } else {
                    this.localIds.put(localObject1, localObject2);
                  }
                }
                else if (((SafeBag)localObject1).getBagId().equals(keyBag))
                {
                  localObject3 = BouncyCastleProvider.getPrivateKey(PrivateKeyInfo.getInstance(((SafeBag)localObject1).getBagValue()));
                  localObject4 = (PKCS12BagAttributeCarrier)localObject3;
                  localObject6 = ((SafeBag)localObject1).getBagAttributes().getObjects();
                  localObject2 = null;
                  localObject1 = null;
                  while (((Enumeration)localObject6).hasMoreElements())
                  {
                    localObject8 = ASN1Sequence.getInstance(((Enumeration)localObject6).nextElement());
                    localObject7 = ASN1ObjectIdentifier.getInstance(((ASN1Sequence)localObject8).getObjectAt(0));
                    localObject8 = ASN1Set.getInstance(((ASN1Sequence)localObject8).getObjectAt(1));
                    if (((ASN1Set)localObject8).size() > 0)
                    {
                      localObject8 = (ASN1Primitive)((ASN1Set)localObject8).getObjectAt(0);
                      localObject9 = ((PKCS12BagAttributeCarrier)localObject4).getBagAttribute((ASN1ObjectIdentifier)localObject7);
                      if (localObject9 != null)
                      {
                        if (!((ASN1Encodable)localObject9).toASN1Primitive().equals(localObject8)) {
                          throw new IOException("attempt to add existing attribute with different value");
                        }
                      }
                      else {
                        ((PKCS12BagAttributeCarrier)localObject4).setBagAttribute((ASN1ObjectIdentifier)localObject7, (ASN1Encodable)localObject8);
                      }
                      if (((ASN1ObjectIdentifier)localObject7).equals(pkcs_9_at_friendlyName))
                      {
                        localObject1 = ((DERBMPString)localObject8).getString();
                        this.keys.put((String)localObject1, localObject3);
                      }
                      else if (((ASN1ObjectIdentifier)localObject7).equals(pkcs_9_at_localKeyId))
                      {
                        localObject2 = (ASN1OctetString)localObject8;
                      }
                    }
                  }
                  localObject2 = new String(Hex.encode(((ASN1OctetString)localObject2).getOctets()));
                  if (localObject1 == null) {
                    this.keys.put((String)localObject2, localObject3);
                  } else {
                    this.localIds.put(localObject1, localObject2);
                  }
                }
                else
                {
                  localObject2 = System.out;
                  localObject3 = new StringBuilder();
                  ((StringBuilder)localObject3).append("extra in encryptedData ");
                  ((StringBuilder)localObject3).append(((SafeBag)localObject1).getBagId());
                  ((PrintStream)localObject2).println(((StringBuilder)localObject3).toString());
                  System.out.println(ASN1Dump.dumpAsString(localObject1));
                }
                k += 1;
              }
            }
            else
            {
              k = j;
              paramInputStream = System.out;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("extra ");
              ((StringBuilder)localObject1).append(localObject5[k].getContentType().getId());
              paramInputStream.println(((StringBuilder)localObject1).toString());
              paramInputStream = System.out;
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append("extra ");
              ((StringBuilder)localObject1).append(ASN1Dump.dumpAsString(localObject5[k].getContent()));
              paramInputStream.println(((StringBuilder)localObject1).toString());
            }
            j += 1;
          }
        }
        int k = 0;
        this.certs = new IgnoresCaseHashtable(null);
        this.chainCerts = new Hashtable();
        this.keyCerts = new Hashtable();
        int i = 0;
        for (;;)
        {
          if (i == localVector.size()) {
            break label2211;
          }
          paramInputStream = (SafeBag)localVector.elementAt(i);
          paramArrayOfChar = CertBag.getInstance(paramInputStream.getBagValue());
          if (paramArrayOfChar.getCertId().equals(x509Certificate)) {
            try
            {
              paramArrayOfChar = new ByteArrayInputStream(((ASN1OctetString)paramArrayOfChar.getCertValue()).getOctets());
              localObject1 = this.certFact.generateCertificate(paramArrayOfChar);
              if (paramInputStream.getBagAttributes() != null)
              {
                localObject2 = paramInputStream.getBagAttributes().getObjects();
                paramArrayOfChar = null;
                paramInputStream = paramArrayOfChar;
                while (((Enumeration)localObject2).hasMoreElements())
                {
                  localObject4 = ASN1Sequence.getInstance(((Enumeration)localObject2).nextElement());
                  localObject3 = ASN1ObjectIdentifier.getInstance(((ASN1Sequence)localObject4).getObjectAt(0));
                  localObject4 = ASN1Set.getInstance(((ASN1Sequence)localObject4).getObjectAt(1));
                  if (((ASN1Set)localObject4).size() > 0)
                  {
                    localObject4 = (ASN1Primitive)((ASN1Set)localObject4).getObjectAt(0);
                    if ((localObject1 instanceof PKCS12BagAttributeCarrier))
                    {
                      localObject5 = (PKCS12BagAttributeCarrier)localObject1;
                      localObject6 = ((PKCS12BagAttributeCarrier)localObject5).getBagAttribute((ASN1ObjectIdentifier)localObject3);
                      if (localObject6 != null)
                      {
                        if (!((ASN1Encodable)localObject6).toASN1Primitive().equals(localObject4)) {
                          throw new IOException("attempt to add existing attribute with different value");
                        }
                      }
                      else {
                        ((PKCS12BagAttributeCarrier)localObject5).setBagAttribute((ASN1ObjectIdentifier)localObject3, (ASN1Encodable)localObject4);
                      }
                    }
                    if (((ASN1ObjectIdentifier)localObject3).equals(pkcs_9_at_friendlyName)) {
                      paramInputStream = ((DERBMPString)localObject4).getString();
                    } else if (((ASN1ObjectIdentifier)localObject3).equals(pkcs_9_at_localKeyId)) {
                      paramArrayOfChar = (ASN1OctetString)localObject4;
                    }
                  }
                }
              }
              else
              {
                paramArrayOfChar = null;
                paramInputStream = paramArrayOfChar;
              }
              this.chainCerts.put(new CertId(((Certificate)localObject1).getPublicKey()), localObject1);
              if (k != 0)
              {
                if (this.keyCerts.isEmpty())
                {
                  paramInputStream = new String(Hex.encode(createSubjectKeyId(((Certificate)localObject1).getPublicKey()).getKeyIdentifier()));
                  this.keyCerts.put(paramInputStream, localObject1);
                  paramArrayOfChar = this.keys;
                  paramArrayOfChar.put(paramInputStream, paramArrayOfChar.remove("unmarked"));
                }
              }
              else
              {
                if (paramArrayOfChar != null)
                {
                  paramArrayOfChar = new String(Hex.encode(paramArrayOfChar.getOctets()));
                  this.keyCerts.put(paramArrayOfChar, localObject1);
                }
                if (paramInputStream != null) {
                  this.certs.put(paramInputStream, localObject1);
                }
              }
              i += 1;
            }
            catch (Exception paramInputStream)
            {
              throw new RuntimeException(paramInputStream.toString());
            }
          }
        }
        paramInputStream = new StringBuilder();
        paramInputStream.append("Unsupported certificate type: ");
        paramInputStream.append(paramArrayOfChar.getCertId());
        throw new RuntimeException(paramInputStream.toString());
        label2211:
        return;
      }
      throw new IOException("stream does not represent a PKCS12 key store");
    }
    throw new NullPointerException("No password supplied for PKCS#12 KeyStore.");
  }
  
  public void engineSetCertificateEntry(String paramString, Certificate paramCertificate)
    throws KeyStoreException
  {
    if (this.keys.get(paramString) == null)
    {
      this.certs.put(paramString, paramCertificate);
      this.chainCerts.put(new CertId(paramCertificate.getPublicKey()), paramCertificate);
      return;
    }
    paramCertificate = new StringBuilder();
    paramCertificate.append("There is a key entry with the name ");
    paramCertificate.append(paramString);
    paramCertificate.append(".");
    throw new KeyStoreException(paramCertificate.toString());
  }
  
  public void engineSetKeyEntry(String paramString, Key paramKey, char[] paramArrayOfChar, Certificate[] paramArrayOfCertificate)
    throws KeyStoreException
  {
    boolean bool = paramKey instanceof PrivateKey;
    if (bool)
    {
      if ((bool) && (paramArrayOfCertificate == null)) {
        throw new KeyStoreException("no certificate chain for private key");
      }
      if (this.keys.get(paramString) != null) {
        engineDeleteEntry(paramString);
      }
      this.keys.put(paramString, paramKey);
      if (paramArrayOfCertificate != null)
      {
        paramKey = this.certs;
        int i = 0;
        paramKey.put(paramString, paramArrayOfCertificate[0]);
        while (i != paramArrayOfCertificate.length)
        {
          this.chainCerts.put(new CertId(paramArrayOfCertificate[i].getPublicKey()), paramArrayOfCertificate[i]);
          i += 1;
        }
      }
      return;
    }
    throw new KeyStoreException("PKCS12 does not support non-PrivateKeys");
  }
  
  public void engineSetKeyEntry(String paramString, byte[] paramArrayOfByte, Certificate[] paramArrayOfCertificate)
    throws KeyStoreException
  {
    throw new RuntimeException("operation not supported");
  }
  
  public int engineSize()
  {
    Hashtable localHashtable = new Hashtable();
    Enumeration localEnumeration = this.certs.keys();
    while (localEnumeration.hasMoreElements()) {
      localHashtable.put(localEnumeration.nextElement(), "cert");
    }
    localEnumeration = this.keys.keys();
    while (localEnumeration.hasMoreElements())
    {
      String str = (String)localEnumeration.nextElement();
      if (localHashtable.get(str) == null) {
        localHashtable.put(str, "key");
      }
    }
    return localHashtable.size();
  }
  
  public void engineStore(OutputStream paramOutputStream, char[] paramArrayOfChar)
    throws IOException
  {
    doStore(paramOutputStream, paramArrayOfChar, false);
  }
  
  public void engineStore(KeyStore.LoadStoreParameter paramLoadStoreParameter)
    throws IOException, NoSuchAlgorithmException, CertificateException
  {
    if (paramLoadStoreParameter != null)
    {
      boolean bool = paramLoadStoreParameter instanceof PKCS12StoreParameter;
      if ((!bool) && (!(paramLoadStoreParameter instanceof JDKPKCS12StoreParameter)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("No support for 'param' of type ");
        ((StringBuilder)localObject).append(paramLoadStoreParameter.getClass().getName());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      if (bool)
      {
        localObject = (PKCS12StoreParameter)paramLoadStoreParameter;
      }
      else
      {
        localObject = (JDKPKCS12StoreParameter)paramLoadStoreParameter;
        localObject = new PKCS12StoreParameter(((JDKPKCS12StoreParameter)localObject).getOutputStream(), paramLoadStoreParameter.getProtectionParameter(), ((JDKPKCS12StoreParameter)localObject).isUseDEREncoding());
      }
      paramLoadStoreParameter = paramLoadStoreParameter.getProtectionParameter();
      if (paramLoadStoreParameter == null)
      {
        paramLoadStoreParameter = null;
      }
      else
      {
        if (!(paramLoadStoreParameter instanceof KeyStore.PasswordProtection)) {
          break label147;
        }
        paramLoadStoreParameter = ((KeyStore.PasswordProtection)paramLoadStoreParameter).getPassword();
      }
      doStore(((PKCS12StoreParameter)localObject).getOutputStream(), paramLoadStoreParameter, ((PKCS12StoreParameter)localObject).isForDEREncoding());
      return;
      label147:
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("No support for protection parameter of type ");
      ((StringBuilder)localObject).append(paramLoadStoreParameter.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    throw new IllegalArgumentException("'param' arg cannot be null");
  }
  
  public void setRandom(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
  }
  
  protected PrivateKey unwrapKey(AlgorithmIdentifier paramAlgorithmIdentifier, byte[] paramArrayOfByte, char[] paramArrayOfChar, boolean paramBoolean)
    throws IOException
  {
    Object localObject = paramAlgorithmIdentifier.getAlgorithm();
    try
    {
      boolean bool = ((ASN1ObjectIdentifier)localObject).on(PKCSObjectIdentifiers.pkcs_12PbeIds);
      if (bool)
      {
        paramAlgorithmIdentifier = PKCS12PBEParams.getInstance(paramAlgorithmIdentifier.getParameters());
        paramAlgorithmIdentifier = new PBEParameterSpec(paramAlgorithmIdentifier.getIV(), paramAlgorithmIdentifier.getIterations().intValue());
        localObject = this.helper.createCipher(((ASN1ObjectIdentifier)localObject).getId());
        ((Cipher)localObject).init(4, new PKCS12Key(paramArrayOfChar, paramBoolean), paramAlgorithmIdentifier);
        return (PrivateKey)((Cipher)localObject).unwrap(paramArrayOfByte, "", 2);
      }
      if (((ASN1ObjectIdentifier)localObject).equals(PKCSObjectIdentifiers.id_PBES2))
      {
        paramAlgorithmIdentifier = (PrivateKey)createCipher(4, paramArrayOfChar, paramAlgorithmIdentifier).unwrap(paramArrayOfByte, "", 2);
        return paramAlgorithmIdentifier;
      }
      paramAlgorithmIdentifier = new StringBuilder();
      paramAlgorithmIdentifier.append("exception unwrapping private key - cannot recognise: ");
      paramAlgorithmIdentifier.append(localObject);
      throw new IOException(paramAlgorithmIdentifier.toString());
    }
    catch (Exception paramAlgorithmIdentifier)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("exception unwrapping private key - ");
      paramArrayOfByte.append(paramAlgorithmIdentifier.toString());
      throw new IOException(paramArrayOfByte.toString());
    }
  }
  
  protected byte[] wrapKey(String paramString, Key paramKey, PKCS12PBEParams paramPKCS12PBEParams, char[] paramArrayOfChar)
    throws IOException
  {
    paramArrayOfChar = new PBEKeySpec(paramArrayOfChar);
    try
    {
      SecretKeyFactory localSecretKeyFactory = this.helper.createSecretKeyFactory(paramString);
      paramPKCS12PBEParams = new PBEParameterSpec(paramPKCS12PBEParams.getIV(), paramPKCS12PBEParams.getIterations().intValue());
      paramString = this.helper.createCipher(paramString);
      paramString.init(3, localSecretKeyFactory.generateSecret(paramArrayOfChar), paramPKCS12PBEParams);
      paramString = paramString.wrap(paramKey);
      return paramString;
    }
    catch (Exception paramString)
    {
      paramKey = new StringBuilder();
      paramKey.append("exception encrypting data - ");
      paramKey.append(paramString.toString());
      throw new IOException(paramKey.toString());
    }
  }
  
  public static class BCPKCS12KeyStore
    extends PKCS12KeyStoreSpi
  {
    public BCPKCS12KeyStore()
    {
      super(pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd40BitRC2_CBC);
    }
  }
  
  public static class BCPKCS12KeyStore3DES
    extends PKCS12KeyStoreSpi
  {
    public BCPKCS12KeyStore3DES()
    {
      super(pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
    }
  }
  
  private class CertId
  {
    byte[] id;
    
    CertId(PublicKey paramPublicKey)
    {
      this.id = PKCS12KeyStoreSpi.this.createSubjectKeyId(paramPublicKey).getKeyIdentifier();
    }
    
    CertId(byte[] paramArrayOfByte)
    {
      this.id = paramArrayOfByte;
    }
    
    public boolean equals(Object paramObject)
    {
      if (paramObject == this) {
        return true;
      }
      if (!(paramObject instanceof CertId)) {
        return false;
      }
      paramObject = (CertId)paramObject;
      return Arrays.areEqual(this.id, ((CertId)paramObject).id);
    }
    
    public int hashCode()
    {
      return Arrays.hashCode(this.id);
    }
  }
  
  public static class DefPKCS12KeyStore
    extends PKCS12KeyStoreSpi
  {
    public DefPKCS12KeyStore()
    {
      super(pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd40BitRC2_CBC);
    }
  }
  
  public static class DefPKCS12KeyStore3DES
    extends PKCS12KeyStoreSpi
  {
    public DefPKCS12KeyStore3DES()
    {
      super(pbeWithSHAAnd3_KeyTripleDES_CBC, pbeWithSHAAnd3_KeyTripleDES_CBC);
    }
  }
  
  private static class DefaultSecretKeyProvider
  {
    private final Map KEY_SIZES;
    
    DefaultSecretKeyProvider()
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put(new ASN1ObjectIdentifier("1.2.840.113533.7.66.10"), Integers.valueOf(128));
      localHashMap.put(PKCSObjectIdentifiers.des_EDE3_CBC, Integers.valueOf(192));
      localHashMap.put(NISTObjectIdentifiers.id_aes128_CBC, Integers.valueOf(128));
      localHashMap.put(NISTObjectIdentifiers.id_aes192_CBC, Integers.valueOf(192));
      localHashMap.put(NISTObjectIdentifiers.id_aes256_CBC, Integers.valueOf(256));
      localHashMap.put(NTTObjectIdentifiers.id_camellia128_cbc, Integers.valueOf(128));
      localHashMap.put(NTTObjectIdentifiers.id_camellia192_cbc, Integers.valueOf(192));
      localHashMap.put(NTTObjectIdentifiers.id_camellia256_cbc, Integers.valueOf(256));
      localHashMap.put(CryptoProObjectIdentifiers.gostR28147_gcfb, Integers.valueOf(256));
      this.KEY_SIZES = Collections.unmodifiableMap(localHashMap);
    }
    
    public int getKeySize(AlgorithmIdentifier paramAlgorithmIdentifier)
    {
      paramAlgorithmIdentifier = (Integer)this.KEY_SIZES.get(paramAlgorithmIdentifier.getAlgorithm());
      if (paramAlgorithmIdentifier != null) {
        return paramAlgorithmIdentifier.intValue();
      }
      return -1;
    }
  }
  
  private static class IgnoresCaseHashtable
  {
    private Hashtable keys = new Hashtable();
    private Hashtable orig = new Hashtable();
    
    public Enumeration elements()
    {
      return this.orig.elements();
    }
    
    public Object get(String paramString)
    {
      Hashtable localHashtable = this.keys;
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = Strings.toLowerCase(paramString);
      }
      paramString = (String)localHashtable.get(paramString);
      if (paramString == null) {
        return null;
      }
      return this.orig.get(paramString);
    }
    
    public Enumeration keys()
    {
      return this.orig.keys();
    }
    
    public void put(String paramString, Object paramObject)
    {
      String str1;
      if (paramString == null) {
        str1 = null;
      } else {
        str1 = Strings.toLowerCase(paramString);
      }
      String str2 = (String)this.keys.get(str1);
      if (str2 != null) {
        this.orig.remove(str2);
      }
      this.keys.put(str1, paramString);
      this.orig.put(paramString, paramObject);
    }
    
    public Object remove(String paramString)
    {
      Hashtable localHashtable = this.keys;
      if (paramString == null) {
        paramString = null;
      } else {
        paramString = Strings.toLowerCase(paramString);
      }
      paramString = (String)localHashtable.remove(paramString);
      if (paramString == null) {
        return null;
      }
      return this.orig.remove(paramString);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\keystore\pkcs12\PKCS12KeyStoreSpi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */