package com.google.firebase.crashlytics.internal.common;

import android.os.Looper;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public final class Utils
{
  private static final FilenameFilter ALL_FILES_FILTER = new FilenameFilter()
  {
    public boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return true;
    }
  };
  private static final ExecutorService TASK_CONTINUATION_EXECUTOR_SERVICE = ExecutorUtils.buildSingleThreadExecutorService("awaitEvenIfOnMainThread task continuation executor");
  
  public static <T> T awaitEvenIfOnMainThread(Task<T> paramTask)
    throws InterruptedException, TimeoutException
  {
    CountDownLatch localCountDownLatch = new CountDownLatch(1);
    paramTask.continueWith(TASK_CONTINUATION_EXECUTOR_SERVICE, Utils..Lambda.1.lambdaFactory$(localCountDownLatch));
    if (Looper.getMainLooper() == Looper.myLooper()) {
      localCountDownLatch.await(4L, TimeUnit.SECONDS);
    } else {
      localCountDownLatch.await();
    }
    if (paramTask.isSuccessful()) {
      return (T)paramTask.getResult();
    }
    if (!paramTask.isCanceled())
    {
      if (paramTask.isComplete()) {
        throw new IllegalStateException(paramTask.getException());
      }
      throw new TimeoutException();
    }
    throw new CancellationException("Task is already canceled");
  }
  
  public static <T> Task<T> callTask(Executor paramExecutor, Callable<Task<T>> paramCallable)
  {
    final TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    paramExecutor.execute(new Runnable()
    {
      public void run()
      {
        try
        {
          ((Task)Utils.this.call()).continueWith(new Continuation()
          {
            public Void then(Task<T> paramAnonymous2Task)
              throws Exception
            {
              if (paramAnonymous2Task.isSuccessful()) {
                Utils.3.this.val$tcs.setResult(paramAnonymous2Task.getResult());
              } else {
                Utils.3.this.val$tcs.setException(paramAnonymous2Task.getException());
              }
              return null;
            }
          });
          return;
        }
        catch (Exception localException)
        {
          localTaskCompletionSource.setException(localException);
        }
      }
    });
    return localTaskCompletionSource.getTask();
  }
  
  static int capFileCount(File paramFile, int paramInt, Comparator<File> paramComparator)
  {
    return capFileCount(paramFile, ALL_FILES_FILTER, paramInt, paramComparator);
  }
  
  static int capFileCount(File paramFile, FilenameFilter paramFilenameFilter, int paramInt, Comparator<File> paramComparator)
  {
    paramFile = paramFile.listFiles(paramFilenameFilter);
    if (paramFile == null) {
      return 0;
    }
    return capFileCount(Arrays.asList(paramFile), paramInt, paramComparator);
  }
  
  static int capFileCount(List<File> paramList, int paramInt, Comparator<File> paramComparator)
  {
    int i = paramList.size();
    Collections.sort(paramList, paramComparator);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      paramComparator = (File)paramList.next();
      if (i <= paramInt) {
        return i;
      }
      recursiveDelete(paramComparator);
      i -= 1;
    }
    return i;
  }
  
  static int capSessionCount(File paramFile1, File paramFile2, int paramInt, Comparator<File> paramComparator)
  {
    ArrayList localArrayList = new ArrayList();
    paramFile1 = paramFile1.listFiles();
    paramFile2 = paramFile2.listFiles(ALL_FILES_FILTER);
    if (paramFile1 == null) {
      paramFile1 = new File[0];
    }
    if (paramFile2 == null) {
      paramFile2 = new File[0];
    }
    localArrayList.addAll(Arrays.asList(paramFile1));
    localArrayList.addAll(Arrays.asList(paramFile2));
    return capFileCount(localArrayList, paramInt, paramComparator);
  }
  
  public static <T> Task<T> race(Task<T> paramTask1, Task<T> paramTask2)
  {
    TaskCompletionSource localTaskCompletionSource = new TaskCompletionSource();
    Continuation local2 = new Continuation()
    {
      public Void then(Task<T> paramAnonymousTask)
        throws Exception
      {
        if (paramAnonymousTask.isSuccessful()) {
          Utils.this.trySetResult(paramAnonymousTask.getResult());
        } else {
          Utils.this.trySetException(paramAnonymousTask.getException());
        }
        return null;
      }
    };
    paramTask1.continueWith(local2);
    paramTask2.continueWith(local2);
    return localTaskCompletionSource.getTask();
  }
  
  private static void recursiveDelete(File paramFile)
  {
    if (paramFile.isDirectory())
    {
      File[] arrayOfFile = paramFile.listFiles();
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        recursiveDelete(arrayOfFile[i]);
        i += 1;
      }
    }
    paramFile.delete();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\common\Utils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */