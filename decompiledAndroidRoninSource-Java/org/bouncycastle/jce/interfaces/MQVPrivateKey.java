package org.bouncycastle.jce.interfaces;

import java.security.PrivateKey;
import java.security.PublicKey;

public abstract interface MQVPrivateKey
  extends PrivateKey
{
  public abstract PrivateKey getEphemeralPrivateKey();
  
  public abstract PublicKey getEphemeralPublicKey();
  
  public abstract PrivateKey getStaticPrivateKey();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\interfaces\MQVPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */