package org.bouncycastle.openssl;

import org.bouncycastle.operator.OperatorCreationException;

public abstract interface PEMDecryptorProvider
{
  public abstract PEMDecryptor get(String paramString)
    throws OperatorCreationException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\openssl\PEMDecryptorProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */