package com.huawei.hms.support.api.a;

import android.text.TextUtils;
import com.huawei.hms.support.api.ResolvePendingResult;
import com.huawei.hms.support.api.ResolveResult;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.InnerPendingResult;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.core.CheckConnectInfo;
import com.huawei.hms.support.api.entity.core.CheckConnectResp;
import com.huawei.hms.support.api.entity.core.ConnectInfo;
import com.huawei.hms.support.api.entity.core.ConnectResp;
import com.huawei.hms.support.api.entity.core.DisconnectInfo;
import com.huawei.hms.support.api.entity.core.DisconnectResp;
import com.huawei.hms.support.api.entity.core.JosGetNoticeReq;
import com.huawei.hms.support.api.entity.core.JosGetNoticeResp;

public final class a
{
  public static ResolvePendingResult<DisconnectResp> a(ApiClient paramApiClient, DisconnectInfo paramDisconnectInfo)
  {
    return ResolvePendingResult.build(paramApiClient, "core.disconnect", paramDisconnectInfo, DisconnectResp.class);
  }
  
  public static InnerPendingResult<ResolveResult<CheckConnectResp>> a(ApiClient paramApiClient, CheckConnectInfo paramCheckConnectInfo)
  {
    return ResolvePendingResult.build(paramApiClient, "core.checkconnect", paramCheckConnectInfo, CheckConnectResp.class);
  }
  
  public static PendingResult<ResolveResult<JosGetNoticeResp>> a(ApiClient paramApiClient, int paramInt, String paramString)
  {
    JosGetNoticeReq localJosGetNoticeReq = new JosGetNoticeReq();
    localJosGetNoticeReq.setNoticeType(paramInt);
    localJosGetNoticeReq.setHmsSdkVersionName(paramString);
    if (!TextUtils.isEmpty(paramApiClient.getCpID())) {
      localJosGetNoticeReq.setCpID(paramApiClient.getCpID());
    }
    return new c(paramApiClient, "core.getNoticeIntent", localJosGetNoticeReq);
  }
  
  public static PendingResult<ResolveResult<ConnectResp>> a(ApiClient paramApiClient, ConnectInfo paramConnectInfo)
  {
    return new b(paramApiClient, "core.connect", paramConnectInfo);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\a\a.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */