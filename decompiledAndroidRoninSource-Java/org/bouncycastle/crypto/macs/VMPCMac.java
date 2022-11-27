package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class VMPCMac
  implements Mac
{
  private byte[] P = null;
  private byte[] T;
  private byte g;
  private byte n = 0;
  private byte s = 0;
  private byte[] workingIV;
  private byte[] workingKey;
  private byte x1;
  private byte x2;
  private byte x3;
  private byte x4;
  
  private void initKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
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
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException
  {
    int j = 1;
    int m;
    int k;
    int i;
    byte b1;
    byte[] arrayOfByte2;
    while (j < 25)
    {
      arrayOfByte1 = this.P;
      m = this.s;
      k = this.n;
      i = arrayOfByte1[(m + arrayOfByte1[(k & 0xFF)] & 0xFF)];
      this.s = i;
      int i1 = this.x4;
      m = this.x3;
      b1 = arrayOfByte1[(i1 + m + j & 0xFF)];
      this.x4 = b1;
      i1 = this.x2;
      byte b2 = arrayOfByte1[(m + i1 + j & 0xFF)];
      this.x3 = b2;
      m = this.x1;
      byte b3 = arrayOfByte1[(i1 + m + j & 0xFF)];
      this.x2 = b3;
      byte b4 = arrayOfByte1[(m + i + j & 0xFF)];
      this.x1 = b4;
      arrayOfByte2 = this.T;
      m = this.g;
      arrayOfByte2[(m & 0x1F)] = ((byte)(b4 ^ arrayOfByte2[(m & 0x1F)]));
      arrayOfByte2[(m + 1 & 0x1F)] = ((byte)(b3 ^ arrayOfByte2[(m + 1 & 0x1F)]));
      arrayOfByte2[(m + 2 & 0x1F)] = ((byte)(b2 ^ arrayOfByte2[(m + 2 & 0x1F)]));
      arrayOfByte2[(m + 3 & 0x1F)] = ((byte)(b1 ^ arrayOfByte2[(m + 3 & 0x1F)]));
      this.g = ((byte)(m + 4 & 0x1F));
      b1 = arrayOfByte1[(k & 0xFF)];
      arrayOfByte1[(k & 0xFF)] = arrayOfByte1[(i & 0xFF)];
      arrayOfByte1[(i & 0xFF)] = b1;
      this.n = ((byte)(k + 1 & 0xFF));
      j += 1;
    }
    j = 0;
    while (j < 768)
    {
      arrayOfByte1 = this.P;
      k = this.s;
      m = j & 0xFF;
      i = arrayOfByte1[(k + arrayOfByte1[m] + this.T[(j & 0x1F)] & 0xFF)];
      this.s = i;
      b1 = arrayOfByte1[m];
      arrayOfByte1[m] = arrayOfByte1[(i & 0xFF)];
      arrayOfByte1[(i & 0xFF)] = b1;
      j += 1;
    }
    byte[] arrayOfByte1 = new byte[20];
    j = 0;
    while (j < 20)
    {
      arrayOfByte2 = this.P;
      k = this.s;
      m = j & 0xFF;
      i = arrayOfByte2[(k + arrayOfByte2[m] & 0xFF)];
      this.s = i;
      arrayOfByte1[j] = arrayOfByte2[(arrayOfByte2[(arrayOfByte2[(i & 0xFF)] & 0xFF)] + 1 & 0xFF)];
      b1 = arrayOfByte2[m];
      arrayOfByte2[m] = arrayOfByte2[(i & 0xFF)];
      arrayOfByte2[(i & 0xFF)] = b1;
      j += 1;
    }
    System.arraycopy(arrayOfByte1, 0, paramArrayOfByte, paramInt, 20);
    reset();
    return 20;
  }
  
  public String getAlgorithmName()
  {
    return "VMPC-MAC";
  }
  
  public int getMacSize()
  {
    return 20;
  }
  
  public void init(CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      Object localObject = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = (KeyParameter)((ParametersWithIV)localObject).getParameters();
      if ((((ParametersWithIV)localObject).getParameters() instanceof KeyParameter))
      {
        localObject = ((ParametersWithIV)localObject).getIV();
        this.workingIV = ((byte[])localObject);
        if ((localObject != null) && (localObject.length >= 1) && (localObject.length <= 768))
        {
          this.workingKey = paramCipherParameters.getKey();
          reset();
          return;
        }
        throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
      }
      throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
    }
    throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
  }
  
  public void reset()
  {
    initKey(this.workingKey, this.workingIV);
    this.n = 0;
    this.x4 = 0;
    this.x3 = 0;
    this.x2 = 0;
    this.x1 = 0;
    this.g = 0;
    this.T = new byte[32];
    int i = 0;
    while (i < 32)
    {
      this.T[i] = 0;
      i += 1;
    }
  }
  
  public void update(byte paramByte)
    throws IllegalStateException
  {
    byte[] arrayOfByte1 = this.P;
    int k = this.s;
    int j = this.n;
    int i = arrayOfByte1[(k + arrayOfByte1[(j & 0xFF)] & 0xFF)];
    this.s = i;
    paramByte = (byte)(paramByte ^ arrayOfByte1[(arrayOfByte1[(arrayOfByte1[(i & 0xFF)] & 0xFF)] + 1 & 0xFF)]);
    int m = this.x4;
    k = this.x3;
    byte b1 = arrayOfByte1[(m + k & 0xFF)];
    this.x4 = b1;
    m = this.x2;
    byte b2 = arrayOfByte1[(k + m & 0xFF)];
    this.x3 = b2;
    k = this.x1;
    byte b3 = arrayOfByte1[(m + k & 0xFF)];
    this.x2 = b3;
    byte b4 = arrayOfByte1[(k + i + paramByte & 0xFF)];
    this.x1 = b4;
    byte[] arrayOfByte2 = this.T;
    paramByte = this.g;
    arrayOfByte2[(paramByte & 0x1F)] = ((byte)(b4 ^ arrayOfByte2[(paramByte & 0x1F)]));
    arrayOfByte2[(paramByte + 1 & 0x1F)] = ((byte)(b3 ^ arrayOfByte2[(paramByte + 1 & 0x1F)]));
    arrayOfByte2[(paramByte + 2 & 0x1F)] = ((byte)(b2 ^ arrayOfByte2[(paramByte + 2 & 0x1F)]));
    arrayOfByte2[(paramByte + 3 & 0x1F)] = ((byte)(b1 ^ arrayOfByte2[(paramByte + 3 & 0x1F)]));
    this.g = ((byte)(paramByte + 4 & 0x1F));
    b1 = arrayOfByte1[(j & 0xFF)];
    arrayOfByte1[(j & 0xFF)] = arrayOfByte1[(i & 0xFF)];
    arrayOfByte1[(i & 0xFF)] = b1;
    this.n = ((byte)(j + 1 & 0xFF));
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    if (paramInt1 + paramInt2 <= paramArrayOfByte.length)
    {
      int i = 0;
      while (i < paramInt2)
      {
        update(paramArrayOfByte[(paramInt1 + i)]);
        i += 1;
      }
      return;
    }
    throw new DataLengthException("input buffer too short");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\VMPCMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */