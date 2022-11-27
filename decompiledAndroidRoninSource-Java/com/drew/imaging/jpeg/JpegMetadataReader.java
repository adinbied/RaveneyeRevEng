package com.drew.imaging.jpeg;

import com.drew.lang.StreamReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.adobe.AdobeJpegReader;
import com.drew.metadata.exif.ExifReader;
import com.drew.metadata.file.FileMetadataReader;
import com.drew.metadata.icc.IccReader;
import com.drew.metadata.iptc.IptcReader;
import com.drew.metadata.jfif.JfifReader;
import com.drew.metadata.jfxx.JfxxReader;
import com.drew.metadata.jpeg.JpegCommentReader;
import com.drew.metadata.jpeg.JpegDhtReader;
import com.drew.metadata.jpeg.JpegDnlReader;
import com.drew.metadata.jpeg.JpegReader;
import com.drew.metadata.photoshop.DuckyReader;
import com.drew.metadata.photoshop.PhotoshopReader;
import com.drew.metadata.xmp.XmpReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JpegMetadataReader
{
  public static final Iterable<JpegSegmentMetadataReader> ALL_READERS = Arrays.asList(new JpegSegmentMetadataReader[] { new JpegReader(), new JpegCommentReader(), new JfifReader(), new JfxxReader(), new ExifReader(), new XmpReader(), new IccReader(), new PhotoshopReader(), new DuckyReader(), new IptcReader(), new AdobeJpegReader(), new JpegDhtReader(), new JpegDnlReader() });
  
  private JpegMetadataReader()
    throws Exception
  {
    throw new Exception("Not intended for instantiation");
  }
  
  public static void process(Metadata paramMetadata, InputStream paramInputStream)
    throws JpegProcessingException, IOException
  {
    process(paramMetadata, paramInputStream, null);
  }
  
  public static void process(Metadata paramMetadata, InputStream paramInputStream, Iterable<JpegSegmentMetadataReader> paramIterable)
    throws JpegProcessingException, IOException
  {
    Object localObject = paramIterable;
    if (paramIterable == null) {
      localObject = ALL_READERS;
    }
    paramIterable = new HashSet();
    Iterator localIterator1 = ((Iterable)localObject).iterator();
    while (localIterator1.hasNext())
    {
      Iterator localIterator2 = ((JpegSegmentMetadataReader)localIterator1.next()).getSegmentTypes().iterator();
      while (localIterator2.hasNext()) {
        paramIterable.add((JpegSegmentType)localIterator2.next());
      }
    }
    processJpegSegmentData(paramMetadata, (Iterable)localObject, JpegSegmentReader.readSegments(new StreamReader(paramInputStream), paramIterable));
  }
  
  public static void processJpegSegmentData(Metadata paramMetadata, Iterable<JpegSegmentMetadataReader> paramIterable, JpegSegmentData paramJpegSegmentData)
  {
    paramIterable = paramIterable.iterator();
    while (paramIterable.hasNext())
    {
      JpegSegmentMetadataReader localJpegSegmentMetadataReader = (JpegSegmentMetadataReader)paramIterable.next();
      Iterator localIterator = localJpegSegmentMetadataReader.getSegmentTypes().iterator();
      while (localIterator.hasNext())
      {
        JpegSegmentType localJpegSegmentType = (JpegSegmentType)localIterator.next();
        localJpegSegmentMetadataReader.readJpegSegments(paramJpegSegmentData.getSegments(localJpegSegmentType), paramMetadata, localJpegSegmentType);
      }
    }
  }
  
  public static Metadata readMetadata(File paramFile)
    throws JpegProcessingException, IOException
  {
    return readMetadata(paramFile, null);
  }
  
  public static Metadata readMetadata(File paramFile, Iterable<JpegSegmentMetadataReader> paramIterable)
    throws JpegProcessingException, IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      paramIterable = readMetadata(localFileInputStream, paramIterable);
      localFileInputStream.close();
      new FileMetadataReader().read(paramFile, paramIterable);
      return paramIterable;
    }
    finally
    {
      localFileInputStream.close();
    }
  }
  
  public static Metadata readMetadata(InputStream paramInputStream)
    throws JpegProcessingException, IOException
  {
    return readMetadata(paramInputStream, null);
  }
  
  public static Metadata readMetadata(InputStream paramInputStream, Iterable<JpegSegmentMetadataReader> paramIterable)
    throws JpegProcessingException, IOException
  {
    Metadata localMetadata = new Metadata();
    process(localMetadata, paramInputStream, paramIterable);
    return localMetadata;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\jpeg\JpegMetadataReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */