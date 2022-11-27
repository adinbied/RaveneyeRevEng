package org.bouncycastle.openssl.jcajce;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.openssl.PEMException;
import org.bouncycastle.openssl.PEMKeyPair;

public class JcaPEMKeyConverter
{
  private static final Map algorithms;
  private JcaJceHelper helper = new DefaultJcaJceHelper();
  
  static
  {
    HashMap localHashMap = new HashMap();
    algorithms = localHashMap;
    localHashMap.put(X9ObjectIdentifiers.id_ecPublicKey, "ECDSA");
    algorithms.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
    algorithms.put(X9ObjectIdentifiers.id_dsa, "DSA");
  }
  
  private KeyFactory getKeyFactory(AlgorithmIdentifier paramAlgorithmIdentifier)
    throws NoSuchAlgorithmException, NoSuchProviderException
  {
    ASN1ObjectIdentifier localASN1ObjectIdentifier = paramAlgorithmIdentifier.getAlgorithm();
    Object localObject = (String)algorithms.get(localASN1ObjectIdentifier);
    paramAlgorithmIdentifier = (AlgorithmIdentifier)localObject;
    if (localObject == null) {
      paramAlgorithmIdentifier = localASN1ObjectIdentifier.getId();
    }
    try
    {
      localObject = this.helper.createKeyFactory(paramAlgorithmIdentifier);
      return (KeyFactory)localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      if (paramAlgorithmIdentifier.equals("ECDSA")) {
        return this.helper.createKeyFactory("EC");
      }
      throw localNoSuchAlgorithmException;
    }
  }
  
  public KeyPair getKeyPair(PEMKeyPair paramPEMKeyPair)
    throws PEMException
  {
    try
    {
      localObject = getKeyFactory(paramPEMKeyPair.getPrivateKeyInfo().getPrivateKeyAlgorithm());
      paramPEMKeyPair = new KeyPair(((KeyFactory)localObject).generatePublic(new X509EncodedKeySpec(paramPEMKeyPair.getPublicKeyInfo().getEncoded())), ((KeyFactory)localObject).generatePrivate(new PKCS8EncodedKeySpec(paramPEMKeyPair.getPrivateKeyInfo().getEncoded())));
      return paramPEMKeyPair;
    }
    catch (Exception paramPEMKeyPair)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to convert key pair: ");
      ((StringBuilder)localObject).append(paramPEMKeyPair.getMessage());
      throw new PEMException(((StringBuilder)localObject).toString(), paramPEMKeyPair);
    }
  }
  
  public PrivateKey getPrivateKey(PrivateKeyInfo paramPrivateKeyInfo)
    throws PEMException
  {
    try
    {
      paramPrivateKeyInfo = getKeyFactory(paramPrivateKeyInfo.getPrivateKeyAlgorithm()).generatePrivate(new PKCS8EncodedKeySpec(paramPrivateKeyInfo.getEncoded()));
      return paramPrivateKeyInfo;
    }
    catch (Exception paramPrivateKeyInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to convert key pair: ");
      localStringBuilder.append(paramPrivateKeyInfo.getMessage());
      throw new PEMException(localStringBuilder.toString(), paramPrivateKeyInfo);
    }
  }
  
  public PublicKey getPublicKey(SubjectPublicKeyInfo paramSubjectPublicKeyInfo)
    throws PEMException
  {
    try
    {
      paramSubjectPublicKeyInfo = getKeyFactory(paramSubjectPublicKeyInfo.getAlgorithm()).generatePublic(new X509EncodedKeySpec(paramSubjectPublicKeyInfo.getEncoded()));
      return paramSubjectPublicKeyInfo;
    }
    catch (Exception paramSubjectPublicKeyInfo)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to convert key pair: ");
      localStringBuilder.append(paramSubjectPublicKeyInfo.getMessage());
      throw new PEMException(localStringBuilder.toString(), paramSubjectPublicKeyInfo);
    }
  }
  
  public JcaPEMKeyConverter setProvider(String paramString)
  {
    this.helper = new NamedJcaJceHelper(paramString);
    return this;
  }
  
  public JcaPEMKeyConverter setProvider(Provider paramProvider)
  {
    this.helper = new ProviderJcaJceHelper(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\jcajce\JcaPEMKeyConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */