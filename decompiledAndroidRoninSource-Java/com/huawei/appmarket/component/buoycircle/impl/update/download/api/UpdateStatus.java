package com.huawei.appmarket.component.buoycircle.impl.update.download.api;

public final class UpdateStatus
{
  public static final int CHECK_FAILURE = 1201;
  public static final int CHECK_NO_SUPPORTED = 1203;
  public static final int CHECK_NO_UPDATE = 1202;
  public static final int CHECK_OK = 1000;
  public static final int DOWNLOADING = 2100;
  public static final int DOWNLOAD_CANCELED = 2101;
  public static final int DOWNLOAD_FAILURE = 2201;
  public static final int DOWNLOAD_HASH_ERROR = 2202;
  public static final int DOWNLOAD_NO_SPACE = 2203;
  public static final int DOWNLOAD_NO_STORAGE = 2204;
  public static final int DOWNLOAD_SUCCESS = 2000;
  
  public static String statusToString(int paramInt)
  {
    if (paramInt != 1000)
    {
      if (paramInt != 2000)
      {
        if (paramInt != 2100)
        {
          if (paramInt != 2101)
          {
            switch (paramInt)
            {
            default: 
              switch (paramInt)
              {
              default: 
                StringBuilder localStringBuilder = new StringBuilder();
                localStringBuilder.append("UNKNOWN - ");
                localStringBuilder.append(Integer.toString(paramInt));
                return localStringBuilder.toString();
              case 2204: 
                return "DOWNLOAD_NO_STORAGE";
              case 2203: 
                return "DOWNLOAD_NO_SPACE";
              case 2202: 
                return "DOWNLOAD_HASH_ERROR";
              }
              return "DOWNLOAD_FAILURE";
            case 1203: 
              return "CHECK_NO_SUPPORTED";
            case 1202: 
              return "CHECK_NO_UPDATE";
            }
            return "CHECK_FAILURE";
          }
          return "DOWNLOAD_CANCELED";
        }
        return "DOWNLOADING";
      }
      return "DOWNLOAD_SUCCESS";
    }
    return "CHECK_OK";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\appmarket\component\buoycircle\imp\\update\download\api\UpdateStatus.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */