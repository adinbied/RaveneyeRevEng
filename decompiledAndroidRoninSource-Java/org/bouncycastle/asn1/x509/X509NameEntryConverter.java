package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERPrintableString;
import org.bouncycastle.util.Strings;

public abstract class X509NameEntryConverter
{
  protected boolean canBePrintable(String paramString)
  {
    return DERPrintableString.isPrintableString(paramString);
  }
  
  protected ASN1Primitive convertHexEncoded(String paramString, int paramInt)
    throws IOException
  {
    paramString = Strings.toLowerCase(paramString);
    int j = (paramString.length() - paramInt) / 2;
    byte[] arrayOfByte = new byte[j];
    int i = 0;
    while (i != j)
    {
      int k = i * 2 + paramInt;
      int m = paramString.charAt(k);
      k = paramString.charAt(k + 1);
      if (m < 97) {
        arrayOfByte[i] = ((byte)(m - 48 << 4));
      } else {
        arrayOfByte[i] = ((byte)(m - 97 + 10 << 4));
      }
      if (k < 97)
      {
        m = arrayOfByte[i];
        arrayOfByte[i] = ((byte)((byte)(k - 48) | m));
      }
      else
      {
        m = arrayOfByte[i];
        arrayOfByte[i] = ((byte)((byte)(k - 97 + 10) | m));
      }
      i += 1;
    }
    return new ASN1InputStream(arrayOfByte).readObject();
  }
  
  public abstract ASN1Primitive getConvertedValue(ASN1ObjectIdentifier paramASN1ObjectIdentifier, String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\X509NameEntryConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */