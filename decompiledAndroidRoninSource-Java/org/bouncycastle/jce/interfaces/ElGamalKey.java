package org.bouncycastle.jce.interfaces;

import javax.crypto.interfaces.DHKey;
import org.bouncycastle.jce.spec.ElGamalParameterSpec;

public abstract interface ElGamalKey
  extends DHKey
{
  public abstract ElGamalParameterSpec getParameters();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\interfaces\ElGamalKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */