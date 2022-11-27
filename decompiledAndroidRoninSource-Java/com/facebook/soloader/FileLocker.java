package com.facebook.soloader;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import javax.annotation.Nullable;

public final class FileLocker
  implements Closeable
{
  @Nullable
  private final FileLock mLock;
  private final FileOutputStream mLockFileOutputStream;
  
  private FileLocker(File paramFile)
    throws IOException
  {
    paramFile = new FileOutputStream(paramFile);
    this.mLockFileOutputStream = paramFile;
    try
    {
      paramFile = paramFile.getChannel().lock();
      if (paramFile == null) {
        this.mLockFileOutputStream.close();
      }
      this.mLock = paramFile;
      return;
    }
    finally
    {
      this.mLockFileOutputStream.close();
    }
  }
  
  public static FileLocker lock(File paramFile)
    throws IOException
  {
    return new FileLocker(paramFile);
  }
  
  public void close()
    throws IOException
  {
    try
    {
      if (this.mLock != null) {
        this.mLock.release();
      }
      return;
    }
    finally
    {
      this.mLockFileOutputStream.close();
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\FileLocker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */