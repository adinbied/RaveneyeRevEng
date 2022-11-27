package dji.midware.data.queue.P3;

public class PackUtil
{
  private static int seq;
  private static int sessionId;
  
  public static int getSeq()
  {
    try
    {
      int i = seq + 1;
      seq = i;
      if (i == 85) {
        seq = i + 1;
      } else if (i >= 65535) {
        seq = 0;
      }
      i = seq;
      return i;
    }
    finally {}
  }
  
  public static int getSessionId()
  {
    try
    {
      int i = sessionId + 1;
      sessionId = i;
      if (i == 85) {
        sessionId = i + 1;
      } else if (i >= 65535) {
        sessionId = 0;
      }
      i = sessionId;
      return i;
    }
    finally {}
  }
  
  public static int sessionId()
  {
    try
    {
      int i = sessionId;
      return i;
    }
    finally
    {
      localObject = finally;
      throw ((Throwable)localObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\queue\P3\PackUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */