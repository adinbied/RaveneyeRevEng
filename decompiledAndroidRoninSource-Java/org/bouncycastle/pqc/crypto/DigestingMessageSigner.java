package org.bouncycastle.pqc.crypto;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Signer;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.ParametersWithRandom;

public class DigestingMessageSigner
  implements Signer
{
  private boolean forSigning;
  private final Digest messDigest;
  private final MessageSigner messSigner;
  
  public DigestingMessageSigner(MessageSigner paramMessageSigner, Digest paramDigest)
  {
    this.messSigner = paramMessageSigner;
    this.messDigest = paramDigest;
  }
  
  public byte[] generateSignature()
  {
    if (this.forSigning)
    {
      byte[] arrayOfByte = new byte[this.messDigest.getDigestSize()];
      this.messDigest.doFinal(arrayOfByte, 0);
      return this.messSigner.generateSignature(arrayOfByte);
    }
    throw new IllegalStateException("DigestingMessageSigner not initialised for signature generation.");
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
    this.messSigner.init(paramBoolean, paramCipherParameters);
  }
  
  public void reset()
  {
    this.messDigest.reset();
  }
  
  public void update(byte paramByte)
  {
    this.messDigest.update(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.messDigest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte)
  {
    if (!this.forSigning)
    {
      byte[] arrayOfByte = new byte[this.messDigest.getDigestSize()];
      this.messDigest.doFinal(arrayOfByte, 0);
      return this.messSigner.verifySignature(arrayOfByte, paramArrayOfByte);
    }
    throw new IllegalStateException("DigestingMessageSigner not initialised for verification");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\DigestingMessageSigner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */