package org.bouncycastle.asn1.dvcs;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1GeneralizedTime;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.x509.Extensions;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.PolicyInformation;

public class DVCSRequestInformation
  extends ASN1Object
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
  private BigInteger nonce;
  private PolicyInformation requestPolicy;
  private DVCSTime requestTime;
  private GeneralNames requester;
  private ServiceType service;
  private int version = 1;
  
  private DVCSRequestInformation(ASN1Sequence paramASN1Sequence)
  {
    if ((paramASN1Sequence.getObjectAt(0) instanceof ASN1Integer))
    {
      this.version = ASN1Integer.getInstance(paramASN1Sequence.getObjectAt(0)).getValue().intValue();
      i = 1;
    }
    else
    {
      this.version = 1;
      i = 0;
    }
    int j = i + 1;
    this.service = ServiceType.getInstance(paramASN1Sequence.getObjectAt(i));
    int i = j;
    while (i < paramASN1Sequence.size())
    {
      Object localObject = paramASN1Sequence.getObjectAt(i);
      if ((localObject instanceof ASN1Integer))
      {
        this.nonce = ASN1Integer.getInstance(localObject).getValue();
      }
      else
      {
        if ((localObject instanceof ASN1GeneralizedTime)) {}
        while (!(localObject instanceof ASN1TaggedObject))
        {
          this.requestTime = DVCSTime.getInstance(localObject);
          break;
        }
        localObject = ASN1TaggedObject.getInstance(localObject);
        j = ((ASN1TaggedObject)localObject).getTagNo();
        if (j != 0)
        {
          if (j != 1)
          {
            if (j != 2)
            {
              if (j != 3)
              {
                if (j == 4)
                {
                  this.extensions = Extensions.getInstance((ASN1TaggedObject)localObject, false);
                }
                else
                {
                  paramASN1Sequence = new StringBuilder();
                  paramASN1Sequence.append("unknown tag number encountered: ");
                  paramASN1Sequence.append(j);
                  throw new IllegalArgumentException(paramASN1Sequence.toString());
                }
              }
              else {
                this.dataLocations = GeneralNames.getInstance((ASN1TaggedObject)localObject, false);
              }
            }
            else {
              this.dvcs = GeneralNames.getInstance((ASN1TaggedObject)localObject, false);
            }
          }
          else {
            this.requestPolicy = PolicyInformation.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject)localObject, false));
          }
        }
        else {
          this.requester = GeneralNames.getInstance((ASN1TaggedObject)localObject, false);
        }
      }
      i += 1;
    }
  }
  
  public static DVCSRequestInformation getInstance(Object paramObject)
  {
    if ((paramObject instanceof DVCSRequestInformation)) {
      return (DVCSRequestInformation)paramObject;
    }
    if (paramObject != null) {
      return new DVCSRequestInformation(ASN1Sequence.getInstance(paramObject));
    }
    return null;
  }
  
  public static DVCSRequestInformation getInstance(ASN1TaggedObject paramASN1TaggedObject, boolean paramBoolean)
  {
    return getInstance(ASN1Sequence.getInstance(paramASN1TaggedObject, paramBoolean));
  }
  
  public GeneralNames getDVCS()
  {
    return this.dvcs;
  }
  
  public GeneralNames getDataLocations()
  {
    return this.dataLocations;
  }
  
  public Extensions getExtensions()
  {
    return this.extensions;
  }
  
  public BigInteger getNonce()
  {
    return this.nonce;
  }
  
  public PolicyInformation getRequestPolicy()
  {
    return this.requestPolicy;
  }
  
  public DVCSTime getRequestTime()
  {
    return this.requestTime;
  }
  
  public GeneralNames getRequester()
  {
    return this.requester;
  }
  
  public ServiceType getService()
  {
    return this.service;
  }
  
  public int getVersion()
  {
    return this.version;
  }
  
  public ASN1Primitive toASN1Primitive()
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
    return new DERSequence(localASN1EncodableVector);
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("DVCSRequestInformation {\n");
    if (this.version != 1)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("version: ");
      localStringBuilder.append(this.version);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("service: ");
    localStringBuilder.append(this.service);
    localStringBuilder.append("\n");
    localStringBuffer.append(localStringBuilder.toString());
    if (this.nonce != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("nonce: ");
      localStringBuilder.append(this.nonce);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.requestTime != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestTime: ");
      localStringBuilder.append(this.requestTime);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.requester != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requester: ");
      localStringBuilder.append(this.requester);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.requestPolicy != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("requestPolicy: ");
      localStringBuilder.append(this.requestPolicy);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.dvcs != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dvcs: ");
      localStringBuilder.append(this.dvcs);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.dataLocations != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("dataLocations: ");
      localStringBuilder.append(this.dataLocations);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    if (this.extensions != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("extensions: ");
      localStringBuilder.append(this.extensions);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    localStringBuffer.append("}\n");
    return localStringBuffer.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\dvcs\DVCSRequestInformation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */