package org.bouncycastle.dvcs;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.cms.CMSException;
import org.bouncycastle.cms.CMSProcessableByteArray;
import org.bouncycastle.cms.CMSSignedData;
import org.bouncycastle.cms.CMSSignedDataGenerator;

public class SignedDVCSMessageGenerator
{
  private final CMSSignedDataGenerator signedDataGen;
  
  public SignedDVCSMessageGenerator(CMSSignedDataGenerator paramCMSSignedDataGenerator)
  {
    this.signedDataGen = paramCMSSignedDataGenerator;
  }
  
  public CMSSignedData build(DVCSMessage paramDVCSMessage)
    throws DVCSException
  {
    try
    {
      byte[] arrayOfByte = paramDVCSMessage.getContent().toASN1Primitive().getEncoded("DER");
      paramDVCSMessage = this.signedDataGen.generate(new CMSProcessableByteArray(paramDVCSMessage.getContentType(), arrayOfByte), true);
      return paramDVCSMessage;
    }
    catch (IOException paramDVCSMessage)
    {
      throw new DVCSException("Could not encode DVCS request", paramDVCSMessage);
    }
    catch (CMSException paramDVCSMessage)
    {
      throw new DVCSException("Could not sign DVCS request", paramDVCSMessage);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\SignedDVCSMessageGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */