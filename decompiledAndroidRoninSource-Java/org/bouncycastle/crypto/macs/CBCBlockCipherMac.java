package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;

public class CBCBlockCipherMac
  implements Mac
{
  private byte[] buf;
  private int bufOff;
  private BlockCipher cipher;
  private byte[] mac;
  private int macSize;
  private BlockCipherPadding padding;
  
  public CBCBlockCipherMac(BlockCipher paramBlockCipher)
  {
    this(paramBlockCipher, paramBlockCipher.getBlockSize() * 8 / 2, null);
  }
  
  public CBCBlockCipherMac(BlockCipher paramBlockCipher, int paramInt)
  {
    this(paramBlockCipher, paramInt, null);
  }
  
  public CBCBlockCipherMac(BlockCipher paramBlockCipher, int paramInt, BlockCipherPadding paramBlockCipherPadding)
  {
    if (paramInt % 8 == 0)
    {
      this.cipher = new CBCBlockCipher(paramBlockCipher);
      this.padding = paramBlockCipherPadding;
      this.macSize = (paramInt / 8);
      this.mac = new byte[paramBlockCipher.getBlockSize()];
      this.buf = new byte[paramBlockCipher.getBlockSize()];
      this.bufOff = 0;
      return;
    }
    throw new IllegalArgumentException("MAC size must be multiple of 8");
  }
  
  public CBCBlockCipherMac(BlockCipher paramBlockCipher, BlockCipherPadding paramBlockCipherPadding)
  {
    this(paramBlockCipher, paramBlockCipher.getBlockSize() * 8 / 2, paramBlockCipherPadding);
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
    System.arraycopy(this.mac, 0, paramArrayOfByte, paramInt, this.macSize);
    reset();
    return this.macSize;
  }
  
  public String getAlgorithmName()
  {
    return this.cipher.getAlgorithmName();
  }
  
  public int getMacSize()
  {
    return this.macSize;
  }
  
  public void init(CipherParameters paramCipherParameters)
  {
    reset();
    this.cipher.init(true, paramCipherParameters);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\CBCBlockCipherMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */