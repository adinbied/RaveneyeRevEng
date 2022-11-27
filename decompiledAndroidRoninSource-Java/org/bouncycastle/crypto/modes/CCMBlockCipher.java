package org.bouncycastle.crypto.modes;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.macs.CBCBlockCipherMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class CCMBlockCipher
  implements AEADBlockCipher
{
  private ExposedByteArrayOutputStream associatedText = new ExposedByteArrayOutputStream();
  private int blockSize;
  private BlockCipher cipher;
  private ExposedByteArrayOutputStream data = new ExposedByteArrayOutputStream();
  private boolean forEncryption;
  private byte[] initialAssociatedText;
  private CipherParameters keyParam;
  private byte[] macBlock;
  private int macSize;
  private byte[] nonce;
  
  public CCMBlockCipher(BlockCipher paramBlockCipher)
  {
    this.cipher = paramBlockCipher;
    int i = paramBlockCipher.getBlockSize();
    this.blockSize = i;
    this.macBlock = new byte[i];
    if (i == 16) {
      return;
    }
    throw new IllegalArgumentException("cipher required with a block size of 16.");
  }
  
  private int calculateMac(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2)
  {
    CBCBlockCipherMac localCBCBlockCipherMac = new CBCBlockCipherMac(this.cipher, this.macSize * 8);
    localCBCBlockCipherMac.init(this.keyParam);
    byte[] arrayOfByte1 = new byte[16];
    if (hasAssociatedText()) {
      arrayOfByte1[0] = ((byte)(arrayOfByte1[0] | 0x40));
    }
    int i = arrayOfByte1[0];
    int j = localCBCBlockCipherMac.getMacSize();
    int k = 2;
    arrayOfByte1[0] = ((byte)(i | ((j - 2) / 2 & 0x7) << 3));
    i = arrayOfByte1[0];
    byte[] arrayOfByte2 = this.nonce;
    arrayOfByte1[0] = ((byte)(i | 15 - arrayOfByte2.length - 1 & 0x7));
    System.arraycopy(arrayOfByte2, 0, arrayOfByte1, 1, arrayOfByte2.length);
    j = paramInt2;
    i = 1;
    while (j > 0)
    {
      arrayOfByte1[(16 - i)] = ((byte)(j & 0xFF));
      j >>>= 8;
      i += 1;
    }
    localCBCBlockCipherMac.update(arrayOfByte1, 0, 16);
    if (hasAssociatedText())
    {
      j = getAssociatedTextLength();
      if (j < 65280)
      {
        localCBCBlockCipherMac.update((byte)(j >> 8));
        localCBCBlockCipherMac.update((byte)j);
        i = k;
      }
      else
      {
        localCBCBlockCipherMac.update((byte)-1);
        localCBCBlockCipherMac.update((byte)-2);
        localCBCBlockCipherMac.update((byte)(j >> 24));
        localCBCBlockCipherMac.update((byte)(j >> 16));
        localCBCBlockCipherMac.update((byte)(j >> 8));
        localCBCBlockCipherMac.update((byte)j);
        i = 6;
      }
      arrayOfByte1 = this.initialAssociatedText;
      if (arrayOfByte1 != null) {
        localCBCBlockCipherMac.update(arrayOfByte1, 0, arrayOfByte1.length);
      }
      if (this.associatedText.size() > 0) {
        localCBCBlockCipherMac.update(this.associatedText.getBuffer(), 0, this.associatedText.size());
      }
      i = (i + j) % 16;
      if (i != 0) {
        while (i != 16)
        {
          localCBCBlockCipherMac.update((byte)0);
          i += 1;
        }
      }
    }
    localCBCBlockCipherMac.update(paramArrayOfByte1, paramInt1, paramInt2);
    return localCBCBlockCipherMac.doFinal(paramArrayOfByte2, 0);
  }
  
  private int getAssociatedTextLength()
  {
    int j = this.associatedText.size();
    byte[] arrayOfByte = this.initialAssociatedText;
    int i;
    if (arrayOfByte == null) {
      i = 0;
    } else {
      i = arrayOfByte.length;
    }
    return j + i;
  }
  
  private boolean hasAssociatedText()
  {
    return getAssociatedTextLength() > 0;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, InvalidCipherTextException
  {
    paramInt = processPacket(this.data.getBuffer(), 0, this.data.size(), paramArrayOfByte, paramInt);
    reset();
    return paramInt;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cipher.getAlgorithmName());
    localStringBuilder.append("/CCM");
    return localStringBuilder.toString();
  }
  
  public byte[] getMac()
  {
    int i = this.macSize;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.macBlock, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public int getOutputSize(int paramInt)
  {
    paramInt += this.data.size();
    if (this.forEncryption) {
      return paramInt + this.macSize;
    }
    int i = this.macSize;
    if (paramInt < i) {
      return 0;
    }
    return paramInt - i;
  }
  
  public BlockCipher getUnderlyingCipher()
  {
    return this.cipher;
  }
  
  public int getUpdateOutputSize(int paramInt)
  {
    return 0;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    this.forEncryption = paramBoolean;
    if ((paramCipherParameters instanceof AEADParameters))
    {
      paramCipherParameters = (AEADParameters)paramCipherParameters;
      this.nonce = paramCipherParameters.getNonce();
      this.initialAssociatedText = paramCipherParameters.getAssociatedText();
      this.macSize = (paramCipherParameters.getMacSize() / 8);
      paramCipherParameters = paramCipherParameters.getKey();
    }
    else
    {
      if (!(paramCipherParameters instanceof ParametersWithIV)) {
        break label140;
      }
      paramCipherParameters = (ParametersWithIV)paramCipherParameters;
      this.nonce = paramCipherParameters.getIV();
      this.initialAssociatedText = null;
      this.macSize = (this.macBlock.length / 2);
      paramCipherParameters = paramCipherParameters.getParameters();
    }
    if (paramCipherParameters != null) {
      this.keyParam = paramCipherParameters;
    }
    paramCipherParameters = this.nonce;
    if ((paramCipherParameters != null) && (paramCipherParameters.length >= 7) && (paramCipherParameters.length <= 13))
    {
      reset();
      return;
    }
    throw new IllegalArgumentException("nonce must have length from 7 to 13 octets");
    label140:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameters passed to CCM: ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void processAADByte(byte paramByte)
  {
    this.associatedText.write(paramByte);
  }
  
  public void processAADBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.associatedText.write(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException
  {
    this.data.write(paramByte);
    return 0;
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException, IllegalStateException
  {
    if (paramArrayOfByte1.length >= paramInt1 + paramInt2)
    {
      this.data.write(paramArrayOfByte1, paramInt1, paramInt2);
      return 0;
    }
    throw new DataLengthException("Input buffer too short");
  }
  
  public int processPacket(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws IllegalStateException, InvalidCipherTextException, DataLengthException
  {
    if (this.keyParam != null)
    {
      int i = 15 - this.nonce.length;
      if ((i < 4) && (paramInt2 >= 1 << i * 8)) {
        throw new IllegalStateException("CCM packet too large for choice of q.");
      }
      byte[] arrayOfByte1 = new byte[this.blockSize];
      arrayOfByte1[0] = ((byte)(i - 1 & 0x7));
      Object localObject = this.nonce;
      System.arraycopy(localObject, 0, arrayOfByte1, 1, localObject.length);
      localObject = new SICBlockCipher(this.cipher);
      ((BlockCipher)localObject).init(this.forEncryption, new ParametersWithIV(this.keyParam, arrayOfByte1));
      int k;
      int j;
      int m;
      if (this.forEncryption)
      {
        k = this.macSize + paramInt2;
        if (paramArrayOfByte2.length >= k + paramInt3)
        {
          calculateMac(paramArrayOfByte1, paramInt1, paramInt2, this.macBlock);
          arrayOfByte1 = new byte[this.blockSize];
          ((BlockCipher)localObject).processBlock(this.macBlock, 0, arrayOfByte1, 0);
          i = paramInt1;
          j = paramInt3;
          int n;
          for (;;)
          {
            m = paramInt1 + paramInt2;
            n = this.blockSize;
            if (i >= m - n) {
              break;
            }
            ((BlockCipher)localObject).processBlock(paramArrayOfByte1, i, paramArrayOfByte2, j);
            m = this.blockSize;
            j += m;
            i += m;
          }
          byte[] arrayOfByte2 = new byte[n];
          paramInt1 = m - i;
          System.arraycopy(paramArrayOfByte1, i, arrayOfByte2, 0, paramInt1);
          ((BlockCipher)localObject).processBlock(arrayOfByte2, 0, arrayOfByte2, 0);
          System.arraycopy(arrayOfByte2, 0, paramArrayOfByte2, j, paramInt1);
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte2, paramInt3 + paramInt2, this.macSize);
          return k;
        }
        throw new OutputLengthException("Output buffer too short.");
      }
      i = this.macSize;
      if (paramInt2 >= i)
      {
        j = paramInt2 - i;
        if (paramArrayOfByte2.length >= j + paramInt3)
        {
          k = paramInt1 + j;
          System.arraycopy(paramArrayOfByte1, k, this.macBlock, 0, i);
          arrayOfByte1 = this.macBlock;
          ((BlockCipher)localObject).processBlock(arrayOfByte1, 0, arrayOfByte1, 0);
          paramInt2 = this.macSize;
          for (;;)
          {
            arrayOfByte1 = this.macBlock;
            if (paramInt2 == arrayOfByte1.length) {
              break;
            }
            arrayOfByte1[paramInt2] = 0;
            paramInt2 += 1;
          }
          paramInt2 = paramInt1;
          i = paramInt3;
          for (;;)
          {
            m = this.blockSize;
            if (paramInt2 >= k - m) {
              break;
            }
            ((BlockCipher)localObject).processBlock(paramArrayOfByte1, paramInt2, paramArrayOfByte2, i);
            m = this.blockSize;
            i += m;
            paramInt2 += m;
          }
          arrayOfByte1 = new byte[m];
          paramInt1 = j - (paramInt2 - paramInt1);
          System.arraycopy(paramArrayOfByte1, paramInt2, arrayOfByte1, 0, paramInt1);
          ((BlockCipher)localObject).processBlock(arrayOfByte1, 0, arrayOfByte1, 0);
          System.arraycopy(arrayOfByte1, 0, paramArrayOfByte2, i, paramInt1);
          paramArrayOfByte1 = new byte[this.blockSize];
          calculateMac(paramArrayOfByte2, paramInt3, j, paramArrayOfByte1);
          if (Arrays.constantTimeAreEqual(this.macBlock, paramArrayOfByte1)) {
            return j;
          }
          throw new InvalidCipherTextException("mac check in CCM failed");
        }
        throw new OutputLengthException("Output buffer too short.");
      }
      throw new InvalidCipherTextException("data too short");
    }
    throw new IllegalStateException("CCM cipher unitialized.");
  }
  
  public byte[] processPacket(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IllegalStateException, InvalidCipherTextException
  {
    if (this.forEncryption) {}
    byte[] arrayOfByte;
    for (int i = this.macSize + paramInt2;; i = paramInt2 - i)
    {
      arrayOfByte = new byte[i];
      break;
      i = this.macSize;
      if (paramInt2 < i) {
        break label59;
      }
    }
    processPacket(paramArrayOfByte, paramInt1, paramInt2, arrayOfByte, 0);
    return arrayOfByte;
    label59:
    throw new InvalidCipherTextException("data too short");
  }
  
  public void reset()
  {
    this.cipher.reset();
    this.associatedText.reset();
    this.data.reset();
  }
  
  private class ExposedByteArrayOutputStream
    extends ByteArrayOutputStream
  {
    public ExposedByteArrayOutputStream() {}
    
    public byte[] getBuffer()
    {
      return this.buf;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\CCMBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */