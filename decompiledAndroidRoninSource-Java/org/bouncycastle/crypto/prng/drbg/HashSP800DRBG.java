package org.bouncycastle.crypto.prng.drbg;

import java.util.Hashtable;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;

public class HashSP800DRBG
  implements SP80090DRBG
{
  private static final int MAX_BITS_REQUEST = 262144;
  private static final byte[] ONE = { 1 };
  private static final long RESEED_MAX = 140737488355328L;
  private static final Hashtable seedlens;
  private byte[] _C;
  private byte[] _V;
  private Digest _digest;
  private EntropySource _entropySource;
  private long _reseedCounter;
  private int _securityStrength;
  private int _seedLength;
  
  static
  {
    Hashtable localHashtable = new Hashtable();
    seedlens = localHashtable;
    localHashtable.put("SHA-1", Integers.valueOf(440));
    seedlens.put("SHA-224", Integers.valueOf(440));
    seedlens.put("SHA-256", Integers.valueOf(440));
    seedlens.put("SHA-512/256", Integers.valueOf(440));
    seedlens.put("SHA-512/224", Integers.valueOf(440));
    seedlens.put("SHA-384", Integers.valueOf(888));
    seedlens.put("SHA-512", Integers.valueOf(888));
  }
  
  public HashSP800DRBG(Digest paramDigest, int paramInt, EntropySource paramEntropySource, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramInt <= Utils.getMaxSecurityStrength(paramDigest))
    {
      if (paramEntropySource.entropySize() >= paramInt)
      {
        this._digest = paramDigest;
        this._entropySource = paramEntropySource;
        this._securityStrength = paramInt;
        this._seedLength = ((Integer)seedlens.get(paramDigest.getAlgorithmName())).intValue();
        paramDigest = Arrays.concatenate(getEntropy(), paramArrayOfByte2, paramArrayOfByte1);
        paramDigest = Utils.hash_df(this._digest, paramDigest, this._seedLength);
        this._V = paramDigest;
        paramEntropySource = new byte[paramDigest.length + 1];
        System.arraycopy(paramDigest, 0, paramEntropySource, 1, paramDigest.length);
        this._C = Utils.hash_df(this._digest, paramEntropySource, this._seedLength);
        this._reseedCounter = 1L;
        return;
      }
      throw new IllegalArgumentException("Not enough entropy for security strength required");
    }
    throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
  }
  
  private void addTo(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = 1;
    int i = 0;
    int k;
    while (j <= paramArrayOfByte2.length)
    {
      k = (paramArrayOfByte1[(paramArrayOfByte1.length - j)] & 0xFF) + (paramArrayOfByte2[(paramArrayOfByte2.length - j)] & 0xFF) + i;
      if (k > 255) {
        i = 1;
      } else {
        i = 0;
      }
      paramArrayOfByte1[(paramArrayOfByte1.length - j)] = ((byte)k);
      j += 1;
    }
    j = paramArrayOfByte2.length + 1;
    while (j <= paramArrayOfByte1.length)
    {
      k = (paramArrayOfByte1[(paramArrayOfByte1.length - j)] & 0xFF) + i;
      if (k > 255) {
        i = 1;
      } else {
        i = 0;
      }
      paramArrayOfByte1[(paramArrayOfByte1.length - j)] = ((byte)k);
      j += 1;
    }
  }
  
  private void doHash(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this._digest.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    this._digest.doFinal(paramArrayOfByte2, 0);
  }
  
  private byte[] getEntropy()
  {
    byte[] arrayOfByte = this._entropySource.getEntropy();
    if (arrayOfByte.length >= (this._securityStrength + 7) / 8) {
      return arrayOfByte;
    }
    throw new IllegalStateException("Insufficient entropy provided by entropy source");
  }
  
  private byte[] hash(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[this._digest.getDigestSize()];
    doHash(paramArrayOfByte, arrayOfByte);
    return arrayOfByte;
  }
  
  private byte[] hashgen(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this._digest.getDigestSize();
    int m = paramInt / 8;
    int n = m / i;
    byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte1, 0, paramArrayOfByte.length);
    paramArrayOfByte = new byte[m];
    int j = this._digest.getDigestSize();
    byte[] arrayOfByte2 = new byte[j];
    paramInt = 0;
    while (paramInt <= n)
    {
      doHash(arrayOfByte1, arrayOfByte2);
      int i1 = paramInt * j;
      int k = m - i1;
      i = k;
      if (k > j) {
        i = j;
      }
      System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, i1, i);
      addTo(arrayOfByte1, ONE);
      paramInt += 1;
    }
    return paramArrayOfByte;
  }
  
  public int generate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    int n = paramArrayOfByte1.length * 8;
    if (n <= 262144)
    {
      if (this._reseedCounter > 140737488355328L) {
        return -1;
      }
      byte[] arrayOfByte1 = paramArrayOfByte2;
      if (paramBoolean)
      {
        reseed(paramArrayOfByte2);
        arrayOfByte1 = null;
      }
      if (arrayOfByte1 != null)
      {
        paramArrayOfByte2 = this._V;
        arrayOfByte2 = new byte[paramArrayOfByte2.length + 1 + arrayOfByte1.length];
        arrayOfByte2[0] = 2;
        System.arraycopy(paramArrayOfByte2, 0, arrayOfByte2, 1, paramArrayOfByte2.length);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, this._V.length + 1, arrayOfByte1.length);
        paramArrayOfByte2 = hash(arrayOfByte2);
        addTo(this._V, paramArrayOfByte2);
      }
      paramArrayOfByte2 = hashgen(this._V, n);
      arrayOfByte1 = this._V;
      byte[] arrayOfByte2 = new byte[arrayOfByte1.length + 1];
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, 1, arrayOfByte1.length);
      arrayOfByte2[0] = 3;
      arrayOfByte1 = hash(arrayOfByte2);
      addTo(this._V, arrayOfByte1);
      addTo(this._V, this._C);
      long l = this._reseedCounter;
      int i = (byte)(int)(l >> 24);
      int j = (byte)(int)(l >> 16);
      int k = (byte)(int)(l >> 8);
      int m = (byte)(int)l;
      addTo(this._V, new byte[] { i, j, k, m });
      this._reseedCounter += 1L;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte1.length);
      return n;
    }
    throw new IllegalArgumentException("Number of bits per request limited to 262144");
  }
  
  public int getBlockSize()
  {
    return this._digest.getDigestSize() * 8;
  }
  
  public void reseed(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = getEntropy();
    paramArrayOfByte = Arrays.concatenate(ONE, this._V, arrayOfByte, paramArrayOfByte);
    paramArrayOfByte = Utils.hash_df(this._digest, paramArrayOfByte, this._seedLength);
    this._V = paramArrayOfByte;
    arrayOfByte = new byte[paramArrayOfByte.length + 1];
    arrayOfByte[0] = 0;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 1, paramArrayOfByte.length);
    this._C = Utils.hash_df(this._digest, arrayOfByte, this._seedLength);
    this._reseedCounter = 1L;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\drbg\HashSP800DRBG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */