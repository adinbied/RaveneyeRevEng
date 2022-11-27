package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

public final class zzfv
{
  static int zza(Set<?> paramSet)
  {
    paramSet = paramSet.iterator();
    int i = 0;
    while (paramSet.hasNext())
    {
      Object localObject = paramSet.next();
      int j;
      if (localObject != null) {
        j = localObject.hashCode();
      } else {
        j = 0;
      }
      i += j;
    }
    return i;
  }
  
  static boolean zza(Set<?> paramSet, @NullableDecl Object paramObject)
  {
    if (paramSet == paramObject) {
      return true;
    }
    if ((paramObject instanceof Set)) {
      paramObject = (Set)paramObject;
    }
    try
    {
      if (paramSet.size() == ((Set)paramObject).size())
      {
        boolean bool = paramSet.containsAll((Collection)paramObject);
        if (bool) {
          return true;
        }
      }
      return false;
    }
    catch (NullPointerException|ClassCastException paramSet) {}
    return false;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzfv.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */