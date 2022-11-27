package com.google.android.gms.measurement.internal;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import java.io.File;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class zzag
{
  private static Set<String> zza(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder(String.valueOf(paramString).length() + 22);
    localStringBuilder.append("SELECT * FROM ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" LIMIT 0");
    paramSQLiteDatabase = paramSQLiteDatabase.rawQuery(localStringBuilder.toString(), null);
    try
    {
      Collections.addAll(localHashSet, paramSQLiteDatabase.getColumnNames());
      return localHashSet;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  static void zza(zzer paramzzer, SQLiteDatabase paramSQLiteDatabase)
  {
    if (paramzzer != null)
    {
      paramSQLiteDatabase = new File(paramSQLiteDatabase.getPath());
      if (!paramSQLiteDatabase.setReadable(false, false)) {
        paramzzer.zzh().zza("Failed to turn off database read permission");
      }
      if (!paramSQLiteDatabase.setWritable(false, false)) {
        paramzzer.zzh().zza("Failed to turn off database write permission");
      }
      if (!paramSQLiteDatabase.setReadable(true, true)) {
        paramzzer.zzh().zza("Failed to turn on database read permission for owner");
      }
      if (!paramSQLiteDatabase.setWritable(true, true)) {
        paramzzer.zzh().zza("Failed to turn on database write permission for owner");
      }
      return;
    }
    throw new IllegalArgumentException("Monitor must not be null");
  }
  
  static void zza(zzer paramzzer, SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2, String paramString3, String[] paramArrayOfString)
    throws SQLiteException
  {
    if (paramzzer != null)
    {
      if (!zza(paramzzer, paramSQLiteDatabase, paramString1)) {
        paramSQLiteDatabase.execSQL(paramString2);
      }
      if (paramzzer == null) {}
    }
    for (;;)
    {
      try
      {
        paramString2 = zza(paramSQLiteDatabase, paramString1);
        String[] arrayOfString = paramString3.split(",");
        int k = arrayOfString.length;
        j = 0;
        i = 0;
        if (i >= k) {
          continue;
        }
        paramString3 = arrayOfString[i];
        if (paramString2.remove(paramString3))
        {
          i += 1;
          continue;
        }
        paramSQLiteDatabase = new StringBuilder(String.valueOf(paramString1).length() + 35 + String.valueOf(paramString3).length());
        paramSQLiteDatabase.append("Table ");
        paramSQLiteDatabase.append(paramString1);
        paramSQLiteDatabase.append(" is missing required column: ");
        paramSQLiteDatabase.append(paramString3);
        throw new SQLiteException(paramSQLiteDatabase.toString());
      }
      catch (SQLiteException paramSQLiteDatabase)
      {
        int j;
        int i;
        continue;
      }
      if (i < paramArrayOfString.length)
      {
        if (!paramString2.remove(paramArrayOfString[i])) {
          paramSQLiteDatabase.execSQL(paramArrayOfString[(i + 1)]);
        }
      }
      else
      {
        if (paramString2.isEmpty()) {
          continue;
        }
        paramzzer.zzh().zza("Table has extra columns. table, columns", paramString1, TextUtils.join(", ", paramString2));
        return;
        throw new IllegalArgumentException("Monitor must not be null");
        paramzzer.zze().zza("Failed to verify columns on table that was just created", paramString1);
        throw paramSQLiteDatabase;
        throw new IllegalArgumentException("Monitor must not be null");
        if (paramArrayOfString == null) {
          continue;
        }
        i = j;
        continue;
      }
      i += 2;
    }
  }
  
  /* Error */
  private static boolean zza(zzer paramzzer, SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +111 -> 112
    //   4: aconst_null
    //   5: astore 5
    //   7: aconst_null
    //   8: astore 4
    //   10: aload_1
    //   11: ldc -98
    //   13: iconst_1
    //   14: anewarray 16	java/lang/String
    //   17: dup
    //   18: iconst_0
    //   19: ldc -96
    //   21: aastore
    //   22: ldc -94
    //   24: iconst_1
    //   25: anewarray 16	java/lang/String
    //   28: dup
    //   29: iconst_0
    //   30: aload_2
    //   31: aastore
    //   32: aconst_null
    //   33: aconst_null
    //   34: aconst_null
    //   35: invokevirtual 166	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   38: astore_1
    //   39: aload_1
    //   40: astore 4
    //   42: aload_1
    //   43: astore 5
    //   45: aload_1
    //   46: invokeinterface 169 1 0
    //   51: istore_3
    //   52: aload_1
    //   53: ifnull +9 -> 62
    //   56: aload_1
    //   57: invokeinterface 60 1 0
    //   62: iload_3
    //   63: ireturn
    //   64: astore_0
    //   65: goto +33 -> 98
    //   68: astore_1
    //   69: aload 5
    //   71: astore 4
    //   73: aload_0
    //   74: invokevirtual 82	com/google/android/gms/measurement/internal/zzer:zzh	()Lcom/google/android/gms/measurement/internal/zzet;
    //   77: ldc -85
    //   79: aload_2
    //   80: aload_1
    //   81: invokevirtual 147	com/google/android/gms/measurement/internal/zzet:zza	(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   84: aload 5
    //   86: ifnull +10 -> 96
    //   89: aload 5
    //   91: invokeinterface 60 1 0
    //   96: iconst_0
    //   97: ireturn
    //   98: aload 4
    //   100: ifnull +10 -> 110
    //   103: aload 4
    //   105: invokeinterface 60 1 0
    //   110: aload_0
    //   111: athrow
    //   112: new 99	java/lang/IllegalArgumentException
    //   115: dup
    //   116: ldc 101
    //   118: invokespecial 102	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   121: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	122	0	paramzzer	zzer
    //   0	122	1	paramSQLiteDatabase	SQLiteDatabase
    //   0	122	2	paramString	String
    //   51	12	3	bool	boolean
    //   8	96	4	localSQLiteDatabase1	SQLiteDatabase
    //   5	85	5	localSQLiteDatabase2	SQLiteDatabase
    // Exception table:
    //   from	to	target	type
    //   10	39	64	finally
    //   45	52	64	finally
    //   73	84	64	finally
    //   10	39	68	android/database/sqlite/SQLiteException
    //   45	52	68	android/database/sqlite/SQLiteException
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\measurement\internal\zzag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */