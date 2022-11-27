package com.huawei.hms.update.a.a;

public final class d
{
  public static String a(int paramInt)
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


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hm\\update\a\a\d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */