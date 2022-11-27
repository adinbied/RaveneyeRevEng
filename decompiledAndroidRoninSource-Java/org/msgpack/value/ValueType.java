package org.msgpack.value;

public enum ValueType
{
  private final boolean numberType;
  private final boolean rawType;
  
  static
  {
    BOOLEAN = new ValueType("BOOLEAN", 1, false, false);
    INTEGER = new ValueType("INTEGER", 2, true, false);
    FLOAT = new ValueType("FLOAT", 3, true, false);
    STRING = new ValueType("STRING", 4, false, true);
    BINARY = new ValueType("BINARY", 5, false, true);
    ARRAY = new ValueType("ARRAY", 6, false, false);
    MAP = new ValueType("MAP", 7, false, false);
    ValueType localValueType = new ValueType("EXTENSION", 8, false, false);
    EXTENSION = localValueType;
    $VALUES = new ValueType[] { NIL, BOOLEAN, INTEGER, FLOAT, STRING, BINARY, ARRAY, MAP, localValueType };
  }
  
  private ValueType(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.numberType = paramBoolean1;
    this.rawType = paramBoolean2;
  }
  
  public boolean isArrayType()
  {
    return this == ARRAY;
  }
  
  public boolean isBinaryType()
  {
    return this == BINARY;
  }
  
  public boolean isBooleanType()
  {
    return this == BOOLEAN;
  }
  
  public boolean isExtensionType()
  {
    return this == EXTENSION;
  }
  
  public boolean isFloatType()
  {
    return this == FLOAT;
  }
  
  public boolean isIntegerType()
  {
    return this == INTEGER;
  }
  
  public boolean isMapType()
  {
    return this == MAP;
  }
  
  public boolean isNilType()
  {
    return this == NIL;
  }
  
  public boolean isNumberType()
  {
    return this.numberType;
  }
  
  public boolean isRawType()
  {
    return this.rawType;
  }
  
  public boolean isStringType()
  {
    return this == STRING;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\msgpack\value\ValueType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */