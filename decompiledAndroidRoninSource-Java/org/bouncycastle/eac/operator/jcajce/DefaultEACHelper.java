package org.bouncycastle.eac.operator.jcajce;

import java.security.NoSuchAlgorithmException;
import java.security.Signature;

class DefaultEACHelper
  extends EACHelper
{
  protected Signature createSignature(String paramString)
    throws NoSuchAlgorithmException
  {
    return Signature.getInstance(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\operator\jcajce\DefaultEACHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */