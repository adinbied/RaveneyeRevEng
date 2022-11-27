package org.bouncycastle.jce.spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.bouncycastle.jce.interfaces.MQVPrivateKey;

public class MQVPrivateKeySpec
  implements KeySpec, MQVPrivateKey
{
  private PrivateKey ephemeralPrivateKey;
  private PublicKey ephemeralPublicKey;
  private PrivateKey staticPrivateKey;
  
  public MQVPrivateKeySpec(PrivateKey paramPrivateKey1, PrivateKey paramPrivateKey2)
  {
    this(paramPrivateKey1, paramPrivateKey2, null);
  }
  
  public MQVPrivateKeySpec(PrivateKey paramPrivateKey1, PrivateKey paramPrivateKey2, PublicKey paramPublicKey)
  {
    this.staticPrivateKey = paramPrivateKey1;
    this.ephemeralPrivateKey = paramPrivateKey2;
    this.ephemeralPublicKey = paramPublicKey;
  }
  
  public String getAlgorithm()
  {
    return "ECMQV";
  }
  
  public byte[] getEncoded()
  {
    return null;
  }
  
  public PrivateKey getEphemeralPrivateKey()
  {
    return this.ephemeralPrivateKey;
  }
  
  public PublicKey getEphemeralPublicKey()
  {
    return this.ephemeralPublicKey;
  }
  
  public String getFormat()
  {
    return null;
  }
  
  public PrivateKey getStaticPrivateKey()
  {
    return this.staticPrivateKey;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\spec\MQVPrivateKeySpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */