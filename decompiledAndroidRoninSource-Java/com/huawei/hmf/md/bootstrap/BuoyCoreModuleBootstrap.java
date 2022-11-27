package com.huawei.hmf.md.bootstrap;

import com.huawei.appmarket.component.buoycircle.BuoyCircleModule;
import com.huawei.appmarket.component.buoycircle.impl.manager.BuoyCircleManager;
import com.huawei.hmf.repository.Repository;
import com.huawei.hmf.services.ApiSet;
import com.huawei.hmf.services.ApiSet.Builder;
import com.huawei.hmf.services.ModuleProviderWrapper;

public final class BuoyCoreModuleBootstrap
{
  public static final String name()
  {
    return "BuoyCore";
  }
  
  public static final void register(Repository paramRepository)
  {
    Object localObject = ApiSet.builder();
    ((ApiSet.Builder)localObject).add(BuoyCircleManager.class);
    localObject = ((ApiSet.Builder)localObject).build();
    new ModuleProviderWrapper(new BuoyCircleModule()).bootstrap(paramRepository, name(), (ApiSet)localObject);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hmf\md\bootstrap\BuoyCoreModuleBootstrap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */