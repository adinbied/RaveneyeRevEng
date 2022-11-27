package org.bouncycastle.asn1.ocsp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;

public class OCSPResponseStatus
  extends ASN1Object
{
  public static final int INTERNAL_ERROR = 2;
  public static final int MALFORMED_REQUEST = 1;
  public static final int SIG_REQUIRED = 5;
  public static final int SUCCESSFUL = 0;
  public static final int TRY_LATER = 3;
  public static final int UNAUTHORIZED = 6;
  private ASN1Enumerated value;
  
  public OCSPResponseStatus(int paramInt)
  {
    this(new ASN1Enumerated(paramInt));
  }
  
  private OCSPResponseStatus(ASN1Enumerated paramASN1Enumerated)
  {
    this.value = paramASN1Enumerated;
  }
  
  public static OCSPResponseStatus getInstance(Object paramObject)
  {
    if ((paramObject instanceof OCSPResponseStatus)) {
      return (OCSPResponseStatus)paramObject;
    }
    if (paramObject != null) {
      return new OCSPResponseStatus(ASN1Enumerated.getInstance(paramObject));
    }
    return null;
  }
  
  public BigInteger getValue()
  {
    return this.value.getValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\ocsp\OCSPResponseStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */