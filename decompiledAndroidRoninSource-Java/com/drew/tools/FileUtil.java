package com.drew.tools;

import java.io.File;
import java.io.IOException;

public class FileUtil
{
  /* Error */
  public static byte[] readBytes(File paramFile)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 23	java/io/File:length	()J
    //   4: l2i
    //   5: istore_2
    //   6: iload_2
    //   7: newarray <illegal type>
    //   9: astore 4
    //   11: iconst_0
    //   12: istore_1
    //   13: aconst_null
    //   14: astore 5
    //   16: new 25	java/io/FileInputStream
    //   19: dup
    //   20: aload_0
    //   21: invokespecial 28	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   24: astore_0
    //   25: iload_1
    //   26: iload_2
    //   27: if_icmpeq +34 -> 61
    //   30: aload_0
    //   31: aload 4
    //   33: iload_1
    //   34: iload_2
    //   35: iload_1
    //   36: isub
    //   37: invokevirtual 32	java/io/FileInputStream:read	([BII)I
    //   40: istore_3
    //   41: iload_3
    //   42: iconst_m1
    //   43: if_icmpne +6 -> 49
    //   46: goto +15 -> 61
    //   49: iload_1
    //   50: iload_3
    //   51: iadd
    //   52: istore_1
    //   53: goto -28 -> 25
    //   56: astore 4
    //   58: goto +15 -> 73
    //   61: aload_0
    //   62: invokevirtual 35	java/io/FileInputStream:close	()V
    //   65: aload 4
    //   67: areturn
    //   68: astore 4
    //   70: aload 5
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +7 -> 81
    //   77: aload_0
    //   78: invokevirtual 35	java/io/FileInputStream:close	()V
    //   81: aload 4
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	paramFile	File
    //   12	41	1	i	int
    //   5	32	2	j	int
    //   40	12	3	k	int
    //   9	23	4	arrayOfByte1	byte[]
    //   56	10	4	arrayOfByte2	byte[]
    //   68	14	4	localObject1	Object
    //   14	57	5	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   30	41	56	finally
    //   16	25	68	finally
  }
  
  public static byte[] readBytes(String paramString)
    throws IOException
  {
    return readBytes(new File(paramString));
  }
  
  /* Error */
  public static void saveBytes(File paramFile, byte[] paramArrayOfByte)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 46	java/io/FileOutputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 47	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: aload_0
    //   12: aload_1
    //   13: invokevirtual 51	java/io/FileOutputStream:write	([B)V
    //   16: aload_0
    //   17: invokevirtual 52	java/io/FileOutputStream:close	()V
    //   20: return
    //   21: astore_1
    //   22: goto +6 -> 28
    //   25: astore_1
    //   26: aload_2
    //   27: astore_0
    //   28: aload_0
    //   29: ifnull +7 -> 36
    //   32: aload_0
    //   33: invokevirtual 52	java/io/FileOutputStream:close	()V
    //   36: aload_1
    //   37: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	38	0	paramFile	File
    //   0	38	1	paramArrayOfByte	byte[]
    //   1	26	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   11	16	21	finally
    //   2	11	25	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\tools\FileUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */