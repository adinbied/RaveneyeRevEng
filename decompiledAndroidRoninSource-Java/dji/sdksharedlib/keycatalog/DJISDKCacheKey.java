package dji.sdksharedlib.keycatalog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class DJISDKCacheKey
{
  private static final int DEFAULT_INDEX = DJISDKCacheKeyIndexType.Default.value;
  private static final String DEFAULT_STRING = null;
  private static Map<String, DJISDKCacheKey> keysCacheMap = new ConcurrentHashMap();
  private final String component;
  private final int index;
  private boolean isValid;
  private final String paramKey;
  private final String path;
  private final String pathWithoutParamKey;
  private final int subCompIndex;
  private final String subComponent;
  
  private DJISDKCacheKey(Builder paramBuilder)
  {
    if (validatePath(paramBuilder.path))
    {
      this.component = componentInPath(paramBuilder.path);
      this.index = indexInPath(paramBuilder.path);
      this.subComponent = subComponentInPath(paramBuilder.path);
      this.subCompIndex = subCompIndexInPath(paramBuilder.path);
      paramBuilder = paramKeyInPath(paramBuilder.path);
      this.paramKey = paramBuilder;
      this.path = producePathFromElements(this.component, this.index, this.subComponent, this.subCompIndex, paramBuilder);
      this.pathWithoutParamKey = producePathFromElements(this.component, this.index, this.subComponent, this.subCompIndex, "");
    }
    else
    {
      this.component = paramBuilder.component;
      this.index = paramBuilder.index;
      this.subComponent = paramBuilder.subComponent;
      this.subCompIndex = paramBuilder.subCompIndex;
      paramBuilder = paramBuilder.paramKey;
      this.paramKey = paramBuilder;
      this.path = producePathFromElements(this.component, this.index, this.subComponent, this.subCompIndex, paramBuilder);
      this.pathWithoutParamKey = producePathFromElements(this.component, this.index, this.subComponent, this.subCompIndex, "");
    }
    this.isValid = validatePath(this.path);
  }
  
  private static String componentInPath(String paramString)
  {
    paramString = keyPathSplitHelper(paramString);
    if (paramString.length > 0) {
      return paramString[0];
    }
    return null;
  }
  
  private static String componentIndexString(int paramInt)
  {
    if (paramInt == Integer.MAX_VALUE) {
      return "*";
    }
    return Integer.toString(paramInt);
  }
  
  public static DJISDKCacheKey getCache(String paramString)
  {
    if ((paramString != null) && (keysCacheMap.containsKey(paramString))) {
      return (DJISDKCacheKey)keysCacheMap.get(paramString);
    }
    return null;
  }
  
  private static int indexInPath(String paramString)
  {
    paramString = keyPathSplitHelper(paramString);
    if ((paramString.length > 1) && (paramString[1].matches("\\d+"))) {
      return Integer.parseInt(paramString[1]);
    }
    if (paramString[1].equals("*")) {
      return Integer.MAX_VALUE;
    }
    return 0;
  }
  
  private static String[] keyPathSplitHelper(String paramString)
  {
    return paramString.split("/");
  }
  
  private static String paramKeyInPath(String paramString)
  {
    paramString = keyPathSplitHelper(paramString);
    if (paramString.length > 1) {
      return paramString[(paramString.length - 1)];
    }
    return null;
  }
  
  public static String produceKeyForComponent(String paramString1, int paramInt, String paramString2)
  {
    return produceKeyForComponent(paramString1, paramInt, null, 0, paramString2);
  }
  
  private static String produceKeyForComponent(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    return producePathFromElements(paramString1, paramInt1, paramString2, paramInt2, paramString3);
  }
  
  private static String producePathFromElements(String paramString1, int paramInt1, String paramString2, int paramInt2, String paramString3)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramInt1 == 0) && (paramString2 == null))
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/0/");
      localStringBuilder.append(paramString3);
    }
    else if (paramString2 == null)
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/");
      localStringBuilder.append(componentIndexString(paramInt1));
      localStringBuilder.append("/");
      localStringBuilder.append(paramString3);
    }
    else if (paramInt2 == 0)
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/");
      localStringBuilder.append(componentIndexString(paramInt1));
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("/0/");
      localStringBuilder.append(paramString3);
    }
    else
    {
      localStringBuilder.append(paramString1);
      localStringBuilder.append("/");
      localStringBuilder.append(componentIndexString(paramInt1));
      localStringBuilder.append("/");
      localStringBuilder.append(paramString2);
      localStringBuilder.append("/");
      localStringBuilder.append(subComponentIndexString(paramInt2));
      localStringBuilder.append("/");
      localStringBuilder.append(paramString3);
    }
    return localStringBuilder.toString();
  }
  
  private static void putCache(String paramString, DJISDKCacheKey paramDJISDKCacheKey)
  {
    if ((paramString != null) && (paramDJISDKCacheKey != null) && (!keysCacheMap.containsKey(paramString))) {
      keysCacheMap.put(paramString, paramDJISDKCacheKey);
    }
  }
  
  private static int subCompIndexInPath(String paramString)
  {
    paramString = keyPathSplitHelper(paramString);
    if ((paramString.length > 3) && (paramString[3].matches("\\d+"))) {
      return Integer.parseInt(paramString[3]);
    }
    return 0;
  }
  
  private static String subComponentInPath(String paramString)
  {
    paramString = keyPathSplitHelper(paramString);
    if (paramString.length > 3) {
      return paramString[2];
    }
    return null;
  }
  
  private static String subComponentIndexString(int paramInt)
  {
    return componentIndexString(paramInt);
  }
  
  public static boolean validatePath(String paramString)
  {
    if ((paramString != null) && (paramString.length() != 0)) {
      return paramString.matches("^\\w+[/](\\d+|\\*)[/]\\w+([/](\\d+)[/]\\w+)?$");
    }
    return false;
  }
  
  public DJISDKCacheKey clone(String paramString)
  {
    return null;
  }
  
  public boolean equals(Object paramObject)
  {
    return false;
  }
  
  public DJISDKCacheKey extractSubComponentKeyPath()
  {
    return null;
  }
  
  public String getComponent()
  {
    return this.component;
  }
  
  public int getIndex()
  {
    return this.index;
  }
  
  public String getParamKey()
  {
    return this.paramKey;
  }
  
  public String getPath()
  {
    return this.path;
  }
  
  public String getSubComponent()
  {
    return this.subComponent;
  }
  
  public int getSubComponentIndex()
  {
    return this.subCompIndex;
  }
  
  public int hashCode()
  {
    return 0;
  }
  
  public boolean isPathEmpty()
  {
    return false;
  }
  
  public boolean isValid()
  {
    return this.isValid;
  }
  
  public String toString()
  {
    String str2 = this.path;
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    return str1;
  }
  
  public static final class Builder
  {
    private String component;
    private int index = DJISDKCacheKey.DEFAULT_INDEX;
    private String paramKey;
    private String path = DJISDKCacheKey.DEFAULT_STRING;
    private int subCompIndex = DJISDKCacheKey.DEFAULT_INDEX;
    private String subComponent = DJISDKCacheKey.DEFAULT_STRING;
    
    public DJISDKCacheKey build()
    {
      return null;
    }
    
    public Builder component(String paramString)
    {
      this.component = paramString;
      return this;
    }
    
    public Builder index(int paramInt)
    {
      this.index = paramInt;
      return this;
    }
    
    public Builder paramKey(String paramString)
    {
      this.paramKey = paramString;
      return this;
    }
    
    public Builder path(String paramString)
    {
      return null;
    }
    
    public Builder subComponent(String paramString)
    {
      this.subComponent = paramString;
      return this;
    }
    
    public Builder subComponentIndex(int paramInt)
    {
      this.subCompIndex = paramInt;
      return this;
    }
  }
  
  public static enum DJISDKCacheKeyIndexType
  {
    private int value;
    
    static
    {
      DJISDKCacheKeyIndexType localDJISDKCacheKeyIndexType = new DJISDKCacheKeyIndexType("All", 1, Integer.MAX_VALUE);
      All = localDJISDKCacheKeyIndexType;
      $VALUES = new DJISDKCacheKeyIndexType[] { Default, localDJISDKCacheKeyIndexType };
    }
    
    private DJISDKCacheKeyIndexType(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\sdksharedlib\keycatalog\DJISDKCacheKey.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */