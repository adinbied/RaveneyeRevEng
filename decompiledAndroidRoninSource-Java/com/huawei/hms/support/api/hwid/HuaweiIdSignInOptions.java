package com.huawei.hms.support.api.hwid;

import com.huawei.hms.api.Api.ApiOptions.HasOptions;
import com.huawei.hms.support.api.entity.auth.PermissionInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HuaweiIdSignInOptions
  implements Api.ApiOptions.HasOptions
{
  public static final HuaweiIdSignInOptions DEFAULT_SIGN_IN = new Builder().requestScopes(new Scope("https://www.huawei.com/auth/account/base.profile"), new Scope[0]).requestOpenId().requestUnionId().build();
  private static final PermissionInfo a = new PermissionInfo().setPermissionUri("com.huawei.android.hms.account.getUID");
  private static final PermissionInfo b = new PermissionInfo().setPermissionUri("com.huawei.android.hms.account.getOpenID");
  private static final PermissionInfo c = new PermissionInfo().setPermissionUri("com.huawei.android.hms.account.getUnionId");
  private final ArrayList<Scope> d;
  private ArrayList<PermissionInfo> e;
  
  public HuaweiIdSignInOptions(ArrayList<Scope> paramArrayList, ArrayList<PermissionInfo> paramArrayList1)
  {
    this.d = paramArrayList;
    this.e = paramArrayList1;
  }
  
  public HuaweiIdSignInOptions(Set<Scope> paramSet, Set<PermissionInfo> paramSet1)
  {
    this(new ArrayList(paramSet), new ArrayList(paramSet1));
  }
  
  public List<PermissionInfo> getPermissionInfos()
  {
    return this.e;
  }
  
  public List<Scope> getScopeList()
  {
    return this.d;
  }
  
  public static final class Builder
  {
    private Set<Scope> a = new HashSet();
    private Set<PermissionInfo> b = new HashSet();
    
    public Builder() {}
    
    public Builder(HuaweiIdSignInOptions paramHuaweiIdSignInOptions)
    {
      this.a.addAll(paramHuaweiIdSignInOptions.getScopeList());
      this.b.addAll(paramHuaweiIdSignInOptions.getPermissionInfos());
    }
    
    public HuaweiIdSignInOptions build()
    {
      return null;
    }
    
    public Builder requestAccessToken()
    {
      return null;
    }
    
    public Builder requestOpenId()
    {
      return null;
    }
    
    public Builder requestScopes(Scope paramScope, Scope... paramVarArgs)
    {
      return null;
    }
    
    public Builder requestServerAuthCode()
    {
      return null;
    }
    
    public Builder requestUid()
    {
      return null;
    }
    
    public Builder requestUnionId()
    {
      return null;
    }
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\hwid\HuaweiIdSignInOptions.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */