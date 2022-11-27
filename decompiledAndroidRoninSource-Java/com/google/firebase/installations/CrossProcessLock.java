package com.google.firebase.installations;

import android.content.Context;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

class CrossProcessLock
{
  private static final String TAG = "CrossProcessLock";
  private final FileChannel channel;
  private final FileLock lock;
  
  private CrossProcessLock(FileChannel paramFileChannel, FileLock paramFileLock)
  {
    this.channel = paramFileChannel;
    this.lock = paramFileLock;
  }
  
  static CrossProcessLock acquire(Context paramContext, String paramString)
  {
    try
    {
      localFileChannel = new RandomAccessFile(new File(paramContext.getFilesDir(), paramString), "rw").getChannel();
      try
      {
        paramString = localFileChannel.lock();
        try
        {
          paramContext = new CrossProcessLock(localFileChannel, paramString);
          return paramContext;
        }
        catch (Error paramContext) {}catch (IOException paramContext) {}
        paramString = null;
      }
      catch (Error paramContext) {}catch (IOException paramContext) {}
    }
    catch (Error paramContext) {}catch (IOException paramContext) {}
    FileChannel localFileChannel = null;
    paramString = localFileChannel;
    Log.e("CrossProcessLock", "encountered error while creating and acquiring the lock, ignoring", paramContext);
    if (paramString != null) {}
    try
    {
      paramString.release();
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        try
        {
          localFileChannel.close();
          return null;
        }
        catch (IOException paramContext) {}
        paramContext = paramContext;
      }
    }
    if (localFileChannel != null) {}
    return null;
  }
  
  void releaseAndClose()
  {
    try
    {
      this.lock.release();
      this.channel.close();
      return;
    }
    catch (IOException localIOException)
    {
      Log.e("CrossProcessLock", "encountered error while releasing, ignoring", localIOException);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\installations\CrossProcessLock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */