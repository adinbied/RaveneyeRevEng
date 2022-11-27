package com.drew.imaging.psd;

import com.drew.lang.StreamReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.file.FileMetadataReader;
import com.drew.metadata.photoshop.PsdReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PsdMetadataReader
{
  public static Metadata readMetadata(File paramFile)
    throws IOException
  {
    Metadata localMetadata = new Metadata();
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      new PsdReader().extract(new StreamReader(localFileInputStream), localMetadata);
      localFileInputStream.close();
      new FileMetadataReader().read(paramFile, localMetadata);
      return localMetadata;
    }
    finally
    {
      localFileInputStream.close();
    }
  }
  
  public static Metadata readMetadata(InputStream paramInputStream)
  {
    Metadata localMetadata = new Metadata();
    new PsdReader().extract(new StreamReader(paramInputStream), localMetadata);
    return localMetadata;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\psd\PsdMetadataReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */