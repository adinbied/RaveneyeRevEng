package org.bouncycastle.crypto.engines;

public class VMPCKSA3Engine
  extends VMPCEngine
{
  public String getAlgorithmName()
  {
    return "VMPC-KSA3";
  }
  
  protected void initKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.s = 0;
    this.P = new byte['Ā'];
    int j = 0;
    while (j < 256)
    {
      this.P[j] = ((byte)j);
      j += 1;
    }
    j = 0;
    byte[] arrayOfByte1;
    int k;
    byte[] arrayOfByte2;
    int m;
    int i;
    while (j < 768)
    {
      arrayOfByte1 = this.P;
      k = this.s;
      arrayOfByte2 = this.P;
      m = j & 0xFF;
      this.s = arrayOfByte1[(k + arrayOfByte2[m] + paramArrayOfByte1[(j % paramArrayOfByte1.length)] & 0xFF)];
      i = this.P[m];
      this.P[m] = this.P[(this.s & 0xFF)];
      this.P[(this.s & 0xFF)] = i;
      j += 1;
    }
    j = 0;
    while (j < 768)
    {
      arrayOfByte1 = this.P;
      k = this.s;
      arrayOfByte2 = this.P;
      m = j & 0xFF;
      this.s = arrayOfByte1[(k + arrayOfByte2[m] + paramArrayOfByte2[(j % paramArrayOfByte2.length)] & 0xFF)];
      i = this.P[m];
      this.P[m] = this.P[(this.s & 0xFF)];
      this.P[(this.s & 0xFF)] = i;
      j += 1;
    }
    j = 0;
    while (j < 768)
    {
      paramArrayOfByte2 = this.P;
      k = this.s;
      arrayOfByte1 = this.P;
      m = j & 0xFF;
      this.s = paramArrayOfByte2[(k + arrayOfByte1[m] + paramArrayOfByte1[(j % paramArrayOfByte1.length)] & 0xFF)];
      i = this.P[m];
      this.P[m] = this.P[(this.s & 0xFF)];
      this.P[(this.s & 0xFF)] = i;
      j += 1;
    }
    this.n = 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\VMPCKSA3Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */