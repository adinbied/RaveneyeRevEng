package com.drew.imaging.bmp;

import com.drew.lang.StreamReader;
import com.drew.metadata.Metadata;
import com.drew.metadata.bmp.BmpReader;
import java.io.InputStream;

public class BmpMetadataReader
{
  /* Error */
  public static Metadata readMetadata(java.io.File paramFile)
    throws java.io.IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 15	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 18	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: aload_0
    //   12: invokestatic 21	com/drew/imaging/bmp/BmpMetadataReader:readMetadata	(Ljava/io/InputStream;)Lcom/drew/metadata/Metadata;
    //   15: astore_1
    //   16: aload_0
    //   17: invokevirtual 24	java/io/FileInputStream:close	()V
    //   20: aload_1
    //   21: areturn
    //   22: astore_1
    //   23: goto +6 -> 29
    //   26: astore_1
    //   27: aload_2
    //   28: astore_0
    //   29: aload_0
    //   30: ifnull +7 -> 37
    //   33: aload_0
    //   34: invokevirtual 24	java/io/FileInputStream:close	()V
    //   37: aload_1
    //   38: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	39	0	paramFile	java.io.File
    //   15	6	1	localMetadata	Metadata
    //   22	1	1	localObject1	Object
    //   26	12	1	localObject2	Object
    //   1	27	2	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   11	16	22	finally
    //   2	11	26	finally
  }
  
  public static Metadata readMetadata(InputStream paramInputStream)
  {
    Metadata localMetadata = new Metadata();
    new BmpReader().extract(new StreamReader(paramInputStream), localMetadata);
    return localMetadata;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\imaging\bmp\BmpMetadataReader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */