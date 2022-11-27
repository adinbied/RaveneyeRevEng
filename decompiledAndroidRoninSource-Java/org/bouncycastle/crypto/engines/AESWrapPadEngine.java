package org.bouncycastle.crypto.engines;

public class AESWrapPadEngine
  extends RFC5649WrapEngine
{
  public AESWrapPadEngine()
  {
    super(new AESEngine());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\AESWrapPadEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */