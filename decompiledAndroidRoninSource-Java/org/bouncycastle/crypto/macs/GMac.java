package org.bouncycastle.crypto.macs;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.modes.GCMBlockCipher;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;

public class GMac
  implements Mac
{
  private final GCMBlockCipher cipher;
  private final int macSizeBits;
  
  public GMac(GCMBlockCipher paramGCMBlockCipher)
  {
    this.cipher = paramGCMBlockCipher;
    this.macSizeBits = 128;
  }
  
  public GMac(GCMBlockCipher paramGCMBlockCipher, int paramInt)
  {
    this.cipher = paramGCMBlockCipher;
    this.macSizeBits = paramInt;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException, IllegalStateException
  {
    try
    {
      paramInt = this.cipher.doFinal(paramArrayOfByte, paramInt);
      return paramInt;
    }
    catch (InvalidCipherTextException paramArrayOfByte)
    {
      throw new IllegalStateException(paramArrayOfByte.toString());
    }
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cipher.getUnderlyingCipher().getAlgorithmName());
    localStringBuilder.append("-GMAC");
    return localStringBuilder.toString();
  }
  
  public int getMacSize()
  {
    return this.macSizeBits / 8;
  }
  
  public void init(CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      Object localObject = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject).getIV();
      localObject = (KeyParameter)((ParametersWithIV)localObject).getParameters();
      this.cipher.init(true, new AEADParameters((KeyParameter)localObject, this.macSizeBits, paramCipherParameters));
      return;
    }
    throw new IllegalArgumentException("GMAC requires ParametersWithIV");
  }
  
  public void reset()
  {
    this.cipher.reset();
  }
  
  public void update(byte paramByte)
    throws IllegalStateException
  {
    this.cipher.processAADByte(paramByte);
  }
  
  public void update(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws DataLengthException, IllegalStateException
  {
    this.cipher.processAADBytes(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\macs\GMac.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */