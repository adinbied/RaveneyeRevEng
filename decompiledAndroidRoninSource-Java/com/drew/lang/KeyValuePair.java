package com.drew.lang;

import com.drew.metadata.StringValue;

public class KeyValuePair
{
  private final String _key;
  private final StringValue _value;
  
  public KeyValuePair(String paramString, StringValue paramStringValue)
  {
    this._key = paramString;
    this._value = paramStringValue;
  }
  
  public String getKey()
  {
    return this._key;
  }
  
  public StringValue getValue()
  {
    return this._value;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\lang\KeyValuePair.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */