package dji.thirdparty.afinal.exception;

public class ViewException
  extends AfinalException
{
  private static final long serialVersionUID = 1L;
  private String strMsg = null;
  
  public ViewException(String paramString)
  {
    this.strMsg = paramString;
  }
  
  /* Error */
  public void printStackTrace()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\exception\ViewException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */