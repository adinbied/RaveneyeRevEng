package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public abstract class LongDigest
  implements ExtendedDigest, Memoable, EncodableDigest
{
  private static final int BYTE_LENGTH = 128;
  static final long[] K = { 4794697086780616226L, 8158064640168781261L, -5349999486874862801L, -1606136188198331460L, 4131703408338449720L, 6480981068601479193L, -7908458776815382629L, -6116909921290321640L, -2880145864133508542L, 1334009975649890238L, 2608012711638119052L, 6128411473006802146L, 8268148722764581231L, -9160688886553864527L, -7215885187991268811L, -4495734319001033068L, -1973867731355612462L, -1171420211273849373L, 1135362057144423861L, 2597628984639134821L, 3308224258029322869L, 5365058923640841347L, 6679025012923562964L, 8573033837759648693L, -7476448914759557205L, -6327057829258317296L, -5763719355590565569L, -4658551843659510044L, -4116276920077217854L, -3051310485924567259L, 489312712824947311L, 1452737877330783856L, 2861767655752347644L, 3322285676063803686L, 5560940570517711597L, 5996557281743188959L, 7280758554555802590L, 8532644243296465576L, -9096487096722542874L, -7894198246740708037L, -6719396339535248540L, -6333637450476146687L, -4446306890439682159L, -4076793802049405392L, -3345356375505022440L, -2983346525034927856L, -860691631967231958L, 1182934255886127544L, 1847814050463011016L, 2177327727835720531L, 2830643537854262169L, 3796741975233480872L, 4115178125766777443L, 5681478168544905931L, 6601373596472566643L, 7507060721942968483L, 8399075790359081724L, 8693463985226723168L, -8878714635349349518L, -8302665154208450068L, -8016688836872298968L, -6606660893046293015L, -4685533653050689259L, -4147400797238176981L, -3880063495543823972L, -3348786107499101689L, -1523767162380948706L, -757361751448694408L, 500013540394364858L, 748580250866718886L, 1242879168328830382L, 1977374033974150939L, 2944078676154940804L, 3659926193048069267L, 4368137639120453308L, 4836135668995329356L, 5532061633213252278L, 6448918945643986474L, 6902733635092675308L, 7801388544844847127L };
  protected long H1;
  protected long H2;
  protected long H3;
  protected long H4;
  protected long H5;
  protected long H6;
  protected long H7;
  protected long H8;
  private long[] W = new long[80];
  private long byteCount1;
  private long byteCount2;
  private int wOff;
  private byte[] xBuf = new byte[8];
  private int xBufOff;
  
  protected LongDigest()
  {
    this.xBufOff = 0;
    reset();
  }
  
  protected LongDigest(LongDigest paramLongDigest)
  {
    copyIn(paramLongDigest);
  }
  
  private long Ch(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 ^ paramLong2 & paramLong1;
  }
  
  private long Maj(long paramLong1, long paramLong2, long paramLong3)
  {
    return paramLong1 & paramLong3 ^ paramLong1 & paramLong2 ^ paramLong2 & paramLong3;
  }
  
  private long Sigma0(long paramLong)
  {
    return paramLong >>> 7 ^ (paramLong << 63 | paramLong >>> 1) ^ (paramLong << 56 | paramLong >>> 8);
  }
  
  private long Sigma1(long paramLong)
  {
    return paramLong >>> 6 ^ (paramLong << 45 | paramLong >>> 19) ^ (paramLong << 3 | paramLong >>> 61);
  }
  
  private long Sum0(long paramLong)
  {
    return (paramLong >>> 39 | paramLong << 25) ^ (paramLong << 36 | paramLong >>> 28) ^ (paramLong << 30 | paramLong >>> 34);
  }
  
  private long Sum1(long paramLong)
  {
    return (paramLong >>> 41 | paramLong << 23) ^ (paramLong << 50 | paramLong >>> 14) ^ (paramLong << 46 | paramLong >>> 18);
  }
  
  private void adjustByteCounts()
  {
    long l = this.byteCount1;
    if (l > 2305843009213693951L)
    {
      this.byteCount2 += (l >>> 61);
      this.byteCount1 = (l & 0x1FFFFFFFFFFFFFFF);
    }
  }
  
  protected void copyIn(LongDigest paramLongDigest)
  {
    Object localObject = paramLongDigest.xBuf;
    System.arraycopy(localObject, 0, this.xBuf, 0, localObject.length);
    this.xBufOff = paramLongDigest.xBufOff;
    this.byteCount1 = paramLongDigest.byteCount1;
    this.byteCount2 = paramLongDigest.byteCount2;
    this.H1 = paramLongDigest.H1;
    this.H2 = paramLongDigest.H2;
    this.H3 = paramLongDigest.H3;
    this.H4 = paramLongDigest.H4;
    this.H5 = paramLongDigest.H5;
    this.H6 = paramLongDigest.H6;
    this.H7 = paramLongDigest.H7;
    this.H8 = paramLongDigest.H8;
    localObject = paramLongDigest.W;
    System.arraycopy(localObject, 0, this.W, 0, localObject.length);
    this.wOff = paramLongDigest.wOff;
  }
  
  public void finish()
  {
    adjustByteCounts();
    long l1 = this.byteCount1;
    long l2 = this.byteCount2;
    for (byte b = Byte.MIN_VALUE;; b = 0)
    {
      update(b);
      if (this.xBufOff == 0) {
        break;
      }
    }
    processLength(l1 << 3, l2);
    processBlock();
  }
  
  public int getByteLength()
  {
    return 128;
  }
  
  protected int getEncodedStateSize()
  {
    return this.wOff * 8 + 96;
  }
  
  protected void populateState(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = this.xBuf;
    int j = this.xBufOff;
    int i = 0;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, 0, j);
    Pack.intToBigEndian(this.xBufOff, paramArrayOfByte, 8);
    Pack.longToBigEndian(this.byteCount1, paramArrayOfByte, 12);
    Pack.longToBigEndian(this.byteCount2, paramArrayOfByte, 20);
    Pack.longToBigEndian(this.H1, paramArrayOfByte, 28);
    Pack.longToBigEndian(this.H2, paramArrayOfByte, 36);
    Pack.longToBigEndian(this.H3, paramArrayOfByte, 44);
    Pack.longToBigEndian(this.H4, paramArrayOfByte, 52);
    Pack.longToBigEndian(this.H5, paramArrayOfByte, 60);
    Pack.longToBigEndian(this.H6, paramArrayOfByte, 68);
    Pack.longToBigEndian(this.H7, paramArrayOfByte, 76);
    Pack.longToBigEndian(this.H8, paramArrayOfByte, 84);
    Pack.intToBigEndian(this.wOff, paramArrayOfByte, 92);
    while (i < this.wOff)
    {
      Pack.longToBigEndian(this.W[i], paramArrayOfByte, i * 8 + 96);
      i += 1;
    }
  }
  
  protected void processBlock()
  {
    adjustByteCounts();
    int i = 16;
    long[] arrayOfLong1;
    while (i <= 79)
    {
      arrayOfLong1 = this.W;
      l1 = Sigma1(arrayOfLong1[(i - 2)]);
      long[] arrayOfLong2 = this.W;
      arrayOfLong1[i] = (l1 + arrayOfLong2[(i - 7)] + Sigma0(arrayOfLong2[(i - 15)]) + this.W[(i - 16)]);
      i += 1;
    }
    long l1 = this.H1;
    long l4 = this.H2;
    long l6 = this.H3;
    long l8 = this.H4;
    long l2 = this.H5;
    long l3 = this.H6;
    long l7 = this.H7;
    long l9 = this.H8;
    int j = 0;
    i = 0;
    while (i < 10)
    {
      long l5 = Sum1(l2);
      long l10 = Ch(l2, l3, l7);
      long l11 = K[j];
      arrayOfLong1 = this.W;
      int k = j + 1;
      l5 = l9 + (l5 + l10 + l11 + arrayOfLong1[j]);
      l8 += l5;
      l9 = l5 + (Sum0(l1) + Maj(l1, l4, l6));
      l5 = Sum1(l8);
      l10 = Ch(l8, l2, l3);
      l11 = K[k];
      arrayOfLong1 = this.W;
      j = k + 1;
      l5 = l7 + (l5 + l10 + l11 + arrayOfLong1[k]);
      l6 += l5;
      l10 = l5 + (Sum0(l9) + Maj(l9, l1, l4));
      l5 = Sum1(l6);
      l7 = Ch(l6, l8, l2);
      l11 = K[j];
      arrayOfLong1 = this.W;
      k = j + 1;
      l3 += l5 + l7 + l11 + arrayOfLong1[j];
      l4 += l3;
      l5 = l3 + (Sum0(l10) + Maj(l10, l9, l1));
      l3 = Sum1(l4);
      l7 = Ch(l4, l6, l8);
      l11 = K[k];
      arrayOfLong1 = this.W;
      j = k + 1;
      l2 += l3 + l7 + l11 + arrayOfLong1[k];
      l7 = l1 + l2;
      l2 += Sum0(l5) + Maj(l5, l10, l9);
      l1 = Sum1(l7);
      l3 = Ch(l7, l4, l6);
      l11 = K[j];
      arrayOfLong1 = this.W;
      k = j + 1;
      l1 = l8 + (l1 + l3 + l11 + arrayOfLong1[j]);
      l9 += l1;
      l8 = l1 + (Sum0(l2) + Maj(l2, l5, l10));
      l1 = Sum1(l9);
      l3 = Ch(l9, l7, l4);
      l11 = K[k];
      arrayOfLong1 = this.W;
      j = k + 1;
      l3 = l6 + (l1 + l3 + l11 + arrayOfLong1[k]);
      l1 = l10 + l3;
      l6 = l3 + (Sum0(l8) + Maj(l8, l2, l5));
      l10 = Sum1(l1);
      l3 = l1;
      l1 = Ch(l1, l9, l7);
      l11 = K[j];
      arrayOfLong1 = this.W;
      k = j + 1;
      l4 += l10 + l1 + l11 + arrayOfLong1[j];
      l1 = l5 + l4;
      l11 = Sum0(l6);
      long l12 = Maj(l6, l8, l2);
      l10 = Sum1(l1);
      l5 = l1;
      l4 += l11 + l12;
      l1 = l7 + (l10 + Ch(l1, l3, l9) + K[k] + this.W[k]);
      l7 = Sum0(l4);
      l10 = Maj(l4, l6, l8);
      i += 1;
      l2 += l1;
      j = k + 1;
      l1 += l7 + l10;
      l7 = l3;
      l3 = l5;
    }
    this.H1 += l1;
    this.H2 += l4;
    this.H3 += l6;
    this.H4 += l8;
    this.H5 += l2;
    this.H6 += l3;
    this.H7 += l7;
    this.H8 += l9;
    this.wOff = 0;
    i = 0;
    while (i < 16)
    {
      this.W[i] = 0L;
      i += 1;
    }
  }
  
  protected void processLength(long paramLong1, long paramLong2)
  {
    if (this.wOff > 14) {
      processBlock();
    }
    long[] arrayOfLong = this.W;
    arrayOfLong[14] = paramLong2;
    arrayOfLong[15] = paramLong1;
  }
  
  protected void processWord(byte[] paramArrayOfByte, int paramInt)
  {
    this.W[this.wOff] = Pack.bigEndianToLong(paramArrayOfByte, paramInt);
    paramInt = this.wOff + 1;
    this.wOff = paramInt;
    if (paramInt == 16) {
      processBlock();
    }
  }
  
  public void reset()
  {
    this.byteCount1 = 0L;
    this.byteCount2 = 0L;
    int j = 0;
    this.xBufOff = 0;
    int i = 0;
    Object localObject;
    for (;;)
    {
      localObject = this.xBuf;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0;
      i += 1;
    }
    this.wOff = 0;
    i = j;
    for (;;)
    {
      localObject = this.W;
      if (i == localObject.length) {
        break;
      }
      localObject[i] = 0L;
      i += 1;
    }
  }
  
  protected void restoreState(byte[] paramArrayOfByte)
  {
    int j = Pack.bigEndianToInt(paramArrayOfByte, 8);
    this.xBufOff = j;
    byte[] arrayOfByte = this.xBuf;
    int i = 0;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, j);
    this.byteCount1 = Pack.bigEndianToLong(paramArrayOfByte, 12);
    this.byteCount2 = Pack.bigEndianToLong(paramArrayOfByte, 20);
    this.H1 = Pack.bigEndianToLong(paramArrayOfByte, 28);
    this.H2 = Pack.bigEndianToLong(paramArrayOfByte, 36);
    this.H3 = Pack.bigEndianToLong(paramArrayOfByte, 44);
    this.H4 = Pack.bigEndianToLong(paramArrayOfByte, 52);
    this.H5 = Pack.bigEndianToLong(paramArrayOfByte, 60);
    this.H6 = Pack.bigEndianToLong(paramArrayOfByte, 68);
    this.H7 = Pack.bigEndianToLong(paramArrayOfByte, 76);
    this.H8 = Pack.bigEndianToLong(paramArrayOfByte, 84);
    this.wOff = Pack.bigEndianToInt(paramArrayOfByte, 92);
    while (i < this.wOff)
    {
      this.W[i] = Pack.bigEndianToLong(paramArrayOfByte, i * 8 + 96);
      i += 1;
    }
  }
  
  public void update(byte paramByte)
  {
    byte[] arrayOfByte = this.xBuf;
    int i = this.xBufOff;
    int j = i + 1;
    this.xBufOff = j;
    arrayOfByte[i] = paramByte;
    if (j == arrayOfByte.length)
    {
      processWord(arrayOfByte, 0);
      this.xBufOff = 0;
    }
    this.byteCount1 += 1L;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = paramInt2;
    int j = paramInt1;
    for (;;)
    {
      paramInt1 = j;
      paramInt2 = i;
      if (this.xBufOff == 0) {
        break;
      }
      paramInt1 = j;
      paramInt2 = i;
      if (i <= 0) {
        break;
      }
      update(paramArrayOfByte[j]);
      j += 1;
      i -= 1;
    }
    for (;;)
    {
      i = paramInt1;
      j = paramInt2;
      if (paramInt2 <= this.xBuf.length) {
        break;
      }
      processWord(paramArrayOfByte, paramInt1);
      byte[] arrayOfByte = this.xBuf;
      paramInt1 += arrayOfByte.length;
      paramInt2 -= arrayOfByte.length;
      this.byteCount1 += arrayOfByte.length;
    }
    while (j > 0)
    {
      update(paramArrayOfByte[i]);
      i += 1;
      j -= 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\LongDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */