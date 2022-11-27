package org.bouncycastle.tsp;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERUTF8String;
import org.bouncycastle.asn1.cmp.PKIFreeText;
import org.bouncycastle.asn1.cmp.PKIStatusInfo;
import org.bouncycastle.asn1.tsp.TimeStampResp;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.cms.CMSSignedData;

public class TimeStampResponseGenerator
{
  private Set acceptedAlgorithms;
  private Set acceptedExtensions;
  private Set acceptedPolicies;
  int failInfo;
  int status;
  ASN1EncodableVector statusStrings;
  private TimeStampTokenGenerator tokenGenerator;
  
  public TimeStampResponseGenerator(TimeStampTokenGenerator paramTimeStampTokenGenerator, Set paramSet)
  {
    this(paramTimeStampTokenGenerator, paramSet, null, null);
  }
  
  public TimeStampResponseGenerator(TimeStampTokenGenerator paramTimeStampTokenGenerator, Set paramSet1, Set paramSet2)
  {
    this(paramTimeStampTokenGenerator, paramSet1, paramSet2, null);
  }
  
  public TimeStampResponseGenerator(TimeStampTokenGenerator paramTimeStampTokenGenerator, Set paramSet1, Set paramSet2, Set paramSet3)
  {
    this.tokenGenerator = paramTimeStampTokenGenerator;
    this.acceptedAlgorithms = convert(paramSet1);
    this.acceptedPolicies = convert(paramSet2);
    this.acceptedExtensions = convert(paramSet3);
    this.statusStrings = new ASN1EncodableVector();
  }
  
  private void addStatusString(String paramString)
  {
    this.statusStrings.add(new DERUTF8String(paramString));
  }
  
  private Set convert(Set paramSet)
  {
    if (paramSet == null) {
      return paramSet;
    }
    HashSet localHashSet = new HashSet(paramSet.size());
    paramSet = paramSet.iterator();
    while (paramSet.hasNext())
    {
      Object localObject = paramSet.next();
      if ((localObject instanceof String)) {
        localHashSet.add(new ASN1ObjectIdentifier((String)localObject));
      } else {
        localHashSet.add(localObject);
      }
    }
    return localHashSet;
  }
  
  private PKIStatusInfo getPKIStatusInfo()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    localASN1EncodableVector.add(new ASN1Integer(this.status));
    if (this.statusStrings.size() > 0) {
      localASN1EncodableVector.add(PKIFreeText.getInstance(new DERSequence(this.statusStrings)));
    }
    int i = this.failInfo;
    if (i != 0) {
      localASN1EncodableVector.add(new FailInfo(i));
    }
    return PKIStatusInfo.getInstance(new DERSequence(localASN1EncodableVector));
  }
  
  private void setFailInfoField(int paramInt)
  {
    this.failInfo = (paramInt | this.failInfo);
  }
  
  public TimeStampResponse generate(TimeStampRequest paramTimeStampRequest, BigInteger paramBigInteger, Date paramDate)
    throws TSPException
  {
    try
    {
      paramTimeStampRequest = generateGrantedResponse(paramTimeStampRequest, paramBigInteger, paramDate, "Operation Okay");
      return paramTimeStampRequest;
    }
    catch (Exception paramTimeStampRequest) {}
    return generateRejectedResponse(paramTimeStampRequest);
  }
  
  public TimeStampResponse generateFailResponse(int paramInt1, int paramInt2, String paramString)
    throws TSPException
  {
    this.status = paramInt1;
    this.statusStrings = new ASN1EncodableVector();
    setFailInfoField(paramInt2);
    if (paramString != null) {
      addStatusString(paramString);
    }
    paramString = new TimeStampResp(getPKIStatusInfo(), null);
    try
    {
      paramString = new TimeStampResponse(paramString);
      return paramString;
    }
    catch (IOException paramString)
    {
      for (;;) {}
    }
    throw new TSPException("created badly formatted response!");
  }
  
  public TimeStampResponse generateGrantedResponse(TimeStampRequest paramTimeStampRequest, BigInteger paramBigInteger, Date paramDate)
    throws TSPException
  {
    return generateGrantedResponse(paramTimeStampRequest, paramBigInteger, paramDate, null);
  }
  
  public TimeStampResponse generateGrantedResponse(TimeStampRequest paramTimeStampRequest, BigInteger paramBigInteger, Date paramDate, String paramString)
    throws TSPException
  {
    return generateGrantedResponse(paramTimeStampRequest, paramBigInteger, paramDate, paramString, null);
  }
  
  public TimeStampResponse generateGrantedResponse(TimeStampRequest paramTimeStampRequest, BigInteger paramBigInteger, Date paramDate, String paramString, Extensions paramExtensions)
    throws TSPException
  {
    if (paramDate != null)
    {
      paramTimeStampRequest.validate(this.acceptedAlgorithms, this.acceptedPolicies, this.acceptedExtensions);
      this.status = 0;
      this.statusStrings = new ASN1EncodableVector();
      if (paramString != null) {
        addStatusString(paramString);
      }
      paramString = getPKIStatusInfo();
      try
      {
        paramTimeStampRequest = this.tokenGenerator.generate(paramTimeStampRequest, paramBigInteger, paramDate, paramExtensions).toCMSSignedData().toASN1Structure();
        paramTimeStampRequest = new TimeStampResp(paramString, paramTimeStampRequest);
      }
      catch (Exception paramTimeStampRequest)
      {
        throw new TSPException("Timestamp token received cannot be converted to ContentInfo", paramTimeStampRequest);
      }
      catch (TSPException paramTimeStampRequest)
      {
        label94:
        throw paramTimeStampRequest;
      }
    }
    try
    {
      paramTimeStampRequest = new TimeStampResponse(paramTimeStampRequest);
      return paramTimeStampRequest;
    }
    catch (IOException paramTimeStampRequest)
    {
      break label94;
    }
    throw new TSPException("created badly formatted response!");
    throw new TSPValidationException("The time source is not available.", 512);
  }
  
  public TimeStampResponse generateRejectedResponse(Exception paramException)
    throws TSPException
  {
    if ((paramException instanceof TSPValidationException)) {}
    for (int i = ((TSPValidationException)paramException).getFailureCode();; i = 1073741824) {
      return generateFailResponse(2, i, paramException.getMessage());
    }
  }
  
  class FailInfo
    extends DERBitString
  {
    FailInfo(int paramInt)
    {
      super(getPadBits(paramInt));
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\TimeStampResponseGenerator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */