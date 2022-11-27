package retrofit2;

import java.io.IOException;
import okhttp3.Request;
import okio.Timeout;

public abstract interface Call<T>
  extends Cloneable
{
  public abstract void cancel();
  
  public abstract Call<T> clone();
  
  public abstract void enqueue(Callback<T> paramCallback);
  
  public abstract Response<T> execute()
    throws IOException;
  
  public abstract boolean isCanceled();
  
  public abstract boolean isExecuted();
  
  public abstract Request request();
  
  public abstract Timeout timeout();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\retrofit2\Call.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */