package org.bouncycastle.crypto.digests;

import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.crypto.params.SkeinParameters;
import org.bouncycastle.util.Memoable;

public class SkeinDigest
  implements ExtendedDigest, Memoable
{
  public static final int SKEIN_1024 = 1024;
  public static final int SKEIN_256 = 256;
  public static final int SKEIN_512 = 512;
  private SkeinEngine engine;
  
  public SkeinDigest(int paramInt1, int paramInt2)
  {
    this.engine = new SkeinEngine(paramInt1, paramInt2);
    init(null);
  }
  
  public SkeinDigest(SkeinDigest paramSkeinDigest)
  {
    this.engine = new SkeinEngine(paramSkeinDigest.engine);
  }
  
  public Memoable copy()
  {
    return new SkeinDigest(this);
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
  {
    return this.engine.doFinal(paramArrayOfByte, paramInt);
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Skein-");
    localStringBuilder.append(this.engine.getBlockSize() * 8);
    localStringBuilder.append("-");
    localStringBuilder.append(this.engine.getOutputSize() * 8);
    return localStringBuilder.toString();
  }
  
  public int getByteLength()
  {
    return this.engine.getBlockSize();
  }
  
  public int getDigestSize()
  {
    return this.engine.getOutputSize();
  }
  
  public void init(SkeinParameters paramSkeinParameters)
  {
    this.engine.init(paramSkeinParameters);
  }
  
  public void reset()
  {
    this.engine.reset();
  }
  
  public void reset(Memoable paramMemoable)
  {
    paramMemoable = (SkeinDigest)paramMemoable;
    this.engine.reset(paramMemoable.engine);
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\digests\SkeinDigest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */