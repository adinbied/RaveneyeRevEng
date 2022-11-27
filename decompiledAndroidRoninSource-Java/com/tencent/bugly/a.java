package com.tencent.bugly;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.tencent.bugly.crashreport.common.strategy.StrategyBean;
import com.tencent.bugly.proguard.x;

public abstract class a
{
  public int id;
  public String moduleName;
  public String version;
  public String versionKey;
  
  public abstract String[] getTables();
  
  public abstract void init(Context paramContext, boolean paramBoolean, BuglyStrategy paramBuglyStrategy);
  
  public void onDbCreate(SQLiteDatabase paramSQLiteDatabase) {}
  
  public void onDbDowngrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      if (getTables() == null) {
        return;
      }
      String[] arrayOfString = getTables();
      paramInt2 = arrayOfString.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        String str = arrayOfString[paramInt1];
        StringBuilder localStringBuilder = new StringBuilder("DROP TABLE IF EXISTS ");
        localStringBuilder.append(str);
        paramSQLiteDatabase.execSQL(localStringBuilder.toString());
        paramInt1 += 1;
      }
      onDbCreate(paramSQLiteDatabase);
      return;
    }
    finally
    {
      if (!x.b(paramSQLiteDatabase)) {
        paramSQLiteDatabase.printStackTrace();
      }
    }
  }
  
  public void onDbUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    try
    {
      if (getTables() == null) {
        return;
      }
      String[] arrayOfString = getTables();
      paramInt2 = arrayOfString.length;
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        String str = arrayOfString[paramInt1];
        StringBuilder localStringBuilder = new StringBuilder("DROP TABLE IF EXISTS ");
        localStringBuilder.append(str);
        paramSQLiteDatabase.execSQL(localStringBuilder.toString());
        paramInt1 += 1;
      }
      onDbCreate(paramSQLiteDatabase);
      return;
    }
    finally
    {
      if (!x.b(paramSQLiteDatabase)) {
        paramSQLiteDatabase.printStackTrace();
      }
    }
  }
  
  public void onServerStrategyChanged(StrategyBean paramStrategyBean) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\tencent\bugly\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */