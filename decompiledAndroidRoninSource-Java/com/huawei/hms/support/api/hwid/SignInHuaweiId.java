package com.huawei.hms.support.api.hwid;

import com.huawei.hms.support.api.entity.auth.Scope;
import java.util.Set;

public class SignInHuaweiId
{
  private String a;
  private String b;
  private String c;
  private String d;
  private String e;
  private int f;
  private int g;
  private String h;
  private String i;
  private Set<Scope> j;
  private String k;
  private String l;
  
  SignInHuaweiId(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, Set<Scope> paramSet, String paramString7, String paramString8, String paramString9)
  {
    this.b = paramString1;
    this.a = paramString2;
    this.c = paramString3;
    this.d = paramString4;
    this.e = paramString5;
    this.h = paramString6;
    this.f = paramInt1;
    this.g = paramInt2;
    this.j = paramSet;
    this.k = paramString7;
    this.l = paramString8;
    this.i = paramString9;
  }
  
  public static SignInHuaweiId build(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, int paramInt1, int paramInt2, Set<Scope> paramSet, String paramString7, String paramString8, String paramString9)
  {
    return new SignInHuaweiId(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6, paramInt1, paramInt2, paramSet, paramString7, paramString8, paramString9);
  }
  
  public String getAccessToken()
  {
    return this.e;
  }
  
  public String getCountryCode()
  {
    return this.i;
  }
  
  public String getDisplayName()
  {
    return this.c;
  }
  
  public int getGender()
  {
    return this.g;
  }
  
  public Set<Scope> getGrantedScopes()
  {
    return this.j;
  }
  
  public String getOpenId()
  {
    return this.b;
  }
  
  public String getPhotoUrl()
  {
    return this.d;
  }
  
  public String getServerAuthCode()
  {
    return this.k;
  }
  
  public String getServiceCountryCode()
  {
    return this.h;
  }
  
  public int getStatus()
  {
    return this.f;
  }
  
  public String getUid()
  {
    return this.a;
  }
  
  public String getUnionId()
  {
    return this.l;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\huawei\hms\support\api\hwid\SignInHuaweiId.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */