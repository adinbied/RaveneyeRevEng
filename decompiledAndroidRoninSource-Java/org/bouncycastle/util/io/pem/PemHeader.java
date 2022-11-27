package org.bouncycastle.util.io.pem;

public class PemHeader
{
  private String name;
  private String value;
  
  public PemHeader(String paramString1, String paramString2)
  {
    this.name = paramString1;
    this.value = paramString2;
  }
  
  private int getHashCode(String paramString)
  {
    if (paramString == null) {
      return 1;
    }
    return paramString.hashCode();
  }
  
  private boolean isEqual(String paramString1, String paramString2)
  {
    if (paramString1 == paramString2) {
      return true;
    }
    if ((paramString1 != null) && (paramString2 != null)) {
      return paramString1.equals(paramString2);
    }
    return false;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool1 = paramObject instanceof PemHeader;
    boolean bool2 = false;
    if (!bool1) {
      return false;
    }
    paramObject = (PemHeader)paramObject;
    if (paramObject != this)
    {
      bool1 = bool2;
      if (isEqual(this.name, ((PemHeader)paramObject).name))
      {
        bool1 = bool2;
        if (!isEqual(this.value, ((PemHeader)paramObject).value)) {}
      }
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  public String getName()
  {
    return this.name;
  }
  
  public String getValue()
  {
    return this.value;
  }
  
  public int hashCode()
  {
    return getHashCode(this.name) + getHashCode(this.value) * 31;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastl\\util\io\pem\PemHeader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */