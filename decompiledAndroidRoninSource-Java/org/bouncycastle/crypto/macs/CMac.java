package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.CBCBlockCipher;
import org.bouncycastle.crypto.paddings.ISO7816d4Padding;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.util.Pack;

public class CMac
  implements Mac
{
  private byte[] Lu;
  private byte[] Lu2;
  private byte[] ZEROES;
  private byte[] buf;
  private int bufOff;
  private BlockCipher cipher;
  private byte[] mac;
  private int macSize;
  private byte[] poly;
  
  public CMac(BlockCipher paramBlockCipher)
  {
    this(paramBlockCipher, paramBlockCipher.getBlockSize() * 8);
  }
  
  public CMac(BlockCipher paramBlockCipher, int paramInt)
  {
    if (paramInt % 8 == 0)
    {
      if (paramInt <= paramBlockCipher.getBlockSize() * 8)
      {
        this.cipher = new CBCBlockCipher(paramBlockCipher);
        this.macSize = (paramInt / 8);
        this.poly = lookupPoly(paramBlockCipher.getBlockSize());
        this.mac = new byte[paramBlockCipher.getBlockSize()];
        this.buf = new byte[paramBlockCipher.getBlockSize()];
        this.ZEROES = new byte[paramBlockCipher.getBlockSize()];
        this.bufOff = 0;
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("MAC size must be less or equal to ");
      localStringBuilder.append(paramBlockCipher.getBlockSize() * 8);
      throw new IllegalArgumentException(localStringBuilder.toString());
    }
    throw new IllegalArgumentException("MAC size must be multiple of 8");
  }
  
  private byte[] doubleLu(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte1 = new byte[paramArrayOfByte.length];
    int i = -shiftLeft(paramArrayOfByte, arrayOfByte1) & 0xFF;
    int j = paramArrayOfByte.length - 3;
    int k = arrayOfByte1[j];
    byte[] arrayOfByte2 = this.poly;
    arrayOfByte1[j] = ((byte)(k ^ arrayOfByte2[1] & i));
    j = paramArrayOfByte.length - 2;
    k = arrayOfByte1[j];
    arrayOfByte1[j] = ((byte)(arrayOfByte2[2] & i ^ k));
    j = paramArrayOfByte.length - 1;
    k = arrayOfByte1[j];
    arrayOfByte1[j] = ((byte)(i & arrayOfByte2[3] ^ k));
    return arrayOfByte1;
  }
  
  private static byte[] lookupPoly(int paramInt)
  {
    int i = paramInt * 8;
    paramInt = 135;
    switch (i)
    {
    default: 
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unknown block size for CMAC: ");
      localStringBuilder.append(i);
      throw new IllegalArgumentException(localStringBuilder.toString());
    case 2048: 
      paramInt = 548865;
      break;
    case 1024: 
      paramInt = 524355;
      break;
    case 768: 
      paramInt = 655377;
      break;
    case 512: 
      paramInt = 293;
      break;
    case 448: 
      paramInt = 2129;
      break;
    case 384: 
      paramInt = 4109;
      break;
    case 256: 
      paramInt = 1061;
      break;
    case 224: 
      paramInt = 777;
      break;
    case 160: 
      paramInt = 45;
      break;
    case 64: 
    case 320: 
      paramInt = 27;
    }
    return Pack.intToBigEndian(paramInt);
  }
  
  private static int shiftLeft(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = paramArrayOfByte1.length;
    int k;
    for (int i = 0;; i = k >>> 7 & 0x1)
    {
      j -= 1;
      if (j < 0) {
        break;
      }
      k = paramArrayOfByte1[j] & 0xFF;
      paramArrayOfByte2[j] = ((byte)(i | k << 1));
    }
    return i;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    int i = this.cipher.getBlockSize();
    byte[] arrayOfByte1;
    if (this.bufOff == i)
    {
      arrayOfByte1 = this.Lu;
    }
    else
    {
      new ISO7816d4Padding().addPadding(this.buf, this.bufOff);
      arrayOfByte1 = this.Lu2;
    }
    i = 0;
    byte[] arrayOfByte2;
    for (;;)
    {
      arrayOfByte2 = this.mac;
      if (i >= arrayOfByte2.length) {
        break;
      }
      arrayOfByte2 = this.buf;
      arrayOfByte2[i] = ((byte)(arrayOfByte2[i] ^ arrayOfByte1[i]));
      i += 1;
    }
    this.cipher.processBlock(this.buf, 0, arrayOfByte2, 0);
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
    validate(paramCipherParameters);
    this.cipher.init(true, paramCipherParameters);
    paramCipherParameters = this.ZEROES;
    byte[] arrayOfByte = new byte[paramCipherParameters.length];
    this.cipher.processBlock(paramCipherParameters, 0, arrayOfByte, 0);
    paramCipherParameters = doubleLu(arrayOfByte);
    this.Lu = paramCipherParameters;
    this.Lu2 = doubleLu(paramCipherParameters);
    reset();
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
  
  void validate(CipherParameters paramCipherParameters)
  {
    if (paramCipherParameters != null)
    {
      if ((paramCipherParameters instanceof KeyParameter)) {
        return;
      }
      throw new IllegalArgumentException("CMac mode only permits key to be set.");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\CMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */