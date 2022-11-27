package dji.midware.media.transcode.online;

import java.util.concurrent.ArrayBlockingQueue;

public class FrameBuffer
{
  private static boolean DEBUG;
  private final int frameCapacity;
  private int generated;
  private final ArrayBlockingQueue<Frame> pool;
  private final int poolCapacity;
  private final ArrayBlockingQueue<Frame> queue;
  private final Frame.FrameType type;
  
  public FrameBuffer(int paramInt1, int paramInt2, Frame.FrameType paramFrameType)
  {
    this.frameCapacity = paramInt1;
    this.poolCapacity = paramInt2;
    this.type = paramFrameType;
    this.pool = new ArrayBlockingQueue(this.poolCapacity);
    this.queue = new ArrayBlockingQueue(this.poolCapacity);
    this.generated = 0;
  }
  
  /* Error */
  public void deinit()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Frame getFrame()
  {
    return null;
  }
  
  public int getQueueSize()
  {
    return this.queue.size();
  }
  
  /* Error */
  public void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public Frame peek()
  {
    return null;
  }
  
  public Frame poll()
  {
    return null;
  }
  
  /* Error */
  public void queue(Frame arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void release(Frame paramFrame)
  {
    this.pool.offer(paramFrame);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\media\transcode\online\FrameBuffer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */