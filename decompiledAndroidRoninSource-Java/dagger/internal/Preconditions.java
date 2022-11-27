package dagger.internal;

public final class Preconditions
{
  public static <T> void checkBuilderRequirement(T paramT, Class<T> paramClass)
  {
    if (paramT != null) {
      return;
    }
    paramT = new StringBuilder();
    paramT.append(paramClass.getCanonicalName());
    paramT.append(" must be set");
    throw new IllegalStateException(paramT.toString());
  }
  
  public static <T> T checkNotNull(T paramT)
  {
    if (paramT != null) {
      return paramT;
    }
    throw null;
  }
  
  public static <T> T checkNotNull(T paramT, String paramString)
  {
    if (paramT != null) {
      return paramT;
    }
    throw new NullPointerException(paramString);
  }
  
  public static <T> T checkNotNull(T paramT, String paramString, Object paramObject)
  {
    if (paramT == null)
    {
      if (paramString.contains("%s"))
      {
        if (paramString.indexOf("%s") == paramString.lastIndexOf("%s"))
        {
          if ((paramObject instanceof Class)) {
            paramT = ((Class)paramObject).getCanonicalName();
          } else {
            paramT = String.valueOf(paramObject);
          }
          throw new NullPointerException(paramString.replace("%s", paramT));
        }
        throw new IllegalArgumentException("errorMessageTemplate has more than one format specifier");
      }
      throw new IllegalArgumentException("errorMessageTemplate has no format specifiers");
    }
    return paramT;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dagger\internal\Preconditions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */