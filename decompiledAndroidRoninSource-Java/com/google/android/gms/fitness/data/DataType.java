package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.collection.ArraySet;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class DataType
  extends AbstractSafeParcelable
  implements ReflectedParcelable
{
  public static final DataType AGGREGATE_ACTIVITY_SUMMARY;
  public static final DataType AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY;
  public static final DataType AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY;
  @Deprecated
  public static final DataType AGGREGATE_CALORIES_CONSUMED;
  public static final DataType AGGREGATE_CALORIES_EXPENDED;
  public static final DataType AGGREGATE_DISTANCE_DELTA;
  public static final DataType AGGREGATE_HEART_POINTS;
  public static final DataType AGGREGATE_HEART_RATE_SUMMARY;
  public static final DataType AGGREGATE_HEIGHT_SUMMARY;
  public static final DataType AGGREGATE_HYDRATION;
  @Deprecated
  public static final Set<DataType> AGGREGATE_INPUT_TYPES;
  public static final DataType AGGREGATE_LOCATION_BOUNDING_BOX;
  public static final DataType AGGREGATE_MOVE_MINUTES;
  public static final DataType AGGREGATE_NUTRITION_SUMMARY;
  public static final DataType AGGREGATE_POWER_SUMMARY;
  public static final DataType AGGREGATE_SPEED_SUMMARY;
  public static final DataType AGGREGATE_STEP_COUNT_DELTA;
  public static final DataType AGGREGATE_WEIGHT_SUMMARY;
  public static final Parcelable.Creator<DataType> CREATOR = new zzl();
  public static final String MIME_TYPE_PREFIX = "vnd.google.fitness.data_type/";
  @Deprecated
  public static final DataType TYPE_ACTIVITY_SAMPLE;
  public static final DataType TYPE_ACTIVITY_SAMPLES;
  public static final DataType TYPE_ACTIVITY_SEGMENT;
  public static final DataType TYPE_BASAL_METABOLIC_RATE;
  public static final DataType TYPE_BODY_FAT_PERCENTAGE;
  @Deprecated
  public static final DataType TYPE_CALORIES_CONSUMED;
  public static final DataType TYPE_CALORIES_EXPENDED;
  public static final DataType TYPE_CYCLING_PEDALING_CADENCE;
  public static final DataType TYPE_CYCLING_PEDALING_CUMULATIVE;
  public static final DataType TYPE_CYCLING_WHEEL_REVOLUTION;
  public static final DataType TYPE_CYCLING_WHEEL_RPM;
  public static final DataType TYPE_DISTANCE_CUMULATIVE;
  public static final DataType TYPE_DISTANCE_DELTA;
  public static final DataType TYPE_HEART_POINTS;
  public static final DataType TYPE_HEART_RATE_BPM;
  public static final DataType TYPE_HEIGHT;
  public static final DataType TYPE_HYDRATION;
  public static final DataType TYPE_LOCATION_SAMPLE;
  public static final DataType TYPE_LOCATION_TRACK;
  public static final DataType TYPE_MOVE_MINUTES;
  public static final DataType TYPE_NUTRITION;
  public static final DataType TYPE_POWER_SAMPLE;
  public static final DataType TYPE_SPEED;
  public static final DataType TYPE_STEP_COUNT_CADENCE;
  public static final DataType TYPE_STEP_COUNT_CUMULATIVE;
  public static final DataType TYPE_STEP_COUNT_DELTA = new DataType("com.google.step_count.delta", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_STEPS });
  public static final DataType TYPE_WEIGHT;
  public static final DataType TYPE_WORKOUT_EXERCISE;
  public static final DataType zzbc;
  public static final DataType zzbd;
  public static final DataType zzbe;
  public static final DataType zzbf;
  public static final DataType zzbg;
  public static final DataType zzbh;
  public static final DataType zzbi;
  public static final DataType zzbj;
  public static final DataType zzbk;
  public static final DataType zzbl;
  public static final DataType zzbm;
  public static final DataType zzbn;
  public static final DataType zzbo;
  public static final DataType zzbp;
  public static final DataType zzbq;
  public static final DataType zzbr;
  private final String name;
  private final List<Field> zzbs;
  private final String zzbt;
  private final String zzbu;
  
  static
  {
    TYPE_STEP_COUNT_CUMULATIVE = new DataType("com.google.step_count.cumulative", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_STEPS });
    zzbc = new DataType("com.google.step_length", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_STEP_LENGTH });
    TYPE_STEP_COUNT_CADENCE = new DataType("com.google.step_count.cadence", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_RPM });
    zzbd = new DataType("com.google.internal.goal", new Field[] { Field.zzck });
    zzbe = new DataType("com.google.internal.prescription_event", new Field[] { Field.zzcl });
    zzbf = new DataType("com.google.internal.symptom", new Field[] { Field.zzcm });
    zzbg = new DataType("com.google.stride_model", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.zzcn });
    TYPE_ACTIVITY_SEGMENT = new DataType("com.google.activity.segment", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_ACTIVITY });
    zzbh = new DataType("com.google.floor_change", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_ACTIVITY, Field.FIELD_CONFIDENCE, Field.zzcp, Field.zzcs });
    TYPE_CALORIES_CONSUMED = new DataType("com.google.calories.consumed", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_CALORIES });
    TYPE_CALORIES_EXPENDED = new DataType("com.google.calories.expended", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_CALORIES });
    TYPE_BASAL_METABOLIC_RATE = new DataType("com.google.calories.bmr", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_CALORIES });
    TYPE_POWER_SAMPLE = new DataType("com.google.power.sample", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_WATTS });
    TYPE_ACTIVITY_SAMPLE = new DataType("com.google.activity.sample", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_ACTIVITY, Field.FIELD_CONFIDENCE });
    TYPE_ACTIVITY_SAMPLES = new DataType("com.google.activity.samples", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_ACTIVITY_CONFIDENCE });
    zzbi = new DataType("com.google.accelerometer", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.zza.zzde, Field.zza.zzdf, Field.zza.zzdg });
    zzbj = new DataType("com.google.sensor.events", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.zzcv, Field.zzcx, Field.zzdb });
    zzbk = new DataType("com.google.sensor.const_rate_events", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.zzcw, Field.zzcy, Field.zzcz, Field.zzda, Field.zzdb });
    TYPE_HEART_RATE_BPM = new DataType("com.google.heart_rate.bpm", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.read", new Field[] { Field.FIELD_BPM });
    TYPE_LOCATION_SAMPLE = new DataType("com.google.location.sample", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", new Field[] { Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE });
    TYPE_LOCATION_TRACK = new DataType("com.google.location.track", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", new Field[] { Field.FIELD_LATITUDE, Field.FIELD_LONGITUDE, Field.FIELD_ACCURACY, Field.FIELD_ALTITUDE });
    TYPE_DISTANCE_DELTA = new DataType("com.google.distance.delta", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", new Field[] { Field.FIELD_DISTANCE });
    TYPE_DISTANCE_CUMULATIVE = new DataType("com.google.distance.cumulative", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", new Field[] { Field.FIELD_DISTANCE });
    TYPE_SPEED = new DataType("com.google.speed", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", new Field[] { Field.FIELD_SPEED });
    TYPE_CYCLING_WHEEL_REVOLUTION = new DataType("com.google.cycling.wheel_revolution.cumulative", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", new Field[] { Field.FIELD_REVOLUTIONS });
    TYPE_CYCLING_WHEEL_RPM = new DataType("com.google.cycling.wheel_revolution.rpm", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", new Field[] { Field.FIELD_RPM });
    TYPE_CYCLING_PEDALING_CUMULATIVE = new DataType("com.google.cycling.pedaling.cumulative", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_REVOLUTIONS });
    TYPE_CYCLING_PEDALING_CADENCE = new DataType("com.google.cycling.pedaling.cadence", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_RPM });
    TYPE_HEIGHT = new DataType("com.google.height", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_HEIGHT });
    TYPE_WEIGHT = new DataType("com.google.weight", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_WEIGHT });
    TYPE_BODY_FAT_PERCENTAGE = new DataType("com.google.body.fat.percentage", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_PERCENTAGE });
    zzbl = new DataType("com.google.body.waist.circumference", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_CIRCUMFERENCE });
    zzbm = new DataType("com.google.body.hip.circumference", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_CIRCUMFERENCE });
    TYPE_NUTRITION = new DataType("com.google.nutrition", "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", new Field[] { Field.FIELD_NUTRIENTS, Field.FIELD_MEAL_TYPE, Field.FIELD_FOOD_ITEM });
    TYPE_HYDRATION = new DataType("com.google.hydration", "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", new Field[] { Field.FIELD_VOLUME });
    TYPE_WORKOUT_EXERCISE = new DataType("com.google.activity.exercise", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_EXERCISE, Field.FIELD_REPETITIONS, Field.FIELD_DURATION, Field.FIELD_RESISTANCE_TYPE, Field.FIELD_RESISTANCE });
    Object localObject = new DataType("com.google.active_minutes", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_DURATION });
    TYPE_MOVE_MINUTES = (DataType)localObject;
    AGGREGATE_MOVE_MINUTES = (DataType)localObject;
    zzbn = new DataType("com.google.device_on_body", new Field[] { Field.zzdc });
    zzbo = new DataType("com.google.internal.primary_device", new Field[] { Field.zzco });
    AGGREGATE_ACTIVITY_SUMMARY = new DataType("com.google.activity.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_ACTIVITY, Field.FIELD_DURATION, Field.FIELD_NUM_SEGMENTS });
    zzbp = new DataType("com.google.floor_change.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.zzci, Field.zzcj, Field.zzcq, Field.zzcr, Field.zzct, Field.zzcu });
    AGGREGATE_BASAL_METABOLIC_RATE_SUMMARY = new DataType("com.google.calories.bmr.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN });
    AGGREGATE_STEP_COUNT_DELTA = TYPE_STEP_COUNT_DELTA;
    AGGREGATE_DISTANCE_DELTA = TYPE_DISTANCE_DELTA;
    AGGREGATE_CALORIES_CONSUMED = TYPE_CALORIES_CONSUMED;
    AGGREGATE_CALORIES_EXPENDED = TYPE_CALORIES_EXPENDED;
    TYPE_HEART_POINTS = new DataType("com.google.heart_minutes", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_INTENSITY });
    AGGREGATE_HEART_POINTS = new DataType("com.google.heart_minutes.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_INTENSITY, Field.FIELD_DURATION });
    AGGREGATE_HEART_RATE_SUMMARY = new DataType("com.google.heart_rate.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN });
    AGGREGATE_LOCATION_BOUNDING_BOX = new DataType("com.google.location.bounding_box", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", new Field[] { Field.FIELD_LOW_LATITUDE, Field.FIELD_LOW_LONGITUDE, Field.FIELD_HIGH_LATITUDE, Field.FIELD_HIGH_LONGITUDE });
    AGGREGATE_POWER_SUMMARY = new DataType("com.google.power.summary", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN });
    AGGREGATE_SPEED_SUMMARY = new DataType("com.google.speed.summary", "https://www.googleapis.com/auth/fitness.location.read", "https://www.googleapis.com/auth/fitness.location.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN });
    AGGREGATE_BODY_FAT_PERCENTAGE_SUMMARY = new DataType("com.google.body.fat.percentage.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN });
    zzbq = new DataType("com.google.body.hip.circumference.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN });
    zzbr = new DataType("com.google.body.waist.circumference.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN });
    AGGREGATE_WEIGHT_SUMMARY = new DataType("com.google.weight.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN });
    AGGREGATE_HEIGHT_SUMMARY = new DataType("com.google.height.summary", "https://www.googleapis.com/auth/fitness.body.read", "https://www.googleapis.com/auth/fitness.body.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN });
    AGGREGATE_NUTRITION_SUMMARY = new DataType("com.google.nutrition.summary", "https://www.googleapis.com/auth/fitness.nutrition.read", "https://www.googleapis.com/auth/fitness.nutrition.write", new Field[] { Field.FIELD_NUTRIENTS, Field.FIELD_MEAL_TYPE });
    AGGREGATE_HYDRATION = TYPE_HYDRATION;
    localObject = new ArraySet();
    AGGREGATE_INPUT_TYPES = (Set)localObject;
    ((Set)localObject).add(TYPE_ACTIVITY_SEGMENT);
    AGGREGATE_INPUT_TYPES.add(TYPE_BASAL_METABOLIC_RATE);
    AGGREGATE_INPUT_TYPES.add(TYPE_BODY_FAT_PERCENTAGE);
    AGGREGATE_INPUT_TYPES.add(zzbm);
    AGGREGATE_INPUT_TYPES.add(zzbl);
    AGGREGATE_INPUT_TYPES.add(TYPE_CALORIES_CONSUMED);
    AGGREGATE_INPUT_TYPES.add(TYPE_CALORIES_EXPENDED);
    AGGREGATE_INPUT_TYPES.add(TYPE_DISTANCE_DELTA);
    AGGREGATE_INPUT_TYPES.add(zzbh);
    AGGREGATE_INPUT_TYPES.add(TYPE_LOCATION_SAMPLE);
    AGGREGATE_INPUT_TYPES.add(TYPE_NUTRITION);
    AGGREGATE_INPUT_TYPES.add(TYPE_HYDRATION);
    AGGREGATE_INPUT_TYPES.add(TYPE_HEART_RATE_BPM);
    AGGREGATE_INPUT_TYPES.add(TYPE_POWER_SAMPLE);
    AGGREGATE_INPUT_TYPES.add(TYPE_SPEED);
    AGGREGATE_INPUT_TYPES.add(TYPE_STEP_COUNT_DELTA);
    AGGREGATE_INPUT_TYPES.add(TYPE_WEIGHT);
  }
  
  public DataType(String paramString1, String paramString2, String paramString3, Field... paramVarArgs)
  {
    this(paramString1, Arrays.asList(paramVarArgs), paramString2, paramString3);
  }
  
  DataType(String paramString1, List<Field> paramList, String paramString2, String paramString3)
  {
    this.name = paramString1;
    this.zzbs = Collections.unmodifiableList(paramList);
    this.zzbt = paramString2;
    this.zzbu = paramString3;
  }
  
  private DataType(String paramString, Field... paramVarArgs)
  {
    this(paramString, Arrays.asList(paramVarArgs), null, null);
  }
  
  public static List<DataType> getAggregatesForInput(DataType paramDataType)
  {
    paramDataType = (List)zza.zzac.get(paramDataType);
    if (paramDataType == null) {
      return Collections.emptyList();
    }
    return Collections.unmodifiableList(paramDataType);
  }
  
  public static String getMimeType(DataType paramDataType)
  {
    paramDataType = String.valueOf(paramDataType.getName());
    if (paramDataType.length() != 0) {
      return "vnd.google.fitness.data_type/".concat(paramDataType);
    }
    return new String("vnd.google.fitness.data_type/");
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof DataType)) {
      return false;
    }
    paramObject = (DataType)paramObject;
    return (this.name.equals(((DataType)paramObject).name)) && (this.zzbs.equals(((DataType)paramObject).zzbs));
  }
  
  public final List<Field> getFields()
  {
    return this.zzbs;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final int hashCode()
  {
    return this.name.hashCode();
  }
  
  public final int indexOf(Field paramField)
  {
    int i = this.zzbs.indexOf(paramField);
    boolean bool;
    if (i >= 0) {
      bool = true;
    } else {
      bool = false;
    }
    Preconditions.checkArgument(bool, "%s not a field of %s", new Object[] { paramField, this });
    return i;
  }
  
  public final String toString()
  {
    return String.format("DataType{%s%s}", new Object[] { this.name, this.zzbs });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeTypedList(paramParcel, 2, getFields(), false);
    SafeParcelWriter.writeString(paramParcel, 3, this.zzbt, false);
    SafeParcelWriter.writeString(paramParcel, 4, this.zzbu, false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public final String zzk()
  {
    return this.zzbt;
  }
  
  public final String zzl()
  {
    return this.zzbu;
  }
  
  public final String zzm()
  {
    if (this.name.startsWith("com.google.")) {
      return this.name.substring(11);
    }
    return this.name;
  }
  
  public static final class zza
  {
    public static final DataType zzbv = new DataType("com.google.internal.session.debug", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.zza.zzdh });
    public static final DataType zzbw = new DataType("com.google.internal.session.v2", "https://www.googleapis.com/auth/fitness.activity.read", "https://www.googleapis.com/auth/fitness.activity.write", new Field[] { Field.zza.zzdi });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\DataType.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */