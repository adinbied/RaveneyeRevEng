package org.bouncycastle.jcajce.provider.config;

import java.io.OutputStream;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStore.ProtectionParameter;

public class PKCS12StoreParameter
  extends org.bouncycastle.jcajce.PKCS12StoreParameter
{
  public PKCS12StoreParameter(OutputStream paramOutputStream, KeyStore.ProtectionParameter paramProtectionParameter)
  {
    super(paramOutputStream, paramProtectionParameter, false);
  }
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, KeyStore.ProtectionParameter paramProtectionParameter, boolean paramBoolean)
  {
    super(paramOutputStream, paramProtectionParameter, paramBoolean);
  }
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, char[] paramArrayOfChar)
  {
    super(paramOutputStream, paramArrayOfChar, false);
  }
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, char[] paramArrayOfChar, boolean paramBoolean)
  {
    super(paramOutputStream, new KeyStore.PasswordProtection(paramArrayOfChar), paramBoolean);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\config\PKCS12StoreParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */