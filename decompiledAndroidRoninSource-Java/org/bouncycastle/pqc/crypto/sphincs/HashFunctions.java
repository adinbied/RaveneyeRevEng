package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Strings;

class HashFunctions
{
  private static final byte[] hashc = Strings.toByteArray("expand 32-byte to 64-byte state!");
  private final Digest dig256;
  private final Digest dig512;
  private final Permute perm = new Permute();
  
  HashFunctions(Digest paramDigest)
  {
    this(paramDigest, null);
  }
  
  HashFunctions(Digest paramDigest1, Digest paramDigest2)
  {
    this.dig256 = paramDigest1;
    this.dig512 = paramDigest2;
  }
  
  Digest getMessageHash()
  {
    return this.dig512;
  }
  
  int hash_2n_n(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    byte[] arrayOfByte = new byte[64];
    int i = 0;
    while (i < 32)
    {
      arrayOfByte[i] = paramArrayOfByte2[(paramInt2 + i)];
      arrayOfByte[(i + 32)] = hashc[i];
      i += 1;
    }
    this.perm.chacha_permute(arrayOfByte, arrayOfByte);
    i = 0;
    while (i < 32)
    {
      arrayOfByte[i] = ((byte)(arrayOfByte[i] ^ paramArrayOfByte2[(paramInt2 + i + 32)]));
      i += 1;
    }
    this.perm.chacha_permute(arrayOfByte, arrayOfByte);
    paramInt2 = 0;
    while (paramInt2 < 32)
    {
      paramArrayOfByte1[(paramInt1 + paramInt2)] = arrayOfByte[paramInt2];
      paramInt2 += 1;
    }
    return 0;
  }
  
  int hash_2n_n_mask(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, int paramInt3)
  {
    byte[] arrayOfByte = new byte[64];
    int i = 0;
    while (i < 64)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte2[(paramInt2 + i)] ^ paramArrayOfByte3[(paramInt3 + i)]));
      i += 1;
    }
    return hash_2n_n(paramArrayOfByte1, paramInt1, arrayOfByte, 0);
  }
  
  int hash_n_n(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    byte[] arrayOfByte = new byte[64];
    int i = 0;
    while (i < 32)
    {
      arrayOfByte[i] = paramArrayOfByte2[(paramInt2 + i)];
      arrayOfByte[(i + 32)] = hashc[i];
      i += 1;
    }
    this.perm.chacha_permute(arrayOfByte, arrayOfByte);
    paramInt2 = 0;
    while (paramInt2 < 32)
    {
      paramArrayOfByte1[(paramInt1 + paramInt2)] = arrayOfByte[paramInt2];
      paramInt2 += 1;
    }
    return 0;
  }
  
  int hash_n_n_mask(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, int paramInt3)
  {
    byte[] arrayOfByte = new byte[32];
    int i = 0;
    while (i < 32)
    {
      arrayOfByte[i] = ((byte)(paramArrayOfByte2[(paramInt2 + i)] ^ paramArrayOfByte3[(paramInt3 + i)]));
      i += 1;
    }
    return hash_n_n(paramArrayOfByte1, paramInt1, arrayOfByte, 0);
  }
  
  int varlen_hash(byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2)
  {
    this.dig256.update(paramArrayOfByte2, 0, paramInt2);
    this.dig256.doFinal(paramArrayOfByte1, paramInt1);
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\sphincs\HashFunctions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */