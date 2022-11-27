package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.StrictMode.ThreadPolicy;
import android.util.Log;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;

public class ApplicationSoSource
  extends SoSource
{
  private Context applicationContext;
  private int flags;
  private DirectorySoSource soSource;
  
  public ApplicationSoSource(Context paramContext, int paramInt)
  {
    Context localContext = paramContext.getApplicationContext();
    this.applicationContext = localContext;
    if (localContext == null)
    {
      Log.w("SoLoader", "context.getApplicationContext returned null, holding reference to original context.");
      this.applicationContext = paramContext;
    }
    this.flags = paramInt;
    this.soSource = new DirectorySoSource(new File(this.applicationContext.getApplicationInfo().nativeLibraryDir), paramInt);
  }
  
  public static File getNativeLibDirFromContext(Context paramContext)
  {
    return new File(paramContext.getApplicationInfo().nativeLibraryDir);
  }
  
  public void addToLdLibraryPath(Collection<String> paramCollection)
  {
    this.soSource.addToLdLibraryPath(paramCollection);
  }
  
  public boolean checkAndMaybeUpdate()
    throws IOException
  {
    Object localObject = this.soSource.soDirectory;
    Context localContext = getUpdatedContext();
    File localFile = getNativeLibDirFromContext(localContext);
    if (!((File)localObject).equals(localFile))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Native library directory updated from ");
      localStringBuilder.append(localObject);
      localStringBuilder.append(" to ");
      localStringBuilder.append(localFile);
      Log.d("SoLoader", localStringBuilder.toString());
      int i = this.flags | 0x1;
      this.flags = i;
      localObject = new DirectorySoSource(localFile, i);
      this.soSource = ((DirectorySoSource)localObject);
      ((DirectorySoSource)localObject).prepare(this.flags);
      this.applicationContext = localContext;
      return true;
    }
    return false;
  }
  
  @Nullable
  public String[] getLibraryDependencies(String paramString)
    throws IOException
  {
    return this.soSource.getLibraryDependencies(paramString);
  }
  
  @Nullable
  public String getLibraryPath(String paramString)
    throws IOException
  {
    return this.soSource.getLibraryPath(paramString);
  }
  
  public Context getUpdatedContext()
  {
    try
    {
      Context localContext = this.applicationContext.createPackageContext(this.applicationContext.getPackageName(), 0);
      return localContext;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      throw new RuntimeException(localNameNotFoundException);
    }
  }
  
  public int loadLibrary(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
    throws IOException
  {
    return this.soSource.loadLibrary(paramString, paramInt, paramThreadPolicy);
  }
  
  protected void prepare(int paramInt)
    throws IOException
  {
    this.soSource.prepare(paramInt);
  }
  
  public String toString()
  {
    return this.soSource.toString();
  }
  
  @Nullable
  public File unpackLibrary(String paramString)
    throws IOException
  {
    return this.soSource.unpackLibrary(paramString);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\soloader\ApplicationSoSource.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */