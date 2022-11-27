package org.bouncycastle.i18n;

import java.net.URLClassLoader;
import java.util.Locale;

public class MissingEntryException
  extends RuntimeException
{
  private String debugMsg;
  protected final String key;
  protected final ClassLoader loader;
  protected final Locale locale;
  protected final String resource;
  
  public MissingEntryException(String paramString1, String paramString2, String paramString3, Locale paramLocale, ClassLoader paramClassLoader)
  {
    super(paramString1);
    this.resource = paramString2;
    this.key = paramString3;
    this.locale = paramLocale;
    this.loader = paramClassLoader;
  }
  
  public MissingEntryException(String paramString1, Throwable paramThrowable, String paramString2, String paramString3, Locale paramLocale, ClassLoader paramClassLoader)
  {
    super(paramString1, paramThrowable);
    this.resource = paramString2;
    this.key = paramString3;
    this.locale = paramLocale;
    this.loader = paramClassLoader;
  }
  
  public ClassLoader getClassLoader()
  {
    return this.loader;
  }
  
  public String getDebugMsg()
  {
    if (this.debugMsg == null)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Can not find entry ");
      ((StringBuilder)localObject).append(this.key);
      ((StringBuilder)localObject).append(" in resource file ");
      ((StringBuilder)localObject).append(this.resource);
      ((StringBuilder)localObject).append(" for the locale ");
      ((StringBuilder)localObject).append(this.locale);
      ((StringBuilder)localObject).append(".");
      this.debugMsg = ((StringBuilder)localObject).toString();
      localObject = this.loader;
      if ((localObject instanceof URLClassLoader))
      {
        localObject = ((URLClassLoader)localObject).getURLs();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(this.debugMsg);
        localStringBuilder.append(" The following entries in the classpath were searched: ");
        this.debugMsg = localStringBuilder.toString();
        int i = 0;
        while (i != localObject.length)
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.debugMsg);
          localStringBuilder.append(localObject[i]);
          localStringBuilder.append(" ");
          this.debugMsg = localStringBuilder.toString();
          i += 1;
        }
      }
    }
    return this.debugMsg;
  }
  
  public String getKey()
  {
    return this.key;
  }
  
  public Locale getLocale()
  {
    return this.locale;
  }
  
  public String getResource()
  {
    return this.resource;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\i18n\MissingEntryException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */