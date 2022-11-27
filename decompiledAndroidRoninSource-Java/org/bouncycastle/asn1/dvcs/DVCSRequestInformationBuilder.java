package org.bouncycastle.asn1.dvcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.PolicyInformation;
import org.bouncycastle.util.BigIntegers;

public class DVCSRequestInformationBuilder
{
  private static final int DEFAULT_VERSION = 1;
  private static final int TAG_DATA_LOCATIONS = 3;
  private static final int TAG_DVCS = 2;
  private static final int TAG_EXTENSIONS = 4;
  private static final int TAG_REQUESTER = 0;
  private static final int TAG_REQUEST_POLICY = 1;
  private GeneralNames dataLocations;
  private GeneralNames dvcs;
  private Extensions extensions;
  private DVCSRequestInformation initialInfo;
  private BigInteger nonce;
  private PolicyInformation requestPolicy;
  private DVCSTime requestTime;
  private GeneralNames requester;
  private final ServiceType service;
  private int version = 1;
  
  public DVCSRequestInformationBuilder(DVCSRequestInformation paramDVCSRequestInformation)
  {
    this.initialInfo = paramDVCSRequestInformation;
    this.service = paramDVCSRequestInformation.getService();
    this.version = paramDVCSRequestInformation.getVersion();
    this.nonce = paramDVCSRequestInformation.getNonce();
    this.requestTime = paramDVCSRequestInformation.getRequestTime();
    this.requestPolicy = paramDVCSRequestInformation.getRequestPolicy();
    this.dvcs = paramDVCSRequestInformation.getDVCS();
    this.dataLocations = paramDVCSRequestInformation.getDataLocations();
  }
  
  public DVCSRequestInformationBuilder(ServiceType paramServiceType)
  {
    this.service = paramServiceType;
  }
  
  public DVCSRequestInformation build()
  {
    ASN1EncodableVector localASN1EncodableVector = new ASN1EncodableVector();
    int i = this.version;
    if (i != 1) {
      localASN1EncodableVector.add(new ASN1Integer(i));
    }
    localASN1EncodableVector.add(this.service);
    Object localObject = this.nonce;
    if (localObject != null) {
      localASN1EncodableVector.add(new ASN1Integer((BigInteger)localObject));
    }
    localObject = this.requestTime;
    if (localObject != null) {
      localASN1EncodableVector.add((ASN1Encodable)localObject);
    }
    localObject = this.requester;
    PolicyInformation localPolicyInformation = this.requestPolicy;
    GeneralNames localGeneralNames1 = this.dvcs;
    GeneralNames localGeneralNames2 = this.dataLocations;
    Extensions localExtensions = this.extensions;
    i = 0;
    while (i < 5)
    {
      int j = new int[] { 0, 1, 2, 3, 4 }[i];
      ASN1Encodable localASN1Encodable = new ASN1Encodable[] { localObject, localPolicyInformation, localGeneralNames1, localGeneralNames2, localExtensions }[i];
      if (localASN1Encodable != null) {
        localASN1EncodableVector.add(new DERTaggedObject(false, j, localASN1Encodable));
      }
      i += 1;
    }
    return DVCSRequestInformation.getInstance(new DERSequence(localASN1EncodableVector));
  }
  
  public void setDVCS(GeneralName paramGeneralName)
  {
    setDVCS(new GeneralNames(paramGeneralName));
  }
  
  public void setDVCS(GeneralNames paramGeneralNames)
  {
    this.dvcs = paramGeneralNames;
  }
  
  public void setDataLocations(GeneralName paramGeneralName)
  {
    setDataLocations(new GeneralNames(paramGeneralName));
  }
  
  public void setDataLocations(GeneralNames paramGeneralNames)
  {
    this.dataLocations = paramGeneralNames;
  }
  
  public void setExtensions(Extensions paramExtensions)
  {
    if (this.initialInfo == null)
    {
      this.extensions = paramExtensions;
      return;
    }
    throw new IllegalStateException("cannot change extensions in existing DVCSRequestInformation");
  }
  
  public void setNonce(BigInteger paramBigInteger)
  {
    Object localObject = this.initialInfo;
    if (localObject != null) {
      if (((DVCSRequestInformation)localObject).getNonce() == null)
      {
        this.nonce = paramBigInteger;
      }
      else
      {
        localObject = this.initialInfo.getNonce().toByteArray();
        byte[] arrayOfByte1 = BigIntegers.asUnsignedByteArray(paramBigInteger);
        byte[] arrayOfByte2 = new byte[localObject.length + arrayOfByte1.length];
        System.arraycopy(localObject, 0, arrayOfByte2, 0, localObject.length);
        System.arraycopy(arrayOfByte1, 0, arrayOfByte2, localObject.length, arrayOfByte1.length);
        this.nonce = new BigInteger(arrayOfByte2);
      }
    }
    this.nonce = paramBigInteger;
  }
  
  public void setRequestPolicy(PolicyInformation paramPolicyInformation)
  {
    if (this.initialInfo == null)
    {
      this.requestPolicy = paramPolicyInformation;
      return;
    }
    throw new IllegalStateException("cannot change request policy in existing DVCSRequestInformation");
  }
  
  public void setRequestTime(DVCSTime paramDVCSTime)
  {
    if (this.initialInfo == null)
    {
      this.requestTime = paramDVCSTime;
      return;
    }
    throw new IllegalStateException("cannot change request time in existing DVCSRequestInformation");
  }
  
  public void setRequester(GeneralName paramGeneralName)
  {
    setRequester(new GeneralNames(paramGeneralName));
  }
  
  public void setRequester(GeneralNames paramGeneralNames)
  {
    this.requester = paramGeneralNames;
  }
  
  public void setVersion(int paramInt)
  {
    if (this.initialInfo == null)
    {
      this.version = paramInt;
      return;
    }
    throw new IllegalStateException("cannot change version in existing DVCSRequestInformation");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\DVCSRequestInformationBuilder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */