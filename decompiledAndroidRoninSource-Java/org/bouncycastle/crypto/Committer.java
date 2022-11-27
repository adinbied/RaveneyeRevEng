package org.bouncycastle.crypto;

public abstract interface Committer
{
  public abstract Commitment commit(byte[] paramArrayOfByte);
  
  public abstract boolean isRevealed(Commitment paramCommitment, byte[] paramArrayOfByte);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\Committer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */