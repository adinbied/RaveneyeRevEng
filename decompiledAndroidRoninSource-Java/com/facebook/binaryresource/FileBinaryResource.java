package com.facebook.binaryresource;

import com.facebook.common.internal.Files;
import com.facebook.common.internal.Preconditions;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;

public class FileBinaryResource
  implements BinaryResource
{
  private final File mFile;
  
  private FileBinaryResource(File paramFile)
  {
    this.mFile = ((File)Preconditions.checkNotNull(paramFile));
  }
  
  @Nullable
  public static FileBinaryResource createOrNull(File paramFile)
  {
    if (paramFile != null) {
      return new FileBinaryResource(paramFile);
    }
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject != null) && ((paramObject instanceof FileBinaryResource)))
    {
      paramObject = (FileBinaryResource)paramObject;
      return this.mFile.equals(((FileBinaryResource)paramObject).mFile);
    }
    return false;
  }
  
  public File getFile()
  {
    return this.mFile;
  }
  
  public int hashCode()
  {
    return this.mFile.hashCode();
  }
  
  public InputStream openStream()
    throws IOException
  {
    return new FileInputStream(this.mFile);
  }
  
  public byte[] read()
    throws IOException
  {
    return Files.toByteArray(this.mFile);
  }
  
  public long size()
  {
    return this.mFile.length();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\binaryresource\FileBinaryResource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */