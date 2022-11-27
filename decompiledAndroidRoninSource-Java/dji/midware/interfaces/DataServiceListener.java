package dji.midware.interfaces;

import dji.midware.data.config.P3.CmdSet;
import dji.midware.data.queue.P3.Queue;
import dji.midware.data.queue.P3.QueueBase;

public abstract interface DataServiceListener
{
  public abstract Queue getQueue(int paramInt);
  
  public abstract QueueBase getQueue(CmdSet paramCmdSet);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\interfaces\DataServiceListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */