package io.flutter.embedding.engine.loader;

import android.content.Context;
import android.os.AsyncTask;
import java.io.File;
import java.io.FilenameFilter;

class ResourceCleaner
{
  private static final long DELAY_MS = 5000L;
  private static final String TAG = "ResourceCleaner";
  private final Context mContext;
  
  ResourceCleaner(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  /* Error */
  void start()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private static class CleanTask
    extends AsyncTask<Void, Void, Void>
  {
    private final File[] mFilesToDelete;
    
    CleanTask(File[] paramArrayOfFile)
    {
      this.mFilesToDelete = paramArrayOfFile;
    }
    
    /* Error */
    private void deleteRecursively(File arg1)
    {
      // Byte code:
      //   0: return
      //   1: astore_1
      //   2: goto -2 -> 0
    }
    
    protected Void doInBackground(Void... paramVarArgs)
    {
      return null;
    }
    
    boolean hasFilesToDelete()
    {
      return false;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\flutter\embedding\engine\loader\ResourceCleaner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */