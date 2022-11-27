package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.engines.DESEngine;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class ISO9797Alg3Mac
  implements Mac
{
  private byte[] buf;
  private int bufOff;
  private BlockCipher cipher;
  private KeyParameter lastKey2;
  private KeyParameter lastKey3;
  private byte[] mac;
  private int macSize;
  private BlockCipherPadding padding;
  
  public ISO9797Alg3Mac(BlockCipher paramBlockCipher)
  {
    this(paramBlockCipher, paramBlockCipher.getBlockSize() * 8, null);
  }
  
  public ISO9797Alg3Mac(BlockCipher paramBlockCipher, int paramInt)
  {
    this(paramBlockCipher, paramInt, null);
  }
  
  public ISO9797Alg3Mac(BlockCipher paramBlockCipher, int paramInt, BlockCipherPadding paramBlockCipherPadding)
  {
    if (paramInt % 8 == 0)
    {
      if ((paramBlockCipher instanceof DESEngine))
      {
        this.cipher = new CBCBlockCipher(paramBlockCipher);
        this.padding = paramBlockCipherPadding;
        this.macSize = (paramInt / 8);
        this.mac = new byte[paramBlockCipher.getBlockSize()];
        this.buf = new byte[paramBlockCipher.getBlockSize()];
        this.bufOff = 0;
        return;
      }
      throw new IllegalArgumentException("cipher must be instance of DESEngine");
    }
    throw new IllegalArgumentException("MAC size must be multiple of 8");
  }
  
  public ISO9797Alg3Mac(BlockCipher paramBlockCipher, BlockCipherPadding paramBlockCipherPadding)
  {
    this(paramBlockCipher, paramBlockCipher.getBlockSize() * 8, paramBlockCipherPadding);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.cipher.getBlockSize();
    if (this.padding == null) {
      for (;;)
      {
        int j = this.bufOff;
        if (j >= i) {
          break;
        }
        this.buf[j] = 0;
        this.bufOff = (j + 1);
      }
    }
    if (this.bufOff == i)
    {
      this.cipher.processBlock(this.buf, 0, this.mac, 0);
      this.bufOff = 0;
    }
    this.padding.addPadding(this.buf, this.bufOff);
    this.cipher.processBlock(this.buf, 0, this.mac, 0);
    DESEngine localDESEngine = new DESEngine();
    localDESEngine.init(false, this.lastKey2);
    byte[] arrayOfByte = this.mac;
    localDESEngine.processBlock(arrayOfByte, 0, arrayOfByte, 0);
    localDESEngine.init(true, this.lastKey3);
    arrayOfByte = this.mac;
    localDESEngine.processBlock(arrayOfByte, 0, arrayOfByte, 0);
    System.arraycopy(this.mac, 0, paramArrayOfByte, paramInt, this.macSize);
    reset();
    return this.macSize;
  }
  
  public String getAlgorithmName()
  {
    return "ISO9797Alg3";
  }
  
  public int getMacSize()
  {
    return this.macSize;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    reset();
    boolean bool = paramCipherParameters instanceof KeyParameter;
    if ((!bool) && (!(paramCipherParameters instanceof ParametersWithIV))) {
      throw new IllegalArgumentException("params must be an instance of KeyParameter or ParametersWithIV");
    }
    KeyParameter localKeyParameter;
    if (bool) {
      localKeyParameter = (KeyParameter)paramCipherParameters;
    } else {
      localKeyParameter = (KeyParameter)((ParametersWithIV)paramCipherParameters).getParameters();
    }
    byte[] arrayOfByte = localKeyParameter.getKey();
    if (arrayOfByte.length == 16)
    {
      localKeyParameter = new KeyParameter(arrayOfByte, 0, 8);
      this.lastKey2 = new KeyParameter(arrayOfByte, 8, 8);
      this.lastKey3 = localKeyParameter;
    }
    else
    {
      if (arrayOfByte.length != 24) {
        break label208;
      }
      localKeyParameter = new KeyParameter(arrayOfByte, 0, 8);
      this.lastKey2 = new KeyParameter(arrayOfByte, 8, 8);
      this.lastKey3 = new KeyParameter(arrayOfByte, 16, 8);
    }
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      this.cipher.init(true, new ParametersWithIV(localKeyParameter, ((ParametersWithIV)paramCipherParameters).getIV()));
      return;
    }
    this.cipher.init(true, localKeyParameter);
    return;
    label208:
    throw new IllegalArgumentException("Key must be either 112 or 168 bit long");
  }
  
  public void reset()
  {
    int i = 0;
    for (;;)
    {
      byte[] arrayOfByte = this.buf;
      if (i >= arrayOfByte.length) {
        break;
      }
      arrayOfByte[i] = 0;
      i += 1;
    }
    this.bufOff = 0;
    this.cipher.reset();
  }
  
  public void update(byte paramByte)
  {
    int i = this.bufOff;
    byte[] arrayOfByte = this.buf;
    if (i == arrayOfByte.length)
    {
      this.cipher.processBlock(arrayOfByte, 0, this.mac, 0);
      this.bufOff = 0;
    }
    arrayOfByte = this.buf;
    i = this.bufOff;
    this.bufOff = (i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 >= 0)
    {
      int k = this.cipher.getBlockSize();
      int n = this.bufOff;
      int m = k - n;
      int i = paramInt1;
      int j = paramInt2;
      if (paramInt2 > m)
      {
        System.arraycopy(paramArrayOfByte, paramInt1, this.buf, n, m);
        this.cipher.processBlock(this.buf, 0, this.mac, 0);
        this.bufOff = 0;
        paramInt2 -= m;
        paramInt1 += m;
        for (;;)
        {
          i = paramInt1;
          j = paramInt2;
          if (paramInt2 <= k) {
            break;
          }
          this.cipher.processBlock(paramArrayOfByte, paramInt1, this.mac, 0);
          paramInt2 -= k;
          paramInt1 += k;
        }
      }
      System.arraycopy(paramArrayOfByte, i, this.buf, this.bufOff, j);
      this.bufOff += j;
      return;
    }
    throw new IllegalArgumentException("Can't have a negative input length!");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\ISO9797Alg3Mac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */