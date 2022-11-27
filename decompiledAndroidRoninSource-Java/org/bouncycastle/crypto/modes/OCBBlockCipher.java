package org.bouncycastle.crypto.modes;

import java.util.Vector;
import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.AEADParameters;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Arrays;

public class OCBBlockCipher
  implements AEADBlockCipher
{
  private static final int BLOCK_SIZE = 16;
  private byte[] Checksum;
  private byte[] KtopInput = null;
  private Vector L;
  private byte[] L_Asterisk;
  private byte[] L_Dollar;
  private byte[] OffsetHASH;
  private byte[] OffsetMAIN = new byte[16];
  private byte[] OffsetMAIN_0 = new byte[16];
  private byte[] Stretch = new byte[24];
  private byte[] Sum;
  private boolean forEncryption;
  private byte[] hashBlock;
  private long hashBlockCount;
  private int hashBlockPos;
  private BlockCipher hashCipher;
  private byte[] initialAssociatedText;
  private byte[] macBlock;
  private int macSize;
  private byte[] mainBlock;
  private long mainBlockCount;
  private int mainBlockPos;
  private BlockCipher mainCipher;
  
  public OCBBlockCipher(BlockCipher paramBlockCipher1, BlockCipher paramBlockCipher2)
  {
    if (paramBlockCipher1 != null)
    {
      if (paramBlockCipher1.getBlockSize() == 16)
      {
        if (paramBlockCipher2 != null)
        {
          if (paramBlockCipher2.getBlockSize() == 16)
          {
            if (paramBlockCipher1.getAlgorithmName().equals(paramBlockCipher2.getAlgorithmName()))
            {
              this.hashCipher = paramBlockCipher1;
              this.mainCipher = paramBlockCipher2;
              return;
            }
            throw new IllegalArgumentException("'hashCipher' and 'mainCipher' must be the same algorithm");
          }
          throw new IllegalArgumentException("'mainCipher' must have a block size of 16");
        }
        throw new IllegalArgumentException("'mainCipher' cannot be null");
      }
      throw new IllegalArgumentException("'hashCipher' must have a block size of 16");
    }
    throw new IllegalArgumentException("'hashCipher' cannot be null");
  }
  
  protected static byte[] OCB_double(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[16];
    arrayOfByte[15] = ((byte)(135 >>> (1 - shiftLeft(paramArrayOfByte, arrayOfByte) << 3) ^ arrayOfByte[15]));
    return arrayOfByte;
  }
  
  protected static void OCB_extend(byte[] paramArrayOfByte, int paramInt)
  {
    paramArrayOfByte[paramInt] = Byte.MIN_VALUE;
    for (;;)
    {
      paramInt += 1;
      if (paramInt >= 16) {
        break;
      }
      paramArrayOfByte[paramInt] = 0;
    }
  }
  
  protected static int OCB_ntz(long paramLong)
  {
    if (paramLong == 0L) {
      return 64;
    }
    int i = 0;
    while ((1L & paramLong) == 0L)
    {
      i += 1;
      paramLong >>>= 1;
    }
    return i;
  }
  
  protected static int shiftLeft(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int j = 16;
    int k;
    for (int i = 0;; i = k >>> 7 & 0x1)
    {
      j -= 1;
      if (j < 0) {
        break;
      }
      k = paramArrayOfByte1[j] & 0xFF;
      paramArrayOfByte2[j] = ((byte)(i | k << 1));
    }
    return i;
  }
  
  protected static void xor(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    int i = 15;
    while (i >= 0)
    {
      paramArrayOfByte1[i] = ((byte)(paramArrayOfByte1[i] ^ paramArrayOfByte2[i]));
      i -= 1;
    }
  }
  
  protected void clear(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      Arrays.fill(paramArrayOfByte, (byte)0);
    }
  }
  
  public int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, InvalidCipherTextException
  {
    int j;
    byte[] arrayOfByte1;
    if (!this.forEncryption)
    {
      j = this.mainBlockPos;
      i = this.macSize;
      if (j >= i)
      {
        j -= i;
        this.mainBlockPos = j;
        arrayOfByte1 = new byte[i];
        System.arraycopy(this.mainBlock, j, arrayOfByte1, 0, i);
      }
      else
      {
        throw new InvalidCipherTextException("data too short");
      }
    }
    else
    {
      arrayOfByte1 = null;
    }
    int i = this.hashBlockPos;
    if (i > 0)
    {
      OCB_extend(this.hashBlock, i);
      updateHASH(this.L_Asterisk);
    }
    i = this.mainBlockPos;
    if (i > 0)
    {
      if (this.forEncryption)
      {
        OCB_extend(this.mainBlock, i);
        xor(this.Checksum, this.mainBlock);
      }
      xor(this.OffsetMAIN, this.L_Asterisk);
      localObject = new byte[16];
      this.hashCipher.processBlock(this.OffsetMAIN, 0, (byte[])localObject, 0);
      xor(this.mainBlock, (byte[])localObject);
      i = paramArrayOfByte.length;
      j = this.mainBlockPos;
      if (i >= paramInt + j)
      {
        System.arraycopy(this.mainBlock, 0, paramArrayOfByte, paramInt, j);
        if (!this.forEncryption)
        {
          OCB_extend(this.mainBlock, this.mainBlockPos);
          xor(this.Checksum, this.mainBlock);
        }
      }
      else
      {
        throw new OutputLengthException("Output buffer too short");
      }
    }
    xor(this.Checksum, this.OffsetMAIN);
    xor(this.Checksum, this.L_Dollar);
    Object localObject = this.hashCipher;
    byte[] arrayOfByte2 = this.Checksum;
    ((BlockCipher)localObject).processBlock(arrayOfByte2, 0, arrayOfByte2, 0);
    xor(this.Checksum, this.Sum);
    i = this.macSize;
    localObject = new byte[i];
    this.macBlock = ((byte[])localObject);
    System.arraycopy(this.Checksum, 0, localObject, 0, i);
    i = this.mainBlockPos;
    if (this.forEncryption)
    {
      j = paramArrayOfByte.length;
      paramInt += i;
      int k = this.macSize;
      if (j >= paramInt + k)
      {
        System.arraycopy(this.macBlock, 0, paramArrayOfByte, paramInt, k);
        paramInt = i + this.macSize;
      }
      else
      {
        throw new OutputLengthException("Output buffer too short");
      }
    }
    else
    {
      if (!Arrays.constantTimeAreEqual(this.macBlock, arrayOfByte1)) {
        break label420;
      }
      paramInt = i;
    }
    reset(false);
    return paramInt;
    label420:
    throw new InvalidCipherTextException("mac check in OCB failed");
  }
  
  public String getAlgorithmName()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mainCipher.getAlgorithmName());
    localStringBuilder.append("/OCB");
    return localStringBuilder.toString();
  }
  
  protected byte[] getLSub(int paramInt)
  {
    while (paramInt >= this.L.size())
    {
      Vector localVector = this.L;
      localVector.addElement(OCB_double((byte[])localVector.lastElement()));
    }
    return (byte[])this.L.elementAt(paramInt);
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
    paramInt += this.mainBlockPos;
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
    return this.mainCipher;
  }
  
  public int getUpdateOutputSize(int paramInt)
  {
    int i = paramInt + this.mainBlockPos;
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
    boolean bool = this.forEncryption;
    this.forEncryption = paramBoolean;
    this.macBlock = null;
    Object localObject1;
    int i;
    if ((paramCipherParameters instanceof AEADParameters))
    {
      localObject1 = (AEADParameters)paramCipherParameters;
      paramCipherParameters = ((AEADParameters)localObject1).getNonce();
      this.initialAssociatedText = ((AEADParameters)localObject1).getAssociatedText();
      i = ((AEADParameters)localObject1).getMacSize();
      if ((i >= 64) && (i <= 128) && (i % 8 == 0))
      {
        this.macSize = (i / 8);
        localObject1 = ((AEADParameters)localObject1).getKey();
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
        break label525;
      }
      localObject1 = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject1).getIV();
      this.initialAssociatedText = null;
      this.macSize = 16;
      localObject1 = (KeyParameter)((ParametersWithIV)localObject1).getParameters();
    }
    this.hashBlock = new byte[16];
    if (paramBoolean) {
      i = 16;
    } else {
      i = this.macSize + 16;
    }
    this.mainBlock = new byte[i];
    Object localObject2 = paramCipherParameters;
    if (paramCipherParameters == null) {
      localObject2 = new byte[0];
    }
    if (localObject2.length <= 15)
    {
      if (localObject1 != null)
      {
        this.hashCipher.init(true, (CipherParameters)localObject1);
        this.mainCipher.init(paramBoolean, (CipherParameters)localObject1);
        this.KtopInput = null;
      }
      else
      {
        if (bool != paramBoolean) {
          break label503;
        }
      }
      paramCipherParameters = new byte[16];
      this.L_Asterisk = paramCipherParameters;
      this.hashCipher.processBlock(paramCipherParameters, 0, paramCipherParameters, 0);
      this.L_Dollar = OCB_double(this.L_Asterisk);
      paramCipherParameters = new Vector();
      this.L = paramCipherParameters;
      paramCipherParameters.addElement(OCB_double(this.L_Dollar));
      i = processNonce((byte[])localObject2);
      int k = i % 8;
      int j = i / 8;
      if (k == 0)
      {
        System.arraycopy(this.Stretch, j, this.OffsetMAIN_0, 0, 16);
      }
      else
      {
        i = 0;
        while (i < 16)
        {
          paramCipherParameters = this.Stretch;
          int m = paramCipherParameters[j];
          j += 1;
          int n = paramCipherParameters[j];
          this.OffsetMAIN_0[i] = ((byte)((n & 0xFF) >>> 8 - k | (m & 0xFF) << k));
          i += 1;
        }
      }
      this.hashBlockPos = 0;
      this.mainBlockPos = 0;
      this.hashBlockCount = 0L;
      this.mainBlockCount = 0L;
      this.OffsetHASH = new byte[16];
      this.Sum = new byte[16];
      System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
      this.Checksum = new byte[16];
      paramCipherParameters = this.initialAssociatedText;
      if (paramCipherParameters != null) {
        processAADBytes(paramCipherParameters, 0, paramCipherParameters.length);
      }
      return;
      label503:
      throw new IllegalArgumentException("cannot change encrypting state without providing key.");
    }
    throw new IllegalArgumentException("IV must be no more than 15 bytes");
    label525:
    throw new IllegalArgumentException("invalid parameters passed to OCB");
  }
  
  public void processAADByte(byte paramByte)
  {
    byte[] arrayOfByte = this.hashBlock;
    int i = this.hashBlockPos;
    arrayOfByte[i] = paramByte;
    i += 1;
    this.hashBlockPos = i;
    if (i == arrayOfByte.length) {
      processHashBlock();
    }
  }
  
  public void processAADBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i < paramInt2)
    {
      byte[] arrayOfByte = this.hashBlock;
      int j = this.hashBlockPos;
      arrayOfByte[j] = paramArrayOfByte[(paramInt1 + i)];
      j += 1;
      this.hashBlockPos = j;
      if (j == arrayOfByte.length) {
        processHashBlock();
      }
      i += 1;
    }
  }
  
  public int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException
  {
    byte[] arrayOfByte = this.mainBlock;
    int i = this.mainBlockPos;
    arrayOfByte[i] = paramByte;
    i += 1;
    this.mainBlockPos = i;
    if (i == arrayOfByte.length)
    {
      processMainBlock(paramArrayOfByte, paramInt);
      return 16;
    }
    return 0;
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException
  {
    if (paramArrayOfByte1.length >= paramInt1 + paramInt2)
    {
      int i = 0;
      int k;
      for (int j = 0; i < paramInt2; j = k)
      {
        byte[] arrayOfByte = this.mainBlock;
        k = this.mainBlockPos;
        arrayOfByte[k] = paramArrayOfByte1[(paramInt1 + i)];
        int m = k + 1;
        this.mainBlockPos = m;
        k = j;
        if (m == arrayOfByte.length)
        {
          processMainBlock(paramArrayOfByte2, paramInt3 + j);
          k = j + 16;
        }
        i += 1;
      }
      return j;
    }
    throw new DataLengthException("Input buffer too short");
  }
  
  protected void processHashBlock()
  {
    long l = this.hashBlockCount + 1L;
    this.hashBlockCount = l;
    updateHASH(getLSub(OCB_ntz(l)));
    this.hashBlockPos = 0;
  }
  
  protected void processMainBlock(byte[] paramArrayOfByte, int paramInt)
  {
    if (paramArrayOfByte.length >= paramInt + 16)
    {
      if (this.forEncryption)
      {
        xor(this.Checksum, this.mainBlock);
        this.mainBlockPos = 0;
      }
      Object localObject = this.OffsetMAIN;
      long l = this.mainBlockCount + 1L;
      this.mainBlockCount = l;
      xor((byte[])localObject, getLSub(OCB_ntz(l)));
      xor(this.mainBlock, this.OffsetMAIN);
      localObject = this.mainCipher;
      byte[] arrayOfByte = this.mainBlock;
      ((BlockCipher)localObject).processBlock(arrayOfByte, 0, arrayOfByte, 0);
      xor(this.mainBlock, this.OffsetMAIN);
      System.arraycopy(this.mainBlock, 0, paramArrayOfByte, paramInt, 16);
      if (!this.forEncryption)
      {
        xor(this.Checksum, this.mainBlock);
        paramArrayOfByte = this.mainBlock;
        System.arraycopy(paramArrayOfByte, 16, paramArrayOfByte, 0, this.macSize);
        this.mainBlockPos = this.macSize;
      }
      return;
    }
    throw new OutputLengthException("Output buffer too short");
  }
  
  protected int processNonce(byte[] paramArrayOfByte)
  {
    byte[] arrayOfByte = new byte[16];
    int j = paramArrayOfByte.length;
    int k = paramArrayOfByte.length;
    int i = 0;
    System.arraycopy(paramArrayOfByte, 0, arrayOfByte, 16 - j, k);
    arrayOfByte[0] = ((byte)(this.macSize << 4));
    j = 15 - paramArrayOfByte.length;
    arrayOfByte[j] = ((byte)(arrayOfByte[j] | 0x1));
    k = arrayOfByte[15];
    arrayOfByte[15] = ((byte)(arrayOfByte[15] & 0xC0));
    paramArrayOfByte = this.KtopInput;
    if ((paramArrayOfByte == null) || (!Arrays.areEqual(arrayOfByte, paramArrayOfByte)))
    {
      paramArrayOfByte = new byte[16];
      this.KtopInput = arrayOfByte;
      this.hashCipher.processBlock(arrayOfByte, 0, paramArrayOfByte, 0);
      System.arraycopy(paramArrayOfByte, 0, this.Stretch, 0, 16);
      while (i < 8)
      {
        arrayOfByte = this.Stretch;
        int m = paramArrayOfByte[i];
        j = i + 1;
        arrayOfByte[(i + 16)] = ((byte)(m ^ paramArrayOfByte[j]));
        i = j;
      }
    }
    return k & 0x3F;
  }
  
  public void reset()
  {
    reset(true);
  }
  
  protected void reset(boolean paramBoolean)
  {
    this.hashCipher.reset();
    this.mainCipher.reset();
    clear(this.hashBlock);
    clear(this.mainBlock);
    this.hashBlockPos = 0;
    this.mainBlockPos = 0;
    this.hashBlockCount = 0L;
    this.mainBlockCount = 0L;
    clear(this.OffsetHASH);
    clear(this.Sum);
    System.arraycopy(this.OffsetMAIN_0, 0, this.OffsetMAIN, 0, 16);
    clear(this.Checksum);
    if (paramBoolean) {
      this.macBlock = null;
    }
    byte[] arrayOfByte = this.initialAssociatedText;
    if (arrayOfByte != null) {
      processAADBytes(arrayOfByte, 0, arrayOfByte.length);
    }
  }
  
  protected void updateHASH(byte[] paramArrayOfByte)
  {
    xor(this.OffsetHASH, paramArrayOfByte);
    xor(this.hashBlock, this.OffsetHASH);
    paramArrayOfByte = this.hashCipher;
    byte[] arrayOfByte = this.hashBlock;
    paramArrayOfByte.processBlock(arrayOfByte, 0, arrayOfByte, 0);
    xor(this.Sum, this.hashBlock);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\OCBBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */