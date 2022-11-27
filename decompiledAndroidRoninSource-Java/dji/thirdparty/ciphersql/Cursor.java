package dji.thirdparty.ciphersql;

public abstract interface Cursor
  extends android.database.Cursor
{
  public static final int FIELD_TYPE_BLOB = 4;
  public static final int FIELD_TYPE_FLOAT = 2;
  public static final int FIELD_TYPE_INTEGER = 1;
  public static final int FIELD_TYPE_NULL = 0;
  public static final int FIELD_TYPE_STRING = 3;
  
  public abstract int getType(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\Cursor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */