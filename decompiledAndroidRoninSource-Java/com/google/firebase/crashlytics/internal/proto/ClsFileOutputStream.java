package com.google.firebase.crashlytics.internal.proto;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class ClsFileOutputStream
  extends FileOutputStream
{
  public static final String IN_PROGRESS_SESSION_FILE_EXTENSION = ".cls_temp";
  public static final String SESSION_FILE_EXTENSION = ".cls";
  public static final FilenameFilter TEMP_FILENAME_FILTER = new FilenameFilter()
  {
    public boolean accept(File paramAnonymousFile, String paramAnonymousString)
    {
      return paramAnonymousString.endsWith(".cls_temp");
    }
  };
  private boolean closed = false;
  private File complete;
  private File inProgress;
  private final String root;
  
  public ClsFileOutputStream(File paramFile, String paramString)
    throws FileNotFoundException
  {
    super(new File(paramFile, localStringBuilder.toString()));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFile);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    this.root = localStringBuilder.toString();
    paramFile = new StringBuilder();
    paramFile.append(this.root);
    paramFile.append(".cls_temp");
    this.inProgress = new File(paramFile.toString());
  }
  
  public ClsFileOutputStream(String paramString1, String paramString2)
    throws FileNotFoundException
  {
    this(new File(paramString1), paramString2);
  }
  
  public void close()
    throws IOException
  {
    for (;;)
    {
      try
      {
        boolean bool = this.closed;
        if (bool) {
          return;
        }
        this.closed = true;
        super.flush();
        super.close();
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(this.root);
        ((StringBuilder)localObject1).append(".cls");
        File localFile = new File(((StringBuilder)localObject1).toString());
        if (this.inProgress.renameTo(localFile))
        {
          this.inProgress = null;
          this.complete = localFile;
          return;
        }
        localObject1 = "";
        if (!localFile.exists())
        {
          if (!this.inProgress.exists()) {
            localObject1 = " (source does not exist)";
          }
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("Could not rename temp file: ");
          localStringBuilder.append(this.inProgress);
          localStringBuilder.append(" -> ");
          localStringBuilder.append(localFile);
          localStringBuilder.append((String)localObject1);
          throw new IOException(localStringBuilder.toString());
        }
      }
      finally {}
      String str = " (target already exists)";
    }
  }
  
  public void closeInProgressStream()
    throws IOException
  {
    if (this.closed) {
      return;
    }
    this.closed = true;
    super.flush();
    super.close();
  }
  
  public File getCompleteFile()
  {
    return this.complete;
  }
  
  public File getInProgressFile()
  {
    return this.inProgress;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\firebase\crashlytics\internal\proto\ClsFileOutputStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */