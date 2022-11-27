package dji.thirdparty.afinal.exception;

public class AfinalException
  extends RuntimeException
{
  private static final long serialVersionUID = 1L;
  
  public AfinalException() {}
  
  public AfinalException(String paramString)
  {
    super(paramString);
  }
  
  public AfinalException(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
  }
  
  public AfinalException(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\exception\AfinalException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */