package it.sauronsoftware.ftp4j.connectors;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

class Base64
{
  static String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
  static char pad = '=';
  
  private static void copy(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    byte[] arrayOfByte = new byte['Ѐ'];
    for (;;)
    {
      int i = paramInputStream.read(arrayOfByte);
      if (i == -1) {
        break;
      }
      paramOutputStream.write(arrayOfByte, 0, i);
    }
  }
  
  public static String decode(String paramString)
    throws RuntimeException
  {
    try
    {
      paramString = paramString.getBytes("ASCII");
      return new String(decode(paramString));
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("ASCII is not supported!", paramString);
    }
  }
  
  /* Error */
  public static String decode(String paramString1, String paramString2)
    throws RuntimeException
  {
    // Byte code:
    //   0: aload_0
    //   1: ldc 42
    //   3: invokevirtual 48	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   6: astore_0
    //   7: aload_0
    //   8: invokestatic 51	it/sauronsoftware/ftp4j/connectors/Base64:decode	([B)[B
    //   11: astore_0
    //   12: new 44	java/lang/String
    //   15: dup
    //   16: aload_0
    //   17: aload_1
    //   18: invokespecial 63	java/lang/String:<init>	([BLjava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: areturn
    //   24: astore_0
    //   25: new 65	java/lang/StringBuffer
    //   28: dup
    //   29: invokespecial 66	java/lang/StringBuffer:<init>	()V
    //   32: astore_2
    //   33: aload_2
    //   34: ldc 68
    //   36: invokevirtual 72	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   39: pop
    //   40: aload_2
    //   41: aload_1
    //   42: invokevirtual 72	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   45: pop
    //   46: new 38	java/lang/RuntimeException
    //   49: dup
    //   50: aload_2
    //   51: invokevirtual 76	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   54: aload_0
    //   55: invokespecial 59	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   58: athrow
    //   59: astore_0
    //   60: new 38	java/lang/RuntimeException
    //   63: dup
    //   64: ldc 56
    //   66: aload_0
    //   67: invokespecial 59	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramString1	String
    //   0	71	1	paramString2	String
    //   32	19	2	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   12	22	24	java/io/UnsupportedEncodingException
    //   0	7	59	java/io/UnsupportedEncodingException
  }
  
  /* Error */
  public static void decode(java.io.File paramFile1, java.io.File paramFile2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 79	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: new 84	java/io/FileOutputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: astore_1
    //   20: aload_0
    //   21: aload_1
    //   22: invokestatic 87	it/sauronsoftware/ftp4j/connectors/Base64:decode	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   25: aload_1
    //   26: invokevirtual 90	java/io/OutputStream:close	()V
    //   29: aload_0
    //   30: invokevirtual 91	java/io/InputStream:close	()V
    //   33: return
    //   34: astore_3
    //   35: aload_1
    //   36: astore_2
    //   37: aload_0
    //   38: astore_1
    //   39: aload_3
    //   40: astore_0
    //   41: goto +14 -> 55
    //   44: astore_3
    //   45: aload_0
    //   46: astore_1
    //   47: aload_3
    //   48: astore_0
    //   49: goto +6 -> 55
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_2
    //   56: ifnull +10 -> 66
    //   59: aload_2
    //   60: invokevirtual 90	java/io/OutputStream:close	()V
    //   63: goto +3 -> 66
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 91	java/io/InputStream:close	()V
    //   74: aload_0
    //   75: athrow
    //   76: astore_1
    //   77: goto -48 -> 29
    //   80: astore_0
    //   81: return
    //   82: astore_2
    //   83: goto -17 -> 66
    //   86: astore_1
    //   87: goto -13 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramFile1	java.io.File
    //   0	90	1	paramFile2	java.io.File
    //   1	59	2	localFile	java.io.File
    //   82	1	2	localObject1	Object
    //   34	6	3	localObject2	Object
    //   44	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	34	finally
    //   11	20	44	finally
    //   2	11	52	finally
    //   25	29	76	finally
    //   29	33	80	finally
    //   59	63	82	finally
    //   70	74	86	finally
  }
  
  public static void decode(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    copy(new Base64InputStream(paramInputStream), paramOutputStream);
  }
  
  /* Error */
  public static byte[] decode(byte[] paramArrayOfByte)
    throws RuntimeException
  {
    // Byte code:
    //   0: new 100	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 101	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_2
    //   9: new 103	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 104	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_0
    //   17: aload_2
    //   18: aload_0
    //   19: invokestatic 87	it/sauronsoftware/ftp4j/connectors/Base64:decode	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   22: aload_2
    //   23: invokevirtual 105	java/io/ByteArrayInputStream:close	()V
    //   26: aload_0
    //   27: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   30: aload_0
    //   31: invokevirtual 110	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   34: areturn
    //   35: astore_1
    //   36: goto +15 -> 51
    //   39: astore_1
    //   40: new 38	java/lang/RuntimeException
    //   43: dup
    //   44: ldc 112
    //   46: aload_1
    //   47: invokespecial 59	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   50: athrow
    //   51: aload_2
    //   52: invokevirtual 105	java/io/ByteArrayInputStream:close	()V
    //   55: aload_0
    //   56: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   59: aload_1
    //   60: athrow
    //   61: astore_1
    //   62: goto -36 -> 26
    //   65: astore_1
    //   66: goto -36 -> 30
    //   69: astore_2
    //   70: goto -15 -> 55
    //   73: astore_0
    //   74: goto -15 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	paramArrayOfByte	byte[]
    //   35	1	1	localObject1	Object
    //   39	21	1	localIOException	IOException
    //   61	1	1	localObject2	Object
    //   65	1	1	localObject3	Object
    //   8	44	2	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   69	1	2	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	22	35	finally
    //   40	51	35	finally
    //   17	22	39	java/io/IOException
    //   22	26	61	finally
    //   26	30	65	finally
    //   51	55	69	finally
    //   55	59	73	finally
  }
  
  public static String encode(String paramString)
    throws RuntimeException
  {
    paramString = encode(paramString.getBytes());
    try
    {
      paramString = new String(paramString, "ASCII");
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException("ASCII is not supported!", paramString);
    }
  }
  
  /* Error */
  public static String encode(String paramString1, String paramString2)
    throws RuntimeException
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_1
    //   2: invokevirtual 48	java/lang/String:getBytes	(Ljava/lang/String;)[B
    //   5: astore_0
    //   6: aload_0
    //   7: invokestatic 117	it/sauronsoftware/ftp4j/connectors/Base64:encode	([B)[B
    //   10: astore_0
    //   11: new 44	java/lang/String
    //   14: dup
    //   15: aload_0
    //   16: ldc 42
    //   18: invokespecial 63	java/lang/String:<init>	([BLjava/lang/String;)V
    //   21: astore_0
    //   22: aload_0
    //   23: areturn
    //   24: astore_0
    //   25: new 38	java/lang/RuntimeException
    //   28: dup
    //   29: ldc 56
    //   31: aload_0
    //   32: invokespecial 59	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   35: athrow
    //   36: astore_0
    //   37: new 65	java/lang/StringBuffer
    //   40: dup
    //   41: invokespecial 66	java/lang/StringBuffer:<init>	()V
    //   44: astore_2
    //   45: aload_2
    //   46: ldc 68
    //   48: invokevirtual 72	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   51: pop
    //   52: aload_2
    //   53: aload_1
    //   54: invokevirtual 72	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   57: pop
    //   58: new 38	java/lang/RuntimeException
    //   61: dup
    //   62: aload_2
    //   63: invokevirtual 76	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   66: aload_0
    //   67: invokespecial 59	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   70: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	71	0	paramString1	String
    //   0	71	1	paramString2	String
    //   44	19	2	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   11	22	24	java/io/UnsupportedEncodingException
    //   0	6	36	java/io/UnsupportedEncodingException
  }
  
  /* Error */
  public static void encode(java.io.File paramFile1, java.io.File paramFile2)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: new 79	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: new 84	java/io/FileOutputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: astore_1
    //   20: aload_0
    //   21: aload_1
    //   22: invokestatic 119	it/sauronsoftware/ftp4j/connectors/Base64:encode	(Ljava/io/InputStream;Ljava/io/OutputStream;)V
    //   25: aload_1
    //   26: invokevirtual 90	java/io/OutputStream:close	()V
    //   29: aload_0
    //   30: invokevirtual 91	java/io/InputStream:close	()V
    //   33: return
    //   34: astore_3
    //   35: aload_1
    //   36: astore_2
    //   37: aload_0
    //   38: astore_1
    //   39: aload_3
    //   40: astore_0
    //   41: goto +14 -> 55
    //   44: astore_3
    //   45: aload_0
    //   46: astore_1
    //   47: aload_3
    //   48: astore_0
    //   49: goto +6 -> 55
    //   52: astore_0
    //   53: aconst_null
    //   54: astore_1
    //   55: aload_2
    //   56: ifnull +10 -> 66
    //   59: aload_2
    //   60: invokevirtual 90	java/io/OutputStream:close	()V
    //   63: goto +3 -> 66
    //   66: aload_1
    //   67: ifnull +7 -> 74
    //   70: aload_1
    //   71: invokevirtual 91	java/io/InputStream:close	()V
    //   74: aload_0
    //   75: athrow
    //   76: astore_1
    //   77: goto -48 -> 29
    //   80: astore_0
    //   81: return
    //   82: astore_2
    //   83: goto -17 -> 66
    //   86: astore_1
    //   87: goto -13 -> 74
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	90	0	paramFile1	java.io.File
    //   0	90	1	paramFile2	java.io.File
    //   1	59	2	localFile	java.io.File
    //   82	1	2	localObject1	Object
    //   34	6	3	localObject2	Object
    //   44	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	25	34	finally
    //   11	20	44	finally
    //   2	11	52	finally
    //   25	29	76	finally
    //   29	33	80	finally
    //   59	63	82	finally
    //   70	74	86	finally
  }
  
  /* Error */
  public static void encode(java.io.File paramFile1, java.io.File paramFile2, int paramInt)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 79	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 82	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   10: astore_0
    //   11: new 84	java/io/FileOutputStream
    //   14: dup
    //   15: aload_1
    //   16: invokespecial 85	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   19: astore_1
    //   20: aload_0
    //   21: aload_1
    //   22: iload_2
    //   23: invokestatic 123	it/sauronsoftware/ftp4j/connectors/Base64:encode	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   26: aload_1
    //   27: invokevirtual 90	java/io/OutputStream:close	()V
    //   30: aload_0
    //   31: invokevirtual 91	java/io/InputStream:close	()V
    //   34: return
    //   35: astore 4
    //   37: aload_1
    //   38: astore_3
    //   39: aload_0
    //   40: astore_1
    //   41: aload 4
    //   43: astore_0
    //   44: goto +16 -> 60
    //   47: astore 4
    //   49: aload_0
    //   50: astore_1
    //   51: aload 4
    //   53: astore_0
    //   54: goto +6 -> 60
    //   57: astore_0
    //   58: aconst_null
    //   59: astore_1
    //   60: aload_3
    //   61: ifnull +10 -> 71
    //   64: aload_3
    //   65: invokevirtual 90	java/io/OutputStream:close	()V
    //   68: goto +3 -> 71
    //   71: aload_1
    //   72: ifnull +7 -> 79
    //   75: aload_1
    //   76: invokevirtual 91	java/io/InputStream:close	()V
    //   79: aload_0
    //   80: athrow
    //   81: astore_1
    //   82: goto -52 -> 30
    //   85: astore_0
    //   86: return
    //   87: astore_3
    //   88: goto -17 -> 71
    //   91: astore_1
    //   92: goto -13 -> 79
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	paramFile1	java.io.File
    //   0	95	1	paramFile2	java.io.File
    //   0	95	2	paramInt	int
    //   1	64	3	localFile	java.io.File
    //   87	1	3	localObject1	Object
    //   35	7	4	localObject2	Object
    //   47	5	4	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   20	26	35	finally
    //   11	20	47	finally
    //   2	11	57	finally
    //   26	30	81	finally
    //   30	34	85	finally
    //   64	68	87	finally
    //   75	79	91	finally
  }
  
  public static void encode(InputStream paramInputStream, OutputStream paramOutputStream)
    throws IOException
  {
    encode(paramInputStream, paramOutputStream, 0);
  }
  
  public static void encode(InputStream paramInputStream, OutputStream paramOutputStream, int paramInt)
    throws IOException
  {
    paramOutputStream = new Base64OutputStream(paramOutputStream, paramInt);
    copy(paramInputStream, paramOutputStream);
    paramOutputStream.commit();
  }
  
  public static byte[] encode(byte[] paramArrayOfByte)
    throws RuntimeException
  {
    return encode(paramArrayOfByte, 0);
  }
  
  /* Error */
  public static byte[] encode(byte[] paramArrayOfByte, int paramInt)
    throws RuntimeException
  {
    // Byte code:
    //   0: new 100	java/io/ByteArrayInputStream
    //   3: dup
    //   4: aload_0
    //   5: invokespecial 101	java/io/ByteArrayInputStream:<init>	([B)V
    //   8: astore_3
    //   9: new 103	java/io/ByteArrayOutputStream
    //   12: dup
    //   13: invokespecial 104	java/io/ByteArrayOutputStream:<init>	()V
    //   16: astore_0
    //   17: aload_3
    //   18: aload_0
    //   19: iload_1
    //   20: invokestatic 123	it/sauronsoftware/ftp4j/connectors/Base64:encode	(Ljava/io/InputStream;Ljava/io/OutputStream;I)V
    //   23: aload_3
    //   24: invokevirtual 105	java/io/ByteArrayInputStream:close	()V
    //   27: aload_0
    //   28: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   31: aload_0
    //   32: invokevirtual 110	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   35: areturn
    //   36: astore_2
    //   37: goto +15 -> 52
    //   40: astore_2
    //   41: new 38	java/lang/RuntimeException
    //   44: dup
    //   45: ldc 112
    //   47: aload_2
    //   48: invokespecial 59	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   51: athrow
    //   52: aload_3
    //   53: invokevirtual 105	java/io/ByteArrayInputStream:close	()V
    //   56: aload_0
    //   57: invokevirtual 106	java/io/ByteArrayOutputStream:close	()V
    //   60: aload_2
    //   61: athrow
    //   62: astore_2
    //   63: goto -36 -> 27
    //   66: astore_2
    //   67: goto -36 -> 31
    //   70: astore_3
    //   71: goto -15 -> 56
    //   74: astore_0
    //   75: goto -15 -> 60
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	paramArrayOfByte	byte[]
    //   0	78	1	paramInt	int
    //   36	1	2	localObject1	Object
    //   40	21	2	localIOException	IOException
    //   62	1	2	localObject2	Object
    //   66	1	2	localObject3	Object
    //   8	45	3	localByteArrayInputStream	java.io.ByteArrayInputStream
    //   70	1	3	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	23	36	finally
    //   41	52	36	finally
    //   17	23	40	java/io/IOException
    //   23	27	62	finally
    //   27	31	66	finally
    //   52	56	70	finally
    //   56	60	74	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\connectors\Base64.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */