package org.bouncycastle.jcajce.provider.asymmetric.x509;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.util.encoders.Base64;

class PEMUtil
{
  private final String _footer1;
  private final String _footer2;
  private final String _footer3;
  private final String _header1;
  private final String _header2;
  private final String _header3;
  
  PEMUtil(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----BEGIN ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("-----");
    this._header1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----BEGIN X509 ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("-----");
    this._header2 = localStringBuilder.toString();
    this._header3 = "-----BEGIN PKCS7-----";
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----END ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("-----");
    this._footer1 = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("-----END X509 ");
    localStringBuilder.append(paramString);
    localStringBuilder.append("-----");
    this._footer2 = localStringBuilder.toString();
    this._footer3 = "-----END PKCS7-----";
  }
  
  private String readLine(InputStream paramInputStream)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i;
    do
    {
      for (;;)
      {
        i = paramInputStream.read();
        if ((i == 13) || (i == 10) || (i < 0)) {
          break;
        }
        localStringBuffer.append((char)i);
      }
    } while ((i >= 0) && (localStringBuffer.length() == 0));
    if (i < 0) {
      return null;
    }
    if (i == 13)
    {
      paramInputStream.mark(1);
      i = paramInputStream.read();
      if (i == 10) {
        paramInputStream.mark(1);
      }
      if (i > 0) {
        paramInputStream.reset();
      }
    }
    return localStringBuffer.toString();
  }
  
  ASN1Sequence readPEMObject(InputStream paramInputStream)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    String str;
    do
    {
      str = readLine(paramInputStream);
    } while ((str != null) && (!str.startsWith(this._header1)) && (!str.startsWith(this._header2)) && (!str.startsWith(this._header3)));
    for (;;)
    {
      str = readLine(paramInputStream);
      if ((str == null) || (str.startsWith(this._footer1)) || (str.startsWith(this._footer2)) || (str.startsWith(this._footer3))) {
        break;
      }
      localStringBuffer.append(str);
    }
    if (localStringBuffer.length() != 0) {}
    try
    {
      paramInputStream = ASN1Sequence.getInstance(Base64.decode(localStringBuffer.toString()));
      return paramInputStream;
    }
    catch (Exception paramInputStream)
    {
      for (;;) {}
    }
    throw new IOException("malformed PEM data encountered");
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jcajce\provider\asymmetric\x509\PEMUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */