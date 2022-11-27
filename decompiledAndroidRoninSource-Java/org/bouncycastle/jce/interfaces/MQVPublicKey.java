package org.bouncycastle.jce.interfaces;

import java.security.PublicKey;

public abstract interface MQVPublicKey
  extends PublicKey
{
  public abstract PublicKey getEphemeralKey();
  
  public abstract PublicKey getStaticKey();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\interfaces\MQVPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */