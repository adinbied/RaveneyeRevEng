package org.bouncycastle.crypto.engines;

public class CamelliaWrapEngine
  extends RFC3394WrapEngine
{
  public CamelliaWrapEngine()
  {
    super(new CamelliaEngine());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\CamelliaWrapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */