package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.CipherParameters;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.crypto.MessageSigner;
import org.bouncycastle.util.Pack;

public class SPHINCS256Signer
  implements MessageSigner
{
  private final HashFunctions hashFunctions;
  private byte[] keyData;
  
  public SPHINCS256Signer(Digest paramDigest1, Digest paramDigest2)
  {
    if (paramDigest1.getDigestSize() == 32)
    {
      if (paramDigest2.getDigestSize() == 64)
      {
        this.hashFunctions = new HashFunctions(paramDigest1, paramDigest2);
        return;
      }
      throw new IllegalArgumentException("2n-digest needs to produce 64 bytes of output");
    }
    throw new IllegalArgumentException("n-digest needs to produce 32 bytes of output");
  }
  
  static void compute_authpath_wots(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, Tree.leafaddr paramleafaddr, byte[] paramArrayOfByte3, byte[] paramArrayOfByte4, int paramInt2)
  {
    Tree.leafaddr localleafaddr = new Tree.leafaddr(paramleafaddr);
    byte[] arrayOfByte1 = new byte['ࠀ'];
    byte[] arrayOfByte2 = new byte['Ѐ'];
    byte[] arrayOfByte3 = new byte[68608];
    for (localleafaddr.subleaf = 0L; localleafaddr.subleaf < 32L; localleafaddr.subleaf += 1L) {
      Seed.get_seed(paramHashFunctions, arrayOfByte2, (int)(localleafaddr.subleaf * 32L), paramArrayOfByte3, localleafaddr);
    }
    paramArrayOfByte3 = new Wots();
    for (localleafaddr.subleaf = 0L; localleafaddr.subleaf < 32L; localleafaddr.subleaf += 1L) {
      paramArrayOfByte3.wots_pkgen(paramHashFunctions, arrayOfByte3, (int)(localleafaddr.subleaf * 67L * 32L), arrayOfByte2, (int)(localleafaddr.subleaf * 32L), paramArrayOfByte4, 0);
    }
    for (localleafaddr.subleaf = 0L; localleafaddr.subleaf < 32L; localleafaddr.subleaf += 1L) {
      Tree.l_tree(paramHashFunctions, arrayOfByte1, (int)(localleafaddr.subleaf * 32L + 1024L), arrayOfByte3, (int)(localleafaddr.subleaf * 67L * 32L), paramArrayOfByte4, 0);
    }
    int i = 32;
    int j = 0;
    while (i > 0)
    {
      int k = 0;
      while (k < i)
      {
        paramHashFunctions.hash_2n_n_mask(arrayOfByte1, (i >>> 1) * 32 + (k >>> 1) * 32, arrayOfByte1, i * 32 + k * 32, paramArrayOfByte4, (j + 7) * 2 * 32);
        k += 2;
      }
      j += 1;
      i >>>= 1;
    }
    j = (int)paramleafaddr.subleaf;
    i = 0;
    while (i < paramInt2)
    {
      System.arraycopy(arrayOfByte1, (32 >>> i) * 32 + (j >>> i ^ 0x1) * 32, paramArrayOfByte2, paramInt1 + i * 32, 32);
      i += 1;
    }
    System.arraycopy(arrayOfByte1, 32, paramArrayOfByte1, 0, 32);
  }
  
  static void validate_authpath(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, int paramInt1, byte[] paramArrayOfByte3, int paramInt2, byte[] paramArrayOfByte4, int paramInt3)
  {
    byte[] arrayOfByte = new byte[64];
    if ((paramInt1 & 0x1) != 0)
    {
      i = 0;
      while (i < 32)
      {
        arrayOfByte[(i + 32)] = paramArrayOfByte2[i];
        i += 1;
      }
      i = 0;
      while (i < 32)
      {
        arrayOfByte[i] = paramArrayOfByte3[(paramInt2 + i)];
        i += 1;
      }
    }
    int i = 0;
    while (i < 32)
    {
      arrayOfByte[i] = paramArrayOfByte2[i];
      i += 1;
    }
    i = 0;
    while (i < 32)
    {
      arrayOfByte[(i + 32)] = paramArrayOfByte3[(paramInt2 + i)];
      i += 1;
    }
    paramInt2 += 32;
    int j = 0;
    i = paramInt1;
    paramInt1 = j;
    while (paramInt1 < paramInt3 - 1)
    {
      j = i >>> 1;
      if ((j & 0x1) != 0)
      {
        paramHashFunctions.hash_2n_n_mask(arrayOfByte, 32, arrayOfByte, 0, paramArrayOfByte4, (paramInt1 + 7) * 2 * 32);
        i = 0;
        while (i < 32)
        {
          arrayOfByte[i] = paramArrayOfByte3[(paramInt2 + i)];
          i += 1;
        }
      }
      paramHashFunctions.hash_2n_n_mask(arrayOfByte, 0, arrayOfByte, 0, paramArrayOfByte4, (paramInt1 + 7) * 2 * 32);
      i = 0;
      while (i < 32)
      {
        arrayOfByte[(i + 32)] = paramArrayOfByte3[(paramInt2 + i)];
        i += 1;
      }
      paramInt2 += 32;
      paramInt1 += 1;
      i = j;
    }
    paramHashFunctions.hash_2n_n_mask(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte4, (paramInt3 + 7 - 1) * 2 * 32);
  }
  
  private void zerobytes(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int i = 0;
    while (i != paramInt2)
    {
      paramArrayOfByte[(paramInt1 + i)] = 0;
      i += 1;
    }
  }
  
  byte[] crypto_sign(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    byte[] arrayOfByte2 = new byte[41000];
    byte[] arrayOfByte6 = new byte[32];
    byte[] arrayOfByte5 = new byte[64];
    Object localObject2 = new long[8];
    byte[] arrayOfByte3 = new byte[32];
    byte[] arrayOfByte4 = new byte[32];
    byte[] arrayOfByte1 = new byte['Ѐ'];
    Object localObject1 = new byte['р'];
    int i = 0;
    while (i < 1088)
    {
      localObject1[i] = paramArrayOfByte2[i];
      i += 1;
    }
    System.arraycopy(localObject1, 1056, arrayOfByte2, 40968, 32);
    paramArrayOfByte2 = paramHashFunctions.getMessageHash();
    byte[] arrayOfByte7 = new byte[paramArrayOfByte2.getDigestSize()];
    paramArrayOfByte2.update(arrayOfByte2, 40968, 32);
    paramArrayOfByte2.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    paramArrayOfByte2.doFinal(arrayOfByte7, 0);
    zerobytes(arrayOfByte2, 40968, 32);
    i = 0;
    while (i != 8)
    {
      localObject2[i] = Pack.littleEndianToLong(arrayOfByte7, i * 8);
      i += 1;
    }
    long l = localObject2[0] & 0xFFFFFFFFFFFFFFF;
    System.arraycopy(arrayOfByte7, 16, arrayOfByte6, 0, 32);
    System.arraycopy(arrayOfByte6, 0, arrayOfByte2, 39912, 32);
    paramArrayOfByte2 = new Tree.leafaddr();
    paramArrayOfByte2.level = 11;
    paramArrayOfByte2.subtree = 0L;
    paramArrayOfByte2.subleaf = 0L;
    System.arraycopy(localObject1, 32, arrayOfByte2, 39944, 1024);
    Tree.treehash(paramHashFunctions, arrayOfByte2, 40968, 5, (byte[])localObject1, paramArrayOfByte2, arrayOfByte2, 39944);
    paramArrayOfByte2 = paramHashFunctions.getMessageHash();
    paramArrayOfByte2.update(arrayOfByte2, 39912, 1088);
    paramArrayOfByte2.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
    paramArrayOfByte2.doFinal(arrayOfByte5, 0);
    localObject2 = new Tree.leafaddr();
    ((Tree.leafaddr)localObject2).level = 12;
    ((Tree.leafaddr)localObject2).subleaf = ((int)(l & 0x1F));
    ((Tree.leafaddr)localObject2).subtree = (l >>> 5);
    i = 0;
    while (i < 32)
    {
      arrayOfByte2[i] = arrayOfByte6[i];
      i += 1;
    }
    paramArrayOfByte1 = arrayOfByte1;
    System.arraycopy(localObject1, 32, paramArrayOfByte1, 0, 1024);
    i = 0;
    while (i < 8)
    {
      arrayOfByte2[(32 + i)] = ((byte)(int)(l >>> i * 8 & 0xFF));
      i += 1;
    }
    Seed.get_seed(paramHashFunctions, arrayOfByte4, 0, (byte[])localObject1, (Tree.leafaddr)localObject2);
    new Horst();
    paramArrayOfByte2 = (byte[])localObject1;
    i = Horst.horst_sign(paramHashFunctions, arrayOfByte2, 40, arrayOfByte3, arrayOfByte4, paramArrayOfByte1, arrayOfByte5);
    localObject1 = new Wots();
    int j = 40 + i;
    i = 0;
    while (i < 12)
    {
      ((Tree.leafaddr)localObject2).level = i;
      Seed.get_seed(paramHashFunctions, arrayOfByte4, 0, paramArrayOfByte2, (Tree.leafaddr)localObject2);
      ((Wots)localObject1).wots_sign(paramHashFunctions, arrayOfByte2, j, arrayOfByte3, arrayOfByte4, paramArrayOfByte1);
      j += 2144;
      compute_authpath_wots(paramHashFunctions, arrayOfByte3, arrayOfByte2, j, (Tree.leafaddr)localObject2, paramArrayOfByte2, paramArrayOfByte1, 5);
      j += 160;
      ((Tree.leafaddr)localObject2).subleaf = ((int)(((Tree.leafaddr)localObject2).subtree & 0x1F));
      ((Tree.leafaddr)localObject2).subtree >>>= 5;
      i += 1;
    }
    zerobytes(paramArrayOfByte2, 0, 1088);
    return arrayOfByte2;
  }
  
  public byte[] generateSignature(byte[] paramArrayOfByte)
  {
    return crypto_sign(this.hashFunctions, paramArrayOfByte, this.keyData);
  }
  
  public void init(boolean paramBoolean, CipherParameters paramCipherParameters)
  {
    if (paramBoolean)
    {
      this.keyData = ((SPHINCSPrivateKeyParameters)paramCipherParameters).getKeyData();
      return;
    }
    this.keyData = ((SPHINCSPublicKeyParameters)paramCipherParameters).getKeyData();
  }
  
  boolean verify(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    int i = paramArrayOfByte2.length;
    byte[] arrayOfByte3 = new byte['ࡠ'];
    byte[] arrayOfByte4 = new byte[32];
    byte[] arrayOfByte5 = new byte[32];
    byte[] arrayOfByte2 = new byte[41000];
    byte[] arrayOfByte1 = new byte['Р'];
    if (i == 41000)
    {
      byte[] arrayOfByte6 = new byte[64];
      i = 0;
      while (i < 1056)
      {
        arrayOfByte1[i] = paramArrayOfByte3[i];
        i += 1;
      }
      paramArrayOfByte3 = new byte[32];
      i = 0;
      while (i < 32)
      {
        paramArrayOfByte3[i] = paramArrayOfByte2[i];
        i += 1;
      }
      System.arraycopy(paramArrayOfByte2, 0, arrayOfByte2, 0, 41000);
      paramArrayOfByte2 = paramHashFunctions.getMessageHash();
      paramArrayOfByte2.update(paramArrayOfByte3, 0, 32);
      paramArrayOfByte2.update(arrayOfByte1, 0, 1056);
      paramArrayOfByte2.update(paramArrayOfByte1, 0, paramArrayOfByte1.length);
      paramArrayOfByte2.doFinal(arrayOfByte6, 0);
      long l = 0L;
      i = 0;
      while (i < 8)
      {
        l ^= (arrayOfByte2[(32 + i)] & 0xFF) << i * 8;
        i += 1;
      }
      new Horst();
      Horst.horst_verify(paramHashFunctions, arrayOfByte5, arrayOfByte2, 40, arrayOfByte1, arrayOfByte6);
      paramArrayOfByte3 = new Wots();
      i = 0;
      int j = 13352;
      paramArrayOfByte2 = arrayOfByte2;
      paramArrayOfByte1 = arrayOfByte1;
      while (i < 12)
      {
        paramArrayOfByte3.wots_verify(paramHashFunctions, arrayOfByte3, paramArrayOfByte2, j, arrayOfByte5, paramArrayOfByte1);
        j += 2144;
        Tree.l_tree(paramHashFunctions, arrayOfByte4, 0, arrayOfByte3, 0, paramArrayOfByte1, 0);
        validate_authpath(paramHashFunctions, arrayOfByte5, arrayOfByte4, (int)(0x1F & l), paramArrayOfByte2, j, paramArrayOfByte1, 5);
        l >>= 5;
        j += 160;
        i += 1;
      }
      boolean bool = true;
      i = 0;
      while (i < 32)
      {
        if (arrayOfByte5[i] != paramArrayOfByte1[(i + 1024)]) {
          bool = false;
        }
        i += 1;
      }
      return bool;
    }
    throw new IllegalArgumentException("signature wrong size");
  }
  
  public boolean verifySignature(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return verify(this.hashFunctions, paramArrayOfByte1, paramArrayOfByte2, this.keyData);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\sphincs\SPHINCS256Signer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */