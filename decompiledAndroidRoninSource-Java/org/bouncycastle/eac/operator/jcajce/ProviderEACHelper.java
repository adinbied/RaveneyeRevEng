package org.bouncycastle.eac.operator.jcajce;

import java.security.NoSuchAlgorithmException;
import java.security.Provider;
import java.security.Signature;

class ProviderEACHelper
  extends EACHelper
{
  private final Provider provider;
  
  ProviderEACHelper(Provider paramProvider)
  {
    this.provider = paramProvider;
  }
  
  protected Signature createSignature(String paramString)
    throws NoSuchAlgorithmException
  {
    return Signature.getInstance(paramString, this.provider);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\operator\jcajce\ProviderEACHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */