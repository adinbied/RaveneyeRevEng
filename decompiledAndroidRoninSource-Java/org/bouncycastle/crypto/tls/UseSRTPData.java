package org.bouncycastle.crypto.tls;

public class UseSRTPData
{
  protected byte[] mki;
  protected int[] protectionProfiles;
  
  public UseSRTPData(int[] paramArrayOfInt, byte[] paramArrayOfByte)
  {
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 1) && (paramArrayOfInt.length < 32768))
    {
      if (paramArrayOfByte == null) {
        paramArrayOfByte = TlsUtils.EMPTY_BYTES;
      } else {
        if (paramArrayOfByte.length > 255) {
          break label51;
        }
      }
      this.protectionProfiles = paramArrayOfInt;
      this.mki = paramArrayOfByte;
      return;
      label51:
      throw new IllegalArgumentException("'mki' cannot be longer than 255 bytes");
    }
    throw new IllegalArgumentException("'protectionProfiles' must have length from 1 to (2^15 - 1)");
  }
  
  public byte[] getMki()
  {
    return this.mki;
  }
  
  public int[] getProtectionProfiles()
  {
    return this.protectionProfiles;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\tls\UseSRTPData.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */