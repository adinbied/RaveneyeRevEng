package com.drew.imaging.jpeg;

import com.drew.metadata.Metadata;

public abstract interface JpegSegmentMetadataReader
{
  public abstract Iterable<JpegSegmentType> getSegmentTypes();
  
  public abstract void readJpegSegments(Iterable<byte[]> paramIterable, Metadata paramMetadata, JpegSegmentType paramJpegSegmentType);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\jpeg\JpegSegmentMetadataReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */