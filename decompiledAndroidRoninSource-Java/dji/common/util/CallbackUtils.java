package dji.common.util;

import dji.common.error.DJIError;
import dji.midware.data.config.P3.Ccode;
import dji.midware.interfaces.DJIDataCallBack;
import dji.sdksharedlib.hardware.abstractions.DJISDKCacheHWAbstraction.InnerCallback;
import dji.sdksharedlib.hardware.extension.DJISDKCacheCommonMergeCallback;
import dji.sdksharedlib.listener.DJIActionCallback;
import dji.sdksharedlib.listener.DJIGetCallback;
import dji.sdksharedlib.listener.DJISetCallback;

public class CallbackUtils
{
  public static DJIDataCallBack defaultCB(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    new DJIDataCallBack()
    {
      /* Error */
      public void onFailure(Ccode arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
      
      /* Error */
      public void onSuccess(Object arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  public static DJIDataCallBack defaultCB(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, final Class<? extends DJIError> paramClass)
  {
    new DJIDataCallBack()
    {
      /* Error */
      public void onFailure(Ccode arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: return
      }
      
      public void onSuccess(Object paramAnonymousObject)
      {
        CallbackUtils.onSuccess(this.val$callback, null);
      }
    };
  }
  
  public static DJIActionCallback getActionCallback(CommonCallbacks.CompletionCallback paramCompletionCallback)
  {
    new DJIActionCallback()
    {
      public void onFails(DJIError paramAnonymousDJIError)
      {
        CallbackUtils.onFailure(this.val$callback, paramAnonymousDJIError);
      }
      
      public void onSuccess()
      {
        CallbackUtils.onSuccess(this.val$callback);
      }
    };
  }
  
  public static DJIDataCallBack getDJIDataCallback(CommonCallbacks.CompletionCallback paramCompletionCallback)
  {
    new DJIDataCallBack()
    {
      public void onFailure(Ccode paramAnonymousCcode)
      {
        CallbackUtils.onFailure(this.val$callback, paramAnonymousCcode);
      }
      
      public void onSuccess(Object paramAnonymousObject)
      {
        CallbackUtils.onSuccess(this.val$callback);
      }
    };
  }
  
  public static DJISDKCacheCommonMergeCallback getFlightControllerDefaultMergeSetCallback(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    new DJISDKCacheCommonMergeCallback()
    {
      public void onFailure(DJIError paramAnonymousDJIError)
      {
        CallbackUtils.onFailure(this.val$callback, paramAnonymousDJIError);
      }
      
      public void onSuccess(Object paramAnonymousObject)
      {
        CallbackUtils.onSuccess(this.val$callback, null);
      }
    };
  }
  
  public static DJISDKCacheCommonMergeCallback getFlightControllerDetaultMergeGetCallback(Class paramClass, final DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    new DJISDKCacheCommonMergeCallback()
    {
      public void onFailure(DJIError paramAnonymousDJIError)
      {
        CallbackUtils.onFailure(paramInnerCallback, paramAnonymousDJIError);
      }
      
      /* Error */
      public void onSuccess(Object arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  public static DJIGetCallback getGetCallback(CommonCallbacks.CompletionCallbackWith paramCompletionCallbackWith)
  {
    new DJIGetCallback()
    {
      public void onFails(DJIError paramAnonymousDJIError)
      {
        CallbackUtils.onFailure(this.val$callback, paramAnonymousDJIError);
      }
      
      /* Error */
      public void onSuccess(dji.sdksharedlib.store.DJISDKCacheParamValue arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  public static DJIDataCallBack getMissionManagerDJIDataCallback(int paramInt, final CommonCallbacks.CompletionCallback paramCompletionCallback, final Runnable paramRunnable)
  {
    new DJIDataCallBack()
    {
      public void onFailure(Ccode paramAnonymousCcode)
      {
        CallbackUtils.onFailure(paramCompletionCallback, paramAnonymousCcode);
      }
      
      /* Error */
      public void onSuccess(Object arg1)
      {
        // Byte code:
        //   0: return
        //   1: astore_1
        //   2: goto -2 -> 0
      }
    };
  }
  
  public static DJISetCallback getSetCallback(CommonCallbacks.CompletionCallback paramCompletionCallback)
  {
    new DJISetCallback()
    {
      public void onFails(DJIError paramAnonymousDJIError)
      {
        CallbackUtils.onFailure(this.val$callback, paramAnonymousDJIError);
      }
      
      public void onSuccess()
      {
        CallbackUtils.onSuccess(this.val$callback);
      }
    };
  }
  
  public static DJIDataCallBack getSetterDJIDataCallback(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    new DJIDataCallBack()
    {
      public void onFailure(Ccode paramAnonymousCcode)
      {
        CallbackUtils.onFailure(this.val$callback, paramAnonymousCcode);
      }
      
      public void onSuccess(Object paramAnonymousObject)
      {
        CallbackUtils.onSuccess(this.val$callback, null);
      }
    };
  }
  
  public static void onFailure(CommonCallbacks.CompletionCallback paramCompletionCallback, DJIError paramDJIError)
  {
    if (paramCompletionCallback != null) {
      paramCompletionCallback.onResult(paramDJIError);
    }
  }
  
  public static void onFailure(CommonCallbacks.CompletionCallback paramCompletionCallback, Ccode paramCcode)
  {
    if (paramCompletionCallback != null) {
      paramCompletionCallback.onResult(DJIError.getDJIError(paramCcode));
    }
  }
  
  public static void onFailure(CommonCallbacks.CompletionCallbackWith paramCompletionCallbackWith, DJIError paramDJIError)
  {
    if (paramCompletionCallbackWith != null) {
      paramCompletionCallbackWith.onFailure(paramDJIError);
    }
  }
  
  public static void onFailure(CommonCallbacks.CompletionCallbackWith paramCompletionCallbackWith, Ccode paramCcode)
  {
    if (paramCompletionCallbackWith != null) {
      paramCompletionCallbackWith.onFailure(DJIError.getDJIError(paramCcode));
    }
  }
  
  public static void onFailure(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(null);
    }
  }
  
  public static void onFailure(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, DJIError paramDJIError)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(paramDJIError);
    }
  }
  
  public static void onFailure(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, Ccode paramCcode)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onFails(DJIError.getDJIError(paramCcode));
    }
  }
  
  public static void onResult(CommonCallbacks.CompletionCallback paramCompletionCallback, DJIError paramDJIError)
  {
    if (paramCompletionCallback != null) {
      paramCompletionCallback.onResult(paramDJIError);
    }
  }
  
  public static void onSuccess(CommonCallbacks.CompletionCallback paramCompletionCallback)
  {
    if (paramCompletionCallback != null) {
      paramCompletionCallback.onResult(null);
    }
  }
  
  public static void onSuccess(CommonCallbacks.CompletionCallbackWith paramCompletionCallbackWith, Object paramObject)
  {
    if (paramCompletionCallbackWith != null) {
      paramCompletionCallbackWith.onSuccess(paramObject);
    }
  }
  
  public static void onSuccess(DJISDKCacheHWAbstraction.InnerCallback paramInnerCallback, Object paramObject)
  {
    if (paramInnerCallback != null) {
      paramInnerCallback.onSuccess(paramObject);
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\commo\\util\CallbackUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */