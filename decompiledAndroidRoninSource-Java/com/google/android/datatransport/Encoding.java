package com.google.android.datatransport;

public final class Encoding
{
  private final String name;
  
  private Encoding(String paramString)
  {
    if (paramString != null)
    {
      this.name = paramString;
      return;
    }
    throw new NullPointerException("name is null");
  }
  
  public static Encoding of(String paramString)
  {
    return new Encoding(paramString);
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (!(paramObject instanceof Encoding)) {
      return false;
    }
    return this.name.equals(((Encoding)paramObject).name);
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public int hashCode()
  {
    return this.name.hashCode() ^ 0xF4243;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Encoding{name=\"");
    localStringBuilder.append(this.name);
    localStringBuilder.append("\"}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\datatransport\Encoding.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */