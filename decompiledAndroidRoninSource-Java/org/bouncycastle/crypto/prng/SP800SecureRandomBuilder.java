package org.bouncycastle.crypto.prng;

import java.security.SecureRandom;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.prng.drbg.CTRSP800DRBG;
import org.bouncycastle.crypto.prng.drbg.HMacSP800DRBG;
import org.bouncycastle.crypto.prng.drbg.HashSP800DRBG;
import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;

public class SP800SecureRandomBuilder
{
  private int entropyBitsRequired = 256;
  private final EntropySourceProvider entropySourceProvider;
  private byte[] personalizationString;
  private final SecureRandom random;
  private int securityStrength = 256;
  
  public SP800SecureRandomBuilder()
  {
    this(new SecureRandom(), false);
  }
  
  public SP800SecureRandomBuilder(SecureRandom paramSecureRandom, boolean paramBoolean)
  {
    this.random = paramSecureRandom;
    this.entropySourceProvider = new BasicEntropySourceProvider(paramSecureRandom, paramBoolean);
  }
  
  public SP800SecureRandomBuilder(EntropySourceProvider paramEntropySourceProvider)
  {
    this.random = null;
    this.entropySourceProvider = paramEntropySourceProvider;
  }
  
  public SP800SecureRandom buildCTR(BlockCipher paramBlockCipher, int paramInt, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new CTRDRBGProvider(paramBlockCipher, paramInt, paramArrayOfByte, this.personalizationString, this.securityStrength), paramBoolean);
  }
  
  public SP800SecureRandom buildHMAC(Mac paramMac, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new HMacDRBGProvider(paramMac, paramArrayOfByte, this.personalizationString, this.securityStrength), paramBoolean);
  }
  
  public SP800SecureRandom buildHash(Digest paramDigest, byte[] paramArrayOfByte, boolean paramBoolean)
  {
    return new SP800SecureRandom(this.random, this.entropySourceProvider.get(this.entropyBitsRequired), new HashDRBGProvider(paramDigest, paramArrayOfByte, this.personalizationString, this.securityStrength), paramBoolean);
  }
  
  public SP800SecureRandomBuilder setEntropyBitsRequired(int paramInt)
  {
    this.entropyBitsRequired = paramInt;
    return this;
  }
  
  public SP800SecureRandomBuilder setPersonalizationString(byte[] paramArrayOfByte)
  {
    this.personalizationString = paramArrayOfByte;
    return this;
  }
  
  public SP800SecureRandomBuilder setSecurityStrength(int paramInt)
  {
    this.securityStrength = paramInt;
    return this;
  }
  
  private static class CTRDRBGProvider
    implements DRBGProvider
  {
    private final BlockCipher blockCipher;
    private final int keySizeInBits;
    private final byte[] nonce;
    private final byte[] personalizationString;
    private final int securityStrength;
    
    public CTRDRBGProvider(BlockCipher paramBlockCipher, int paramInt1, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt2)
    {
      this.blockCipher = paramBlockCipher;
      this.keySizeInBits = paramInt1;
      this.nonce = paramArrayOfByte1;
      this.personalizationString = paramArrayOfByte2;
      this.securityStrength = paramInt2;
    }
    
    public SP80090DRBG get(EntropySource paramEntropySource)
    {
      return new CTRSP800DRBG(this.blockCipher, this.keySizeInBits, this.securityStrength, paramEntropySource, this.personalizationString, this.nonce);
    }
  }
  
  private static class HMacDRBGProvider
    implements DRBGProvider
  {
    private final Mac hMac;
    private final byte[] nonce;
    private final byte[] personalizationString;
    private final int securityStrength;
    
    public HMacDRBGProvider(Mac paramMac, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
    {
      this.hMac = paramMac;
      this.nonce = paramArrayOfByte1;
      this.personalizationString = paramArrayOfByte2;
      this.securityStrength = paramInt;
    }
    
    public SP80090DRBG get(EntropySource paramEntropySource)
    {
      return new HMacSP800DRBG(this.hMac, this.securityStrength, paramEntropySource, this.personalizationString, this.nonce);
    }
  }
  
  private static class HashDRBGProvider
    implements DRBGProvider
  {
    private final Digest digest;
    private final byte[] nonce;
    private final byte[] personalizationString;
    private final int securityStrength;
    
    public HashDRBGProvider(Digest paramDigest, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
    {
      this.digest = paramDigest;
      this.nonce = paramArrayOfByte1;
      this.personalizationString = paramArrayOfByte2;
      this.securityStrength = paramInt;
    }
    
    public SP80090DRBG get(EntropySource paramEntropySource)
    {
      return new HashSP800DRBG(this.digest, this.securityStrength, paramEntropySource, this.personalizationString, this.nonce);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\SP800SecureRandomBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */