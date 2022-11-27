package dji.thirdparty.okhttp3;

import java.io.IOException;

public abstract interface Callback
{
  public abstract void onFailure(Call paramCall, IOException paramIOException);
  
  public abstract void onResponse(Call paramCall, Response paramResponse)
    throws IOException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */