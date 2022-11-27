package org.bouncycastle.pqc.crypto.sphincs;

class Tree
{
  static void gen_leaf_wots(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, leafaddr paramleafaddr)
  {
    byte[] arrayOfByte1 = new byte[32];
    byte[] arrayOfByte2 = new byte['ࡠ'];
    Wots localWots = new Wots();
    Seed.get_seed(paramHashFunctions, arrayOfByte1, 0, paramArrayOfByte3, paramleafaddr);
    localWots.wots_pkgen(paramHashFunctions, arrayOfByte2, 0, arrayOfByte1, 0, paramArrayOfByte2, paramInt2);
    l_tree(paramHashFunctions, paramArrayOfByte1, paramInt1, arrayOfByte2, 0, paramArrayOfByte2, paramInt2);
  }
  
  static void l_tree(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, int paramInt1, byte[] paramArrayOfByte2, int paramInt2, byte[] paramArrayOfByte3, int paramInt3)
  {
    int k = 67;
    int j = 0;
    while (j < 7)
    {
      int i = 0;
      int m;
      for (;;)
      {
        m = k >>> 1;
        if (i >= m) {
          break;
        }
        paramHashFunctions.hash_2n_n_mask(paramArrayOfByte2, paramInt2 + i * 32, paramArrayOfByte2, paramInt2 + i * 2 * 32, paramArrayOfByte3, paramInt3 + j * 2 * 32);
        i += 1;
      }
      i = m;
      if ((k & 0x1) != 0)
      {
        System.arraycopy(paramArrayOfByte2, paramInt2 + (k - 1) * 32, paramArrayOfByte2, m * 32 + paramInt2, 32);
        i = m + 1;
      }
      j += 1;
      k = i;
    }
    System.arraycopy(paramArrayOfByte2, paramInt2, paramArrayOfByte1, paramInt1, 32);
  }
  
  static void treehash(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, int paramInt1, int paramInt2, byte[] paramArrayOfByte2, leafaddr paramleafaddr, byte[] paramArrayOfByte3, int paramInt3)
  {
    leafaddr localleafaddr = new leafaddr(paramleafaddr);
    int i = paramInt2 + 1;
    byte[] arrayOfByte = new byte[i * 32];
    paramleafaddr = new int[i];
    paramInt2 = (int)(localleafaddr.subleaf + (1 << paramInt2));
    i = 0;
    while (localleafaddr.subleaf < paramInt2)
    {
      gen_leaf_wots(paramHashFunctions, arrayOfByte, i * 32, paramArrayOfByte3, paramInt3, paramArrayOfByte2, localleafaddr);
      paramleafaddr[i] = 0;
      i += 1;
      while (i > 1)
      {
        int k = i - 1;
        int m = paramleafaddr[k];
        int j = i - 2;
        if (m != paramleafaddr[j]) {
          break;
        }
        k = paramleafaddr[k];
        m = j * 32;
        paramHashFunctions.hash_2n_n_mask(arrayOfByte, m, arrayOfByte, m, paramArrayOfByte3, paramInt3 + (k + 7) * 2 * 32);
        paramleafaddr[j] += 1;
        i -= 1;
      }
      localleafaddr.subleaf += 1L;
    }
    paramInt2 = 0;
    while (paramInt2 < 32)
    {
      paramArrayOfByte1[(paramInt1 + paramInt2)] = arrayOfByte[paramInt2];
      paramInt2 += 1;
    }
  }
  
  static class leafaddr
  {
    int level;
    long subleaf;
    long subtree;
    
    public leafaddr() {}
    
    public leafaddr(leafaddr paramleafaddr)
    {
      this.level = paramleafaddr.level;
      this.subtree = paramleafaddr.subtree;
      this.subleaf = paramleafaddr.subleaf;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\sphincs\Tree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */