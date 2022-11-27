package org.bouncycastle.asn1.cmc;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class OtherStatusInfo
  extends ASN1Object
  implements ASN1Choice
{
  private final ExtendedFailInfo extendedFailInfo;
  private final CMCFailInfo failInfo;
  private final PendInfo pendInfo;
  
  OtherStatusInfo(CMCFailInfo paramCMCFailInfo)
  {
    this(paramCMCFailInfo, null, null);
  }
  
  private OtherStatusInfo(CMCFailInfo paramCMCFailInfo, PendInfo paramPendInfo, ExtendedFailInfo paramExtendedFailInfo)
  {
    this.failInfo = paramCMCFailInfo;
    this.pendInfo = paramPendInfo;
    this.extendedFailInfo = paramExtendedFailInfo;
  }
  
  OtherStatusInfo(ExtendedFailInfo paramExtendedFailInfo)
  {
    this(null, null, paramExtendedFailInfo);
  }
  
  OtherStatusInfo(PendInfo paramPendInfo)
  {
    this(null, paramPendInfo, null);
  }
  
  public static OtherStatusInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof OtherStatusInfo)) {
      return (OtherStatusInfo)paramObject;
    }
    if ((paramObject instanceof ASN1Encodable))
    {
      localObject = ((ASN1Encodable)paramObject).toASN1Primitive();
      if ((localObject instanceof ASN1Integer)) {
        return new OtherStatusInfo(CMCFailInfo.getInstance(localObject));
      }
      if ((localObject instanceof ASN1Sequence))
      {
        if ((((ASN1Sequence)localObject).getObjectAt(0) instanceof ASN1ObjectIdentifier)) {
          return new OtherStatusInfo(ExtendedFailInfo.getInstance(localObject));
        }
        return new OtherStatusInfo(PendInfo.getInstance(localObject));
      }
    }
    else if ((paramObject instanceof byte[]))
    {
      try
      {
        paramObject = getInstance(ASN1Primitive.fromByteArray((byte[])paramObject));
        return (OtherStatusInfo)paramObject;
      }
      catch (IOException paramObject)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("parsing error: ");
        ((StringBuilder)localObject).append(((IOException)paramObject).getMessage());
        throw new IllegalArgumentException(((StringBuilder)localObject).toString());
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unknown object in getInstance(): ");
    ((StringBuilder)localObject).append(paramObject.getClass().getName());
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public boolean isExtendedFailInfo()
  {
    return this.extendedFailInfo != null;
  }
  
  public boolean isFailInfo()
  {
    return this.failInfo != null;
  }
  
  public boolean isPendingInfo()
  {
    return this.pendInfo != null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    Object localObject = this.pendInfo;
    if (localObject != null) {
      return ((PendInfo)localObject).toASN1Primitive();
    }
    localObject = this.failInfo;
    if (localObject != null) {
      return ((CMCFailInfo)localObject).toASN1Primitive();
    }
    return this.extendedFailInfo.toASN1Primitive();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\OtherStatusInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */