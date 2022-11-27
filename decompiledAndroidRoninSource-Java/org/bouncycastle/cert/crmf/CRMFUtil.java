package org.bouncycastle.cert.crmf;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROutputStream;
import org.bouncycastle.asn1.x509.ExtensionsGenerator;
import org.bouncycastle.cert.CertIOException;

class CRMFUtil
{
  static void addExtension(ExtensionsGenerator paramExtensionsGenerator, ASN1ObjectIdentifier paramASN1ObjectIdentifier, boolean paramBoolean, ASN1Encodable paramASN1Encodable)
    throws CertIOException
  {
    try
    {
      paramExtensionsGenerator.addExtension(paramASN1ObjectIdentifier, paramBoolean, paramASN1Encodable);
      return;
    }
    catch (IOException paramExtensionsGenerator)
    {
      paramASN1ObjectIdentifier = new StringBuilder();
      paramASN1ObjectIdentifier.append("cannot encode extension: ");
      paramASN1ObjectIdentifier.append(paramExtensionsGenerator.getMessage());
      throw new CertIOException(paramASN1ObjectIdentifier.toString(), paramExtensionsGenerator);
    }
  }
  
  static void derEncodeToStream(ASN1Encodable paramASN1Encodable, OutputStream paramOutputStream)
  {
    paramOutputStream = new DEROutputStream(paramOutputStream);
    try
    {
      paramOutputStream.writeObject(paramASN1Encodable);
      paramOutputStream.close();
      return;
    }
    catch (IOException paramASN1Encodable)
    {
      paramOutputStream = new StringBuilder();
      paramOutputStream.append("unable to DER encode object: ");
      paramOutputStream.append(paramASN1Encodable.getMessage());
      throw new CRMFRuntimeException(paramOutputStream.toString(), paramASN1Encodable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\crmf\CRMFUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */