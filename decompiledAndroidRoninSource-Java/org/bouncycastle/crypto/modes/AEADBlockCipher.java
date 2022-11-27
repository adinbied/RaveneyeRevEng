package org.bouncycastle.crypto.modes;

import org.bouncycastle.crypto.BlockCipher;
import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.InvalidCipherTextException;

public abstract interface AEADBlockCipher
{
  public abstract int doFinal(byte[] paramArrayOfByte, int paramInt)
    throws IllegalStateException, InvalidCipherTextException;
  
  public abstract String getAlgorithmName();
  
  public abstract byte[] getMac();
  
  public abstract int getOutputSize(int paramInt);
  
  public abstract BlockCipher getUnderlyingCipher();
  
  public abstract int getUpdateOutputSize(int paramInt);
  
  public abstract void init(boolean paramBoolean, CipherParameters paramCipherParameters)
    throws IllegalArgumentException;
  
  public abstract void processAADByte(byte paramByte);
  
  public abstract void processAADBytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2);
  
  public abstract int processByte(byte paramByte, byte[] paramArrayOfByte, int paramInt)
    throws DataLengthException;
  
  public abstract int processBytes(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, int paramInt3)
    throws DataLengthException;
  
  public abstract void reset();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\modes\AEADBlockCipher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */