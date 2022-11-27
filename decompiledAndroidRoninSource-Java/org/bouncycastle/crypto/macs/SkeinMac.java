package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.digests.SkeinEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.SkeinParameters;
import org.bouncycastle.crypto.params.SkeinParameters.Builder;

public class SkeinMac
  implements Mac
{
  public static final int SKEIN_1024 = 1024;
  public static final int SKEIN_256 = 256;
  public static final int SKEIN_512 = 512;
  private SkeinEngine engine;
  
  public SkeinMac(int paramInt1, int paramInt2)
  {
    this.engine = new SkeinEngine(paramInt1, paramInt2);
  }
  
  public SkeinMac(SkeinMac paramSkeinMac)
  {
    this.engine = new SkeinEngine(paramSkeinMac.engine);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    return this.engine.doFinal(paramArrayOfByte, paramInt);
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Skein-MAC-");
    localStringBuilder.append(this.engine.getBlockSize() * 8);
    localStringBuilder.append("-");
    localStringBuilder.append(this.engine.getOutputSize() * 8);
    return localStringBuilder.toString();
  }
  
  public int getMacSize()
  {
    return this.engine.getOutputSize();
  }
  
  public void init(CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof SkeinParameters))
    {
      paramCipherParameters = (SkeinParameters)paramCipherParameters;
    }
    else
    {
      if (!(paramCipherParameters instanceof KeyParameter)) {
        break label69;
      }
      paramCipherParameters = new SkeinParameters.Builder().setKey(((KeyParameter)paramCipherParameters).getKey()).build();
    }
    if (paramCipherParameters.getKey() != null)
    {
      this.engine.init(paramCipherParameters);
      return;
    }
    throw new IllegalArgumentException("Skein MAC requires a key parameter.");
    label69:
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Invalid parameter passed to Skein MAC init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  public void reset()
  {
    this.engine.reset();
  }
  
  public void update(byte paramByte)
  {
    this.engine.update(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.engine.update(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\SkeinMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */