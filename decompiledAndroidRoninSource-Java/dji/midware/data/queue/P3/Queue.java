package dji.midware.data.queue.P3;

import android.util.SparseArray;
import dji.midware.data.packages.P3.Pack;
import java.util.ArrayList;

public class Queue
  extends QueueBase
{
  private static final int REMOVE_MSG_LENGTH = 30;
  private int MAX_LENGTH = 100;
  private SparseArray<QueueBase.Msg> list = null;
  private ArrayList<Integer> listKey = null;
  
  private int getKey(Pack paramPack)
  {
    int i = paramPack.cmdId;
    return paramPack.seq | i << 16;
  }
  
  /* Error */
  private void removeLast()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public QueueBase.Msg addMsg(Pack paramPack)
  {
    return null;
  }
  
  public void destroy()
  {
    this.list = null;
    this.listKey = null;
  }
  
  /* Error */
  public void setMsg(Pack arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\queue\P3\Queue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */