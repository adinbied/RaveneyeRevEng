package com.huawei.hms.support.api.pay;

import android.content.Intent;
import com.huawei.hms.api.HuaweiApiClient;
import com.huawei.hms.core.aidl.IMessageEntity;
import com.huawei.hms.support.api.c;
import com.huawei.hms.support.api.client.ApiClient;
import com.huawei.hms.support.api.client.PendingResult;
import com.huawei.hms.support.api.entity.pay.HwWalletInfoRequest;
import com.huawei.hms.support.api.entity.pay.HwWalletInoResp;
import com.huawei.hms.support.api.entity.pay.InternalPayRequest;
import com.huawei.hms.support.api.entity.pay.OrderRequest;
import com.huawei.hms.support.api.entity.pay.OrderResp;
import com.huawei.hms.support.api.entity.pay.PayReq;
import com.huawei.hms.support.api.entity.pay.PayResp;
import com.huawei.hms.support.api.entity.pay.ProductDetailRequest;
import com.huawei.hms.support.api.entity.pay.ProductDetailResp;
import com.huawei.hms.support.api.entity.pay.ProductPayRequest;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoRequest;
import com.huawei.hms.support.api.entity.pay.PurchaseInfoResp;
import com.huawei.hms.support.api.entity.pay.WalletIntentResp;
import com.huawei.hms.support.api.entity.pay.WalletUiIntentReq;
import com.huawei.hms.support.api.entity.pay.WithholdRequest;

public class HuaweiPayApiImpl
  implements HuaweiPayApi
{
  private static c<GetWalletUiIntentResult, WalletIntentResp> a(HuaweiApiClient paramHuaweiApiClient, WalletUiIntentReq paramWalletUiIntentReq)
  {
    return new a(paramHuaweiApiClient, "pay.getwalletintent", paramWalletUiIntentReq);
  }
  
  public PendingResult<PayResult> addWithholdingPlan(HuaweiApiClient paramHuaweiApiClient, WithholdRequest paramWithholdRequest)
  {
    return null;
  }
  
  public PendingResult<OrderResult> getOrderDetail(HuaweiApiClient paramHuaweiApiClient, OrderRequest paramOrderRequest)
  {
    return null;
  }
  
  public PayResultInfo getPayResultInfoFromIntent(Intent paramIntent)
  {
    return null;
  }
  
  public PendingResult<ProductDetailResult> getProductDetails(HuaweiApiClient paramHuaweiApiClient, ProductDetailRequest paramProductDetailRequest)
  {
    return null;
  }
  
  public ProductPayResultInfo getProductPayResultFromIntent(Intent paramIntent)
  {
    return null;
  }
  
  public PendingResult<PurchaseInfoResult> getPurchaseInfo(HuaweiApiClient paramHuaweiApiClient, PurchaseInfoRequest paramPurchaseInfoRequest)
  {
    return null;
  }
  
  public PendingResult<GetWalletUiIntentResult> getWalletUiIntent(HuaweiApiClient paramHuaweiApiClient, int paramInt)
  {
    return null;
  }
  
  public PendingResult<PayResult> internalPay(HuaweiApiClient paramHuaweiApiClient, InternalPayRequest paramInternalPayRequest)
  {
    return null;
  }
  
  public PendingResult<PayResult> pay(HuaweiApiClient paramHuaweiApiClient, PayReq paramPayReq)
  {
    return null;
  }
  
  public PendingResult<PayResult> productPay(HuaweiApiClient paramHuaweiApiClient, ProductPayRequest paramProductPayRequest)
  {
    return null;
  }
  
  public PendingResult<HwWalletInfoResult> queryWalletInfo(HuaweiApiClient paramHuaweiApiClient, HwWalletInfoRequest paramHwWalletInfoRequest)
  {
    return null;
  }
  
  private static class a
    extends c<OrderResult, OrderResp>
  {
    public a(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public OrderResult a(OrderResp paramOrderResp)
    {
      return null;
    }
  }
  
  private static class b
    extends com.huawei.hms.support.api.a<PurchaseInfoResult>
  {
    public b(int paramInt)
    {
      super();
    }
  }
  
  private static class c
    extends c<PurchaseInfoResult, PurchaseInfoResp>
  {
    public c(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public PurchaseInfoResult a(PurchaseInfoResp paramPurchaseInfoResp)
    {
      return null;
    }
  }
  
  private static class d
    extends com.huawei.hms.support.api.a<GetWalletUiIntentResult>
  {
    public d(int paramInt)
    {
      super();
    }
  }
  
  private static class e
    extends com.huawei.hms.support.api.a<PayResult>
  {
    public e(int paramInt)
    {
      super();
    }
  }
  
  private static class f
    extends c<PayResult, PayResp>
  {
    public f(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public PayResult a(PayResp paramPayResp)
    {
      return null;
    }
  }
  
  private static class g
    extends c<ProductDetailResult, ProductDetailResp>
  {
    public g(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public ProductDetailResult a(ProductDetailResp paramProductDetailResp)
    {
      return null;
    }
  }
  
  private static class h
    extends com.huawei.hms.support.api.a<HwWalletInfoResult>
  {
    public h(int paramInt)
    {
      super();
    }
  }
  
  private static class i
    extends c<HwWalletInfoResult, HwWalletInoResp>
  {
    public i(ApiClient paramApiClient, String paramString, IMessageEntity paramIMessageEntity)
    {
      super(paramString, paramIMessageEntity);
    }
    
    public HwWalletInfoResult a(HwWalletInoResp paramHwWalletInoResp)
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\pay\HuaweiPayApiImpl.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */