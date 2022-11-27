package org.bouncycastle.est.jcajce;

import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.est.HttpAuth;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;

public class JcaHttpAuthBuilder
{
  private final char[] password;
  private JcaDigestCalculatorProviderBuilder providerBuilder = new JcaDigestCalculatorProviderBuilder();
  private SecureRandom random = new SecureRandom();
  private final String realm;
  private final String username;
  
  public JcaHttpAuthBuilder(String paramString1, String paramString2, char[] paramArrayOfChar)
  {
    this.realm = paramString1;
    this.username = paramString2;
    this.password = paramArrayOfChar;
  }
  
  public JcaHttpAuthBuilder(String paramString, char[] paramArrayOfChar)
  {
    this(null, paramString, paramArrayOfChar);
  }
  
  public HttpAuth build()
    throws OperatorCreationException
  {
    return new HttpAuth(this.realm, this.username, this.password, this.random, this.providerBuilder.build());
  }
  
  public JcaHttpAuthBuilder setNonceGenerator(SecureRandom paramSecureRandom)
  {
    this.random = paramSecureRandom;
    return this;
  }
  
  public JcaHttpAuthBuilder setProvider(String paramString)
  {
    this.providerBuilder.setProvider(paramString);
    return this;
  }
  
  public JcaHttpAuthBuilder setProvider(Provider paramProvider)
  {
    this.providerBuilder.setProvider(paramProvider);
    return this;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\JcaHttpAuthBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */