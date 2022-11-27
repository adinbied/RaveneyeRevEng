package org.bouncycastle.pqc.crypto.sphincs;

import org.bouncycastle.crypto.StreamCipher;
import org.bouncycastle.crypto.engines.ChaChaEngine;
import org.bouncycastle.crypto.params.KeyParameter;
import org.bouncycastle.crypto.params.ParametersWithIV;
import org.bouncycastle.util.Pack;

class Seed
{
  static void get_seed(HashFunctions paramHashFunctions, byte[] paramArrayOfByte1, int paramInt, byte[] paramArrayOfByte2, Tree.leafaddr paramleafaddr)
  {
    byte[] arrayOfByte = new byte[40];
    int i = 0;
    while (i < 32)
    {
      arrayOfByte[i] = paramArrayOfByte2[i];
      i += 1;
    }
    long l1 = paramleafaddr.level;
    long l2 = paramleafaddr.subtree;
    Pack.longToLittleEndian(paramleafaddr.subleaf << 59 | l1 | l2 << 4, arrayOfByte, 32);
    paramHashFunctions.varlen_hash(paramArrayOfByte1, paramInt, arrayOfByte, 40);
  }
  
  static void prg(byte[] paramArrayOfByte1, int paramInt1, long paramLong, byte[] paramArrayOfByte2, int paramInt2)
  {
    byte[] arrayOfByte = new byte[8];
    ChaChaEngine localChaChaEngine = new ChaChaEngine(12);
    localChaChaEngine.init(true, new ParametersWithIV(new KeyParameter(paramArrayOfByte2, paramInt2, 32), arrayOfByte));
    localChaChaEngine.processBytes(paramArrayOfByte1, paramInt1, (int)paramLong, paramArrayOfByte1, paramInt1);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\crypto\sphincs\Seed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */