package dji.thirdparty.plogger;

public abstract interface Printer
{
  public abstract void d(Object paramObject);
  
  public abstract void d(String paramString, Object... paramVarArgs);
  
  public abstract void e(String paramString, Object... paramVarArgs);
  
  public abstract void e(Throwable paramThrowable, String paramString, Object... paramVarArgs);
  
  public abstract Settings getSettings();
  
  public abstract void i(String paramString, Object... paramVarArgs);
  
  public abstract Settings init(String paramString);
  
  public abstract void json(String paramString);
  
  public abstract void log(int paramInt, String paramString1, String paramString2, Throwable paramThrowable);
  
  public abstract void resetSettings();
  
  public abstract Printer t(String paramString, int paramInt);
  
  public abstract void v(String paramString, Object... paramVarArgs);
  
  public abstract void w(String paramString, Object... paramVarArgs);
  
  public abstract void wtf(String paramString, Object... paramVarArgs);
  
  public abstract void xml(String paramString);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\plogger\Printer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */