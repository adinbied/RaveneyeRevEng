package org.bouncycastle.cert.crmf;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.crmf.EncryptedValue;
import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.util.Strings;
import org.bouncycastle.util.io.Streams;

public class EncryptedValueParser
{
  private EncryptedValuePadder padder;
  private EncryptedValue value;
  
  public EncryptedValueParser(EncryptedValue paramEncryptedValue)
  {
    this.value = paramEncryptedValue;
  }
  
  public EncryptedValueParser(EncryptedValue paramEncryptedValue, EncryptedValuePadder paramEncryptedValuePadder)
  {
    this.value = paramEncryptedValue;
    this.padder = paramEncryptedValuePadder;
  }
  
  private byte[] decryptValue(ValueDecryptorGenerator paramValueDecryptorGenerator)
    throws CRMFException
  {
    if (this.value.getIntendedAlg() == null)
    {
      if (this.value.getValueHint() == null)
      {
        paramValueDecryptorGenerator = paramValueDecryptorGenerator.getValueDecryptor(this.value.getKeyAlg(), this.value.getSymmAlg(), this.value.getEncSymmKey().getBytes()).getInputStream(new ByteArrayInputStream(this.value.getEncValue().getBytes()));
        try
        {
          localObject = Streams.readAll(paramValueDecryptorGenerator);
          paramValueDecryptorGenerator = (ValueDecryptorGenerator)localObject;
          if (this.padder != null) {
            paramValueDecryptorGenerator = this.padder.getUnpaddedData((byte[])localObject);
          }
          return paramValueDecryptorGenerator;
        }
        catch (IOException paramValueDecryptorGenerator)
        {
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("Cannot parse decrypted data: ");
          ((StringBuilder)localObject).append(paramValueDecryptorGenerator.getMessage());
          throw new CRMFException(((StringBuilder)localObject).toString(), paramValueDecryptorGenerator);
        }
      }
      throw new UnsupportedOperationException();
    }
    throw new UnsupportedOperationException();
  }
  
  public X509CertificateHolder readCertificateHolder(ValueDecryptorGenerator paramValueDecryptorGenerator)
    throws CRMFException
  {
    return new X509CertificateHolder(Certificate.getInstance(decryptValue(paramValueDecryptorGenerator)));
  }
  
  public char[] readPassphrase(ValueDecryptorGenerator paramValueDecryptorGenerator)
    throws CRMFException
  {
    return Strings.fromUTF8ByteArray(decryptValue(paramValueDecryptorGenerator)).toCharArray();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\EncryptedValueParser.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */