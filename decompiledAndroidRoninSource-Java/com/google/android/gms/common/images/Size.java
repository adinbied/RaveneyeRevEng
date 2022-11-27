package com.google.android.gms.common.images;

public final class Size
{
  private final int zane;
  private final int zanf;
  
  public Size(int paramInt1, int paramInt2)
  {
    this.zane = paramInt1;
    this.zanf = paramInt2;
  }
  
  public static Size parseSize(String paramString)
    throws NumberFormatException
  {
    int i;
    if (paramString != null)
    {
      int j = paramString.indexOf('*');
      i = j;
      if (j < 0) {
        i = paramString.indexOf('x');
      }
      if (i < 0) {}
    }
    try
    {
      Size localSize = new Size(Integer.parseInt(paramString.substring(0, i)), Integer.parseInt(paramString.substring(i + 1)));
      return localSize;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      for (;;) {}
    }
    throw zah(paramString);
    throw zah(paramString);
    throw new IllegalArgumentException("string must not be null");
  }
  
  private static NumberFormatException zah(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 16);
    localStringBuilder.append("Invalid Size: \"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\"");
    throw new NumberFormatException(localStringBuilder.toString());
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == null) {
      return false;
    }
    if (this == paramObject) {
      return true;
    }
    if ((paramObject instanceof Size))
    {
      paramObject = (Size)paramObject;
      if ((this.zane == ((Size)paramObject).zane) && (this.zanf == ((Size)paramObject).zanf)) {
        return true;
      }
    }
    return false;
  }
  
  public final int getHeight()
  {
    return this.zanf;
  }
  
  public final int getWidth()
  {
    return this.zane;
  }
  
  public final int hashCode()
  {
    int i = this.zanf;
    int j = this.zane;
    return i ^ (j >>> 16 | j << 16);
  }
  
  public final String toString()
  {
    int i = this.zane;
    int j = this.zanf;
    StringBuilder localStringBuilder = new StringBuilder(23);
    localStringBuilder.append(i);
    localStringBuilder.append("x");
    localStringBuilder.append(j);
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\images\Size.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */