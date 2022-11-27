package com.drew.metadata.file;

import com.drew.metadata.TagDescriptor;

public class FileMetadataDescriptor
  extends TagDescriptor<FileMetadataDirectory>
{
  public FileMetadataDescriptor(FileMetadataDirectory paramFileMetadataDirectory)
  {
    super(paramFileMetadataDirectory);
  }
  
  private String getFileSizeDescription()
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\file\FileMetadataDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */