package org.bouncycastle.crypto.digests;

import java.lang.reflect.Array;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.engines.GOST28147Engine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithSBox;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Memoable;
import org.bouncycastle.util.Pack;

public class GOST3411Digest
  implements ExtendedDigest, Memoable
{
  private static final byte[] C2 = { 0, -1, 0, -1, 0, -1, 0, -1, -1, 0, -1, 0, -1, 0, -1, 0, 0, -1, -1, 0, -1, 0, 0, -1, -1, 0, 0, 0, -1, -1, 0, -1 };
  private static final int DIGEST_LENGTH = 32;
  private byte[][] C = (byte[][])Array.newInstance(Byte.TYPE, new int[] { 4, 32 });
  private byte[] H = new byte[32];
  private byte[] K = new byte[32];
  private byte[] L = new byte[32];
  private byte[] M = new byte[32];
  byte[] S = new byte[32];
  private byte[] Sum = new byte[32];
  byte[] U = new byte[32];
  byte[] V = new byte[32];
  byte[] W = new byte[32];
  byte[] a = new byte[8];
  private long byteCount;
  private BlockCipher cipher = new GOST28147Engine();
  private byte[] sBox;
  short[] wS = new short[16];
  short[] w_S = new short[16];
  private byte[] xBuf = new byte[32];
  private int xBufOff;
  
  public GOST3411Digest()
  {
    byte[] arrayOfByte = GOST28147Engine.getSBox("D-A");
    this.sBox = arrayOfByte;
    this.cipher.init(true, new ParametersWithSBox(null, arrayOfByte));
    reset();
  }
  
  public GOST3411Digest(GOST3411Digest paramGOST3411Digest)
  {
    reset(paramGOST3411Digest);
  }
  
  public GOST3411Digest(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = Arrays.clone(paramArrayOfByte);
    this.sBox = paramArrayOfByte;
    this.cipher.init(true, new ParametersWithSBox(null, paramArrayOfByte));
    reset();
  }
  
  private byte[] A(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < 8)
    {
      this.a[i] = ((byte)(paramArrayOfByte[i] ^ paramArrayOfByte[(i + 8)]));
      i += 1;
    }
    System.arraycopy(paramArrayOfByte, 8, paramArrayOfByte, 0, 24);
    System.arraycopy(this.a, 0, paramArrayOfByte, 24, 8);
    return paramArrayOfByte;
  }
  
  private void E(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, byte[] paramArrayOfByte3, int paramInt2)
  {
    this.cipher.init(true, new KeyParameter(paramArrayOfByte1));
    this.cipher.processBlock(paramArrayOfByte3, paramInt2, paramArrayOfByte2, paramInt1);
  }
  
  private byte[] P(byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < 8)
    {
      byte[] arrayOfByte = this.K;
      int j = i * 4;
      arrayOfByte[j] = paramArrayOfByte[i];
      arrayOfByte[(j + 1)] = paramArrayOfByte[(i + 8)];
      arrayOfByte[(j + 2)] = paramArrayOfByte[(i + 16)];
      arrayOfByte[(j + 3)] = paramArrayOfByte[(i + 24)];
      i += 1;
    }
    return this.K;
  }
  
  private void cpyBytesToShort(byte[] paramArrayOfByte, short[] paramArrayOfShort)
  {
    int i = 0;
    while (i < paramArrayOfByte.length / 2)
    {
      int j = i * 2;
      int k = paramArrayOfByte[(j + 1)];
      paramArrayOfShort[i] = ((short)(paramArrayOfByte[j] & 0xFF | k << 8 & 0xFF00));
      i += 1;
    }
  }
  
  private void cpyShortToBytes(short[] paramArrayOfShort, byte[] paramArrayOfByte)
  {
    int i = 0;
    while (i < paramArrayOfByte.length / 2)
    {
      int j = i * 2;
      paramArrayOfByte[(j + 1)] = ((byte)(paramArrayOfShort[i] >> 8));
      paramArrayOfByte[j] = ((byte)paramArrayOfShort[i]);
      i += 1;
    }
  }
  
  private void finish()
  {
    Pack.longToLittleEndian(this.byteCount * 8L, this.L, 0);
    while (this.xBufOff != 0) {
      update((byte)0);
    }
    processBlock(this.L, 0);
    processBlock(this.Sum, 0);
  }
  
  private void fw(byte[] paramArrayOfByte)
  {
    cpyBytesToShort(paramArrayOfByte, this.wS);
    short[] arrayOfShort1 = this.w_S;
    short[] arrayOfShort2 = this.wS;
    arrayOfShort1[15] = ((short)(arrayOfShort2[0] ^ arrayOfShort2[1] ^ arrayOfShort2[2] ^ arrayOfShort2[3] ^ arrayOfShort2[12] ^ arrayOfShort2[15]));
    System.arraycopy(arrayOfShort2, 1, arrayOfShort1, 0, 15);
    cpyShortToBytes(this.w_S, paramArrayOfByte);
  }
  
  private void sumByteArray(byte[] paramArrayOfByte)
  {
    int i = 0;
    int j = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.Sum;
      if (i == arrayOfByte.length) {
        break;
      }
      j = (arrayOfByte[i] & 0xFF) + (paramArrayOfByte[i] & 0xFF) + j;
      arrayOfByte[i] = ((byte)j);
      j >>>= 8;
      i += 1;
    }
  }
  
  public Memoable copy()
  {
    return new GOST3411Digest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    finish();
    byte[] arrayOfByte = this.H;
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte, paramInt, arrayOfByte.length);
    reset();
    return 32;
  }
  
  public String getAlgorithmName()
  {
    return "GOST3411";
  }
  
  public int getByteLength()
  {
    return 32;
  }
  
  public int getDigestSize()
  {
    return 32;
  }
  
  protected void processBlock(byte[] paramArrayOfByte, int paramInt)
  {
    System.arraycopy(paramArrayOfByte, paramInt, this.M, 0, 32);
    System.arraycopy(this.H, 0, this.U, 0, 32);
    System.arraycopy(this.M, 0, this.V, 0, 32);
    paramInt = 0;
    while (paramInt < 32)
    {
      this.W[paramInt] = ((byte)(this.U[paramInt] ^ this.V[paramInt]));
      paramInt += 1;
    }
    E(P(this.W), this.S, 0, this.H, 0);
    paramInt = 1;
    while (paramInt < 4)
    {
      paramArrayOfByte = A(this.U);
      int i = 0;
      while (i < 32)
      {
        this.U[i] = ((byte)(paramArrayOfByte[i] ^ this.C[paramInt][i]));
        i += 1;
      }
      this.V = A(A(this.V));
      i = 0;
      while (i < 32)
      {
        this.W[i] = ((byte)(this.U[i] ^ this.V[i]));
        i += 1;
      }
      paramArrayOfByte = P(this.W);
      arrayOfByte = this.S;
      i = paramInt * 8;
      E(paramArrayOfByte, arrayOfByte, i, this.H, i);
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 12)
    {
      fw(this.S);
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 32)
    {
      paramArrayOfByte = this.S;
      paramArrayOfByte[paramInt] = ((byte)(paramArrayOfByte[paramInt] ^ this.M[paramInt]));
      paramInt += 1;
    }
    fw(this.S);
    paramInt = 0;
    while (paramInt < 32)
    {
      paramArrayOfByte = this.S;
      paramArrayOfByte[paramInt] = ((byte)(this.H[paramInt] ^ paramArrayOfByte[paramInt]));
      paramInt += 1;
    }
    paramInt = 0;
    while (paramInt < 61)
    {
      fw(this.S);
      paramInt += 1;
    }
    paramArrayOfByte = this.S;
    byte[] arrayOfByte = this.H;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 0, arrayOfByte.length);
  }
  
  public void reset()
  {
    this.byteCount = 0L;
    this.xBufOff = 0;
    int i = 0;
    for (;;)
    {
      localObject = this.H;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0;
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.L;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0;
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.M;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0;
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.C;
      if (i >= localObject[1].length) {
        break;
      }
      localObject[1][i] = 0;
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.C;
      if (i >= localObject[3].length) {
        break;
      }
      localObject[3][i] = 0;
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.Sum;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0;
      i += 1;
    }
    i = 0;
    for (;;)
    {
      localObject = this.xBuf;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = 0;
      i += 1;
    }
    Object localObject = C2;
    System.arraycopy(localObject, 0, this.C[2], 0, localObject.length);
  }
  
  public void reset(Memoable paramMemoable)
  {
    paramMemoable = (GOST3411Digest)paramMemoable;
    Object localObject = paramMemoable.sBox;
    this.sBox = ((byte[])localObject);
    this.cipher.init(true, new ParametersWithSBox(null, (byte[])localObject));
    reset();
    localObject = paramMemoable.H;
    System.arraycopy(localObject, 0, this.H, 0, localObject.length);
    localObject = paramMemoable.L;
    System.arraycopy(localObject, 0, this.L, 0, localObject.length);
    localObject = paramMemoable.M;
    System.arraycopy(localObject, 0, this.M, 0, localObject.length);
    localObject = paramMemoable.Sum;
    System.arraycopy(localObject, 0, this.Sum, 0, localObject.length);
    localObject = paramMemoable.C;
    System.arraycopy(localObject[1], 0, this.C[1], 0, localObject[1].length);
    localObject = paramMemoable.C;
    System.arraycopy(localObject[2], 0, this.C[2], 0, localObject[2].length);
    localObject = paramMemoable.C;
    System.arraycopy(localObject[3], 0, this.C[3], 0, localObject[3].length);
    localObject = paramMemoable.xBuf;
    System.arraycopy(localObject, 0, this.xBuf, 0, localObject.length);
    this.xBufOff = paramMemoable.xBufOff;
    this.byteCount = paramMemoable.byteCount;
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
      sumByteArray(arrayOfByte);
      processBlock(this.xBuf, 0);
      this.xBufOff = 0;
    }
    this.byteCount += 1L;
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
      byte[] arrayOfByte = this.xBuf;
      i = paramInt1;
      j = paramInt2;
      if (paramInt2 <= arrayOfByte.length) {
        break;
      }
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, arrayOfByte.length);
      sumByteArray(this.xBuf);
      processBlock(this.xBuf, 0);
      arrayOfByte = this.xBuf;
      paramInt1 += arrayOfByte.length;
      paramInt2 -= arrayOfByte.length;
      this.byteCount += arrayOfByte.length;
    }
    while (j > 0)
    {
      update(paramArrayOfByte[i]);
      i += 1;
      j -= 1;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\GOST3411Digest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */