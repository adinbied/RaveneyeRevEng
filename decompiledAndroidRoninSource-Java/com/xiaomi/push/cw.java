package com.xiaomi.push;

import org.json.JSONObject;

public class cw
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private long b;
  private long c;
  
  public cw()
  {
    this(0, 0L, 0L, null);
  }
  
  public cw(int paramInt, long paramLong1, long paramLong2, Exception paramException)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Long = paramLong1;
    this.c = paramLong2;
    this.b = System.currentTimeMillis();
    if (paramException != null) {
      this.jdField_a_of_type_JavaLangString = paramException.getClass().getSimpleName();
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public cw a(JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\cw.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */