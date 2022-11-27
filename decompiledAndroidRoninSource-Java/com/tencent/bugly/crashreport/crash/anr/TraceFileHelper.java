package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.x;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TraceFileHelper
{
  private static String a(BufferedReader paramBufferedReader)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 3)
    {
      String str = paramBufferedReader.readLine();
      if (str == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  private static Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs)
    throws IOException
  {
    if (paramBufferedReader != null)
    {
      if (paramVarArgs == null) {
        return null;
      }
      for (;;)
      {
        String str = paramBufferedReader.readLine();
        if (str == null) {
          break;
        }
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          Pattern localPattern = paramVarArgs[i];
          if (localPattern.matcher(str).matches()) {
            return new Object[] { localPattern, str };
          }
          i += 1;
        }
      }
    }
    return null;
  }
  
  private static String b(BufferedReader paramBufferedReader)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if ((str == null) || (str.trim().length() <= 0)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    return localStringBuffer.toString();
  }
  
  public static a readFirstDumpInfo(String paramString, final boolean paramBoolean)
  {
    if (paramString == null)
    {
      x.e("path:%s", new Object[] { paramString });
      return null;
    }
    a locala = new a();
    readTraceFile(paramString, new b()
    {
      public final boolean a(long paramAnonymousLong)
      {
        x.c("process end %d", new Object[] { Long.valueOf(paramAnonymousLong) });
        return false;
      }
      
      public final boolean a(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
      {
        x.c("new process %s", new Object[] { paramAnonymousString });
        this.a.a = paramAnonymousLong1;
        this.a.b = paramAnonymousString;
        this.a.c = paramAnonymousLong2;
        return paramBoolean;
      }
      
      public final boolean a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
      {
        x.c("new thread %s", new Object[] { paramAnonymousString1 });
        if (this.a.d == null) {
          this.a.d = new HashMap();
        }
        Map localMap = this.a.d;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramAnonymousInt);
        localMap.put(paramAnonymousString1, new String[] { paramAnonymousString2, paramAnonymousString3, localStringBuilder.toString() });
        return true;
      }
    });
    if ((locala.a > 0L) && (locala.c > 0L) && (locala.b != null)) {
      return locala;
    }
    paramString = new StringBuilder();
    paramString.append(locala.a);
    paramString.append(" ");
    paramString.append(locala.c);
    paramString.append(" ");
    paramString.append(locala.b);
    x.e("first dump error %s", new Object[] { paramString.toString() });
    return null;
  }
  
  public static a readTargetDumpInfo(final String paramString1, String paramString2, final boolean paramBoolean)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return null;
      }
      a locala = new a();
      readTraceFile(paramString2, new b()
      {
        public final boolean a(long paramAnonymousLong)
        {
          x.c("process end %d", new Object[] { Long.valueOf(paramAnonymousLong) });
          if ((this.a.a > 0L) && (this.a.c > 0L)) {
            return paramString1 == null;
          }
          return true;
        }
        
        public final boolean a(long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString)
        {
          x.c("new process %s", new Object[] { paramAnonymousString });
          if (!paramAnonymousString.equals(paramString1)) {
            return true;
          }
          this.a.a = paramAnonymousLong1;
          this.a.b = paramAnonymousString;
          this.a.c = paramAnonymousLong2;
          return paramBoolean;
        }
        
        public final boolean a(String paramAnonymousString1, int paramAnonymousInt, String paramAnonymousString2, String paramAnonymousString3)
        {
          x.c("new thread %s", new Object[] { paramAnonymousString1 });
          if ((this.a.a > 0L) && (this.a.c > 0L))
          {
            if (paramString1 == null) {
              return true;
            }
            if (this.a.d == null) {
              this.a.d = new HashMap();
            }
            Map localMap = this.a.d;
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append(paramAnonymousInt);
            localMap.put(paramAnonymousString1, new String[] { paramAnonymousString2, paramAnonymousString3, localStringBuilder.toString() });
          }
          return true;
        }
      });
      if ((locala.a > 0L) && (locala.c > 0L) && (locala.b != null)) {
        return locala;
      }
    }
    return null;
  }
  
  /* Error */
  public static void readTraceFile(String paramString, b paramb)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +683 -> 684
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 113	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 116	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 7
    //   19: aload 7
    //   21: invokevirtual 119	java/io/File:exists	()Z
    //   24: ifne +4 -> 28
    //   27: return
    //   28: aload 7
    //   30: invokevirtual 123	java/io/File:lastModified	()J
    //   33: pop2
    //   34: aload 7
    //   36: invokevirtual 125	java/io/File:length	()J
    //   39: pop2
    //   40: aconst_null
    //   41: astore 8
    //   43: aconst_null
    //   44: astore_0
    //   45: new 27	java/io/BufferedReader
    //   48: dup
    //   49: new 127	java/io/FileReader
    //   52: dup
    //   53: aload 7
    //   55: invokespecial 130	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   58: invokespecial 133	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   61: astore 7
    //   63: ldc -121
    //   65: invokestatic 139	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   68: astore 8
    //   70: ldc -115
    //   72: invokestatic 139	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   75: astore 9
    //   77: ldc -113
    //   79: invokestatic 139	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   82: astore 10
    //   84: ldc -111
    //   86: invokestatic 139	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   89: astore 11
    //   91: new 147	java/text/SimpleDateFormat
    //   94: dup
    //   95: ldc -107
    //   97: getstatic 155	java/util/Locale:US	Ljava/util/Locale;
    //   100: invokespecial 158	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   103: astore_0
    //   104: aload 7
    //   106: iconst_1
    //   107: anewarray 51	java/util/regex/Pattern
    //   110: dup
    //   111: iconst_0
    //   112: aload 8
    //   114: aastore
    //   115: invokestatic 160	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   118: astore 12
    //   120: aload 12
    //   122: ifnull +392 -> 514
    //   125: aload 12
    //   127: iconst_1
    //   128: aaload
    //   129: invokevirtual 161	java/lang/Object:toString	()Ljava/lang/String;
    //   132: ldc -93
    //   134: invokevirtual 167	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   137: astore 12
    //   139: aload 12
    //   141: iconst_2
    //   142: aaload
    //   143: invokestatic 173	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   146: lstore_2
    //   147: new 33	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   154: astore 13
    //   156: aload 13
    //   158: aload 12
    //   160: iconst_4
    //   161: aaload
    //   162: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload 13
    //   168: ldc 102
    //   170: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 13
    //   176: aload 12
    //   178: iconst_5
    //   179: aaload
    //   180: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_0
    //   185: aload 13
    //   187: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokevirtual 177	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   193: invokevirtual 182	java/util/Date:getTime	()J
    //   196: lstore 4
    //   198: aload 7
    //   200: iconst_1
    //   201: anewarray 51	java/util/regex/Pattern
    //   204: dup
    //   205: iconst_0
    //   206: aload 10
    //   208: aastore
    //   209: invokestatic 160	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   212: astore 12
    //   214: aload 12
    //   216: ifnonnull +22 -> 238
    //   219: aload 7
    //   221: invokevirtual 185	java/io/BufferedReader:close	()V
    //   224: return
    //   225: astore_0
    //   226: aload_0
    //   227: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   230: ifne +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   237: return
    //   238: aload 10
    //   240: aload 12
    //   242: iconst_1
    //   243: aaload
    //   244: invokevirtual 161	java/lang/Object:toString	()Ljava/lang/String;
    //   247: invokevirtual 55	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   250: astore 12
    //   252: aload 12
    //   254: invokevirtual 194	java/util/regex/Matcher:find	()Z
    //   257: pop
    //   258: aload 12
    //   260: iconst_1
    //   261: invokevirtual 198	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   264: pop
    //   265: aload_1
    //   266: lload_2
    //   267: lload 4
    //   269: aload 12
    //   271: iconst_1
    //   272: invokevirtual 198	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   275: invokeinterface 201 6 0
    //   280: istore 6
    //   282: iload 6
    //   284: ifne +22 -> 306
    //   287: aload 7
    //   289: invokevirtual 185	java/io/BufferedReader:close	()V
    //   292: return
    //   293: astore_0
    //   294: aload_0
    //   295: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   298: ifne +7 -> 305
    //   301: aload_0
    //   302: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   305: return
    //   306: aload 7
    //   308: iconst_2
    //   309: anewarray 51	java/util/regex/Pattern
    //   312: dup
    //   313: iconst_0
    //   314: aload 11
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: aload 9
    //   321: aastore
    //   322: invokestatic 160	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   325: astore 12
    //   327: aload 12
    //   329: ifnull +182 -> 511
    //   332: aload 12
    //   334: iconst_0
    //   335: aaload
    //   336: aload 11
    //   338: if_acmpne +124 -> 462
    //   341: aload 12
    //   343: iconst_1
    //   344: aaload
    //   345: invokevirtual 161	java/lang/Object:toString	()Ljava/lang/String;
    //   348: astore 12
    //   350: ldc -53
    //   352: invokestatic 139	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   355: aload 12
    //   357: invokevirtual 55	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   360: astore 13
    //   362: aload 13
    //   364: invokevirtual 194	java/util/regex/Matcher:find	()Z
    //   367: pop
    //   368: aload 13
    //   370: invokevirtual 205	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   373: astore 13
    //   375: aload 13
    //   377: iconst_1
    //   378: aload 13
    //   380: invokevirtual 70	java/lang/String:length	()I
    //   383: iconst_1
    //   384: isub
    //   385: invokevirtual 209	java/lang/String:substring	(II)Ljava/lang/String;
    //   388: astore 13
    //   390: aload 12
    //   392: ldc -45
    //   394: invokevirtual 215	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   397: pop
    //   398: ldc -39
    //   400: invokestatic 139	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   403: aload 12
    //   405: invokevirtual 55	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   408: astore 12
    //   410: aload 12
    //   412: invokevirtual 194	java/util/regex/Matcher:find	()Z
    //   415: pop
    //   416: aload 12
    //   418: invokevirtual 205	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   421: astore 12
    //   423: aload_1
    //   424: aload 13
    //   426: aload 12
    //   428: aload 12
    //   430: ldc -37
    //   432: invokevirtual 223	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   435: iconst_1
    //   436: iadd
    //   437: invokevirtual 225	java/lang/String:substring	(I)Ljava/lang/String;
    //   440: invokestatic 230	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   443: aload 7
    //   445: invokestatic 232	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:a	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   448: aload 7
    //   450: invokestatic 234	com/tencent/bugly/crashreport/crash/anr/TraceFileHelper:b	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   453: invokeinterface 237 5 0
    //   458: pop
    //   459: goto -153 -> 306
    //   462: aload_1
    //   463: aload 12
    //   465: iconst_1
    //   466: aaload
    //   467: invokevirtual 161	java/lang/Object:toString	()Ljava/lang/String;
    //   470: ldc -93
    //   472: invokevirtual 167	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   475: iconst_2
    //   476: aaload
    //   477: invokestatic 173	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   480: invokeinterface 240 3 0
    //   485: istore 6
    //   487: iload 6
    //   489: ifne +22 -> 511
    //   492: aload 7
    //   494: invokevirtual 185	java/io/BufferedReader:close	()V
    //   497: return
    //   498: astore_0
    //   499: aload_0
    //   500: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   503: ifne +7 -> 510
    //   506: aload_0
    //   507: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   510: return
    //   511: goto -407 -> 104
    //   514: aload 7
    //   516: invokevirtual 185	java/io/BufferedReader:close	()V
    //   519: return
    //   520: astore_0
    //   521: aload_0
    //   522: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   525: ifne +7 -> 532
    //   528: aload_0
    //   529: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   532: return
    //   533: astore_1
    //   534: aload 7
    //   536: astore_0
    //   537: goto +122 -> 659
    //   540: astore_0
    //   541: aload 7
    //   543: astore_1
    //   544: aload_0
    //   545: astore 7
    //   547: goto +12 -> 559
    //   550: astore_1
    //   551: goto +108 -> 659
    //   554: astore 7
    //   556: aload 8
    //   558: astore_1
    //   559: aload_1
    //   560: astore_0
    //   561: aload 7
    //   563: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   566: ifne +10 -> 576
    //   569: aload_1
    //   570: astore_0
    //   571: aload 7
    //   573: invokevirtual 241	java/lang/Exception:printStackTrace	()V
    //   576: aload_1
    //   577: astore_0
    //   578: aload 7
    //   580: invokevirtual 245	java/lang/Object:getClass	()Ljava/lang/Class;
    //   583: invokevirtual 250	java/lang/Class:getName	()Ljava/lang/String;
    //   586: astore 8
    //   588: aload_1
    //   589: astore_0
    //   590: new 33	java/lang/StringBuilder
    //   593: dup
    //   594: invokespecial 34	java/lang/StringBuilder:<init>	()V
    //   597: astore 9
    //   599: aload_1
    //   600: astore_0
    //   601: aload 9
    //   603: aload 7
    //   605: invokevirtual 253	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   608: invokevirtual 38	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   611: pop
    //   612: aload_1
    //   613: astore_0
    //   614: ldc -1
    //   616: iconst_2
    //   617: anewarray 4	java/lang/Object
    //   620: dup
    //   621: iconst_0
    //   622: aload 8
    //   624: aastore
    //   625: dup
    //   626: iconst_1
    //   627: aload 9
    //   629: invokevirtual 43	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   632: aastore
    //   633: invokestatic 258	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   636: pop
    //   637: aload_1
    //   638: ifnull +20 -> 658
    //   641: aload_1
    //   642: invokevirtual 185	java/io/BufferedReader:close	()V
    //   645: return
    //   646: astore_0
    //   647: aload_0
    //   648: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   651: ifne +7 -> 658
    //   654: aload_0
    //   655: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   658: return
    //   659: aload_0
    //   660: ifnull +22 -> 682
    //   663: aload_0
    //   664: invokevirtual 185	java/io/BufferedReader:close	()V
    //   667: goto +15 -> 682
    //   670: astore_0
    //   671: aload_0
    //   672: invokestatic 188	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   675: ifne +7 -> 682
    //   678: aload_0
    //   679: invokevirtual 191	java/io/IOException:printStackTrace	()V
    //   682: aload_1
    //   683: athrow
    //   684: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	685	0	paramString	String
    //   0	685	1	paramb	b
    //   146	121	2	l1	long
    //   196	72	4	l2	long
    //   280	208	6	bool	boolean
    //   17	529	7	localObject1	Object
    //   554	50	7	localException	Exception
    //   41	582	8	localObject2	Object
    //   75	553	9	localObject3	Object
    //   82	157	10	localPattern1	Pattern
    //   89	248	11	localPattern2	Pattern
    //   118	346	12	localObject4	Object
    //   154	271	13	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   219	224	225	java/io/IOException
    //   287	292	293	java/io/IOException
    //   492	497	498	java/io/IOException
    //   514	519	520	java/io/IOException
    //   63	104	533	finally
    //   104	120	533	finally
    //   125	214	533	finally
    //   238	282	533	finally
    //   306	327	533	finally
    //   341	459	533	finally
    //   462	487	533	finally
    //   63	104	540	java/lang/Exception
    //   104	120	540	java/lang/Exception
    //   125	214	540	java/lang/Exception
    //   238	282	540	java/lang/Exception
    //   306	327	540	java/lang/Exception
    //   341	459	540	java/lang/Exception
    //   462	487	540	java/lang/Exception
    //   45	63	550	finally
    //   561	569	550	finally
    //   571	576	550	finally
    //   578	588	550	finally
    //   590	599	550	finally
    //   601	612	550	finally
    //   614	637	550	finally
    //   45	63	554	java/lang/Exception
    //   641	645	646	java/io/IOException
    //   663	667	670	java/io/IOException
  }
  
  public static final class a
  {
    public long a;
    public String b;
    public long c;
    public Map<String, String[]> d;
  }
  
  public static abstract interface b
  {
    public abstract boolean a(long paramLong);
    
    public abstract boolean a(long paramLong1, long paramLong2, String paramString);
    
    public abstract boolean a(String paramString1, int paramInt, String paramString2, String paramString3);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\crashreport\crash\anr\TraceFileHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */