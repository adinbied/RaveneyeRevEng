package org.bouncycastle.eac.jcajce;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

class NamedEACHelper
  implements EACHelper
{
  private final String providerName;
  
  NamedEACHelper(String paramString)
  {
    this.providerName = paramString;
  }
  
  public KeyFactory createKeyFactory(String paramString)
    throws NoSuchProviderException, NoSuchAlgorithmException
  {
    return KeyFactory.getInstance(paramString, this.providerName);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\jcajce\NamedEACHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */