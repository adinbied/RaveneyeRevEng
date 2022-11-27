package dji.thirdparty.okhttp3;

import java.net.Socket;

public abstract interface Connection
{
  public abstract Handshake handshake();
  
  public abstract Protocol protocol();
  
  public abstract Route route();
  
  public abstract Socket socket();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\okhttp3\Connection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */