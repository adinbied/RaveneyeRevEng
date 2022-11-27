package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.Mac;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.macs.CMac;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class EAXBlockCipher
  implements AEADBlockCipher
{
  private static final byte cTAG = 2;
  private static final byte hTAG = 1;
  private static final byte nTAG = 0;
  private byte[] associatedTextMac;
  private int blockSize;
  private byte[] bufBlock;
  private int bufOff;
  private SICBlockCipher cipher;
  private boolean cipherInitialized;
  private boolean forEncryption;
  private byte[] initialAssociatedText;
  private Mac mac;
  private byte[] macBlock;
  private int macSize;
  private byte[] nonceMac;
  
  public EAXBlockCipher(BlockCipher paramBlockCipher)
  {
    this.blockSize = paramBlockCipher.getBlockSize();
    CMac localCMac = new CMac(paramBlockCipher);
    this.mac = localCMac;
    this.macBlock = new byte[this.blockSize];
    this.associatedTextMac = new byte[localCMac.getMacSize()];
    this.nonceMac = new byte[this.mac.getMacSize()];
    this.cipher = new SICBlockCipher(paramBlockCipher);
  }
  
  private void calculateMac()
  {
    byte[] arrayOfByte = new byte[this.blockSize];
    Object localObject = this.mac;
    int i = 0;
    ((Mac)localObject).doFinal(arrayOfByte, 0);
    for (;;)
    {
      localObject = this.macBlock;
      if (i >= localObject.length) {
        break;
      }
      localObject[i] = ((byte)(this.nonceMac[i] ^ this.associatedTextMac[i] ^ arrayOfByte[i]));
      i += 1;
    }
  }
  
  private void initCipher()
  {
    if (this.cipherInitialized) {
      return;
    }
    this.cipherInitialized = true;
    this.mac.doFinal(this.associatedTextMac, 0);
    int i = this.blockSize;
    byte[] arrayOfByte = new byte[i];
    arrayOfByte[(i - 1)] = 2;
    this.mac.update(arrayOfByte, 0, i);
  }
  
  private int process(byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.bufBlock;
    int i = this.bufOff;
    int j = i + 1;
    this.bufOff = j;
    arrayOfByte[i] = paramByte;
    if (j == arrayOfByte.length)
    {
      i = paramArrayOfByte.length;
      j = this.blockSize;
      if (i >= paramInt + j)
      {
        if (this.forEncryption)
        {
          i = this.cipher.processBlock(arrayOfByte, 0, paramArrayOfByte, paramInt);
          this.mac.update(paramArrayOfByte, paramInt, this.blockSize);
          paramInt = i;
        }
        else
        {
          this.mac.update(arrayOfByte, 0, j);
          paramInt = this.cipher.processBlock(this.bufBlock, 0, paramArrayOfByte, paramInt);
        }
        this.bufOff = 0;
        if (!this.forEncryption)
        {
          paramArrayOfByte = this.bufBlock;
          System.arraycopy(paramArrayOfByte, this.blockSize, paramArrayOfByte, 0, this.macSize);
          this.bufOff = this.macSize;
        }
        return paramInt;
      }
      throw new OutputLengthException("Output buffer is too short");
    }
    return 0;
  }
  
  private void reset(boolean paramBoolean)
  {
    this.cipher.reset();
    this.mac.reset();
    this.bufOff = 0;
    Arrays.fill(this.bufBlock, (byte)0);
    if (paramBoolean) {
      Arrays.fill(this.macBlock, (byte)0);
    }
    int i = this.blockSize;
    byte[] arrayOfByte = new byte[i];
    arrayOfByte[(i - 1)] = 1;
    this.mac.update(arrayOfByte, 0, i);
    this.cipherInitialized = false;
    arrayOfByte = this.initialAssociatedText;
    if (arrayOfByte != null) {
      processAADBytes(arrayOfByte, 0, arrayOfByte.length);
    }
  }
  
  private boolean verifyMac(byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool = false;
    int i = 0;
    int j = 0;
    while (i < this.macSize)
    {
      j |= this.macBlock[i] ^ paramArrayOfByte[(paramInt + i)];
      i += 1;
    }
    if (j == 0) {
      bool = true;
    }
    return bool;
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, InvalidCipherTextException
  {
    initCipher();
    int i = this.bufOff;
    byte[] arrayOfByte1 = this.bufBlock;
    byte[] arrayOfByte2 = new byte[arrayOfByte1.length];
    this.bufOff = 0;
    if (this.forEncryption)
    {
      j = paramArrayOfByte.length;
      int k = paramInt + i;
      if (j >= this.macSize + k)
      {
        this.cipher.processBlock(arrayOfByte1, 0, arrayOfByte2, 0);
        System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, paramInt, i);
        this.mac.update(arrayOfByte2, 0, i);
        calculateMac();
        System.arraycopy(this.macBlock, 0, paramArrayOfByte, k, this.macSize);
        reset(false);
        return i + this.macSize;
      }
      throw new OutputLengthException("Output buffer too short");
    }
    int j = this.macSize;
    if (i >= j)
    {
      if (paramArrayOfByte.length >= paramInt + i - j)
      {
        if (i > j)
        {
          this.mac.update(arrayOfByte1, 0, i - j);
          this.cipher.processBlock(this.bufBlock, 0, arrayOfByte2, 0);
          System.arraycopy(arrayOfByte2, 0, paramArrayOfByte, paramInt, i - this.macSize);
        }
        calculateMac();
        if (verifyMac(this.bufBlock, i - this.macSize))
        {
          reset(false);
          return i - this.macSize;
        }
        throw new InvalidCipherTextException("mac check in EAX failed");
      }
      throw new OutputLengthException("Output buffer too short");
    }
    throw new InvalidCipherTextException("data too short");
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cipher.getUnderlyingCipher().getAlgorithmName());
    localStringBuilder.append("/EAX");
    return localStringBuilder.toString();
  }
  
  public int getBlockSize()
  {
    return this.cipher.getBlockSize();
  }
  
  public byte[] getMac()
  {
    int i = this.macSize;
    byte[] arrayOfByte = new byte[i];
    System.arraycopy(this.macBlock, 0, arrayOfByte, 0, i);
    return arrayOfByte;
  }
  
  public int getOutputSize(int paramInt)
  {
    paramInt += this.bufOff;
    if (this.forEncryption) {
      return paramInt + this.macSize;
    }
    int i = this.macSize;
    if (paramInt < i) {
      return 0;
    }
    return paramInt - i;
  }
  
  public BlockCipher getUnderlyingCipher()
  {
    return this.cipher.getUnderlyingCipher();
  }
  
  public int getUpdateOutputSize(int paramInt)
  {
    int i = paramInt + this.bufOff;
    paramInt = i;
    if (!this.forEncryption)
    {
      paramInt = this.macSize;
      if (i < paramInt) {
        return 0;
      }
      paramInt = i - paramInt;
    }
    return paramInt - paramInt % this.blockSize;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    this.forEncryption = paramBoolean;
    Object localObject;
    if ((paramCipherParameters instanceof AEADParameters))
    {
      localObject = (AEADParameters)paramCipherParameters;
      paramCipherParameters = ((AEADParameters)localObject).getNonce();
      this.initialAssociatedText = ((AEADParameters)localObject).getAssociatedText();
      this.macSize = (((AEADParameters)localObject).getMacSize() / 8);
      localObject = ((AEADParameters)localObject).getKey();
    }
    else
    {
      if (!(paramCipherParameters instanceof ParametersWithIV)) {
        break label227;
      }
      localObject = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject).getIV();
      this.initialAssociatedText = null;
      this.macSize = (this.mac.getMacSize() / 2);
      localObject = ((ParametersWithIV)localObject).getParameters();
    }
    if (paramBoolean) {
      i = this.blockSize;
    } else {
      i = this.blockSize + this.macSize;
    }
    this.bufBlock = new byte[i];
    byte[] arrayOfByte = new byte[this.blockSize];
    this.mac.init((CipherParameters)localObject);
    int i = this.blockSize;
    arrayOfByte[(i - 1)] = 0;
    this.mac.update(arrayOfByte, 0, i);
    this.mac.update(paramCipherParameters, 0, paramCipherParameters.length);
    this.mac.doFinal(this.nonceMac, 0);
    this.cipher.init(true, new ParametersWithIV(null, this.nonceMac));
    reset();
    return;
    label227:
    throw new IllegalArgumentException("invalid parameters passed to EAX");
  }
  
  public void processAADByte(byte paramByte)
  {
    if (!this.cipherInitialized)
    {
      this.mac.update(paramByte);
      return;
    }
    throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
  }
  
  public void processAADBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (!this.cipherInitialized)
    {
      this.mac.update(paramArrayOfByte, paramInt1, paramInt2);
      return;
    }
    throw new IllegalStateException("AAD data cannot be added after encryption/decryption processing has begun.");
  }
  
  public int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException
  {
    initCipher();
    return process(paramByte, paramArrayOfByte, paramInt);
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException
  {
    initCipher();
    if (paramArrayOfByte1.length >= paramInt1 + paramInt2)
    {
      int i = 0;
      int j = 0;
      while (i != paramInt2)
      {
        j += process(paramArrayOfByte1[(paramInt1 + i)], paramArrayOfByte2, paramInt3 + j);
        i += 1;
      }
      return j;
    }
    throw new DataLengthException("Input buffer too short");
  }
  
  public void reset()
  {
    reset(true);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\EAXBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */