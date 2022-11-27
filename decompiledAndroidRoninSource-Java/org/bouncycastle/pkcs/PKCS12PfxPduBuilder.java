package org.bouncycastle.pkcs;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.pkcs.AuthenticatedSafe;
import org.bouncycastle.asn1.pkcs.ContentInfo;
import org.bouncycastle.asn1.pkcs.MacData;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.Pfx;
import org.bouncycastle.cms.CMSEncryptedData;
import org.bouncycastle.cms.CMSEncryptedDataGenerator;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.operator.OutputEncryptor;

public class PKCS12PfxPduBuilder
{
  private ASN1EncodableVector dataVector = new ASN1EncodableVector();
  
  private PKCS12PfxPduBuilder addEncryptedData(OutputEncryptor paramOutputEncryptor, ASN1Sequence paramASN1Sequence)
    throws IOException
  {
    CMSEncryptedDataGenerator localCMSEncryptedDataGenerator = new CMSEncryptedDataGenerator();
    try
    {
      this.dataVector.add(localCMSEncryptedDataGenerator.generate(new CMSProcessableByteArray(paramASN1Sequence.getEncoded()), paramOutputEncryptor).toASN1Structure());
      return this;
    }
    catch (CMSException paramOutputEncryptor)
    {
      throw new PKCSIOException(paramOutputEncryptor.getMessage(), paramOutputEncryptor.getCause());
    }
  }
  
  public PKCS12PfxPduBuilder addData(PKCS12SafeBag paramPKCS12SafeBag)
    throws IOException
  {
    this.dataVector.add(new ContentInfo(PKCSObjectIdentifiers.data, new DEROctetString(new DLSequence(paramPKCS12SafeBag.toASN1Structure()).getEncoded())));
    return this;
  }
  
  public PKCS12PfxPduBuilder addEncryptedData(OutputEncryptor paramOutputEncryptor, PKCS12SafeBag paramPKCS12SafeBag)
    throws IOException
  {
    return addEncryptedData(paramOutputEncryptor, new DERSequence(paramPKCS12SafeBag.toASN1Structure()));
  }
  
  public PKCS12PfxPduBuilder addEncryptedData(OutputEncryptor paramOutputEncryptor, PKCS12SafeBag[] paramArrayOfPKCS12SafeBag)
    throws IOException
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = 0;
    while (i != paramArrayOfPKCS12SafeBag.length)
    {
      localASN1EncodableVector.add(paramArrayOfPKCS12SafeBag[i].toASN1Structure());
      i += 1;
    }
    return addEncryptedData(paramOutputEncryptor, new DLSequence(localASN1EncodableVector));
  }
  
  public PKCS12PfxPdu build(PKCS12MacCalculatorBuilder paramPKCS12MacCalculatorBuilder, char[] paramArrayOfChar)
    throws PKCSException
  {
    Object localObject = AuthenticatedSafe.getInstance(new DLSequence(this.dataVector));
    try
    {
      byte[] arrayOfByte = ((AuthenticatedSafe)localObject).getEncoded();
      ContentInfo localContentInfo = new ContentInfo(PKCSObjectIdentifiers.data, new DEROctetString(arrayOfByte));
      localObject = null;
      if (paramPKCS12MacCalculatorBuilder != null) {
        localObject = new MacDataGenerator(paramPKCS12MacCalculatorBuilder).build(paramArrayOfChar, arrayOfByte);
      }
      return new PKCS12PfxPdu(new Pfx(localContentInfo, (MacData)localObject));
    }
    catch (IOException paramPKCS12MacCalculatorBuilder)
    {
      paramArrayOfChar = new StringBuilder();
      paramArrayOfChar.append("unable to encode AuthenticatedSafe: ");
      paramArrayOfChar.append(paramPKCS12MacCalculatorBuilder.getMessage());
      throw new PKCSException(paramArrayOfChar.toString(), paramPKCS12MacCalculatorBuilder);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\pkcs\PKCS12PfxPduBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */