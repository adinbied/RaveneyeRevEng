package org.bouncycastle.jce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class IESParameterSpec
  implements AlgorithmParameterSpec
{
  private int cipherKeySize;
  private byte[] derivation;
  private byte[] encoding;
  private int macKeySize;
  private byte[] nonce;
  private boolean usePointCompression;
  
  public IESParameterSpec(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    this(paramArrayOfByte1, paramArrayOfByte2, paramInt, -1, null, false);
  }
  
  public IESParameterSpec(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, byte[] paramArrayOfByte3)
  {
    this(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2, paramArrayOfByte3, false);
  }
  
  public IESParameterSpec(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2, byte[] paramArrayOfByte3, boolean paramBoolean)
  {
    if (paramArrayOfByte1 != null)
    {
      byte[] arrayOfByte = new byte[paramArrayOfByte1.length];
      this.derivation = arrayOfByte;
      System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    }
    else
    {
      this.derivation = null;
    }
    if (paramArrayOfByte2 != null)
    {
      paramArrayOfByte1 = new byte[paramArrayOfByte2.length];
      this.encoding = paramArrayOfByte1;
      System.arraycopy(paramArrayOfByte2, 0, paramArrayOfByte1, 0, paramArrayOfByte2.length);
    }
    else
    {
      this.encoding = null;
    }
    this.macKeySize = paramInt1;
    this.cipherKeySize = paramInt2;
    this.nonce = Arrays.clone(paramArrayOfByte3);
    this.usePointCompression = paramBoolean;
  }
  
  public int getCipherKeySize()
  {
    return this.cipherKeySize;
  }
  
  public byte[] getDerivationV()
  {
    return Arrays.clone(this.derivation);
  }
  
  public byte[] getEncodingV()
  {
    return Arrays.clone(this.encoding);
  }
  
  public int getMacKeySize()
  {
    return this.macKeySize;
  }
  
  public byte[] getNonce()
  {
    return Arrays.clone(this.nonce);
  }
  
  public boolean getPointCompression()
  {
    return this.usePointCompression;
  }
  
  public void setPointCompression(boolean paramBoolean)
  {
    this.usePointCompression = paramBoolean;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\IESParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */