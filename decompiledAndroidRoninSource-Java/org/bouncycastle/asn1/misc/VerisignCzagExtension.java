package org.bouncycastle.asn1.misc;

import org.bouncycastle.asn1.DERIA5String;

public class VerisignCzagExtension
  extends DERIA5String
{
  public VerisignCzagExtension(DERIA5String paramDERIA5String)
  {
    super(paramDERIA5String.getString());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("VerisignCzagExtension: ");
    localStringBuilder.append(getString());
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\org\bouncycastle\asn1\misc\VerisignCzagExtension.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */