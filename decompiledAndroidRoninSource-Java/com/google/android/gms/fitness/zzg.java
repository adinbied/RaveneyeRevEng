package com.google.android.gms.fitness;

import com.google.android.gms.common.api.Scope;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public final class zzg
{
  public static Set<Scope> zza(Collection<Scope> paramCollection)
  {
    HashSet localHashSet = new HashSet(paramCollection.size());
    Iterator localIterator = paramCollection.iterator();
    while (localIterator.hasNext())
    {
      Scope localScope2 = (Scope)localIterator.next();
      Scope localScope1;
      if (localScope2.equals(new Scope("https://www.googleapis.com/auth/fitness.activity.read"))) {
        localScope1 = new Scope("https://www.googleapis.com/auth/fitness.activity.write");
      } else if (localScope2.equals(new Scope("https://www.googleapis.com/auth/fitness.location.read"))) {
        localScope1 = new Scope("https://www.googleapis.com/auth/fitness.location.write");
      } else if (localScope2.equals(new Scope("https://www.googleapis.com/auth/fitness.body.read"))) {
        localScope1 = new Scope("https://www.googleapis.com/auth/fitness.body.write");
      } else if (localScope2.equals(new Scope("https://www.googleapis.com/auth/fitness.nutrition.read"))) {
        localScope1 = new Scope("https://www.googleapis.com/auth/fitness.nutrition.write");
      } else if (localScope2.equals(new Scope("https://www.googleapis.com/auth/fitness.blood_pressure.read"))) {
        localScope1 = new Scope("https://www.googleapis.com/auth/fitness.blood_pressure.write");
      } else if (localScope2.equals(new Scope("https://www.googleapis.com/auth/fitness.blood_glucose.read"))) {
        localScope1 = new Scope("https://www.googleapis.com/auth/fitness.blood_glucose.write");
      } else if (localScope2.equals(new Scope("https://www.googleapis.com/auth/fitness.oxygen_saturation.read"))) {
        localScope1 = new Scope("https://www.googleapis.com/auth/fitness.oxygen_saturation.write");
      } else if (localScope2.equals(new Scope("https://www.googleapis.com/auth/fitness.body_temperature.read"))) {
        localScope1 = new Scope("https://www.googleapis.com/auth/fitness.body_temperature.write");
      } else if (localScope2.equals(new Scope("https://www.googleapis.com/auth/fitness.reproductive_health.read"))) {
        localScope1 = new Scope("https://www.googleapis.com/auth/fitness.reproductive_health.write");
      } else {
        localScope1 = localScope2;
      }
      if ((localScope1.equals(localScope2)) || (!paramCollection.contains(localScope1))) {
        localHashSet.add(localScope2);
      }
    }
    return localHashSet;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\zzg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */