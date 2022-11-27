package org.bouncycastle.x509;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;
import java.security.Signature;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Strings;

class X509Util
{
  private static Hashtable algorithms = new Hashtable();
  private static Set noParams;
  private static Hashtable params = new Hashtable();
  
  static
  {
    noParams = new HashSet();
    algorithms.put("MD2WITHRSAENCRYPTION", PKCSObjectIdentifiers.md2WithRSAEncryption);
    algorithms.put("MD2WITHRSA", PKCSObjectIdentifiers.md2WithRSAEncryption);
    algorithms.put("MD5WITHRSAENCRYPTION", PKCSObjectIdentifiers.md5WithRSAEncryption);
    algorithms.put("MD5WITHRSA", PKCSObjectIdentifiers.md5WithRSAEncryption);
    algorithms.put("SHA1WITHRSAENCRYPTION", PKCSObjectIdentifiers.sha1WithRSAEncryption);
    algorithms.put("SHA1WITHRSA", PKCSObjectIdentifiers.sha1WithRSAEncryption);
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
    algorithms.put("RIPEMD160WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160);
    algorithms.put("RIPEMD160WITHRSA", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160);
    algorithms.put("RIPEMD128WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128);
    algorithms.put("RIPEMD128WITHRSA", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128);
    algorithms.put("RIPEMD256WITHRSAENCRYPTION", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256);
    algorithms.put("RIPEMD256WITHRSA", TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256);
    algorithms.put("SHA1WITHDSA", X9ObjectIdentifiers.id_dsa_with_sha1);
    algorithms.put("DSAWITHSHA1", X9ObjectIdentifiers.id_dsa_with_sha1);
    algorithms.put("SHA224WITHDSA", NISTObjectIdentifiers.dsa_with_sha224);
    algorithms.put("SHA256WITHDSA", NISTObjectIdentifiers.dsa_with_sha256);
    algorithms.put("SHA384WITHDSA", NISTObjectIdentifiers.dsa_with_sha384);
    algorithms.put("SHA512WITHDSA", NISTObjectIdentifiers.dsa_with_sha512);
    algorithms.put("SHA1WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA1);
    algorithms.put("ECDSAWITHSHA1", X9ObjectIdentifiers.ecdsa_with_SHA1);
    algorithms.put("SHA224WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA224);
    algorithms.put("SHA256WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA256);
    algorithms.put("SHA384WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA384);
    algorithms.put("SHA512WITHECDSA", X9ObjectIdentifiers.ecdsa_with_SHA512);
    algorithms.put("GOST3411WITHGOST3410", CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94);
    algorithms.put("GOST3411WITHGOST3410-94", CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94);
    algorithms.put("GOST3411WITHECGOST3410", CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001);
    algorithms.put("GOST3411WITHECGOST3410-2001", CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001);
    algorithms.put("GOST3411WITHGOST3410-2001", CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001);
    noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA1);
    noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA224);
    noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA256);
    noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA384);
    noParams.add(X9ObjectIdentifiers.ecdsa_with_SHA512);
    noParams.add(X9ObjectIdentifiers.id_dsa_with_sha1);
    noParams.add(NISTObjectIdentifiers.dsa_with_sha224);
    noParams.add(NISTObjectIdentifiers.dsa_with_sha256);
    noParams.add(NISTObjectIdentifiers.dsa_with_sha384);
    noParams.add(NISTObjectIdentifiers.dsa_with_sha512);
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
  
  static byte[] calculateSignature(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString1, String paramString2, PrivateKey paramPrivateKey, SecureRandom paramSecureRandom, ASN1Encodable paramASN1Encodable)
    throws IOException, NoSuchProviderException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
  {
    if (paramASN1ObjectIdentifier != null)
    {
      paramASN1ObjectIdentifier = getSignatureInstance(paramString1, paramString2);
      if (paramSecureRandom != null) {
        paramASN1ObjectIdentifier.initSign(paramPrivateKey, paramSecureRandom);
      } else {
        paramASN1ObjectIdentifier.initSign(paramPrivateKey);
      }
      paramASN1ObjectIdentifier.update(paramASN1Encodable.toASN1Primitive().getEncoded("DER"));
      return paramASN1ObjectIdentifier.sign();
    }
    throw new IllegalStateException("no signature algorithm specified");
  }
  
  static byte[] calculateSignature(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString, PrivateKey paramPrivateKey, SecureRandom paramSecureRandom, ASN1Encodable paramASN1Encodable)
    throws IOException, NoSuchAlgorithmException, InvalidKeyException, SignatureException
  {
    if (paramASN1ObjectIdentifier != null)
    {
      paramASN1ObjectIdentifier = getSignatureInstance(paramString);
      if (paramSecureRandom != null) {
        paramASN1ObjectIdentifier.initSign(paramPrivateKey, paramSecureRandom);
      } else {
        paramASN1ObjectIdentifier.initSign(paramPrivateKey);
      }
      paramASN1ObjectIdentifier.update(paramASN1Encodable.toASN1Primitive().getEncoded("DER"));
      return paramASN1ObjectIdentifier.sign();
    }
    throw new IllegalStateException("no signature algorithm specified");
  }
  
  static X509Principal convertPrincipal(X500Principal paramX500Principal)
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
    throw new IllegalArgumentException("cannot convert principal");
  }
  
  private static RSASSAPSSparams creatPSSParams(AlgorithmIdentifier paramAlgorithmIdentifier, int paramInt)
  {
    return new RSASSAPSSparams(paramAlgorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, paramAlgorithmIdentifier), new ASN1Integer(paramInt), new ASN1Integer(1L));
  }
  
  static Iterator getAlgNames()
  {
    Enumeration localEnumeration = algorithms.keys();
    ArrayList localArrayList = new ArrayList();
    while (localEnumeration.hasMoreElements()) {
      localArrayList.add(localEnumeration.nextElement());
    }
    return localArrayList.iterator();
  }
  
  static ASN1ObjectIdentifier getAlgorithmOID(String paramString)
  {
    paramString = Strings.toUpperCase(paramString);
    if (algorithms.containsKey(paramString)) {
      return (ASN1ObjectIdentifier)algorithms.get(paramString);
    }
    return new ASN1ObjectIdentifier(paramString);
  }
  
  static Implementation getImplementation(String paramString1, String paramString2)
    throws NoSuchAlgorithmException
  {
    Provider[] arrayOfProvider = Security.getProviders();
    int i = 0;
    for (;;)
    {
      if (i != arrayOfProvider.length)
      {
        Implementation localImplementation = getImplementation(paramString1, Strings.toUpperCase(paramString2), arrayOfProvider[i]);
        if (localImplementation != null) {
          return localImplementation;
        }
      }
      try
      {
        getImplementation(paramString1, paramString2, arrayOfProvider[i]);
        i += 1;
        continue;
        paramString1 = new StringBuilder();
        paramString1.append("cannot find implementation ");
        paramString1.append(paramString2);
        throw new NoSuchAlgorithmException(paramString1.toString());
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        for (;;) {}
      }
    }
  }
  
  static Implementation getImplementation(String paramString1, String paramString2, Provider paramProvider)
    throws NoSuchAlgorithmException
  {
    for (paramString2 = Strings.toUpperCase(paramString2);; paramString2 = (String)localObject)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Alg.Alias.");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(paramString2);
      localObject = paramProvider.getProperty(((StringBuilder)localObject).toString());
      if (localObject == null) {
        break;
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(".");
    ((StringBuilder)localObject).append(paramString2);
    localObject = paramProvider.getProperty(((StringBuilder)localObject).toString());
    if (localObject != null) {}
    try
    {
      paramString1 = paramProvider.getClass().getClassLoader();
      if (paramString1 != null) {
        paramString1 = paramString1.loadClass((String)localObject);
      } else {
        paramString1 = Class.forName((String)localObject);
      }
      paramString1 = new Implementation(paramString1.newInstance(), paramProvider);
      return paramString1;
    }
    catch (ClassNotFoundException paramString1)
    {
      for (;;) {}
    }
    catch (Exception paramString1)
    {
      for (;;) {}
    }
    paramString1 = new StringBuilder();
    paramString1.append("algorithm ");
    paramString1.append(paramString2);
    paramString1.append(" in provider ");
    paramString1.append(paramProvider.getName());
    paramString1.append(" but class \"");
    paramString1.append((String)localObject);
    paramString1.append("\" inaccessible!");
    throw new IllegalStateException(paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("algorithm ");
    paramString1.append(paramString2);
    paramString1.append(" in provider ");
    paramString1.append(paramProvider.getName());
    paramString1.append(" but no class \"");
    paramString1.append((String)localObject);
    paramString1.append("\" found!");
    throw new IllegalStateException(paramString1.toString());
    paramString1 = new StringBuilder();
    paramString1.append("cannot find implementation ");
    paramString1.append(paramString2);
    paramString1.append(" for provider ");
    paramString1.append(paramProvider.getName());
    throw new NoSuchAlgorithmException(paramString1.toString());
  }
  
  static Provider getProvider(String paramString)
    throws NoSuchProviderException
  {
    Object localObject = Security.getProvider(paramString);
    if (localObject != null) {
      return (Provider)localObject;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Provider ");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" not found");
    throw new NoSuchProviderException(((StringBuilder)localObject).toString());
  }
  
  static AlgorithmIdentifier getSigAlgID(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    if (noParams.contains(paramASN1ObjectIdentifier)) {
      return new AlgorithmIdentifier(paramASN1ObjectIdentifier);
    }
    paramString = Strings.toUpperCase(paramString);
    if (params.containsKey(paramString)) {
      return new AlgorithmIdentifier(paramASN1ObjectIdentifier, (ASN1Encodable)params.get(paramString));
    }
    return new AlgorithmIdentifier(paramASN1ObjectIdentifier, DERNull.INSTANCE);
  }
  
  static Signature getSignatureInstance(String paramString)
    throws NoSuchAlgorithmException
  {
    return Signature.getInstance(paramString);
  }
  
  static Signature getSignatureInstance(String paramString1, String paramString2)
    throws NoSuchProviderException, NoSuchAlgorithmException
  {
    if (paramString2 != null) {
      return Signature.getInstance(paramString1, paramString2);
    }
    return Signature.getInstance(paramString1);
  }
  
  static class Implementation
  {
    Object engine;
    Provider provider;
    
    Implementation(Object paramObject, Provider paramProvider)
    {
      this.engine = paramObject;
      this.provider = paramProvider;
    }
    
    Object getEngine()
    {
      return this.engine;
    }
    
    Provider getProvider()
    {
      return this.provider;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\X509Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */