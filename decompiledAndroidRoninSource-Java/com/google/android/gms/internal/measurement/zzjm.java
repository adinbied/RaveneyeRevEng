package com.google.android.gms.internal.measurement;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

final class zzjm
{
  static String zza(zzjh paramzzjh, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("# ");
    localStringBuilder.append(paramString);
    zza(paramzzjh, localStringBuilder, 0);
    return localStringBuilder.toString();
  }
  
  private static final String zza(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramString.length())
    {
      char c = paramString.charAt(i);
      if (Character.isUpperCase(c)) {
        localStringBuilder.append("_");
      }
      localStringBuilder.append(Character.toLowerCase(c));
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  private static void zza(zzjh paramzzjh, StringBuilder paramStringBuilder, int paramInt)
  {
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    Object localObject1 = new TreeSet();
    Object localObject2 = paramzzjh.getClass().getDeclaredMethods();
    int j = localObject2.length;
    int i = 0;
    Object localObject3;
    while (i < j)
    {
      localObject3 = localObject2[i];
      localHashMap2.put(((Method)localObject3).getName(), localObject3);
      if (((Method)localObject3).getParameterTypes().length == 0)
      {
        localHashMap1.put(((Method)localObject3).getName(), localObject3);
        if (((Method)localObject3).getName().startsWith("get")) {
          ((Set)localObject1).add(((Method)localObject3).getName());
        }
      }
      i += 1;
    }
    Iterator localIterator = ((Set)localObject1).iterator();
    while (localIterator.hasNext())
    {
      localObject3 = (String)localIterator.next();
      if (((String)localObject3).startsWith("get")) {
        localObject1 = ((String)localObject3).substring(3);
      } else {
        localObject1 = localObject3;
      }
      boolean bool1 = ((String)localObject1).endsWith("List");
      boolean bool2 = true;
      Object localObject4;
      if ((bool1) && (!((String)localObject1).endsWith("OrBuilderList")) && (!((String)localObject1).equals("List")))
      {
        localObject2 = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase());
        localObject4 = String.valueOf(((String)localObject1).substring(1, ((String)localObject1).length() - 4));
        if (((String)localObject4).length() != 0) {
          localObject2 = ((String)localObject2).concat((String)localObject4);
        } else {
          localObject2 = new String((String)localObject2);
        }
        localObject4 = (Method)localHashMap1.get(localObject3);
        if ((localObject4 != null) && (((Method)localObject4).getReturnType().equals(List.class)))
        {
          zza(paramStringBuilder, paramInt, zza((String)localObject2), zzhz.zza((Method)localObject4, paramzzjh, new Object[0]));
          continue;
        }
      }
      if ((((String)localObject1).endsWith("Map")) && (!((String)localObject1).equals("Map")))
      {
        localObject2 = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase());
        localObject4 = String.valueOf(((String)localObject1).substring(1, ((String)localObject1).length() - 3));
        if (((String)localObject4).length() != 0) {
          localObject2 = ((String)localObject2).concat((String)localObject4);
        } else {
          localObject2 = new String((String)localObject2);
        }
        localObject3 = (Method)localHashMap1.get(localObject3);
        if ((localObject3 != null) && (((Method)localObject3).getReturnType().equals(Map.class)) && (!((Method)localObject3).isAnnotationPresent(Deprecated.class)) && (Modifier.isPublic(((Method)localObject3).getModifiers())))
        {
          zza(paramStringBuilder, paramInt, zza((String)localObject2), zzhz.zza((Method)localObject3, paramzzjh, new Object[0]));
          continue;
        }
      }
      localObject2 = String.valueOf(localObject1);
      if (((String)localObject2).length() != 0) {
        localObject2 = "set".concat((String)localObject2);
      } else {
        localObject2 = new String("set");
      }
      if ((Method)localHashMap2.get(localObject2) != null) {
        if (((String)localObject1).endsWith("Bytes"))
        {
          localObject2 = String.valueOf(((String)localObject1).substring(0, ((String)localObject1).length() - 5));
          if (((String)localObject2).length() != 0) {
            localObject2 = "get".concat((String)localObject2);
          } else {
            localObject2 = new String("get");
          }
          if (localHashMap1.containsKey(localObject2)) {}
        }
        else
        {
          localObject2 = String.valueOf(((String)localObject1).substring(0, 1).toLowerCase());
          localObject3 = String.valueOf(((String)localObject1).substring(1));
          if (((String)localObject3).length() != 0) {
            localObject2 = ((String)localObject2).concat((String)localObject3);
          } else {
            localObject2 = new String((String)localObject2);
          }
          localObject3 = String.valueOf(localObject1);
          if (((String)localObject3).length() != 0) {
            localObject3 = "get".concat((String)localObject3);
          } else {
            localObject3 = new String("get");
          }
          localObject3 = (Method)localHashMap1.get(localObject3);
          localObject1 = String.valueOf(localObject1);
          if (((String)localObject1).length() != 0) {
            localObject1 = "has".concat((String)localObject1);
          } else {
            localObject1 = new String("has");
          }
          localObject1 = (Method)localHashMap1.get(localObject1);
          if (localObject3 != null)
          {
            localObject3 = zzhz.zza((Method)localObject3, paramzzjh, new Object[0]);
            if (localObject1 == null)
            {
              if ((localObject3 instanceof Boolean)) {
                if (((Boolean)localObject3).booleanValue()) {}
              }
              for (;;)
              {
                bool1 = true;
                break;
                label883:
                label907:
                label974:
                do
                {
                  do
                  {
                    do
                    {
                      do
                      {
                        do
                        {
                          bool1 = false;
                          break label996;
                          if (!(localObject3 instanceof Integer)) {
                            break;
                          }
                        } while (((Integer)localObject3).intValue() != 0);
                        break;
                        if (!(localObject3 instanceof Float)) {
                          break label883;
                        }
                      } while (((Float)localObject3).floatValue() != 0.0F);
                      break;
                      if (!(localObject3 instanceof Double)) {
                        break label907;
                      }
                    } while (((Double)localObject3).doubleValue() != 0.0D);
                    break;
                    if ((localObject3 instanceof String))
                    {
                      bool1 = localObject3.equals("");
                      break label996;
                    }
                    if ((localObject3 instanceof zzgr))
                    {
                      bool1 = localObject3.equals(zzgr.zza);
                      break label996;
                    }
                    if (!(localObject3 instanceof zzjh)) {
                      break label974;
                    }
                  } while (localObject3 != ((zzjh)localObject3).zzaa());
                  break;
                } while ((!(localObject3 instanceof Enum)) || (((Enum)localObject3).ordinal() != 0));
              }
              label996:
              if (!bool1) {
                bool1 = bool2;
              } else {
                bool1 = false;
              }
            }
            else
            {
              bool1 = ((Boolean)zzhz.zza((Method)localObject1, paramzzjh, new Object[0])).booleanValue();
            }
            if (bool1) {
              zza(paramStringBuilder, paramInt, zza((String)localObject2), localObject3);
            }
          }
        }
      }
    }
    if ((paramzzjh instanceof zzhz.zzb))
    {
      localObject1 = ((zzhz.zzb)paramzzjh).zzc.zzd();
      if (((Iterator)localObject1).hasNext())
      {
        paramzzjh = (zzhz.zze)((Map.Entry)((Iterator)localObject1).next()).getKey();
        throw new NoSuchMethodError();
      }
    }
    paramzzjh = (zzhz)paramzzjh;
    if (paramzzjh.zzb != null) {
      paramzzjh.zzb.zza(paramStringBuilder, paramInt);
    }
  }
  
  static final void zza(StringBuilder paramStringBuilder, int paramInt, String paramString, Object paramObject)
  {
    if ((paramObject instanceof List))
    {
      paramObject = ((List)paramObject).iterator();
      while (((Iterator)paramObject).hasNext()) {
        zza(paramStringBuilder, paramInt, paramString, ((Iterator)paramObject).next());
      }
      return;
    }
    if ((paramObject instanceof Map))
    {
      paramObject = ((Map)paramObject).entrySet().iterator();
      while (((Iterator)paramObject).hasNext()) {
        zza(paramStringBuilder, paramInt, paramString, (Map.Entry)((Iterator)paramObject).next());
      }
      return;
    }
    paramStringBuilder.append('\n');
    int j = 0;
    int k = 0;
    int i = 0;
    while (i < paramInt)
    {
      paramStringBuilder.append(' ');
      i += 1;
    }
    paramStringBuilder.append(paramString);
    if ((paramObject instanceof String))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzkn.zza(zzgr.zza((String)paramObject)));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzgr))
    {
      paramStringBuilder.append(": \"");
      paramStringBuilder.append(zzkn.zza((zzgr)paramObject));
      paramStringBuilder.append('"');
      return;
    }
    if ((paramObject instanceof zzhz))
    {
      paramStringBuilder.append(" {");
      zza((zzhz)paramObject, paramStringBuilder, paramInt + 2);
      paramStringBuilder.append("\n");
      i = k;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    if ((paramObject instanceof Map.Entry))
    {
      paramStringBuilder.append(" {");
      paramString = (Map.Entry)paramObject;
      i = paramInt + 2;
      zza(paramStringBuilder, i, "key", paramString.getKey());
      zza(paramStringBuilder, i, "value", paramString.getValue());
      paramStringBuilder.append("\n");
      i = j;
      while (i < paramInt)
      {
        paramStringBuilder.append(' ');
        i += 1;
      }
      paramStringBuilder.append("}");
      return;
    }
    paramStringBuilder.append(": ");
    paramStringBuilder.append(paramObject.toString());
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\internal\measurement\zzjm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */