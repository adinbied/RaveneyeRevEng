package com.drew.tools;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentData;
import com.drew.imaging.jpeg.JpegSegmentReader;
import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.lang.Iterables;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ExtractJpegSegmentTool
{
  public static void main(String[] paramArrayOfString)
    throws IOException, JpegProcessingException
  {
    if (paramArrayOfString.length < 1)
    {
      printUsage();
      System.exit(1);
    }
    String str = paramArrayOfString[0];
    if (!new File(str).exists())
    {
      System.err.println("File does not exist");
      printUsage();
      System.exit(1);
    }
    HashSet localHashSet = new HashSet();
    int i = 1;
    while (i < paramArrayOfString.length)
    {
      localObject = JpegSegmentType.valueOf(paramArrayOfString[i].toUpperCase());
      if (!((JpegSegmentType)localObject).canContainMetadata) {
        System.err.printf("WARNING: Segment type %s cannot contain metadata so it may not be necessary to extract it%n", new Object[] { localObject });
      }
      localHashSet.add(localObject);
      i += 1;
    }
    if (localHashSet.size() == 0) {
      localHashSet.addAll(JpegSegmentType.canContainMetadataTypes);
    }
    paramArrayOfString = System.out;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Reading: ");
    ((StringBuilder)localObject).append(str);
    paramArrayOfString.println(((StringBuilder)localObject).toString());
    saveSegmentFiles(str, JpegSegmentReader.readSegments(new File(str), localHashSet));
  }
  
  private static void printUsage()
  {
    System.out.println("USAGE:\n");
    System.out.println("\tjava com.drew.tools.ExtractJpegSegmentTool <filename> [<segment> ...]\n");
    System.out.print("Where <segment> is zero or more of:");
    JpegSegmentType[] arrayOfJpegSegmentType = (JpegSegmentType[])JpegSegmentType.class.getEnumConstants();
    int j = arrayOfJpegSegmentType.length;
    int i = 0;
    while (i < j)
    {
      JpegSegmentType localJpegSegmentType = arrayOfJpegSegmentType[i];
      if (localJpegSegmentType.canContainMetadata)
      {
        PrintStream localPrintStream = System.out;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(" ");
        localStringBuilder.append(localJpegSegmentType.toString());
        localPrintStream.print(localStringBuilder.toString());
      }
      i += 1;
    }
    System.out.println();
  }
  
  public static void saveSegmentFiles(String paramString, JpegSegmentData paramJpegSegmentData)
    throws IOException
  {
    Iterator localIterator = paramJpegSegmentData.getSegmentTypes().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (JpegSegmentType)localIterator.next();
      List localList = Iterables.toList(paramJpegSegmentData.getSegments((JpegSegmentType)localObject1));
      if (localList.size() != 0)
      {
        Object localObject2;
        Object localObject3;
        if (localList.size() > 1)
        {
          int i = 0;
          while (i < localList.size())
          {
            localObject2 = String.format("%s.%s.%d", new Object[] { paramString, ((JpegSegmentType)localObject1).toString().toLowerCase(), Integer.valueOf(i) });
            localObject3 = System.out;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("Writing: ");
            localStringBuilder.append((String)localObject2);
            ((PrintStream)localObject3).println(localStringBuilder.toString());
            FileUtil.saveBytes(new File((String)localObject2), (byte[])localList.get(i));
            i += 1;
          }
        }
        else
        {
          localObject1 = String.format("%s.%s", new Object[] { paramString, ((JpegSegmentType)localObject1).toString().toLowerCase() });
          localObject2 = System.out;
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append("Writing: ");
          ((StringBuilder)localObject3).append((String)localObject1);
          ((PrintStream)localObject2).println(((StringBuilder)localObject3).toString());
          FileUtil.saveBytes(new File((String)localObject1), (byte[])localList.get(0));
        }
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\tools\ExtractJpegSegmentTool.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */