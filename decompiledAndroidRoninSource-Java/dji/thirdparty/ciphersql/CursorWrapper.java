package dji.thirdparty.ciphersql;

public class CursorWrapper
  extends android.database.CursorWrapper
  implements Cursor
{
  private final Cursor mCursor;
  
  public CursorWrapper(Cursor paramCursor)
  {
    super(paramCursor);
    this.mCursor = paramCursor;
  }
  
  public int getType(int paramInt)
  {
    return this.mCursor.getType(paramInt);
  }
  
  public Cursor getWrappedCursor()
  {
    return this.mCursor;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\ciphersql\CursorWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */