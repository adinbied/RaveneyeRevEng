package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;

public class CMacWithIV
  extends CMac
{
  public CMacWithIV(BlockCipher paramBlockCipher)
  {
    super(paramBlockCipher);
  }
  
  public CMacWithIV(BlockCipher paramBlockCipher, int paramInt)
  {
    super(paramBlockCipher, paramInt);
  }
  
  void validate(CipherParameters paramCipherParameters) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\CMacWithIV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */