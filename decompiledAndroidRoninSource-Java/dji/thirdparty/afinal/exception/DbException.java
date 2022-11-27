package dji.thirdparty.afinal.exception;

public class DbException
  extends AfinalException
{
  private static final long serialVersionUID = 1L;
  
  public DbException() {}
  
  public DbException(String paramString)
  {
    super(paramString);
  }
  
  public DbException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public DbException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\exception\DbException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */