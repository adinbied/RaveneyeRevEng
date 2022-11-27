package com.drew.imaging;

import com.drew.imaging.bmp.BmpMetadataReader;
import com.drew.imaging.gif.GifMetadataReader;
import com.drew.imaging.ico.IcoMetadataReader;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.pcx.PcxMetadataReader;
import com.drew.imaging.png.PngMetadataReader;
import com.drew.imaging.psd.PsdMetadataReader;
import com.drew.imaging.raf.RafMetadataReader;
import com.drew.imaging.tiff.TiffMetadataReader;
import com.drew.imaging.webp.WebpMetadataReader;
import com.drew.lang.RandomAccessStreamReader;
import com.drew.lang.StringUtil;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.MetadataException;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifIFD0Directory;
import com.drew.metadata.file.FileMetadataReader;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class ImageMetadataReader
{
  private ImageMetadataReader()
    throws Exception
  {
    throw new Exception("Not intended for instantiation");
  }
  
  public static void main(String[] paramArrayOfString)
    throws MetadataException, IOException
  {
    ArrayList localArrayList = new ArrayList(Arrays.asList(paramArrayOfString));
    boolean bool1 = localArrayList.remove("-markdown");
    boolean bool2 = localArrayList.remove("-hex");
    Object localObject1;
    Object localObject2;
    if (localArrayList.size() < 1)
    {
      localObject1 = ImageMetadataReader.class.getPackage().getImplementationVersion();
      paramArrayOfString = System.out;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("metadata-extractor version ");
      ((StringBuilder)localObject2).append((String)localObject1);
      paramArrayOfString.println(((StringBuilder)localObject2).toString());
      System.out.println();
      localObject2 = System.out;
      paramArrayOfString = (String[])localObject1;
      if (localObject1 == null) {
        paramArrayOfString = "a.b.c";
      }
      ((PrintStream)localObject2).println(String.format("Usage: java -jar metadata-extractor-%s.jar <filename> [<filename>] [-thumb] [-markdown] [-hex]", new Object[] { paramArrayOfString }));
      System.exit(1);
    }
    Iterator localIterator = localArrayList.iterator();
    if (localIterator.hasNext())
    {
      localObject2 = (String)localIterator.next();
      long l1 = System.nanoTime();
      Object localObject3 = new File((String)localObject2);
      if ((!bool1) && (localArrayList.size() > 1)) {
        System.out.printf("\n***** PROCESSING: %s%n%n", new Object[] { localObject2 });
      }
      paramArrayOfString = null;
      try
      {
        localObject1 = readMetadata((File)localObject3);
        paramArrayOfString = (String[])localObject1;
      }
      catch (Exception localException)
      {
        localException.printStackTrace(System.err);
        System.exit(1);
      }
      long l2 = System.nanoTime();
      if (!bool1) {
        System.out.printf("Processed %.3f MB file in %.2f ms%n%n", new Object[] { Double.valueOf(((File)localObject3).length() / 1048576.0D), Double.valueOf((l2 - l1) / 1000000.0D) });
      }
      Object localObject4;
      Object localObject5;
      String str1;
      if (bool1)
      {
        localObject3 = ((File)localObject3).getName();
        localObject4 = StringUtil.urlEncode((String)localObject2);
        localObject5 = (ExifIFD0Directory)paramArrayOfString.getFirstDirectoryOfType(ExifIFD0Directory.class);
        localObject2 = "";
        if (localObject5 == null) {
          str1 = "";
        } else {
          str1 = ((ExifIFD0Directory)localObject5).getString(271);
        }
        if (localObject5 != null) {
          localObject2 = ((ExifIFD0Directory)localObject5).getString(272);
        }
        System.out.println();
        System.out.println("---");
        System.out.println();
        System.out.printf("# %s - %s%n", new Object[] { str1, localObject2 });
        System.out.println();
        System.out.printf("<a href=\"https://raw.githubusercontent.com/drewnoakes/metadata-extractor-images/master/%s\">%n", new Object[] { localObject4 });
        System.out.printf("<img src=\"https://raw.githubusercontent.com/drewnoakes/metadata-extractor-images/master/%s\" width=\"300\"/><br/>%n", new Object[] { localObject4 });
        System.out.println((String)localObject3);
        System.out.println("</a>");
        System.out.println();
        System.out.println("Directory | Tag Id | Tag Name | Extracted Value");
        System.out.println(":--------:|-------:|----------|----------------");
      }
      localObject2 = paramArrayOfString.getDirectories().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Directory)((Iterator)localObject2).next();
        localObject4 = ((Directory)localObject3).getName();
        localObject5 = ((Directory)localObject3).getTags().iterator();
        while (((Iterator)localObject5).hasNext())
        {
          Tag localTag = (Tag)((Iterator)localObject5).next();
          String str2 = localTag.getTagName();
          str1 = localTag.getDescription();
          paramArrayOfString = str1;
          if (str1 != null)
          {
            paramArrayOfString = str1;
            if (str1.length() > 1024)
            {
              paramArrayOfString = new StringBuilder();
              paramArrayOfString.append(str1.substring(0, 1024));
              paramArrayOfString.append("...");
              paramArrayOfString = paramArrayOfString.toString();
            }
          }
          if (bool1) {
            System.out.printf("%s|0x%s|%s|%s%n", new Object[] { localObject4, Integer.toHexString(localTag.getTagType()), str2, paramArrayOfString });
          } else if (bool2) {
            System.out.printf("[%s - %s] %s = %s%n", new Object[] { localObject4, localTag.getTagTypeHex(), str2, paramArrayOfString });
          } else {
            System.out.printf("[%s] %s = %s%n", new Object[] { localObject4, str2, paramArrayOfString });
          }
        }
        paramArrayOfString = ((Directory)localObject3).getErrors().iterator();
        while (paramArrayOfString.hasNext())
        {
          str1 = (String)paramArrayOfString.next();
          localObject3 = System.err;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("ERROR: ");
          ((StringBuilder)localObject4).append(str1);
          ((PrintStream)localObject3).println(((StringBuilder)localObject4).toString());
        }
      }
    }
  }
  
  public static Metadata readMetadata(File paramFile)
    throws ImageProcessingException, IOException
  {
    FileInputStream localFileInputStream = new FileInputStream(paramFile);
    try
    {
      Metadata localMetadata = readMetadata(localFileInputStream, paramFile.length());
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
    throws ImageProcessingException, IOException
  {
    return readMetadata(paramInputStream, -1L);
  }
  
  public static Metadata readMetadata(InputStream paramInputStream, long paramLong)
    throws ImageProcessingException, IOException
  {
    if ((paramInputStream instanceof BufferedInputStream)) {
      paramInputStream = (BufferedInputStream)paramInputStream;
    } else {
      paramInputStream = new BufferedInputStream(paramInputStream);
    }
    FileType localFileType = FileTypeDetector.detectFileType(paramInputStream);
    if (localFileType == FileType.Jpeg) {
      return JpegMetadataReader.readMetadata(paramInputStream);
    }
    if ((localFileType != FileType.Tiff) && (localFileType != FileType.Arw) && (localFileType != FileType.Cr2) && (localFileType != FileType.Nef) && (localFileType != FileType.Orf) && (localFileType != FileType.Rw2))
    {
      if (localFileType == FileType.Psd) {
        return PsdMetadataReader.readMetadata(paramInputStream);
      }
      if (localFileType == FileType.Png) {
        return PngMetadataReader.readMetadata(paramInputStream);
      }
      if (localFileType == FileType.Bmp) {
        return BmpMetadataReader.readMetadata(paramInputStream);
      }
      if (localFileType == FileType.Gif) {
        return GifMetadataReader.readMetadata(paramInputStream);
      }
      if (localFileType == FileType.Ico) {
        return IcoMetadataReader.readMetadata(paramInputStream);
      }
      if (localFileType == FileType.Pcx) {
        return PcxMetadataReader.readMetadata(paramInputStream);
      }
      if (localFileType == FileType.Riff) {
        return WebpMetadataReader.readMetadata(paramInputStream);
      }
      if (localFileType == FileType.Raf) {
        return RafMetadataReader.readMetadata(paramInputStream);
      }
      throw new ImageProcessingException("File format is not supported");
    }
    return TiffMetadataReader.readMetadata(new RandomAccessStreamReader(paramInputStream, 2048, paramLong));
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\ImageMetadataReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */