package com.google.android.gms.common.server.response;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.util.SparseArray;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader.ParseException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.util.ArrayUtils;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SafeParcelResponse
  extends FastSafeParcelableJsonResponse
{
  public static final Parcelable.Creator<SafeParcelResponse> CREATOR = new zap();
  private final String mClassName;
  private final int zalf;
  private final zak zapz;
  private final Parcel zarb;
  private final int zarc;
  private int zard;
  private int zare;
  
  SafeParcelResponse(int paramInt, Parcel paramParcel, zak paramzak)
  {
    this.zalf = paramInt;
    this.zarb = ((Parcel)Preconditions.checkNotNull(paramParcel));
    this.zarc = 2;
    this.zapz = paramzak;
    if (paramzak == null) {
      this.mClassName = null;
    } else {
      this.mClassName = paramzak.zact();
    }
    this.zard = 2;
  }
  
  private SafeParcelResponse(SafeParcelable paramSafeParcelable, zak paramzak, String paramString)
  {
    this.zalf = 1;
    Parcel localParcel = Parcel.obtain();
    this.zarb = localParcel;
    paramSafeParcelable.writeToParcel(localParcel, 0);
    this.zarc = 1;
    this.zapz = ((zak)Preconditions.checkNotNull(paramzak));
    this.mClassName = ((String)Preconditions.checkNotNull(paramString));
    this.zard = 2;
  }
  
  public SafeParcelResponse(zak paramzak, String paramString)
  {
    this.zalf = 1;
    this.zarb = Parcel.obtain();
    this.zarc = 0;
    this.zapz = ((zak)Preconditions.checkNotNull(paramzak));
    this.mClassName = ((String)Preconditions.checkNotNull(paramString));
    this.zard = 0;
  }
  
  public static <T extends FastJsonResponse,  extends SafeParcelable> SafeParcelResponse from(T paramT)
  {
    String str = paramT.getClass().getCanonicalName();
    zak localzak = new zak(paramT.getClass());
    zaa(localzak, paramT);
    localzak.zacs();
    localzak.zacr();
    return new SafeParcelResponse((SafeParcelable)paramT, localzak, str);
  }
  
  private static void zaa(zak paramzak, FastJsonResponse paramFastJsonResponse)
  {
    Object localObject = paramFastJsonResponse.getClass();
    if (!paramzak.zaa((Class)localObject))
    {
      Map localMap = paramFastJsonResponse.getFieldMappings();
      paramzak.zaa((Class)localObject, localMap);
      localObject = localMap.keySet().iterator();
      while (((Iterator)localObject).hasNext())
      {
        paramFastJsonResponse = (FastJsonResponse.Field)localMap.get((String)((Iterator)localObject).next());
        Class localClass = paramFastJsonResponse.zapx;
        if (localClass != null) {
          try
          {
            zaa(paramzak, (FastJsonResponse)localClass.newInstance());
          }
          catch (IllegalAccessException localIllegalAccessException)
          {
            paramzak = String.valueOf(paramFastJsonResponse.zapx.getCanonicalName());
            if (paramzak.length() != 0) {
              paramzak = "Could not access object of type ".concat(paramzak);
            } else {
              paramzak = new String("Could not access object of type ");
            }
            throw new IllegalStateException(paramzak, localIllegalAccessException);
          }
          catch (InstantiationException localInstantiationException)
          {
            paramzak = String.valueOf(paramFastJsonResponse.zapx.getCanonicalName());
            if (paramzak.length() != 0) {
              paramzak = "Could not instantiate an object of type ".concat(paramzak);
            } else {
              paramzak = new String("Could not instantiate an object of type ");
            }
            throw new IllegalStateException(paramzak, localInstantiationException);
          }
        }
      }
    }
  }
  
  private static void zaa(StringBuilder paramStringBuilder, int paramInt, Object paramObject)
  {
    switch (paramInt)
    {
    default: 
      paramStringBuilder = new StringBuilder(26);
      paramStringBuilder.append("Unknown type = ");
      paramStringBuilder.append(paramInt);
      throw new IllegalArgumentException(paramStringBuilder.toString());
    case 11: 
      throw new IllegalArgumentException("Method does not accept concrete type.");
    case 10: 
      MapUtils.writeStringMapToJson(paramStringBuilder, (HashMap)paramObject);
      return;
    case 9: 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(Base64Utils.encodeUrlSafe((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 8: 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(Base64Utils.encode((byte[])paramObject));
      paramStringBuilder.append("\"");
      return;
    case 7: 
      paramStringBuilder.append("\"");
      paramStringBuilder.append(JsonUtils.escapeString(paramObject.toString()));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private final void zaa(StringBuilder paramStringBuilder, Map<String, FastJsonResponse.Field<?, ?>> paramMap, Parcel paramParcel)
  {
    SparseArray localSparseArray = new SparseArray();
    paramMap = paramMap.entrySet().iterator();
    Object localObject1;
    while (paramMap.hasNext())
    {
      localObject1 = (Map.Entry)paramMap.next();
      localSparseArray.put(((FastJsonResponse.Field)((Map.Entry)localObject1).getValue()).getSafeParcelableFieldId(), localObject1);
    }
    paramStringBuilder.append('{');
    int j = SafeParcelReader.validateObjectHeader(paramParcel);
    int i = 0;
    while (paramParcel.dataPosition() < j)
    {
      int k = SafeParcelReader.readHeader(paramParcel);
      paramMap = (Map.Entry)localSparseArray.get(SafeParcelReader.getFieldId(k));
      if (paramMap != null)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        localObject1 = (String)paramMap.getKey();
        paramMap = (FastJsonResponse.Field)paramMap.getValue();
        paramStringBuilder.append("\"");
        paramStringBuilder.append((String)localObject1);
        paramStringBuilder.append("\":");
        Object localObject2;
        if (paramMap.zacn())
        {
          switch (paramMap.zapt)
          {
          default: 
            i = paramMap.zapt;
            paramStringBuilder = new StringBuilder(36);
            paramStringBuilder.append("Unknown field out type = ");
            paramStringBuilder.append(i);
            throw new IllegalArgumentException(paramStringBuilder.toString());
          case 11: 
            throw new IllegalArgumentException("Method does not accept concrete type.");
          case 10: 
            localObject1 = SafeParcelReader.createBundle(paramParcel, k);
            localObject2 = new HashMap();
            Iterator localIterator = ((Bundle)localObject1).keySet().iterator();
            while (localIterator.hasNext())
            {
              String str = (String)localIterator.next();
              ((HashMap)localObject2).put(str, ((Bundle)localObject1).getString(str));
            }
            zab(paramStringBuilder, paramMap, zab(paramMap, localObject2));
            break;
          case 8: 
          case 9: 
            zab(paramStringBuilder, paramMap, zab(paramMap, SafeParcelReader.createByteArray(paramParcel, k)));
            break;
          case 7: 
            zab(paramStringBuilder, paramMap, zab(paramMap, SafeParcelReader.createString(paramParcel, k)));
            break;
          case 6: 
            zab(paramStringBuilder, paramMap, zab(paramMap, Boolean.valueOf(SafeParcelReader.readBoolean(paramParcel, k))));
            break;
          case 5: 
            zab(paramStringBuilder, paramMap, zab(paramMap, SafeParcelReader.createBigDecimal(paramParcel, k)));
            break;
          case 4: 
            zab(paramStringBuilder, paramMap, zab(paramMap, Double.valueOf(SafeParcelReader.readDouble(paramParcel, k))));
            break;
          case 3: 
            zab(paramStringBuilder, paramMap, zab(paramMap, Float.valueOf(SafeParcelReader.readFloat(paramParcel, k))));
            break;
          case 2: 
            zab(paramStringBuilder, paramMap, zab(paramMap, Long.valueOf(SafeParcelReader.readLong(paramParcel, k))));
            break;
          case 1: 
            zab(paramStringBuilder, paramMap, zab(paramMap, SafeParcelReader.createBigInteger(paramParcel, k)));
            break;
          case 0: 
            zab(paramStringBuilder, paramMap, zab(paramMap, Integer.valueOf(SafeParcelReader.readInt(paramParcel, k))));
            break;
          }
        }
        else if (paramMap.zapu)
        {
          paramStringBuilder.append("[");
          switch (paramMap.zapt)
          {
          default: 
            throw new IllegalStateException("Unknown field type out.");
          case 11: 
            localObject1 = SafeParcelReader.createParcelArray(paramParcel, k);
            k = localObject1.length;
            i = 0;
          }
          while (i < k)
          {
            if (i > 0) {
              paramStringBuilder.append(",");
            }
            localObject1[i].setDataPosition(0);
            zaa(paramStringBuilder, paramMap.zacq(), localObject1[i]);
            i += 1;
            continue;
            throw new UnsupportedOperationException("List of type BASE64, BASE64_URL_SAFE, or STRING_MAP is not supported");
            ArrayUtils.writeStringArray(paramStringBuilder, SafeParcelReader.createStringArray(paramParcel, k));
            break;
            ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBooleanArray(paramParcel, k));
            break;
            ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBigDecimalArray(paramParcel, k));
            break;
            ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createDoubleArray(paramParcel, k));
            break;
            ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createFloatArray(paramParcel, k));
            break;
            ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createLongArray(paramParcel, k));
            break;
            ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createBigIntegerArray(paramParcel, k));
            break;
            ArrayUtils.writeArray(paramStringBuilder, SafeParcelReader.createIntArray(paramParcel, k));
          }
          paramStringBuilder.append("]");
        }
        else
        {
          switch (paramMap.zapt)
          {
          default: 
            throw new IllegalStateException("Unknown field type out");
          case 11: 
            localObject1 = SafeParcelReader.createParcel(paramParcel, k);
            ((Parcel)localObject1).setDataPosition(0);
            zaa(paramStringBuilder, paramMap.zacq(), (Parcel)localObject1);
            break;
          case 10: 
            paramMap = SafeParcelReader.createBundle(paramParcel, k);
            localObject1 = paramMap.keySet();
            ((Set)localObject1).size();
            paramStringBuilder.append("{");
            localObject1 = ((Set)localObject1).iterator();
            for (i = 1; ((Iterator)localObject1).hasNext(); i = 0)
            {
              localObject2 = (String)((Iterator)localObject1).next();
              if (i == 0) {
                paramStringBuilder.append(",");
              }
              paramStringBuilder.append("\"");
              paramStringBuilder.append((String)localObject2);
              paramStringBuilder.append("\"");
              paramStringBuilder.append(":");
              paramStringBuilder.append("\"");
              paramStringBuilder.append(JsonUtils.escapeString(paramMap.getString((String)localObject2)));
              paramStringBuilder.append("\"");
            }
            paramStringBuilder.append("}");
            break;
          case 9: 
            paramMap = SafeParcelReader.createByteArray(paramParcel, k);
            paramStringBuilder.append("\"");
            paramStringBuilder.append(Base64Utils.encodeUrlSafe(paramMap));
            paramStringBuilder.append("\"");
            break;
          case 8: 
            paramMap = SafeParcelReader.createByteArray(paramParcel, k);
            paramStringBuilder.append("\"");
            paramStringBuilder.append(Base64Utils.encode(paramMap));
            paramStringBuilder.append("\"");
            break;
          case 7: 
            paramMap = SafeParcelReader.createString(paramParcel, k);
            paramStringBuilder.append("\"");
            paramStringBuilder.append(JsonUtils.escapeString(paramMap));
            paramStringBuilder.append("\"");
            break;
          case 6: 
            paramStringBuilder.append(SafeParcelReader.readBoolean(paramParcel, k));
            break;
          case 5: 
            paramStringBuilder.append(SafeParcelReader.createBigDecimal(paramParcel, k));
            break;
          case 4: 
            paramStringBuilder.append(SafeParcelReader.readDouble(paramParcel, k));
            break;
          case 3: 
            paramStringBuilder.append(SafeParcelReader.readFloat(paramParcel, k));
            break;
          case 2: 
            paramStringBuilder.append(SafeParcelReader.readLong(paramParcel, k));
            break;
          case 1: 
            paramStringBuilder.append(SafeParcelReader.createBigInteger(paramParcel, k));
            break;
          case 0: 
            paramStringBuilder.append(SafeParcelReader.readInt(paramParcel, k));
          }
        }
        i = 1;
      }
    }
    if (paramParcel.dataPosition() == j)
    {
      paramStringBuilder.append('}');
      return;
    }
    paramStringBuilder = new StringBuilder(37);
    paramStringBuilder.append("Overread allowed size end=");
    paramStringBuilder.append(j);
    throw new SafeParcelReader.ParseException(paramStringBuilder.toString(), paramParcel);
  }
  
  private final void zab(FastJsonResponse.Field<?, ?> paramField)
  {
    int i;
    if (paramField.zapw != -1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramField = this.zarb;
      if (paramField != null)
      {
        i = this.zard;
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2) {
              throw new IllegalStateException("Unknown parse state in SafeParcelResponse.");
            }
            throw new IllegalStateException("Attempted to parse JSON with a SafeParcelResponse object that is already filled with data.");
          }
          return;
        }
        this.zare = SafeParcelWriter.beginObjectHeader(paramField);
        this.zard = 1;
        return;
      }
      throw new IllegalStateException("Internal Parcel object is null.");
    }
    throw new IllegalStateException("Field does not have a valid safe parcelable field id.");
  }
  
  private final void zab(StringBuilder paramStringBuilder, FastJsonResponse.Field<?, ?> paramField, Object paramObject)
  {
    if (paramField.zaps)
    {
      paramObject = (ArrayList)paramObject;
      paramStringBuilder.append("[");
      int j = ((ArrayList)paramObject).size();
      int i = 0;
      while (i < j)
      {
        if (i != 0) {
          paramStringBuilder.append(",");
        }
        zaa(paramStringBuilder, paramField.zapr, ((ArrayList)paramObject).get(i));
        i += 1;
      }
      paramStringBuilder.append("]");
      return;
    }
    zaa(paramStringBuilder, paramField.zapr, paramObject);
  }
  
  private final Parcel zacu()
  {
    int i = this.zard;
    if (i != 0)
    {
      if (i != 1) {
        break label44;
      }
    }
    else {
      this.zare = SafeParcelWriter.beginObjectHeader(this.zarb);
    }
    SafeParcelWriter.finishObjectHeader(this.zarb, this.zare);
    this.zard = 2;
    label44:
    return this.zarb;
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList)
  {
    zab(paramField);
    paramString = new ArrayList();
    paramArrayList.size();
    paramArrayList = (ArrayList)paramArrayList;
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramArrayList.get(i);
      i += 1;
      paramString.add(((SafeParcelResponse)localObject).zacu());
    }
    SafeParcelWriter.writeParcelList(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, T paramT)
  {
    zab(paramField);
    paramString = ((SafeParcelResponse)paramT).zacu();
    SafeParcelWriter.writeParcel(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  public Map<String, FastJsonResponse.Field<?, ?>> getFieldMappings()
  {
    zak localzak = this.zapz;
    if (localzak == null) {
      return null;
    }
    return localzak.zai(this.mClassName);
  }
  
  public Object getValueObject(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  public boolean isPrimitiveFieldSet(String paramString)
  {
    throw new UnsupportedOperationException("Converting to JSON does not require this method.");
  }
  
  protected void setBooleanInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, boolean paramBoolean)
  {
    zab(paramField);
    SafeParcelWriter.writeBoolean(this.zarb, paramField.getSafeParcelableFieldId(), paramBoolean);
  }
  
  protected void setDecodedBytesInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, byte[] paramArrayOfByte)
  {
    zab(paramField);
    SafeParcelWriter.writeByteArray(this.zarb, paramField.getSafeParcelableFieldId(), paramArrayOfByte, true);
  }
  
  protected void setIntegerInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, int paramInt)
  {
    zab(paramField);
    SafeParcelWriter.writeInt(this.zarb, paramField.getSafeParcelableFieldId(), paramInt);
  }
  
  protected void setLongInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, long paramLong)
  {
    zab(paramField);
    SafeParcelWriter.writeLong(this.zarb, paramField.getSafeParcelableFieldId(), paramLong);
  }
  
  protected void setStringInternal(FastJsonResponse.Field<?, ?> paramField, String paramString1, String paramString2)
  {
    zab(paramField);
    SafeParcelWriter.writeString(this.zarb, paramField.getSafeParcelableFieldId(), paramString2, true);
  }
  
  protected void setStringsInternal(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList)
  {
    zab(paramField);
    int j = paramArrayList.size();
    paramString = new String[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((String)paramArrayList.get(i));
      i += 1;
    }
    SafeParcelWriter.writeStringArray(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  public String toString()
  {
    Preconditions.checkNotNull(this.zapz, "Cannot convert to JSON on client side.");
    Parcel localParcel = zacu();
    localParcel.setDataPosition(0);
    StringBuilder localStringBuilder = new StringBuilder(100);
    zaa(localStringBuilder, this.zapz.zai(this.mClassName), localParcel);
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
    SafeParcelWriter.writeParcel(paramParcel, 2, zacu(), false);
    int j = this.zarc;
    zak localzak;
    if (j != 0)
    {
      if (j != 1)
      {
        if (j == 2)
        {
          localzak = this.zapz;
        }
        else
        {
          paramInt = this.zarc;
          paramParcel = new StringBuilder(34);
          paramParcel.append("Invalid creation type: ");
          paramParcel.append(paramInt);
          throw new IllegalStateException(paramParcel.toString());
        }
      }
      else {
        localzak = this.zapz;
      }
    }
    else {
      localzak = null;
    }
    SafeParcelWriter.writeParcelable(paramParcel, 3, localzak, paramInt, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, i);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, double paramDouble)
  {
    zab(paramField);
    SafeParcelWriter.writeDouble(this.zarb, paramField.getSafeParcelableFieldId(), paramDouble);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, float paramFloat)
  {
    zab(paramField);
    SafeParcelWriter.writeFloat(this.zarb, paramField.getSafeParcelableFieldId(), paramFloat);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal)
  {
    zab(paramField);
    SafeParcelWriter.writeBigDecimal(this.zarb, paramField.getSafeParcelableFieldId(), paramBigDecimal, true);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, BigInteger paramBigInteger)
  {
    zab(paramField);
    SafeParcelWriter.writeBigInteger(this.zarb, paramField.getSafeParcelableFieldId(), paramBigInteger, true);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList)
  {
    zab(paramField);
    int j = paramArrayList.size();
    paramString = new int[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Integer)paramArrayList.get(i)).intValue();
      i += 1;
    }
    SafeParcelWriter.writeIntArray(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void zaa(FastJsonResponse.Field<?, ?> paramField, String paramString, Map<String, String> paramMap)
  {
    zab(paramField);
    paramString = new Bundle();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      paramString.putString(str, (String)paramMap.get(str));
    }
    SafeParcelWriter.writeBundle(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void zab(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList)
  {
    zab(paramField);
    int j = paramArrayList.size();
    paramString = new BigInteger[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((BigInteger)paramArrayList.get(i));
      i += 1;
    }
    SafeParcelWriter.writeBigIntegerArray(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void zac(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList)
  {
    zab(paramField);
    int j = paramArrayList.size();
    paramString = new long[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Long)paramArrayList.get(i)).longValue();
      i += 1;
    }
    SafeParcelWriter.writeLongArray(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void zad(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList)
  {
    zab(paramField);
    int j = paramArrayList.size();
    paramString = new float[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Float)paramArrayList.get(i)).floatValue();
      i += 1;
    }
    SafeParcelWriter.writeFloatArray(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void zae(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList)
  {
    zab(paramField);
    int j = paramArrayList.size();
    paramString = new double[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Double)paramArrayList.get(i)).doubleValue();
      i += 1;
    }
    SafeParcelWriter.writeDoubleArray(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void zaf(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    zab(paramField);
    int j = paramArrayList.size();
    paramString = new BigDecimal[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((BigDecimal)paramArrayList.get(i));
      i += 1;
    }
    SafeParcelWriter.writeBigDecimalArray(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
  
  protected final void zag(FastJsonResponse.Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList)
  {
    zab(paramField);
    int j = paramArrayList.size();
    paramString = new boolean[j];
    int i = 0;
    while (i < j)
    {
      paramString[i] = ((Boolean)paramArrayList.get(i)).booleanValue();
      i += 1;
    }
    SafeParcelWriter.writeBooleanArray(this.zarb, paramField.getSafeParcelableFieldId(), paramString, true);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\server\response\SafeParcelResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */