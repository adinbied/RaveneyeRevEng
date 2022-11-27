package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.StreamBlockCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.crypto.params.ParametersWithRandom;
import org.bouncycastle.crypto.params.ParametersWithSBox;

public class GCFBBlockCipher
  extends StreamBlockCipher
{
  private static final byte[] C = { 105, 0, 114, 34, 100, -55, 4, 35, -115, 58, -37, -106, 70, -23, 42, -60, 24, -2, -84, -108, 0, -19, 7, 18, -64, -122, -36, -62, -17, 76, -87, 43 };
  private final CFBBlockCipher cfbEngine;
  private long counter = 0L;
  private boolean forEncryption;
  private KeyParameter key;
  
  public GCFBBlockCipher(BlockCipher paramBlockCipher)
  {
    super(paramBlockCipher);
    this.cfbEngine = new CFBBlockCipher(paramBlockCipher, paramBlockCipher.getBlockSize() * 8);
  }
  
  protected byte calculateByte(byte paramByte)
  {
    long l = this.counter;
    if ((l > 0L) && (l % 1024L == 0L))
    {
      BlockCipher localBlockCipher = this.cfbEngine.getUnderlyingCipher();
      localBlockCipher.init(false, this.key);
      Object localObject = new byte[32];
      localBlockCipher.processBlock(C, 0, (byte[])localObject, 0);
      localBlockCipher.processBlock(C, 8, (byte[])localObject, 8);
      localBlockCipher.processBlock(C, 16, (byte[])localObject, 16);
      localBlockCipher.processBlock(C, 24, (byte[])localObject, 24);
      localObject = new KeyParameter((byte[])localObject);
      this.key = ((KeyParameter)localObject);
      localBlockCipher.init(true, (CipherParameters)localObject);
      localObject = this.cfbEngine.getCurrentIV();
      localBlockCipher.processBlock((byte[])localObject, 0, (byte[])localObject, 0);
      this.cfbEngine.init(this.forEncryption, new ParametersWithIV(this.key, (byte[])localObject));
    }
    this.counter += 1L;
    return this.cfbEngine.calculateByte(paramByte);
  }
  
  public String getAlgorithmName()
  {
    String str = this.cfbEngine.getAlgorithmName();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str.substring(0, str.indexOf('/')));
    localStringBuilder.append("/G");
    localStringBuilder.append(str.substring(str.indexOf('/') + 1));
    return localStringBuilder.toString();
  }
  
  public int getBlockSize()
  {
    return this.cfbEngine.getBlockSize();
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    this.counter = 0L;
    this.cfbEngine.init(paramBoolean, paramCipherParameters);
    this.forEncryption = paramBoolean;
    CipherParameters localCipherParameters = paramCipherParameters;
    if ((paramCipherParameters instanceof ParametersWithIV)) {
      localCipherParameters = ((ParametersWithIV)paramCipherParameters).getParameters();
    }
    paramCipherParameters = localCipherParameters;
    if ((localCipherParameters instanceof ParametersWithRandom)) {
      paramCipherParameters = ((ParametersWithRandom)localCipherParameters).getParameters();
    }
    localCipherParameters = paramCipherParameters;
    if ((paramCipherParameters instanceof ParametersWithSBox)) {
      localCipherParameters = ((ParametersWithSBox)paramCipherParameters).getParameters();
    }
    this.key = ((KeyParameter)localCipherParameters);
  }
  
  public int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    processBytes(paramArrayOfByte1, paramInt1, this.cfbEngine.getBlockSize(), paramArrayOfByte2, paramInt2);
    return this.cfbEngine.getBlockSize();
  }
  
  public void reset()
  {
    this.counter = 0L;
    this.cfbEngine.reset();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\GCFBBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */