package com.google.firebase.crashlytics.internal.model;

import java.util.Arrays;

final class AutoValue_CrashlyticsReport_FilesPayload_File
  extends CrashlyticsReport.FilesPayload.File
{
  private final byte[] contents;
  private final String filename;
  
  private AutoValue_CrashlyticsReport_FilesPayload_File(String paramString, byte[] paramArrayOfByte)
  {
    this.filename = paramString;
    this.contents = paramArrayOfByte;
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if ((paramObject instanceof CrashlyticsReport.FilesPayload.File))
    {
      paramObject = (CrashlyticsReport.FilesPayload.File)paramObject;
      if (this.filename.equals(((CrashlyticsReport.FilesPayload.File)paramObject).getFilename()))
      {
        byte[] arrayOfByte = this.contents;
        if ((paramObject instanceof AutoValue_CrashlyticsReport_FilesPayload_File)) {
          paramObject = ((AutoValue_CrashlyticsReport_FilesPayload_File)paramObject).contents;
        } else {
          paramObject = ((CrashlyticsReport.FilesPayload.File)paramObject).getContents();
        }
        if (Arrays.equals(arrayOfByte, (byte[])paramObject)) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  public byte[] getContents()
  {
    return this.contents;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public int hashCode()
  {
    return (this.filename.hashCode() ^ 0xF4243) * 1000003 ^ Arrays.hashCode(this.contents);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("File{filename=");
    localStringBuilder.append(this.filename);
    localStringBuilder.append(", contents=");
    localStringBuilder.append(Arrays.toString(this.contents));
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  static final class Builder
    extends CrashlyticsReport.FilesPayload.File.Builder
  {
    private byte[] contents;
    private String filename;
    
    public CrashlyticsReport.FilesPayload.File build()
    {
      Object localObject2 = this.filename;
      Object localObject1 = "";
      if (localObject2 == null)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append(" filename");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      localObject2 = localObject1;
      if (this.contents == null)
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append((String)localObject1);
        ((StringBuilder)localObject2).append(" contents");
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      if (((String)localObject2).isEmpty()) {
        return new AutoValue_CrashlyticsReport_FilesPayload_File(this.filename, this.contents, null);
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("Missing required properties:");
      ((StringBuilder)localObject1).append((String)localObject2);
      throw new IllegalStateException(((StringBuilder)localObject1).toString());
    }
    
    public CrashlyticsReport.FilesPayload.File.Builder setContents(byte[] paramArrayOfByte)
    {
      if (paramArrayOfByte != null)
      {
        this.contents = paramArrayOfByte;
        return this;
      }
      throw new NullPointerException("Null contents");
    }
    
    public CrashlyticsReport.FilesPayload.File.Builder setFilename(String paramString)
    {
      if (paramString != null)
      {
        this.filename = paramString;
        return this;
      }
      throw new NullPointerException("Null filename");
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\model\AutoValue_CrashlyticsReport_FilesPayload_File.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */