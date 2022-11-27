package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class VMPCEngine
  implements StreamCipher
{
  protected byte[] P = null;
  protected byte n = 0;
  protected byte s = 0;
  protected byte[] workingIV;
  protected byte[] workingKey;
  
  public String getAlgorithmName()
  {
    return "VMPC";
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      Object localObject = (ParametersWithIV)paramCipherParameters;
      if ((((ParametersWithIV)localObject).getParameters() instanceof KeyParameter))
      {
        paramCipherParameters = (KeyParameter)((ParametersWithIV)localObject).getParameters();
        localObject = ((ParametersWithIV)localObject).getIV();
        this.workingIV = ((byte[])localObject);
        if ((localObject != null) && (localObject.length >= 1) && (localObject.length <= 768))
        {
          paramCipherParameters = paramCipherParameters.getKey();
          this.workingKey = paramCipherParameters;
          initKey(paramCipherParameters, this.workingIV);
          return;
        }
        throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
      }
      throw new IllegalArgumentException("VMPC init parameters must include a key");
    }
    throw new IllegalArgumentException("VMPC init parameters must include an IV");
  }
  
  protected void initKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.s = 0;
    this.P = new byte['Ā'];
    int k = 0;
    while (k < 256)
    {
      this.P[k] = ((byte)k);
      k += 1;
    }
    k = 0;
    int m;
    int i1;
    int i;
    int j;
    while (k < 768)
    {
      byte[] arrayOfByte = this.P;
      m = this.s;
      i1 = k & 0xFF;
      i = arrayOfByte[(m + arrayOfByte[i1] + paramArrayOfByte1[(k % paramArrayOfByte1.length)] & 0xFF)];
      this.s = i;
      j = arrayOfByte[i1];
      arrayOfByte[i1] = arrayOfByte[(i & 0xFF)];
      arrayOfByte[(i & 0xFF)] = j;
      k += 1;
    }
    k = 0;
    while (k < 768)
    {
      paramArrayOfByte1 = this.P;
      m = this.s;
      i1 = k & 0xFF;
      i = paramArrayOfByte1[(m + paramArrayOfByte1[i1] + paramArrayOfByte2[(k % paramArrayOfByte2.length)] & 0xFF)];
      this.s = i;
      j = paramArrayOfByte1[i1];
      paramArrayOfByte1[i1] = paramArrayOfByte1[(i & 0xFF)];
      paramArrayOfByte1[(i & 0xFF)] = j;
      k += 1;
    }
    this.n = 0;
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (paramInt1 + paramInt2 <= paramArrayOfByte1.length)
    {
      if (paramInt3 + paramInt2 <= paramArrayOfByte2.length)
      {
        int k = 0;
        while (k < paramInt2)
        {
          byte[] arrayOfByte = this.P;
          int i1 = this.s;
          int m = this.n;
          int i = arrayOfByte[(i1 + arrayOfByte[(m & 0xFF)] & 0xFF)];
          this.s = i;
          i1 = arrayOfByte[(arrayOfByte[(arrayOfByte[(i & 0xFF)] & 0xFF)] + 1 & 0xFF)];
          int j = arrayOfByte[(m & 0xFF)];
          arrayOfByte[(m & 0xFF)] = arrayOfByte[(i & 0xFF)];
          arrayOfByte[(i & 0xFF)] = j;
          this.n = ((byte)(m + 1 & 0xFF));
          paramArrayOfByte2[(k + paramInt3)] = ((byte)(paramArrayOfByte1[(k + paramInt1)] ^ i1));
          k += 1;
        }
        return paramInt2;
      }
      throw new OutputLengthException("output buffer too short");
    }
    throw new DataLengthException("input buffer too short");
  }
  
  public void reset()
  {
    initKey(this.workingKey, this.workingIV);
  }
  
  public byte returnByte(byte paramByte)
  {
    byte[] arrayOfByte = this.P;
    byte b = this.s;
    int k = this.n;
    int i = arrayOfByte[(b + arrayOfByte[(k & 0xFF)] & 0xFF)];
    this.s = i;
    b = arrayOfByte[(arrayOfByte[(arrayOfByte[(i & 0xFF)] & 0xFF)] + 1 & 0xFF)];
    int j = arrayOfByte[(k & 0xFF)];
    arrayOfByte[(k & 0xFF)] = arrayOfByte[(i & 0xFF)];
    arrayOfByte[(i & 0xFF)] = j;
    this.n = ((byte)(k + 1 & 0xFF));
    return (byte)(paramByte ^ b);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\VMPCEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */