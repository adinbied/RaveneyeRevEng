package org.bouncycastle.crypto.prng;

import org.bouncycastle.crypto.prng.drbg.SP80090DRBG;

abstract interface DRBGProvider
{
  public abstract SP80090DRBG get(EntropySource paramEntropySource);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\crypto\prng\DRBGProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */