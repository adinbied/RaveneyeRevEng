package org.bouncycastle.jcajce.spec;

import java.security.spec.KeySpec;
import org.bouncycastle.util.Arrays;

public class TLSKeyMaterialSpec
  implements KeySpec
{
  public static final String KEY_EXPANSION = "key expansion";
  public static final String MASTER_SECRET = "master secret";
  private final String label;
  private final int length;
  private final byte[] secret;
  private final byte[] seed;
  
  public TLSKeyMaterialSpec(byte[] paramArrayOfByte, String paramString, int paramInt, byte[]... paramVarArgs)
  {
    this.secret = Arrays.clone(paramArrayOfByte);
    this.label = paramString;
    this.length = paramInt;
    this.seed = Arrays.concatenate(paramVarArgs);
  }
  
  public String getLabel()
  {
    return this.label;
  }
  
  public int getLength()
  {
    return this.length;
  }
  
  public byte[] getSecret()
  {
    return Arrays.clone(this.secret);
  }
  
  public byte[] getSeed()
  {
    return Arrays.clone(this.seed);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\spec\TLSKeyMaterialSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */