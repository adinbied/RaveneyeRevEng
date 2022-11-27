package org.bouncycastle.eac.jcajce;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;

abstract interface EACHelper
{
  public abstract KeyFactory createKeyFactory(String paramString)
    throws NoSuchProviderException, NoSuchAlgorithmException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\eac\jcajce\EACHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */