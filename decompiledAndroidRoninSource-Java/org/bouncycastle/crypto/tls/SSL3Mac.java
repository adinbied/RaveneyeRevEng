package org.bouncycastle.crypto.tls;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Arrays;

public class SSL3Mac
  implements Mac
{
  static final byte[] IPAD = genPad(, 48);
  private static final byte IPAD_BYTE = 54;
  static final byte[] OPAD = genPad((byte)92, 48);
  private static final byte OPAD_BYTE = 92;
  private Digest digest;
  private int padLength;
  private byte[] secret;
  
  public SSL3Mac(Digest paramDigest)
  {
    this.digest = paramDigest;
    int i;
    if (paramDigest.getDigestSize() == 20) {
      i = 40;
    } else {
      i = 48;
    }
    this.padLength = i;
  }
  
  private static byte[] genPad(byte paramByte, int paramInt)
  {
    byte[] arrayOfByte = new byte[paramInt];
    Arrays.fill(arrayOfByte, paramByte);
    return arrayOfByte;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.digest.getDigestSize();
    byte[] arrayOfByte1 = new byte[i];
    this.digest.doFinal(arrayOfByte1, 0);
    Digest localDigest = this.digest;
    byte[] arrayOfByte2 = this.secret;
    localDigest.update(arrayOfByte2, 0, arrayOfByte2.length);
    this.digest.update(OPAD, 0, this.padLength);
    this.digest.update(arrayOfByte1, 0, i);
    paramInt = this.digest.doFinal(paramArrayOfByte, paramInt);
    reset();
    return paramInt;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.digest.getAlgorithmName());
    localStringBuilder.append("/SSL3MAC");
    return localStringBuilder.toString();
  }
  
  public int getMacSize()
  {
    return this.digest.getDigestSize();
  }
  
  public Digest getUnderlyingDigest()
  {
    return this.digest;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    this.secret = Arrays.clone(((KeyParameter)paramCipherParameters).getKey());
    reset();
  }
  
  public void reset()
  {
    this.digest.reset();
    Digest localDigest = this.digest;
    byte[] arrayOfByte = this.secret;
    localDigest.update(arrayOfByte, 0, arrayOfByte.length);
    this.digest.update(IPAD, 0, this.padLength);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\SSL3Mac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */