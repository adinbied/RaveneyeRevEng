package org.bouncycastle.mozilla;

import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.mozilla.PublicKeyAndChallenge;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.util.Encodable;

public class SignedPublicKeyAndChallenge
  implements Encodable
{
  protected final org.bouncycastle.asn1.mozilla.SignedPublicKeyAndChallenge spkacSeq;
  
  protected SignedPublicKeyAndChallenge(org.bouncycastle.asn1.mozilla.SignedPublicKeyAndChallenge paramSignedPublicKeyAndChallenge)
  {
    this.spkacSeq = paramSignedPublicKeyAndChallenge;
  }
  
  public SignedPublicKeyAndChallenge(byte[] paramArrayOfByte)
  {
    this.spkacSeq = org.bouncycastle.asn1.mozilla.SignedPublicKeyAndChallenge.getInstance(paramArrayOfByte);
  }
  
  public String getChallenge()
  {
    return this.spkacSeq.getPublicKeyAndChallenge().getChallenge().getString();
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return toASN1Structure().getEncoded();
  }
  
  public PublicKey getPublicKey(String paramString)
    throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException
  {
    SubjectPublicKeyInfo localSubjectPublicKeyInfo = this.spkacSeq.getPublicKeyAndChallenge().getSubjectPublicKeyInfo();
    try
    {
      X509EncodedKeySpec localX509EncodedKeySpec = new X509EncodedKeySpec(new DERBitString(localSubjectPublicKeyInfo).getOctets());
      paramString = KeyFactory.getInstance(localSubjectPublicKeyInfo.getAlgorithm().getAlgorithm().getId(), paramString).generatePublic(localX509EncodedKeySpec);
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    throw new InvalidKeyException("error encoding public key");
  }
  
  public PublicKeyAndChallenge getPublicKeyAndChallenge()
  {
    return this.spkacSeq.getPublicKeyAndChallenge();
  }
  
  public SubjectPublicKeyInfo getSubjectPublicKeyInfo()
  {
    return this.spkacSeq.getPublicKeyAndChallenge().getSubjectPublicKeyInfo();
  }
  
  public boolean isSignatureValid(ContentVerifierProvider paramContentVerifierProvider)
    throws OperatorCreationException, IOException
  {
    paramContentVerifierProvider = paramContentVerifierProvider.get(this.spkacSeq.getSignatureAlgorithm());
    OutputStream localOutputStream = paramContentVerifierProvider.getOutputStream();
    new DEROutputStream(localOutputStream).writeObject(this.spkacSeq.getPublicKeyAndChallenge());
    localOutputStream.close();
    return paramContentVerifierProvider.verify(this.spkacSeq.getSignature().getOctets());
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.spkacSeq.toASN1Primitive();
  }
  
  public org.bouncycastle.asn1.mozilla.SignedPublicKeyAndChallenge toASN1Structure()
  {
    return this.spkacSeq;
  }
  
  public boolean verify()
    throws NoSuchAlgorithmException, SignatureException, NoSuchProviderException, InvalidKeyException
  {
    return verify((String)null);
  }
  
  public boolean verify(String paramString)
    throws NoSuchAlgorithmException, SignatureException, NoSuchProviderException, InvalidKeyException
  {
    Object localObject = this.spkacSeq.getSignatureAlgorithm().getAlgorithm().getId();
    if (paramString == null) {
      localObject = Signature.getInstance((String)localObject);
    } else {
      localObject = Signature.getInstance((String)localObject, paramString);
    }
    ((Signature)localObject).initVerify(getPublicKey(paramString));
    try
    {
      ((Signature)localObject).update(this.spkacSeq.getPublicKeyAndChallenge().getEncoded());
      boolean bool = ((Signature)localObject).verify(this.spkacSeq.getSignature().getBytes());
      return bool;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    throw new InvalidKeyException("error encoding public key");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\mozilla\SignedPublicKeyAndChallenge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */