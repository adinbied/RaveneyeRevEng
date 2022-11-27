package com.drew.metadata;

import com.drew.lang.Rational;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

public abstract class Directory
{
  private static final String _floatFormatPattern = "0.###";
  protected final Collection<Tag> _definedTagList = new ArrayList();
  protected TagDescriptor _descriptor;
  private final Collection<String> _errorList = new ArrayList(4);
  private Directory _parent;
  protected final Map<Integer, Object> _tagMap = new HashMap();
  
  public void addError(String paramString)
  {
    this._errorList.add(paramString);
  }
  
  public boolean containsTag(int paramInt)
  {
    return false;
  }
  
  public boolean getBoolean(int paramInt)
    throws MetadataException
  {
    return false;
  }
  
  public Boolean getBooleanObject(int paramInt)
  {
    return null;
  }
  
  public byte[] getByteArray(int paramInt)
  {
    return null;
  }
  
  public Date getDate(int paramInt)
  {
    return getDate(paramInt, null, null);
  }
  
  public Date getDate(int paramInt, String paramString, TimeZone paramTimeZone)
  {
    return null;
  }
  
  public Date getDate(int paramInt, TimeZone paramTimeZone)
  {
    return getDate(paramInt, null, paramTimeZone);
  }
  
  public String getDescription(int paramInt)
  {
    return this._descriptor.getDescription(paramInt);
  }
  
  public double getDouble(int paramInt)
    throws MetadataException
  {
    return 1.04283728E-315D;
  }
  
  public Double getDoubleObject(int paramInt)
  {
    return null;
  }
  
  public int getErrorCount()
  {
    return this._errorList.size();
  }
  
  public Iterable<String> getErrors()
  {
    return Collections.unmodifiableCollection(this._errorList);
  }
  
  public float getFloat(int paramInt)
    throws MetadataException
  {
    return 0.0F;
  }
  
  public Float getFloatObject(int paramInt)
  {
    return null;
  }
  
  public int getInt(int paramInt)
    throws MetadataException
  {
    return 0;
  }
  
  public int[] getIntArray(int paramInt)
  {
    return null;
  }
  
  public Integer getInteger(int paramInt)
  {
    return null;
  }
  
  public long getLong(int paramInt)
    throws MetadataException
  {
    return 211072750L;
  }
  
  public Long getLongObject(int paramInt)
  {
    return null;
  }
  
  public abstract String getName();
  
  public Object getObject(int paramInt)
  {
    return null;
  }
  
  public Directory getParent()
  {
    return this._parent;
  }
  
  public Rational getRational(int paramInt)
  {
    return null;
  }
  
  public Rational[] getRationalArray(int paramInt)
  {
    return null;
  }
  
  public String getString(int paramInt)
  {
    return null;
  }
  
  public String getString(int paramInt, String paramString)
  {
    return null;
  }
  
  public String[] getStringArray(int paramInt)
  {
    return null;
  }
  
  public StringValue getStringValue(int paramInt)
  {
    return null;
  }
  
  public StringValue[] getStringValueArray(int paramInt)
  {
    return null;
  }
  
  public int getTagCount()
  {
    return this._definedTagList.size();
  }
  
  public String getTagName(int paramInt)
  {
    return null;
  }
  
  protected abstract HashMap<Integer, String> getTagNameMap();
  
  public Collection<Tag> getTags()
  {
    return Collections.unmodifiableCollection(this._definedTagList);
  }
  
  public boolean hasErrors()
  {
    return false;
  }
  
  public boolean hasTagName(int paramInt)
  {
    return false;
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public void setBoolean(int paramInt, boolean paramBoolean)
  {
    setObject(paramInt, Boolean.valueOf(paramBoolean));
  }
  
  public void setByteArray(int paramInt, byte[] paramArrayOfByte)
  {
    setObjectArray(paramInt, paramArrayOfByte);
  }
  
  public void setDate(int paramInt, Date paramDate)
  {
    setObject(paramInt, paramDate);
  }
  
  /* Error */
  public void setDescriptor(TagDescriptor arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setDouble(int paramInt, double paramDouble)
  {
    setObject(paramInt, Double.valueOf(paramDouble));
  }
  
  public void setDoubleArray(int paramInt, double[] paramArrayOfDouble)
  {
    setObjectArray(paramInt, paramArrayOfDouble);
  }
  
  public void setFloat(int paramInt, float paramFloat)
  {
    setObject(paramInt, Float.valueOf(paramFloat));
  }
  
  public void setFloatArray(int paramInt, float[] paramArrayOfFloat)
  {
    setObjectArray(paramInt, paramArrayOfFloat);
  }
  
  public void setInt(int paramInt1, int paramInt2)
  {
    setObject(paramInt1, Integer.valueOf(paramInt2));
  }
  
  public void setIntArray(int paramInt, int[] paramArrayOfInt)
  {
    setObjectArray(paramInt, paramArrayOfInt);
  }
  
  public void setLong(int paramInt, long paramLong)
  {
    setObject(paramInt, Long.valueOf(paramLong));
  }
  
  /* Error */
  public void setObject(int arg1, Object arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  public void setObjectArray(int paramInt, Object paramObject)
  {
    setObject(paramInt, paramObject);
  }
  
  public void setParent(Directory paramDirectory)
  {
    this._parent = paramDirectory;
  }
  
  public void setRational(int paramInt, Rational paramRational)
  {
    setObject(paramInt, paramRational);
  }
  
  public void setRationalArray(int paramInt, Rational[] paramArrayOfRational)
  {
    setObjectArray(paramInt, paramArrayOfRational);
  }
  
  public void setString(int paramInt, String paramString)
  {
    if (paramString != null)
    {
      setObject(paramInt, paramString);
      return;
    }
    throw new NullPointerException("cannot set a null String");
  }
  
  public void setStringArray(int paramInt, String[] paramArrayOfString)
  {
    setObjectArray(paramInt, paramArrayOfString);
  }
  
  public void setStringValue(int paramInt, StringValue paramStringValue)
  {
    if (paramStringValue != null)
    {
      setObject(paramInt, paramStringValue);
      return;
    }
    throw new NullPointerException("cannot set a null StringValue");
  }
  
  public void setStringValueArray(int paramInt, StringValue[] paramArrayOfStringValue)
  {
    setObjectArray(paramInt, paramArrayOfStringValue);
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\Directory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */