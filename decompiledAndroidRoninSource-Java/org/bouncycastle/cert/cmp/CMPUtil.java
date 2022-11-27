package org.bouncycastle.cert.cmp;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.DEROutputStream;

class CMPUtil
{
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
      throw new CMPRuntimeException(paramOutputStream.toString(), paramASN1Encodable);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\cmp\CMPUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */