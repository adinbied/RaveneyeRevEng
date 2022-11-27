package com.drew.tools;

import com.drew.imaging.jpeg.JpegProcessingException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URL;

public class ProcessUrlUtility
{
  public static void main(String[] paramArrayOfString)
    throws IOException, JpegProcessingException
  {
    if (paramArrayOfString.length == 0)
    {
      System.err.println("Expects one or more URLs as arguments.");
      System.exit(1);
    }
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      processUrl(new URL(paramArrayOfString[i]));
      i += 1;
    }
    System.out.println("Completed.");
  }
  
  /* Error */
  private static void processUrl(URL paramURL)
    throws IOException
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 53	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   4: invokevirtual 59	java/net/URLConnection:getInputStream	()Ljava/io/InputStream;
    //   7: astore_1
    //   8: aload_1
    //   9: invokestatic 65	com/drew/imaging/ImageMetadataReader:readMetadata	(Ljava/io/InputStream;)Lcom/drew/metadata/Metadata;
    //   12: astore_1
    //   13: aload_1
    //   14: invokevirtual 71	com/drew/metadata/Metadata:hasErrors	()Z
    //   17: ifeq +107 -> 124
    //   20: getstatic 21	java/lang/System:err	Ljava/io/PrintStream;
    //   23: aload_0
    //   24: invokevirtual 74	java/io/PrintStream:println	(Ljava/lang/Object;)V
    //   27: aload_1
    //   28: invokevirtual 78	com/drew/metadata/Metadata:getDirectories	()Ljava/lang/Iterable;
    //   31: invokeinterface 84 1 0
    //   36: astore_0
    //   37: aload_0
    //   38: invokeinterface 89 1 0
    //   43: ifeq +81 -> 124
    //   46: aload_0
    //   47: invokeinterface 93 1 0
    //   52: checkcast 95	com/drew/metadata/Directory
    //   55: astore_2
    //   56: aload_2
    //   57: invokevirtual 96	com/drew/metadata/Directory:hasErrors	()Z
    //   60: ifne +6 -> 66
    //   63: goto -26 -> 37
    //   66: aload_2
    //   67: invokevirtual 99	com/drew/metadata/Directory:getErrors	()Ljava/lang/Iterable;
    //   70: invokeinterface 84 1 0
    //   75: astore_3
    //   76: aload_3
    //   77: invokeinterface 89 1 0
    //   82: ifeq -45 -> 37
    //   85: aload_3
    //   86: invokeinterface 93 1 0
    //   91: checkcast 101	java/lang/String
    //   94: astore 4
    //   96: getstatic 21	java/lang/System:err	Ljava/io/PrintStream;
    //   99: ldc 103
    //   101: iconst_2
    //   102: anewarray 4	java/lang/Object
    //   105: dup
    //   106: iconst_0
    //   107: aload_2
    //   108: invokevirtual 107	com/drew/metadata/Directory:getName	()Ljava/lang/String;
    //   111: aastore
    //   112: dup
    //   113: iconst_1
    //   114: aload 4
    //   116: aastore
    //   117: invokevirtual 111	java/io/PrintStream:printf	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
    //   120: pop
    //   121: goto -45 -> 76
    //   124: aload_1
    //   125: invokevirtual 78	com/drew/metadata/Metadata:getDirectories	()Ljava/lang/Iterable;
    //   128: invokeinterface 84 1 0
    //   133: astore_2
    //   134: aload_2
    //   135: invokeinterface 89 1 0
    //   140: ifeq +143 -> 283
    //   143: aload_2
    //   144: invokeinterface 93 1 0
    //   149: checkcast 95	com/drew/metadata/Directory
    //   152: astore_3
    //   153: aload_3
    //   154: invokevirtual 115	com/drew/metadata/Directory:getTags	()Ljava/util/Collection;
    //   157: invokeinterface 118 1 0
    //   162: astore 4
    //   164: aload 4
    //   166: invokeinterface 89 1 0
    //   171: ifeq -37 -> 134
    //   174: aload 4
    //   176: invokeinterface 93 1 0
    //   181: checkcast 120	com/drew/metadata/Tag
    //   184: astore_0
    //   185: aload_0
    //   186: invokevirtual 123	com/drew/metadata/Tag:getTagName	()Ljava/lang/String;
    //   189: astore 5
    //   191: aload_3
    //   192: invokevirtual 107	com/drew/metadata/Directory:getName	()Ljava/lang/String;
    //   195: astore 6
    //   197: aload_0
    //   198: invokevirtual 126	com/drew/metadata/Tag:getDescription	()Ljava/lang/String;
    //   201: astore_1
    //   202: aload_1
    //   203: astore_0
    //   204: aload_1
    //   205: ifnull +48 -> 253
    //   208: aload_1
    //   209: astore_0
    //   210: aload_1
    //   211: invokevirtual 130	java/lang/String:length	()I
    //   214: sipush 1024
    //   217: if_icmple +36 -> 253
    //   220: new 132	java/lang/StringBuilder
    //   223: dup
    //   224: invokespecial 133	java/lang/StringBuilder:<init>	()V
    //   227: astore_0
    //   228: aload_0
    //   229: aload_1
    //   230: iconst_0
    //   231: sipush 1024
    //   234: invokevirtual 137	java/lang/String:substring	(II)Ljava/lang/String;
    //   237: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   240: pop
    //   241: aload_0
    //   242: ldc -113
    //   244: invokevirtual 141	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   247: pop
    //   248: aload_0
    //   249: invokevirtual 146	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   252: astore_0
    //   253: getstatic 44	java/lang/System:out	Ljava/io/PrintStream;
    //   256: ldc -108
    //   258: iconst_3
    //   259: anewarray 4	java/lang/Object
    //   262: dup
    //   263: iconst_0
    //   264: aload 6
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload 5
    //   271: aastore
    //   272: dup
    //   273: iconst_2
    //   274: aload_0
    //   275: aastore
    //   276: invokevirtual 111	java/io/PrintStream:printf	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
    //   279: pop
    //   280: goto -116 -> 164
    //   283: return
    //   284: astore_1
    //   285: getstatic 21	java/lang/System:err	Ljava/io/PrintStream;
    //   288: ldc -106
    //   290: iconst_2
    //   291: anewarray 4	java/lang/Object
    //   294: dup
    //   295: iconst_0
    //   296: aload_1
    //   297: invokevirtual 154	java/lang/Object:getClass	()Ljava/lang/Class;
    //   300: invokevirtual 157	java/lang/Class:getName	()Ljava/lang/String;
    //   303: aastore
    //   304: dup
    //   305: iconst_1
    //   306: aload_0
    //   307: aastore
    //   308: invokevirtual 111	java/io/PrintStream:printf	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
    //   311: pop
    //   312: aload_1
    //   313: getstatic 21	java/lang/System:err	Ljava/io/PrintStream;
    //   316: invokevirtual 163	java/lang/Throwable:printStackTrace	(Ljava/io/PrintStream;)V
    //   319: return
    //   320: astore_1
    //   321: getstatic 21	java/lang/System:err	Ljava/io/PrintStream;
    //   324: ldc -91
    //   326: iconst_3
    //   327: anewarray 4	java/lang/Object
    //   330: dup
    //   331: iconst_0
    //   332: aload_1
    //   333: invokevirtual 154	java/lang/Object:getClass	()Ljava/lang/Class;
    //   336: invokevirtual 157	java/lang/Class:getName	()Ljava/lang/String;
    //   339: aastore
    //   340: dup
    //   341: iconst_1
    //   342: aload_0
    //   343: aastore
    //   344: dup
    //   345: iconst_2
    //   346: aload_1
    //   347: invokevirtual 168	com/drew/imaging/ImageProcessingException:getMessage	()Ljava/lang/String;
    //   350: aastore
    //   351: invokevirtual 111	java/io/PrintStream:printf	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/io/PrintStream;
    //   354: pop
    //   355: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	356	0	paramURL	URL
    //   7	223	1	localObject1	Object
    //   284	29	1	localObject2	Object
    //   320	27	1	localImageProcessingException	com.drew.imaging.ImageProcessingException
    //   55	89	2	localObject3	Object
    //   75	117	3	localObject4	Object
    //   94	81	4	localObject5	Object
    //   189	81	5	str1	String
    //   195	70	6	str2	String
    // Exception table:
    //   from	to	target	type
    //   8	13	284	finally
    //   8	13	320	com/drew/imaging/ImageProcessingException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\tools\ProcessUrlUtility.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */