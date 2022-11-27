package org.bouncycastle.tsp;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.tsp.Accuracy;

public class GenTimeAccuracy
{
  private Accuracy accuracy;
  
  public GenTimeAccuracy(Accuracy paramAccuracy)
  {
    this.accuracy = paramAccuracy;
  }
  
  private String format(int paramInt)
  {
    StringBuilder localStringBuilder;
    if (paramInt < 10) {
      localStringBuilder = new StringBuilder();
    }
    for (String str = "00";; str = "0")
    {
      localStringBuilder.append(str);
      localStringBuilder.append(paramInt);
      return localStringBuilder.toString();
      if (paramInt >= 100) {
        break;
      }
      localStringBuilder = new StringBuilder();
    }
    return Integer.toString(paramInt);
  }
  
  private int getTimeComponent(ASN1Integer paramASN1Integer)
  {
    if (paramASN1Integer != null) {
      return paramASN1Integer.getValue().intValue();
    }
    return 0;
  }
  
  public int getMicros()
  {
    return getTimeComponent(this.accuracy.getMicros());
  }
  
  public int getMillis()
  {
    return getTimeComponent(this.accuracy.getMillis());
  }
  
  public int getSeconds()
  {
    return getTimeComponent(this.accuracy.getSeconds());
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(getSeconds());
    localStringBuilder.append(".");
    localStringBuilder.append(format(getMillis()));
    localStringBuilder.append(format(getMicros()));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\tsp\GenTimeAccuracy.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */