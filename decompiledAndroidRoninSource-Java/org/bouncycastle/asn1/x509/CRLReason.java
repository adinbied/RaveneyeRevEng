package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Hashtable;
import org.bouncycastle.asn1.ASN1Enumerated;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.util.Integers;

public class CRLReason
  extends ASN1Object
{
  public static final int AA_COMPROMISE = 10;
  public static final int AFFILIATION_CHANGED = 3;
  public static final int CA_COMPROMISE = 2;
  public static final int CERTIFICATE_HOLD = 6;
  public static final int CESSATION_OF_OPERATION = 5;
  public static final int KEY_COMPROMISE = 1;
  public static final int PRIVILEGE_WITHDRAWN = 9;
  public static final int REMOVE_FROM_CRL = 8;
  public static final int SUPERSEDED = 4;
  public static final int UNSPECIFIED = 0;
  public static final int aACompromise = 10;
  public static final int affiliationChanged = 3;
  public static final int cACompromise = 2;
  public static final int certificateHold = 6;
  public static final int cessationOfOperation = 5;
  public static final int keyCompromise = 1;
  public static final int privilegeWithdrawn = 9;
  private static final String[] reasonString = { "unspecified", "keyCompromise", "cACompromise", "affiliationChanged", "superseded", "cessationOfOperation", "certificateHold", "unknown", "removeFromCRL", "privilegeWithdrawn", "aACompromise" };
  public static final int removeFromCRL = 8;
  public static final int superseded = 4;
  private static final Hashtable table = new Hashtable();
  public static final int unspecified = 0;
  private ASN1Enumerated value;
  
  private CRLReason(int paramInt)
  {
    this.value = new ASN1Enumerated(paramInt);
  }
  
  public static CRLReason getInstance(Object paramObject)
  {
    if ((paramObject instanceof CRLReason)) {
      return (CRLReason)paramObject;
    }
    if (paramObject != null) {
      return lookup(ASN1Enumerated.getInstance(paramObject).getValue().intValue());
    }
    return null;
  }
  
  public static CRLReason lookup(int paramInt)
  {
    Integer localInteger = Integers.valueOf(paramInt);
    if (!table.containsKey(localInteger)) {
      table.put(localInteger, new CRLReason(paramInt));
    }
    return (CRLReason)table.get(localInteger);
  }
  
  public BigInteger getValue()
  {
    return this.value.getValue();
  }
  
  public ASN1Primitive toASN1Primitive()
  {
    return this.value;
  }
  
  public String toString()
  {
    int i = getValue().intValue();
    String str;
    if ((i >= 0) && (i <= 10)) {
      str = reasonString[i];
    } else {
      str = "invalid";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CRLReason: ");
    localStringBuilder.append(str);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\org\bouncycastle\asn1\x509\CRLReason.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */