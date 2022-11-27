package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class OFBBlockCipher
  extends StreamBlockCipher
{
  private byte[] IV;
  private final int blockSize;
  private int byteCount;
  private final BlockCipher cipher;
  private byte[] ofbOutV;
  private byte[] ofbV;
  
  public OFBBlockCipher(BlockCipher paramBlockCipher, int paramInt)
  {
    super(paramBlockCipher);
    this.cipher = paramBlockCipher;
    this.blockSize = (paramInt / 8);
    this.IV = new byte[paramBlockCipher.getBlockSize()];
    this.ofbV = new byte[paramBlockCipher.getBlockSize()];
    this.ofbOutV = new byte[paramBlockCipher.getBlockSize()];
  }
  
  protected byte calculateByte(byte paramByte)
    throws DataLengthException, IllegalStateException
  {
    if (this.byteCount == 0) {
      this.cipher.processBlock(this.ofbV, 0, this.ofbOutV, 0);
    }
    byte[] arrayOfByte1 = this.ofbOutV;
    int i = this.byteCount;
    byte b2 = i + 1;
    this.byteCount = b2;
    byte b1 = (byte)(paramByte ^ arrayOfByte1[i]);
    paramByte = this.blockSize;
    if (b2 == paramByte)
    {
      this.byteCount = 0;
      arrayOfByte1 = this.ofbV;
      System.arraycopy(arrayOfByte1, paramByte, arrayOfByte1, 0, arrayOfByte1.length - paramByte);
      arrayOfByte1 = this.ofbOutV;
      byte[] arrayOfByte2 = this.ofbV;
      paramByte = arrayOfByte2.length;
      b2 = this.blockSize;
      System.arraycopy(arrayOfByte1, 0, arrayOfByte2, paramByte - b2, b2);
    }
    return b1;
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cipher.getAlgorithmName());
    localStringBuilder.append("/OFB");
    localStringBuilder.append(this.blockSize * 8);
    return localStringBuilder.toString();
  }
  
  public int getBlockSize()
  {
    return this.blockSize;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
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
    System.arraycopy(arrayOfByte, 0, this.ofbV, 0, arrayOfByte.length);
    this.byteCount = 0;
    this.cipher.reset();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\OFBBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */