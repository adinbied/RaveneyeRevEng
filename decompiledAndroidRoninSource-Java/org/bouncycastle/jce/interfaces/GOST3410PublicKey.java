package org.bouncycastle.jce.interfaces;

import java.math.BigInteger;
import java.security.PublicKey;

public abstract interface GOST3410PublicKey
  extends GOST3410Key, PublicKey
{
  public abstract BigInteger getY();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\interfaces\GOST3410PublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */