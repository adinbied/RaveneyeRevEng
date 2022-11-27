package kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.collections.unsigned.UArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(bv={1, 0, 3}, d1={"\000H\n\000\n\002\020\013\n\000\n\002\020\021\n\002\b\004\n\002\020\016\n\002\b\003\n\002\020\002\n\000\n\002\030\002\n\002\030\002\n\000\n\002\020!\n\002\b\003\n\002\020 \n\002\b\005\n\002\030\002\n\002\b\004\n\002\030\002\n\002\b\002\0321\020\000\032\0020\001\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\016\020\004\032\n\022\006\b\001\022\002H\0020\003H\001¢\006\004\b\005\020\006\032!\020\007\032\0020\b\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\003H\001¢\006\004\b\t\020\n\032?\020\013\032\0020\f\"\004\b\000\020\002*\n\022\006\b\001\022\002H\0020\0032\n\020\r\032\0060\016j\002`\0172\020\020\020\032\f\022\b\022\006\022\002\b\0030\0030\021H\002¢\006\004\b\022\020\023\032+\020\024\032\b\022\004\022\002H\0020\025\"\004\b\000\020\002*\022\022\016\b\001\022\n\022\006\b\001\022\002H\0020\0030\003¢\006\002\020\026\0328\020\027\032\002H\030\"\020\b\000\020\031*\006\022\002\b\0030\003*\002H\030\"\004\b\001\020\030*\002H\0312\f\020\032\032\b\022\004\022\002H\0300\033H\b¢\006\002\020\034\032)\020\035\032\0020\001*\b\022\002\b\003\030\0010\003H\b\002\016\n\f\b\000\022\002\030\001\032\004\b\003\020\000¢\006\002\020\036\032G\020\037\032\032\022\n\022\b\022\004\022\002H\0020\025\022\n\022\b\022\004\022\002H\0300\0250 \"\004\b\000\020\002\"\004\b\001\020\030*\026\022\022\b\001\022\016\022\004\022\002H\002\022\004\022\002H\0300 0\003¢\006\002\020!¨\006\""}, d2={"contentDeepEqualsImpl", "", "T", "", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "contentDeepToStringImpl", "", "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", "", "result", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "processed", "", "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "flatten", "", "([[Ljava/lang/Object;)Ljava/util/List;", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "isNullOrEmpty", "([Ljava/lang/Object;)Z", "unzip", "Lkotlin/Pair;", "([Lkotlin/Pair;)Lkotlin/Pair;", "kotlin-stdlib"}, k=5, mv={1, 1, 15}, xi=1, xs="kotlin/collections/ArraysKt")
class ArraysKt__ArraysKt
  extends ArraysKt__ArraysJVMKt
{
  public static final <T> boolean contentDeepEquals(T[] paramArrayOfT1, T[] paramArrayOfT2)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT1, "$this$contentDeepEqualsImpl");
    Intrinsics.checkParameterIsNotNull(paramArrayOfT2, "other");
    if (paramArrayOfT1 == paramArrayOfT2) {
      return true;
    }
    if (paramArrayOfT1.length != paramArrayOfT2.length) {
      return false;
    }
    int j = paramArrayOfT1.length;
    int i = 0;
    while (i < j)
    {
      T ? = paramArrayOfT1[i];
      T ? = paramArrayOfT2[i];
      if (? != ?)
      {
        if (? == null) {
          break label557;
        }
        if (? == null) {
          return false;
        }
        if (((? instanceof Object[])) && ((? instanceof Object[])))
        {
          if (!ArraysKt.contentDeepEquals((Object[])?, (Object[])?)) {
            return false;
          }
        }
        else if (((? instanceof byte[])) && ((? instanceof byte[])))
        {
          if (!Arrays.equals((byte[])?, (byte[])?)) {
            return false;
          }
        }
        else if (((? instanceof short[])) && ((? instanceof short[])))
        {
          if (!Arrays.equals((short[])?, (short[])?)) {
            return false;
          }
        }
        else if (((? instanceof int[])) && ((? instanceof int[])))
        {
          if (!Arrays.equals((int[])?, (int[])?)) {
            return false;
          }
        }
        else if (((? instanceof long[])) && ((? instanceof long[])))
        {
          if (!Arrays.equals((long[])?, (long[])?)) {
            return false;
          }
        }
        else if (((? instanceof float[])) && ((? instanceof float[])))
        {
          if (!Arrays.equals((float[])?, (float[])?)) {
            return false;
          }
        }
        else if (((? instanceof double[])) && ((? instanceof double[])))
        {
          if (!Arrays.equals((double[])?, (double[])?)) {
            return false;
          }
        }
        else if (((? instanceof char[])) && ((? instanceof char[])))
        {
          if (!Arrays.equals((char[])?, (char[])?)) {
            return false;
          }
        }
        else if (((? instanceof boolean[])) && ((? instanceof boolean[])))
        {
          if (!Arrays.equals((boolean[])?, (boolean[])?)) {
            return false;
          }
        }
        else if (((? instanceof UByteArray)) && ((? instanceof UByteArray)))
        {
          if (!UArraysKt.contentEquals-kdPth3s(((UByteArray)?).unbox-impl(), ((UByteArray)?).unbox-impl())) {
            return false;
          }
        }
        else if (((? instanceof UShortArray)) && ((? instanceof UShortArray)))
        {
          if (!UArraysKt.contentEquals-mazbYpA(((UShortArray)?).unbox-impl(), ((UShortArray)?).unbox-impl())) {
            return false;
          }
        }
        else if (((? instanceof UIntArray)) && ((? instanceof UIntArray)))
        {
          if (!UArraysKt.contentEquals-ctEhBpI(((UIntArray)?).unbox-impl(), ((UIntArray)?).unbox-impl())) {
            return false;
          }
        }
        else if (((? instanceof ULongArray)) && ((? instanceof ULongArray)))
        {
          if (!UArraysKt.contentEquals-us8wMrg(((ULongArray)?).unbox-impl(), ((ULongArray)?).unbox-impl())) {
            return false;
          }
        }
        else if ((Intrinsics.areEqual(?, ?) ^ true)) {
          return false;
        }
      }
      i += 1;
      continue;
      label557:
      return false;
    }
    return true;
  }
  
  public static final <T> String contentDeepToString(T[] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$contentDeepToStringImpl");
    StringBuilder localStringBuilder = new StringBuilder(RangesKt.coerceAtMost(paramArrayOfT.length, 429496729) * 5 + 2);
    contentDeepToStringInternal$ArraysKt__ArraysKt(paramArrayOfT, localStringBuilder, (List)new ArrayList());
    paramArrayOfT = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfT, "StringBuilder(capacity).…builderAction).toString()");
    return paramArrayOfT;
  }
  
  private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] paramArrayOfT, StringBuilder paramStringBuilder, List<Object[]> paramList)
  {
    if (paramList.contains(paramArrayOfT))
    {
      paramStringBuilder.append("[...]");
      return;
    }
    paramList.add(paramArrayOfT);
    paramStringBuilder.append('[');
    int i = 0;
    int j = paramArrayOfT.length;
    while (i < j)
    {
      if (i != 0) {
        paramStringBuilder.append(", ");
      }
      Object localObject = paramArrayOfT[i];
      if (localObject == null)
      {
        paramStringBuilder.append("null");
      }
      else if ((localObject instanceof Object[]))
      {
        contentDeepToStringInternal$ArraysKt__ArraysKt((Object[])localObject, paramStringBuilder, paramList);
      }
      else if ((localObject instanceof byte[]))
      {
        localObject = Arrays.toString((byte[])localObject);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
        paramStringBuilder.append((String)localObject);
      }
      else if ((localObject instanceof short[]))
      {
        localObject = Arrays.toString((short[])localObject);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
        paramStringBuilder.append((String)localObject);
      }
      else if ((localObject instanceof int[]))
      {
        localObject = Arrays.toString((int[])localObject);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
        paramStringBuilder.append((String)localObject);
      }
      else if ((localObject instanceof long[]))
      {
        localObject = Arrays.toString((long[])localObject);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
        paramStringBuilder.append((String)localObject);
      }
      else if ((localObject instanceof float[]))
      {
        localObject = Arrays.toString((float[])localObject);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
        paramStringBuilder.append((String)localObject);
      }
      else if ((localObject instanceof double[]))
      {
        localObject = Arrays.toString((double[])localObject);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
        paramStringBuilder.append((String)localObject);
      }
      else if ((localObject instanceof char[]))
      {
        localObject = Arrays.toString((char[])localObject);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
        paramStringBuilder.append((String)localObject);
      }
      else if ((localObject instanceof boolean[]))
      {
        localObject = Arrays.toString((boolean[])localObject);
        Intrinsics.checkExpressionValueIsNotNull(localObject, "java.util.Arrays.toString(this)");
        paramStringBuilder.append((String)localObject);
      }
      else if ((localObject instanceof UByteArray))
      {
        paramStringBuilder.append(UArraysKt.contentToString-GBYM_sE(((UByteArray)localObject).unbox-impl()));
      }
      else if ((localObject instanceof UShortArray))
      {
        paramStringBuilder.append(UArraysKt.contentToString-rL5Bavg(((UShortArray)localObject).unbox-impl()));
      }
      else if ((localObject instanceof UIntArray))
      {
        paramStringBuilder.append(UArraysKt.contentToString--ajY-9A(((UIntArray)localObject).unbox-impl()));
      }
      else if ((localObject instanceof ULongArray))
      {
        paramStringBuilder.append(UArraysKt.contentToString-QwZRm1k(((ULongArray)localObject).unbox-impl()));
      }
      else
      {
        paramStringBuilder.append(localObject.toString());
      }
      i += 1;
    }
    paramStringBuilder.append(']');
    paramList.remove(CollectionsKt.getLastIndex(paramList));
  }
  
  public static final <T> List<T> flatten(T[][] paramArrayOfT)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfT, "$this$flatten");
    Object localObject = (Object[])paramArrayOfT;
    int m = localObject.length;
    int k = 0;
    int i = 0;
    int j = 0;
    while (i < m)
    {
      j += ((Object[])localObject[i]).length;
      i += 1;
    }
    localObject = new ArrayList(j);
    j = paramArrayOfT.length;
    i = k;
    while (i < j)
    {
      T[] arrayOfT = paramArrayOfT[i];
      CollectionsKt.addAll((Collection)localObject, arrayOfT);
      i += 1;
    }
    return (List)localObject;
  }
  
  private static final <C extends Object[],  extends R, R> R ifEmpty(C paramC, Function0<? extends R> paramFunction0)
  {
    int i;
    if (paramC.length == 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      paramC = paramFunction0.invoke();
    }
    return paramC;
  }
  
  private static final boolean isNullOrEmpty(Object[] paramArrayOfObject)
  {
    boolean bool = false;
    if (paramArrayOfObject != null)
    {
      int i;
      if (paramArrayOfObject.length == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0) {}
    }
    else
    {
      bool = true;
    }
    return bool;
  }
  
  public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] paramArrayOfPair)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfPair, "$this$unzip");
    ArrayList localArrayList1 = new ArrayList(paramArrayOfPair.length);
    ArrayList localArrayList2 = new ArrayList(paramArrayOfPair.length);
    int j = paramArrayOfPair.length;
    int i = 0;
    while (i < j)
    {
      Pair<? extends T, ? extends R> localPair = paramArrayOfPair[i];
      localArrayList1.add(localPair.getFirst());
      localArrayList2.add(localPair.getSecond());
      i += 1;
    }
    return TuplesKt.to(localArrayList1, localArrayList2);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\kotlin\collections\ArraysKt__ArraysKt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */