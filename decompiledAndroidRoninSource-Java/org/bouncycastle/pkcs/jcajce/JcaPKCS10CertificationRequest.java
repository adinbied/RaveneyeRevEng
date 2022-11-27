package org.bouncycastle.pkcs.jcajce;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.pkcs.CertificationRequest;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;

public class JcaPKCS10CertificationRequest
  extends PKCS10CertificationRequest
{
  private static Hashtable keyAlgorithms;
  private JcaJceHelper helper = new DefaultJcaJceHelper();
  
  static
  {
    Hashtable localHashtable = new Hashtable();
    keyAlgorithms = localHashtable;
    localHashtable.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
    keyAlgorithms.put(X9ObjectIdentifiers.id_dsa, "DSA");
  }
  
  public JcaPKCS10CertificationRequest(CertificationRequest paramCertificationRequest)
  {
    super(paramCertificationRequest);
  }
  
  public JcaPKCS10CertificationRequest(PKCS10CertificationRequest paramPKCS10CertificationRequest)
  {
    super(paramPKCS10CertificationRequest.toASN1Structure());
  }
  
  public JcaPKCS10CertificationRequest(byte[] paramArrayOfByte)
    throws IOException
  {
    super(paramArrayOfByte);
  }
  
  public PublicKey getPublicKey()
    throws InvalidKeyException, NoSuchAlgorithmException
  {
    try
    {
      SubjectPublicKeyInfo localSubjectPublicKeyInfo = getSubjectPublicKeyInfo();
      localObject2 = new X509EncodedKeySpec(localSubjectPublicKeyInfo.getEncoded());
      try
      {
        KeyFactory localKeyFactory = this.helper.createKeyFactory(localSubjectPublicKeyInfo.getAlgorithm().getAlgorithm().getId());
      }
      catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
      {
        if (keyAlgorithms.get(localSubjectPublicKeyInfo.getAlgorithm().getAlgorithm()) == null) {
          break label91;
        }
      }
      localObject1 = (String)keyAlgorithms.get(localSubjectPublicKeyInfo.getAlgorithm().getAlgorithm());
      localObject1 = this.helper.createKeyFactory((String)localObject1);
      return ((KeyFactory)localObject1).generatePublic((KeySpec)localObject2);
    }
    catch (NoSuchProviderException localNoSuchProviderException)
    {
      Object localObject1;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("cannot find provider: ");
      ((StringBuilder)localObject2).append(localNoSuchProviderException.getMessage());
      throw new NoSuchAlgorithmException(((StringBuilder)localObject2).toString());
      throw new InvalidKeyException("error extracting key encoding");
      throw new InvalidKeyException("error decoding public key");
    }
    catch (InvalidKeySpecException localInvalidKeySpecException)
    {
      for (;;) {}
    }
    catch (IOException localIOException)
    {
      label91:
      for (;;) {}
    }
    throw ((Throwable)localObject1);
  }
  
  public JcaPKCS10CertificationRequest setProvider(String paramString)
  {
    this.helper = new NamedJcaJceHelper(paramString);
    return this;
  }
  
  public JcaPKCS10CertificationRequest setProvider(Provider paramProvider)
  {
    this.helper = new ProviderJcaJceHelper(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\jcajce\JcaPKCS10CertificationRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */