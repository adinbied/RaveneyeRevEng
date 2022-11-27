package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public class DESedeEngine
  extends DESEngine
{
  protected static final int BLOCK_SIZE = 8;
  private boolean forEncryption;
  private int[] workingKey1 = null;
  private int[] workingKey2 = null;
  private int[] workingKey3 = null;
  
  public String getAlgorithmName()
  {
    return "DESede";
  }
  
  public int getBlockSize()
  {
    return 8;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      paramCipherParameters = ((KeyParameter)paramCipherParameters).getKey();
      if ((paramCipherParameters.length != 24) && (paramCipherParameters.length != 16)) {
        throw new IllegalArgumentException("key size must be 16 or 24 bytes.");
      }
      this.forEncryption = paramBoolean;
      localObject = new byte[8];
      System.arraycopy(paramCipherParameters, 0, localObject, 0, 8);
      this.workingKey1 = generateWorkingKey(paramBoolean, (byte[])localObject);
      localObject = new byte[8];
      System.arraycopy(paramCipherParameters, 8, localObject, 0, 8);
      this.workingKey2 = generateWorkingKey(paramBoolean ^ true, (byte[])localObject);
      if (paramCipherParameters.length == 24)
      {
        localObject = new byte[8];
        System.arraycopy(paramCipherParameters, 16, localObject, 0, 8);
        this.workingKey3 = generateWorkingKey(paramBoolean, (byte[])localObject);
        return;
      }
      this.workingKey3 = this.workingKey1;
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("invalid parameter passed to DESede init - ");
    ((StringBuilder)localObject).append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    int[] arrayOfInt = this.workingKey1;
    if (arrayOfInt != null)
    {
      if (paramInt1 + 8 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 8 <= paramArrayOfByte2.length)
        {
          byte[] arrayOfByte = new byte[8];
          if (this.forEncryption)
          {
            desFunc(arrayOfInt, paramArrayOfByte1, paramInt1, arrayOfByte, 0);
            desFunc(this.workingKey2, arrayOfByte, 0, arrayOfByte, 0);
            desFunc(this.workingKey3, arrayOfByte, 0, paramArrayOfByte2, paramInt2);
            return 8;
          }
          desFunc(this.workingKey3, paramArrayOfByte1, paramInt1, arrayOfByte, 0);
          desFunc(this.workingKey2, arrayOfByte, 0, arrayOfByte, 0);
          desFunc(this.workingKey1, arrayOfByte, 0, paramArrayOfByte2, paramInt2);
          return 8;
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    throw new IllegalStateException("DESede engine not initialised");
  }
  
  public void reset() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\DESedeEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */