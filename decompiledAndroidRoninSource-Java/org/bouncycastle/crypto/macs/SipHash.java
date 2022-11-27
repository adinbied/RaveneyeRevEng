package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class SipHash
  implements Mac
{
  protected final int c;
  protected final int d;
  protected long k0;
  protected long k1;
  protected long m = 0L;
  protected long v0;
  protected long v1;
  protected long v2;
  protected long v3;
  protected int wordCount = 0;
  protected int wordPos = 0;
  
  public SipHash()
  {
    this.c = 2;
    this.d = 4;
  }
  
  public SipHash(int paramInt1, int paramInt2)
  {
    this.c = paramInt1;
    this.d = paramInt2;
  }
  
  protected static long rotateLeft(long paramLong, int paramInt)
  {
    return paramLong >>> -paramInt | paramLong << paramInt;
  }
  
  protected void applySipRounds(int paramInt)
  {
    long l4 = this.v0;
    long l2 = this.v1;
    long l3 = this.v2;
    long l1 = this.v3;
    int i = 0;
    while (i < paramInt)
    {
      l4 += l2;
      l3 += l1;
      l2 = rotateLeft(l2, 13);
      long l5 = rotateLeft(l1, 16);
      l1 = l2 ^ l4;
      l2 = l5 ^ l3;
      l4 = rotateLeft(l4, 32);
      l3 += l1;
      l4 += l2;
      l1 = rotateLeft(l1, 17);
      l5 = rotateLeft(l2, 21);
      l2 = l1 ^ l3;
      l1 = l5 ^ l4;
      l3 = rotateLeft(l3, 32);
      i += 1;
    }
    this.v0 = l4;
    this.v1 = l2;
    this.v2 = l3;
    this.v3 = l1;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException
  {
    Pack.longToLittleEndian(doFinal(), paramArrayOfByte, paramInt);
    return 8;
  }
  
  public long doFinal()
    throws DataLengthException, IllegalStateException
  {
    long l1 = this.m;
    int i = this.wordPos;
    l1 >>>= 7 - i << 3;
    this.m = l1;
    l1 >>>= 8;
    this.m = l1;
    this.m = (l1 | ((this.wordCount << 3) + i & 0xFF) << 56);
    processMessageWord();
    this.v2 ^= 0xFF;
    applySipRounds(this.d);
    l1 = this.v0;
    long l2 = this.v1;
    long l3 = this.v2;
    long l4 = this.v3;
    reset();
    return l1 ^ l2 ^ l3 ^ l4;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SipHash-");
    localStringBuilder.append(this.c);
    localStringBuilder.append("-");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
  
  public int getMacSize()
  {
    return 8;
  }
  
  public void init(CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      paramCipherParameters = ((KeyParameter)paramCipherParameters).getKey();
      if (paramCipherParameters.length == 16)
      {
        this.k0 = Pack.littleEndianToLong(paramCipherParameters, 0);
        this.k1 = Pack.littleEndianToLong(paramCipherParameters, 8);
        reset();
        return;
      }
      throw new IllegalArgumentException("'params' must be a 128-bit key");
    }
    throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
  }
  
  protected void processMessageWord()
  {
    this.wordCount += 1;
    this.v3 ^= this.m;
    applySipRounds(this.c);
    this.v0 ^= this.m;
  }
  
  public void reset()
  {
    long l1 = this.k0;
    this.v0 = (0x736F6D6570736575 ^ l1);
    long l2 = this.k1;
    this.v1 = (0x646F72616E646F6D ^ l2);
    this.v2 = (l1 ^ 0x6C7967656E657261);
    this.v3 = (0x7465646279746573 ^ l2);
    this.m = 0L;
    this.wordPos = 0;
    this.wordCount = 0;
  }
  
  public void update(byte paramByte)
    throws IllegalStateException
  {
    long l = this.m >>> 8;
    this.m = l;
    this.m = (l | (paramByte & 0xFF) << 56);
    paramByte = this.wordPos + 1;
    this.wordPos = paramByte;
    if (paramByte == 8)
    {
      processMessageWord();
      this.wordPos = 0;
    }
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int k = paramInt2 & 0xFFFFFFF8;
    int j = this.wordPos;
    int i = 0;
    long l;
    if (j == 0)
    {
      for (;;)
      {
        j = i;
        if (i >= k) {
          break;
        }
        this.m = Pack.littleEndianToLong(paramArrayOfByte, paramInt1 + i);
        processMessageWord();
        i += 8;
      }
      while (j < paramInt2)
      {
        l = this.m >>> 8;
        this.m = l;
        this.m = (l | (paramArrayOfByte[(paramInt1 + j)] & 0xFF) << 56);
        j += 1;
      }
      this.wordPos = (paramInt2 - k);
      return;
    }
    int n = j << 3;
    i = 0;
    for (;;)
    {
      j = i;
      if (i >= k) {
        break;
      }
      l = Pack.littleEndianToLong(paramArrayOfByte, paramInt1 + i);
      this.m = (this.m >>> -n | l << n);
      processMessageWord();
      this.m = l;
      i += 8;
    }
    while (j < paramInt2)
    {
      l = this.m >>> 8;
      this.m = l;
      this.m = (l | (paramArrayOfByte[(paramInt1 + j)] & 0xFF) << 56);
      i = this.wordPos + 1;
      this.wordPos = i;
      if (i == 8)
      {
        processMessageWord();
        this.wordPos = 0;
      }
      j += 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\SipHash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */