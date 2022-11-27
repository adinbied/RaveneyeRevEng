package com.drew.imaging.tiff;

import com.drew.lang.RandomAccessReader;
import com.drew.lang.Rational;
import com.drew.metadata.StringValue;
import java.io.IOException;
import java.util.Set;

public abstract interface TiffHandler
{
  public abstract boolean customProcessTag(int paramInt1, Set<Integer> paramSet, int paramInt2, RandomAccessReader paramRandomAccessReader, int paramInt3, int paramInt4)
    throws IOException;
  
  public abstract void endingIFD();
  
  public abstract void error(String paramString);
  
  public abstract boolean hasFollowerIfd();
  
  public abstract void setByteArray(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void setDouble(int paramInt, double paramDouble);
  
  public abstract void setDoubleArray(int paramInt, double[] paramArrayOfDouble);
  
  public abstract void setFloat(int paramInt, float paramFloat);
  
  public abstract void setFloatArray(int paramInt, float[] paramArrayOfFloat);
  
  public abstract void setInt16s(int paramInt1, int paramInt2);
  
  public abstract void setInt16sArray(int paramInt, short[] paramArrayOfShort);
  
  public abstract void setInt16u(int paramInt1, int paramInt2);
  
  public abstract void setInt16uArray(int paramInt, int[] paramArrayOfInt);
  
  public abstract void setInt32s(int paramInt1, int paramInt2);
  
  public abstract void setInt32sArray(int paramInt, int[] paramArrayOfInt);
  
  public abstract void setInt32u(int paramInt, long paramLong);
  
  public abstract void setInt32uArray(int paramInt, long[] paramArrayOfLong);
  
  public abstract void setInt8s(int paramInt, byte paramByte);
  
  public abstract void setInt8sArray(int paramInt, byte[] paramArrayOfByte);
  
  public abstract void setInt8u(int paramInt, short paramShort);
  
  public abstract void setInt8uArray(int paramInt, short[] paramArrayOfShort);
  
  public abstract void setRational(int paramInt, Rational paramRational);
  
  public abstract void setRationalArray(int paramInt, Rational[] paramArrayOfRational);
  
  public abstract void setString(int paramInt, StringValue paramStringValue);
  
  public abstract void setTiffMarker(int paramInt)
    throws TiffProcessingException;
  
  public abstract Long tryCustomProcessFormat(int paramInt1, int paramInt2, long paramLong);
  
  public abstract boolean tryEnterSubIfd(int paramInt);
  
  public abstract void warn(String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\tiff\TiffHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */