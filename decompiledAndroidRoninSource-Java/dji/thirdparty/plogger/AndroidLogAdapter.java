package dji.thirdparty.plogger;

import android.util.Log;

class AndroidLogAdapter
  implements LogAdapter
{
  public void d(String paramString1, String paramString2)
  {
    Log.d(paramString1, paramString2);
  }
  
  public void e(String paramString1, String paramString2)
  {
    Log.e(paramString1, paramString2);
  }
  
  public void i(String paramString1, String paramString2)
  {
    Log.i(paramString1, paramString2);
  }
  
  public void v(String paramString1, String paramString2)
  {
    Log.v(paramString1, paramString2);
  }
  
  public void w(String paramString1, String paramString2)
  {
    Log.w(paramString1, paramString2);
  }
  
  public void wtf(String paramString1, String paramString2)
  {
    Log.wtf(paramString1, paramString2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\plogger\AndroidLogAdapter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */