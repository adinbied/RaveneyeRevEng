package org.bouncycastle.crypto.tls;

import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class BasicTlsPSKIdentity
  implements TlsPSKIdentity
{
  protected byte[] identity;
  protected byte[] psk;
  
  public BasicTlsPSKIdentity(String paramString, byte[] paramArrayOfByte)
  {
    this.identity = Strings.toUTF8ByteArray(paramString);
    this.psk = Arrays.clone(paramArrayOfByte);
  }
  
  public BasicTlsPSKIdentity(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.identity = Arrays.clone(paramArrayOfByte1);
    this.psk = Arrays.clone(paramArrayOfByte2);
  }
  
  public byte[] getPSK()
  {
    return this.psk;
  }
  
  public byte[] getPSKIdentity()
  {
    return this.identity;
  }
  
  public void notifyIdentityHint(byte[] paramArrayOfByte) {}
  
  public void skipIdentityHint() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\BasicTlsPSKIdentity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */