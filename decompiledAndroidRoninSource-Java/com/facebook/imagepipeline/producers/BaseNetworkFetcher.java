package com.facebook.imagepipeline.producers;

import java.util.Map;
import javax.annotation.Nullable;

public abstract class BaseNetworkFetcher<FETCH_STATE extends FetchState>
  implements NetworkFetcher<FETCH_STATE>
{
  @Nullable
  public Map<String, String> getExtraMap(FETCH_STATE paramFETCH_STATE, int paramInt)
  {
    return null;
  }
  
  public void onFetchCompletion(FETCH_STATE paramFETCH_STATE, int paramInt) {}
  
  public boolean shouldPropagate(FETCH_STATE paramFETCH_STATE)
  {
    return true;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\facebook\imagepipeline\producers\BaseNetworkFetcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */