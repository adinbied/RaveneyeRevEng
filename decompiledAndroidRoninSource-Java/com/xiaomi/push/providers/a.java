package com.xiaomi.push.providers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class a
  extends SQLiteOpenHelper
{
  private static int jdField_a_of_type_Int = 1;
  public static final Object a;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "package_name", "TEXT", "message_ts", " LONG DEFAULT 0 ", "bytes", " LONG DEFAULT 0 ", "network_type", " INT DEFAULT -1 ", "rcv", " INT DEFAULT -1 ", "imsi", "TEXT" };
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
  }
  
  public a(Context paramContext)
  {
    super(paramContext, "traffic.db", null, jdField_a_of_type_Int);
  }
  
  /* Error */
  private void a(SQLiteDatabase arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onCreate(SQLiteDatabase arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\providers\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */