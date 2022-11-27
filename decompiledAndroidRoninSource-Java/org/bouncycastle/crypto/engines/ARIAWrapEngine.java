package org.bouncycastle.crypto.engines;

public class ARIAWrapEngine
  extends RFC3394WrapEngine
{
  public ARIAWrapEngine()
  {
    super(new ARIAEngine());
  }
  
  public ARIAWrapEngine(boolean paramBoolean)
  {
    super(new ARIAEngine(), paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\ARIAWrapEngine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */