package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.util.Log;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Objects.ToStringHelper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.util.Base64Utils;
import com.google.android.gms.common.util.JsonUtils;
import com.google.android.gms.common.util.MapUtils;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class FastJsonResponse
{
  private final <I, O> void zaa(Field<I, O> paramField, I paramI)
  {
    String str = paramField.zapv;
    paramI = paramField.convert(paramI);
    switch (paramField.zapt)
    {
    case 3: 
    default: 
      int i = paramField.zapt;
      paramField = new StringBuilder(44);
      paramField.append("Unsupported type for conversion: ");
      paramField.append(i);
      throw new IllegalStateException(paramField.toString());
    case 8: 
    case 9: 
      if (zaa(str, paramI))
      {
        setDecodedBytesInternal(paramField, str, (byte[])paramI);
        return;
      }
      break;
    case 7: 
      setStringInternal(paramField, str, (String)paramI);
      return;
    case 6: 
      if (zaa(str, paramI))
      {
        setBooleanInternal(paramField, str, ((Boolean)paramI).booleanValue());
        return;
      }
      break;
    case 5: 
      zaa(paramField, str, (BigDecimal)paramI);
      return;
    case 4: 
      if (zaa(str, paramI))
      {
        zaa(paramField, str, ((Double)paramI).doubleValue());
        return;
      }
      break;
    case 2: 
      if (zaa(str, paramI))
      {
        setLongInternal(paramField, str, ((Long)paramI).longValue());
        return;
      }
      break;
    case 1: 
      zaa(paramField, str, (BigInteger)paramI);
      return;
    case 0: 
      if (zaa(str, paramI)) {
        setIntegerInternal(paramField, str, ((Integer)paramI).intValue());
      }
      break;
    }
  }
  
  private static void zaa(StringBuilder paramStringBuilder, Field paramField, Object paramObject)
  {
    if (paramField.zapr == 11)
    {
      paramStringBuilder.append(((FastJsonResponse)paramField.zapx.cast(paramObject)).toString());
      return;
    }
    if (paramField.zapr == 7)
    {
      paramStringBuilder.append("\"");
      paramStringBuilder.append(JsonUtils.escapeString((String)paramObject));
      paramStringBuilder.append("\"");
      return;
    }
    paramStringBuilder.append(paramObject);
  }
  
  private static <O> boolean zaa(String paramString, O paramO)
  {
    if (paramO == null)
    {
      if (Log.isLoggable("FastJsonResponse", 6))
      {
        paramO = new StringBuilder(String.valueOf(paramString).length() + 58);
        paramO.append("Output field (");
        paramO.append(paramString);
        paramO.append(") has a null value, but expected a primitive");
        Log.e("FastJsonResponse", paramO.toString());
      }
      return false;
    }
    return true;
  }
  
  protected static <O, I> I zab(Field<I, O> paramField, Object paramObject)
  {
    if (Field.zaa(paramField) != null) {
      return (I)paramField.convertBack(paramObject);
    }
    return (I)paramObject;
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeArrayInternal(Field<?, ?> paramField, String paramString, ArrayList<T> paramArrayList)
  {
    throw new UnsupportedOperationException("Concrete type array not supported");
  }
  
  public <T extends FastJsonResponse> void addConcreteTypeInternal(Field<?, ?> paramField, String paramString, T paramT)
  {
    throw new UnsupportedOperationException("Concrete type not supported");
  }
  
  public abstract Map<String, Field<?, ?>> getFieldMappings();
  
  protected Object getFieldValue(Field paramField)
  {
    Object localObject = paramField.zapv;
    if (paramField.zapx != null)
    {
      if (getValueObject(paramField.zapv) == null) {
        bool = true;
      } else {
        bool = false;
      }
      Preconditions.checkState(bool, "Concrete field shouldn't be value object: %s", new Object[] { paramField.zapv });
      boolean bool = paramField.zapu;
      try
      {
        char c = Character.toUpperCase(((String)localObject).charAt(0));
        paramField = ((String)localObject).substring(1);
        localObject = new StringBuilder(String.valueOf(paramField).length() + 4);
        ((StringBuilder)localObject).append("get");
        ((StringBuilder)localObject).append(c);
        ((StringBuilder)localObject).append(paramField);
        paramField = ((StringBuilder)localObject).toString();
        paramField = getClass().getMethod(paramField, new Class[0]).invoke(this, new Object[0]);
        return paramField;
      }
      catch (Exception paramField)
      {
        throw new RuntimeException(paramField);
      }
    }
    return getValueObject(paramField.zapv);
  }
  
  protected abstract Object getValueObject(String paramString);
  
  protected boolean isFieldSet(Field paramField)
  {
    if (paramField.zapt == 11)
    {
      if (paramField.zapu)
      {
        paramField = paramField.zapv;
        throw new UnsupportedOperationException("Concrete type arrays not supported");
      }
      paramField = paramField.zapv;
      throw new UnsupportedOperationException("Concrete types not supported");
    }
    return isPrimitiveFieldSet(paramField.zapv);
  }
  
  protected abstract boolean isPrimitiveFieldSet(String paramString);
  
  protected void setBooleanInternal(Field<?, ?> paramField, String paramString, boolean paramBoolean)
  {
    throw new UnsupportedOperationException("Boolean not supported");
  }
  
  protected void setDecodedBytesInternal(Field<?, ?> paramField, String paramString, byte[] paramArrayOfByte)
  {
    throw new UnsupportedOperationException("byte[] not supported");
  }
  
  protected void setIntegerInternal(Field<?, ?> paramField, String paramString, int paramInt)
  {
    throw new UnsupportedOperationException("Integer not supported");
  }
  
  protected void setLongInternal(Field<?, ?> paramField, String paramString, long paramLong)
  {
    throw new UnsupportedOperationException("Long not supported");
  }
  
  protected void setStringInternal(Field<?, ?> paramField, String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException("String not supported");
  }
  
  protected void setStringsInternal(Field<?, ?> paramField, String paramString, ArrayList<String> paramArrayList)
  {
    throw new UnsupportedOperationException("String list not supported");
  }
  
  public String toString()
  {
    Map localMap = getFieldMappings();
    StringBuilder localStringBuilder = new StringBuilder(100);
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject1 = (String)localIterator.next();
      Field localField = (Field)localMap.get(localObject1);
      if (isFieldSet(localField))
      {
        Object localObject2 = zab(localField, getFieldValue(localField));
        if (localStringBuilder.length() == 0) {
          localStringBuilder.append("{");
        } else {
          localStringBuilder.append(",");
        }
        localStringBuilder.append("\"");
        localStringBuilder.append((String)localObject1);
        localStringBuilder.append("\":");
        if (localObject2 == null)
        {
          localStringBuilder.append("null");
        }
        else
        {
          int i;
          int j;
          switch (localField.zapt)
          {
          default: 
            if (localField.zaps)
            {
              localObject1 = (ArrayList)localObject2;
              localStringBuilder.append("[");
              i = 0;
              j = ((ArrayList)localObject1).size();
            }
            break;
          case 10: 
            MapUtils.writeStringMapToJson(localStringBuilder, (HashMap)localObject2);
            break;
          case 9: 
            localStringBuilder.append("\"");
            localStringBuilder.append(Base64Utils.encodeUrlSafe((byte[])localObject2));
            localStringBuilder.append("\"");
            break;
          case 8: 
            localStringBuilder.append("\"");
            localStringBuilder.append(Base64Utils.encode((byte[])localObject2));
            localStringBuilder.append("\"");
            continue;
            while (i < j)
            {
              if (i > 0) {
                localStringBuilder.append(",");
              }
              localObject2 = ((ArrayList)localObject1).get(i);
              if (localObject2 != null) {
                zaa(localStringBuilder, localField, localObject2);
              }
              i += 1;
            }
            localStringBuilder.append("]");
            continue;
            zaa(localStringBuilder, localField, localObject2);
          }
        }
      }
    }
    if (localStringBuilder.length() > 0) {
      localStringBuilder.append("}");
    } else {
      localStringBuilder.append("{}");
    }
    return localStringBuilder.toString();
  }
  
  public final <O> void zaa(Field<Double, O> paramField, double paramDouble)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, Double.valueOf(paramDouble));
      return;
    }
    zaa(paramField, paramField.zapv, paramDouble);
  }
  
  public final <O> void zaa(Field<Float, O> paramField, float paramFloat)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, Float.valueOf(paramFloat));
      return;
    }
    zaa(paramField, paramField.zapv, paramFloat);
  }
  
  public final <O> void zaa(Field<Integer, O> paramField, int paramInt)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, Integer.valueOf(paramInt));
      return;
    }
    setIntegerInternal(paramField, paramField.zapv, paramInt);
  }
  
  public final <O> void zaa(Field<Long, O> paramField, long paramLong)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, Long.valueOf(paramLong));
      return;
    }
    setLongInternal(paramField, paramField.zapv, paramLong);
  }
  
  public final <O> void zaa(Field<String, O> paramField, String paramString)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramString);
      return;
    }
    setStringInternal(paramField, paramField.zapv, paramString);
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, double paramDouble)
  {
    throw new UnsupportedOperationException("Double not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, float paramFloat)
  {
    throw new UnsupportedOperationException("Float not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, BigDecimal paramBigDecimal)
  {
    throw new UnsupportedOperationException("BigDecimal not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, BigInteger paramBigInteger)
  {
    throw new UnsupportedOperationException("BigInteger not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, ArrayList<Integer> paramArrayList)
  {
    throw new UnsupportedOperationException("Integer list not supported");
  }
  
  protected void zaa(Field<?, ?> paramField, String paramString, Map<String, String> paramMap)
  {
    throw new UnsupportedOperationException("String map not supported");
  }
  
  public final <O> void zaa(Field<BigDecimal, O> paramField, BigDecimal paramBigDecimal)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramBigDecimal);
      return;
    }
    zaa(paramField, paramField.zapv, paramBigDecimal);
  }
  
  public final <O> void zaa(Field<BigInteger, O> paramField, BigInteger paramBigInteger)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramBigInteger);
      return;
    }
    zaa(paramField, paramField.zapv, paramBigInteger);
  }
  
  public final <O> void zaa(Field<ArrayList<Integer>, O> paramField, ArrayList<Integer> paramArrayList)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramArrayList);
      return;
    }
    zaa(paramField, paramField.zapv, paramArrayList);
  }
  
  public final <O> void zaa(Field<Map<String, String>, O> paramField, Map<String, String> paramMap)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramMap);
      return;
    }
    zaa(paramField, paramField.zapv, paramMap);
  }
  
  public final <O> void zaa(Field<Boolean, O> paramField, boolean paramBoolean)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, Boolean.valueOf(paramBoolean));
      return;
    }
    setBooleanInternal(paramField, paramField.zapv, paramBoolean);
  }
  
  public final <O> void zaa(Field<byte[], O> paramField, byte[] paramArrayOfByte)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramArrayOfByte);
      return;
    }
    setDecodedBytesInternal(paramField, paramField.zapv, paramArrayOfByte);
  }
  
  protected void zab(Field<?, ?> paramField, String paramString, ArrayList<BigInteger> paramArrayList)
  {
    throw new UnsupportedOperationException("BigInteger list not supported");
  }
  
  public final <O> void zab(Field<ArrayList<BigInteger>, O> paramField, ArrayList<BigInteger> paramArrayList)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramArrayList);
      return;
    }
    zab(paramField, paramField.zapv, paramArrayList);
  }
  
  protected void zac(Field<?, ?> paramField, String paramString, ArrayList<Long> paramArrayList)
  {
    throw new UnsupportedOperationException("Long list not supported");
  }
  
  public final <O> void zac(Field<ArrayList<Long>, O> paramField, ArrayList<Long> paramArrayList)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramArrayList);
      return;
    }
    zac(paramField, paramField.zapv, paramArrayList);
  }
  
  protected void zad(Field<?, ?> paramField, String paramString, ArrayList<Float> paramArrayList)
  {
    throw new UnsupportedOperationException("Float list not supported");
  }
  
  public final <O> void zad(Field<ArrayList<Float>, O> paramField, ArrayList<Float> paramArrayList)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramArrayList);
      return;
    }
    zad(paramField, paramField.zapv, paramArrayList);
  }
  
  protected void zae(Field<?, ?> paramField, String paramString, ArrayList<Double> paramArrayList)
  {
    throw new UnsupportedOperationException("Double list not supported");
  }
  
  public final <O> void zae(Field<ArrayList<Double>, O> paramField, ArrayList<Double> paramArrayList)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramArrayList);
      return;
    }
    zae(paramField, paramField.zapv, paramArrayList);
  }
  
  protected void zaf(Field<?, ?> paramField, String paramString, ArrayList<BigDecimal> paramArrayList)
  {
    throw new UnsupportedOperationException("BigDecimal list not supported");
  }
  
  public final <O> void zaf(Field<ArrayList<BigDecimal>, O> paramField, ArrayList<BigDecimal> paramArrayList)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramArrayList);
      return;
    }
    zaf(paramField, paramField.zapv, paramArrayList);
  }
  
  protected void zag(Field<?, ?> paramField, String paramString, ArrayList<Boolean> paramArrayList)
  {
    throw new UnsupportedOperationException("Boolean list not supported");
  }
  
  public final <O> void zag(Field<ArrayList<Boolean>, O> paramField, ArrayList<Boolean> paramArrayList)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramArrayList);
      return;
    }
    zag(paramField, paramField.zapv, paramArrayList);
  }
  
  public final <O> void zah(Field<ArrayList<String>, O> paramField, ArrayList<String> paramArrayList)
  {
    if (Field.zaa(paramField) != null)
    {
      zaa(paramField, paramArrayList);
      return;
    }
    setStringsInternal(paramField, paramField.zapv, paramArrayList);
  }
  
  public static class Field<I, O>
    extends AbstractSafeParcelable
  {
    public static final zai CREATOR = new zai();
    private final int zalf;
    protected final int zapr;
    protected final boolean zaps;
    protected final int zapt;
    protected final boolean zapu;
    protected final String zapv;
    protected final int zapw;
    protected final Class<? extends FastJsonResponse> zapx;
    private final String zapy;
    private zak zapz;
    private FastJsonResponse.FieldConverter<I, O> zaqa;
    
    Field(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, String paramString1, int paramInt4, String paramString2, zaa paramzaa)
    {
      this.zalf = paramInt1;
      this.zapr = paramInt2;
      this.zaps = paramBoolean1;
      this.zapt = paramInt3;
      this.zapu = paramBoolean2;
      this.zapv = paramString1;
      this.zapw = paramInt4;
      if (paramString2 == null)
      {
        this.zapx = null;
        this.zapy = null;
      }
      else
      {
        this.zapx = SafeParcelResponse.class;
        this.zapy = paramString2;
      }
      if (paramzaa == null)
      {
        this.zaqa = null;
        return;
      }
      this.zaqa = paramzaa.zaci();
    }
    
    private Field(int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, String paramString, int paramInt3, Class<? extends FastJsonResponse> paramClass, FastJsonResponse.FieldConverter<I, O> paramFieldConverter)
    {
      this.zalf = 1;
      this.zapr = paramInt1;
      this.zaps = paramBoolean1;
      this.zapt = paramInt2;
      this.zapu = paramBoolean2;
      this.zapv = paramString;
      this.zapw = paramInt3;
      this.zapx = paramClass;
      if (paramClass == null) {
        this.zapy = null;
      } else {
        this.zapy = paramClass.getCanonicalName();
      }
      this.zaqa = paramFieldConverter;
    }
    
    public static Field<byte[], byte[]> forBase64(String paramString, int paramInt)
    {
      return new Field(8, false, 8, false, paramString, paramInt, null, null);
    }
    
    public static Field<Boolean, Boolean> forBoolean(String paramString, int paramInt)
    {
      return new Field(6, false, 6, false, paramString, paramInt, null, null);
    }
    
    public static <T extends FastJsonResponse> Field<T, T> forConcreteType(String paramString, int paramInt, Class<T> paramClass)
    {
      return new Field(11, false, 11, false, paramString, paramInt, paramClass, null);
    }
    
    public static <T extends FastJsonResponse> Field<ArrayList<T>, ArrayList<T>> forConcreteTypeArray(String paramString, int paramInt, Class<T> paramClass)
    {
      return new Field(11, true, 11, true, paramString, paramInt, paramClass, null);
    }
    
    public static Field<Double, Double> forDouble(String paramString, int paramInt)
    {
      return new Field(4, false, 4, false, paramString, paramInt, null, null);
    }
    
    public static Field<Float, Float> forFloat(String paramString, int paramInt)
    {
      return new Field(3, false, 3, false, paramString, paramInt, null, null);
    }
    
    public static Field<Integer, Integer> forInteger(String paramString, int paramInt)
    {
      return new Field(0, false, 0, false, paramString, paramInt, null, null);
    }
    
    public static Field<Long, Long> forLong(String paramString, int paramInt)
    {
      return new Field(2, false, 2, false, paramString, paramInt, null, null);
    }
    
    public static Field<String, String> forString(String paramString, int paramInt)
    {
      return new Field(7, false, 7, false, paramString, paramInt, null, null);
    }
    
    public static Field<ArrayList<String>, ArrayList<String>> forStrings(String paramString, int paramInt)
    {
      return new Field(7, true, 7, true, paramString, paramInt, null, null);
    }
    
    public static Field withConverter(String paramString, int paramInt, FastJsonResponse.FieldConverter<?, ?> paramFieldConverter, boolean paramBoolean)
    {
      return new Field(paramFieldConverter.zacj(), paramBoolean, paramFieldConverter.zack(), false, paramString, paramInt, null, paramFieldConverter);
    }
    
    private final String zacm()
    {
      String str2 = this.zapy;
      String str1 = str2;
      if (str2 == null) {
        str1 = null;
      }
      return str1;
    }
    
    private final zaa zaco()
    {
      FastJsonResponse.FieldConverter localFieldConverter = this.zaqa;
      if (localFieldConverter == null) {
        return null;
      }
      return zaa.zaa(localFieldConverter);
    }
    
    public final O convert(I paramI)
    {
      return (O)this.zaqa.convert(paramI);
    }
    
    public final I convertBack(O paramO)
    {
      return (I)this.zaqa.convertBack(paramO);
    }
    
    public int getSafeParcelableFieldId()
    {
      return this.zapw;
    }
    
    public String toString()
    {
      Objects.ToStringHelper localToStringHelper = Objects.toStringHelper(this).add("versionCode", Integer.valueOf(this.zalf)).add("typeIn", Integer.valueOf(this.zapr)).add("typeInArray", Boolean.valueOf(this.zaps)).add("typeOut", Integer.valueOf(this.zapt)).add("typeOutArray", Boolean.valueOf(this.zapu)).add("outputFieldName", this.zapv).add("safeParcelFieldId", Integer.valueOf(this.zapw)).add("concreteTypeName", zacm());
      Object localObject = this.zapx;
      if (localObject != null) {
        localToStringHelper.add("concreteType.class", ((Class)localObject).getCanonicalName());
      }
      localObject = this.zaqa;
      if (localObject != null) {
        localToStringHelper.add("converterName", localObject.getClass().getCanonicalName());
      }
      return localToStringHelper.toString();
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      int i = SafeParcelWriter.beginObjectHeader(paramParcel);
      SafeParcelWriter.writeInt(paramParcel, 1, this.zalf);
      SafeParcelWriter.writeInt(paramParcel, 2, this.zapr);
      SafeParcelWriter.writeBoolean(paramParcel, 3, this.zaps);
      SafeParcelWriter.writeInt(paramParcel, 4, this.zapt);
      SafeParcelWriter.writeBoolean(paramParcel, 5, this.zapu);
      SafeParcelWriter.writeString(paramParcel, 6, this.zapv, false);
      SafeParcelWriter.writeInt(paramParcel, 7, getSafeParcelableFieldId());
      SafeParcelWriter.writeString(paramParcel, 8, zacm(), false);
      SafeParcelWriter.writeParcelable(paramParcel, 9, zaco(), paramInt, false);
      SafeParcelWriter.finishObjectHeader(paramParcel, i);
    }
    
    public final void zaa(zak paramzak)
    {
      this.zapz = paramzak;
    }
    
    public final Field<I, O> zacl()
    {
      return new Field(this.zalf, this.zapr, this.zaps, this.zapt, this.zapu, this.zapv, this.zapw, this.zapy, zaco());
    }
    
    public final boolean zacn()
    {
      return this.zaqa != null;
    }
    
    public final FastJsonResponse zacp()
      throws InstantiationException, IllegalAccessException
    {
      Class localClass = this.zapx;
      if (localClass == SafeParcelResponse.class)
      {
        Preconditions.checkNotNull(this.zapz, "The field mapping dictionary must be set if the concrete type is a SafeParcelResponse object.");
        return new SafeParcelResponse(this.zapz, this.zapy);
      }
      return (FastJsonResponse)localClass.newInstance();
    }
    
    public final Map<String, Field<?, ?>> zacq()
    {
      Preconditions.checkNotNull(this.zapy);
      Preconditions.checkNotNull(this.zapz);
      return this.zapz.zai(this.zapy);
    }
  }
  
  public static abstract interface FieldConverter<I, O>
  {
    public abstract O convert(I paramI);
    
    public abstract I convertBack(O paramO);
    
    public abstract int zacj();
    
    public abstract int zack();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\common\server\response\FastJsonResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */