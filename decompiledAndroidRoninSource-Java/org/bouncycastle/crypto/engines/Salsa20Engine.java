package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.MaxBytesExceededException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.SkippingStreamCipher;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;
import org.bouncycastle.util.Strings;

public class Salsa20Engine
  implements SkippingStreamCipher
{
  public static final int DEFAULT_ROUNDS = 20;
  private static final int STATE_SIZE = 16;
  private static final int[] TAU_SIGMA = Pack.littleEndianToInt(Strings.toByteArray("expand 16-byte kexpand 32-byte k"), 0, 8);
  protected static final byte[] sigma = Strings.toByteArray("expand 32-byte k");
  protected static final byte[] tau = Strings.toByteArray("expand 16-byte k");
  private int cW0;
  private int cW1;
  private int cW2;
  protected int[] engineState = new int[16];
  private int index = 0;
  private boolean initialised = false;
  private byte[] keyStream = new byte[64];
  protected int rounds;
  protected int[] x = new int[16];
  
  public Salsa20Engine()
  {
    this(20);
  }
  
  public Salsa20Engine(int paramInt)
  {
    if ((paramInt > 0) && ((paramInt & 0x1) == 0))
    {
      this.rounds = paramInt;
      return;
    }
    throw new IllegalArgumentException("'rounds' must be a positive, even number");
  }
  
  private boolean limitExceeded()
  {
    int i = this.cW0 + 1;
    this.cW0 = i;
    if (i == 0)
    {
      i = this.cW1 + 1;
      this.cW1 = i;
      if (i == 0)
      {
        i = this.cW2 + 1;
        this.cW2 = i;
        return (i & 0x20) != 0;
      }
    }
    return false;
  }
  
  private boolean limitExceeded(int paramInt)
  {
    int i = this.cW0 + paramInt;
    this.cW0 = i;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (i < paramInt)
    {
      bool1 = bool2;
      if (i >= 0)
      {
        paramInt = this.cW1 + 1;
        this.cW1 = paramInt;
        bool1 = bool2;
        if (paramInt == 0)
        {
          paramInt = this.cW2 + 1;
          this.cW2 = paramInt;
          bool1 = bool2;
          if ((paramInt & 0x20) != 0) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  private void resetLimitCounter()
  {
    this.cW0 = 0;
    this.cW1 = 0;
    this.cW2 = 0;
  }
  
  protected static int rotl(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> -paramInt2 | paramInt1 << paramInt2;
  }
  
  public static void salsaCore(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
  {
    if (paramArrayOfInt1.length == 16)
    {
      if (paramArrayOfInt2.length == 16)
      {
        if (paramInt % 2 == 0)
        {
          int i11 = paramArrayOfInt1[0];
          int i8 = paramArrayOfInt1[1];
          int i5 = paramArrayOfInt1[2];
          int i2 = paramArrayOfInt1[3];
          int m = paramArrayOfInt1[4];
          int i4 = paramArrayOfInt1[5];
          int i1 = paramArrayOfInt1[6];
          int k = paramArrayOfInt1[7];
          int i10 = paramArrayOfInt1[8];
          int i7 = paramArrayOfInt1[9];
          int n = paramArrayOfInt1[10];
          int j = paramArrayOfInt1[11];
          int i9 = paramArrayOfInt1[12];
          int i6 = paramArrayOfInt1[13];
          int i3 = paramArrayOfInt1[14];
          int i = paramArrayOfInt1[15];
          int i12 = m;
          m = i2;
          i2 = i5;
          i5 = i8;
          i8 = i11;
          while (paramInt > 0)
          {
            i11 = rotl(i8 + i9, 7) ^ i12;
            i10 ^= rotl(i11 + i8, 9);
            i9 ^= rotl(i10 + i11, 13);
            i8 = rotl(i9 + i10, 18) ^ i8;
            i7 ^= rotl(i4 + i5, 7);
            i6 ^= rotl(i7 + i4, 9);
            i5 ^= rotl(i6 + i7, 13);
            i4 = rotl(i5 + i6, 18) ^ i4;
            i3 ^= rotl(n + i1, 7);
            i2 ^= rotl(i3 + n, 9);
            i1 ^= rotl(i2 + i3, 13);
            n ^= rotl(i1 + i2, 18);
            m ^= rotl(i + j, 7);
            k ^= rotl(m + i, 9);
            j ^= rotl(k + m, 13);
            i ^= rotl(j + k, 18);
            i5 ^= rotl(i8 + m, 7);
            i2 ^= rotl(i5 + i8, 9);
            m ^= rotl(i2 + i5, 13);
            int i13 = rotl(m + i2, 18);
            i1 ^= rotl(i4 + i11, 7);
            k ^= rotl(i1 + i4, 9);
            i12 = rotl(k + i1, 13) ^ i11;
            i4 ^= rotl(i12 + k, 18);
            j ^= rotl(n + i7, 7);
            i10 = rotl(j + n, 9) ^ i10;
            i7 ^= rotl(i10 + j, 13);
            n ^= rotl(i7 + i10, 18);
            i9 ^= rotl(i + i3, 7);
            i6 ^= rotl(i9 + i, 9);
            i3 ^= rotl(i6 + i9, 13);
            i ^= rotl(i3 + i6, 18);
            i8 ^= i13;
            paramInt -= 2;
          }
          paramArrayOfInt2[0] = (i8 + paramArrayOfInt1[0]);
          paramArrayOfInt2[1] = (i5 + paramArrayOfInt1[1]);
          paramArrayOfInt2[2] = (i2 + paramArrayOfInt1[2]);
          paramArrayOfInt2[3] = (m + paramArrayOfInt1[3]);
          paramArrayOfInt2[4] = (i12 + paramArrayOfInt1[4]);
          paramArrayOfInt2[5] = (i4 + paramArrayOfInt1[5]);
          paramArrayOfInt2[6] = (i1 + paramArrayOfInt1[6]);
          paramArrayOfInt2[7] = (k + paramArrayOfInt1[7]);
          paramArrayOfInt2[8] = (i10 + paramArrayOfInt1[8]);
          paramArrayOfInt2[9] = (i7 + paramArrayOfInt1[9]);
          paramArrayOfInt2[10] = (n + paramArrayOfInt1[10]);
          paramArrayOfInt2[11] = (j + paramArrayOfInt1[11]);
          paramArrayOfInt2[12] = (i9 + paramArrayOfInt1[12]);
          paramArrayOfInt2[13] = (i6 + paramArrayOfInt1[13]);
          paramArrayOfInt2[14] = (i3 + paramArrayOfInt1[14]);
          paramArrayOfInt2[15] = (i + paramArrayOfInt1[15]);
          return;
        }
        throw new IllegalArgumentException("Number of rounds must be even");
      }
      throw new IllegalArgumentException();
    }
    throw new IllegalArgumentException();
  }
  
  protected void advanceCounter()
  {
    int[] arrayOfInt = this.engineState;
    int i = arrayOfInt[8] + 1;
    arrayOfInt[8] = i;
    if (i == 0) {
      arrayOfInt[9] += 1;
    }
  }
  
  protected void advanceCounter(long paramLong)
  {
    int j = (int)(paramLong >>> 32);
    int i = (int)paramLong;
    if (j > 0)
    {
      arrayOfInt = this.engineState;
      arrayOfInt[9] += j;
    }
    int[] arrayOfInt = this.engineState;
    j = arrayOfInt[8];
    arrayOfInt[8] += i;
    if ((j != 0) && (arrayOfInt[8] < j)) {
      arrayOfInt[9] += 1;
    }
  }
  
  protected void generateKeyStream(byte[] paramArrayOfByte)
  {
    salsaCore(this.rounds, this.engineState, this.x);
    Pack.intToLittleEndian(this.x, paramArrayOfByte, 0);
  }
  
  public String getAlgorithmName()
  {
    int i = this.rounds;
    Object localObject = "Salsa20";
    if (i != 20)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Salsa20");
      ((StringBuilder)localObject).append("/");
      ((StringBuilder)localObject).append(this.rounds);
      localObject = ((StringBuilder)localObject).toString();
    }
    return (String)localObject;
  }
  
  protected long getCounter()
  {
    int[] arrayOfInt = this.engineState;
    return arrayOfInt[9] << 32 | arrayOfInt[8] & 0xFFFFFFFF;
  }
  
  protected int getNonceSize()
  {
    return 8;
  }
  
  public long getPosition()
  {
    return getCounter() * 64L + this.index;
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof ParametersWithIV))
    {
      Object localObject = (ParametersWithIV)paramCipherParameters;
      paramCipherParameters = ((ParametersWithIV)localObject).getIV();
      if ((paramCipherParameters != null) && (paramCipherParameters.length == getNonceSize()))
      {
        localObject = ((ParametersWithIV)localObject).getParameters();
        if (localObject == null)
        {
          if (this.initialised)
          {
            setKey(null, paramCipherParameters);
          }
          else
          {
            paramCipherParameters = new StringBuilder();
            paramCipherParameters.append(getAlgorithmName());
            paramCipherParameters.append(" KeyParameter can not be null for first initialisation");
            throw new IllegalStateException(paramCipherParameters.toString());
          }
        }
        else
        {
          if (!(localObject instanceof KeyParameter)) {
            break label120;
          }
          setKey(((KeyParameter)localObject).getKey(), paramCipherParameters);
        }
        reset();
        this.initialised = true;
        return;
        label120:
        paramCipherParameters = new StringBuilder();
        paramCipherParameters.append(getAlgorithmName());
        paramCipherParameters.append(" Init parameters must contain a KeyParameter (or null for re-init)");
        throw new IllegalArgumentException(paramCipherParameters.toString());
      }
      paramCipherParameters = new StringBuilder();
      paramCipherParameters.append(getAlgorithmName());
      paramCipherParameters.append(" requires exactly ");
      paramCipherParameters.append(getNonceSize());
      paramCipherParameters.append(" bytes of IV");
      throw new IllegalArgumentException(paramCipherParameters.toString());
    }
    paramCipherParameters = new StringBuilder();
    paramCipherParameters.append(getAlgorithmName());
    paramCipherParameters.append(" Init parameters must include an IV");
    throw new IllegalArgumentException(paramCipherParameters.toString());
  }
  
  protected void packTauOrSigma(int paramInt1, int[] paramArrayOfInt, int paramInt2)
  {
    paramInt1 = (paramInt1 - 16) / 4;
    int[] arrayOfInt = TAU_SIGMA;
    paramArrayOfInt[paramInt2] = arrayOfInt[paramInt1];
    paramArrayOfInt[(paramInt2 + 1)] = arrayOfInt[(paramInt1 + 1)];
    paramArrayOfInt[(paramInt2 + 2)] = arrayOfInt[(paramInt1 + 2)];
    paramArrayOfInt[(paramInt2 + 3)] = arrayOfInt[(paramInt1 + 3)];
  }
  
  public int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
  {
    if (this.initialised)
    {
      if (paramInt1 + paramInt2 <= paramArrayOfByte1.length)
      {
        if (paramInt3 + paramInt2 <= paramArrayOfByte2.length)
        {
          if (!limitExceeded(paramInt2))
          {
            int i = 0;
            while (i < paramInt2)
            {
              byte[] arrayOfByte = this.keyStream;
              int j = this.index;
              paramArrayOfByte2[(i + paramInt3)] = ((byte)(arrayOfByte[j] ^ paramArrayOfByte1[(i + paramInt1)]));
              j = j + 1 & 0x3F;
              this.index = j;
              if (j == 0)
              {
                advanceCounter();
                generateKeyStream(this.keyStream);
              }
              i += 1;
            }
            return paramInt2;
          }
          throw new MaxBytesExceededException("2^70 byte limit per IV would be exceeded; Change IV");
        }
        throw new OutputLengthException("output buffer too short");
      }
      throw new DataLengthException("input buffer too short");
    }
    paramArrayOfByte1 = new StringBuilder();
    paramArrayOfByte1.append(getAlgorithmName());
    paramArrayOfByte1.append(" not initialised");
    throw new IllegalStateException(paramArrayOfByte1.toString());
  }
  
  public void reset()
  {
    this.index = 0;
    resetLimitCounter();
    resetCounter();
    generateKeyStream(this.keyStream);
  }
  
  protected void resetCounter()
  {
    int[] arrayOfInt = this.engineState;
    arrayOfInt[9] = 0;
    arrayOfInt[8] = 0;
  }
  
  protected void retreatCounter()
  {
    int[] arrayOfInt = this.engineState;
    if ((arrayOfInt[8] == 0) && (arrayOfInt[9] == 0)) {
      throw new IllegalStateException("attempt to reduce counter past zero.");
    }
    arrayOfInt = this.engineState;
    int i = arrayOfInt[8] - 1;
    arrayOfInt[8] = i;
    if (i == -1) {
      arrayOfInt[9] -= 1;
    }
  }
  
  protected void retreatCounter(long paramLong)
  {
    int i = (int)(paramLong >>> 32);
    int j = (int)paramLong;
    if (i != 0)
    {
      arrayOfInt = this.engineState;
      if ((arrayOfInt[9] & 0xFFFFFFFF) >= (i & 0xFFFFFFFF)) {
        arrayOfInt[9] -= i;
      } else {
        throw new IllegalStateException("attempt to reduce counter past zero.");
      }
    }
    int[] arrayOfInt = this.engineState;
    if ((arrayOfInt[8] & 0xFFFFFFFF) >= (0xFFFFFFFF & j))
    {
      arrayOfInt[8] -= j;
      return;
    }
    if (arrayOfInt[9] != 0)
    {
      arrayOfInt[9] -= 1;
      arrayOfInt[8] -= j;
      return;
    }
    throw new IllegalStateException("attempt to reduce counter past zero.");
  }
  
  public byte returnByte(byte paramByte)
  {
    if (!limitExceeded())
    {
      byte[] arrayOfByte = this.keyStream;
      int i = this.index;
      byte b = (byte)(paramByte ^ arrayOfByte[i]);
      paramByte = i + 1 & 0x3F;
      this.index = paramByte;
      if (paramByte == 0)
      {
        advanceCounter();
        generateKeyStream(this.keyStream);
      }
      return b;
    }
    throw new MaxBytesExceededException("2^70 byte limit per IV; Change IV");
  }
  
  public long seekTo(long paramLong)
  {
    reset();
    return skip(paramLong);
  }
  
  protected void setKey(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    if (paramArrayOfByte1 != null)
    {
      if ((paramArrayOfByte1.length != 16) && (paramArrayOfByte1.length != 32))
      {
        paramArrayOfByte1 = new StringBuilder();
        paramArrayOfByte1.append(getAlgorithmName());
        paramArrayOfByte1.append(" requires 128 bit or 256 bit key");
        throw new IllegalArgumentException(paramArrayOfByte1.toString());
      }
      int i = (paramArrayOfByte1.length - 16) / 4;
      int[] arrayOfInt1 = this.engineState;
      int[] arrayOfInt2 = TAU_SIGMA;
      arrayOfInt1[0] = arrayOfInt2[i];
      arrayOfInt1[5] = arrayOfInt2[(i + 1)];
      arrayOfInt1[10] = arrayOfInt2[(i + 2)];
      arrayOfInt1[15] = arrayOfInt2[(i + 3)];
      Pack.littleEndianToInt(paramArrayOfByte1, 0, arrayOfInt1, 1, 4);
      Pack.littleEndianToInt(paramArrayOfByte1, paramArrayOfByte1.length - 16, this.engineState, 11, 4);
    }
    Pack.littleEndianToInt(paramArrayOfByte2, 0, this.engineState, 6, 2);
  }
  
  public long skip(long paramLong)
  {
    long l3 = 0L;
    long l1;
    if (paramLong >= 0L)
    {
      if (paramLong >= 64L)
      {
        l1 = paramLong / 64L;
        advanceCounter(l1);
        l1 = paramLong - l1 * 64L;
      }
      else
      {
        l1 = paramLong;
      }
      int i = this.index;
      int j = (int)l1 + i & 0x3F;
      this.index = j;
      if (j < i) {
        advanceCounter();
      }
    }
    else
    {
      long l4 = -paramLong;
      long l2 = l3;
      l1 = l4;
      if (l4 >= 64L)
      {
        l1 = l4 / 64L;
        retreatCounter(l1);
        l1 = l4 - l1 * 64L;
      }
      for (l2 = l3; l2 < l1; l2 += 1L)
      {
        if (this.index == 0) {
          retreatCounter();
        }
        this.index = (this.index - 1 & 0x3F);
      }
    }
    generateKeyStream(this.keyStream);
    return paramLong;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\Salsa20Engine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */