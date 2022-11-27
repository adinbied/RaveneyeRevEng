package com.huawei.android.hms.agent.common;

public final class StrUtils
{
  public static String objDesc(Object paramObject)
  {
    if (paramObject == null) {
      return "null";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramObject.getClass().getName());
    localStringBuilder.append('@');
    localStringBuilder.append(Integer.toHexString(paramObject.hashCode()));
    return localStringBuilder.toString();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\android\hms\agent\common\StrUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */