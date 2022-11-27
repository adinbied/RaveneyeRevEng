package org.bouncycastle.jcajce.spec;

import javax.crypto.spec.IvParameterSpec;
import org.bouncycastle.util.Arrays;

public class AEADParameterSpec
  extends IvParameterSpec
{
  private final byte[] associatedData;
  private final int macSizeInBits;
  
  public AEADParameterSpec(byte[] paramArrayOfByte, int paramInt)
  {
    this(paramArrayOfByte, paramInt, null);
  }
  
  public AEADParameterSpec(byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2)
  {
    super(paramArrayOfByte1);
    this.macSizeInBits = paramInt;
    this.associatedData = Arrays.clone(paramArrayOfByte2);
  }
  
  public byte[] getAssociatedData()
  {
    return Arrays.clone(this.associatedData);
  }
  
  public int getMacSizeInBits()
  {
    return this.macSizeInBits;
  }
  
  public byte[] getNonce()
  {
    return getIV();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\spec\AEADParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */