package org.bouncycastle.crypto.engines;

public class AESWrapEngine
  extends RFC3394WrapEngine
{
  public AESWrapEngine()
  {
    super(new AESEngine());
  }
  
  public AESWrapEngine(boolean paramBoolean)
  {
    super(new AESEngine(), paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\AESWrapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */