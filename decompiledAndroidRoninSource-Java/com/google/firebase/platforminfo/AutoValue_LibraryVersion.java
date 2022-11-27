package com.google.firebase.platforminfo;

import javax.annotation.Nonnull;

final class AutoValue_LibraryVersion
  extends LibraryVersion
{
  private final String libraryName;
  private final String version;
  
  AutoValue_LibraryVersion(String paramString1, String paramString2)
  {
    if (paramString1 != null)
    {
      this.libraryName = paramString1;
      if (paramString2 != null)
      {
        this.version = paramString2;
        return;
      }
      throw new NullPointerException("Null version");
    }
    throw new NullPointerException("Null libraryName");
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof LibraryVersion))
    {
      paramObject = (LibraryVersion)paramObject;
      return (this.libraryName.equals(((LibraryVersion)paramObject).getLibraryName())) && (this.version.equals(((LibraryVersion)paramObject).getVersion()));
    }
    return false;
  }
  
  @Nonnull
  public String getLibraryName()
  {
    return this.libraryName;
  }
  
  @Nonnull
  public String getVersion()
  {
    return this.version;
  }
  
  public int hashCode()
  {
    return (this.libraryName.hashCode() ^ 0xF4243) * 1000003 ^ this.version.hashCode();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("LibraryVersion{libraryName=");
    localStringBuilder.append(this.libraryName);
    localStringBuilder.append(", version=");
    localStringBuilder.append(this.version);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\platforminfo\AutoValue_LibraryVersion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */