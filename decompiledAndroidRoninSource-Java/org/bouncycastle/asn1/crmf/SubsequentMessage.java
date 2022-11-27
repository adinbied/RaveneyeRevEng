package org.bouncycastle.asn1.crmf;

import org.bouncycastle.asn1.ASN1Integer;

public class SubsequentMessage
  extends ASN1Integer
{
  public static final SubsequentMessage challengeResp = new SubsequentMessage(1);
  public static final SubsequentMessage encrCert = new SubsequentMessage(0);
  
  private SubsequentMessage(int paramInt)
  {
    super(paramInt);
  }
  
  public static SubsequentMessage valueOf(int paramInt)
  {
    if (paramInt == 0) {
      return encrCert;
    }
    if (paramInt == 1) {
      return challengeResp;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unknown value: ");
    localStringBuilder.append(paramInt);
    throw new IllegalArgumentException(localStringBuilder.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\crmf\SubsequentMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */