package org.bouncycastle.operator.bc;

import org.bouncycastle.crypto.engines.AESWrapEngine;
import org.bouncycastle.crypto.params.KeyParameter;

public class BcAESSymmetricKeyUnwrapper
  extends BcSymmetricKeyUnwrapper
{
  public BcAESSymmetricKeyUnwrapper(KeyParameter paramKeyParameter)
  {
    super(AESUtil.determineKeyEncAlg(paramKeyParameter), new AESWrapEngine(), paramKeyParameter);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\operator\bc\BcAESSymmetricKeyUnwrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */