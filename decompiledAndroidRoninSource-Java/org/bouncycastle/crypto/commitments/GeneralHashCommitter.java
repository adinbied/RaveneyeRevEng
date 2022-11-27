package org.bouncycastle.crypto.commitments;

import java.security.SecureRandom;
import org.bouncycastle.crypto.Commitment;
import org.bouncycastle.crypto.Committer;
import org.bouncycastle.crypto.DataLengthException;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.ExtendedDigest;
import org.bouncycastle.util.Arrays;

public class GeneralHashCommitter
  implements Committer
{
  private final int byteLength;
  private final Digest digest;
  private final SecureRandom random;
  
  public GeneralHashCommitter(ExtendedDigest paramExtendedDigest, SecureRandom paramSecureRandom)
  {
    this.digest = paramExtendedDigest;
    this.byteLength = paramExtendedDigest.getByteLength();
    this.random = paramSecureRandom;
  }
  
  private byte[] calculateCommitment(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte = new byte[this.digest.getDigestSize()];
    this.digest.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    this.digest.update(paramArrayOfByte2, 0, paramArrayOfByte2.length);
    this.digest.update((byte)(paramArrayOfByte2.length >>> 8));
    this.digest.update((byte)paramArrayOfByte2.length);
    this.digest.doFinal(arrayOfByte, 0);
    return arrayOfByte;
  }
  
  public Commitment commit(byte[] paramArrayOfByte)
  {
    int i = paramArrayOfByte.length;
    int j = this.byteLength;
    if (i <= j / 2)
    {
      byte[] arrayOfByte = new byte[j - paramArrayOfByte.length];
      this.random.nextBytes(arrayOfByte);
      return new Commitment(arrayOfByte, calculateCommitment(arrayOfByte, paramArrayOfByte));
    }
    throw new DataLengthException("Message to be committed to too large for digest.");
  }
  
  public boolean isRevealed(Commitment paramCommitment, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length + paramCommitment.getSecret().length == this.byteLength)
    {
      paramArrayOfByte = calculateCommitment(paramCommitment.getSecret(), paramArrayOfByte);
      return Arrays.constantTimeAreEqual(paramCommitment.getCommitment(), paramArrayOfByte);
    }
    throw new DataLengthException("Message and witness secret lengths do not match.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\commitments\GeneralHashCommitter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */