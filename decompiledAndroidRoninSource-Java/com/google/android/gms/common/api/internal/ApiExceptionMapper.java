package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.ApiExceptionUtil;

public class ApiExceptionMapper
  implements StatusExceptionMapper
{
  public Exception getException(Status paramStatus)
  {
    return ApiExceptionUtil.fromStatus(paramStatus);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\api\internal\ApiExceptionMapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */