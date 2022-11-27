package dji.thirdparty.ciphersql;

import android.content.ContentValues;
import android.content.OperationApplicationException;
import android.database.CursorWindow;
import android.os.Parcel;
import android.text.TextUtils;
import android.util.Log;
import dji.thirdparty.ciphersql.database.SQLiteAbortException;
import dji.thirdparty.ciphersql.database.SQLiteConstraintException;
import dji.thirdparty.ciphersql.database.SQLiteDatabase;
import dji.thirdparty.ciphersql.database.SQLiteDatabaseCorruptException;
import dji.thirdparty.ciphersql.database.SQLiteDiskIOException;
import dji.thirdparty.ciphersql.database.SQLiteException;
import dji.thirdparty.ciphersql.database.SQLiteFullException;
import dji.thirdparty.ciphersql.database.SQLiteProgram;
import dji.thirdparty.ciphersql.database.SQLiteStatement;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.CollationKey;
import java.text.Collator;
import java.util.HashMap;

public class DatabaseUtils
{
  private static final boolean DEBUG = false;
  private static final char[] HEX_DIGITS_LOWER = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 97, 98, 99, 100, 101, 102 };
  private static final boolean LOCAL_LOGV = false;
  private static final String TAG = "DatabaseUtils";
  private static final String[] countProjection = { "count(*)" };
  private static Collator mColl = null;
  
  public static void appendEscapedSQLString(StringBuilder paramStringBuilder, String paramString)
  {
    paramStringBuilder.append('\'');
    if (paramString.indexOf('\'') != -1)
    {
      int j = paramString.length();
      int i = 0;
      while (i < j)
      {
        char c = paramString.charAt(i);
        if (c == '\'') {
          paramStringBuilder.append('\'');
        }
        paramStringBuilder.append(c);
        i += 1;
      }
    }
    paramStringBuilder.append(paramString);
    paramStringBuilder.append('\'');
  }
  
  public static final void appendValueToSql(StringBuilder paramStringBuilder, Object paramObject)
  {
    if (paramObject == null)
    {
      paramStringBuilder.append("NULL");
      return;
    }
    if ((paramObject instanceof Boolean))
    {
      if (((Boolean)paramObject).booleanValue())
      {
        paramStringBuilder.append('1');
        return;
      }
      paramStringBuilder.append('0');
      return;
    }
    appendEscapedSQLString(paramStringBuilder, paramObject.toString());
  }
  
  public static void bindObjectToProgram(SQLiteProgram paramSQLiteProgram, int paramInt, Object paramObject)
  {
    if (paramObject == null)
    {
      paramSQLiteProgram.bindNull(paramInt);
      return;
    }
    if ((!(paramObject instanceof Double)) && (!(paramObject instanceof Float)))
    {
      if ((paramObject instanceof Number))
      {
        paramSQLiteProgram.bindLong(paramInt, ((Number)paramObject).longValue());
        return;
      }
      if ((paramObject instanceof Boolean))
      {
        if (((Boolean)paramObject).booleanValue())
        {
          paramSQLiteProgram.bindLong(paramInt, 1L);
          return;
        }
        paramSQLiteProgram.bindLong(paramInt, 0L);
        return;
      }
      if ((paramObject instanceof byte[]))
      {
        paramSQLiteProgram.bindBlob(paramInt, (byte[])paramObject);
        return;
      }
      paramSQLiteProgram.bindString(paramInt, paramObject.toString());
      return;
    }
    paramSQLiteProgram.bindDouble(paramInt, ((Number)paramObject).doubleValue());
  }
  
  public static String concatenateWhere(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return paramString2;
    }
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("(");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(") AND (");
    localStringBuilder.append(paramString2);
    localStringBuilder.append(")");
    return localStringBuilder.toString();
  }
  
  public static void cursorDoubleToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Double.valueOf(paramCursor.getDouble(i)));
      return;
    }
    paramContentValues.put(paramString2, (Double)null);
  }
  
  public static void cursorDoubleToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Double.valueOf(paramCursor.getDouble(i)));
    }
  }
  
  public static void cursorDoubleToCursorValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorDoubleToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorFillWindow(Cursor paramCursor, int paramInt, CursorWindow paramCursorWindow)
  {
    if (paramInt >= 0)
    {
      if (paramInt >= paramCursor.getCount()) {
        return;
      }
      int j = paramCursor.getPosition();
      int k = paramCursor.getColumnCount();
      paramCursorWindow.clear();
      paramCursorWindow.setStartPosition(paramInt);
      paramCursorWindow.setNumColumns(k);
      if (paramCursor.moveToPosition(paramInt)) {
        do
        {
          if (!paramCursorWindow.allocRow()) {
            break;
          }
          int i = 0;
          while (i < k)
          {
            int m = paramCursor.getType(i);
            boolean bool;
            if (m != 0)
            {
              if (m != 1)
              {
                if (m != 2)
                {
                  Object localObject;
                  if (m != 4)
                  {
                    localObject = paramCursor.getString(i);
                    if (localObject != null) {
                      bool = paramCursorWindow.putString((String)localObject, paramInt, i);
                    } else {
                      bool = paramCursorWindow.putNull(paramInt, i);
                    }
                  }
                  else
                  {
                    localObject = paramCursor.getBlob(i);
                    if (localObject != null) {
                      bool = paramCursorWindow.putBlob((byte[])localObject, paramInt, i);
                    } else {
                      bool = paramCursorWindow.putNull(paramInt, i);
                    }
                  }
                }
                else
                {
                  bool = paramCursorWindow.putDouble(paramCursor.getDouble(i), paramInt, i);
                }
              }
              else {
                bool = paramCursorWindow.putLong(paramCursor.getLong(i), paramInt, i);
              }
            }
            else {
              bool = paramCursorWindow.putNull(paramInt, i);
            }
            if (!bool)
            {
              paramCursorWindow.freeLastRow();
              break;
            }
            i += 1;
          }
          paramInt += 1;
        } while (paramCursor.moveToNext());
      }
      paramCursor.moveToPosition(j);
    }
  }
  
  public static void cursorFloatToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Float.valueOf(paramCursor.getFloat(i)));
    }
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorIntToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorIntToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Integer.valueOf(paramCursor.getInt(i)));
      return;
    }
    paramContentValues.put(paramString2, (Integer)null);
  }
  
  public static void cursorIntToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Integer.valueOf(paramCursor.getInt(i)));
    }
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorLongToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorLongToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    int i = paramCursor.getColumnIndex(paramString1);
    if (!paramCursor.isNull(i))
    {
      paramContentValues.put(paramString2, Long.valueOf(paramCursor.getLong(i)));
      return;
    }
    paramContentValues.put(paramString2, (Long)null);
  }
  
  public static void cursorLongToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Long.valueOf(paramCursor.getLong(i)));
    }
  }
  
  public static void cursorRowToContentValues(Cursor paramCursor, ContentValues paramContentValues)
  {
    AbstractWindowedCursor localAbstractWindowedCursor;
    if ((paramCursor instanceof AbstractWindowedCursor)) {
      localAbstractWindowedCursor = (AbstractWindowedCursor)paramCursor;
    } else {
      localAbstractWindowedCursor = null;
    }
    String[] arrayOfString = paramCursor.getColumnNames();
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if ((localAbstractWindowedCursor != null) && (localAbstractWindowedCursor.isBlob(i))) {
        paramContentValues.put(arrayOfString[i], paramCursor.getBlob(i));
      } else {
        paramContentValues.put(arrayOfString[i], paramCursor.getString(i));
      }
      i += 1;
    }
  }
  
  public static void cursorShortToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, Short.valueOf(paramCursor.getShort(i)));
    }
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString, ContentValues paramContentValues)
  {
    cursorStringToContentValues(paramCursor, paramString, paramContentValues, paramString);
  }
  
  public static void cursorStringToContentValues(Cursor paramCursor, String paramString1, ContentValues paramContentValues, String paramString2)
  {
    paramContentValues.put(paramString2, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString1)));
  }
  
  public static void cursorStringToContentValuesIfPresent(Cursor paramCursor, ContentValues paramContentValues, String paramString)
  {
    int i = paramCursor.getColumnIndexOrThrow(paramString);
    if (!paramCursor.isNull(i)) {
      paramContentValues.put(paramString, paramCursor.getString(i));
    }
  }
  
  public static void cursorStringToInsertHelper(Cursor paramCursor, String paramString, InsertHelper paramInsertHelper, int paramInt)
  {
    paramInsertHelper.bind(paramInt, paramCursor.getString(paramCursor.getColumnIndexOrThrow(paramString)));
  }
  
  public static void dumpCurrentRow(Cursor paramCursor)
  {
    dumpCurrentRow(paramCursor, System.out);
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, PrintStream paramPrintStream)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramCursor.getPosition());
    ((StringBuilder)localObject).append(" {");
    paramPrintStream.println(((StringBuilder)localObject).toString());
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      try
      {
        localObject = paramCursor.getString(i);
      }
      catch (SQLiteException localSQLiteException)
      {
        StringBuilder localStringBuilder;
        for (;;) {}
      }
      localObject = "<unprintable>";
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("   ");
      localStringBuilder.append(arrayOfString[i]);
      localStringBuilder.append('=');
      localStringBuilder.append((String)localObject);
      paramPrintStream.println(localStringBuilder.toString());
      i += 1;
    }
    paramPrintStream.println("}");
  }
  
  public static void dumpCurrentRow(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("");
    ((StringBuilder)localObject).append(paramCursor.getPosition());
    ((StringBuilder)localObject).append(" {\n");
    paramStringBuilder.append(((StringBuilder)localObject).toString());
    int j = arrayOfString.length;
    int i = 0;
    while (i < j)
    {
      try
      {
        localObject = paramCursor.getString(i);
      }
      catch (SQLiteException localSQLiteException)
      {
        StringBuilder localStringBuilder;
        for (;;) {}
      }
      localObject = "<unprintable>";
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("   ");
      localStringBuilder.append(arrayOfString[i]);
      localStringBuilder.append('=');
      localStringBuilder.append((String)localObject);
      localStringBuilder.append("\n");
      paramStringBuilder.append(localStringBuilder.toString());
      i += 1;
    }
    paramStringBuilder.append("}\n");
  }
  
  public static String dumpCurrentRowToString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCurrentRow(paramCursor, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  public static void dumpCursor(Cursor paramCursor)
  {
    dumpCursor(paramCursor, System.out);
  }
  
  public static void dumpCursor(Cursor paramCursor, PrintStream paramPrintStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>> Dumping cursor ");
    localStringBuilder.append(paramCursor);
    paramPrintStream.println(localStringBuilder.toString());
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramPrintStream);
      }
      paramCursor.moveToPosition(i);
    }
    paramPrintStream.println("<<<<<");
  }
  
  public static void dumpCursor(Cursor paramCursor, StringBuilder paramStringBuilder)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>>>> Dumping cursor ");
    localStringBuilder.append(paramCursor);
    localStringBuilder.append("\n");
    paramStringBuilder.append(localStringBuilder.toString());
    if (paramCursor != null)
    {
      int i = paramCursor.getPosition();
      paramCursor.moveToPosition(-1);
      while (paramCursor.moveToNext()) {
        dumpCurrentRow(paramCursor, paramStringBuilder);
      }
      paramCursor.moveToPosition(i);
    }
    paramStringBuilder.append("<<<<<\n");
  }
  
  public static String dumpCursorToString(Cursor paramCursor)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    dumpCursor(paramCursor, localStringBuilder);
    return localStringBuilder.toString();
  }
  
  private static char[] encodeHex(byte[] paramArrayOfByte, char[] paramArrayOfChar)
  {
    int k = paramArrayOfByte.length;
    char[] arrayOfChar = new char[k << 1];
    int i = 0;
    int j = 0;
    while (i < k)
    {
      int m = j + 1;
      arrayOfChar[j] = paramArrayOfChar[((paramArrayOfByte[i] & 0xF0) >>> 4)];
      j = m + 1;
      arrayOfChar[m] = paramArrayOfChar[(paramArrayOfByte[i] & 0xF)];
      i += 1;
    }
    return arrayOfChar;
  }
  
  public static String getCollationKey(String paramString)
  {
    paramString = getCollationKeyInBytes(paramString);
    try
    {
      paramString = new String(paramString, 0, getKeyLen(paramString), "ISO8859_1");
      return paramString;
    }
    catch (Exception paramString)
    {
      for (;;) {}
    }
    return "";
  }
  
  private static byte[] getCollationKeyInBytes(String paramString)
  {
    if (mColl == null)
    {
      Collator localCollator = Collator.getInstance();
      mColl = localCollator;
      localCollator.setStrength(0);
    }
    return mColl.getCollationKey(paramString).toByteArray();
  }
  
  public static String getHexCollationKey(String paramString)
  {
    paramString = getCollationKeyInBytes(paramString);
    return new String(encodeHex(paramString, HEX_DIGITS_LOWER), 0, getKeyLen(paramString) * 2);
  }
  
  private static int getKeyLen(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte[(paramArrayOfByte.length - 1)] != 0) {
      return paramArrayOfByte.length;
    }
    return paramArrayOfByte.length - 1;
  }
  
  public static int getTypeOfObject(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof byte[])) {
      return 4;
    }
    if ((!(paramObject instanceof Float)) && (!(paramObject instanceof Double)))
    {
      if ((!(paramObject instanceof Long)) && (!(paramObject instanceof Integer))) {
        return 3;
      }
      return 1;
    }
    return 2;
  }
  
  public static long longForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      long l = longForQuery(paramSQLiteDatabase, paramArrayOfString);
      return l;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static long longForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int k = paramArrayOfString.length;
      int j;
      for (int i = 0; i < k; i = j)
      {
        j = i + 1;
        bindObjectToProgram(paramSQLiteStatement, j, paramArrayOfString[i]);
      }
    }
    return paramSQLiteStatement.simpleQueryForLong();
  }
  
  public static long queryNumEntries(SQLiteDatabase paramSQLiteDatabase, String paramString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.query(paramString, countProjection, null, null, null, null, null);
    try
    {
      paramSQLiteDatabase.moveToFirst();
      long l = paramSQLiteDatabase.getLong(0);
      return l;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static final void readExceptionFromParcel(Parcel paramParcel)
  {
    int i = paramParcel.readInt();
    if (i == 0) {
      return;
    }
    readExceptionFromParcel(paramParcel, paramParcel.readString(), i);
  }
  
  private static final void readExceptionFromParcel(Parcel paramParcel, String paramString, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      paramParcel.readException(paramInt, paramString);
      return;
    case 9: 
      throw new SQLiteException(paramString);
    case 8: 
      throw new SQLiteDiskIOException(paramString);
    case 7: 
      throw new SQLiteFullException(paramString);
    case 6: 
      throw new SQLiteDatabaseCorruptException(paramString);
    case 5: 
      throw new SQLiteConstraintException(paramString);
    case 4: 
      throw new SQLiteAbortException(paramString);
    case 3: 
      throw new UnsupportedOperationException(paramString);
    }
    throw new IllegalArgumentException(paramString);
  }
  
  public static void readExceptionWithFileNotFoundExceptionFromParcel(Parcel paramParcel)
    throws FileNotFoundException
  {
    int i = paramParcel.readInt();
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    if (i != 1)
    {
      readExceptionFromParcel(paramParcel, str, i);
      return;
    }
    throw new FileNotFoundException(str);
  }
  
  public static void readExceptionWithOperationApplicationExceptionFromParcel(Parcel paramParcel)
    throws OperationApplicationException
  {
    int i = paramParcel.readInt();
    if (i == 0) {
      return;
    }
    String str = paramParcel.readString();
    if (i != 10)
    {
      readExceptionFromParcel(paramParcel, str, i);
      return;
    }
    throw new OperationApplicationException(str);
  }
  
  public static String sqlEscapeString(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    appendEscapedSQLString(localStringBuilder, paramString);
    return localStringBuilder.toString();
  }
  
  public static String stringForQuery(SQLiteDatabase paramSQLiteDatabase, String paramString, String[] paramArrayOfString)
  {
    paramSQLiteDatabase = paramSQLiteDatabase.compileStatement(paramString);
    try
    {
      paramString = stringForQuery(paramSQLiteDatabase, paramArrayOfString);
      return paramString;
    }
    finally
    {
      paramSQLiteDatabase.close();
    }
  }
  
  public static String stringForQuery(SQLiteStatement paramSQLiteStatement, String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int k = paramArrayOfString.length;
      int j;
      for (int i = 0; i < k; i = j)
      {
        j = i + 1;
        bindObjectToProgram(paramSQLiteStatement, j, paramArrayOfString[i]);
      }
    }
    return paramSQLiteStatement.simpleQueryForString();
  }
  
  public static final void writeExceptionToParcel(Parcel paramParcel, Exception paramException)
  {
    boolean bool = paramException instanceof FileNotFoundException;
    int j = 1;
    int i;
    if (bool)
    {
      i = 0;
    }
    else if ((paramException instanceof IllegalArgumentException))
    {
      i = 1;
      j = 2;
    }
    else if ((paramException instanceof UnsupportedOperationException))
    {
      i = 1;
      j = 3;
    }
    else if ((paramException instanceof SQLiteAbortException))
    {
      i = 1;
      j = 4;
    }
    else if ((paramException instanceof SQLiteConstraintException))
    {
      i = 1;
      j = 5;
    }
    else if ((paramException instanceof SQLiteDatabaseCorruptException))
    {
      i = 1;
      j = 6;
    }
    else if ((paramException instanceof SQLiteFullException))
    {
      i = 1;
      j = 7;
    }
    else if ((paramException instanceof SQLiteDiskIOException))
    {
      i = 1;
      j = 8;
    }
    else if ((paramException instanceof SQLiteException))
    {
      i = 1;
      j = 9;
    }
    else
    {
      if (!(paramException instanceof OperationApplicationException)) {
        break label174;
      }
      i = 1;
      j = 10;
    }
    paramParcel.writeInt(j);
    paramParcel.writeString(paramException.getMessage());
    if (i != 0) {
      Log.e("DatabaseUtils", "Writing exception to parcel", paramException);
    }
    return;
    label174:
    paramParcel.writeException(paramException);
    Log.e("DatabaseUtils", "Writing exception to parcel", paramException);
  }
  
  public static class InsertHelper
  {
    public static final int TABLE_INFO_PRAGMA_COLUMNNAME_INDEX = 1;
    public static final int TABLE_INFO_PRAGMA_DEFAULT_INDEX = 4;
    private HashMap<String, Integer> mColumns;
    private final SQLiteDatabase mDb;
    private String mInsertSQL = null;
    private SQLiteStatement mInsertStatement = null;
    private SQLiteStatement mPreparedStatement = null;
    private SQLiteStatement mReplaceStatement = null;
    private final String mTableName;
    
    public InsertHelper(SQLiteDatabase paramSQLiteDatabase, String paramString)
    {
      this.mDb = paramSQLiteDatabase;
      this.mTableName = paramString;
    }
    
    /* Error */
    private void buildSQL()
      throws SQLException
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
    
    private SQLiteStatement getStatement(boolean paramBoolean)
      throws SQLException
    {
      return null;
    }
    
    private long insertInternal(ContentValues paramContentValues, boolean paramBoolean)
    {
      return 277740772L;
    }
    
    public void bind(int paramInt, double paramDouble)
    {
      this.mPreparedStatement.bindDouble(paramInt, paramDouble);
    }
    
    public void bind(int paramInt, float paramFloat)
    {
      this.mPreparedStatement.bindDouble(paramInt, paramFloat);
    }
    
    public void bind(int paramInt1, int paramInt2)
    {
      this.mPreparedStatement.bindLong(paramInt1, paramInt2);
    }
    
    public void bind(int paramInt, long paramLong)
    {
      this.mPreparedStatement.bindLong(paramInt, paramLong);
    }
    
    /* Error */
    public void bind(int arg1, String arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void bind(int arg1, boolean arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_3
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void bind(int arg1, byte[] arg2)
    {
      // Byte code:
      //   0: return
      //   1: astore_2
      //   2: goto -2 -> 0
    }
    
    public void bindNull(int paramInt)
    {
      this.mPreparedStatement.bindNull(paramInt);
    }
    
    /* Error */
    public void close()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public long execute()
    {
      return 277740860L;
    }
    
    public int getColumnIndex(String paramString)
    {
      return 0;
    }
    
    public long insert(ContentValues paramContentValues)
    {
      return insertInternal(paramContentValues, false);
    }
    
    /* Error */
    public void prepareForInsert()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    /* Error */
    public void prepareForReplace()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    public long replace(ContentValues paramContentValues)
    {
      return insertInternal(paramContentValues, true);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\DatabaseUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */