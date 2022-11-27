package org.bouncycastle.jcajce.spec;

import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.util.Arrays;

public class MQVParameterSpec
  implements AlgorithmParameterSpec
{
  private final PrivateKey ephemeralPrivateKey;
  private final PublicKey ephemeralPublicKey;
  private final PublicKey otherPartyEphemeralKey;
  private final byte[] userKeyingMaterial;
  
  public MQVParameterSpec(KeyPair paramKeyPair, PublicKey paramPublicKey)
  {
    this(paramKeyPair.getPublic(), paramKeyPair.getPrivate(), paramPublicKey, null);
  }
  
  public MQVParameterSpec(KeyPair paramKeyPair, PublicKey paramPublicKey, byte[] paramArrayOfByte)
  {
    this(paramKeyPair.getPublic(), paramKeyPair.getPrivate(), paramPublicKey, paramArrayOfByte);
  }
  
  public MQVParameterSpec(PrivateKey paramPrivateKey, PublicKey paramPublicKey)
  {
    this(null, paramPrivateKey, paramPublicKey, null);
  }
  
  public MQVParameterSpec(PrivateKey paramPrivateKey, PublicKey paramPublicKey, byte[] paramArrayOfByte)
  {
    this(null, paramPrivateKey, paramPublicKey, paramArrayOfByte);
  }
  
  public MQVParameterSpec(PublicKey paramPublicKey1, PrivateKey paramPrivateKey, PublicKey paramPublicKey2)
  {
    this(paramPublicKey1, paramPrivateKey, paramPublicKey2, null);
  }
  
  public MQVParameterSpec(PublicKey paramPublicKey1, PrivateKey paramPrivateKey, PublicKey paramPublicKey2, byte[] paramArrayOfByte)
  {
    this.ephemeralPublicKey = paramPublicKey1;
    this.ephemeralPrivateKey = paramPrivateKey;
    this.otherPartyEphemeralKey = paramPublicKey2;
    this.userKeyingMaterial = Arrays.clone(paramArrayOfByte);
  }
  
  public PrivateKey getEphemeralPrivateKey()
  {
    return this.ephemeralPrivateKey;
  }
  
  public PublicKey getEphemeralPublicKey()
  {
    return this.ephemeralPublicKey;
  }
  
  public PublicKey getOtherPartyEphemeralKey()
  {
    return this.otherPartyEphemeralKey;
  }
  
  public byte[] getUserKeyingMaterial()
  {
    return Arrays.clone(this.userKeyingMaterial);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\spec\MQVParameterSpec.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */