package org.bouncycastle.jce.provider;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.util.encoders.Base64;

public class PEMUtil
{
  private final String _footer1;
  private final String _footer2;
  private final String _header1;
  private final String _header2;
  
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
        if (i != 13) {
          localStringBuffer.append((char)i);
        }
      }
    } while ((i >= 0) && (localStringBuffer.length() == 0));
    if (i < 0) {
      return null;
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
    } while ((str != null) && (!str.startsWith(this._header1)) && (!str.startsWith(this._header2)));
    for (;;)
    {
      str = readLine(paramInputStream);
      if ((str == null) || (str.startsWith(this._footer1)) || (str.startsWith(this._footer2))) {
        break;
      }
      localStringBuffer.append(str);
    }
    if (localStringBuffer.length() != 0)
    {
      paramInputStream = new ASN1InputStream(Base64.decode(localStringBuffer.toString())).readObject();
      if ((paramInputStream instanceof ASN1Sequence)) {
        return (ASN1Sequence)paramInputStream;
      }
      throw new IOException("malformed PEM data encountered");
    }
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\jce\provider\PEMUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */