package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;

public class RC4Engine
  implements StreamCipher
{
  private static final int STATE_LENGTH = 256;
  private byte[] engineState = null;
  private byte[] workingKey = null;
  private int x = 0;
  private int y = 0;
  
  private void setKey(byte[] paramArrayOfByte)
  {
    this.workingKey = paramArrayOfByte;
    int n = 0;
    this.x = 0;
    this.y = 0;
    if (this.engineState == null) {
      this.engineState = new byte['Ā'];
    }
    int j = 0;
    while (j < 256)
    {
      this.engineState[j] = ((byte)j);
      j += 1;
    }
    int k = 0;
    int m = 0;
    j = n;
    while (j < 256)
    {
      n = paramArrayOfByte[k];
      byte[] arrayOfByte = this.engineState;
      m = (n & 0xFF) + arrayOfByte[j] + m & 0xFF;
      int i = arrayOfByte[j];
      arrayOfByte[j] = arrayOfByte[m];
      arrayOfByte[m] = i;
      k = (k + 1) % paramArrayOfByte.length;
      j += 1;
    }
  }
  
  public String getAlgorithmName()
  {
    return "RC4";
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      paramCipherParameters = ((KeyParameter)paramCipherParameters).getKey();
      this.workingKey = paramCipherParameters;
      setKey(paramCipherParameters);
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to RC4 init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (paramInt1 + paramInt2 <= paramArrayOfByte1.length)
    {
      if (paramInt3 + paramInt2 <= paramArrayOfByte2.length)
      {
        int j = 0;
        while (j < paramInt2)
        {
          int k = this.x + 1 & 0xFF;
          this.x = k;
          byte[] arrayOfByte = this.engineState;
          int m = arrayOfByte[k] + this.y & 0xFF;
          this.y = m;
          int i = arrayOfByte[k];
          arrayOfByte[k] = arrayOfByte[m];
          arrayOfByte[m] = i;
          int n = paramArrayOfByte1[(j + paramInt1)];
          paramArrayOfByte2[(j + paramInt3)] = ((byte)(arrayOfByte[(arrayOfByte[k] + arrayOfByte[m] & 0xFF)] ^ n));
          j += 1;
        }
        return paramInt2;
      }
      throw new OutputLengthException("output buffer too short");
    }
    throw new DataLengthException("input buffer too short");
  }
  
  public void reset()
  {
    setKey(this.workingKey);
  }
  
  public byte returnByte(byte paramByte)
  {
    int j = this.x + 1 & 0xFF;
    this.x = j;
    byte[] arrayOfByte = this.engineState;
    int k = arrayOfByte[j] + this.y & 0xFF;
    this.y = k;
    int i = arrayOfByte[j];
    arrayOfByte[j] = arrayOfByte[k];
    arrayOfByte[k] = i;
    return (byte)(paramByte ^ arrayOfByte[(arrayOfByte[j] + arrayOfByte[k] & 0xFF)]);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\RC4Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */