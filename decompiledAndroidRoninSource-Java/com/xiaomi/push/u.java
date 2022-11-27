package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.b;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class u
{
  private static final Set<String> jdField_a_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private Context jdField_a_of_type_AndroidContentContext;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  private String jdField_a_of_type_JavaLangString;
  private FileLock jdField_a_of_type_JavaNioChannelsFileLock;
  
  private u(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public static u a(Context paramContext, File paramFile)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Locking: ");
    ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
    b.c(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramFile.getAbsolutePath());
    ((StringBuilder)localObject).append(".LOCK");
    paramFile = ((StringBuilder)localObject).toString();
    localObject = new File(paramFile);
    if (!((File)localObject).exists())
    {
      ((File)localObject).getParentFile().mkdirs();
      ((File)localObject).createNewFile();
    }
    if (jdField_a_of_type_JavaUtilSet.add(paramFile))
    {
      paramContext = new u(paramContext);
      paramContext.jdField_a_of_type_JavaLangString = paramFile;
      try
      {
        localObject = new RandomAccessFile((File)localObject, "rw");
        paramContext.jdField_a_of_type_JavaIoRandomAccessFile = ((RandomAccessFile)localObject);
        paramContext.jdField_a_of_type_JavaNioChannelsFileLock = ((RandomAccessFile)localObject).getChannel().lock();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Locked: ");
        ((StringBuilder)localObject).append(paramFile);
        ((StringBuilder)localObject).append(" :");
        ((StringBuilder)localObject).append(paramContext.jdField_a_of_type_JavaNioChannelsFileLock);
        b.c(((StringBuilder)localObject).toString());
        if (paramContext.jdField_a_of_type_JavaNioChannelsFileLock == null)
        {
          paramFile = paramContext.jdField_a_of_type_JavaIoRandomAccessFile;
          if (paramFile != null) {
            y.a(paramFile);
          }
          jdField_a_of_type_JavaUtilSet.remove(paramContext.jdField_a_of_type_JavaLangString);
        }
        return paramContext;
      }
      finally
      {
        if (paramContext.jdField_a_of_type_JavaNioChannelsFileLock == null)
        {
          localObject = paramContext.jdField_a_of_type_JavaIoRandomAccessFile;
          if (localObject != null) {
            y.a((Closeable)localObject);
          }
          jdField_a_of_type_JavaUtilSet.remove(paramContext.jdField_a_of_type_JavaLangString);
        }
      }
    }
    throw new IOException("abtain lock failure");
  }
  
  /* Error */
  public void a()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: return
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\pus\\u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */