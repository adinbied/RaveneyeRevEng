package org.bouncycastle.pqc.jcajce.interfaces;

import java.security.PrivateKey;

public abstract interface NHPrivateKey
  extends NHKey, PrivateKey
{
  public abstract short[] getSecretData();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pqc\jcajce\interfaces\NHPrivateKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */