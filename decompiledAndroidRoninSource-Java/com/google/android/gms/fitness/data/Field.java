package com.google.android.gms.fitness.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

public final class Field
  extends AbstractSafeParcelable
{
  public static final Parcelable.Creator<Field> CREATOR = new zzq();
  public static final Field FIELD_ACCURACY;
  public static final Field FIELD_ACTIVITY = zzd("activity");
  public static final Field FIELD_ACTIVITY_CONFIDENCE;
  public static final Field FIELD_ALTITUDE;
  public static final Field FIELD_AVERAGE;
  public static final Field FIELD_BPM;
  public static final Field FIELD_CALORIES;
  public static final Field FIELD_CIRCUMFERENCE;
  public static final Field FIELD_CONFIDENCE = zzf("confidence");
  public static final Field FIELD_DISTANCE;
  public static final Field FIELD_DURATION;
  public static final Field FIELD_EXERCISE;
  public static final Field FIELD_FOOD_ITEM;
  public static final Field FIELD_HEIGHT;
  public static final Field FIELD_HIGH_LATITUDE;
  public static final Field FIELD_HIGH_LONGITUDE;
  public static final Field FIELD_INTENSITY;
  public static final Field FIELD_LATITUDE;
  public static final Field FIELD_LONGITUDE;
  public static final Field FIELD_LOW_LATITUDE;
  public static final Field FIELD_LOW_LONGITUDE;
  public static final Field FIELD_MAX;
  public static final Field FIELD_MEAL_TYPE;
  public static final Field FIELD_MIN;
  public static final Field FIELD_NUM_SEGMENTS;
  public static final Field FIELD_NUTRIENTS;
  public static final Field FIELD_OCCURRENCES;
  public static final Field FIELD_PERCENTAGE;
  public static final Field FIELD_REPETITIONS;
  public static final Field FIELD_RESISTANCE;
  public static final Field FIELD_RESISTANCE_TYPE;
  public static final Field FIELD_REVOLUTIONS;
  public static final Field FIELD_RPM;
  public static final Field FIELD_SPEED;
  public static final Field FIELD_STEPS;
  public static final Field FIELD_STEP_LENGTH;
  public static final Field FIELD_VOLUME;
  public static final Field FIELD_WATTS;
  public static final Field FIELD_WEIGHT;
  public static final int FORMAT_FLOAT = 2;
  public static final int FORMAT_INT32 = 1;
  public static final int FORMAT_MAP = 4;
  public static final int FORMAT_STRING = 3;
  public static final int MEAL_TYPE_BREAKFAST = 1;
  public static final int MEAL_TYPE_DINNER = 3;
  public static final int MEAL_TYPE_LUNCH = 2;
  public static final int MEAL_TYPE_SNACK = 4;
  public static final int MEAL_TYPE_UNKNOWN = 0;
  public static final String NUTRIENT_CALCIUM = "calcium";
  public static final String NUTRIENT_CALORIES = "calories";
  public static final String NUTRIENT_CHOLESTEROL = "cholesterol";
  public static final String NUTRIENT_DIETARY_FIBER = "dietary_fiber";
  public static final String NUTRIENT_IRON = "iron";
  public static final String NUTRIENT_MONOUNSATURATED_FAT = "fat.monounsaturated";
  public static final String NUTRIENT_POLYUNSATURATED_FAT = "fat.polyunsaturated";
  public static final String NUTRIENT_POTASSIUM = "potassium";
  public static final String NUTRIENT_PROTEIN = "protein";
  public static final String NUTRIENT_SATURATED_FAT = "fat.saturated";
  public static final String NUTRIENT_SODIUM = "sodium";
  public static final String NUTRIENT_SUGAR = "sugar";
  public static final String NUTRIENT_TOTAL_CARBS = "carbs.total";
  public static final String NUTRIENT_TOTAL_FAT = "fat.total";
  public static final String NUTRIENT_TRANS_FAT = "fat.trans";
  public static final String NUTRIENT_UNSATURATED_FAT = "fat.unsaturated";
  public static final String NUTRIENT_VITAMIN_A = "vitamin_a";
  public static final String NUTRIENT_VITAMIN_C = "vitamin_c";
  public static final int RESISTANCE_TYPE_BARBELL = 1;
  public static final int RESISTANCE_TYPE_BODY = 6;
  public static final int RESISTANCE_TYPE_CABLE = 2;
  public static final int RESISTANCE_TYPE_DUMBBELL = 3;
  public static final int RESISTANCE_TYPE_KETTLEBELL = 4;
  public static final int RESISTANCE_TYPE_MACHINE = 5;
  public static final int RESISTANCE_TYPE_UNKNOWN = 0;
  private static final Field zzcg;
  private static final Field zzch;
  public static final Field zzci;
  public static final Field zzcj;
  public static final Field zzck;
  public static final Field zzcl;
  public static final Field zzcm;
  public static final Field zzcn;
  public static final Field zzco;
  public static final Field zzcp;
  public static final Field zzcq;
  public static final Field zzcr;
  public static final Field zzcs;
  public static final Field zzct;
  public static final Field zzcu;
  public static final Field zzcv;
  public static final Field zzcw;
  public static final Field zzcx;
  public static final Field zzcy;
  public static final Field zzcz;
  public static final Field zzda;
  public static final Field zzdb;
  public static final Field zzdc;
  private final int format;
  private final String name;
  private final Boolean zzdd;
  
  static
  {
    FIELD_ACTIVITY_CONFIDENCE = zzh("activity_confidence");
    FIELD_STEPS = zzd("steps");
    FIELD_STEP_LENGTH = zzf("step_length");
    FIELD_DURATION = zzd("duration");
    zzcg = zze("duration");
    zzch = zzh("activity_duration");
    zzci = zzh("activity_duration.ascending");
    zzcj = zzh("activity_duration.descending");
    FIELD_BPM = zzf("bpm");
    FIELD_LATITUDE = zzf("latitude");
    FIELD_LONGITUDE = zzf("longitude");
    FIELD_ACCURACY = zzf("accuracy");
    FIELD_ALTITUDE = new Field("altitude", 2, Boolean.valueOf(true));
    FIELD_DISTANCE = zzf("distance");
    FIELD_HEIGHT = zzf("height");
    FIELD_WEIGHT = zzf("weight");
    FIELD_CIRCUMFERENCE = zzf("circumference");
    FIELD_PERCENTAGE = zzf("percentage");
    FIELD_SPEED = zzf("speed");
    FIELD_RPM = zzf("rpm");
    zzck = zzi("google.android.fitness.GoalV2");
    zzcl = zzi("prescription_event");
    zzcm = zzi("symptom");
    zzcn = zzi("google.android.fitness.StrideModel");
    zzco = zzi("google.android.fitness.Device");
    FIELD_REVOLUTIONS = zzd("revolutions");
    FIELD_CALORIES = zzf("calories");
    FIELD_WATTS = zzf("watts");
    FIELD_VOLUME = zzf("volume");
    FIELD_MEAL_TYPE = zzd("meal_type");
    FIELD_FOOD_ITEM = zzg("food_item");
    FIELD_NUTRIENTS = zzh("nutrients");
    zzcp = zzf("elevation.change");
    zzcq = zzh("elevation.gain");
    zzcr = zzh("elevation.loss");
    zzcs = zzf("floors");
    zzct = zzh("floor.gain");
    zzcu = zzh("floor.loss");
    FIELD_EXERCISE = zzg("exercise");
    FIELD_REPETITIONS = zzd("repetitions");
    FIELD_RESISTANCE = zzf("resistance");
    FIELD_RESISTANCE_TYPE = zzd("resistance_type");
    FIELD_NUM_SEGMENTS = zzd("num_segments");
    FIELD_AVERAGE = zzf("average");
    FIELD_MAX = zzf("max");
    FIELD_MIN = zzf("min");
    FIELD_LOW_LATITUDE = zzf("low_latitude");
    FIELD_LOW_LONGITUDE = zzf("low_longitude");
    FIELD_HIGH_LATITUDE = zzf("high_latitude");
    FIELD_HIGH_LONGITUDE = zzf("high_longitude");
    FIELD_OCCURRENCES = zzd("occurrences");
    zzcv = zzd("sensor_type");
    zzcw = zzd("sensor_types");
    zzcx = new Field("timestamps", 5);
    zzcy = zzd("sample_period");
    zzcz = zzd("num_samples");
    zzda = zzd("num_dimensions");
    zzdb = new Field("sensor_values", 6);
    FIELD_INTENSITY = zzf("intensity");
    zzdc = zzf("probability");
  }
  
  private Field(String paramString, int paramInt)
  {
    this(paramString, paramInt, null);
  }
  
  Field(String paramString, int paramInt, Boolean paramBoolean)
  {
    this.name = ((String)Preconditions.checkNotNull(paramString));
    this.format = paramInt;
    this.zzdd = paramBoolean;
  }
  
  public static Field zza(String paramString, int paramInt)
  {
    switch (paramString.hashCode())
    {
    default: 
      break;
    case 2078370221: 
      if (paramString.equals("supplemental_oxygen_flow_rate")) {
        i = 72;
      }
      break;
    case 2072582505: 
      if (paramString.equals("cervical_firmness")) {
        i = 25;
      }
      break;
    case 2056323544: 
      if (paramString.equals("exercise")) {
        i = 37;
      }
      break;
    case 2036550306: 
      if (paramString.equals("altitude")) {
        i = 6;
      }
      break;
    case 2020153105: 
      if (paramString.equals("blood_pressure_systolic_average")) {
        i = 16;
      }
      break;
    case 1983072038: 
      if (paramString.equals("body_position")) {
        i = 19;
      }
      break;
    case 1958191296: 
      if (paramString.equals("supplemental_oxygen_flow_rate_min")) {
        i = 75;
      }
      break;
    case 1958191058: 
      if (paramString.equals("supplemental_oxygen_flow_rate_max")) {
        i = 74;
      }
      break;
    case 1892583496: 
      if (paramString.equals("menstrual_flow")) {
        i = 52;
      }
      break;
    case 1880897007: 
      if (paramString.equals("oxygen_therapy_administration_mode")) {
        i = 66;
      }
      break;
    case 1863800889: 
      if (paramString.equals("resistance")) {
        i = 80;
      }
      break;
    case 1857897492: 
      if (paramString.equals("elevation.loss")) {
        i = 36;
      }
      break;
    case 1857734768: 
      if (paramString.equals("elevation.gain")) {
        i = 35;
      }
      break;
    case 1708915229: 
      if (paramString.equals("timestamps")) {
        i = 67;
      }
      break;
    case 1527920799: 
      if (paramString.equals("sensor_type")) {
        i = 69;
      }
      break;
    case 1403812882: 
      if (paramString.equals("blood_pressure_diastolic_min")) {
        i = 13;
      }
      break;
    case 1403812644: 
      if (paramString.equals("blood_pressure_diastolic_max")) {
        i = 12;
      }
      break;
    case 1284575460: 
      if (paramString.equals("oxygen_saturation_min")) {
        i = 64;
      }
      break;
    case 1284575222: 
      if (paramString.equals("oxygen_saturation_max")) {
        i = 62;
      }
      break;
    case 1276952063: 
      if (paramString.equals("blood_pressure_diastolic")) {
        i = 10;
      }
      break;
    case 1136011766: 
      if (paramString.equals("sample_period")) {
        i = 68;
      }
      break;
    case 998412730: 
      if (paramString.equals("activity_confidence")) {
        i = 2;
      }
      break;
    case 984367650: 
      if (paramString.equals("repetitions")) {
        i = 79;
      }
      break;
    case 883161687: 
      if (paramString.equals("body_temperature")) {
        i = 20;
      }
      break;
    case 833248065: 
      if (paramString.equals("temporal_relation_to_meal")) {
        i = 89;
      }
      break;
    case 829251210: 
      if (paramString.equals("confidence")) {
        i = 30;
      }
      break;
    case 815736413: 
      if (paramString.equals("oxygen_saturation_system")) {
        i = 65;
      }
      break;
    case 811264586: 
      if (paramString.equals("revolutions")) {
        i = 82;
      }
      break;
    case 784486594: 
      if (paramString.equals("occurrences")) {
        i = 58;
      }
      break;
    case 738210934: 
      if (paramString.equals("google.android.fitness.StrideModel")) {
        i = 88;
      }
      break;
    case 623947695: 
      if (paramString.equals("oxygen_saturation_average")) {
        i = 61;
      }
      break;
    case 581888402: 
      if (paramString.equals("cervical_mucus_amount")) {
        i = 26;
      }
      break;
    case 514168969: 
      if (paramString.equals("google.android.fitness.GoalV2")) {
        i = 87;
      }
      break;
    case 499324979: 
      if (paramString.equals("intensity")) {
        i = 43;
      }
      break;
    case 475560262: 
      if (paramString.equals("blood_pressure_systolic_min")) {
        i = 18;
      }
      break;
    case 475560024: 
      if (paramString.equals("blood_pressure_systolic_max")) {
        i = 17;
      }
      break;
    case 455965230: 
      if (paramString.equals("activity_duration.ascending")) {
        i = 4;
      }
      break;
    case 419669488: 
      if (paramString.equals("google.android.fitness.Device")) {
        i = 31;
      }
      break;
    case 320627489: 
      if (paramString.equals("cervical_mucus_texture")) {
        i = 27;
      }
      break;
    case 306600408: 
      if (paramString.equals("google.android.fitness.SessionV2")) {
        i = 98;
      }
      break;
    case 292126261: 
      if (paramString.equals("prescription_event")) {
        i = 76;
      }
      break;
    case 288459765: 
      if (paramString.equals("distance")) {
        i = 32;
      }
      break;
    case 286612066: 
      if (paramString.equals("activity_duration.descending")) {
        i = 5;
      }
      break;
    case 248891292: 
      if (paramString.equals("blood_glucose_specimen_source")) {
        i = 9;
      }
      break;
    case 220648413: 
      if (paramString.equals("blood_pressure_diastolic_average")) {
        i = 11;
      }
      break;
    case 198162679: 
      if (paramString.equals("low_latitude")) {
        i = 48;
      }
      break;
    case 137365935: 
      if (paramString.equals("longitude")) {
        i = 47;
      }
      break;
    case 120904628: 
      if (paramString.equals("sensor_types")) {
        i = 70;
      }
      break;
    case 112903913: 
      if (paramString.equals("watts")) {
        i = 92;
      }
      break;
    case 109761319: 
      if (paramString.equals("steps")) {
        i = 85;
      }
      break;
    case 109641799: 
      if (paramString.equals("speed")) {
        i = 84;
      }
      break;
    case 66639641: 
      if (paramString.equals("temporal_relation_to_sleep")) {
        i = 90;
      }
      break;
    case 113135: 
      if (paramString.equals("rpm")) {
        i = 83;
      }
      break;
    case 108114: 
      if (paramString.equals("min")) {
        i = 53;
      }
      break;
    case 107876: 
      if (paramString.equals("max")) {
        i = 50;
      }
      break;
    case 97759: 
      if (paramString.equals("bpm")) {
        i = 22;
      }
      break;
    case 122: 
      if (paramString.equals("z")) {
        i = 96;
      }
      break;
    case 121: 
      if (paramString.equals("y")) {
        i = 95;
      }
      break;
    case 120: 
      if (paramString.equals("x")) {
        i = 94;
      }
      break;
    case -28590302: 
      if (paramString.equals("ovulation_test_result")) {
        i = 59;
      }
      break;
    case -126538880: 
      if (paramString.equals("resistance_type")) {
        i = 81;
      }
      break;
    case -168965370: 
      if (paramString.equals("calories")) {
        i = 23;
      }
      break;
    case -228366862: 
      if (paramString.equals("oxygen_saturation_measurement_method")) {
        i = 63;
      }
      break;
    case -266093204: 
      if (paramString.equals("nutrients")) {
        i = 57;
      }
      break;
    case -277306353: 
      if (paramString.equals("circumference")) {
        i = 29;
      }
      break;
    case -437053898: 
      if (paramString.equals("meal_type")) {
        i = 51;
      }
      break;
    case -452643911: 
      if (paramString.equals("step_length")) {
        i = 86;
      }
      break;
    case -494782871: 
      if (paramString.equals("high_latitude")) {
        i = 44;
      }
      break;
    case -511934137: 
      if (paramString.equals("sensor_values")) {
        i = 71;
      }
      break;
    case -619868540: 
      if (paramString.equals("low_longitude")) {
        i = 49;
      }
      break;
    case -626344110: 
      if (paramString.equals("high_longitude")) {
        i = 45;
      }
      break;
    case -631448035: 
      if (paramString.equals("average")) {
        i = 7;
      }
      break;
    case -791592328: 
      if (paramString.equals("weight")) {
        i = 93;
      }
      break;
    case -803244749: 
      if (paramString.equals("blood_pressure_systolic")) {
        i = 15;
      }
      break;
    case -810883302: 
      if (paramString.equals("volume")) {
        i = 91;
      }
      break;
    case -918978307: 
      if (paramString.equals("cervical_position")) {
        i = 28;
      }
      break;
    case -921832806: 
      if (paramString.equals("percentage")) {
        i = 78;
      }
      break;
    case -1110756780: 
      if (paramString.equals("food_item")) {
        i = 41;
      }
      break;
    case -1129337776: 
      if (paramString.equals("num_samples")) {
        i = 55;
      }
      break;
    case -1133736764: 
      if (paramString.equals("activity_duration")) {
        i = 3;
      }
      break;
    case -1220952307: 
      if (paramString.equals("blood_pressure_measurement_location")) {
        i = 14;
      }
      break;
    case -1221029593: 
      if (paramString.equals("height")) {
        i = 42;
      }
      break;
    case -1248595573: 
      if (paramString.equals("supplemental_oxygen_flow_rate_average")) {
        i = 73;
      }
      break;
    case -1271636505: 
      if (paramString.equals("floors")) {
        i = 40;
      }
      break;
    case -1290561483: 
      if (paramString.equals("probability")) {
        i = 99;
      }
      break;
    case -1352492506: 
      if (paramString.equals("num_dimensions")) {
        i = 54;
      }
      break;
    case -1439978388: 
      if (paramString.equals("latitude")) {
        i = 46;
      }
      break;
    case -1440707631: 
      if (paramString.equals("oxygen_saturation")) {
        i = 60;
      }
      break;
    case -1531570079: 
      if (paramString.equals("elevation.change")) {
        i = 34;
      }
      break;
    case -1569430471: 
      if (paramString.equals("num_segments")) {
        i = 56;
      }
      break;
    case -1579449403: 
      if (paramString.equals("floor.loss")) {
        i = 39;
      }
      break;
    case -1579612127: 
      if (paramString.equals("floor.gain")) {
        i = 38;
      }
      break;
    case -1595712862: 
      if (paramString.equals("cervical_dilation")) {
        i = 24;
      }
      break;
    case -1655966961: 
      if (paramString.equals("activity")) {
        i = 1;
      }
      break;
    case -1743016407: 
      if (paramString.equals("symptom")) {
        i = 77;
      }
      break;
    case -1859447186: 
      if (paramString.equals("blood_glucose_level")) {
        i = 8;
      }
      break;
    case -1992012396: 
      if (paramString.equals("duration")) {
        i = 33;
      }
      break;
    case -2006370880: 
      if (paramString.equals("body_temperature_measurement_location")) {
        i = 21;
      }
      break;
    case -2083865430: 
      if (paramString.equals("debug_session")) {
        i = 97;
      }
      break;
    case -2131707655: 
      if (paramString.equals("accuracy")) {
        i = 0;
      }
      break;
    }
    int i = -1;
    switch (i)
    {
    default: 
      return new Field(paramString, paramInt, null);
    case 99: 
      return zzdc;
    case 98: 
      return zza.zzdi;
    case 97: 
      return zza.zzdh;
    case 96: 
      return zza.zzdg;
    case 95: 
      return zza.zzdf;
    case 94: 
      return zza.zzde;
    case 93: 
      return FIELD_WEIGHT;
    case 92: 
      return FIELD_WATTS;
    case 91: 
      return FIELD_VOLUME;
    case 90: 
      return HealthFields.FIELD_TEMPORAL_RELATION_TO_SLEEP;
    case 89: 
      return HealthFields.FIELD_TEMPORAL_RELATION_TO_MEAL;
    case 88: 
      return zzcn;
    case 87: 
      return zzck;
    case 86: 
      return FIELD_STEP_LENGTH;
    case 85: 
      return FIELD_STEPS;
    case 84: 
      return FIELD_SPEED;
    case 83: 
      return FIELD_RPM;
    case 82: 
      return FIELD_REVOLUTIONS;
    case 81: 
      return FIELD_RESISTANCE_TYPE;
    case 80: 
      return FIELD_RESISTANCE;
    case 79: 
      return FIELD_REPETITIONS;
    case 78: 
      return FIELD_PERCENTAGE;
    case 77: 
      return zzcm;
    case 76: 
      return zzcl;
    case 75: 
      return HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MIN;
    case 74: 
      return HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MAX;
    case 73: 
      return HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_AVERAGE;
    case 72: 
      return HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE;
    case 71: 
      return zzdb;
    case 70: 
      return zzcw;
    case 69: 
      return zzcv;
    case 68: 
      return zzcy;
    case 67: 
      return zzcx;
    case 66: 
      return HealthFields.FIELD_OXYGEN_THERAPY_ADMINISTRATION_MODE;
    case 65: 
      return HealthFields.FIELD_OXYGEN_SATURATION_SYSTEM;
    case 64: 
      return HealthFields.FIELD_OXYGEN_SATURATION_MIN;
    case 63: 
      return HealthFields.FIELD_OXYGEN_SATURATION_MEASUREMENT_METHOD;
    case 62: 
      return HealthFields.FIELD_OXYGEN_SATURATION_MAX;
    case 61: 
      return HealthFields.FIELD_OXYGEN_SATURATION_AVERAGE;
    case 60: 
      return HealthFields.FIELD_OXYGEN_SATURATION;
    case 59: 
      return HealthFields.FIELD_OVULATION_TEST_RESULT;
    case 58: 
      return FIELD_OCCURRENCES;
    case 57: 
      return FIELD_NUTRIENTS;
    case 56: 
      return FIELD_NUM_SEGMENTS;
    case 55: 
      return zzcz;
    case 54: 
      return zzda;
    case 53: 
      return FIELD_MIN;
    case 52: 
      return HealthFields.FIELD_MENSTRUAL_FLOW;
    case 51: 
      return FIELD_MEAL_TYPE;
    case 50: 
      return FIELD_MAX;
    case 49: 
      return FIELD_LOW_LONGITUDE;
    case 48: 
      return FIELD_LOW_LATITUDE;
    case 47: 
      return FIELD_LONGITUDE;
    case 46: 
      return FIELD_LATITUDE;
    case 45: 
      return FIELD_HIGH_LONGITUDE;
    case 44: 
      return FIELD_HIGH_LATITUDE;
    case 43: 
      return FIELD_INTENSITY;
    case 42: 
      return FIELD_HEIGHT;
    case 41: 
      return FIELD_FOOD_ITEM;
    case 40: 
      return zzcs;
    case 39: 
      return zzcu;
    case 38: 
      return zzct;
    case 37: 
      return FIELD_EXERCISE;
    case 36: 
      return zzcr;
    case 35: 
      return zzcq;
    case 34: 
      return zzcp;
    case 33: 
      return FIELD_DURATION;
    case 32: 
      return FIELD_DISTANCE;
    case 31: 
      return zzco;
    case 30: 
      return FIELD_CONFIDENCE;
    case 29: 
      return FIELD_CIRCUMFERENCE;
    case 28: 
      return HealthFields.FIELD_CERVICAL_POSITION;
    case 27: 
      return HealthFields.FIELD_CERVICAL_MUCUS_TEXTURE;
    case 26: 
      return HealthFields.FIELD_CERVICAL_MUCUS_AMOUNT;
    case 25: 
      return HealthFields.FIELD_CERVICAL_FIRMNESS;
    case 24: 
      return HealthFields.FIELD_CERVICAL_DILATION;
    case 23: 
      return FIELD_CALORIES;
    case 22: 
      return FIELD_BPM;
    case 21: 
      return HealthFields.FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION;
    case 20: 
      return HealthFields.FIELD_BODY_TEMPERATURE;
    case 19: 
      return HealthFields.FIELD_BODY_POSITION;
    case 18: 
      return HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MIN;
    case 17: 
      return HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MAX;
    case 16: 
      return HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_AVERAGE;
    case 15: 
      return HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC;
    case 14: 
      return HealthFields.FIELD_BLOOD_PRESSURE_MEASUREMENT_LOCATION;
    case 13: 
      return HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MIN;
    case 12: 
      return HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MAX;
    case 11: 
      return HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_AVERAGE;
    case 10: 
      return HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC;
    case 9: 
      return HealthFields.FIELD_BLOOD_GLUCOSE_SPECIMEN_SOURCE;
    case 8: 
      return HealthFields.FIELD_BLOOD_GLUCOSE_LEVEL;
    case 7: 
      return FIELD_AVERAGE;
    case 6: 
      return FIELD_ALTITUDE;
    case 5: 
      return zzcj;
    case 4: 
      return zzci;
    case 3: 
      return zzch;
    case 2: 
      return FIELD_ACTIVITY_CONFIDENCE;
    case 1: 
      return FIELD_ACTIVITY;
    }
    return FIELD_ACCURACY;
  }
  
  private static Field zzd(String paramString)
  {
    return new Field(paramString, 1);
  }
  
  static Field zze(String paramString)
  {
    return new Field(paramString, 1, Boolean.valueOf(true));
  }
  
  static Field zzf(String paramString)
  {
    return new Field(paramString, 2);
  }
  
  private static Field zzg(String paramString)
  {
    return new Field(paramString, 3);
  }
  
  private static Field zzh(String paramString)
  {
    return new Field(paramString, 4);
  }
  
  private static Field zzi(String paramString)
  {
    return new Field(paramString, 7);
  }
  
  static Field zzj(String paramString)
  {
    return new Field(paramString, 7, Boolean.valueOf(true));
  }
  
  public final boolean equals(Object paramObject)
  {
    if (paramObject == this) {
      return true;
    }
    if (!(paramObject instanceof Field)) {
      return false;
    }
    paramObject = (Field)paramObject;
    return (this.name.equals(((Field)paramObject).name)) && (this.format == ((Field)paramObject).format);
  }
  
  public final int getFormat()
  {
    return this.format;
  }
  
  public final String getName()
  {
    return this.name;
  }
  
  public final int hashCode()
  {
    return this.name.hashCode();
  }
  
  public final Boolean isOptional()
  {
    return this.zzdd;
  }
  
  public final String toString()
  {
    String str2 = this.name;
    String str1;
    if (this.format == 1) {
      str1 = "i";
    } else {
      str1 = "f";
    }
    return String.format("%s(%s)", new Object[] { str2, str1 });
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramInt = SafeParcelWriter.beginObjectHeader(paramParcel);
    SafeParcelWriter.writeString(paramParcel, 1, getName(), false);
    SafeParcelWriter.writeInt(paramParcel, 2, getFormat());
    SafeParcelWriter.writeBooleanObject(paramParcel, 3, isOptional(), false);
    SafeParcelWriter.finishObjectHeader(paramParcel, paramInt);
  }
  
  public static final class zza
  {
    public static final Field zzde = Field.zzf("x");
    public static final Field zzdf = Field.zzf("y");
    public static final Field zzdg = Field.zzf("z");
    public static final Field zzdh = Field.zzj("debug_session");
    public static final Field zzdi = Field.zzj("google.android.fitness.SessionV2");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\Field.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */