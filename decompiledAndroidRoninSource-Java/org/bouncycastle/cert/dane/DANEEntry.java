package org.bouncycastle.cert.dane;

import java.io.IOException;
import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.util.Arrays;

public class DANEEntry
{
  static final int CERT_USAGE = 0;
  public static final int CERT_USAGE_ACCEPT = 3;
  public static final int CERT_USAGE_CA = 0;
  public static final int CERT_USAGE_PKIX_VALIDATE = 1;
  public static final int CERT_USAGE_TRUST_ANCHOR = 2;
  static final int MATCHING_TYPE = 2;
  static final int SELECTOR = 1;
  private final X509CertificateHolder certHolder;
  private final String domainName;
  private final byte[] flags;
  
  public DANEEntry(String paramString, byte[] paramArrayOfByte)
    throws IOException
  {
    this(paramString, Arrays.copyOfRange(paramArrayOfByte, 0, 3), new X509CertificateHolder(Arrays.copyOfRange(paramArrayOfByte, 3, paramArrayOfByte.length)));
  }
  
  DANEEntry(String paramString, byte[] paramArrayOfByte, X509CertificateHolder paramX509CertificateHolder)
  {
    this.flags = paramArrayOfByte;
    this.domainName = paramString;
    this.certHolder = paramX509CertificateHolder;
  }
  
  public static boolean isValidCertificate(byte[] paramArrayOfByte)
  {
    boolean bool2 = false;
    boolean bool1;
    if (paramArrayOfByte[0] < 0)
    {
      bool1 = bool2;
      if (paramArrayOfByte[0] > 3) {}
    }
    else
    {
      bool1 = bool2;
      if (paramArrayOfByte[1] == 0)
      {
        bool1 = bool2;
        if (paramArrayOfByte[2] == 0) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public X509CertificateHolder getCertificate()
  {
    return this.certHolder;
  }
  
  public String getDomainName()
  {
    return this.domainName;
  }
  
  public byte[] getFlags()
  {
    return Arrays.clone(this.flags);
  }
  
  public byte[] getRDATA()
    throws IOException
  {
    byte[] arrayOfByte1 = this.certHolder.getEncoded();
    byte[] arrayOfByte2 = this.flags;
    byte[] arrayOfByte3 = new byte[arrayOfByte2.length + arrayOfByte1.length];
    System.arraycopy(arrayOfByte2, 0, arrayOfByte3, 0, arrayOfByte2.length);
    System.arraycopy(arrayOfByte1, 0, arrayOfByte3, this.flags.length, arrayOfByte1.length);
    return arrayOfByte3;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\dane\DANEEntry.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */