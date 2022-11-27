package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheErrorLogger.CacheErrorCategory;
import com.facebook.common.file.FileTree;
import com.facebook.common.file.FileUtils;
import com.facebook.common.file.FileUtils.CreateDirectoryException;
import com.facebook.common.internal.Preconditions;
import com.facebook.common.internal.Supplier;
import com.facebook.common.logging.FLog;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;

public class DynamicDefaultDiskStorage
  implements DiskStorage
{
  private static final Class<?> TAG = DynamicDefaultDiskStorage.class;
  private final String mBaseDirectoryName;
  private final Supplier<File> mBaseDirectoryPathSupplier;
  private final CacheErrorLogger mCacheErrorLogger;
  volatile State mCurrentState;
  private final int mVersion;
  
  public DynamicDefaultDiskStorage(int paramInt, Supplier<File> paramSupplier, String paramString, CacheErrorLogger paramCacheErrorLogger)
  {
    this.mVersion = paramInt;
    this.mCacheErrorLogger = paramCacheErrorLogger;
    this.mBaseDirectoryPathSupplier = paramSupplier;
    this.mBaseDirectoryName = paramString;
    this.mCurrentState = new State(null, null);
  }
  
  private void createStorage()
    throws IOException
  {
    File localFile = new File((File)this.mBaseDirectoryPathSupplier.get(), this.mBaseDirectoryName);
    createRootDirectoryIfNecessary(localFile);
    this.mCurrentState = new State(localFile, new DefaultDiskStorage(localFile, this.mVersion, this.mCacheErrorLogger));
  }
  
  private boolean shouldCreateNewStorage()
  {
    State localState = this.mCurrentState;
    return (localState.delegate == null) || (localState.rootDirectory == null) || (!localState.rootDirectory.exists());
  }
  
  public void clearAll()
    throws IOException
  {
    get().clearAll();
  }
  
  public boolean contains(String paramString, Object paramObject)
    throws IOException
  {
    return get().contains(paramString, paramObject);
  }
  
  void createRootDirectoryIfNecessary(File paramFile)
    throws IOException
  {
    try
    {
      FileUtils.mkdirs(paramFile);
      FLog.d(TAG, "Created cache directory %s", paramFile.getAbsolutePath());
      return;
    }
    catch (FileUtils.CreateDirectoryException paramFile)
    {
      this.mCacheErrorLogger.logError(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, TAG, "createRootDirectoryIfNecessary", paramFile);
      throw paramFile;
    }
  }
  
  void deleteOldStorageIfNecessary()
  {
    if ((this.mCurrentState.delegate != null) && (this.mCurrentState.rootDirectory != null)) {
      FileTree.deleteRecursively(this.mCurrentState.rootDirectory);
    }
  }
  
  DiskStorage get()
    throws IOException
  {
    try
    {
      if (shouldCreateNewStorage())
      {
        deleteOldStorageIfNecessary();
        createStorage();
      }
      DiskStorage localDiskStorage = (DiskStorage)Preconditions.checkNotNull(this.mCurrentState.delegate);
      return localDiskStorage;
    }
    finally {}
  }
  
  public DiskStorage.DiskDumpInfo getDumpInfo()
    throws IOException
  {
    return get().getDumpInfo();
  }
  
  public Collection<DiskStorage.Entry> getEntries()
    throws IOException
  {
    return get().getEntries();
  }
  
  public BinaryResource getResource(String paramString, Object paramObject)
    throws IOException
  {
    return get().getResource(paramString, paramObject);
  }
  
  public String getStorageName()
  {
    try
    {
      String str = get().getStorageName();
      return str;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return "";
  }
  
  public DiskStorage.Inserter insert(String paramString, Object paramObject)
    throws IOException
  {
    return get().insert(paramString, paramObject);
  }
  
  public boolean isEnabled()
  {
    try
    {
      boolean bool = get().isEnabled();
      return bool;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return false;
  }
  
  public boolean isExternal()
  {
    try
    {
      boolean bool = get().isExternal();
      return bool;
    }
    catch (IOException localIOException)
    {
      for (;;) {}
    }
    return false;
  }
  
  public void purgeUnexpectedResources()
  {
    try
    {
      get().purgeUnexpectedResources();
      return;
    }
    catch (IOException localIOException)
    {
      FLog.e(TAG, "purgeUnexpectedResources", localIOException);
    }
  }
  
  public long remove(DiskStorage.Entry paramEntry)
    throws IOException
  {
    return get().remove(paramEntry);
  }
  
  public long remove(String paramString)
    throws IOException
  {
    return get().remove(paramString);
  }
  
  public boolean touch(String paramString, Object paramObject)
    throws IOException
  {
    return get().touch(paramString, paramObject);
  }
  
  static class State
  {
    @Nullable
    public final DiskStorage delegate;
    @Nullable
    public final File rootDirectory;
    
    State(@Nullable File paramFile, @Nullable DiskStorage paramDiskStorage)
    {
      this.delegate = paramDiskStorage;
      this.rootDirectory = paramFile;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\cache\disk\DynamicDefaultDiskStorage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */