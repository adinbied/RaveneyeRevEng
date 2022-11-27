package org.bouncycastle.asn1.cmc;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class CMCFailInfo
  extends ASN1Object
{
  public static final CMCFailInfo authDataFail;
  public static final CMCFailInfo badAlg = new CMCFailInfo(new ASN1Integer(0L));
  public static final CMCFailInfo badCertId;
  public static final CMCFailInfo badIdentity;
  public static final CMCFailInfo badMessageCheck = new CMCFailInfo(new ASN1Integer(1L));
  public static final CMCFailInfo badRequest = new CMCFailInfo(new ASN1Integer(2L));
  public static final CMCFailInfo badTime = new CMCFailInfo(new ASN1Integer(3L));
  public static final CMCFailInfo internalCAError;
  public static final CMCFailInfo mustArchiveKeys;
  public static final CMCFailInfo noKeyReuse;
  public static final CMCFailInfo popFailed;
  public static final CMCFailInfo popRequired;
  private static Map range;
  public static final CMCFailInfo tryLater;
  public static final CMCFailInfo unsupportedExt;
  private final ASN1Integer value;
  
  static
  {
    badCertId = new CMCFailInfo(new ASN1Integer(4L));
    unsupportedExt = new CMCFailInfo(new ASN1Integer(5L));
    mustArchiveKeys = new CMCFailInfo(new ASN1Integer(6L));
    badIdentity = new CMCFailInfo(new ASN1Integer(7L));
    popRequired = new CMCFailInfo(new ASN1Integer(8L));
    popFailed = new CMCFailInfo(new ASN1Integer(9L));
    noKeyReuse = new CMCFailInfo(new ASN1Integer(10L));
    internalCAError = new CMCFailInfo(new ASN1Integer(11L));
    tryLater = new CMCFailInfo(new ASN1Integer(12L));
    authDataFail = new CMCFailInfo(new ASN1Integer(13L));
    Object localObject = new HashMap();
    range = (Map)localObject;
    CMCFailInfo localCMCFailInfo = badAlg;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = badMessageCheck;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = badRequest;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = badTime;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = badCertId;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = popRequired;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = unsupportedExt;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = mustArchiveKeys;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = badIdentity;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = popRequired;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = popFailed;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = badCertId;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = popRequired;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = noKeyReuse;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = internalCAError;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = tryLater;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
    localObject = range;
    localCMCFailInfo = authDataFail;
    ((Map)localObject).put(localCMCFailInfo.value, localCMCFailInfo);
  }
  
  private CMCFailInfo(ASN1Integer paramASN1Integer)
  {
    this.value = paramASN1Integer;
  }
  
  public static CMCFailInfo getInstance(Object paramObject)
  {
    if ((paramObject instanceof CMCFailInfo)) {
      return (CMCFailInfo)paramObject;
    }
    if (paramObject != null)
    {
      Object localObject = (CMCFailInfo)range.get(ASN1Integer.getInstance(paramObject));
      if (localObject != null) {
        return (CMCFailInfo)localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unknown object in getInstance(): ");
      ((StringBuilder)localObject).append(paramObject.getClass().getName());
      throw new IllegalArgumentException(((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\CMCFailInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */