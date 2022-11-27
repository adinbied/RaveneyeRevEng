package com.xiaomi.push.providers;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import com.xiaomi.push.gz;

public class TrafficProvider
  extends ContentProvider
{
  private static final UriMatcher jdField_a_of_type_AndroidContentUriMatcher;
  public static final Uri a;
  private SQLiteOpenHelper jdField_a_of_type_AndroidDatabaseSqliteSQLiteOpenHelper;
  
  static
  {
    jdField_a_of_type_AndroidNetUri = Uri.parse("content://com.xiaomi.push.providers.TrafficProvider/traffic");
    UriMatcher localUriMatcher = new UriMatcher(-1);
    jdField_a_of_type_AndroidContentUriMatcher = localUriMatcher;
    localUriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "traffic", 1);
    jdField_a_of_type_AndroidContentUriMatcher.addURI("com.xiaomi.push.providers.TrafficProvider", "update_imsi", 2);
  }
  
  public int bulkInsert(Uri paramUri, ContentValues[] paramArrayOfContentValues)
  {
    return 0;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    return false;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    return null;
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    if ((jdField_a_of_type_AndroidContentUriMatcher.match(paramUri) == 2) && (paramContentValues != null) && (paramContentValues.containsKey("imsi"))) {
      gz.a(paramContentValues.getAsString("imsi"));
    }
    return 0;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\providers\TrafficProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */