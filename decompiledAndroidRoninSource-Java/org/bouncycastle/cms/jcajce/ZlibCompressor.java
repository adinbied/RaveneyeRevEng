package org.bouncycastle.cms.jcajce;

import java.io.OutputStream;
import java.util.zip.DeflaterOutputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.operator.OutputCompressor;

public class ZlibCompressor
  implements OutputCompressor
{
  private static final String ZLIB = "1.2.840.113549.1.9.16.3.8";
  
  public AlgorithmIdentifier getAlgorithmIdentifier()
  {
    return new AlgorithmIdentifier(new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.3.8"));
  }
  
  public OutputStream getOutputStream(OutputStream paramOutputStream)
  {
    return new DeflaterOutputStream(paramOutputStream);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\cms\jcajce\ZlibCompressor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */