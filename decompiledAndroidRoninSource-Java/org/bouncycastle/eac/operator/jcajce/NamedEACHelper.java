package org.bouncycastle.eac.operator.jcajce;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Signature;

class NamedEACHelper
  extends EACHelper
{
  private final String providerName;
  
  NamedEACHelper(String paramString)
  {
    this.providerName = paramString;
  }
  
  protected Signature createSignature(String paramString)
    throws NoSuchProviderException, NoSuchAlgorithmException
  {
    return Signature.getInstance(paramString, this.providerName);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\operator\jcajce\NamedEACHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */