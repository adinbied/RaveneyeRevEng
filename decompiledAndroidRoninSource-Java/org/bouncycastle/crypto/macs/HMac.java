package org.bouncycastle.crypto.macs;

import java.util.Hashtable;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Memoable;

public class HMac
  implements Mac
{
  private static final byte IPAD = 54;
  private static final byte OPAD = 92;
  private static Hashtable blockLengths;
  private int blockLength;
  private Digest digest;
  private int digestSize;
  private byte[] inputPad;
  private Memoable ipadState;
  private Memoable opadState;
  private byte[] outputBuf;
  
  static
  {
    Hashtable localHashtable = new Hashtable();
    blockLengths = localHashtable;
    localHashtable.put("GOST3411", Integers.valueOf(32));
    blockLengths.put("MD2", Integers.valueOf(16));
    blockLengths.put("MD4", Integers.valueOf(64));
    blockLengths.put("MD5", Integers.valueOf(64));
    blockLengths.put("RIPEMD128", Integers.valueOf(64));
    blockLengths.put("RIPEMD160", Integers.valueOf(64));
    blockLengths.put("SHA-1", Integers.valueOf(64));
    blockLengths.put("SHA-224", Integers.valueOf(64));
    blockLengths.put("SHA-256", Integers.valueOf(64));
    blockLengths.put("SHA-384", Integers.valueOf(128));
    blockLengths.put("SHA-512", Integers.valueOf(128));
    blockLengths.put("Tiger", Integers.valueOf(64));
    blockLengths.put("Whirlpool", Integers.valueOf(64));
  }
  
  public HMac(Digest paramDigest)
  {
    this(paramDigest, getByteLength(paramDigest));
  }
  
  private HMac(Digest paramDigest, int paramInt)
  {
    this.digest = paramDigest;
    int i = paramDigest.getDigestSize();
    this.digestSize = i;
    this.blockLength = paramInt;
    this.inputPad = new byte[paramInt];
    this.outputBuf = new byte[paramInt + i];
  }
  
  private static int getByteLength(Digest paramDigest)
  {
    if ((paramDigest instanceof ExtendedDigest)) {
      return ((ExtendedDigest)paramDigest).getByteLength();
    }
    Object localObject = (Integer)blockLengths.get(paramDigest.getAlgorithmName());
    if (localObject != null) {
      return ((Integer)localObject).intValue();
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown digest passed: ");
    ((StringBuilder)localObject).append(paramDigest.getAlgorithmName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  private static void xorPad(byte[] paramArrayOfByte, int paramInt, byte paramByte)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramArrayOfByte[i] = ((byte)(paramArrayOfByte[i] ^ paramByte));
      i += 1;
    }
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    this.digest.doFinal(this.outputBuf, this.blockLength);
    Object localObject = this.opadState;
    if (localObject != null)
    {
      ((Memoable)this.digest).reset((Memoable)localObject);
      localObject = this.digest;
      ((Digest)localObject).update(this.outputBuf, this.blockLength, ((Digest)localObject).getDigestSize());
    }
    else
    {
      localObject = this.digest;
      byte[] arrayOfByte = this.outputBuf;
      ((Digest)localObject).update(arrayOfByte, 0, arrayOfByte.length);
    }
    int i = this.digest.doFinal(paramArrayOfByte, paramInt);
    paramInt = this.blockLength;
    for (;;)
    {
      paramArrayOfByte = this.outputBuf;
      if (paramInt >= paramArrayOfByte.length) {
        break;
      }
      paramArrayOfByte[paramInt] = 0;
      paramInt += 1;
    }
    paramArrayOfByte = this.ipadState;
    if (paramArrayOfByte != null)
    {
      ((Memoable)this.digest).reset(paramArrayOfByte);
      return i;
    }
    paramArrayOfByte = this.digest;
    localObject = this.inputPad;
    paramArrayOfByte.update((byte[])localObject, 0, localObject.length);
    return i;
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
    int i = paramCipherParameters.length;
    if (i > this.blockLength)
    {
      this.digest.update(paramCipherParameters, 0, i);
      this.digest.doFinal(this.inputPad, 0);
      i = this.digestSize;
    }
    else
    {
      System.arraycopy(paramCipherParameters, 0, this.inputPad, 0, i);
    }
    for (;;)
    {
      paramCipherParameters = this.inputPad;
      if (i >= paramCipherParameters.length) {
        break;
      }
      paramCipherParameters[i] = 0;
      i += 1;
    }
    System.arraycopy(paramCipherParameters, 0, this.outputBuf, 0, this.blockLength);
    xorPad(this.inputPad, this.blockLength, (byte)54);
    xorPad(this.outputBuf, this.blockLength, (byte)92);
    paramCipherParameters = this.digest;
    if ((paramCipherParameters instanceof Memoable))
    {
      paramCipherParameters = ((Memoable)paramCipherParameters).copy();
      this.opadState = paramCipherParameters;
      ((Digest)paramCipherParameters).update(this.outputBuf, 0, this.blockLength);
    }
    paramCipherParameters = this.digest;
    byte[] arrayOfByte = this.inputPad;
    paramCipherParameters.update(arrayOfByte, 0, arrayOfByte.length);
    paramCipherParameters = this.digest;
    if ((paramCipherParameters instanceof Memoable)) {
      this.ipadState = ((Memoable)paramCipherParameters).copy();
    }
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\HMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */