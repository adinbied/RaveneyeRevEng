package org.bouncycastle.cert.ocsp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.cert.X509CertificateHolder;

class OCSPUtils
{
  static final X509CertificateHolder[] EMPTY_CERTS = new X509CertificateHolder[0];
  static List EMPTY_LIST = Collections.unmodifiableList(new ArrayList());
  static Set EMPTY_SET = Collections.unmodifiableSet(new HashSet());
  
  static Date extractDate(ASN1GeneralizedTime paramASN1GeneralizedTime)
  {
    try
    {
      paramASN1GeneralizedTime = paramASN1GeneralizedTime.getDate();
      return paramASN1GeneralizedTime;
    }
    catch (Exception paramASN1GeneralizedTime)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("exception processing GeneralizedTime: ");
      localStringBuilder.append(paramASN1GeneralizedTime.getMessage());
      throw new IllegalStateException(localStringBuilder.toString());
    }
  }
  
  static Set getCriticalExtensionOIDs(Extensions paramExtensions)
  {
    if (paramExtensions == null) {
      return EMPTY_SET;
    }
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(paramExtensions.getCriticalExtensionOIDs())));
  }
  
  static List getExtensionOIDs(Extensions paramExtensions)
  {
    if (paramExtensions == null) {
      return EMPTY_LIST;
    }
    return Collections.unmodifiableList(Arrays.asList(paramExtensions.getExtensionOIDs()));
  }
  
  static Set getNonCriticalExtensionOIDs(Extensions paramExtensions)
  {
    if (paramExtensions == null) {
      return EMPTY_SET;
    }
    return Collections.unmodifiableSet(new HashSet(Arrays.asList(paramExtensions.getNonCriticalExtensionOIDs())));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\ocsp\OCSPUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */