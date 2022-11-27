package org.bouncycastle.crypto.signers;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DSA;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class DSADigestSigner
  implements Signer
{
  private final Digest digest;
  private final DSA dsaSigner;
  private boolean forSigning;
  
  public DSADigestSigner(DSA paramDSA, Digest paramDigest)
  {
    this.digest = paramDigest;
    this.dsaSigner = paramDSA;
  }
  
  private BigInteger[] derDecode(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = (ASN1Sequence)ASN1Primitive.fromByteArray(paramArrayOfByte);
    return new BigInteger[] { ((ASN1Integer)paramArrayOfByte.getObjectAt(0)).getValue(), ((ASN1Integer)paramArrayOfByte.getObjectAt(1)).getValue() };
  }
  
  private byte[] derEncode(BigInteger paramBigInteger1, BigInteger paramBigInteger2)
    throws IOException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(paramBigInteger1));
    localASN1EncodableVector.add(new ASN1Integer(paramBigInteger2));
    return new DERSequence(localASN1EncodableVector).getEncoded("DER");
  }
  
  public byte[] generateSignature()
  {
    Object localObject;
    if (this.forSigning)
    {
      localObject = new byte[this.digest.getDigestSize()];
      this.digest.doFinal((byte[])localObject, 0);
      localObject = this.dsaSigner.generateSignature((byte[])localObject);
    }
    try
    {
      localObject = derEncode(localObject[0], localObject[1]);
      return (byte[])localObject;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    throw new IllegalStateException("unable to encode signature");
    throw new IllegalStateException("DSADigestSigner not initialised for signature generation.");
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    this.forSigning = paramBoolean;
    AsymmetricKeyParameter localAsymmetricKeyParameter;
    if ((paramCipherParameters instanceof ParametersWithRandom)) {
      localAsymmetricKeyParameter = (AsymmetricKeyParameter)((ParametersWithRandom)paramCipherParameters).getParameters();
    } else {
      localAsymmetricKeyParameter = (AsymmetricKeyParameter)paramCipherParameters;
    }
    if ((paramBoolean) && (!localAsymmetricKeyParameter.isPrivate())) {
      throw new IllegalArgumentException("Signing Requires Private Key.");
    }
    if ((!paramBoolean) && (localAsymmetricKeyParameter.isPrivate())) {
      throw new IllegalArgumentException("Verification Requires Public Key.");
    }
    reset();
    this.dsaSigner.init(paramBoolean, paramCipherParameters);
  }
  
  public void reset()
  {
    this.digest.reset();
  }
  
  public void update(byte paramByte)
  {
    this.digest.update(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte;
    if (!this.forSigning)
    {
      arrayOfByte = new byte[this.digest.getDigestSize()];
      this.digest.doFinal(arrayOfByte, 0);
    }
    try
    {
      paramArrayOfByte = derDecode(paramArrayOfByte);
      boolean bool = this.dsaSigner.verifySignature(arrayOfByte, paramArrayOfByte[0], paramArrayOfByte[1]);
      return bool;
    }
    catch (IOException paramArrayOfByte) {}
    throw new IllegalStateException("DSADigestSigner not initialised for verification");
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\signers\DSADigestSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */