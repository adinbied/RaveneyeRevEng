package org.bouncycastle.mozilla.jcajce;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.mozilla.PublicKeyAndChallenge;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jcajce.util.DefaultJcaJceHelper;
import org.bouncycastle.jcajce.util.JcaJceHelper;
import org.bouncycastle.jcajce.util.NamedJcaJceHelper;
import org.bouncycastle.jcajce.util.ProviderJcaJceHelper;

public class JcaSignedPublicKeyAndChallenge
  extends org.bouncycastle.mozilla.SignedPublicKeyAndChallenge
{
  JcaJceHelper helper = new DefaultJcaJceHelper();
  
  private JcaSignedPublicKeyAndChallenge(org.bouncycastle.asn1.mozilla.SignedPublicKeyAndChallenge paramSignedPublicKeyAndChallenge, JcaJceHelper paramJcaJceHelper)
  {
    super(paramSignedPublicKeyAndChallenge);
    this.helper = paramJcaJceHelper;
  }
  
  public JcaSignedPublicKeyAndChallenge(byte[] paramArrayOfByte)
  {
    super(paramArrayOfByte);
  }
  
  public PublicKey getPublicKey()
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException
  {
    try
    {
      Object localObject2 = this.spkacSeq.getPublicKeyAndChallenge().getSubjectPublicKeyInfo();
      Object localObject1 = new X509EncodedKeySpec(((SubjectPublicKeyInfo)localObject2).getEncoded());
      localObject2 = ((SubjectPublicKeyInfo)localObject2).getAlgorithm();
      localObject1 = this.helper.createKeyFactory(((AlgorithmIdentifier)localObject2).getAlgorithm().getId()).generatePublic((KeySpec)localObject1);
      return (PublicKey)localObject1;
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
    throw new InvalidKeyException("error encoding public key");
  }
  
  public JcaSignedPublicKeyAndChallenge setProvider(String paramString)
  {
    return new JcaSignedPublicKeyAndChallenge(this.spkacSeq, new NamedJcaJceHelper(paramString));
  }
  
  public JcaSignedPublicKeyAndChallenge setProvider(Provider paramProvider)
  {
    return new JcaSignedPublicKeyAndChallenge(this.spkacSeq, new ProviderJcaJceHelper(paramProvider));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\mozilla\jcajce\JcaSignedPublicKeyAndChallenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */