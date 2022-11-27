package com.drew.lang;

import java.text.DecimalFormat;

public final class GeoLocation
{
  private final double _latitude;
  private final double _longitude;
  
  public GeoLocation(double paramDouble1, double paramDouble2)
  {
    this._latitude = paramDouble1;
    this._longitude = paramDouble2;
  }
  
  public static double[] decimalToDegreesMinutesSeconds(double paramDouble)
  {
    int i = (int)paramDouble;
    paramDouble = Math.abs(paramDouble % 1.0D * 60.0D);
    return new double[] { i, (int)paramDouble, paramDouble % 1.0D * 60.0D };
  }
  
  public static String decimalToDegreesMinutesSecondsString(double paramDouble)
  {
    double[] arrayOfDouble = decimalToDegreesMinutesSeconds(paramDouble);
    DecimalFormat localDecimalFormat = new DecimalFormat("0.##");
    return String.format("%s° %s' %s\"", new Object[] { localDecimalFormat.format(arrayOfDouble[0]), localDecimalFormat.format(arrayOfDouble[1]), localDecimalFormat.format(arrayOfDouble[2]) });
  }
  
  public static Double degreesMinutesSecondsToDecimal(Rational paramRational1, Rational paramRational2, Rational paramRational3, boolean paramBoolean)
  {
    double d2 = Math.abs(paramRational1.doubleValue()) + paramRational2.doubleValue() / 60.0D + paramRational3.doubleValue() / 3600.0D;
    if (Double.isNaN(d2)) {
      return null;
    }
    double d1 = d2;
    if (paramBoolean) {
      d1 = d2 * -1.0D;
    }
    return Double.valueOf(d1);
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public double getLatitude()
  {
    return this._latitude;
  }
  
  public double getLongitude()
  {
    return this._longitude;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isZero()
  {
    return false;
  }
  
  public String toDMSString()
  {
    return null;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\GeoLocation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */