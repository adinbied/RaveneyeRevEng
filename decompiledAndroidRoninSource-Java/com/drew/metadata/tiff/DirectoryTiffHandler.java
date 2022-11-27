package com.drew.metadata.tiff;

import com.drew.imaging.tiff.TiffHandler;
import com.drew.lang.Rational;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.StringValue;
import java.util.Stack;

public abstract class DirectoryTiffHandler
  implements TiffHandler
{
  protected Directory _currentDirectory;
  private final Stack<Directory> _directoryStack = new Stack();
  protected final Metadata _metadata;
  
  protected DirectoryTiffHandler(Metadata paramMetadata)
  {
    this._metadata = paramMetadata;
  }
  
  private Directory getCurrentOrErrorDirectory()
  {
    return null;
  }
  
  /* Error */
  public void endingIFD()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void error(String paramString)
  {
    getCurrentOrErrorDirectory().addError(paramString);
  }
  
  /* Error */
  protected void pushDirectory(Class<? extends Directory> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void setByteArray(int paramInt, byte[] paramArrayOfByte)
  {
    this._currentDirectory.setByteArray(paramInt, paramArrayOfByte);
  }
  
  public void setDouble(int paramInt, double paramDouble)
  {
    this._currentDirectory.setDouble(paramInt, paramDouble);
  }
  
  public void setDoubleArray(int paramInt, double[] paramArrayOfDouble)
  {
    this._currentDirectory.setDoubleArray(paramInt, paramArrayOfDouble);
  }
  
  public void setFloat(int paramInt, float paramFloat)
  {
    this._currentDirectory.setFloat(paramInt, paramFloat);
  }
  
  public void setFloatArray(int paramInt, float[] paramArrayOfFloat)
  {
    this._currentDirectory.setFloatArray(paramInt, paramArrayOfFloat);
  }
  
  public void setInt16s(int paramInt1, int paramInt2)
  {
    this._currentDirectory.setInt(paramInt1, paramInt2);
  }
  
  public void setInt16sArray(int paramInt, short[] paramArrayOfShort)
  {
    this._currentDirectory.setObjectArray(paramInt, paramArrayOfShort);
  }
  
  public void setInt16u(int paramInt1, int paramInt2)
  {
    this._currentDirectory.setInt(paramInt1, paramInt2);
  }
  
  public void setInt16uArray(int paramInt, int[] paramArrayOfInt)
  {
    this._currentDirectory.setObjectArray(paramInt, paramArrayOfInt);
  }
  
  public void setInt32s(int paramInt1, int paramInt2)
  {
    this._currentDirectory.setInt(paramInt1, paramInt2);
  }
  
  public void setInt32sArray(int paramInt, int[] paramArrayOfInt)
  {
    this._currentDirectory.setIntArray(paramInt, paramArrayOfInt);
  }
  
  public void setInt32u(int paramInt, long paramLong)
  {
    this._currentDirectory.setLong(paramInt, paramLong);
  }
  
  public void setInt32uArray(int paramInt, long[] paramArrayOfLong)
  {
    this._currentDirectory.setObjectArray(paramInt, paramArrayOfLong);
  }
  
  public void setInt8s(int paramInt, byte paramByte)
  {
    this._currentDirectory.setInt(paramInt, paramByte);
  }
  
  public void setInt8sArray(int paramInt, byte[] paramArrayOfByte)
  {
    this._currentDirectory.setByteArray(paramInt, paramArrayOfByte);
  }
  
  public void setInt8u(int paramInt, short paramShort)
  {
    this._currentDirectory.setInt(paramInt, paramShort);
  }
  
  public void setInt8uArray(int paramInt, short[] paramArrayOfShort)
  {
    this._currentDirectory.setObjectArray(paramInt, paramArrayOfShort);
  }
  
  public void setRational(int paramInt, Rational paramRational)
  {
    this._currentDirectory.setRational(paramInt, paramRational);
  }
  
  public void setRationalArray(int paramInt, Rational[] paramArrayOfRational)
  {
    this._currentDirectory.setRationalArray(paramInt, paramArrayOfRational);
  }
  
  public void setString(int paramInt, StringValue paramStringValue)
  {
    this._currentDirectory.setStringValue(paramInt, paramStringValue);
  }
  
  public void warn(String paramString)
  {
    getCurrentOrErrorDirectory().addError(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\tiff\DirectoryTiffHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */