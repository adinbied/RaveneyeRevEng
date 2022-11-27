package org.bouncycastle.i18n;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.TimeZone;
import org.bouncycastle.i18n.filter.Filter;
import org.bouncycastle.i18n.filter.TrustedInput;
import org.bouncycastle.i18n.filter.UntrustedInput;
import org.bouncycastle.i18n.filter.UntrustedUrlInput;

public class LocalizedMessage
{
  public static final String DEFAULT_ENCODING = "ISO-8859-1";
  protected FilteredArguments arguments;
  protected String encoding = "ISO-8859-1";
  protected FilteredArguments extraArgs = null;
  protected Filter filter = null;
  protected final String id;
  protected ClassLoader loader = null;
  protected final String resource;
  
  public LocalizedMessage(String paramString1, String paramString2)
    throws NullPointerException
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      this.id = paramString2;
      this.resource = paramString1;
      this.arguments = new FilteredArguments();
      return;
    }
    throw null;
  }
  
  public LocalizedMessage(String paramString1, String paramString2, String paramString3)
    throws NullPointerException, UnsupportedEncodingException
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      this.id = paramString2;
      this.resource = paramString1;
      this.arguments = new FilteredArguments();
      if (Charset.isSupported(paramString3))
      {
        this.encoding = paramString3;
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("The encoding \"");
      paramString1.append(paramString3);
      paramString1.append("\" is not supported.");
      throw new UnsupportedEncodingException(paramString1.toString());
    }
    throw null;
  }
  
  public LocalizedMessage(String paramString1, String paramString2, String paramString3, Object[] paramArrayOfObject)
    throws NullPointerException, UnsupportedEncodingException
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramArrayOfObject != null))
    {
      this.id = paramString2;
      this.resource = paramString1;
      this.arguments = new FilteredArguments(paramArrayOfObject);
      if (Charset.isSupported(paramString3))
      {
        this.encoding = paramString3;
        return;
      }
      paramString1 = new StringBuilder();
      paramString1.append("The encoding \"");
      paramString1.append(paramString3);
      paramString1.append("\" is not supported.");
      throw new UnsupportedEncodingException(paramString1.toString());
    }
    throw null;
  }
  
  public LocalizedMessage(String paramString1, String paramString2, Object[] paramArrayOfObject)
    throws NullPointerException
  {
    if ((paramString1 != null) && (paramString2 != null) && (paramArrayOfObject != null))
    {
      this.id = paramString2;
      this.resource = paramString1;
      this.arguments = new FilteredArguments(paramArrayOfObject);
      return;
    }
    throw null;
  }
  
  protected String addExtraArgs(String paramString, Locale paramLocale)
  {
    String str = paramString;
    if (this.extraArgs != null)
    {
      paramString = new StringBuffer(paramString);
      paramLocale = this.extraArgs.getFilteredArgs(paramLocale);
      int i = 0;
      while (i < paramLocale.length)
      {
        paramString.append(paramLocale[i]);
        i += 1;
      }
      str = paramString.toString();
    }
    return str;
  }
  
  protected String formatWithTimeZone(String paramString, Object[] paramArrayOfObject, Locale paramLocale, TimeZone paramTimeZone)
  {
    MessageFormat localMessageFormat = new MessageFormat(" ");
    localMessageFormat.setLocale(paramLocale);
    localMessageFormat.applyPattern(paramString);
    if (!paramTimeZone.equals(TimeZone.getDefault()))
    {
      paramString = localMessageFormat.getFormats();
      int i = 0;
      while (i < paramString.length)
      {
        if ((paramString[i] instanceof DateFormat))
        {
          paramLocale = (DateFormat)paramString[i];
          paramLocale.setTimeZone(paramTimeZone);
          localMessageFormat.setFormat(i, paramLocale);
        }
        i += 1;
      }
    }
    return localMessageFormat.format(paramArrayOfObject);
  }
  
  public Object[] getArguments()
  {
    return this.arguments.getArguments();
  }
  
  public ClassLoader getClassLoader()
  {
    return this.loader;
  }
  
  public String getEntry(String paramString, Locale paramLocale, TimeZone paramTimeZone)
    throws MissingEntryException
  {
    String str = this.id;
    Object localObject = str;
    if (paramString != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(".");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
    }
    try
    {
      if (this.loader == null) {
        paramString = ResourceBundle.getBundle(this.resource, paramLocale);
      } else {
        paramString = ResourceBundle.getBundle(this.resource, paramLocale, this.loader);
      }
      str = paramString.getString((String)localObject);
      paramString = str;
      if (!this.encoding.equals("ISO-8859-1")) {
        paramString = new String(str.getBytes("ISO-8859-1"), this.encoding);
      }
      str = paramString;
      if (!this.arguments.isEmpty()) {
        str = formatWithTimeZone(paramString, this.arguments.getFilteredArgs(paramLocale), paramLocale, paramTimeZone);
      }
      paramString = addExtraArgs(str, paramLocale);
      return paramString;
    }
    catch (UnsupportedEncodingException paramString)
    {
      throw new RuntimeException(paramString);
      paramString = new StringBuilder();
      paramString.append("Can't find entry ");
      paramString.append((String)localObject);
      paramString.append(" in resource file ");
      paramString.append(this.resource);
      paramString.append(".");
      paramTimeZone = paramString.toString();
      str = this.resource;
      paramString = this.loader;
      if (paramString == null) {
        paramString = getClassLoader();
      }
      throw new MissingEntryException(paramTimeZone, str, (String)localObject, paramLocale, paramString);
    }
    catch (MissingResourceException paramString)
    {
      for (;;) {}
    }
  }
  
  public Object[] getExtraArgs()
  {
    FilteredArguments localFilteredArguments = this.extraArgs;
    if (localFilteredArguments == null) {
      return null;
    }
    return localFilteredArguments.getArguments();
  }
  
  public Filter getFilter()
  {
    return this.filter;
  }
  
  public String getId()
  {
    return this.id;
  }
  
  public String getResource()
  {
    return this.resource;
  }
  
  public void setClassLoader(ClassLoader paramClassLoader)
  {
    this.loader = paramClassLoader;
  }
  
  public void setExtraArgument(Object paramObject)
  {
    setExtraArguments(new Object[] { paramObject });
  }
  
  public void setExtraArguments(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject != null)
    {
      paramArrayOfObject = new FilteredArguments(paramArrayOfObject);
      this.extraArgs = paramArrayOfObject;
      paramArrayOfObject.setFilter(this.filter);
      return;
    }
    this.extraArgs = null;
  }
  
  public void setFilter(Filter paramFilter)
  {
    this.arguments.setFilter(paramFilter);
    FilteredArguments localFilteredArguments = this.extraArgs;
    if (localFilteredArguments != null) {
      localFilteredArguments.setFilter(paramFilter);
    }
    this.filter = paramFilter;
  }
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("Resource: \"");
    localStringBuffer.append(this.resource);
    localStringBuffer.append("\" Id: \"");
    localStringBuffer.append(this.id);
    localStringBuffer.append("\"");
    localStringBuffer.append(" Arguments: ");
    localStringBuffer.append(this.arguments.getArguments().length);
    localStringBuffer.append(" normal");
    FilteredArguments localFilteredArguments = this.extraArgs;
    if ((localFilteredArguments != null) && (localFilteredArguments.getArguments().length > 0))
    {
      localStringBuffer.append(", ");
      localStringBuffer.append(this.extraArgs.getArguments().length);
      localStringBuffer.append(" extra");
    }
    localStringBuffer.append(" Encoding: ");
    localStringBuffer.append(this.encoding);
    localStringBuffer.append(" ClassLoader: ");
    localStringBuffer.append(this.loader);
    return localStringBuffer.toString();
  }
  
  protected class FilteredArguments
  {
    protected static final int FILTER = 1;
    protected static final int FILTER_URL = 2;
    protected static final int NO_FILTER = 0;
    protected int[] argFilterType;
    protected Object[] arguments;
    protected Filter filter = null;
    protected Object[] filteredArgs;
    protected boolean[] isLocaleSpecific;
    protected Object[] unpackedArgs;
    
    FilteredArguments()
    {
      this(new Object[0]);
    }
    
    FilteredArguments(Object[] paramArrayOfObject)
    {
      this.arguments = paramArrayOfObject;
      this.unpackedArgs = new Object[paramArrayOfObject.length];
      this.filteredArgs = new Object[paramArrayOfObject.length];
      this.isLocaleSpecific = new boolean[paramArrayOfObject.length];
      this.argFilterType = new int[paramArrayOfObject.length];
      int i = 0;
      while (i < paramArrayOfObject.length)
      {
        if ((paramArrayOfObject[i] instanceof TrustedInput))
        {
          this.unpackedArgs[i] = ((TrustedInput)paramArrayOfObject[i]).getInput();
          this.argFilterType[i] = 0;
        }
        else if ((paramArrayOfObject[i] instanceof UntrustedInput))
        {
          this.unpackedArgs[i] = ((UntrustedInput)paramArrayOfObject[i]).getInput();
          if ((paramArrayOfObject[i] instanceof UntrustedUrlInput)) {
            this.argFilterType[i] = 2;
          } else {
            this.argFilterType[i] = 1;
          }
        }
        else
        {
          this.unpackedArgs[i] = paramArrayOfObject[i];
          this.argFilterType[i] = 1;
        }
        this.isLocaleSpecific[i] = (this.unpackedArgs[i] instanceof LocaleString);
        i += 1;
      }
    }
    
    private Object filter(int paramInt, Object paramObject)
    {
      Object localObject2 = paramObject;
      if (this.filter != null)
      {
        Object localObject1 = paramObject;
        if (paramObject == null) {
          localObject1 = "null";
        }
        localObject2 = localObject1;
        if (paramInt != 0)
        {
          if (paramInt != 1)
          {
            if (paramInt != 2) {
              return null;
            }
            return this.filter.doFilterUrl(localObject1.toString());
          }
          return this.filter.doFilter(localObject1.toString());
        }
      }
      return localObject2;
    }
    
    public Object[] getArguments()
    {
      return this.arguments;
    }
    
    public Filter getFilter()
    {
      return this.filter;
    }
    
    public Object[] getFilteredArgs(Locale paramLocale)
    {
      Object[] arrayOfObject1 = new Object[this.unpackedArgs.length];
      int i = 0;
      for (;;)
      {
        Object localObject = this.unpackedArgs;
        if (i >= localObject.length) {
          break;
        }
        Object[] arrayOfObject2 = this.filteredArgs;
        if (arrayOfObject2[i] != null)
        {
          localObject = arrayOfObject2[i];
        }
        else
        {
          localObject = localObject[i];
          if (this.isLocaleSpecific[i] != 0)
          {
            localObject = ((LocaleString)localObject).getLocaleString(paramLocale);
            localObject = filter(this.argFilterType[i], localObject);
          }
          else
          {
            localObject = filter(this.argFilterType[i], localObject);
            this.filteredArgs[i] = localObject;
          }
        }
        arrayOfObject1[i] = localObject;
        i += 1;
      }
      return arrayOfObject1;
    }
    
    public boolean isEmpty()
    {
      return this.unpackedArgs.length == 0;
    }
    
    public void setFilter(Filter paramFilter)
    {
      if (paramFilter != this.filter)
      {
        int i = 0;
        while (i < this.unpackedArgs.length)
        {
          this.filteredArgs[i] = null;
          i += 1;
        }
      }
      this.filter = paramFilter;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x8af8f000-dex2jar.jar!\org\bouncycastle\i18n\LocalizedMessage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */