package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class CBCBlockCipher
  implements BlockCipher
{
  private byte[] IV;
  private int blockSize;
  private byte[] cbcNextV;
  private byte[] cbcV;
  private BlockCipher cipher = null;
  private boolean encrypting;
  
  public CBCBlockCipher(BlockCipher paramBlockCipher)
  {
    this.cipher = paramBlockCipher;
    int i = paramBlockCipher.getBlockSize();
    this.blockSize = i;
    this.IV = new byte[i];
    this.cbcV = new byte[i];
    this.cbcNextV = new byte[i];
  }
  
  private int decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    int j = this.blockSize;
    if (paramInt1 + j <= paramArrayOfByte1.length)
    {
      byte[] arrayOfByte = this.cbcNextV;
      int i = 0;
      System.arraycopy(paramArrayOfByte1, paramInt1, arrayOfByte, 0, j);
      j = this.cipher.processBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
      paramInt1 = i;
      while (paramInt1 < this.blockSize)
      {
        i = paramInt2 + paramInt1;
        paramArrayOfByte2[i] = ((byte)(paramArrayOfByte2[i] ^ this.cbcV[paramInt1]));
        paramInt1 += 1;
      }
      paramArrayOfByte1 = this.cbcV;
      this.cbcV = this.cbcNextV;
      this.cbcNextV = paramArrayOfByte1;
      return j;
    }
    throw new DataLengthException("input buffer too short");
  }
  
  private int encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    if (this.blockSize + paramInt1 <= paramArrayOfByte1.length)
    {
      int i = 0;
      while (i < this.blockSize)
      {
        byte[] arrayOfByte = this.cbcV;
        arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte1[(paramInt1 + i)]));
        i += 1;
      }
      paramInt1 = this.cipher.processBlock(this.cbcV, 0, paramArrayOfByte2, paramInt2);
      paramArrayOfByte1 = this.cbcV;
      System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, 0, paramArrayOfByte1.length);
      return paramInt1;
    }
    throw new DataLengthException("input buffer too short");
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cipher.getAlgorithmName());
    localStringBuilder.append("/CBC");
    return localStringBuilder.toString();
  }
  
  public int getBlockSize()
  {
    return this.cipher.getBlockSize();
  }
  
  public BlockCipher getUnderlyingCipher()
  {
    return this.cipher;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    boolean bool = this.encrypting;
    this.encrypting = paramBoolean;
    Object localObject;
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      localObject = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject).getIV();
      if (paramCipherParameters.length == this.blockSize)
      {
        System.arraycopy(paramCipherParameters, 0, this.IV, 0, paramCipherParameters.length);
        reset();
        if (((ParametersWithIV)localObject).getParameters() != null)
        {
          paramCipherParameters = this.cipher;
          localObject = ((ParametersWithIV)localObject).getParameters();
        }
        else
        {
          if (bool == paramBoolean) {
            return;
          }
          throw new IllegalArgumentException("cannot change encrypting state without providing key.");
        }
      }
      else
      {
        throw new IllegalArgumentException("initialisation vector must be the same length as block size");
      }
    }
    else
    {
      reset();
      if (paramCipherParameters == null) {
        break label133;
      }
      BlockCipher localBlockCipher = this.cipher;
      localObject = paramCipherParameters;
      paramCipherParameters = localBlockCipher;
    }
    paramCipherParameters.init(paramBoolean, (CipherParameters)localObject);
    return;
    label133:
    if (bool == paramBoolean) {
      return;
    }
    throw new IllegalArgumentException("cannot change encrypting state without providing key.");
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    if (this.encrypting) {
      return encryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
    }
    return decryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
  }
  
  public void reset()
  {
    byte[] arrayOfByte = this.IV;
    System.arraycopy(arrayOfByte, 0, this.cbcV, 0, arrayOfByte.length);
    Arrays.fill(this.cbcNextV, (byte)0);
    this.cipher.reset();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\CBCBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */