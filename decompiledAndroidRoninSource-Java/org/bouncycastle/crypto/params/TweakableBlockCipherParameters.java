package org.bouncycastle.crypto.params;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.util.Arrays;

public class TweakableBlockCipherParameters
  implements CipherParameters
{
  private final KeyParameter key;
  private final byte[] tweak;
  
  public TweakableBlockCipherParameters(KeyParameter paramKeyParameter, byte[] paramArrayOfByte)
  {
    this.key = paramKeyParameter;
    this.tweak = Arrays.clone(paramArrayOfByte);
  }
  
  public KeyParameter getKey()
  {
    return this.key;
  }
  
  public byte[] getTweak()
  {
    return this.tweak;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\params\TweakableBlockCipherParameters.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */