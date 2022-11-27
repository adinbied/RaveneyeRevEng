package com.dji.video.framing.utils.stream;

import dji.log.DJILog;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.List;

public class StreamDataLogHelper
  implements StreamDataObserver.IStreamDataObserverGlobalListener
{
  private static boolean IS_OPEN = true;
  private int cachingCount = 0;
  private List<String> curNameList;
  private DateFormat dateFormat;
  private boolean hasData = false;
  private int interval = 2;
  private boolean isLastLineEmpty = false;
  private int lastLineStart = 0;
  private StringBuffer mSb = new StringBuffer();
  private boolean needLogNameList = false;
  private List<String> processingNameList;
  private int skipCount = 0;
  private Object writeDataLock = new Object();
  private int writeNum = 30;
  
  private String getTimeString()
  {
    return null;
  }
  
  private boolean isListEqual(List paramList1, List paramList2)
  {
    if ((paramList1 == null) && (paramList2 == null)) {
      return true;
    }
    if ((paramList1 != null) && (paramList2 != null)) {
      return Arrays.equals(paramList1.toArray(), paramList2.toArray());
    }
    return false;
  }
  
  private void log2File(String paramString)
  {
    DJILog.saveLog(paramString, "LiveStreaming");
  }
  
  /* Error */
  private void logList(List arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onByteRatesUpdate(java.util.Map<String, java.util.Map<String, Long>> arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  public void start()
  {
    if (IS_OPEN) {
      StreamDataObserver.addListener(this);
    }
  }
  
  /* Error */
  public void stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\stream\StreamDataLogHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */