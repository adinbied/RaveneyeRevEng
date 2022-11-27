package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

public class Poly1305
  implements Mac
{
  private static final int BLOCK_SIZE = 16;
  private final BlockCipher cipher;
  private final byte[] currentBlock = new byte[16];
  private int currentBlockOffset = 0;
  private int h0;
  private int h1;
  private int h2;
  private int h3;
  private int h4;
  private int k0;
  private int k1;
  private int k2;
  private int k3;
  private int r0;
  private int r1;
  private int r2;
  private int r3;
  private int r4;
  private int s1;
  private int s2;
  private int s3;
  private int s4;
  private final byte[] singleByte = new byte[1];
  
  public Poly1305()
  {
    this.cipher = null;
  }
  
  public Poly1305(BlockCipher paramBlockCipher)
  {
    if (paramBlockCipher.getBlockSize() == 16)
    {
      this.cipher = paramBlockCipher;
      return;
    }
    throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
  }
  
  private static final long mul32x32_64(int paramInt1, int paramInt2)
  {
    return (paramInt1 & 0xFFFFFFFF) * paramInt2;
  }
  
  private void processBlock()
  {
    int i = this.currentBlockOffset;
    if (i < 16)
    {
      this.currentBlock[i] = 1;
      i += 1;
      while (i < 16)
      {
        this.currentBlock[i] = 0;
        i += 1;
      }
    }
    long l1 = Pack.littleEndianToInt(this.currentBlock, 0) & 0xFFFFFFFF;
    long l2 = Pack.littleEndianToInt(this.currentBlock, 4) & 0xFFFFFFFF;
    long l3 = Pack.littleEndianToInt(this.currentBlock, 8) & 0xFFFFFFFF;
    long l4 = 0xFFFFFFFF & Pack.littleEndianToInt(this.currentBlock, 12);
    this.h0 = ((int)(this.h0 + (l1 & 0x3FFFFFF)));
    this.h1 = ((int)(this.h1 + ((l2 << 32 | l1) >>> 26 & 0x3FFFFFF)));
    this.h2 = ((int)(this.h2 + ((l2 | l3 << 32) >>> 20 & 0x3FFFFFF)));
    this.h3 = ((int)(this.h3 + ((l4 << 32 | l3) >>> 14 & 0x3FFFFFF)));
    i = (int)(this.h4 + (l4 >>> 8));
    this.h4 = i;
    if (this.currentBlockOffset == 16) {
      this.h4 = (i + 16777216);
    }
    long l16 = mul32x32_64(this.h0, this.r0) + mul32x32_64(this.h1, this.s4) + mul32x32_64(this.h2, this.s3) + mul32x32_64(this.h3, this.s2) + mul32x32_64(this.h4, this.s1);
    long l17 = mul32x32_64(this.h0, this.r1);
    long l18 = mul32x32_64(this.h1, this.r0);
    long l19 = mul32x32_64(this.h2, this.s4);
    long l20 = mul32x32_64(this.h3, this.s3);
    long l21 = mul32x32_64(this.h4, this.s2);
    long l11 = mul32x32_64(this.h0, this.r2);
    long l12 = mul32x32_64(this.h1, this.r1);
    long l13 = mul32x32_64(this.h2, this.r0);
    long l14 = mul32x32_64(this.h3, this.s4);
    long l15 = mul32x32_64(this.h4, this.s3);
    long l6 = mul32x32_64(this.h0, this.r3);
    long l7 = mul32x32_64(this.h1, this.r2);
    long l8 = mul32x32_64(this.h2, this.r1);
    long l9 = mul32x32_64(this.h3, this.r0);
    long l10 = mul32x32_64(this.h4, this.s4);
    l1 = mul32x32_64(this.h0, this.r4);
    l2 = mul32x32_64(this.h1, this.r3);
    l3 = mul32x32_64(this.h2, this.r2);
    l4 = mul32x32_64(this.h3, this.r1);
    long l5 = mul32x32_64(this.h4, this.r0);
    int j = (int)l16 & 0x3FFFFFF;
    this.h0 = j;
    l16 = l17 + l18 + l19 + l20 + l21 + (l16 >>> 26);
    i = (int)l16 & 0x3FFFFFF;
    this.h1 = i;
    l11 = l11 + l12 + l13 + l14 + l15 + (l16 >>> 26);
    this.h2 = ((int)l11 & 0x3FFFFFF);
    l6 = l6 + l7 + l8 + l9 + l10 + (l11 >>> 26);
    this.h3 = ((int)l6 & 0x3FFFFFF);
    l1 = l1 + l2 + l3 + l4 + l5 + (l6 >>> 26);
    this.h4 = ((int)l1 & 0x3FFFFFF);
    j += (int)(l1 >>> 26) * 5;
    this.h0 = j;
    this.h1 = (i + (j >>> 26));
    this.h0 = (j & 0x3FFFFFF);
  }
  
  private void setKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1.length == 32)
    {
      Object localObject = this.cipher;
      int i = 16;
      if ((localObject != null) && ((paramArrayOfByte2 == null) || (paramArrayOfByte2.length != 16))) {
        throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
      }
      int k = Pack.littleEndianToInt(paramArrayOfByte1, 0);
      int n = Pack.littleEndianToInt(paramArrayOfByte1, 4);
      int m = Pack.littleEndianToInt(paramArrayOfByte1, 8);
      int j = Pack.littleEndianToInt(paramArrayOfByte1, 12);
      this.r0 = (0x3FFFFFF & k);
      k = (k >>> 26 | n << 6) & 0x3FFFF03;
      this.r1 = k;
      n = (n >>> 20 | m << 12) & 0x3FFC0FF;
      this.r2 = n;
      m = (m >>> 14 | j << 18) & 0x3F03FFF;
      this.r3 = m;
      j = j >>> 8 & 0xFFFFF;
      this.r4 = j;
      this.s1 = (k * 5);
      this.s2 = (n * 5);
      this.s3 = (m * 5);
      this.s4 = (j * 5);
      BlockCipher localBlockCipher = this.cipher;
      if (localBlockCipher != null)
      {
        localObject = new byte[16];
        localBlockCipher.init(true, new KeyParameter(paramArrayOfByte1, 16, 16));
        this.cipher.processBlock(paramArrayOfByte2, 0, (byte[])localObject, 0);
        paramArrayOfByte1 = (byte[])localObject;
        i = 0;
      }
      this.k0 = Pack.littleEndianToInt(paramArrayOfByte1, i + 0);
      this.k1 = Pack.littleEndianToInt(paramArrayOfByte1, i + 4);
      this.k2 = Pack.littleEndianToInt(paramArrayOfByte1, i + 8);
      this.k3 = Pack.littleEndianToInt(paramArrayOfByte1, i + 12);
      return;
    }
    throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException
  {
    if (paramInt + 16 <= paramArrayOfByte.length)
    {
      if (this.currentBlockOffset > 0) {
        processBlock();
      }
      int j = this.h1;
      int i = this.h0;
      j += (i >>> 26);
      this.h1 = j;
      int k = i & 0x3FFFFFF;
      this.h0 = k;
      i = this.h2 + (j >>> 26);
      this.h2 = i;
      int m = j & 0x3FFFFFF;
      this.h1 = m;
      j = this.h3 + (i >>> 26);
      this.h3 = j;
      i &= 0x3FFFFFF;
      this.h2 = i;
      int n = this.h4 + (j >>> 26);
      this.h4 = n;
      j &= 0x3FFFFFF;
      this.h3 = j;
      int i1 = k + (n >>> 26) * 5;
      this.h0 = i1;
      k = n & 0x3FFFFFF;
      this.h4 = k;
      int i4 = m + (i1 >>> 26);
      this.h1 = i4;
      int i3 = i1 & 0x3FFFFFF;
      this.h0 = i3;
      int i7 = i3 + 5;
      int i6 = (i7 >>> 26) + i4;
      int i5 = (i6 >>> 26) + i;
      int i2 = (i5 >>> 26) + j;
      m = (i2 >>> 26) + k - 67108864;
      n = (m >>> 31) - 1;
      i1 = n;
      i3 = i3 & i1 | i7 & 0x3FFFFFF & n;
      this.h0 = i3;
      i4 = i4 & i1 | i6 & 0x3FFFFFF & n;
      this.h1 = i4;
      i = i & i1 | i5 & 0x3FFFFFF & n;
      this.h2 = i;
      j = 0x3FFFFFF & i2 & n | j & i1;
      this.h3 = j;
      k = k & i1 | m & n;
      this.h4 = k;
      long l5 = ((i3 | i4 << 26) & 0xFFFFFFFF) + (this.k0 & 0xFFFFFFFF);
      long l6 = i4 >>> 6 | i << 20;
      long l7 = this.k1;
      long l3 = i >>> 12 | j << 14;
      long l4 = this.k2;
      long l1 = j >>> 18 | k << 8;
      long l2 = this.k3;
      Pack.intToLittleEndian((int)l5, paramArrayOfByte, paramInt);
      l5 = (l6 & 0xFFFFFFFF) + (l7 & 0xFFFFFFFF) + (l5 >>> 32);
      Pack.intToLittleEndian((int)l5, paramArrayOfByte, paramInt + 4);
      l3 = (l3 & 0xFFFFFFFF) + (l4 & 0xFFFFFFFF) + (l5 >>> 32);
      Pack.intToLittleEndian((int)l3, paramArrayOfByte, paramInt + 8);
      Pack.intToLittleEndian((int)((l1 & 0xFFFFFFFF) + (0xFFFFFFFF & l2) + (l3 >>> 32)), paramArrayOfByte, paramInt + 12);
      reset();
      return 16;
    }
    throw new DataLengthException("Output buffer is too short.");
  }
  
  public String getAlgorithmName()
  {
    if (this.cipher == null) {
      return "Poly1305";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Poly1305-");
    localStringBuilder.append(this.cipher.getAlgorithmName());
    return localStringBuilder.toString();
  }
  
  public int getMacSize()
  {
    return 16;
  }
  
  public void init(CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    Object localObject1;
    if (this.cipher != null)
    {
      if ((paramCipherParameters instanceof ParametersWithIV))
      {
        localObject1 = (ParametersWithIV)paramCipherParameters;
        paramCipherParameters = ((ParametersWithIV)localObject1).getIV();
        localObject1 = ((ParametersWithIV)localObject1).getParameters();
      }
      else
      {
        throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
      }
    }
    else
    {
      Object localObject2 = null;
      localObject1 = paramCipherParameters;
      paramCipherParameters = (CipherParameters)localObject2;
    }
    if ((localObject1 instanceof KeyParameter))
    {
      setKey(((KeyParameter)localObject1).getKey(), paramCipherParameters);
      reset();
      return;
    }
    throw new IllegalArgumentException("Poly1305 requires a key.");
  }
  
  public void reset()
  {
    this.currentBlockOffset = 0;
    this.h4 = 0;
    this.h3 = 0;
    this.h2 = 0;
    this.h1 = 0;
    this.h0 = 0;
  }
  
  public void update(byte paramByte)
    throws IllegalStateException
  {
    byte[] arrayOfByte = this.singleByte;
    arrayOfByte[0] = paramByte;
    update(arrayOfByte, 0, 1);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int i = 0;
    while (paramInt2 > i)
    {
      if (this.currentBlockOffset == 16)
      {
        processBlock();
        this.currentBlockOffset = 0;
      }
      int j = Math.min(paramInt2 - i, 16 - this.currentBlockOffset);
      System.arraycopy(paramArrayOfByte, i + paramInt1, this.currentBlock, this.currentBlockOffset, j);
      i += j;
      this.currentBlockOffset += j;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\Poly1305.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */