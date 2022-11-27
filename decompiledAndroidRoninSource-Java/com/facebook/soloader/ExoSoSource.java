package com.facebook.soloader;

import android.content.Context;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class ExoSoSource
  extends UnpackingSoSource
{
  public ExoSoSource(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  protected UnpackingSoSource.Unpacker makeUnpacker()
    throws IOException
  {
    return new ExoUnpacker(this);
  }
  
  private final class ExoUnpacker
    extends UnpackingSoSource.Unpacker
  {
    private final ExoSoSource.FileDso[] mDsos;
    
    /* Error */
    ExoUnpacker(UnpackingSoSource paramUnpackingSoSource)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: aload_1
      //   2: putfield 20	com/facebook/soloader/ExoSoSource$ExoUnpacker:this$0	Lcom/facebook/soloader/ExoSoSource;
      //   5: aload_0
      //   6: invokespecial 23	com/facebook/soloader/UnpackingSoSource$Unpacker:<init>	()V
      //   9: aload_1
      //   10: getfield 27	com/facebook/soloader/ExoSoSource:mContext	Landroid/content/Context;
      //   13: astore_1
      //   14: new 29	java/lang/StringBuilder
      //   17: dup
      //   18: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   21: astore 8
      //   23: aload 8
      //   25: ldc 32
      //   27: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   30: pop
      //   31: aload 8
      //   33: aload_1
      //   34: invokevirtual 42	android/content/Context:getPackageName	()Ljava/lang/String;
      //   37: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   40: pop
      //   41: aload 8
      //   43: ldc 44
      //   45: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   48: pop
      //   49: new 46	java/io/File
      //   52: dup
      //   53: aload 8
      //   55: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   58: invokespecial 52	java/io/File:<init>	(Ljava/lang/String;)V
      //   61: astore 9
      //   63: new 54	java/util/ArrayList
      //   66: dup
      //   67: invokespecial 55	java/util/ArrayList:<init>	()V
      //   70: astore 10
      //   72: new 57	java/util/LinkedHashSet
      //   75: dup
      //   76: invokespecial 58	java/util/LinkedHashSet:<init>	()V
      //   79: astore 11
      //   81: invokestatic 64	com/facebook/soloader/SysUtil:getSupportedAbis	()[Ljava/lang/String;
      //   84: astore 12
      //   86: aload 12
      //   88: arraylength
      //   89: istore 5
      //   91: iconst_0
      //   92: istore_3
      //   93: iload_3
      //   94: iload 5
      //   96: if_icmpge +345 -> 441
      //   99: aload 12
      //   101: iload_3
      //   102: aaload
      //   103: astore_1
      //   104: new 46	java/io/File
      //   107: dup
      //   108: aload 9
      //   110: aload_1
      //   111: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   114: astore 13
      //   116: aload 13
      //   118: invokevirtual 71	java/io/File:isDirectory	()Z
      //   121: ifne +6 -> 127
      //   124: goto +265 -> 389
      //   127: aload 11
      //   129: aload_1
      //   130: invokeinterface 77 2 0
      //   135: pop
      //   136: new 46	java/io/File
      //   139: dup
      //   140: aload 13
      //   142: ldc 79
      //   144: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   147: astore_1
      //   148: aload_1
      //   149: invokevirtual 82	java/io/File:isFile	()Z
      //   152: ifne +6 -> 158
      //   155: goto +234 -> 389
      //   158: new 84	java/io/FileReader
      //   161: dup
      //   162: aload_1
      //   163: invokespecial 87	java/io/FileReader:<init>	(Ljava/io/File;)V
      //   166: astore_1
      //   167: new 89	java/io/BufferedReader
      //   170: dup
      //   171: aload_1
      //   172: invokespecial 92	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
      //   175: astore 8
      //   177: aload 8
      //   179: invokevirtual 95	java/io/BufferedReader:readLine	()Ljava/lang/String;
      //   182: astore 14
      //   184: aload 14
      //   186: ifnull +194 -> 380
      //   189: aload 14
      //   191: invokevirtual 101	java/lang/String:length	()I
      //   194: ifne +6 -> 200
      //   197: goto -20 -> 177
      //   200: aload 14
      //   202: bipush 32
      //   204: invokevirtual 105	java/lang/String:indexOf	(I)I
      //   207: istore 6
      //   209: iload 6
      //   211: iconst_m1
      //   212: if_icmpeq +127 -> 339
      //   215: new 29	java/lang/StringBuilder
      //   218: dup
      //   219: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   222: astore 15
      //   224: aload 15
      //   226: aload 14
      //   228: iconst_0
      //   229: iload 6
      //   231: invokevirtual 109	java/lang/String:substring	(II)Ljava/lang/String;
      //   234: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   237: pop
      //   238: aload 15
      //   240: ldc 111
      //   242: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   245: pop
      //   246: aload 15
      //   248: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   251: astore 15
      //   253: aload 10
      //   255: invokevirtual 114	java/util/ArrayList:size	()I
      //   258: istore 7
      //   260: iconst_0
      //   261: istore 4
      //   263: iload 4
      //   265: iload 7
      //   267: if_icmpge +228 -> 495
      //   270: aload 10
      //   272: iload 4
      //   274: invokevirtual 118	java/util/ArrayList:get	(I)Ljava/lang/Object;
      //   277: checkcast 120	com/facebook/soloader/ExoSoSource$FileDso
      //   280: getfield 124	com/facebook/soloader/ExoSoSource$FileDso:name	Ljava/lang/String;
      //   283: aload 15
      //   285: invokevirtual 127	java/lang/String:equals	(Ljava/lang/Object;)Z
      //   288: ifeq +198 -> 486
      //   291: iconst_1
      //   292: istore 4
      //   294: goto +204 -> 498
      //   297: aload 14
      //   299: iload 6
      //   301: iconst_1
      //   302: iadd
      //   303: invokevirtual 130	java/lang/String:substring	(I)Ljava/lang/String;
      //   306: astore 14
      //   308: aload 10
      //   310: new 120	com/facebook/soloader/ExoSoSource$FileDso
      //   313: dup
      //   314: aload 15
      //   316: aload 14
      //   318: new 46	java/io/File
      //   321: dup
      //   322: aload 13
      //   324: aload 14
      //   326: invokespecial 67	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
      //   329: invokespecial 133	com/facebook/soloader/ExoSoSource$FileDso:<init>	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)V
      //   332: invokevirtual 134	java/util/ArrayList:add	(Ljava/lang/Object;)Z
      //   335: pop
      //   336: goto +167 -> 503
      //   339: new 29	java/lang/StringBuilder
      //   342: dup
      //   343: invokespecial 30	java/lang/StringBuilder:<init>	()V
      //   346: astore_2
      //   347: aload_2
      //   348: ldc -120
      //   350: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   353: pop
      //   354: aload_2
      //   355: aload 14
      //   357: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   360: pop
      //   361: aload_2
      //   362: ldc -118
      //   364: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   367: pop
      //   368: new 140	java/lang/RuntimeException
      //   371: dup
      //   372: aload_2
      //   373: invokevirtual 49	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   376: invokespecial 141	java/lang/RuntimeException:<init>	(Ljava/lang/String;)V
      //   379: athrow
      //   380: aload 8
      //   382: invokevirtual 144	java/io/BufferedReader:close	()V
      //   385: aload_1
      //   386: invokevirtual 145	java/io/FileReader:close	()V
      //   389: iload_3
      //   390: iconst_1
      //   391: iadd
      //   392: istore_3
      //   393: goto -300 -> 93
      //   396: astore_2
      //   397: aload_2
      //   398: athrow
      //   399: astore 9
      //   401: aload 8
      //   403: invokevirtual 144	java/io/BufferedReader:close	()V
      //   406: goto +11 -> 417
      //   409: astore 8
      //   411: aload_2
      //   412: aload 8
      //   414: invokevirtual 151	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   417: aload 9
      //   419: athrow
      //   420: astore_2
      //   421: aload_2
      //   422: athrow
      //   423: astore 8
      //   425: aload_1
      //   426: invokevirtual 145	java/io/FileReader:close	()V
      //   429: goto +9 -> 438
      //   432: astore_1
      //   433: aload_2
      //   434: aload_1
      //   435: invokevirtual 151	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
      //   438: aload 8
      //   440: athrow
      //   441: aload_2
      //   442: aload 11
      //   444: aload 11
      //   446: invokeinterface 152 1 0
      //   451: anewarray 97	java/lang/String
      //   454: invokeinterface 156 2 0
      //   459: checkcast 158	[Ljava/lang/String;
      //   462: invokevirtual 164	com/facebook/soloader/UnpackingSoSource:setSoSourceAbis	([Ljava/lang/String;)V
      //   465: aload_0
      //   466: aload 10
      //   468: aload 10
      //   470: invokevirtual 114	java/util/ArrayList:size	()I
      //   473: anewarray 120	com/facebook/soloader/ExoSoSource$FileDso
      //   476: invokevirtual 165	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
      //   479: checkcast 166	[Lcom/facebook/soloader/ExoSoSource$FileDso;
      //   482: putfield 168	com/facebook/soloader/ExoSoSource$ExoUnpacker:mDsos	[Lcom/facebook/soloader/ExoSoSource$FileDso;
      //   485: return
      //   486: iload 4
      //   488: iconst_1
      //   489: iadd
      //   490: istore 4
      //   492: goto -229 -> 263
      //   495: iconst_0
      //   496: istore 4
      //   498: iload 4
      //   500: ifeq -203 -> 297
      //   503: goto -326 -> 177
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	506	0	this	ExoUnpacker
      //   0	506	1	this$1	ExoSoSource
      //   0	506	2	paramUnpackingSoSource	UnpackingSoSource
      //   92	301	3	i	int
      //   261	238	4	j	int
      //   89	8	5	k	int
      //   207	96	6	m	int
      //   258	10	7	n	int
      //   21	381	8	localObject1	Object
      //   409	4	8	localThrowable	Throwable
      //   423	16	8	localObject2	Object
      //   61	48	9	localFile1	File
      //   399	19	9	localObject3	Object
      //   70	399	10	localArrayList	java.util.ArrayList
      //   79	366	11	localLinkedHashSet	java.util.LinkedHashSet
      //   84	16	12	arrayOfString	String[]
      //   114	209	13	localFile2	File
      //   182	174	14	str	String
      //   222	93	15	localObject4	Object
      // Exception table:
      //   from	to	target	type
      //   177	184	396	finally
      //   189	197	396	finally
      //   200	209	396	finally
      //   215	260	396	finally
      //   270	291	396	finally
      //   297	336	396	finally
      //   339	380	396	finally
      //   397	399	399	finally
      //   401	406	409	finally
      //   167	177	420	finally
      //   380	385	420	finally
      //   411	417	420	finally
      //   417	420	420	finally
      //   421	423	423	finally
      //   425	429	432	finally
    }
    
    protected UnpackingSoSource.DsoManifest getDsoManifest()
      throws IOException
    {
      return new UnpackingSoSource.DsoManifest(this.mDsos);
    }
    
    protected UnpackingSoSource.InputDsoIterator openDsoIterator()
      throws IOException
    {
      return new FileBackedInputDsoIterator(null);
    }
    
    private final class FileBackedInputDsoIterator
      extends UnpackingSoSource.InputDsoIterator
    {
      private int mCurrentDso;
      
      private FileBackedInputDsoIterator() {}
      
      public boolean hasNext()
      {
        return this.mCurrentDso < ExoSoSource.ExoUnpacker.this.mDsos.length;
      }
      
      public UnpackingSoSource.InputDso next()
        throws IOException
      {
        Object localObject1 = ExoSoSource.ExoUnpacker.this.mDsos;
        int i = this.mCurrentDso;
        this.mCurrentDso = (i + 1);
        Object localObject2 = localObject1[i];
        localObject1 = new FileInputStream(((ExoSoSource.FileDso)localObject2).backingFile);
        try
        {
          localObject2 = new UnpackingSoSource.InputDso((UnpackingSoSource.Dso)localObject2, (InputStream)localObject1);
          return (UnpackingSoSource.InputDso)localObject2;
        }
        finally
        {
          ((FileInputStream)localObject1).close();
        }
      }
    }
  }
  
  private static final class FileDso
    extends UnpackingSoSource.Dso
  {
    final File backingFile;
    
    FileDso(String paramString1, String paramString2, File paramFile)
    {
      super(paramString2);
      this.backingFile = paramFile;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\ExoSoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */