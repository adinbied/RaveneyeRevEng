package dji.thirdparty.okhttp3;

import java.io.IOException;

public abstract interface Call
{
  public abstract void cancel();
  
  public abstract void enqueue(Callback paramCallback);
  
  public abstract Response execute()
    throws IOException;
  
  public abstract boolean isCanceled();
  
  public abstract boolean isExecuted();
  
  public abstract Request request();
  
  public static abstract interface Factory
  {
    public abstract Call newCall(Request paramRequest);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */