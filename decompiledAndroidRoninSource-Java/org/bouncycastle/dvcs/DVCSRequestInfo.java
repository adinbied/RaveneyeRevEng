package org.bouncycastle.dvcs;

import java.math.BigInteger;
import java.util.Date;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.dvcs.DVCSRequestInformation;
import org.bouncycastle.asn1.dvcs.DVCSTime;
import org.bouncycastle.asn1.dvcs.ServiceType;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.tsp.TimeStampToken;
import org.bouncycastle.tsp.TimeStampTokenInfo;
import org.bouncycastle.util.Arrays;

public class DVCSRequestInfo
{
  private DVCSRequestInformation data;
  
  public DVCSRequestInfo(DVCSRequestInformation paramDVCSRequestInformation)
  {
    this.data = paramDVCSRequestInformation;
  }
  
  public DVCSRequestInfo(byte[] paramArrayOfByte)
  {
    this(DVCSRequestInformation.getInstance(paramArrayOfByte));
  }
  
  private static boolean clientEqualsServer(Object paramObject1, Object paramObject2)
  {
    return ((paramObject1 == null) && (paramObject2 == null)) || ((paramObject1 != null) && (paramObject1.equals(paramObject2)));
  }
  
  public static boolean validate(DVCSRequestInfo paramDVCSRequestInfo1, DVCSRequestInfo paramDVCSRequestInfo2)
  {
    paramDVCSRequestInfo1 = paramDVCSRequestInfo1.data;
    paramDVCSRequestInfo2 = paramDVCSRequestInfo2.data;
    if (paramDVCSRequestInfo1.getVersion() != paramDVCSRequestInfo2.getVersion()) {
      return false;
    }
    if (!clientEqualsServer(paramDVCSRequestInfo1.getService(), paramDVCSRequestInfo2.getService())) {
      return false;
    }
    if (!clientEqualsServer(paramDVCSRequestInfo1.getRequestTime(), paramDVCSRequestInfo2.getRequestTime())) {
      return false;
    }
    if (!clientEqualsServer(paramDVCSRequestInfo1.getRequestPolicy(), paramDVCSRequestInfo2.getRequestPolicy())) {
      return false;
    }
    if (!clientEqualsServer(paramDVCSRequestInfo1.getExtensions(), paramDVCSRequestInfo2.getExtensions())) {
      return false;
    }
    if (paramDVCSRequestInfo1.getNonce() != null)
    {
      if (paramDVCSRequestInfo2.getNonce() == null) {
        return false;
      }
      paramDVCSRequestInfo1 = paramDVCSRequestInfo1.getNonce().toByteArray();
      paramDVCSRequestInfo2 = paramDVCSRequestInfo2.getNonce().toByteArray();
      if (paramDVCSRequestInfo2.length < paramDVCSRequestInfo1.length) {
        return false;
      }
      if (!Arrays.areEqual(paramDVCSRequestInfo1, Arrays.copyOfRange(paramDVCSRequestInfo2, 0, paramDVCSRequestInfo1.length))) {
        return false;
      }
    }
    return true;
  }
  
  public GeneralNames getDVCSNames()
  {
    return this.data.getDVCS();
  }
  
  public GeneralNames getDataLocations()
  {
    return this.data.getDataLocations();
  }
  
  public BigInteger getNonce()
  {
    return this.data.getNonce();
  }
  
  public PolicyInformation getRequestPolicy()
  {
    if (this.data.getRequestPolicy() != null) {
      return this.data.getRequestPolicy();
    }
    return null;
  }
  
  public Date getRequestTime()
    throws DVCSParsingException
  {
    Object localObject = this.data.getRequestTime();
    if (localObject == null) {
      return null;
    }
    try
    {
      if (((DVCSTime)localObject).getGenTime() != null) {
        return ((DVCSTime)localObject).getGenTime().getDate();
      }
      localObject = new TimeStampToken(((DVCSTime)localObject).getTimeStampToken()).getTimeStampInfo().getGenTime();
      return (Date)localObject;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("unable to extract time: ");
      localStringBuilder.append(localException.getMessage());
      throw new DVCSParsingException(localStringBuilder.toString(), localException);
    }
  }
  
  public GeneralNames getRequester()
  {
    return this.data.getRequester();
  }
  
  public int getServiceType()
  {
    return this.data.getService().getValue().intValue();
  }
  
  public int getVersion()
  {
    return this.data.getVersion();
  }
  
  public DVCSRequestInformation toASN1Structure()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\dvcs\DVCSRequestInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */