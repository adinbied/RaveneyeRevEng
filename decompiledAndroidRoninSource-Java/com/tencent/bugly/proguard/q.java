package com.tencent.bugly.proguard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.tencent.bugly.a;
import java.util.List;

public final class q
  extends SQLiteOpenHelper
{
  public static String a = "bugly_db";
  private static int b = 15;
  private Context c;
  private List<a> d;
  
  public q(Context paramContext, List<a> paramList)
  {
    super(paramContext, localStringBuilder.toString(), null, b);
    this.c = paramContext;
    this.d = paramList;
  }
  
  private boolean a(SQLiteDatabase paramSQLiteDatabase)
  {
    int i = 0;
    for (;;)
    {
      if (i < 3) {}
      try
      {
        String str = new String[] { "t_lr", "t_ui", "t_pf" }[i];
        StringBuilder localStringBuilder = new StringBuilder("DROP TABLE IF EXISTS ");
        localStringBuilder.append(str);
        paramSQLiteDatabase.execSQL(localStringBuilder.toString(), new String[0]);
        i += 1;
      }
      finally
      {
        paramSQLiteDatabase = finally;
        try
        {
          if (x.b(paramSQLiteDatabase)) {
            break label85;
          }
          paramSQLiteDatabase.printStackTrace();
          return false;
        }
        finally
        {
          paramSQLiteDatabase = finally;
          throw paramSQLiteDatabase;
        }
      }
    }
    return true;
  }
  
  public final SQLiteDatabase getReadableDatabase()
  {
    Object localObject1 = null;
    int i = 0;
    while ((localObject1 == null) && (i < 5))
    {
      i += 1;
      for (;;)
      {
        try
        {
          SQLiteDatabase localSQLiteDatabase2 = super.getReadableDatabase();
          localObject1 = localSQLiteDatabase2;
          break;
        }
        finally
        {
          localObject2 = finally;
          continue;
        }
        try
        {
          x.d("[Database] Try to get db(count: %d).", new Object[] { Integer.valueOf(i) });
          if (i == 5) {
            x.e("[Database] Failed to get db.", new Object[0]);
          }
          try
          {
            Thread.sleep(200L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          break;
        }
        finally {}
      }
    }
    return localSQLiteDatabase1;
  }
  
  public final SQLiteDatabase getWritableDatabase()
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      if ((localObject1 == null) && (i < 5)) {
        i += 1;
      }
      for (;;)
      {
        try
        {
          SQLiteDatabase localSQLiteDatabase2 = super.getWritableDatabase();
          localObject1 = localSQLiteDatabase2;
          break;
        }
        finally
        {
          localObject2 = finally;
          continue;
        }
        try
        {
          x.d("[Database] Try to get db(count: %d).", new Object[] { Integer.valueOf(i) });
          if (i == 5) {
            x.e("[Database] Failed to get db.", new Object[0]);
          }
          try
          {
            Thread.sleep(200L);
          }
          catch (InterruptedException localInterruptedException)
          {
            localInterruptedException.printStackTrace();
          }
          break;
        }
        finally {}
      }
    }
    if (localObject1 == null) {
      x.d("[Database] db error delay error record 1min.", new Object[0]);
    }
    return localSQLiteDatabase1;
  }
  
  /* Error */
  public final void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 23	java/lang/StringBuilder
    //   5: dup
    //   6: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   9: astore_2
    //   10: aload_2
    //   11: iconst_0
    //   12: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   15: aload_2
    //   16: ldc -123
    //   18: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: ldc -121
    //   25: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: ldc -119
    //   32: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc -117
    //   39: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc -115
    //   46: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   49: pop
    //   50: aload_2
    //   51: ldc -113
    //   53: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: ldc -115
    //   60: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: pop
    //   64: aload_2
    //   65: ldc -111
    //   67: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   70: pop
    //   71: aload_2
    //   72: ldc -115
    //   74: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload_2
    //   79: ldc -109
    //   81: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload_2
    //   86: ldc -107
    //   88: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: pop
    //   92: aload_2
    //   93: ldc -105
    //   95: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload_2
    //   100: ldc -103
    //   102: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload_2
    //   107: ldc -101
    //   109: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   112: pop
    //   113: aload_2
    //   114: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: iconst_0
    //   118: anewarray 40	java/lang/Object
    //   121: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   124: pop
    //   125: aload_1
    //   126: aload_2
    //   127: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   130: iconst_0
    //   131: anewarray 62	java/lang/String
    //   134: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   137: aload_2
    //   138: iconst_0
    //   139: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   142: aload_2
    //   143: ldc -97
    //   145: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: pop
    //   149: aload_2
    //   150: ldc -121
    //   152: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: pop
    //   156: aload_2
    //   157: ldc -119
    //   159: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload_2
    //   164: ldc -111
    //   166: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   169: pop
    //   170: aload_2
    //   171: ldc -115
    //   173: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload_2
    //   178: ldc -117
    //   180: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload_2
    //   185: ldc -115
    //   187: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   190: pop
    //   191: aload_2
    //   192: ldc -105
    //   194: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: pop
    //   198: aload_2
    //   199: ldc -103
    //   201: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   204: pop
    //   205: aload_2
    //   206: ldc -95
    //   208: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload_2
    //   213: ldc -103
    //   215: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   218: pop
    //   219: aload_2
    //   220: ldc -109
    //   222: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   225: pop
    //   226: aload_2
    //   227: ldc -107
    //   229: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_2
    //   234: ldc -101
    //   236: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: pop
    //   240: aload_2
    //   241: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   244: iconst_0
    //   245: anewarray 40	java/lang/Object
    //   248: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   251: pop
    //   252: aload_1
    //   253: aload_2
    //   254: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   257: iconst_0
    //   258: anewarray 62	java/lang/String
    //   261: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   264: aload_2
    //   265: iconst_0
    //   266: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   269: aload_2
    //   270: ldc -93
    //   272: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: pop
    //   276: aload_2
    //   277: ldc -121
    //   279: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload_2
    //   284: ldc -91
    //   286: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: pop
    //   290: aload_2
    //   291: ldc -111
    //   293: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: pop
    //   297: aload_2
    //   298: ldc -103
    //   300: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: pop
    //   304: aload_2
    //   305: ldc -117
    //   307: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   310: pop
    //   311: aload_2
    //   312: ldc -115
    //   314: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: pop
    //   318: aload_2
    //   319: ldc -109
    //   321: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload_2
    //   326: ldc -107
    //   328: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   331: pop
    //   332: aload_2
    //   333: ldc -89
    //   335: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   338: pop
    //   339: aload_2
    //   340: ldc -87
    //   342: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: pop
    //   346: aload_2
    //   347: ldc -85
    //   349: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_2
    //   354: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   357: iconst_0
    //   358: anewarray 40	java/lang/Object
    //   361: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   364: pop
    //   365: aload_1
    //   366: aload_2
    //   367: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: iconst_0
    //   371: anewarray 62	java/lang/String
    //   374: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   377: aload_2
    //   378: iconst_0
    //   379: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   382: aload_2
    //   383: ldc -83
    //   385: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload_2
    //   390: ldc -121
    //   392: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   395: pop
    //   396: aload_2
    //   397: ldc -119
    //   399: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: pop
    //   403: aload_2
    //   404: ldc -117
    //   406: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   409: pop
    //   410: aload_2
    //   411: ldc -115
    //   413: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   416: pop
    //   417: aload_2
    //   418: ldc -81
    //   420: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_2
    //   425: ldc -103
    //   427: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_2
    //   432: ldc -79
    //   434: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   437: pop
    //   438: aload_2
    //   439: ldc -115
    //   441: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: pop
    //   445: aload_2
    //   446: ldc -77
    //   448: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload_2
    //   453: ldc -115
    //   455: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: pop
    //   459: aload_2
    //   460: ldc -75
    //   462: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   465: pop
    //   466: aload_2
    //   467: ldc -115
    //   469: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload_2
    //   474: ldc -109
    //   476: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload_2
    //   481: ldc -107
    //   483: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload_2
    //   488: ldc -101
    //   490: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: aload_2
    //   495: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   498: iconst_0
    //   499: anewarray 40	java/lang/Object
    //   502: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   505: pop
    //   506: aload_1
    //   507: aload_2
    //   508: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   511: iconst_0
    //   512: anewarray 62	java/lang/String
    //   515: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   518: aload_2
    //   519: iconst_0
    //   520: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   523: aload_2
    //   524: ldc -73
    //   526: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   529: pop
    //   530: aload_2
    //   531: ldc -71
    //   533: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   536: pop
    //   537: aload_2
    //   538: ldc -69
    //   540: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload_2
    //   545: ldc -67
    //   547: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: pop
    //   551: aload_2
    //   552: ldc -65
    //   554: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   557: pop
    //   558: aload_2
    //   559: ldc -63
    //   561: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   564: pop
    //   565: aload_2
    //   566: ldc -61
    //   568: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   571: pop
    //   572: aload_2
    //   573: ldc -59
    //   575: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   578: pop
    //   579: aload_2
    //   580: ldc -57
    //   582: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   585: pop
    //   586: aload_2
    //   587: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   590: iconst_0
    //   591: anewarray 40	java/lang/Object
    //   594: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   597: pop
    //   598: aload_1
    //   599: aload_2
    //   600: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   603: iconst_0
    //   604: anewarray 62	java/lang/String
    //   607: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   610: aload_2
    //   611: iconst_0
    //   612: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   615: aload_2
    //   616: ldc -55
    //   618: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   621: pop
    //   622: aload_2
    //   623: ldc -71
    //   625: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   628: pop
    //   629: aload_2
    //   630: ldc -53
    //   632: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: pop
    //   636: aload_2
    //   637: ldc -51
    //   639: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   642: pop
    //   643: aload_2
    //   644: ldc -49
    //   646: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   649: pop
    //   650: aload_2
    //   651: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: iconst_0
    //   655: anewarray 40	java/lang/Object
    //   658: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   661: pop
    //   662: aload_1
    //   663: aload_2
    //   664: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   667: iconst_0
    //   668: anewarray 62	java/lang/String
    //   671: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   674: aload_2
    //   675: iconst_0
    //   676: invokevirtual 131	java/lang/StringBuilder:setLength	(I)V
    //   679: aload_2
    //   680: ldc -47
    //   682: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   685: pop
    //   686: aload_2
    //   687: ldc -121
    //   689: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   692: pop
    //   693: aload_2
    //   694: ldc -91
    //   696: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   699: pop
    //   700: aload_2
    //   701: ldc -111
    //   703: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   706: pop
    //   707: aload_2
    //   708: ldc -103
    //   710: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: pop
    //   714: aload_2
    //   715: ldc -117
    //   717: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   720: pop
    //   721: aload_2
    //   722: ldc -115
    //   724: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   727: pop
    //   728: aload_2
    //   729: ldc -109
    //   731: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: pop
    //   735: aload_2
    //   736: ldc -107
    //   738: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   741: pop
    //   742: aload_2
    //   743: ldc -89
    //   745: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   748: pop
    //   749: aload_2
    //   750: ldc -87
    //   752: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   755: pop
    //   756: aload_2
    //   757: ldc -85
    //   759: invokevirtual 31	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   762: pop
    //   763: aload_2
    //   764: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   767: iconst_0
    //   768: anewarray 40	java/lang/Object
    //   771: invokestatic 157	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   774: pop
    //   775: aload_1
    //   776: aload_2
    //   777: invokevirtual 48	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   780: iconst_0
    //   781: anewarray 62	java/lang/String
    //   784: invokevirtual 79	android/database/sqlite/SQLiteDatabase:execSQL	(Ljava/lang/String;[Ljava/lang/Object;)V
    //   787: goto +15 -> 802
    //   790: astore_2
    //   791: aload_2
    //   792: invokestatic 84	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   795: ifne +7 -> 802
    //   798: aload_2
    //   799: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   802: aload_0
    //   803: getfield 57	com/tencent/bugly/proguard/q:d	Ljava/util/List;
    //   806: astore_2
    //   807: aload_2
    //   808: ifnonnull +6 -> 814
    //   811: aload_0
    //   812: monitorexit
    //   813: return
    //   814: aload_0
    //   815: getfield 57	com/tencent/bugly/proguard/q:d	Ljava/util/List;
    //   818: invokeinterface 215 1 0
    //   823: astore_2
    //   824: aload_2
    //   825: invokeinterface 221 1 0
    //   830: ifeq +36 -> 866
    //   833: aload_2
    //   834: invokeinterface 225 1 0
    //   839: checkcast 227	com/tencent/bugly/a
    //   842: astore_3
    //   843: aload_3
    //   844: aload_1
    //   845: invokevirtual 230	com/tencent/bugly/a:onDbCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   848: goto -24 -> 824
    //   851: astore_3
    //   852: aload_3
    //   853: invokestatic 84	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   856: ifne -32 -> 824
    //   859: aload_3
    //   860: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   863: goto -39 -> 824
    //   866: aload_0
    //   867: monitorexit
    //   868: return
    //   869: astore_1
    //   870: aload_0
    //   871: monitorexit
    //   872: aload_1
    //   873: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	874	0	this	q
    //   0	874	1	paramSQLiteDatabase	SQLiteDatabase
    //   9	768	2	localStringBuilder	StringBuilder
    //   790	9	2	localThrowable1	Throwable
    //   806	28	2	localObject	Object
    //   842	2	3	locala	a
    //   851	9	3	localThrowable2	Throwable
    // Exception table:
    //   from	to	target	type
    //   2	787	790	finally
    //   843	848	851	finally
    //   791	802	869	finally
    //   802	807	869	finally
    //   814	824	869	finally
    //   824	843	869	finally
    //   852	863	869	finally
  }
  
  /* Error */
  public final void onDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 237	com/tencent/bugly/crashreport/common/info/b:c	()I
    //   5: bipush 11
    //   7: if_icmplt +149 -> 156
    //   10: ldc -17
    //   12: iconst_2
    //   13: anewarray 40	java/lang/Object
    //   16: dup
    //   17: iconst_0
    //   18: iload_2
    //   19: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aastore
    //   23: dup
    //   24: iconst_1
    //   25: iload_3
    //   26: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   29: aastore
    //   30: invokestatic 106	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   33: pop
    //   34: aload_0
    //   35: getfield 57	com/tencent/bugly/proguard/q:d	Ljava/util/List;
    //   38: ifnull +65 -> 103
    //   41: aload_0
    //   42: getfield 57	com/tencent/bugly/proguard/q:d	Ljava/util/List;
    //   45: invokeinterface 215 1 0
    //   50: astore 4
    //   52: aload 4
    //   54: invokeinterface 221 1 0
    //   59: ifeq +44 -> 103
    //   62: aload 4
    //   64: invokeinterface 225 1 0
    //   69: checkcast 227	com/tencent/bugly/a
    //   72: astore 5
    //   74: aload 5
    //   76: aload_1
    //   77: iload_2
    //   78: iload_3
    //   79: invokevirtual 242	com/tencent/bugly/a:onDbDowngrade	(Landroid/database/sqlite/SQLiteDatabase;II)V
    //   82: goto -30 -> 52
    //   85: astore 5
    //   87: aload 5
    //   89: invokestatic 84	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   92: ifne -40 -> 52
    //   95: aload 5
    //   97: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   100: goto -48 -> 52
    //   103: aload_0
    //   104: aload_1
    //   105: invokespecial 244	com/tencent/bugly/proguard/q:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   108: ifeq +11 -> 119
    //   111: aload_0
    //   112: aload_1
    //   113: invokevirtual 246	com/tencent/bugly/proguard/q:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   116: aload_0
    //   117: monitorexit
    //   118: return
    //   119: ldc -8
    //   121: iconst_0
    //   122: anewarray 40	java/lang/Object
    //   125: invokestatic 106	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   128: pop
    //   129: aload_0
    //   130: getfield 55	com/tencent/bugly/proguard/q:c	Landroid/content/Context;
    //   133: getstatic 27	com/tencent/bugly/proguard/q:a	Ljava/lang/String;
    //   136: invokevirtual 254	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   139: astore_1
    //   140: aload_1
    //   141: ifnull +15 -> 156
    //   144: aload_1
    //   145: invokevirtual 259	java/io/File:canWrite	()Z
    //   148: ifeq +8 -> 156
    //   151: aload_1
    //   152: invokevirtual 262	java/io/File:delete	()Z
    //   155: pop
    //   156: aload_0
    //   157: monitorexit
    //   158: return
    //   159: astore_1
    //   160: aload_0
    //   161: monitorexit
    //   162: aload_1
    //   163: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	q
    //   0	164	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	164	2	paramInt1	int
    //   0	164	3	paramInt2	int
    //   50	13	4	localIterator	java.util.Iterator
    //   72	3	5	locala	a
    //   85	11	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   74	82	85	finally
    //   2	52	159	finally
    //   52	74	159	finally
    //   87	100	159	finally
    //   103	116	159	finally
    //   119	140	159	finally
    //   144	156	159	finally
  }
  
  /* Error */
  public final void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc_w 265
    //   5: iconst_2
    //   6: anewarray 40	java/lang/Object
    //   9: dup
    //   10: iconst_0
    //   11: iload_2
    //   12: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   15: aastore
    //   16: dup
    //   17: iconst_1
    //   18: iload_3
    //   19: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   22: aastore
    //   23: invokestatic 106	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   26: pop
    //   27: aload_0
    //   28: getfield 57	com/tencent/bugly/proguard/q:d	Ljava/util/List;
    //   31: ifnull +65 -> 96
    //   34: aload_0
    //   35: getfield 57	com/tencent/bugly/proguard/q:d	Ljava/util/List;
    //   38: invokeinterface 215 1 0
    //   43: astore 4
    //   45: aload 4
    //   47: invokeinterface 221 1 0
    //   52: ifeq +44 -> 96
    //   55: aload 4
    //   57: invokeinterface 225 1 0
    //   62: checkcast 227	com/tencent/bugly/a
    //   65: astore 5
    //   67: aload 5
    //   69: aload_1
    //   70: iload_2
    //   71: iload_3
    //   72: invokevirtual 268	com/tencent/bugly/a:onDbUpgrade	(Landroid/database/sqlite/SQLiteDatabase;II)V
    //   75: goto -30 -> 45
    //   78: astore 5
    //   80: aload 5
    //   82: invokestatic 84	com/tencent/bugly/proguard/x:b	(Ljava/lang/Throwable;)Z
    //   85: ifne -40 -> 45
    //   88: aload 5
    //   90: invokevirtual 89	java/lang/Throwable:printStackTrace	()V
    //   93: goto -48 -> 45
    //   96: aload_0
    //   97: aload_1
    //   98: invokespecial 244	com/tencent/bugly/proguard/q:a	(Landroid/database/sqlite/SQLiteDatabase;)Z
    //   101: ifeq +11 -> 112
    //   104: aload_0
    //   105: aload_1
    //   106: invokevirtual 246	com/tencent/bugly/proguard/q:onCreate	(Landroid/database/sqlite/SQLiteDatabase;)V
    //   109: aload_0
    //   110: monitorexit
    //   111: return
    //   112: ldc -8
    //   114: iconst_0
    //   115: anewarray 40	java/lang/Object
    //   118: invokestatic 106	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   121: pop
    //   122: aload_0
    //   123: getfield 55	com/tencent/bugly/proguard/q:c	Landroid/content/Context;
    //   126: getstatic 27	com/tencent/bugly/proguard/q:a	Ljava/lang/String;
    //   129: invokevirtual 254	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   132: astore_1
    //   133: aload_1
    //   134: ifnull +15 -> 149
    //   137: aload_1
    //   138: invokevirtual 259	java/io/File:canWrite	()Z
    //   141: ifeq +8 -> 149
    //   144: aload_1
    //   145: invokevirtual 262	java/io/File:delete	()Z
    //   148: pop
    //   149: aload_0
    //   150: monitorexit
    //   151: return
    //   152: astore_1
    //   153: aload_0
    //   154: monitorexit
    //   155: aload_1
    //   156: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	157	0	this	q
    //   0	157	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	157	2	paramInt1	int
    //   0	157	3	paramInt2	int
    //   43	13	4	localIterator	java.util.Iterator
    //   65	3	5	locala	a
    //   78	11	5	localThrowable	Throwable
    // Exception table:
    //   from	to	target	type
    //   67	75	78	finally
    //   2	45	152	finally
    //   45	67	152	finally
    //   80	93	152	finally
    //   96	109	152	finally
    //   112	133	152	finally
    //   137	149	152	finally
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */