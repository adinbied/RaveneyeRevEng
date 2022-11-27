package org.bouncycastle.crypto.prng.drbg;

import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.util.Arrays;

public class HMacSP800DRBG
  implements SP80090DRBG
{
  private static final int MAX_BITS_REQUEST = 262144;
  private static final long RESEED_MAX = 140737488355328L;
  private byte[] _K;
  private byte[] _V;
  private EntropySource _entropySource;
  private Mac _hMac;
  private long _reseedCounter;
  private int _securityStrength;
  
  public HMacSP800DRBG(Mac paramMac, int paramInt, EntropySource paramEntropySource, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramInt <= Utils.getMaxSecurityStrength(paramMac))
    {
      if (paramEntropySource.entropySize() >= paramInt)
      {
        this._securityStrength = paramInt;
        this._entropySource = paramEntropySource;
        this._hMac = paramMac;
        paramEntropySource = Arrays.concatenate(getEntropy(), paramArrayOfByte2, paramArrayOfByte1);
        paramMac = new byte[paramMac.getMacSize()];
        this._K = paramMac;
        paramMac = new byte[paramMac.length];
        this._V = paramMac;
        Arrays.fill(paramMac, (byte)1);
        hmac_DRBG_Update(paramEntropySource);
        this._reseedCounter = 1L;
        return;
      }
      throw new IllegalArgumentException("Not enough entropy for security strength required");
    }
    throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
  }
  
  private byte[] getEntropy()
  {
    byte[] arrayOfByte = this._entropySource.getEntropy();
    if (arrayOfByte.length >= (this._securityStrength + 7) / 8) {
      return arrayOfByte;
    }
    throw new IllegalStateException("Insufficient entropy provided by entropy source");
  }
  
  private void hmac_DRBG_Update(byte[] paramArrayOfByte)
  {
    hmac_DRBG_Update_Func(paramArrayOfByte, (byte)0);
    if (paramArrayOfByte != null) {
      hmac_DRBG_Update_Func(paramArrayOfByte, (byte)1);
    }
  }
  
  private void hmac_DRBG_Update_Func(byte[] paramArrayOfByte, byte paramByte)
  {
    this._hMac.init(new KeyParameter(this._K));
    Object localObject = this._hMac;
    byte[] arrayOfByte = this._V;
    ((Mac)localObject).update(arrayOfByte, 0, arrayOfByte.length);
    this._hMac.update(paramByte);
    if (paramArrayOfByte != null) {
      this._hMac.update(paramArrayOfByte, 0, paramArrayOfByte.length);
    }
    this._hMac.doFinal(this._K, 0);
    this._hMac.init(new KeyParameter(this._K));
    paramArrayOfByte = this._hMac;
    localObject = this._V;
    paramArrayOfByte.update((byte[])localObject, 0, localObject.length);
    this._hMac.doFinal(this._V, 0);
  }
  
  public int generate(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, boolean paramBoolean)
  {
    int j = paramArrayOfByte1.length * 8;
    if (j <= 262144)
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
      if (arrayOfByte1 != null) {
        hmac_DRBG_Update(arrayOfByte1);
      }
      int k = paramArrayOfByte1.length;
      paramArrayOfByte2 = new byte[k];
      int m = paramArrayOfByte1.length / this._V.length;
      this._hMac.init(new KeyParameter(this._K));
      int i = 0;
      while (i < m)
      {
        localObject = this._hMac;
        byte[] arrayOfByte2 = this._V;
        ((Mac)localObject).update(arrayOfByte2, 0, arrayOfByte2.length);
        this._hMac.doFinal(this._V, 0);
        localObject = this._V;
        System.arraycopy(localObject, 0, paramArrayOfByte2, localObject.length * i, localObject.length);
        i += 1;
      }
      Object localObject = this._V;
      if (localObject.length * m < k)
      {
        this._hMac.update((byte[])localObject, 0, localObject.length);
        this._hMac.doFinal(this._V, 0);
        localObject = this._V;
        System.arraycopy(localObject, 0, paramArrayOfByte2, localObject.length * m, k - m * localObject.length);
      }
      hmac_DRBG_Update(arrayOfByte1);
      this._reseedCounter += 1L;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte1.length);
      return j;
    }
    throw new IllegalArgumentException("Number of bits per request limited to 262144");
  }
  
  public int getBlockSize()
  {
    return this._V.length * 8;
  }
  
  public void reseed(byte[] paramArrayOfByte)
  {
    hmac_DRBG_Update(Arrays.concatenate(getEntropy(), paramArrayOfByte));
    this._reseedCounter = 1L;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\drbg\HMacSP800DRBG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */