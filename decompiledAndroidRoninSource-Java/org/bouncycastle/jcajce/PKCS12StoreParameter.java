package org.bouncycastle.jcajce;

import java.io.OutputStream;
import java.security.KeyStore.LoadStoreParameter;
import java.security.KeyStore.PasswordProtection;
import java.security.KeyStore.ProtectionParameter;

public class PKCS12StoreParameter
  implements KeyStore.LoadStoreParameter
{
  private final boolean forDEREncoding;
  private final OutputStream out;
  private final KeyStore.ProtectionParameter protectionParameter;
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, KeyStore.ProtectionParameter paramProtectionParameter)
  {
    this(paramOutputStream, paramProtectionParameter, false);
  }
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, KeyStore.ProtectionParameter paramProtectionParameter, boolean paramBoolean)
  {
    this.out = paramOutputStream;
    this.protectionParameter = paramProtectionParameter;
    this.forDEREncoding = paramBoolean;
  }
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, char[] paramArrayOfChar)
  {
    this(paramOutputStream, paramArrayOfChar, false);
  }
  
  public PKCS12StoreParameter(OutputStream paramOutputStream, char[] paramArrayOfChar, boolean paramBoolean)
  {
    this(paramOutputStream, new KeyStore.PasswordProtection(paramArrayOfChar), paramBoolean);
  }
  
  public OutputStream getOutputStream()
  {
    return this.out;
  }
  
  public KeyStore.ProtectionParameter getProtectionParameter()
  {
    return this.protectionParameter;
  }
  
  public boolean isForDEREncoding()
  {
    return this.forDEREncoding;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\PKCS12StoreParameter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */