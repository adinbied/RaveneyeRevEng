package org.bouncycastle.jce;

import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.CertificationRequest;
import org.bouncycastle.asn1.pkcs.CertificationRequestInfo;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.util.Strings;

public class PKCS10CertificationRequest
  extends CertificationRequest
{
  private static Hashtable algorithms = new Hashtable();
  private static Hashtable keyAlgorithms;
  private static Set noParams;
  private static Hashtable oids;
  private static Hashtable params = new Hashtable();
  
  static
  {
    keyAlgorithms = new Hashtable();
    oids = new Hashtable();
    noParams = new HashSet();
    algorithms.put("MD2WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"));
    algorithms.put("MD2WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"));
    algorithms.put("MD5WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
    algorithms.put("MD5WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
    algorithms.put("RSAWITHMD5", new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"));
    algorithms.put("SHA1WITHRSAENCRYPTION", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
    algorithms.put("SHA1WITHRSA", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
    algorithms.put("SHA224WITHRSAENCRYPTION", PKCSObjectIdentifiers.sha224WithRSAEncryption);
    algorithms.put("SHA224WITHRSA", PKCSObjectIdentifiers.sha224WithRSAEncryption);
    algorithms.put("SHA256WITHRSAENCRYPTION", PKCSObjectIdentifiers.sha256WithRSAEncryption);
    algorithms.put("SHA256WITHRSA", PKCSObjectIdentifiers.sha256WithRSAEncryption);
    algorithms.put("SHA384WITHRSAENCRYPTION", PKCSObjectIdentifiers.sha384WithRSAEncryption);
    algorithms.put("SHA384WITHRSA", PKCSObjectIdentifiers.sha384WithRSAEncryption);
    algorithms.put("SHA512WITHRSAENCRYPTION", PKCSObjectIdentifiers.sha512WithRSAEncryption);
    algorithms.put("SHA512WITHRSA", PKCSObjectIdentifiers.sha512WithRSAEncryption);
    algorithms.put("SHA1WITHRSAANDMGF1", PKCSObjectIdentifiers.id_RSASSA_PSS);
    algorithms.put("SHA224WITHRSAANDMGF1", PKCSObjectIdentifiers.id_RSASSA_PSS);
    algorithms.put("SHA256WITHRSAANDMGF1", PKCSObjectIdentifiers.id_RSASSA_PSS);
    algorithms.put("SHA384WITHRSAANDMGF1", PKCSObjectIdentifiers.id_RSASSA_PSS);
    algorithms.put("SHA512WITHRSAANDMGF1", PKCSObjectIdentifiers.id_RSASSA_PSS);
    algorithms.put("RSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"));
    algorithms.put("RIPEMD128WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128);
    algorithms.put("RIPEMD128WITHRSA", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128);
    algorithms.put("RIPEMD160WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160);
    algorithms.put("RIPEMD160WITHRSA", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160);
    algorithms.put("RIPEMD256WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256);
    algorithms.put("RIPEMD256WITHRSA", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256);
    algorithms.put("SHA1WITHDSA", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
    algorithms.put("DSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
    algorithms.put("SHA224WITHDSA", NISTObjectIdentifiers.dsa_with_sha224);
    algorithms.put("SHA256WITHDSA", NISTObjectIdentifiers.dsa_with_sha256);
    algorithms.put("SHA384WITHDSA", NISTObjectIdentifiers.dsa_with_sha384);
    algorithms.put("SHA512WITHDSA", NISTObjectIdentifiers.dsa_with_sha512);
    algorithms.put("SHA1WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA1);
    algorithms.put("SHA224WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA224);
    algorithms.put("SHA256WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA256);
    algorithms.put("SHA384WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA384);
    algorithms.put("SHA512WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA512);
    algorithms.put("ECDSAWITHSHA1", X9ObjectIdentifiers.ecdsa_with_SHA1);
    algorithms.put("GOST3411WITHGOST3410", CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94);
    algorithms.put("GOST3410WITHGOST3411", CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94);
    algorithms.put("GOST3411WITHECGOST3410", CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001);
    algorithms.put("GOST3411WITHECGOST3410-2001", CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001);
    algorithms.put("GOST3411WITHGOST3410-2001", CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001);
    oids.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.5"), "SHA1WITHRSA");
    oids.put(PKCSObjectIdentifiers.sha224WithRSAEncryption, "SHA224WITHRSA");
    oids.put(PKCSObjectIdentifiers.sha256WithRSAEncryption, "SHA256WITHRSA");
    oids.put(PKCSObjectIdentifiers.sha384WithRSAEncryption, "SHA384WITHRSA");
    oids.put(PKCSObjectIdentifiers.sha512WithRSAEncryption, "SHA512WITHRSA");
    oids.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94, "GOST3411WITHGOST3410");
    oids.put(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001, "GOST3411WITHECGOST3410");
    oids.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.4"), "MD5WITHRSA");
    oids.put(new ASN1ObjectIdentifier("1.2.840.113549.1.1.2"), "MD2WITHRSA");
    oids.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), "SHA1WITHDSA");
    oids.put(X9ObjectIdentifiers.ecdsa_with_SHA1, "SHA1WITHECDSA");
    oids.put(X9ObjectIdentifiers.ecdsa_with_SHA224, "SHA224WITHECDSA");
    oids.put(X9ObjectIdentifiers.ecdsa_with_SHA256, "SHA256WITHECDSA");
    oids.put(X9ObjectIdentifiers.ecdsa_with_SHA384, "SHA384WITHECDSA");
    oids.put(X9ObjectIdentifiers.ecdsa_with_SHA512, "SHA512WITHECDSA");
    oids.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
    oids.put(OIWObjectIdentifiers.dsaWithSHA1, "SHA1WITHDSA");
    oids.put(NISTObjectIdentifiers.dsa_with_sha224, "SHA224WITHDSA");
    oids.put(NISTObjectIdentifiers.dsa_with_sha256, "SHA256WITHDSA");
    keyAlgorithms.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
    keyAlgorithms.put(X9ObjectIdentifiers.id_dsa, "DSA");
    noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA1);
    noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA224);
    noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA256);
    noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA384);
    noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA512);
    noParams.add(X9ObjectIdentifiers.id_dsa_with_sha1);
    noParams.add(NISTObjectIdentifiers.dsa_with_sha224);
    noParams.add(NISTObjectIdentifiers.dsa_with_sha256);
    noParams.add(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94);
    noParams.add(CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001);
    AlgorithmIdentifier localAlgorithmIdentifier = new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
    params.put("SHA1WITHRSAANDMGF1", creatPSSParams(localAlgorithmIdentifier, 20));
    localAlgorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, DERNull.INSTANCE);
    params.put("SHA224WITHRSAANDMGF1", creatPSSParams(localAlgorithmIdentifier, 28));
    localAlgorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, DERNull.INSTANCE);
    params.put("SHA256WITHRSAANDMGF1", creatPSSParams(localAlgorithmIdentifier, 32));
    localAlgorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, DERNull.INSTANCE);
    params.put("SHA384WITHRSAANDMGF1", creatPSSParams(localAlgorithmIdentifier, 48));
    localAlgorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, DERNull.INSTANCE);
    params.put("SHA512WITHRSAANDMGF1", creatPSSParams(localAlgorithmIdentifier, 64));
  }
  
  public PKCS10CertificationRequest(String paramString, X500Principal paramX500Principal, PublicKey paramPublicKey, ASN1Set paramASN1Set, PrivateKey paramPrivateKey)
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException
  {
    this(paramString, convertName(paramX500Principal), paramPublicKey, paramASN1Set, paramPrivateKey, "BC");
  }
  
  public PKCS10CertificationRequest(String paramString1, X500Principal paramX500Principal, PublicKey paramPublicKey, ASN1Set paramASN1Set, PrivateKey paramPrivateKey, String paramString2)
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException
  {
    this(paramString1, convertName(paramX500Principal), paramPublicKey, paramASN1Set, paramPrivateKey, paramString2);
  }
  
  public PKCS10CertificationRequest(String paramString, X509Name paramX509Name, PublicKey paramPublicKey, ASN1Set paramASN1Set, PrivateKey paramPrivateKey)
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException
  {
    this(paramString, paramX509Name, paramPublicKey, paramASN1Set, paramPrivateKey, "BC");
  }
  
  public PKCS10CertificationRequest(String paramString1, X509Name paramX509Name, PublicKey paramPublicKey, ASN1Set paramASN1Set, PrivateKey paramPrivateKey, String paramString2)
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException
  {
    String str = Strings.toUpperCase(paramString1);
    ASN1ObjectIdentifier localASN1ObjectIdentifier = (ASN1ObjectIdentifier)algorithms.get(str);
    Object localObject = localASN1ObjectIdentifier;
    if (localASN1ObjectIdentifier == null) {}
    try
    {
      localObject = new ASN1ObjectIdentifier(str);
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("Unknown signature type requested");
    if (paramX509Name != null) {
      if (paramPublicKey != null)
      {
        if (noParams.contains(localObject)) {}
        for (localObject = new AlgorithmIdentifier((ASN1ObjectIdentifier)localObject);; localObject = new AlgorithmIdentifier((ASN1ObjectIdentifier)localObject, DERNull.INSTANCE))
        {
          this.sigAlgId = ((AlgorithmIdentifier)localObject);
          break;
          if (params.containsKey(str))
          {
            this.sigAlgId = new AlgorithmIdentifier((ASN1ObjectIdentifier)localObject, (ASN1Encodable)params.get(str));
            break;
          }
        }
      }
    }
    try
    {
      this.reqInfo = new CertificationRequestInfo(paramX509Name, SubjectPublicKeyInfo.getInstance((ASN1Sequence)ASN1Primitive.fromByteArray(paramPublicKey.getEncoded())), paramASN1Set);
      if (paramString2 == null) {
        paramString1 = Signature.getInstance(paramString1);
      } else {
        paramString1 = Signature.getInstance(paramString1, paramString2);
      }
      paramString1.initSign(paramPrivateKey);
      try
      {
        paramString1.update(this.reqInfo.getEncoded("DER"));
        this.sigBits = new DERBitString(paramString1.sign());
        return;
      }
      catch (Exception paramString1)
      {
        paramX509Name = new StringBuilder();
        paramX509Name.append("exception encoding TBS cert request - ");
        paramX509Name.append(paramString1);
        throw new IllegalArgumentException(paramX509Name.toString());
      }
    }
    catch (IOException paramString1)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("can't encode public key");
    throw new IllegalArgumentException("public key must not be null");
    throw new IllegalArgumentException("subject must not be null");
  }
  
  public PKCS10CertificationRequest(ASN1Sequence paramASN1Sequence)
  {
    super(paramASN1Sequence);
  }
  
  public PKCS10CertificationRequest(byte[] paramArrayOfByte)
  {
    super(toDERSequence(paramArrayOfByte));
  }
  
  private static X509Name convertName(X500Principal paramX500Principal)
  {
    try
    {
      paramX500Principal = new X509Principal(paramX500Principal.getEncoded());
      return paramX500Principal;
    }
    catch (IOException paramX500Principal)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("can't convert name");
  }
  
  private static RSASSAPSSparams creatPSSParams(AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt)
  {
    return new RSASSAPSSparams(paramAlgorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, paramAlgorithmIdentifier), new ASN1Integer(paramInt), new ASN1Integer(1L));
  }
  
  private static String getDigestAlgName(ASN1ObjectIdentifier paramASN1ObjectIdentifier)
  {
    if (PKCSObjectIdentifiers.md5.equals(paramASN1ObjectIdentifier)) {
      return "MD5";
    }
    if (OIWObjectIdentifiers.idSHA1.equals(paramASN1ObjectIdentifier)) {
      return "SHA1";
    }
    if (NISTObjectIdentifiers.id_sha224.equals(paramASN1ObjectIdentifier)) {
      return "SHA224";
    }
    if (NISTObjectIdentifiers.id_sha256.equals(paramASN1ObjectIdentifier)) {
      return "SHA256";
    }
    if (NISTObjectIdentifiers.id_sha384.equals(paramASN1ObjectIdentifier)) {
      return "SHA384";
    }
    if (NISTObjectIdentifiers.id_sha512.equals(paramASN1ObjectIdentifier)) {
      return "SHA512";
    }
    if (TeleTrusTObjectIdentifiers.ripemd128.equals(paramASN1ObjectIdentifier)) {
      return "RIPEMD128";
    }
    if (TeleTrusTObjectIdentifiers.ripemd160.equals(paramASN1ObjectIdentifier)) {
      return "RIPEMD160";
    }
    if (TeleTrusTObjectIdentifiers.ripemd256.equals(paramASN1ObjectIdentifier)) {
      return "RIPEMD256";
    }
    if (CryptoProObjectIdentifiers.gostR3411.equals(paramASN1ObjectIdentifier)) {
      return "GOST3411";
    }
    return paramASN1ObjectIdentifier.getId();
  }
  
  static String getSignatureName(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    Object localObject = paramAlgorithmIdentifier.getParameters();
    if ((localObject != null) && (!DERNull.INSTANCE.equals(localObject)) && (paramAlgorithmIdentifier.getAlgorithm().equals(PKCSObjectIdentifiers.id_RSASSA_PSS)))
    {
      paramAlgorithmIdentifier = RSASSAPSSparams.getInstance(localObject);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(getDigestAlgName(paramAlgorithmIdentifier.getHashAlgorithm().getAlgorithm()));
      ((StringBuilder)localObject).append("withRSAandMGF1");
      return ((StringBuilder)localObject).toString();
    }
    return paramAlgorithmIdentifier.getAlgorithm().getId();
  }
  
  private void setSignatureParameters(Signature paramSignature, ASN1Encodable paramASN1Encodable)
    throws NoSuchAlgorithmException, SignatureException, InvalidKeyException
  {
    if ((paramASN1Encodable != null) && (!DERNull.INSTANCE.equals(paramASN1Encodable)))
    {
      AlgorithmParameters localAlgorithmParameters = AlgorithmParameters.getInstance(paramSignature.getAlgorithm(), paramSignature.getProvider());
      try
      {
        localAlgorithmParameters.init(paramASN1Encodable.toASN1Primitive().getEncoded("DER"));
        if (paramSignature.getAlgorithm().endsWith("MGF1")) {
          try
          {
            paramSignature.setParameter(localAlgorithmParameters.getParameterSpec(PSSParameterSpec.class));
            return;
          }
          catch (GeneralSecurityException paramSignature)
          {
            paramASN1Encodable = new StringBuilder();
            paramASN1Encodable.append("Exception extracting parameters: ");
            paramASN1Encodable.append(paramSignature.getMessage());
            throw new SignatureException(paramASN1Encodable.toString());
          }
        }
        return;
      }
      catch (IOException paramSignature)
      {
        paramASN1Encodable = new StringBuilder();
        paramASN1Encodable.append("IOException decoding parameters: ");
        paramASN1Encodable.append(paramSignature.getMessage());
        throw new SignatureException(paramASN1Encodable.toString());
      }
    }
  }
  
  private static ASN1Sequence toDERSequence(byte[] paramArrayOfByte)
  {
    try
    {
      paramArrayOfByte = (ASN1Sequence)new ASN1InputStream(paramArrayOfByte).readObject();
      return paramArrayOfByte;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;) {}
    }
    throw new IllegalArgumentException("badly encoded request");
  }
  
  public byte[] getEncoded()
  {
    try
    {
      byte[] arrayOfByte = getEncoded("DER");
      return arrayOfByte;
    }
    catch (IOException localIOException)
    {
      throw new RuntimeException(localIOException.toString());
    }
  }
  
  public PublicKey getPublicKey()
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException
  {
    return getPublicKey("BC");
  }
  
  public PublicKey getPublicKey(String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException
  {
    Object localObject = this.reqInfo.getSubjectPublicKeyInfo();
    try
    {
      localX509EncodedKeySpec = new X509EncodedKeySpec(new DERBitString((ASN1Encodable)localObject).getOctets());
      localObject = ((SubjectPublicKeyInfo)localObject).getAlgorithm();
      if (paramString == null) {}
      try
      {
        return KeyFactory.getInstance(((AlgorithmIdentifier)localObject).getAlgorithm().getId()).generatePublic(localX509EncodedKeySpec);
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        PublicKey localPublicKey;
        if (keyAlgorithms.get(((AlgorithmIdentifier)localObject).getAlgorithm()) == null) {
          break label123;
        }
        localObject = (String)keyAlgorithms.get(((AlgorithmIdentifier)localObject).getAlgorithm());
        if (paramString != null) {
          break label113;
        }
        return KeyFactory.getInstance((String)localObject).generatePublic(localX509EncodedKeySpec);
        return KeyFactory.getInstance((String)localObject, paramString).generatePublic(localX509EncodedKeySpec);
        throw localNoSuchAlgorithmException;
      }
      localPublicKey = KeyFactory.getInstance(((AlgorithmIdentifier)localObject).getAlgorithm().getId(), paramString).generatePublic(localX509EncodedKeySpec);
      return localPublicKey;
    }
    catch (InvalidKeySpecException paramString)
    {
      X509EncodedKeySpec localX509EncodedKeySpec;
      for (;;) {}
    }
    catch (IOException paramString)
    {
      label113:
      label123:
      for (;;) {}
    }
    throw new InvalidKeyException("error decoding public key");
    throw new InvalidKeyException("error decoding public key");
  }
  
  public boolean verify()
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException
  {
    return verify("BC");
  }
  
  public boolean verify(String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException
  {
    return verify(getPublicKey(paramString), paramString);
  }
  
  public boolean verify(PublicKey paramPublicKey, String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException
  {
    if (paramString == null) {}
    try
    {
      localSignature = Signature.getInstance(getSignatureName(this.sigAlgId));
      paramString = localSignature;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      Signature localSignature;
      if (oids.get(this.sigAlgId.getAlgorithm()) == null) {
        break label167;
      }
    }
    localSignature = Signature.getInstance(getSignatureName(this.sigAlgId), paramString);
    paramString = localSignature;
    break label89;
    String str = (String)oids.get(this.sigAlgId.getAlgorithm());
    if (paramString == null) {
      paramString = Signature.getInstance(str);
    } else {
      paramString = Signature.getInstance(str, paramString);
    }
    label89:
    setSignatureParameters(paramString, this.sigAlgId.getParameters());
    paramString.initVerify(paramPublicKey);
    try
    {
      paramString.update(this.reqInfo.getEncoded("DER"));
      return paramString.verify(this.sigBits.getOctets());
    }
    catch (Exception paramPublicKey)
    {
      paramString = new StringBuilder();
      paramString.append("exception encoding TBS cert request - ");
      paramString.append(paramPublicKey);
      throw new SignatureException(paramString.toString());
    }
    label167:
    throw str;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\PKCS10CertificationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */