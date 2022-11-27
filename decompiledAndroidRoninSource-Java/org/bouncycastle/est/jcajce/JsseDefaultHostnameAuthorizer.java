package org.bouncycastle.est.jcajce;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.net.ssl.SSLSession;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x500.AttributeTypeAndValue;
import org.bouncycastle.asn1.x500.RDN;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x500.style.BCStyle;
import org.bouncycastle.est.ESTException;
import org.bouncycastle.util.Strings;

public class JsseDefaultHostnameAuthorizer
  implements JsseHostnameAuthorizer
{
  private final Set<String> knownSuffixes;
  
  public JsseDefaultHostnameAuthorizer(Set<String> paramSet)
  {
    this.knownSuffixes = paramSet;
  }
  
  public static boolean isValidNameMatch(String paramString1, String paramString2, Set<String> paramSet)
    throws IOException
  {
    if (paramString2.contains("*"))
    {
      int i = paramString2.indexOf('*');
      int j = paramString2.lastIndexOf("*");
      boolean bool2 = false;
      if ((i == j) && (!paramString2.contains("..")))
      {
        if (paramString2.charAt(paramString2.length() - 1) == '*') {
          return false;
        }
        j = paramString2.indexOf('.', i);
        if ((paramSet != null) && (paramSet.contains(Strings.toLowerCase(paramString2.substring(j)))))
        {
          paramString1 = new StringBuilder();
          paramString1.append("Wildcard `");
          paramString1.append(paramString2);
          paramString1.append("` matches known public suffix.");
          throw new IOException(paramString1.toString());
        }
        paramSet = Strings.toLowerCase(paramString2.substring(i + 1));
        paramString1 = Strings.toLowerCase(paramString1);
        if (paramString1.equals(paramSet)) {
          return false;
        }
        if (paramSet.length() > paramString1.length()) {
          return false;
        }
        if (i > 0)
        {
          boolean bool1 = bool2;
          if (paramString1.startsWith(paramString2.substring(0, i - 1)))
          {
            bool1 = bool2;
            if (paramString1.endsWith(paramSet))
            {
              bool1 = bool2;
              if (paramString1.substring(i, paramString1.length() - paramSet.length()).indexOf('.') < 0) {
                bool1 = true;
              }
            }
          }
          return bool1;
        }
        if (paramString1.substring(0, paramString1.length() - paramSet.length()).indexOf('.') > 0) {
          return false;
        }
        return paramString1.endsWith(paramSet);
      }
      return false;
    }
    return paramString1.equalsIgnoreCase(paramString2);
  }
  
  public boolean verified(String paramString, SSLSession paramSSLSession)
    throws IOException
  {
    try
    {
      boolean bool = verify(paramString, (X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(paramSSLSession.getPeerCertificates()[0].getEncoded())));
      return bool;
    }
    catch (Exception paramString)
    {
      if ((paramString instanceof ESTException)) {
        throw ((ESTException)paramString);
      }
      throw new ESTException(paramString.getMessage(), paramString);
    }
  }
  
  public boolean verify(String paramString, X509Certificate paramX509Certificate)
    throws IOException
  {
    try
    {
      Object localObject = paramX509Certificate.getSubjectAlternativeNames();
      if (localObject != null)
      {
        paramX509Certificate = ((Collection)localObject).iterator();
        while (paramX509Certificate.hasNext())
        {
          localObject = (List)paramX509Certificate.next();
          i = ((Number)((List)localObject).get(0)).intValue();
          if (i != 2)
          {
            if (i == 7)
            {
              if (InetAddress.getByName(paramString).equals(InetAddress.getByName(((List)localObject).get(1).toString()))) {
                return true;
              }
            }
            else {
              throw new RuntimeException("Unable to handle ");
            }
          }
          else
          {
            boolean bool = isValidNameMatch(paramString, ((List)localObject).get(1).toString(), this.knownSuffixes);
            if (bool) {
              return true;
            }
          }
        }
        return false;
      }
      if (paramX509Certificate.getSubjectX500Principal() == null) {
        return false;
      }
      paramX509Certificate = X500Name.getInstance(paramX509Certificate.getSubjectX500Principal().getEncoded()).getRDNs();
      int i = 0;
      while (i != paramX509Certificate.length)
      {
        localObject = paramX509Certificate[i];
        AttributeTypeAndValue[] arrayOfAttributeTypeAndValue = ((RDN)localObject).getTypesAndValues();
        int j = 0;
        while (j != arrayOfAttributeTypeAndValue.length)
        {
          if (arrayOfAttributeTypeAndValue[j].getType().equals(BCStyle.CN)) {
            return isValidNameMatch(paramString, ((RDN)localObject).getFirst().getValue().toString(), this.knownSuffixes);
          }
          j += 1;
        }
        i += 1;
      }
      return false;
    }
    catch (Exception paramString)
    {
      throw new ESTException(paramString.getMessage(), paramString);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\est\jcajce\JsseDefaultHostnameAuthorizer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */