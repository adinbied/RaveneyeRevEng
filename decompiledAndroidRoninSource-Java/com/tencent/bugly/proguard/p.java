package com.tencent.bugly.proguard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.a;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class p
{
  private static p a;
  private static q b;
  private static boolean c;
  
  private p(Context paramContext, List<a> paramList)
  {
    b = new q(paramContext, paramList);
  }
  
  /* Error */
  private int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 7
    //   5: iconst_0
    //   6: istore 6
    //   8: iconst_0
    //   9: istore 5
    //   11: getstatic 25	com/tencent/bugly/proguard/p:b	Lcom/tencent/bugly/proguard/q;
    //   14: invokevirtual 35	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 8
    //   19: aload 8
    //   21: ifnull +13 -> 34
    //   24: aload 8
    //   26: aload_1
    //   27: aload_2
    //   28: aload_3
    //   29: invokevirtual 41	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   32: istore 5
    //   34: iload 5
    //   36: istore 6
    //   38: aload 4
    //   40: ifnull +38 -> 78
    //   43: iload 5
    //   45: istore 6
    //   47: goto +31 -> 78
    //   50: astore_1
    //   51: goto +40 -> 91
    //   54: astore_1
    //   55: aload_1
    //   56: invokestatic 46	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   59: ifne +7 -> 66
    //   62: aload_1
    //   63: invokevirtual 51	java/lang/Throwable:printStackTrace	()V
    //   66: aload 4
    //   68: ifnull +10 -> 78
    //   71: iload 7
    //   73: istore 5
    //   75: goto -32 -> 43
    //   78: aload_0
    //   79: monitorexit
    //   80: iload 6
    //   82: ireturn
    //   83: astore_1
    //   84: aload 4
    //   86: ifnull +3 -> 89
    //   89: aload_1
    //   90: athrow
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	p
    //   0	95	1	paramString1	String
    //   0	95	2	paramString2	String
    //   0	95	3	paramArrayOfString	String[]
    //   0	95	4	paramo	o
    //   9	65	5	i	int
    //   6	75	6	j	int
    //   3	69	7	k	int
    //   17	8	8	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   89	91	50	finally
    //   11	19	54	finally
    //   24	34	54	finally
    //   55	66	83	finally
  }
  
  /* Error */
  private long a(String paramString, ContentValues paramContentValues, o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: lconst_0
    //   3: lstore 6
    //   5: getstatic 25	com/tencent/bugly/proguard/p:b	Lcom/tencent/bugly/proguard/q;
    //   8: invokevirtual 35	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   11: astore 10
    //   13: lload 6
    //   15: lstore 4
    //   17: aload 10
    //   19: ifnull +60 -> 79
    //   22: lload 6
    //   24: lstore 4
    //   26: aload_2
    //   27: ifnull +52 -> 79
    //   30: aload 10
    //   32: aload_1
    //   33: ldc 57
    //   35: aload_2
    //   36: invokevirtual 61	android/database/sqlite/SQLiteDatabase:replace	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   39: lstore 4
    //   41: lload 4
    //   43: lconst_0
    //   44: lcmp
    //   45: iflt +20 -> 65
    //   48: ldc 63
    //   50: iconst_1
    //   51: anewarray 4	java/lang/Object
    //   54: dup
    //   55: iconst_0
    //   56: aload_1
    //   57: aastore
    //   58: invokestatic 66	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   61: pop
    //   62: goto +17 -> 79
    //   65: ldc 68
    //   67: iconst_1
    //   68: anewarray 4	java/lang/Object
    //   71: dup
    //   72: iconst_0
    //   73: aload_1
    //   74: aastore
    //   75: invokestatic 71	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   78: pop
    //   79: lload 4
    //   81: lstore 8
    //   83: aload_3
    //   84: ifnull +41 -> 125
    //   87: lload 4
    //   89: lstore 8
    //   91: goto +34 -> 125
    //   94: astore_1
    //   95: goto +42 -> 137
    //   98: astore_1
    //   99: aload_1
    //   100: invokestatic 46	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   103: ifne +7 -> 110
    //   106: aload_1
    //   107: invokevirtual 51	java/lang/Throwable:printStackTrace	()V
    //   110: lload 6
    //   112: lstore 8
    //   114: aload_3
    //   115: ifnull +10 -> 125
    //   118: lload 6
    //   120: lstore 4
    //   122: goto -35 -> 87
    //   125: aload_0
    //   126: monitorexit
    //   127: lload 8
    //   129: lreturn
    //   130: astore_1
    //   131: aload_3
    //   132: ifnull +3 -> 135
    //   135: aload_1
    //   136: athrow
    //   137: aload_0
    //   138: monitorexit
    //   139: aload_1
    //   140: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	141	0	this	p
    //   0	141	1	paramString	String
    //   0	141	2	paramContentValues	ContentValues
    //   0	141	3	paramo	o
    //   15	106	4	l1	long
    //   3	116	6	l2	long
    //   81	47	8	l3	long
    //   11	20	10	localSQLiteDatabase	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   135	137	94	finally
    //   5	13	98	finally
    //   30	41	98	finally
    //   48	62	98	finally
    //   65	79	98	finally
    //   99	110	130	finally
  }
  
  private Cursor a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6, o paramo)
  {
    Object localObject = null;
    try
    {
      SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
      paramo = (o)localObject;
      if (localSQLiteDatabase != null) {
        paramo = localSQLiteDatabase.query(paramBoolean, paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, paramString3, paramString4, paramString5, paramString6);
      }
    }
    finally
    {
      paramo = (o)localObject;
    }
    try
    {
      if (!x.a(paramString1))
      {
        paramString1.printStackTrace();
        paramo = (o)localObject;
      }
      return paramo;
    }
    finally
    {
      paramString1 = finally;
      try
      {
        throw paramString1;
      }
      finally {}
    }
  }
  
  public static p a()
  {
    try
    {
      p localp = a;
      return localp;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
  
  public static p a(Context paramContext, List<a> paramList)
  {
    try
    {
      if (a == null) {
        a = new p(paramContext, paramList);
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  private static r a(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      r localr = new r();
      localr.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      localr.b = paramCursor.getInt(paramCursor.getColumnIndex("_tp"));
      localr.c = paramCursor.getString(paramCursor.getColumnIndex("_pc"));
      localr.d = paramCursor.getString(paramCursor.getColumnIndex("_th"));
      localr.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      localr.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      return localr;
    }
    finally
    {
      if (!x.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  private Map<String, byte[]> a(int paramInt, o paramo)
  {
    Object localObject1 = null;
    paramo = null;
    try
    {
      Object localObject2 = c(paramInt);
      if (localObject2 != null)
      {
        localObject1 = new HashMap();
        try
        {
          paramo = ((List)localObject2).iterator();
          while (paramo.hasNext())
          {
            localObject2 = (r)paramo.next();
            byte[] arrayOfByte = ((r)localObject2).g;
            if (arrayOfByte != null) {
              ((Map)localObject1).put(((r)localObject2).f, arrayOfByte);
            }
          }
          return (Map<String, byte[]>)localObject1;
        }
        finally
        {
          paramo = (o)localObject1;
        }
        localObject1 = paramo;
      }
    }
    finally {}
    try
    {
      if (!x.a(localThrowable))
      {
        localThrowable.printStackTrace();
        localObject1 = paramo;
      }
      return (Map<String, byte[]>)localObject1;
    }
    finally {}
  }
  
  /* Error */
  private boolean a(int paramInt, String paramString, o paramo)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iconst_0
    //   3: istore 6
    //   5: iconst_0
    //   6: istore 7
    //   8: iconst_0
    //   9: istore 5
    //   11: getstatic 25	com/tencent/bugly/proguard/p:b	Lcom/tencent/bugly/proguard/q;
    //   14: invokevirtual 35	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   17: astore 8
    //   19: iload 5
    //   21: istore 4
    //   23: aload 8
    //   25: ifnull +132 -> 157
    //   28: aload_2
    //   29: invokestatic 181	com/tencent/bugly/proguard/z:a	(Ljava/lang/String;)Z
    //   32: ifeq +27 -> 59
    //   35: new 183	java/lang/StringBuilder
    //   38: dup
    //   39: ldc -71
    //   41: invokespecial 188	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   44: astore_2
    //   45: aload_2
    //   46: iload_1
    //   47: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   55: astore_2
    //   56: goto +58 -> 114
    //   59: new 183	java/lang/StringBuilder
    //   62: dup
    //   63: ldc -71
    //   65: invokespecial 188	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   68: astore 9
    //   70: aload 9
    //   72: iload_1
    //   73: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload 9
    //   79: ldc -58
    //   81: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 9
    //   87: ldc -53
    //   89: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   92: pop
    //   93: aload 9
    //   95: aload_2
    //   96: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: aload 9
    //   102: ldc -51
    //   104: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 9
    //   110: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   113: astore_2
    //   114: aload 8
    //   116: ldc -49
    //   118: aload_2
    //   119: aconst_null
    //   120: invokevirtual 41	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   123: istore_1
    //   124: ldc -47
    //   126: iconst_2
    //   127: anewarray 4	java/lang/Object
    //   130: dup
    //   131: iconst_0
    //   132: ldc -49
    //   134: aastore
    //   135: dup
    //   136: iconst_1
    //   137: iload_1
    //   138: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   141: aastore
    //   142: invokestatic 66	com/tencent/bugly/proguard/x:c	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   145: pop
    //   146: iload 5
    //   148: istore 4
    //   150: iload_1
    //   151: ifle +6 -> 157
    //   154: iconst_1
    //   155: istore 4
    //   157: iload 4
    //   159: istore 5
    //   161: aload_3
    //   162: ifnull +41 -> 203
    //   165: iload 4
    //   167: istore 5
    //   169: goto +34 -> 203
    //   172: astore_2
    //   173: goto +42 -> 215
    //   176: astore_2
    //   177: aload_2
    //   178: invokestatic 46	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   181: ifne +7 -> 188
    //   184: aload_2
    //   185: invokevirtual 51	java/lang/Throwable:printStackTrace	()V
    //   188: iload 7
    //   190: istore 5
    //   192: aload_3
    //   193: ifnull +10 -> 203
    //   196: iload 6
    //   198: istore 4
    //   200: goto -35 -> 165
    //   203: aload_0
    //   204: monitorexit
    //   205: iload 5
    //   207: ireturn
    //   208: astore_2
    //   209: aload_3
    //   210: ifnull +3 -> 213
    //   213: aload_2
    //   214: athrow
    //   215: aload_0
    //   216: monitorexit
    //   217: aload_2
    //   218: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	219	0	this	p
    //   0	219	1	paramInt	int
    //   0	219	2	paramString	String
    //   0	219	3	paramo	o
    //   21	178	4	bool1	boolean
    //   9	197	5	bool2	boolean
    //   3	194	6	bool3	boolean
    //   6	183	7	bool4	boolean
    //   17	98	8	localSQLiteDatabase	SQLiteDatabase
    //   68	41	9	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   213	215	172	finally
    //   11	19	176	finally
    //   28	56	176	finally
    //   59	114	176	finally
    //   114	146	176	finally
    //   177	188	208	finally
  }
  
  private boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, o paramo)
  {
    bool2 = false;
    bool3 = false;
    try
    {
      r localr = new r();
      localr.a = paramInt;
      localr.f = paramString;
      localr.e = System.currentTimeMillis();
      localr.g = paramArrayOfByte;
      bool1 = b(localr);
      bool2 = bool1;
      if (paramo == null) {
        break label86;
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          if (!x.a(paramString)) {
            paramString.printStackTrace();
          }
          if (paramo == null) {
            break;
          }
          boolean bool1 = bool3;
        }
        return bool2;
      }
      finally
      {
        if (paramo == null) {
          break label95;
        }
      }
    }
    return bool1;
  }
  
  private static r b(Cursor paramCursor)
  {
    if (paramCursor == null) {
      return null;
    }
    try
    {
      r localr = new r();
      localr.a = paramCursor.getLong(paramCursor.getColumnIndex("_id"));
      localr.e = paramCursor.getLong(paramCursor.getColumnIndex("_tm"));
      localr.f = paramCursor.getString(paramCursor.getColumnIndex("_tp"));
      localr.g = paramCursor.getBlob(paramCursor.getColumnIndex("_dt"));
      return localr;
    }
    finally
    {
      if (!x.a(paramCursor)) {
        paramCursor.printStackTrace();
      }
    }
    return null;
  }
  
  private boolean b(r paramr)
  {
    if (paramr == null) {
      return false;
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
      if (localSQLiteDatabase != null)
      {
        ContentValues localContentValues = d(paramr);
        if (localContentValues != null)
        {
          long l = localSQLiteDatabase.replace("t_pf", "_id", localContentValues);
          if (l >= 0L)
          {
            x.c("[Database] insert %s success.", new Object[] { "t_pf" });
            paramr.a = l;
            return true;
          }
          return false;
        }
      }
      return false;
    }
    finally
    {
      try
      {
        if (!x.a(paramr)) {
          paramr.printStackTrace();
        }
        return false;
      }
      finally
      {
        paramr = finally;
        try
        {
          throw paramr;
        }
        finally {}
      }
    }
  }
  
  private static ContentValues c(r paramr)
  {
    if (paramr == null) {
      return null;
    }
    try
    {
      ContentValues localContentValues = new ContentValues();
      if (paramr.a > 0L) {
        localContentValues.put("_id", Long.valueOf(paramr.a));
      }
      localContentValues.put("_tp", Integer.valueOf(paramr.b));
      localContentValues.put("_pc", paramr.c);
      localContentValues.put("_th", paramr.d);
      localContentValues.put("_tm", Long.valueOf(paramr.e));
      if (paramr.g != null) {
        localContentValues.put("_dt", paramr.g);
      }
      return localContentValues;
    }
    finally
    {
      if (!x.a(paramr)) {
        paramr.printStackTrace();
      }
    }
    return null;
  }
  
  private List<r> c(int paramInt)
  {
    Object localObject1;
    for (;;)
    {
      try
      {
        localSQLiteDatabase = b.getWritableDatabase();
        if (localSQLiteDatabase != null)
        {
          localObject1 = new StringBuilder("_id = ");
          ((StringBuilder)localObject1).append(paramInt);
          str = ((StringBuilder)localObject1).toString();
          localObject1 = localSQLiteDatabase.query("t_pf", null, str, null, null, null, null);
          if (localObject1 == null) {
            if (localObject1 == null) {}
          }
        }
      }
      finally
      {
        SQLiteDatabase localSQLiteDatabase;
        String str;
        StringBuilder localStringBuilder;
        ArrayList localArrayList;
        Object localObject5;
        localObject1 = null;
      }
      try
      {
        ((Cursor)localObject1).close();
        return null;
      }
      finally {}
      try
      {
        localStringBuilder = new StringBuilder();
        localArrayList = new ArrayList();
        if (((Cursor)localObject1).moveToNext())
        {
          localObject5 = b((Cursor)localObject1);
          if (localObject5 != null) {
            localArrayList.add(localObject5);
          }
        }
      }
      finally {}
      try
      {
        localObject5 = ((Cursor)localObject1).getString(((Cursor)localObject1).getColumnIndex("_tp"));
        localStringBuilder.append(" or _tp");
        localStringBuilder.append(" = ");
        localStringBuilder.append((String)localObject5);
        continue;
      }
      finally {}
      x.d("[Database] unknown id.", new Object[0]);
    }
    if (localStringBuilder.length() > 0)
    {
      localStringBuilder.append(" and _id");
      localStringBuilder.append(" = ");
      localStringBuilder.append(paramInt);
      x.d("[Database] deleted %s illegal data %d.", new Object[] { "t_pf", Integer.valueOf(localSQLiteDatabase.delete("t_pf", str.substring(4), null)) });
    }
    if (localObject1 != null) {
      ((Cursor)localObject1).close();
    }
    return localArrayList;
    try
    {
      if (!x.a(localThrowable)) {
        localThrowable.printStackTrace();
      }
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      return null;
    }
    finally
    {
      localObject4 = finally;
      if (localObject1 != null) {
        ((Cursor)localObject1).close();
      }
      throw ((Throwable)localObject4);
    }
  }
  
  private static ContentValues d(r paramr)
  {
    if (paramr != null)
    {
      if (z.a(paramr.f)) {
        return null;
      }
      try
      {
        ContentValues localContentValues = new ContentValues();
        if (paramr.a > 0L) {
          localContentValues.put("_id", Long.valueOf(paramr.a));
        }
        localContentValues.put("_tp", paramr.f);
        localContentValues.put("_tm", Long.valueOf(paramr.e));
        if (paramr.g != null) {
          localContentValues.put("_dt", paramr.g);
        }
        return localContentValues;
      }
      finally
      {
        if (!x.a(paramr)) {
          paramr.printStackTrace();
        }
      }
    }
    return null;
  }
  
  public final int a(String paramString1, String paramString2, String[] paramArrayOfString, o paramo, boolean paramBoolean)
  {
    return a(paramString1, paramString2, null, null);
  }
  
  public final long a(String paramString, ContentValues paramContentValues, o paramo, boolean paramBoolean)
  {
    return a(paramString, paramContentValues, null);
  }
  
  public final Cursor a(String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, o paramo, boolean paramBoolean)
  {
    return a(false, paramString1, paramArrayOfString1, paramString2, null, null, null, null, null, null);
  }
  
  /* Error */
  public final List<r> a(int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 25	com/tencent/bugly/proguard/p:b	Lcom/tencent/bugly/proguard/q;
    //   5: invokevirtual 35	com/tencent/bugly/proguard/q:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   8: astore 5
    //   10: aload 5
    //   12: ifnull +303 -> 315
    //   15: iload_1
    //   16: iflt +323 -> 339
    //   19: new 183	java/lang/StringBuilder
    //   22: dup
    //   23: ldc_w 298
    //   26: invokespecial 188	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   29: astore 4
    //   31: aload 4
    //   33: iload_1
    //   34: invokevirtual 192	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   43: astore 4
    //   45: goto +3 -> 48
    //   48: aload 5
    //   50: ldc_w 300
    //   53: aconst_null
    //   54: aload 4
    //   56: aconst_null
    //   57: aconst_null
    //   58: aconst_null
    //   59: aconst_null
    //   60: invokevirtual 257	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   63: astore 4
    //   65: aload 4
    //   67: ifnonnull +19 -> 86
    //   70: aload 4
    //   72: ifnull +10 -> 82
    //   75: aload 4
    //   77: invokeinterface 260 1 0
    //   82: aload_0
    //   83: monitorexit
    //   84: aconst_null
    //   85: areturn
    //   86: new 183	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 261	java/lang/StringBuilder:<init>	()V
    //   93: astore 7
    //   95: new 263	java/util/ArrayList
    //   98: dup
    //   99: invokespecial 264	java/util/ArrayList:<init>	()V
    //   102: astore 6
    //   104: aload 4
    //   106: invokeinterface 267 1 0
    //   111: ifeq +87 -> 198
    //   114: aload 4
    //   116: invokestatic 302	com/tencent/bugly/proguard/p:a	(Landroid/database/Cursor;)Lcom/tencent/bugly/proguard/r;
    //   119: astore 8
    //   121: aload 8
    //   123: ifnull +16 -> 139
    //   126: aload 6
    //   128: aload 8
    //   130: invokeinterface 273 2 0
    //   135: pop
    //   136: goto -32 -> 104
    //   139: aload 4
    //   141: aload 4
    //   143: ldc 57
    //   145: invokeinterface 95 2 0
    //   150: invokeinterface 99 2 0
    //   155: lstore_2
    //   156: aload 7
    //   158: ldc_w 304
    //   161: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 7
    //   167: ldc_w 277
    //   170: invokevirtual 201	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 7
    //   176: lload_2
    //   177: invokevirtual 307	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   180: pop
    //   181: goto -77 -> 104
    //   184: ldc_w 279
    //   187: iconst_0
    //   188: anewarray 4	java/lang/Object
    //   191: invokestatic 71	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   194: pop
    //   195: goto -91 -> 104
    //   198: aload 7
    //   200: invokevirtual 196	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: astore 7
    //   205: aload 7
    //   207: invokevirtual 308	java/lang/String:length	()I
    //   210: ifle +41 -> 251
    //   213: ldc_w 310
    //   216: iconst_2
    //   217: anewarray 4	java/lang/Object
    //   220: dup
    //   221: iconst_0
    //   222: ldc_w 300
    //   225: aastore
    //   226: dup
    //   227: iconst_1
    //   228: aload 5
    //   230: ldc_w 300
    //   233: aload 7
    //   235: iconst_4
    //   236: invokevirtual 292	java/lang/String:substring	(I)Ljava/lang/String;
    //   239: aconst_null
    //   240: invokevirtual 41	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   243: invokestatic 215	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   246: aastore
    //   247: invokestatic 71	com/tencent/bugly/proguard/x:d	(Ljava/lang/String;[Ljava/lang/Object;)Z
    //   250: pop
    //   251: aload 4
    //   253: ifnull +10 -> 263
    //   256: aload 4
    //   258: invokeinterface 260 1 0
    //   263: aload_0
    //   264: monitorexit
    //   265: aload 6
    //   267: areturn
    //   268: astore 5
    //   270: aload 5
    //   272: invokestatic 46	com/tencent/bugly/proguard/x:a	(Ljava/lang/Throwable;)Z
    //   275: ifne +8 -> 283
    //   278: aload 5
    //   280: invokevirtual 51	java/lang/Throwable:printStackTrace	()V
    //   283: aload 4
    //   285: ifnull +30 -> 315
    //   288: aload 4
    //   290: invokeinterface 260 1 0
    //   295: goto +20 -> 315
    //   298: astore 5
    //   300: aload 4
    //   302: ifnull +10 -> 312
    //   305: aload 4
    //   307: invokeinterface 260 1 0
    //   312: aload 5
    //   314: athrow
    //   315: aload_0
    //   316: monitorexit
    //   317: aconst_null
    //   318: areturn
    //   319: astore 4
    //   321: aload_0
    //   322: monitorexit
    //   323: aload 4
    //   325: athrow
    //   326: astore 8
    //   328: goto -144 -> 184
    //   331: astore 5
    //   333: aconst_null
    //   334: astore 4
    //   336: goto -66 -> 270
    //   339: aconst_null
    //   340: astore 4
    //   342: goto -294 -> 48
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	345	0	this	p
    //   0	345	1	paramInt	int
    //   155	22	2	l	long
    //   29	277	4	localObject1	Object
    //   319	5	4	localObject2	Object
    //   334	7	4	localObject3	Object
    //   8	221	5	localSQLiteDatabase	SQLiteDatabase
    //   268	11	5	localThrowable	Throwable
    //   298	15	5	localObject4	Object
    //   331	1	5	localObject5	Object
    //   102	164	6	localArrayList	ArrayList
    //   93	141	7	localObject6	Object
    //   119	10	8	localr	r
    //   326	1	8	localObject7	Object
    // Exception table:
    //   from	to	target	type
    //   86	104	268	finally
    //   104	121	268	finally
    //   126	136	268	finally
    //   184	195	268	finally
    //   198	251	268	finally
    //   270	283	298	finally
    //   2	10	319	finally
    //   75	82	319	finally
    //   256	263	319	finally
    //   288	295	319	finally
    //   305	312	319	finally
    //   312	315	319	finally
    //   139	181	326	finally
    //   19	45	331	finally
    //   48	65	331	finally
  }
  
  public final Map<String, byte[]> a(int paramInt, o paramo, boolean paramBoolean)
  {
    return a(paramInt, null);
  }
  
  public final void a(List<r> paramList)
  {
    if (paramList != null) {
      try
      {
        if (paramList.size() != 0)
        {
          SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
          if (localSQLiteDatabase != null)
          {
            StringBuilder localStringBuilder = new StringBuilder();
            paramList = paramList.iterator();
            while (paramList.hasNext())
            {
              localObject = (r)paramList.next();
              localStringBuilder.append(" or _id");
              localStringBuilder.append(" = ");
              localStringBuilder.append(((r)localObject).a);
            }
            Object localObject = localStringBuilder.toString();
            paramList = (List<r>)localObject;
            if (((String)localObject).length() > 0) {
              paramList = ((String)localObject).substring(4);
            }
            localStringBuilder.setLength(0);
            try
            {
              x.c("[Database] deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(localSQLiteDatabase.delete("t_lr", paramList, null)) });
              return;
            }
            finally
            {
              paramList = finally;
              try
              {
                if (!x.a(paramList)) {
                  paramList.printStackTrace();
                }
                return;
              }
              finally
              {
                paramList = finally;
                throw paramList;
              }
            }
          }
          return;
        }
      }
      finally {}
    }
  }
  
  public final boolean a(int paramInt, String paramString, byte[] paramArrayOfByte, o paramo, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramo = new a(4, null);
      paramo.a(paramInt, paramString, paramArrayOfByte);
      w.a().a(paramo);
      return true;
    }
    return a(paramInt, paramString, paramArrayOfByte, null);
  }
  
  public final boolean a(r paramr)
  {
    if (paramr == null) {
      return false;
    }
    try
    {
      SQLiteDatabase localSQLiteDatabase = b.getWritableDatabase();
      if (localSQLiteDatabase != null)
      {
        ContentValues localContentValues = c(paramr);
        if (localContentValues != null)
        {
          long l = localSQLiteDatabase.replace("t_lr", "_id", localContentValues);
          if (l >= 0L)
          {
            x.c("[Database] insert %s success.", new Object[] { "t_lr" });
            paramr.a = l;
            return true;
          }
          return false;
        }
      }
      return false;
    }
    finally
    {
      try
      {
        if (!x.a(paramr)) {
          paramr.printStackTrace();
        }
        return false;
      }
      finally
      {
        paramr = finally;
        try
        {
          throw paramr;
        }
        finally {}
      }
    }
  }
  
  public final void b(int paramInt)
  {
    for (;;)
    {
      SQLiteDatabase localSQLiteDatabase;
      Object localObject1;
      try
      {
        localSQLiteDatabase = b.getWritableDatabase();
        if (localSQLiteDatabase != null) {
          if (paramInt < 0) {
            break label105;
          }
        }
      }
      finally {}
      try
      {
        localObject1 = new StringBuilder("_tp = ");
        ((StringBuilder)localObject1).append(paramInt);
        localObject1 = ((StringBuilder)localObject1).toString();
        x.c("[Database] deleted %s data %d", new Object[] { "t_lr", Integer.valueOf(localSQLiteDatabase.delete("t_lr", (String)localObject1, null)) });
        return;
      }
      finally
      {
        continue;
      }
      try
      {
        if (!x.a((Throwable)localObject1)) {
          ((Throwable)localObject1).printStackTrace();
        }
        return;
      }
      finally
      {
        localObject2 = finally;
        throw ((Throwable)localObject2);
      }
      return;
      label105:
      Object localObject5 = null;
    }
  }
  
  final class a
    extends Thread
  {
    private int a;
    private o b;
    private String c;
    private ContentValues d;
    private boolean e;
    private String[] f;
    private String g;
    private String[] h;
    private String i;
    private String j;
    private String k;
    private String l;
    private String m;
    private String[] n;
    private int o;
    private String p;
    private byte[] q;
    
    public a(int paramInt, o paramo)
    {
      this.a = paramInt;
      this.b = paramo;
    }
    
    public final void a(int paramInt, String paramString, byte[] paramArrayOfByte)
    {
      this.o = paramInt;
      this.p = paramString;
      this.q = paramArrayOfByte;
    }
    
    public final void a(boolean paramBoolean, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4, String paramString5, String paramString6)
    {
      this.e = paramBoolean;
      this.c = paramString1;
      this.f = paramArrayOfString1;
      this.g = paramString2;
      this.h = paramArrayOfString2;
      this.i = paramString3;
      this.j = paramString4;
      this.k = paramString5;
      this.l = paramString6;
    }
    
    public final void run()
    {
      switch (this.a)
      {
      default: 
        
      case 6: 
        p.a(p.this, this.o, this.p, this.b);
        return;
      case 5: 
        p.a(p.this, this.o, this.b);
        return;
      case 4: 
        p.a(p.this, this.o, this.p, this.q, this.b);
        return;
      case 3: 
        Cursor localCursor = p.a(p.this, this.e, this.c, this.f, this.g, this.h, this.i, this.j, this.k, this.l, this.b);
        if (localCursor != null)
        {
          localCursor.close();
          return;
        }
        break;
      case 2: 
        p.a(p.this, this.c, this.m, this.n, this.b);
        return;
      case 1: 
        p.a(p.this, this.c, this.d, this.b);
      }
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\proguard\p.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */