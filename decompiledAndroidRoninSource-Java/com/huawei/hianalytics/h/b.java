package com.huawei.hianalytics.h;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.security.KeyStore;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public abstract class b
{
  static KeyStore a()
  {
    KeyStore localKeyStore = KeyStore.getInstance("BKS");
    localKeyStore.load(null, null);
    String[] arrayOfString = a.a;
    int i = 0;
    while (i < arrayOfString.length)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Certificate");
      localStringBuilder.append(i);
      localKeyStore.setCertificateEntry(localStringBuilder.toString(), a(arrayOfString[i]));
      i += 1;
    }
    return localKeyStore;
  }
  
  private static X509Certificate a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("UTF-8");
      paramString = new ByteArrayInputStream(paramString);
      return (X509Certificate)CertificateFactory.getInstance("X509").generateCertificate(paramString);
    }
    catch (UnsupportedEncodingException paramString)
    {
      for (;;) {}
    }
    com.huawei.hianalytics.g.b.c("StoreTools", "generateCertificate: Exception has happened!Encoding is utf-8!");
    throw new CertificateException("generateCertificate(): UnsupportedEncodingException");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hianalytics\h\b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */