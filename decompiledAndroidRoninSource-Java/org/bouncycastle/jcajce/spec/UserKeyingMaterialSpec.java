package org.bouncycastle.jcajce.spec;

import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class UserKeyingMaterialSpec
  implements AlgorithmParameterSpec
{
  private final byte[] userKeyingMaterial;
  
  public UserKeyingMaterialSpec(byte[] paramArrayOfByte)
  {
    this.userKeyingMaterial = Arrays.clone(paramArrayOfByte);
  }
  
  public byte[] getUserKeyingMaterial()
  {
    return Arrays.clone(this.userKeyingMaterial);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\spec\UserKeyingMaterialSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */