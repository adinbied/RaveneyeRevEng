package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class CFBBlockCipher
  extends StreamBlockCipher
{
  private byte[] IV;
  private int blockSize;
  private int byteCount;
  private byte[] cfbOutV;
  private byte[] cfbV;
  private BlockCipher cipher = null;
  private boolean encrypting;
  private byte[] inBuf;
  
  public CFBBlockCipher(BlockCipher paramBlockCipher, int paramInt)
  {
    super(paramBlockCipher);
    this.cipher = paramBlockCipher;
    this.blockSize = (paramInt / 8);
    this.IV = new byte[paramBlockCipher.getBlockSize()];
    this.cfbV = new byte[paramBlockCipher.getBlockSize()];
    this.cfbOutV = new byte[paramBlockCipher.getBlockSize()];
    this.inBuf = new byte[this.blockSize];
  }
  
  private byte decryptByte(byte paramByte)
  {
    if (this.byteCount == 0) {
      this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
    }
    byte[] arrayOfByte1 = this.inBuf;
    int j = this.byteCount;
    arrayOfByte1[j] = paramByte;
    arrayOfByte1 = this.cfbOutV;
    int i = j + 1;
    this.byteCount = i;
    paramByte = (byte)(paramByte ^ arrayOfByte1[j]);
    j = this.blockSize;
    if (i == j)
    {
      this.byteCount = 0;
      arrayOfByte1 = this.cfbV;
      System.arraycopy(arrayOfByte1, j, arrayOfByte1, 0, arrayOfByte1.length - j);
      arrayOfByte1 = this.inBuf;
      byte[] arrayOfByte2 = this.cfbV;
      i = arrayOfByte2.length;
      j = this.blockSize;
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i - j, j);
    }
    return paramByte;
  }
  
  private byte encryptByte(byte paramByte)
  {
    if (this.byteCount == 0) {
      this.cipher.processBlock(this.cfbV, 0, this.cfbOutV, 0);
    }
    byte[] arrayOfByte1 = this.cfbOutV;
    byte b2 = this.byteCount;
    byte b1 = (byte)(paramByte ^ arrayOfByte1[b2]);
    arrayOfByte1 = this.inBuf;
    paramByte = b2 + 1;
    this.byteCount = paramByte;
    arrayOfByte1[b2] = b1;
    b2 = this.blockSize;
    if (paramByte == b2)
    {
      this.byteCount = 0;
      arrayOfByte1 = this.cfbV;
      System.arraycopy(arrayOfByte1, b2, arrayOfByte1, 0, arrayOfByte1.length - b2);
      arrayOfByte1 = this.inBuf;
      byte[] arrayOfByte2 = this.cfbV;
      paramByte = arrayOfByte2.length;
      b2 = this.blockSize;
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramByte - b2, b2);
    }
    return b1;
  }
  
  protected byte calculateByte(byte paramByte)
    throws DataLengthException, IllegalStateException
  {
    if (this.encrypting) {
      return encryptByte(paramByte);
    }
    return decryptByte(paramByte);
  }
  
  public int decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    processBytes(paramArrayOfByte1, paramInt1, this.blockSize, paramArrayOfByte2, paramInt2);
    return this.blockSize;
  }
  
  public int encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    processBytes(paramArrayOfByte1, paramInt1, this.blockSize, paramArrayOfByte2, paramInt2);
    return this.blockSize;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cipher.getAlgorithmName());
    localStringBuilder.append("/CFB");
    localStringBuilder.append(this.blockSize * 8);
    return localStringBuilder.toString();
  }
  
  public int getBlockSize()
  {
    return this.blockSize;
  }
  
  public byte[] getCurrentIV()
  {
    return Arrays.clone(this.cfbV);
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    this.encrypting = paramBoolean;
    Object localObject1;
    Object localObject2;
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      localObject1 = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject1).getIV();
      int i = paramCipherParameters.length;
      localObject2 = this.IV;
      if (i < localObject2.length)
      {
        System.arraycopy(paramCipherParameters, 0, localObject2, localObject2.length - paramCipherParameters.length, paramCipherParameters.length);
        i = 0;
        for (;;)
        {
          localObject2 = this.IV;
          if (i >= localObject2.length - paramCipherParameters.length) {
            break;
          }
          localObject2[i] = 0;
          i += 1;
        }
      }
      System.arraycopy(paramCipherParameters, 0, localObject2, 0, localObject2.length);
      reset();
      if (((ParametersWithIV)localObject1).getParameters() == null) {
        return;
      }
      paramCipherParameters = this.cipher;
      localObject1 = ((ParametersWithIV)localObject1).getParameters();
    }
    else
    {
      reset();
      if (paramCipherParameters == null) {
        return;
      }
      localObject2 = this.cipher;
      localObject1 = paramCipherParameters;
      paramCipherParameters = (CipherParameters)localObject2;
    }
    paramCipherParameters.init(true, (CipherParameters)localObject1);
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    processBytes(paramArrayOfByte1, paramInt1, this.blockSize, paramArrayOfByte2, paramInt2);
    return this.blockSize;
  }
  
  public void reset()
  {
    byte[] arrayOfByte = this.IV;
    System.arraycopy(arrayOfByte, 0, this.cfbV, 0, arrayOfByte.length);
    Arrays.fill(this.inBuf, (byte)0);
    this.byteCount = 0;
    this.cipher.reset();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\CFBBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */