package com.google.android.gms.common.util;

import android.text.TextUtils;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public final class ScopeUtil
{
  public static Set<Scope> fromScopeString(Collection<String> paramCollection)
  {
    Preconditions.checkNotNull(paramCollection, "scopeStrings can't be null.");
    return fromScopeString((String[])paramCollection.toArray(new String[paramCollection.size()]));
  }
  
  public static Set<Scope> fromScopeString(String... paramVarArgs)
  {
    Preconditions.checkNotNull(paramVarArgs, "scopeStrings can't be null.");
    HashSet localHashSet = new HashSet(paramVarArgs.length);
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (!TextUtils.isEmpty(str)) {
        localHashSet.add(new Scope(str));
      }
      i += 1;
    }
    return localHashSet;
  }
  
  public static String[] toScopeString(Set<Scope> paramSet)
  {
    Preconditions.checkNotNull(paramSet, "scopes can't be null.");
    return toScopeString((Scope[])paramSet.toArray(new Scope[paramSet.size()]));
  }
  
  public static String[] toScopeString(Scope[] paramArrayOfScope)
  {
    Preconditions.checkNotNull(paramArrayOfScope, "scopes can't be null.");
    String[] arrayOfString = new String[paramArrayOfScope.length];
    int i = 0;
    while (i < paramArrayOfScope.length)
    {
      arrayOfString[i] = paramArrayOfScope[i].getScopeUri();
      i += 1;
    }
    return arrayOfString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\commo\\util\ScopeUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */