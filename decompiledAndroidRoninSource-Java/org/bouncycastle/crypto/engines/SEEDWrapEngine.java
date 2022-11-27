package org.bouncycastle.crypto.engines;

public class SEEDWrapEngine
  extends RFC3394WrapEngine
{
  public SEEDWrapEngine()
  {
    super(new SEEDEngine());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\SEEDWrapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */