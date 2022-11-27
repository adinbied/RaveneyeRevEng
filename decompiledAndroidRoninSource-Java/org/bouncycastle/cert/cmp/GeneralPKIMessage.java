package org.bouncycastle.cert.cmp;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cmp.PKIBody;
import org.bouncycastle.asn1.cmp.PKIHeader;
import org.bouncycastle.asn1.cmp.PKIMessage;
import org.bouncycastle.cert.CertIOException;

public class GeneralPKIMessage
{
  private final PKIMessage pkiMessage;
  
  public GeneralPKIMessage(PKIMessage paramPKIMessage)
  {
    this.pkiMessage = paramPKIMessage;
  }
  
  public GeneralPKIMessage(byte[] paramArrayOfByte)
    throws IOException
  {
    this(parseBytes(paramArrayOfByte));
  }
  
  private static PKIMessage parseBytes(byte[] paramArrayOfByte)
    throws IOException
  {
    try
    {
      paramArrayOfByte = PKIMessage.getInstance(ASN1Primitive.fromByteArray(paramArrayOfByte));
      return paramArrayOfByte;
    }
    catch (IllegalArgumentException paramArrayOfByte)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
    catch (ClassCastException paramArrayOfByte)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed data: ");
      localStringBuilder.append(paramArrayOfByte.getMessage());
      throw new CertIOException(localStringBuilder.toString(), paramArrayOfByte);
    }
  }
  
  public PKIBody getBody()
  {
    return this.pkiMessage.getBody();
  }
  
  public PKIHeader getHeader()
  {
    return this.pkiMessage.getHeader();
  }
  
  public boolean hasProtection()
  {
    return this.pkiMessage.getHeader().getProtectionAlg() != null;
  }
  
  public PKIMessage toASN1Structure()
  {
    return this.pkiMessage;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\cert\cmp\GeneralPKIMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */