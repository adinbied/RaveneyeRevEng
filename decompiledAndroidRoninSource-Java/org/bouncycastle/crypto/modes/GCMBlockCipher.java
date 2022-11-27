package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.modes.gcm.GCMExponentiator;
import org.bouncycastle.crypto.modes.gcm.GCMMultiplier;
import org.bouncycastle.crypto.modes.gcm.GCMUtil;
import org.bouncycastle.crypto.modes.gcm.Tables1kGCMExponentiator;
import org.bouncycastle.crypto.modes.gcm.Tables8kGCMMultiplier;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Pack;

public class GCMBlockCipher
  implements AEADBlockCipher
{
  private static final int BLOCK_SIZE = 16;
  private byte[] H;
  private byte[] J0;
  private byte[] S;
  private byte[] S_at;
  private byte[] S_atPre;
  private byte[] atBlock;
  private int atBlockPos;
  private long atLength;
  private long atLengthPre;
  private int blocksRemaining;
  private byte[] bufBlock;
  private int bufOff;
  private BlockCipher cipher;
  private byte[] counter;
  private GCMExponentiator exp;
  private boolean forEncryption;
  private byte[] initialAssociatedText;
  private boolean initialised;
  private byte[] lastKey;
  private byte[] macBlock;
  private int macSize;
  private GCMMultiplier multiplier;
  private byte[] nonce;
  private long totalLength;
  
  public GCMBlockCipher(BlockCipher paramBlockCipher)
  {
    this(paramBlockCipher, null);
  }
  
  public GCMBlockCipher(BlockCipher paramBlockCipher, GCMMultiplier paramGCMMultiplier)
  {
    if (paramBlockCipher.getBlockSize() == 16)
    {
      Object localObject = paramGCMMultiplier;
      if (paramGCMMultiplier == null) {
        localObject = new Tables8kGCMMultiplier();
      }
      this.cipher = paramBlockCipher;
      this.multiplier = ((GCMMultiplier)localObject);
      return;
    }
    throw new IllegalArgumentException("cipher required with a block size of 16.");
  }
  
  private void checkStatus()
  {
    if (!this.initialised)
    {
      if (this.forEncryption) {
        throw new IllegalStateException("GCM cipher cannot be reused for encryption");
      }
      throw new IllegalStateException("GCM cipher needs to be initialised");
    }
  }
  
  private void gCTRBlock(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    byte[] arrayOfByte = getNextCounterBlock();
    GCMUtil.xor(arrayOfByte, paramArrayOfByte1);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, paramInt, 16);
    paramArrayOfByte2 = this.S;
    if (this.forEncryption) {
      paramArrayOfByte1 = arrayOfByte;
    }
    gHASHBlock(paramArrayOfByte2, paramArrayOfByte1);
    this.totalLength += 16L;
  }
  
  private void gCTRPartial(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    byte[] arrayOfByte = getNextCounterBlock();
    GCMUtil.xor(arrayOfByte, paramArrayOfByte1, paramInt1, paramInt2);
    System.arraycopy(arrayOfByte, 0, paramArrayOfByte2, paramInt3, paramInt2);
    paramArrayOfByte2 = this.S;
    if (this.forEncryption) {
      paramArrayOfByte1 = arrayOfByte;
    }
    gHASHPartial(paramArrayOfByte2, paramArrayOfByte1, 0, paramInt2);
    this.totalLength += paramInt2;
  }
  
  private void gHASH(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      gHASHPartial(paramArrayOfByte1, paramArrayOfByte2, i, Math.min(paramInt - i, 16));
      i += 16;
    }
  }
  
  private void gHASHBlock(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    GCMUtil.xor(paramArrayOfByte1, paramArrayOfByte2);
    this.multiplier.multiplyH(paramArrayOfByte1);
  }
  
  private void gHASHPartial(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, int paramInt2)
  {
    GCMUtil.xor(paramArrayOfByte1, paramArrayOfByte2, paramInt1, paramInt2);
    this.multiplier.multiplyH(paramArrayOfByte1);
  }
  
  private byte[] getNextCounterBlock()
  {
    int i = this.blocksRemaining;
    if (i != 0)
    {
      this.blocksRemaining = (i - 1);
      byte[] arrayOfByte1 = this.counter;
      i = (arrayOfByte1[15] & 0xFF) + 1;
      arrayOfByte1[15] = ((byte)i);
      i = (i >>> 8) + (arrayOfByte1[14] & 0xFF);
      arrayOfByte1[14] = ((byte)i);
      i = (i >>> 8) + (arrayOfByte1[13] & 0xFF);
      arrayOfByte1[13] = ((byte)i);
      arrayOfByte1[12] = ((byte)((i >>> 8) + (arrayOfByte1[12] & 0xFF)));
      byte[] arrayOfByte2 = new byte[16];
      this.cipher.processBlock(arrayOfByte1, 0, arrayOfByte2, 0);
      return arrayOfByte2;
    }
    throw new IllegalStateException("Attempt to process too many blocks");
  }
  
  private void initCipher()
  {
    if (this.atLength > 0L)
    {
      System.arraycopy(this.S_at, 0, this.S_atPre, 0, 16);
      this.atLengthPre = this.atLength;
    }
    int i = this.atBlockPos;
    if (i > 0)
    {
      gHASHPartial(this.S_atPre, this.atBlock, 0, i);
      this.atLengthPre += this.atBlockPos;
    }
    if (this.atLengthPre > 0L) {
      System.arraycopy(this.S_atPre, 0, this.S, 0, 16);
    }
  }
  
  private void outputBlock(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length >= paramInt + 16)
    {
      if (this.totalLength == 0L) {
        initCipher();
      }
      gCTRBlock(this.bufBlock, paramArrayOfByte, paramInt);
      if (this.forEncryption)
      {
        this.bufOff = 0;
        return;
      }
      paramArrayOfByte = this.bufBlock;
      System.arraycopy(paramArrayOfByte, 16, paramArrayOfByte, 0, this.macSize);
      this.bufOff = this.macSize;
      return;
    }
    throw new OutputLengthException("Output buffer too short");
  }
  
  private void reset(boolean paramBoolean)
  {
    this.cipher.reset();
    this.S = new byte[16];
    this.S_at = new byte[16];
    this.S_atPre = new byte[16];
    this.atBlock = new byte[16];
    this.atBlockPos = 0;
    this.atLength = 0L;
    this.atLengthPre = 0L;
    this.counter = Arrays.clone(this.J0);
    this.blocksRemaining = -2;
    this.bufOff = 0;
    this.totalLength = 0L;
    byte[] arrayOfByte = this.bufBlock;
    if (arrayOfByte != null) {
      Arrays.fill(arrayOfByte, (byte)0);
    }
    if (paramBoolean) {
      this.macBlock = null;
    }
    if (this.forEncryption)
    {
      this.initialised = false;
      return;
    }
    arrayOfByte = this.initialAssociatedText;
    if (arrayOfByte != null) {
      processAADBytes(arrayOfByte, 0, arrayOfByte.length);
    }
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, InvalidCipherTextException
  {
    checkStatus();
    if (this.totalLength == 0L) {
      initCipher();
    }
    int i = this.bufOff;
    if (this.forEncryption)
    {
      if (paramArrayOfByte.length < paramInt + i + this.macSize) {
        throw new OutputLengthException("Output buffer too short");
      }
    }
    else
    {
      j = this.macSize;
      if (i < j) {
        break label462;
      }
      i -= j;
      if (paramArrayOfByte.length < paramInt + i) {
        break label452;
      }
    }
    if (i > 0) {
      gCTRPartial(this.bufBlock, 0, i, paramArrayOfByte, paramInt);
    }
    long l = this.atLength;
    int j = this.atBlockPos;
    l += j;
    this.atLength = l;
    if (l > this.atLengthPre)
    {
      if (j > 0) {
        gHASHPartial(this.S_at, this.atBlock, 0, j);
      }
      if (this.atLengthPre > 0L) {
        GCMUtil.xor(this.S_at, this.S_atPre);
      }
      l = this.totalLength;
      arrayOfByte = new byte[16];
      if (this.exp == null)
      {
        localObject = new Tables1kGCMExponentiator();
        this.exp = ((GCMExponentiator)localObject);
        ((GCMExponentiator)localObject).init(this.H);
      }
      this.exp.exponentiateX(l * 8L + 127L >>> 7, arrayOfByte);
      GCMUtil.multiply(this.S_at, arrayOfByte);
      GCMUtil.xor(this.S, this.S_at);
    }
    byte[] arrayOfByte = new byte[16];
    Pack.longToBigEndian(this.atLength * 8L, arrayOfByte, 0);
    Pack.longToBigEndian(this.totalLength * 8L, arrayOfByte, 8);
    gHASHBlock(this.S, arrayOfByte);
    arrayOfByte = new byte[16];
    this.cipher.processBlock(this.J0, 0, arrayOfByte, 0);
    GCMUtil.xor(arrayOfByte, this.S);
    j = this.macSize;
    Object localObject = new byte[j];
    this.macBlock = ((byte[])localObject);
    System.arraycopy(arrayOfByte, 0, localObject, 0, j);
    if (this.forEncryption)
    {
      System.arraycopy(this.macBlock, 0, paramArrayOfByte, paramInt + this.bufOff, this.macSize);
      i += this.macSize;
    }
    else
    {
      paramInt = this.macSize;
      paramArrayOfByte = new byte[paramInt];
      System.arraycopy(this.bufBlock, i, paramArrayOfByte, 0, paramInt);
      if (!Arrays.constantTimeAreEqual(this.macBlock, paramArrayOfByte)) {
        break label442;
      }
    }
    reset(false);
    return i;
    label442:
    throw new InvalidCipherTextException("mac check in GCM failed");
    label452:
    throw new OutputLengthException("Output buffer too short");
    label462:
    throw new InvalidCipherTextException("data too short");
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.cipher.getAlgorithmName());
    localStringBuilder.append("/GCM");
    return localStringBuilder.toString();
  }
  
  public byte[] getMac()
  {
    byte[] arrayOfByte = this.macBlock;
    if (arrayOfByte == null) {
      return new byte[this.macSize];
    }
    return Arrays.clone(arrayOfByte);
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
    return this.cipher;
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
    return paramInt - paramInt % 16;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException
  {
    this.forEncryption = paramBoolean;
    this.macBlock = null;
    this.initialised = true;
    Object localObject;
    int i;
    if ((paramCipherParameters instanceof AEADParameters))
    {
      localObject = (AEADParameters)paramCipherParameters;
      paramCipherParameters = ((AEADParameters)localObject).getNonce();
      this.initialAssociatedText = ((AEADParameters)localObject).getAssociatedText();
      i = ((AEADParameters)localObject).getMacSize();
      if ((i >= 32) && (i <= 128) && (i % 8 == 0))
      {
        this.macSize = (i / 8);
        localObject = ((AEADParameters)localObject).getKey();
      }
      else
      {
        paramCipherParameters = new StringBuilder();
        paramCipherParameters.append("Invalid value for MAC size: ");
        paramCipherParameters.append(i);
        throw new IllegalArgumentException(paramCipherParameters.toString());
      }
    }
    else
    {
      if (!(paramCipherParameters instanceof ParametersWithIV)) {
        break label562;
      }
      localObject = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject).getIV();
      this.initialAssociatedText = null;
      this.macSize = 16;
      localObject = (KeyParameter)((ParametersWithIV)localObject).getParameters();
    }
    if (paramBoolean) {
      i = 16;
    } else {
      i = this.macSize + 16;
    }
    this.bufBlock = new byte[i];
    if ((paramCipherParameters != null) && (paramCipherParameters.length >= 1))
    {
      if (paramBoolean)
      {
        byte[] arrayOfByte = this.nonce;
        if ((arrayOfByte != null) && (Arrays.areEqual(arrayOfByte, paramCipherParameters))) {
          if (localObject != null)
          {
            arrayOfByte = this.lastKey;
            if ((arrayOfByte != null) && (Arrays.areEqual(arrayOfByte, ((KeyParameter)localObject).getKey()))) {
              throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
            }
          }
          else
          {
            throw new IllegalArgumentException("cannot reuse nonce for GCM encryption");
          }
        }
      }
      this.nonce = paramCipherParameters;
      if (localObject != null) {
        this.lastKey = ((KeyParameter)localObject).getKey();
      }
      if (localObject != null)
      {
        this.cipher.init(true, (CipherParameters)localObject);
        paramCipherParameters = new byte[16];
        this.H = paramCipherParameters;
        this.cipher.processBlock(paramCipherParameters, 0, paramCipherParameters, 0);
        this.multiplier.init(this.H);
        this.exp = null;
      }
      else
      {
        if (this.H == null) {
          break label540;
        }
      }
      paramCipherParameters = new byte[16];
      this.J0 = paramCipherParameters;
      localObject = this.nonce;
      if (localObject.length == 12)
      {
        System.arraycopy(localObject, 0, paramCipherParameters, 0, localObject.length);
        this.J0[15] = 1;
      }
      else
      {
        gHASH(paramCipherParameters, (byte[])localObject, localObject.length);
        paramCipherParameters = new byte[16];
        Pack.longToBigEndian(this.nonce.length * 8L, paramCipherParameters, 8);
        gHASHBlock(this.J0, paramCipherParameters);
      }
      this.S = new byte[16];
      this.S_at = new byte[16];
      this.S_atPre = new byte[16];
      this.atBlock = new byte[16];
      this.atBlockPos = 0;
      this.atLength = 0L;
      this.atLengthPre = 0L;
      this.counter = Arrays.clone(this.J0);
      this.blocksRemaining = -2;
      this.bufOff = 0;
      this.totalLength = 0L;
      paramCipherParameters = this.initialAssociatedText;
      if (paramCipherParameters != null) {
        processAADBytes(paramCipherParameters, 0, paramCipherParameters.length);
      }
      return;
      label540:
      throw new IllegalArgumentException("Key must be specified in initial init");
    }
    throw new IllegalArgumentException("IV must be at least 1 byte");
    label562:
    throw new IllegalArgumentException("invalid parameters passed to GCM");
  }
  
  public void processAADByte(byte paramByte)
  {
    checkStatus();
    byte[] arrayOfByte = this.atBlock;
    int i = this.atBlockPos;
    arrayOfByte[i] = paramByte;
    i += 1;
    this.atBlockPos = i;
    if (i == 16)
    {
      gHASHBlock(this.S_at, arrayOfByte);
      this.atBlockPos = 0;
      this.atLength += 16L;
    }
  }
  
  public void processAADBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      byte[] arrayOfByte = this.atBlock;
      int j = this.atBlockPos;
      arrayOfByte[j] = paramArrayOfByte[(paramInt1 + i)];
      j += 1;
      this.atBlockPos = j;
      if (j == 16)
      {
        gHASHBlock(this.S_at, arrayOfByte);
        this.atBlockPos = 0;
        this.atLength += 16L;
      }
      i += 1;
    }
  }
  
  public int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException
  {
    checkStatus();
    byte[] arrayOfByte = this.bufBlock;
    int i = this.bufOff;
    arrayOfByte[i] = paramByte;
    i += 1;
    this.bufOff = i;
    if (i == arrayOfByte.length)
    {
      outputBlock(paramArrayOfByte, paramInt);
      return 16;
    }
    return 0;
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException
  {
    checkStatus();
    if (paramArrayOfByte1.length >= paramInt1 + paramInt2)
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramInt2; j = k)
      {
        byte[] arrayOfByte = this.bufBlock;
        k = this.bufOff;
        arrayOfByte[k] = paramArrayOfByte1[(paramInt1 + i)];
        int m = k + 1;
        this.bufOff = m;
        k = j;
        if (m == arrayOfByte.length)
        {
          outputBlock(paramArrayOfByte2, paramInt3 + j);
          k = j + 16;
        }
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\GCMBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */