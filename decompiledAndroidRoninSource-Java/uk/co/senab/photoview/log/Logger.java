package uk.co.senab.photoview.log;

public abstract interface Logger
{
  public abstract int d(String paramString1, String paramString2);
  
  public abstract int d(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int e(String paramString1, String paramString2);
  
  public abstract int e(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int i(String paramString1, String paramString2);
  
  public abstract int i(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int v(String paramString1, String paramString2);
  
  public abstract int v(String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract int w(String paramString1, String paramString2);
  
  public abstract int w(String paramString1, String paramString2, Throwable paramThrowable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar\\uk\co\senab\photoview\log\Logger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */