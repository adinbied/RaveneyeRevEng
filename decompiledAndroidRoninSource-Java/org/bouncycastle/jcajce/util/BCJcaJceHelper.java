package org.bouncycastle.jcajce.util;

import java.security.Provider;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class BCJcaJceHelper
  extends ProviderJcaJceHelper
{
  private static volatile Provider bcProvider;
  
  public BCJcaJceHelper()
  {
    super(getBouncyCastleProvider());
  }
  
  private static Provider getBouncyCastleProvider()
  {
    if (Security.getProvider("BC") != null) {
      return Security.getProvider("BC");
    }
    if (bcProvider != null) {
      return bcProvider;
    }
    bcProvider = new BouncyCastleProvider();
    return bcProvider;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajc\\util\BCJcaJceHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */