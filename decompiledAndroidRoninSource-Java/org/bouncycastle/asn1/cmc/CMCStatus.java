package org.bouncycastle.asn1.cmc;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class CMCStatus
  extends ASN1Object
{
  public static final CMCStatus confirmRequired;
  public static final CMCStatus failed;
  public static final CMCStatus noSupport;
  public static final CMCStatus partial;
  public static final CMCStatus pending;
  public static final CMCStatus popRequired;
  private static Map range;
  public static final CMCStatus success = new CMCStatus(new ASN1Integer(0L));
  private final ASN1Integer value;
  
  static
  {
    failed = new CMCStatus(new ASN1Integer(2L));
    pending = new CMCStatus(new ASN1Integer(3L));
    noSupport = new CMCStatus(new ASN1Integer(4L));
    confirmRequired = new CMCStatus(new ASN1Integer(5L));
    popRequired = new CMCStatus(new ASN1Integer(6L));
    partial = new CMCStatus(new ASN1Integer(7L));
    Object localObject = new HashMap();
    range = (Map)localObject;
    CMCStatus localCMCStatus = success;
    ((Map)localObject).put(localCMCStatus.value, localCMCStatus);
    localObject = range;
    localCMCStatus = failed;
    ((Map)localObject).put(localCMCStatus.value, localCMCStatus);
    localObject = range;
    localCMCStatus = pending;
    ((Map)localObject).put(localCMCStatus.value, localCMCStatus);
    localObject = range;
    localCMCStatus = noSupport;
    ((Map)localObject).put(localCMCStatus.value, localCMCStatus);
    localObject = range;
    localCMCStatus = confirmRequired;
    ((Map)localObject).put(localCMCStatus.value, localCMCStatus);
    localObject = range;
    localCMCStatus = popRequired;
    ((Map)localObject).put(localCMCStatus.value, localCMCStatus);
    localObject = range;
    localCMCStatus = partial;
    ((Map)localObject).put(localCMCStatus.value, localCMCStatus);
  }
  
  private CMCStatus(ASN1Integer paramASN1Integer)
  {
    this.value = paramASN1Integer;
  }
  
  public static CMCStatus getInstance(Object paramObject)
  {
    if ((paramObject instanceof CMCStatus)) {
      return (CMCStatus)paramObject;
    }
    if (paramObject != null)
    {
      Object localObject = (CMCStatus)range.get(ASN1Integer.getInstance(paramObject));
      if (localObject != null) {
        return (CMCStatus)localObject;
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\cmc\CMCStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */