package com.dji.video.framing.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import androidx.documentfile.provider.DocumentFile;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;

public class FileStreamCopyController
{
  private static final int CACHE_NUM = 5;
  private static final int MSG_OBSERVE = 1;
  private static final int MSG_START = 0;
  private static final int MSG_STOP = 2;
  private static final String TAG = "FileStreamCopyControl";
  private byte[] cache = new byte['Ѐ'];
  private File inputFile;
  private FileInputStream inputStream;
  private boolean isPaused = false;
  private boolean needRemoveSrcFile = false;
  private Handler observingHandler;
  private HandlerThread observingThread;
  private OutputStream outputStream;
  private int writeNum = 0;
  
  public FileStreamCopyController(String paramString)
  {
    this.inputFile = new File(paramString);
  }
  
  /* Error */
  private void _stop()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  /* Error */
  private void _stop(Object arg1, int arg2)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private int observe(boolean paramBoolean)
    throws IOException
  {
    return 0;
  }
  
  private void setOutputStream(FileOutputStream paramFileOutputStream)
  {
    this.outputStream = paramFileOutputStream;
  }
  
  /* Error */
  private void setOutputStream(String arg1)
    throws IOException
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void forceStop()
  {
    _stop();
  }
  
  public boolean isRunning()
  {
    return this.observingHandler != null;
  }
  
  /* Error */
  public void pause()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void resume()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void start(OutputStream arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void startThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void stop(DocumentFile paramDocumentFile, int paramInt, boolean paramBoolean)
    throws IOException
  {
    this.needRemoveSrcFile = paramBoolean;
    _stop(paramDocumentFile, paramInt);
  }
  
  public void stop(RandomAccessFile paramRandomAccessFile, int paramInt)
    throws IOException
  {
    _stop(paramRandomAccessFile, paramInt);
  }
  
  /* Error */
  public void stopThread()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
  
  private class StopStreamCopyTask
    extends Thread
  {
    private Object checkFileObj;
    private int checkLen;
    
    public StopStreamCopyTask(Object paramObject, int paramInt)
    {
      this.checkFileObj = paramObject;
      this.checkLen = paramInt;
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: return
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\dji\video\framin\\utils\FileStreamCopyController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */