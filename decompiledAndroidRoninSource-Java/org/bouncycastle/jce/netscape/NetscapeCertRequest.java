package org.bouncycastle.jce.netscape;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;

public class NetscapeCertRequest
  extends ASN1Object
{
  String challenge;
  DERBitString content;
  AlgorithmIdentifier keyAlg;
  PublicKey pubkey;
  AlgorithmIdentifier sigAlg;
  byte[] sigBits;
  
  public NetscapeCertRequest(String paramString, AlgorithmIdentifier paramAlgorithmIdentifier, PublicKey paramPublicKey)
    throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException
  {
    this.challenge = paramString;
    this.sigAlg = paramAlgorithmIdentifier;
    this.pubkey = paramPublicKey;
    paramAlgorithmIdentifier = new ASN1EncodableVector();
    paramAlgorithmIdentifier.add(getKeySpec());
    paramAlgorithmIdentifier.add(new DERIA5String(paramString));
    try
    {
      this.content = new DERBitString(new DERSequence(paramAlgorithmIdentifier));
      return;
    }
    catch (IOException paramString)
    {
      paramAlgorithmIdentifier = new StringBuilder();
      paramAlgorithmIdentifier.append("exception encoding key: ");
      paramAlgorithmIdentifier.append(paramString.toString());
      throw new InvalidKeySpecException(paramAlgorithmIdentifier.toString());
    }
  }
  
  public NetscapeCertRequest(ASN1Sequence paramASN1Sequence)
  {
    try
    {
      if (paramASN1Sequence.size() == 3)
      {
        this.sigAlg = AlgorithmIdentifier.getInstance(paramASN1Sequence.getObjectAt(1));
        this.sigBits = ((DERBitString)paramASN1Sequence.getObjectAt(2)).getOctets();
        paramASN1Sequence = (ASN1Sequence)paramASN1Sequence.getObjectAt(0);
        if (paramASN1Sequence.size() == 2)
        {
          this.challenge = ((DERIA5String)paramASN1Sequence.getObjectAt(1)).getString();
          this.content = new DERBitString(paramASN1Sequence);
          localObject = SubjectPublicKeyInfo.getInstance(paramASN1Sequence.getObjectAt(0));
          paramASN1Sequence = new X509EncodedKeySpec(new DERBitString((ASN1Encodable)localObject).getBytes());
          localObject = ((SubjectPublicKeyInfo)localObject).getAlgorithm();
          this.keyAlg = ((AlgorithmIdentifier)localObject);
          this.pubkey = KeyFactory.getInstance(((AlgorithmIdentifier)localObject).getAlgorithm().getId(), "BC").generatePublic(paramASN1Sequence);
          return;
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("invalid PKAC (len): ");
        ((StringBuilder)localObject).append(paramASN1Sequence.size());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("invalid SPKAC (size):");
      ((StringBuilder)localObject).append(paramASN1Sequence.size());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    catch (Exception paramASN1Sequence)
    {
      throw new IllegalArgumentException(paramASN1Sequence.toString());
    }
  }
  
  public NetscapeCertRequest(byte[] paramArrayOfByte)
    throws IOException
  {
    this(getReq(paramArrayOfByte));
  }
  
  private ASN1Primitive getKeySpec()
    throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchProviderException
  {
    Object localObject = new ByteArrayOutputStream();
    try
    {
      ((ByteArrayOutputStream)localObject).write(this.pubkey.getEncoded());
      ((ByteArrayOutputStream)localObject).close();
      localObject = new ASN1InputStream(new ByteArrayInputStream(((ByteArrayOutputStream)localObject).toByteArray())).readObject();
      return (ASN1Primitive)localObject;
    }
    catch (IOException localIOException)
    {
      throw new InvalidKeySpecException(localIOException.getMessage());
    }
  }
  
  private static ASN1Sequence getReq(byte[] paramArrayOfByte)
    throws IOException
  {
    return ASN1Sequence.getInstance(new ASN1InputStream(new ByteArrayInputStream(paramArrayOfByte)).readObject());
  }
  
  public String getChallenge()
  {
    return this.challenge;
  }
  
  public AlgorithmIdentifier getKeyAlgorithm()
  {
    return this.keyAlg;
  }
  
  public PublicKey getPublicKey()
  {
    return this.pubkey;
  }
  
  public AlgorithmIdentifier getSigningAlgorithm()
  {
    return this.sigAlg;
  }
  
  public void setChallenge(String paramString)
  {
    this.challenge = paramString;
  }
  
  public void setKeyAlgorithm(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.keyAlg = paramAlgorithmIdentifier;
  }
  
  public void setPublicKey(PublicKey paramPublicKey)
  {
    this.pubkey = paramPublicKey;
  }
  
  public void setSigningAlgorithm(AlgorithmIdentifier paramAlgorithmIdentifier)
  {
    this.sigAlg = paramAlgorithmIdentifier;
  }
  
  public void sign(PrivateKey paramPrivateKey)
    throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException, InvalidKeySpecException
  {
    sign(paramPrivateKey, null);
  }
  
  public void sign(PrivateKey paramPrivateKey, SecureRandom paramSecureRandom)
    throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException, InvalidKeySpecException
  {
    Signature localSignature = Signature.getInstance(this.sigAlg.getAlgorithm().getId(), "BC");
    if (paramSecureRandom != null) {
      localSignature.initSign(paramPrivateKey, paramSecureRandom);
    } else {
      localSignature.initSign(paramPrivateKey);
    }
    paramPrivateKey = new ASN1EncodableVector();
    paramPrivateKey.add(getKeySpec());
    paramPrivateKey.add(new DERIA5String(this.challenge));
    try
    {
      localSignature.update(new DERSequence(paramPrivateKey).getEncoded("DER"));
      this.sigBits = localSignature.sign();
      return;
    }
    catch (IOException paramPrivateKey)
    {
      throw new SignatureException(paramPrivateKey.getMessage());
    }
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    ASN1EncodableVector localASN1EncodableVector1 = new ASN1EncodableVector();
    ASN1EncodableVector localASN1EncodableVector2 = new ASN1EncodableVector();
    try
    {
      localASN1EncodableVector2.add(getKeySpec());
      localASN1EncodableVector2.add(new DERIA5String(this.challenge));
      localASN1EncodableVector1.add(new DERSequence(localASN1EncodableVector2));
      localASN1EncodableVector1.add(this.sigAlg);
      localASN1EncodableVector1.add(new DERBitString(this.sigBits));
      return new DERSequence(localASN1EncodableVector1);
    }
    catch (Exception localException)
    {
      for (;;) {}
    }
  }
  
  public boolean verify(String paramString)
    throws NoSuchAlgorithmException, InvalidKeyException, SignatureException, NoSuchProviderException
  {
    if (!paramString.equals(this.challenge)) {
      return false;
    }
    paramString = Signature.getInstance(this.sigAlg.getAlgorithm().getId(), "BC");
    paramString.initVerify(this.pubkey);
    paramString.update(this.content.getBytes());
    return paramString.verify(this.sigBits);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\netscape\NetscapeCertRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */