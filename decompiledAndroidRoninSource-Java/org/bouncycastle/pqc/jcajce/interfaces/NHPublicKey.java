package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PublicKey;

public abstract interface NHPublicKey
  extends NHKey, PublicKey
{
  public abstract byte[] getPublicData();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\interfaces\NHPublicKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */