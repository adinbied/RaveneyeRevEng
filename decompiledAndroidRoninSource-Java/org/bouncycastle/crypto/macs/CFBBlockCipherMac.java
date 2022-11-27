package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.paddings.BlockCipherPadding;

public class CFBBlockCipherMac
  implements Mac
{
  private byte[] buf;
  private int bufOff;
  private MacCFBBlockCipher cipher;
  private byte[] mac;
  private int macSize;
  private BlockCipherPadding padding = null;
  
  public CFBBlockCipherMac(BlockCipher paramBlockCipher)
  {
    this(paramBlockCipher, 8, paramBlockCipher.getBlockSize() * 8 / 2, null);
  }
  
  public CFBBlockCipherMac(BlockCipher paramBlockCipher, int paramInt1, int paramInt2)
  {
    this(paramBlockCipher, paramInt1, paramInt2, null);
  }
  
  public CFBBlockCipherMac(BlockCipher paramBlockCipher, int paramInt1, int paramInt2, BlockCipherPadding paramBlockCipherPadding)
  {
    if (paramInt2 % 8 == 0)
    {
      this.mac = new byte[paramBlockCipher.getBlockSize()];
      paramBlockCipher = new MacCFBBlockCipher(paramBlockCipher, paramInt1);
      this.cipher = paramBlockCipher;
      this.padding = paramBlockCipherPadding;
      this.macSize = (paramInt2 / 8);
      this.buf = new byte[paramBlockCipher.getBlockSize()];
      this.bufOff = 0;
      return;
    }
    throw new IllegalArgumentException("MAC size must be multiple of 8");
  }
  
  public CFBBlockCipherMac(BlockCipher paramBlockCipher, BlockCipherPadding paramBlockCipherPadding)
  {
    this(paramBlockCipher, 8, paramBlockCipher.getBlockSize() * 8 / 2, paramBlockCipherPadding);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.cipher.getBlockSize();
    BlockCipherPadding localBlockCipherPadding = this.padding;
    if (localBlockCipherPadding == null) {
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
    localBlockCipherPadding.addPadding(this.buf, this.bufOff);
    this.cipher.processBlock(this.buf, 0, this.mac, 0);
    this.cipher.getMacBlock(this.mac);
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
    this.cipher.init(paramCipherParameters);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\CFBBlockCipherMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */