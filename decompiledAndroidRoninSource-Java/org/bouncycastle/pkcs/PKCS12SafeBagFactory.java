package org.bouncycastle.pkcs;

import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.SafeBag;
import org.bouncycastle.cms.CMSEncryptedData;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.operator.InputDecryptorProvider;

public class PKCS12SafeBagFactory
{
  private ASN1Sequence safeBagSeq;
  
  public PKCS12SafeBagFactory(org.bouncycastle.asn1.pkcs.ContentInfo paramContentInfo)
  {
    if (!paramContentInfo.getContentType().equals(PKCSObjectIdentifiers.encryptedData))
    {
      this.safeBagSeq = ASN1Sequence.getInstance(ASN1OctetString.getInstance(paramContentInfo.getContent()).getOctets());
      return;
    }
    throw new IllegalArgumentException("encryptedData requires constructor with decryptor.");
  }
  
  public PKCS12SafeBagFactory(org.bouncycastle.asn1.pkcs.ContentInfo paramContentInfo, InputDecryptorProvider paramInputDecryptorProvider)
    throws PKCSException
  {
    if (paramContentInfo.getContentType().equals(PKCSObjectIdentifiers.encryptedData))
    {
      paramContentInfo = new CMSEncryptedData(org.bouncycastle.asn1.cms.ContentInfo.getInstance(paramContentInfo));
      try
      {
        this.safeBagSeq = ASN1Sequence.getInstance(paramContentInfo.getContent(paramInputDecryptorProvider));
        return;
      }
      catch (CMSException paramContentInfo)
      {
        paramInputDecryptorProvider = new StringBuilder();
        paramInputDecryptorProvider.append("unable to extract data: ");
        paramInputDecryptorProvider.append(paramContentInfo.getMessage());
        throw new PKCSException(paramInputDecryptorProvider.toString(), paramContentInfo);
      }
    }
    throw new IllegalArgumentException("encryptedData requires constructor with decryptor.");
  }
  
  public PKCS12SafeBag[] getSafeBags()
  {
    PKCS12SafeBag[] arrayOfPKCS12SafeBag = new PKCS12SafeBag[this.safeBagSeq.size()];
    int i = 0;
    while (i != this.safeBagSeq.size())
    {
      arrayOfPKCS12SafeBag[i] = new PKCS12SafeBag(SafeBag.getInstance(this.safeBagSeq.getObjectAt(i)));
      i += 1;
    }
    return arrayOfPKCS12SafeBag;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS12SafeBagFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */