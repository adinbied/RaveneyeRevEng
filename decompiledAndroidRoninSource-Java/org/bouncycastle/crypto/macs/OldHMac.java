package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;

public class OldHMac
  implements Mac
{
  private static final int BLOCK_LENGTH = 64;
  private static final byte IPAD = 54;
  private static final byte OPAD = 92;
  private Digest digest;
  private int digestSize;
  private byte[] inputPad = new byte[64];
  private byte[] outputPad = new byte[64];
  
  public OldHMac(Digest paramDigest)
  {
    this.digest = paramDigest;
    this.digestSize = paramDigest.getDigestSize();
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.digestSize;
    byte[] arrayOfByte1 = new byte[i];
    this.digest.doFinal(arrayOfByte1, 0);
    Digest localDigest = this.digest;
    byte[] arrayOfByte2 = this.outputPad;
    localDigest.update(arrayOfByte2, 0, arrayOfByte2.length);
    this.digest.update(arrayOfByte1, 0, i);
    paramInt = this.digest.doFinal(paramArrayOfByte, paramInt);
    reset();
    return paramInt;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.digest.getAlgorithmName());
    localStringBuilder.append("/HMAC");
    return localStringBuilder.toString();
  }
  
  public int getMacSize()
  {
    return this.digestSize;
  }
  
  public Digest getUnderlyingDigest()
  {
    return this.digest;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    this.digest.reset();
    paramCipherParameters = ((KeyParameter)paramCipherParameters).getKey();
    if (paramCipherParameters.length > 64)
    {
      this.digest.update(paramCipherParameters, 0, paramCipherParameters.length);
      this.digest.doFinal(this.inputPad, 0);
      i = this.digestSize;
      for (;;)
      {
        paramCipherParameters = this.inputPad;
        if (i >= paramCipherParameters.length) {
          break;
        }
        paramCipherParameters[i] = 0;
        i += 1;
      }
    }
    System.arraycopy(paramCipherParameters, 0, this.inputPad, 0, paramCipherParameters.length);
    int i = paramCipherParameters.length;
    for (;;)
    {
      paramCipherParameters = this.inputPad;
      if (i >= paramCipherParameters.length) {
        break;
      }
      paramCipherParameters[i] = 0;
      i += 1;
    }
    paramCipherParameters = this.inputPad;
    byte[] arrayOfByte = new byte[paramCipherParameters.length];
    this.outputPad = arrayOfByte;
    System.arraycopy(paramCipherParameters, 0, arrayOfByte, 0, paramCipherParameters.length);
    i = 0;
    for (;;)
    {
      paramCipherParameters = this.inputPad;
      if (i >= paramCipherParameters.length) {
        break;
      }
      paramCipherParameters[i] = ((byte)(paramCipherParameters[i] ^ 0x36));
      i += 1;
    }
    i = 0;
    for (;;)
    {
      paramCipherParameters = this.outputPad;
      if (i >= paramCipherParameters.length) {
        break;
      }
      paramCipherParameters[i] = ((byte)(paramCipherParameters[i] ^ 0x5C));
      i += 1;
    }
    paramCipherParameters = this.digest;
    arrayOfByte = this.inputPad;
    paramCipherParameters.update(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void reset()
  {
    this.digest.reset();
    Digest localDigest = this.digest;
    byte[] arrayOfByte = this.inputPad;
    localDigest.update(arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void update(byte paramByte)
  {
    this.digest.update(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.digest.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\OldHMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */