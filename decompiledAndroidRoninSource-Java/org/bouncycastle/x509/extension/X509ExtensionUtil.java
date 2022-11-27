package org.bouncycastle.x509.extension;

import java.io.IOException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1String;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.X509Extension;
import org.bouncycastle.util.Integers;

public class X509ExtensionUtil
{
  public static ASN1Primitive fromExtensionValue(byte[] paramArrayOfByte)
    throws IOException
  {
    return ASN1Primitive.fromByteArray(((ASN1OctetString)ASN1Primitive.fromByteArray(paramArrayOfByte)).getOctets());
  }
  
  private static Collection getAlternativeNames(byte[] paramArrayOfByte)
    throws CertificateParsingException
  {
    if (paramArrayOfByte == null) {
      return Collections.EMPTY_LIST;
    }
    for (;;)
    {
      try
      {
        Object localObject = new ArrayList();
        Enumeration localEnumeration = DERSequence.getInstance(fromExtensionValue(paramArrayOfByte)).getObjects();
        ArrayList localArrayList;
        if (localEnumeration.hasMoreElements())
        {
          paramArrayOfByte = GeneralName.getInstance(localEnumeration.nextElement());
          localArrayList = new ArrayList();
          localArrayList.add(Integers.valueOf(paramArrayOfByte.getTagNo()));
        }
        switch (paramArrayOfByte.getTagNo())
        {
        case 8: 
          continue;
          paramArrayOfByte = ASN1ObjectIdentifier.getInstance(paramArrayOfByte.getName()).getId();
          localArrayList.add(paramArrayOfByte);
          break;
        case 7: 
          localArrayList.add(DEROctetString.getInstance(paramArrayOfByte.getName()).getOctets());
          break;
        case 4: 
          paramArrayOfByte = X500Name.getInstance(paramArrayOfByte.getName()).toString();
          break;
        case 1: 
        case 2: 
        case 6: 
          paramArrayOfByte = ((ASN1String)paramArrayOfByte.getName()).getString();
          break;
        case 0: 
        case 3: 
        case 5: 
          paramArrayOfByte = paramArrayOfByte.getName().toASN1Primitive();
          continue;
          ((Collection)localObject).add(localArrayList);
          continue;
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Bad tag number: ");
          ((StringBuilder)localObject).append(paramArrayOfByte.getTagNo());
          throw new IOException(((StringBuilder)localObject).toString());
          paramArrayOfByte = Collections.unmodifiableCollection((Collection)localObject);
          return paramArrayOfByte;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        throw new CertificateParsingException(paramArrayOfByte.getMessage());
      }
    }
  }
  
  public static Collection getIssuerAlternativeNames(X509Certificate paramX509Certificate)
    throws CertificateParsingException
  {
    return getAlternativeNames(paramX509Certificate.getExtensionValue(X509Extension.issuerAlternativeName.getId()));
  }
  
  public static Collection getSubjectAlternativeNames(X509Certificate paramX509Certificate)
    throws CertificateParsingException
  {
    return getAlternativeNames(paramX509Certificate.getExtensionValue(X509Extension.subjectAlternativeName.getId()));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\x509\extension\X509ExtensionUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */