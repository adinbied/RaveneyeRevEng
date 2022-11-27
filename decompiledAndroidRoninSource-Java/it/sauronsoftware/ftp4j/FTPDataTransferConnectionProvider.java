package it.sauronsoftware.ftp4j;

import java.net.Socket;

abstract interface FTPDataTransferConnectionProvider
{
  public abstract void dispose();
  
  public abstract Socket openDataTransferConnection()
    throws FTPDataTransferException;
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPDataTransferConnectionProvider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */