package org.bouncycastle.tsp;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.cmp.PKIFailureInfo;
import org.bouncycastle.asn1.cmp.PKIFreeText;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.cms.Attribute;
import org.bouncycastle.asn1.cms.AttributeTable;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.tsp.TimeStampResp;
import org.bouncycastle.util.Arrays;

public class TimeStampResponse
{
  TimeStampResp resp;
  TimeStampToken timeStampToken;
  
  public TimeStampResponse(InputStream paramInputStream)
    throws TSPException, IOException
  {
    this(readTimeStampResp(paramInputStream));
  }
  
  public TimeStampResponse(TimeStampResp paramTimeStampResp)
    throws TSPException, IOException
  {
    this.resp = paramTimeStampResp;
    if (paramTimeStampResp.getTimeStampToken() != null) {
      this.timeStampToken = new TimeStampToken(paramTimeStampResp.getTimeStampToken());
    }
  }
  
  public TimeStampResponse(byte[] paramArrayOfByte)
    throws TSPException, IOException
  {
    this(new ByteArrayInputStream(paramArrayOfByte));
  }
  
  private static TimeStampResp readTimeStampResp(InputStream paramInputStream)
    throws IOException, TSPException
  {
    try
    {
      paramInputStream = TimeStampResp.getInstance(new ASN1InputStream(paramInputStream).readObject());
      return paramInputStream;
    }
    catch (ClassCastException paramInputStream)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed timestamp response: ");
      localStringBuilder.append(paramInputStream);
      throw new TSPException(localStringBuilder.toString(), paramInputStream);
    }
    catch (IllegalArgumentException paramInputStream)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("malformed timestamp response: ");
      localStringBuilder.append(paramInputStream);
      throw new TSPException(localStringBuilder.toString(), paramInputStream);
    }
  }
  
  public byte[] getEncoded()
    throws IOException
  {
    return this.resp.getEncoded();
  }
  
  public PKIFailureInfo getFailInfo()
  {
    if (this.resp.getStatus().getFailInfo() != null) {
      return new PKIFailureInfo(this.resp.getStatus().getFailInfo());
    }
    return null;
  }
  
  public int getStatus()
  {
    return this.resp.getStatus().getStatus().intValue();
  }
  
  public String getStatusString()
  {
    if (this.resp.getStatus().getStatusString() != null)
    {
      StringBuffer localStringBuffer = new StringBuffer();
      PKIFreeText localPKIFreeText = this.resp.getStatus().getStatusString();
      int i = 0;
      while (i != localPKIFreeText.size())
      {
        localStringBuffer.append(localPKIFreeText.getStringAt(i).getString());
        i += 1;
      }
      return localStringBuffer.toString();
    }
    return null;
  }
  
  public TimeStampToken getTimeStampToken()
  {
    return this.timeStampToken;
  }
  
  public void validate(TimeStampRequest paramTimeStampRequest)
    throws TSPException
  {
    Object localObject = getTimeStampToken();
    if (localObject != null)
    {
      TimeStampTokenInfo localTimeStampTokenInfo = ((TimeStampToken)localObject).getTimeStampInfo();
      if ((paramTimeStampRequest.getNonce() != null) && (!paramTimeStampRequest.getNonce().equals(localTimeStampTokenInfo.getNonce()))) {
        throw new TSPValidationException("response contains wrong nonce value.");
      }
      if ((getStatus() != 0) && (getStatus() != 1)) {
        throw new TSPValidationException("time stamp token found in failed request.");
      }
      if (Arrays.constantTimeAreEqual(paramTimeStampRequest.getMessageImprintDigest(), localTimeStampTokenInfo.getMessageImprintDigest()))
      {
        if (localTimeStampTokenInfo.getMessageImprintAlgOID().equals(paramTimeStampRequest.getMessageImprintAlgOID()))
        {
          Attribute localAttribute = ((TimeStampToken)localObject).getSignedAttributes().get(PKCSObjectIdentifiers.id_aa_signingCertificate);
          localObject = ((TimeStampToken)localObject).getSignedAttributes().get(PKCSObjectIdentifiers.id_aa_signingCertificateV2);
          if ((localAttribute == null) && (localObject == null)) {
            throw new TSPValidationException("no signing certificate attribute present.");
          }
          if (paramTimeStampRequest.getReqPolicy() != null)
          {
            if (paramTimeStampRequest.getReqPolicy().equals(localTimeStampTokenInfo.getPolicy())) {
              return;
            }
            throw new TSPValidationException("TSA policy wrong for request.");
          }
        }
        else
        {
          throw new TSPValidationException("response for different message imprint algorithm.");
        }
      }
      else {
        throw new TSPValidationException("response for different message imprint digest.");
      }
    }
    else
    {
      if ((getStatus() == 0) || (getStatus() == 1)) {
        break label222;
      }
    }
    return;
    label222:
    throw new TSPValidationException("no time stamp token found and one expected.");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\TimeStampResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */