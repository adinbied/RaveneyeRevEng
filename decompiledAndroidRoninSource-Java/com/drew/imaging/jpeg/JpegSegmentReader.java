package com.drew.imaging.jpeg;

import com.drew.lang.SequentialReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class JpegSegmentReader
{
  private static final byte MARKER_EOI = -39;
  private static final byte SEGMENT_IDENTIFIER = -1;
  private static final byte SEGMENT_SOS = -38;
  
  private JpegSegmentReader()
    throws Exception
  {
    throw new Exception("Not intended for instantiation.");
  }
  
  public static JpegSegmentData readSegments(SequentialReader paramSequentialReader, Iterable<JpegSegmentType> paramIterable)
    throws JpegProcessingException, IOException
  {
    int k = paramSequentialReader.getUInt16();
    if (k == 65496)
    {
      Object localObject = null;
      if (paramIterable != null)
      {
        HashSet localHashSet = new HashSet();
        paramIterable = paramIterable.iterator();
        for (;;)
        {
          localObject = localHashSet;
          if (!paramIterable.hasNext()) {
            break;
          }
          localHashSet.add(Byte.valueOf(((JpegSegmentType)paramIterable.next()).byteValue));
        }
      }
      paramIterable = new JpegSegmentData();
      k = paramSequentialReader.getInt8();
      int j;
      for (int i = paramSequentialReader.getInt8();; i = j)
      {
        if ((k == -1) && (i != -1) && (i != 0))
        {
          if (i == -38) {
            return paramIterable;
          }
          if (i == -39) {
            return paramIterable;
          }
          k = paramSequentialReader.getUInt16() - 2;
          if (k >= 0)
          {
            if ((localObject != null) && (!((Set)localObject).contains(Byte.valueOf(i))))
            {
              if (paramSequentialReader.trySkip(k)) {
                break;
              }
              return paramIterable;
            }
            paramIterable.addSegment(i, paramSequentialReader.getBytes(k));
            break;
          }
          throw new JpegProcessingException("JPEG segment size would be less than zero");
        }
        j = paramSequentialReader.getInt8();
        k = i;
      }
    }
    paramSequentialReader = new StringBuilder();
    paramSequentialReader.append("JPEG data is expected to begin with 0xFFD8 (ÿØ) not 0x");
    paramSequentialReader.append(Integer.toHexString(k));
    throw new JpegProcessingException(paramSequentialReader.toString());
  }
  
  /* Error */
  public static JpegSegmentData readSegments(java.io.File paramFile, Iterable<JpegSegmentType> paramIterable)
    throws JpegProcessingException, IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 126	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 129	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: new 131	com/drew/lang/StreamReader
    //   14: dup
    //   15: aload_0
    //   16: invokespecial 134	com/drew/lang/StreamReader:<init>	(Ljava/io/InputStream;)V
    //   19: aload_1
    //   20: invokestatic 136	com/drew/imaging/jpeg/JpegSegmentReader:readSegments	(Lcom/drew/lang/SequentialReader;Ljava/lang/Iterable;)Lcom/drew/imaging/jpeg/JpegSegmentData;
    //   23: astore_1
    //   24: aload_0
    //   25: invokevirtual 139	java/io/FileInputStream:close	()V
    //   28: aload_1
    //   29: areturn
    //   30: astore_1
    //   31: goto +6 -> 37
    //   34: astore_1
    //   35: aload_2
    //   36: astore_0
    //   37: aload_0
    //   38: ifnull +7 -> 45
    //   41: aload_0
    //   42: invokevirtual 139	java/io/FileInputStream:close	()V
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	paramFile	java.io.File
    //   0	47	1	paramIterable	Iterable<JpegSegmentType>
    //   1	35	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	24	30	finally
    //   2	11	34	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\jpeg\JpegSegmentReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */