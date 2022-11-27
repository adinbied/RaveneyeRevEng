package it.sauronsoftware.ftp4j;

public abstract interface FTPDataTransferListener
{
  public abstract void aborted();
  
  public abstract void completed();
  
  public abstract void failed();
  
  public abstract void started();
  
  public abstract void transferred(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\it\sauronsoftware\ftp4j\FTPDataTransferListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */