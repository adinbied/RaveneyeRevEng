package org.bouncycastle.crypto;

public class Commitment
{
  private final byte[] commitment;
  private final byte[] secret;
  
  public Commitment(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    this.secret = paramArrayOfByte1;
    this.commitment = paramArrayOfByte2;
  }
  
  public byte[] getCommitment()
  {
    return this.commitment;
  }
  
  public byte[] getSecret()
  {
    return this.secret;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\Commitment.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */