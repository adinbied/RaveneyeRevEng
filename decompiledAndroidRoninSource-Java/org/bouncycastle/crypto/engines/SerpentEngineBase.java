package org.bouncycastle.crypto.engines;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.OutputLengthException;
import org.bouncycastle.crypto.params.KeyParameter;

public abstract class SerpentEngineBase
  implements BlockCipher
{
  protected static final int BLOCK_SIZE = 16;
  static final int PHI = -1640531527;
  static final int ROUNDS = 32;
  protected int X0;
  protected int X1;
  protected int X2;
  protected int X3;
  protected boolean encrypting;
  protected int[] wKey;
  
  protected static int rotateLeft(int paramInt1, int paramInt2)
  {
    return paramInt1 >>> -paramInt2 | paramInt1 << paramInt2;
  }
  
  protected static int rotateRight(int paramInt1, int paramInt2)
  {
    return paramInt1 << -paramInt2 | paramInt1 >>> paramInt2;
  }
  
  protected final void LT()
  {
    int i = rotateLeft(this.X0, 13);
    int j = rotateLeft(this.X2, 3);
    int k = this.X1;
    int m = this.X3;
    this.X1 = rotateLeft(k ^ i ^ j, 1);
    k = rotateLeft(m ^ j ^ i << 3, 7);
    this.X3 = k;
    this.X0 = rotateLeft(i ^ this.X1 ^ k, 5);
    this.X2 = rotateLeft(this.X3 ^ j ^ this.X1 << 7, 22);
  }
  
  protected abstract void decryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2);
  
  protected abstract void encryptBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2);
  
  public String getAlgorithmName()
  {
    return "Serpent";
  }
  
  public int getBlockSize()
  {
    return 16;
  }
  
  protected final void ib0(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1;
    int j = paramInt2 ^ paramInt1;
    paramInt2 = (i | j) ^ paramInt4;
    paramInt3 ^= paramInt2;
    int k = j ^ paramInt3;
    this.X2 = k;
    paramInt4 = j & paramInt4 ^ i;
    i = k & paramInt4 ^ paramInt2;
    this.X1 = i;
    paramInt1 = paramInt1 & paramInt2 ^ (i | paramInt3);
    this.X3 = paramInt1;
    this.X0 = (paramInt1 ^ paramInt4 ^ paramInt3);
  }
  
  protected final void ib1(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt4 ^= paramInt2;
    int i = paramInt1 ^ paramInt2 & paramInt4;
    paramInt1 = paramInt4 ^ i;
    paramInt3 ^= paramInt1;
    this.X3 = paramInt3;
    paramInt2 ^= paramInt4 & i;
    paramInt4 = i ^ (paramInt3 | paramInt2);
    this.X1 = paramInt4;
    paramInt4 = paramInt4;
    paramInt2 ^= paramInt3;
    this.X0 = (paramInt4 ^ paramInt2);
    this.X2 = ((paramInt4 | paramInt2) ^ paramInt1);
  }
  
  protected final void ib2(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt2 ^ paramInt4;
    int i = paramInt1 ^ paramInt3;
    paramInt3 ^= j;
    paramInt2 = paramInt2 & paramInt3 ^ i;
    this.X0 = paramInt2;
    paramInt1 = ((paramInt1 | j) ^ paramInt4 | i) ^ j;
    this.X3 = paramInt1;
    paramInt3 = paramInt3;
    paramInt1 |= paramInt2;
    this.X1 = (paramInt3 ^ paramInt1);
    this.X2 = (paramInt1 ^ i ^ paramInt4 & paramInt3);
  }
  
  protected final void ib3(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = paramInt2 ^ paramInt3;
    int j = paramInt1 ^ paramInt2 & k;
    int m = paramInt4 | j;
    int i = k ^ m;
    this.X0 = i;
    paramInt4 = (m | k) ^ paramInt4;
    this.X2 = (paramInt3 ^ j ^ paramInt4);
    paramInt1 = (paramInt1 | paramInt2) ^ paramInt4;
    paramInt2 = j ^ i & paramInt1;
    this.X3 = paramInt2;
    this.X1 = (paramInt2 ^ paramInt1 ^ i);
  }
  
  protected final void ib4(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 ^= (paramInt3 | paramInt4) & paramInt1;
    int i = paramInt3 ^ paramInt1 & paramInt2;
    paramInt3 = paramInt4 ^ i;
    this.X1 = paramInt3;
    paramInt1 = paramInt1;
    i = i & paramInt3 ^ paramInt2;
    this.X3 = i;
    paramInt4 ^= (paramInt3 | paramInt1);
    this.X0 = (i ^ paramInt4);
    this.X2 = (paramInt1 ^ paramInt3 ^ paramInt2 & paramInt4);
  }
  
  protected final void ib5(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt3;
    int k = paramInt2 & i ^ paramInt4;
    int j = paramInt1 & k;
    int m = paramInt2 ^ i ^ j;
    this.X3 = m;
    m |= paramInt2;
    this.X1 = (k ^ paramInt1 & m);
    paramInt4 |= paramInt1;
    this.X0 = (i ^ m ^ paramInt4);
    this.X2 = ((paramInt1 ^ paramInt3 | j) ^ paramInt2 & paramInt4);
  }
  
  protected final void ib6(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1;
    int j = paramInt1 ^ paramInt2;
    paramInt1 = paramInt3 ^ j;
    int k = (paramInt3 | i) ^ paramInt4;
    this.X1 = (paramInt1 ^ k);
    paramInt3 = j ^ paramInt1 & k;
    j = k ^ (paramInt2 | paramInt3);
    this.X3 = j;
    paramInt2 |= j;
    this.X0 = (paramInt3 ^ paramInt2);
    this.X2 = (paramInt4 & i ^ paramInt2 ^ paramInt1);
  }
  
  protected final void ib7(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1 & paramInt2 | paramInt3;
    int k = (paramInt1 | paramInt2) & paramInt4;
    int j = i ^ k;
    this.X3 = j;
    k = paramInt2 ^ k;
    paramInt2 = (j ^ paramInt4 | k) ^ paramInt1;
    this.X1 = paramInt2;
    paramInt3 = k ^ paramInt3 ^ (paramInt4 | paramInt2);
    this.X0 = paramInt3;
    this.X2 = (paramInt1 & j ^ paramInt3 ^ i ^ paramInt2);
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if ((paramCipherParameters instanceof KeyParameter))
    {
      this.encrypting = paramBoolean;
      this.wKey = makeWorkingKey(((KeyParameter)paramCipherParameters).getKey());
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("invalid parameter passed to ");
    localStringBuilder.append(getAlgorithmName());
    localStringBuilder.append(" init - ");
    localStringBuilder.append(paramCipherParameters.getClass().getName());
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
  
  protected final void inverseLT()
  {
    int i = rotateRight(this.X2, 22) ^ this.X3 ^ this.X1 << 7;
    int k = rotateRight(this.X0, 5);
    int m = this.X1;
    int j = this.X3;
    k = k ^ m ^ j;
    j = rotateRight(j, 7);
    m = rotateRight(this.X1, 1);
    this.X3 = (j ^ i ^ k << 3);
    this.X1 = (m ^ k ^ i);
    this.X2 = rotateRight(i, 3);
    this.X0 = rotateRight(k, 13);
  }
  
  protected abstract int[] makeWorkingKey(byte[] paramArrayOfByte);
  
  public final int processBlock(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    if (this.wKey != null)
    {
      if (paramInt1 + 16 <= paramArrayOfByte1.length)
      {
        if (paramInt2 + 16 <= paramArrayOfByte2.length)
        {
          if (this.encrypting) {
            encryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          } else {
            decryptBlock(paramArrayOfByte1, paramInt1, paramArrayOfByte2, paramInt2);
          }
          return 16;
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
  
  public void reset() {}
  
  protected final void sb0(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int k = paramInt1 ^ paramInt4;
    int i = paramInt3 ^ k;
    int j = paramInt2 ^ i;
    paramInt4 = paramInt4 & paramInt1 ^ j;
    this.X3 = paramInt4;
    paramInt1 ^= paramInt2 & k;
    this.X2 = ((paramInt3 | paramInt1) ^ j);
    paramInt2 = (i ^ paramInt1) & paramInt4;
    this.X1 = (i ^ paramInt2);
    this.X0 = (paramInt1 ^ paramInt2);
  }
  
  protected final void sb1(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1 ^ paramInt2;
    paramInt1 = (paramInt1 | i) ^ paramInt3;
    paramInt3 = paramInt4 ^ paramInt1;
    this.X2 = paramInt3;
    paramInt2 ^= (paramInt4 | i);
    paramInt3 ^= i;
    paramInt4 = paramInt1 & paramInt2 ^ paramInt3;
    this.X3 = paramInt4;
    paramInt2 ^= paramInt1;
    this.X1 = (paramInt4 ^ paramInt2);
    this.X0 = (paramInt1 ^ paramInt2 & paramInt3);
  }
  
  protected final void sb2(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1;
    int j = paramInt2 ^ paramInt4;
    int k = paramInt3 & i ^ j;
    this.X0 = k;
    int m = paramInt3 ^ i;
    paramInt3 = paramInt2 & (paramInt3 ^ k);
    paramInt2 = m ^ paramInt3;
    this.X3 = paramInt2;
    paramInt1 ^= (paramInt3 | paramInt4) & (k | m);
    this.X2 = paramInt1;
    this.X1 = (paramInt1 ^ (paramInt4 | i) ^ j ^ paramInt2);
  }
  
  protected final void sb3(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt1 ^ paramInt2;
    int k = paramInt1 | paramInt4;
    int i = paramInt3 ^ paramInt4;
    paramInt3 = paramInt1 & paramInt3 | j & k;
    paramInt1 = i ^ paramInt3;
    this.X2 = paramInt1;
    paramInt3 = k ^ paramInt2 ^ paramInt3;
    j ^= i & paramInt3;
    this.X0 = j;
    paramInt1 = j & paramInt1;
    this.X1 = (paramInt3 ^ paramInt1);
    this.X3 = ((paramInt2 | paramInt4) ^ i ^ paramInt1);
  }
  
  protected final void sb4(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt1 ^ paramInt4;
    paramInt3 ^= paramInt4 & i;
    paramInt4 = paramInt2 | paramInt3;
    this.X3 = (i ^ paramInt4);
    int j = paramInt2;
    paramInt2 = (i | j) ^ paramInt3;
    this.X0 = paramInt2;
    i = j ^ i;
    paramInt2 = paramInt4 & i ^ paramInt2 & paramInt1;
    this.X2 = paramInt2;
    this.X1 = (paramInt1 ^ paramInt3 ^ i & paramInt2);
  }
  
  protected final void sb5(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt1;
    int i = paramInt1 ^ paramInt2;
    paramInt1 ^= paramInt4;
    paramInt3 = paramInt3 ^ j ^ (i | paramInt1);
    this.X0 = paramInt3;
    paramInt4 &= paramInt3;
    int k = i ^ paramInt3 ^ paramInt4;
    this.X1 = k;
    paramInt1 ^= (paramInt3 | j);
    this.X2 = ((i | paramInt4) ^ paramInt1);
    this.X3 = (paramInt1 & k ^ paramInt2 ^ paramInt4);
  }
  
  protected final void sb6(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = paramInt1 ^ paramInt4;
    int i = paramInt2 ^ j;
    paramInt1 = paramInt3 ^ (paramInt1 | j);
    paramInt2 ^= paramInt1;
    this.X1 = paramInt2;
    paramInt3 = (j | paramInt2) ^ paramInt4;
    paramInt2 = paramInt1 & paramInt3 ^ i;
    this.X2 = paramInt2;
    paramInt3 ^= paramInt1;
    this.X0 = (paramInt2 ^ paramInt3);
    this.X3 = (paramInt3 & i ^ paramInt1);
  }
  
  protected final void sb7(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = paramInt2 ^ paramInt3;
    paramInt3 = paramInt3 & i ^ paramInt4;
    int j = paramInt1 ^ paramInt3;
    paramInt2 ^= (paramInt4 | i) & j;
    this.X1 = paramInt2;
    paramInt1 = paramInt1 & j ^ i;
    this.X3 = paramInt1;
    paramInt2 = (paramInt2 | paramInt3) ^ j;
    paramInt3 ^= paramInt1 & paramInt2;
    this.X2 = paramInt3;
    this.X0 = (paramInt1 & paramInt3 ^ paramInt2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\engines\SerpentEngineBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */