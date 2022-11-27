package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERGeneralizedTime;
import org.bouncycastle.asn1.DERIA5String;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.asn1.DERUTF8String;

public class X509DefaultEntryConverter
  extends X509NameEntryConverter
{
  public ASN1Primitive getConvertedValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString)
  {
    if ((paramString.length() != 0) && (paramString.charAt(0) == '#')) {}
    try
    {
      paramString = convertHexEncoded(paramString, 1);
      return paramString;
    }
    catch (IOException paramString)
    {
      String str;
      for (;;) {}
    }
    paramString = new StringBuilder();
    paramString.append("can't recode value for oid ");
    paramString.append(paramASN1ObjectIdentifier.getId());
    throw new RuntimeException(paramString.toString());
    str = paramString;
    if (paramString.length() != 0)
    {
      str = paramString;
      if (paramString.charAt(0) == '\\') {
        str = paramString.substring(1);
      }
    }
    if ((!paramASN1ObjectIdentifier.equals(X509Name.EmailAddress)) && (!paramASN1ObjectIdentifier.equals(X509Name.DC)))
    {
      if (paramASN1ObjectIdentifier.equals(X509Name.DATE_OF_BIRTH)) {
        return new DERGeneralizedTime(str);
      }
      if ((!paramASN1ObjectIdentifier.equals(X509Name.C)) && (!paramASN1ObjectIdentifier.equals(X509Name.SN)) && (!paramASN1ObjectIdentifier.equals(X509Name.DN_QUALIFIER)) && (!paramASN1ObjectIdentifier.equals(X509Name.TELEPHONE_NUMBER))) {
        return new DERUTF8String(str);
      }
      return new DERPrintableString(str);
    }
    return new DERIA5String(str);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\X509DefaultEntryConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */