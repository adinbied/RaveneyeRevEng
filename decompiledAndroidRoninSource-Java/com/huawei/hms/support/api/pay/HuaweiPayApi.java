package com.huawei.hms.support.api.pay;

import android.content.Intent;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.pay.HwWalletInfoRequest;
import com.huawei.hms.support.api.entity.pay.InternalPayRequest;
import com.huawei.hms.support.api.entity.pay.OrderRequest;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hms.support.api.entity.pay.ProductDetailRequest;
import com.huawei.hms.support.api.entity.pay.ProductPayRequest;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoRequest;
import com.huawei.hms.support.api.entity.pay.WithholdRequest;

public abstract interface HuaweiPayApi
{
  public abstract PendingResult<PayResult> addWithholdingPlan(HuaweiApiClient paramHuaweiApiClient, WithholdRequest paramWithholdRequest);
  
  public abstract PendingResult<OrderResult> getOrderDetail(HuaweiApiClient paramHuaweiApiClient, OrderRequest paramOrderRequest);
  
  public abstract PayResultInfo getPayResultInfoFromIntent(Intent paramIntent);
  
  public abstract PendingResult<ProductDetailResult> getProductDetails(HuaweiApiClient paramHuaweiApiClient, ProductDetailRequest paramProductDetailRequest);
  
  public abstract ProductPayResultInfo getProductPayResultFromIntent(Intent paramIntent);
  
  public abstract PendingResult<PurchaseInfoResult> getPurchaseInfo(HuaweiApiClient paramHuaweiApiClient, PurchaseInfoRequest paramPurchaseInfoRequest);
  
  public abstract PendingResult<GetWalletUiIntentResult> getWalletUiIntent(HuaweiApiClient paramHuaweiApiClient, int paramInt);
  
  public abstract PendingResult<PayResult> internalPay(HuaweiApiClient paramHuaweiApiClient, InternalPayRequest paramInternalPayRequest);
  
  public abstract PendingResult<PayResult> pay(HuaweiApiClient paramHuaweiApiClient, PayReq paramPayReq);
  
  public abstract PendingResult<PayResult> productPay(HuaweiApiClient paramHuaweiApiClient, ProductPayRequest paramProductPayRequest);
  
  public abstract PendingResult<HwWalletInfoResult> queryWalletInfo(HuaweiApiClient paramHuaweiApiClient, HwWalletInfoRequest paramHwWalletInfoRequest);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\pay\HuaweiPayApi.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */