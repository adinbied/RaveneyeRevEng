package org.bouncycastle.jcajce.provider.drbg;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.SecureRandomSpi;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.prng.EntropySource;
import org.bouncycastle.crypto.prng.EntropySourceProvider;
import org.bouncycastle.crypto.prng.SP800SecureRandom;
import org.bouncycastle.crypto.prng.SP800SecureRandomBuilder;
import org.bouncycastle.jcajce.provider.config.ConfigurableProvider;
import org.bouncycastle.jcajce.provider.util.AsymmetricAlgorithmProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;

public class DRBG
{
  private static final String PREFIX = DRBG.class.getName();
  private static final Object[] initialEntropySourceAndSpi = findSource();
  private static final String[][] initialEntropySourceNames;
  
  static
  {
    String[] arrayOfString = { "com.android.org.conscrypt.OpenSSLProvider", "com.android.org.conscrypt.OpenSSLRandom" };
    initialEntropySourceNames = new String[][] { { "sun.security.provider.Sun", "sun.security.provider.SecureRandom" }, { "org.apache.harmony.security.provider.crypto.CryptoProvider", "org.apache.harmony.security.provider.crypto.SHA1PRNG_SecureRandomImpl" }, arrayOfString, { "org.conscrypt.OpenSSLProvider", "org.conscrypt.OpenSSLRandom" } };
  }
  
  private static SecureRandom createBaseRandom(boolean paramBoolean)
  {
    if (System.getProperty("org.bouncycastle.drbg.entropysource") != null)
    {
      localObject = createEntropySource();
      EntropySource localEntropySource = ((EntropySourceProvider)localObject).get(128);
      arrayOfByte = localEntropySource.getEntropy();
      if (paramBoolean) {
        arrayOfByte = generateDefaultPersonalizationString(arrayOfByte);
      } else {
        arrayOfByte = generateNonceIVPersonalizationString(arrayOfByte);
      }
      return new SP800SecureRandomBuilder((EntropySourceProvider)localObject).setPersonalizationString(arrayOfByte).buildHash(new SHA512Digest(), Arrays.concatenate(localEntropySource.getEntropy(), localEntropySource.getEntropy()), paramBoolean);
    }
    Object localObject = new HybridSecureRandom();
    byte[] arrayOfByte = ((SecureRandom)localObject).generateSeed(16);
    if (paramBoolean) {
      arrayOfByte = generateDefaultPersonalizationString(arrayOfByte);
    } else {
      arrayOfByte = generateNonceIVPersonalizationString(arrayOfByte);
    }
    return new SP800SecureRandomBuilder((SecureRandom)localObject, true).setPersonalizationString(arrayOfByte).buildHash(new SHA512Digest(), ((SecureRandom)localObject).generateSeed(32), paramBoolean);
  }
  
  private static EntropySourceProvider createEntropySource()
  {
    (EntropySourceProvider)AccessController.doPrivileged(new PrivilegedAction()
    {
      public EntropySourceProvider run()
      {
        try
        {
          EntropySourceProvider localEntropySourceProvider = (EntropySourceProvider)DRBG.class.getClassLoader().loadClass(this.val$sourceClass).newInstance();
          return localEntropySourceProvider;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("entropy source ");
          localStringBuilder.append(this.val$sourceClass);
          localStringBuilder.append(" not created: ");
          localStringBuilder.append(localException.getMessage());
          throw new IllegalStateException(localStringBuilder.toString(), localException);
        }
      }
    });
  }
  
  private static SecureRandom createInitialEntropySource()
  {
    if (initialEntropySourceAndSpi != null) {
      return new CoreSecureRandom();
    }
    return new SecureRandom();
  }
  
  private static final Object[] findSource()
  {
    int i = 0;
    for (;;)
    {
      Object localObject1 = initialEntropySourceNames;
      if (i >= localObject1.length) {
        break;
      }
      Object localObject3 = localObject1[i];
      try
      {
        localObject1 = Class.forName(localObject3[0]).newInstance();
        localObject3 = Class.forName(localObject3[1]).newInstance();
        return new Object[] { localObject1, localObject3 };
      }
      finally
      {
        for (;;) {}
      }
      i += 1;
    }
    return null;
  }
  
  private static byte[] generateDefaultPersonalizationString(byte[] paramArrayOfByte)
  {
    return Arrays.concatenate(Strings.toByteArray("Default"), paramArrayOfByte, Pack.longToBigEndian(Thread.currentThread().getId()), Pack.longToBigEndian(System.currentTimeMillis()));
  }
  
  private static byte[] generateNonceIVPersonalizationString(byte[] paramArrayOfByte)
  {
    return Arrays.concatenate(Strings.toByteArray("Nonce"), paramArrayOfByte, Pack.longToLittleEndian(Thread.currentThread().getId()), Pack.longToLittleEndian(System.currentTimeMillis()));
  }
  
  private static class CoreSecureRandom
    extends SecureRandom
  {
    CoreSecureRandom()
    {
      super((Provider)DRBG.initialEntropySourceAndSpi[0]);
    }
  }
  
  public static class Default
    extends SecureRandomSpi
  {
    private static final SecureRandom random = DRBG.createBaseRandom(true);
    
    protected byte[] engineGenerateSeed(int paramInt)
    {
      return random.generateSeed(paramInt);
    }
    
    protected void engineNextBytes(byte[] paramArrayOfByte)
    {
      random.nextBytes(paramArrayOfByte);
    }
    
    protected void engineSetSeed(byte[] paramArrayOfByte)
    {
      random.setSeed(paramArrayOfByte);
    }
  }
  
  private static class HybridSecureRandom
    extends SecureRandom
  {
    private final SecureRandom baseRandom = DRBG.access$300();
    private final SP800SecureRandom drbg = new SP800SecureRandomBuilder(new EntropySourceProvider()
    {
      public EntropySource get(int paramAnonymousInt)
      {
        return new DRBG.HybridSecureRandom.SignallingEntropySource(DRBG.HybridSecureRandom.this, paramAnonymousInt);
      }
    }).setPersonalizationString(Strings.toByteArray("Bouncy Castle Hybrid Entropy Source")).buildHMAC(new HMac(new SHA512Digest()), this.baseRandom.generateSeed(32), false);
    private final AtomicInteger samples = new AtomicInteger(0);
    private final AtomicBoolean seedAvailable = new AtomicBoolean(false);
    
    public byte[] generateSeed(int paramInt)
    {
      byte[] arrayOfByte = new byte[paramInt];
      if ((this.samples.getAndIncrement() > 20) && (this.seedAvailable.getAndSet(false)))
      {
        this.samples.set(0);
        this.drbg.reseed(null);
      }
      this.drbg.nextBytes(arrayOfByte);
      return arrayOfByte;
    }
    
    private class SignallingEntropySource
      implements EntropySource
    {
      private final int byteLength;
      private final AtomicReference entropy = new AtomicReference();
      private final AtomicBoolean scheduled = new AtomicBoolean(false);
      
      SignallingEntropySource(int paramInt)
      {
        this.byteLength = ((paramInt + 7) / 8);
      }
      
      public int entropySize()
      {
        return this.byteLength * 8;
      }
      
      public byte[] getEntropy()
      {
        byte[] arrayOfByte = (byte[])this.entropy.getAndSet(null);
        if ((arrayOfByte != null) && (arrayOfByte.length == this.byteLength)) {
          this.scheduled.set(false);
        } else {
          arrayOfByte = DRBG.HybridSecureRandom.this.baseRandom.generateSeed(this.byteLength);
        }
        if (!this.scheduled.getAndSet(true)) {
          new Thread(new EntropyGatherer(this.byteLength)).start();
        }
        return arrayOfByte;
      }
      
      public boolean isPredictionResistant()
      {
        return true;
      }
      
      private class EntropyGatherer
        implements Runnable
      {
        private final int numBytes;
        
        EntropyGatherer(int paramInt)
        {
          this.numBytes = paramInt;
        }
        
        public void run()
        {
          DRBG.HybridSecureRandom.SignallingEntropySource.this.entropy.set(DRBG.HybridSecureRandom.this.baseRandom.generateSeed(this.numBytes));
          DRBG.HybridSecureRandom.this.seedAvailable.set(true);
        }
      }
    }
  }
  
  public static class Mappings
    extends AsymmetricAlgorithmProvider
  {
    public void configure(ConfigurableProvider paramConfigurableProvider)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(DRBG.PREFIX);
      localStringBuilder.append("$Default");
      paramConfigurableProvider.addAlgorithm("SecureRandom.DEFAULT", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(DRBG.PREFIX);
      localStringBuilder.append("$NonceAndIV");
      paramConfigurableProvider.addAlgorithm("SecureRandom.NONCEANDIV", localStringBuilder.toString());
    }
  }
  
  public static class NonceAndIV
    extends SecureRandomSpi
  {
    private static final SecureRandom random = DRBG.createBaseRandom(false);
    
    protected byte[] engineGenerateSeed(int paramInt)
    {
      return random.generateSeed(paramInt);
    }
    
    protected void engineNextBytes(byte[] paramArrayOfByte)
    {
      random.nextBytes(paramArrayOfByte);
    }
    
    protected void engineSetSeed(byte[] paramArrayOfByte)
    {
      random.setSeed(paramArrayOfByte);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\drbg\DRBG.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */