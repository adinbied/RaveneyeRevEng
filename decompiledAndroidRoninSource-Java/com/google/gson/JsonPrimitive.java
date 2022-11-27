package com.google.gson;

import com.google.gson.internal..Gson.Preconditions;
import com.google.gson.internal.LazilyParsedNumber;
import java.math.BigDecimal;
import java.math.BigInteger;

public final class JsonPrimitive
  extends JsonElement
{
  private final Object value;
  
  public JsonPrimitive(Boolean paramBoolean)
  {
    this.value = .Gson.Preconditions.checkNotNull(paramBoolean);
  }
  
  public JsonPrimitive(Character paramCharacter)
  {
    this.value = ((Character).Gson.Preconditions.checkNotNull(paramCharacter)).toString();
  }
  
  public JsonPrimitive(Number paramNumber)
  {
    this.value = .Gson.Preconditions.checkNotNull(paramNumber);
  }
  
  public JsonPrimitive(String paramString)
  {
    this.value = .Gson.Preconditions.checkNotNull(paramString);
  }
  
  private static boolean isIntegral(JsonPrimitive paramJsonPrimitive)
  {
    paramJsonPrimitive = paramJsonPrimitive.value;
    boolean bool3 = paramJsonPrimitive instanceof Number;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (bool3)
    {
      paramJsonPrimitive = (Number)paramJsonPrimitive;
      if ((!(paramJsonPrimitive instanceof BigInteger)) && (!(paramJsonPrimitive instanceof Long)) && (!(paramJsonPrimitive instanceof Integer)) && (!(paramJsonPrimitive instanceof Short)))
      {
        bool1 = bool2;
        if (!(paramJsonPrimitive instanceof Byte)) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public JsonPrimitive deepCopy()
  {
    return this;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool = true;
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (JsonPrimitive)paramObject;
      if (this.value == null) {
        return ((JsonPrimitive)paramObject).value == null;
      }
      if ((isIntegral(this)) && (isIntegral((JsonPrimitive)paramObject))) {
        return getAsNumber().longValue() == ((JsonPrimitive)paramObject).getAsNumber().longValue();
      }
      if (((this.value instanceof Number)) && ((((JsonPrimitive)paramObject).value instanceof Number)))
      {
        double d1 = getAsNumber().doubleValue();
        double d2 = ((JsonPrimitive)paramObject).getAsNumber().doubleValue();
        if (d1 != d2)
        {
          if ((Double.isNaN(d1)) && (Double.isNaN(d2))) {
            return true;
          }
          bool = false;
        }
        return bool;
      }
      return this.value.equals(((JsonPrimitive)paramObject).value);
    }
    return false;
  }
  
  public BigDecimal getAsBigDecimal()
  {
    Object localObject = this.value;
    if ((localObject instanceof BigDecimal)) {
      return (BigDecimal)localObject;
    }
    return new BigDecimal(this.value.toString());
  }
  
  public BigInteger getAsBigInteger()
  {
    Object localObject = this.value;
    if ((localObject instanceof BigInteger)) {
      return (BigInteger)localObject;
    }
    return new BigInteger(this.value.toString());
  }
  
  public boolean getAsBoolean()
  {
    if (isBoolean()) {
      return ((Boolean)this.value).booleanValue();
    }
    return Boolean.parseBoolean(getAsString());
  }
  
  public byte getAsByte()
  {
    if (isNumber()) {
      return getAsNumber().byteValue();
    }
    return Byte.parseByte(getAsString());
  }
  
  public char getAsCharacter()
  {
    return getAsString().charAt(0);
  }
  
  public double getAsDouble()
  {
    if (isNumber()) {
      return getAsNumber().doubleValue();
    }
    return Double.parseDouble(getAsString());
  }
  
  public float getAsFloat()
  {
    if (isNumber()) {
      return getAsNumber().floatValue();
    }
    return Float.parseFloat(getAsString());
  }
  
  public int getAsInt()
  {
    if (isNumber()) {
      return getAsNumber().intValue();
    }
    return Integer.parseInt(getAsString());
  }
  
  public long getAsLong()
  {
    if (isNumber()) {
      return getAsNumber().longValue();
    }
    return Long.parseLong(getAsString());
  }
  
  public Number getAsNumber()
  {
    Object localObject = this.value;
    if ((localObject instanceof String)) {
      return new LazilyParsedNumber((String)this.value);
    }
    return (Number)localObject;
  }
  
  public short getAsShort()
  {
    if (isNumber()) {
      return getAsNumber().shortValue();
    }
    return Short.parseShort(getAsString());
  }
  
  public String getAsString()
  {
    if (isNumber()) {
      return getAsNumber().toString();
    }
    if (isBoolean()) {
      return ((Boolean)this.value).toString();
    }
    return (String)this.value;
  }
  
  public int hashCode()
  {
    if (this.value == null) {
      return 31;
    }
    if (isIntegral(this)) {}
    Object localObject;
    for (long l = getAsNumber().longValue();; l = Double.doubleToLongBits(getAsNumber().doubleValue()))
    {
      return (int)(l >>> 32 ^ l);
      localObject = this.value;
      if (!(localObject instanceof Number)) {
        break;
      }
    }
    return localObject.hashCode();
  }
  
  public boolean isBoolean()
  {
    return this.value instanceof Boolean;
  }
  
  public boolean isNumber()
  {
    return this.value instanceof Number;
  }
  
  public boolean isString()
  {
    return this.value instanceof String;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\gson\JsonPrimitive.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */