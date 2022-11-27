package org.bouncycastle.cms.jcajce;

import java.security.cert.X509CertSelector;
import org.bouncycastle.cms.KeyTransRecipientId;
import org.bouncycastle.cms.SignerId;

public class JcaX509CertSelectorConverter
  extends org.bouncycastle.cert.selector.jcajce.JcaX509CertSelectorConverter
{
  public X509CertSelector getCertSelector(KeyTransRecipientId paramKeyTransRecipientId)
  {
    return doConversion(paramKeyTransRecipientId.getIssuer(), paramKeyTransRecipientId.getSerialNumber(), paramKeyTransRecipientId.getSubjectKeyIdentifier());
  }
  
  public X509CertSelector getCertSelector(SignerId paramSignerId)
  {
    return doConversion(paramSignerId.getIssuer(), paramSignerId.getSerialNumber(), paramSignerId.getSubjectKeyIdentifier());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\JcaX509CertSelectorConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */