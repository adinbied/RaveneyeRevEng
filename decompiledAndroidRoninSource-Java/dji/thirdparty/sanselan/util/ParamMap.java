package dji.thirdparty.sanselan.util;

import java.util.Map;

public class ParamMap
{
  public static boolean getParamBoolean(Map paramMap, Object paramObject, boolean paramBoolean)
  {
    if (paramMap == null) {
      paramMap = null;
    } else {
      paramMap = paramMap.get(paramObject);
    }
    boolean bool = paramBoolean;
    if (paramMap != null)
    {
      bool = paramBoolean;
      if ((paramMap instanceof Boolean)) {
        bool = ((Boolean)paramMap).booleanValue();
      }
    }
    return bool;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\sansela\\util\ParamMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */