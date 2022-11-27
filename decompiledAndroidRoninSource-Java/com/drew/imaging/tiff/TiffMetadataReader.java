package com.drew.imaging.tiff;

import com.drew.lang.RandomAccessFileReader;
import com.drew.lang.RandomAccessReader;
import com.drew.lang.RandomAccessStreamReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.exif.ExifTiffHandler;
import com.drew.metadata.file.FileMetadataReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;

public class TiffMetadataReader
{
  public static Metadata readMetadata(RandomAccessReader paramRandomAccessReader)
    throws IOException, TiffProcessingException
  {
    Metadata localMetadata = new Metadata();
    ExifTiffHandler localExifTiffHandler = new ExifTiffHandler(localMetadata, null);
    new TiffReader().processTiff(paramRandomAccessReader, localExifTiffHandler, 0);
    return localMetadata;
  }
  
  public static Metadata readMetadata(File paramFile)
    throws IOException, TiffProcessingException
  {
    Metadata localMetadata = new Metadata();
    RandomAccessFile localRandomAccessFile = new RandomAccessFile(paramFile, "r");
    try
    {
      ExifTiffHandler localExifTiffHandler = new ExifTiffHandler(localMetadata, null);
      new TiffReader().processTiff(new RandomAccessFileReader(localRandomAccessFile), localExifTiffHandler, 0);
      localRandomAccessFile.close();
      new FileMetadataReader().read(paramFile, localMetadata);
      return localMetadata;
    }
    finally
    {
      localRandomAccessFile.close();
    }
  }
  
  public static Metadata readMetadata(InputStream paramInputStream)
    throws IOException, TiffProcessingException
  {
    return readMetadata(new RandomAccessStreamReader(paramInputStream));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\tiff\TiffMetadataReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */