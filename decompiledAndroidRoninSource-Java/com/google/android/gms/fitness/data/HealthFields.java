package com.google.android.gms.fitness.data;

public final class HealthFields
{
  public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_CAPILLARY_BLOOD = 2;
  public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_INTERSTITIAL_FLUID = 1;
  public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_PLASMA = 3;
  public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_SERUM = 4;
  public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_TEARS = 5;
  public static final int BLOOD_GLUCOSE_SPECIMEN_SOURCE_WHOLE_BLOOD = 6;
  public static final int BLOOD_PRESSURE_MEASUREMENT_LOCATION_LEFT_UPPER_ARM = 3;
  public static final int BLOOD_PRESSURE_MEASUREMENT_LOCATION_LEFT_WRIST = 1;
  public static final int BLOOD_PRESSURE_MEASUREMENT_LOCATION_RIGHT_UPPER_ARM = 4;
  public static final int BLOOD_PRESSURE_MEASUREMENT_LOCATION_RIGHT_WRIST = 2;
  public static final int BODY_POSITION_LYING_DOWN = 3;
  public static final int BODY_POSITION_SEMI_RECUMBENT = 4;
  public static final int BODY_POSITION_SITTING = 2;
  public static final int BODY_POSITION_STANDING = 1;
  public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_AXILLARY = 1;
  public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_FINGER = 2;
  public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_FOREHEAD = 3;
  public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_ORAL = 4;
  public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_RECTAL = 5;
  public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_TEMPORAL_ARTERY = 6;
  public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_TOE = 7;
  public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_TYMPANIC = 8;
  public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_VAGINAL = 10;
  public static final int BODY_TEMPERATURE_MEASUREMENT_LOCATION_WRIST = 9;
  public static final int CERVICAL_DILATION_CLOSED = 1;
  public static final int CERVICAL_DILATION_MEDIUM = 2;
  public static final int CERVICAL_DILATION_OPEN = 3;
  public static final int CERVICAL_FIRMNESS_FIRM = 3;
  public static final int CERVICAL_FIRMNESS_MEDIUM = 2;
  public static final int CERVICAL_FIRMNESS_SOFT = 1;
  public static final int CERVICAL_MUCUS_AMOUNT_HEAVY = 3;
  public static final int CERVICAL_MUCUS_AMOUNT_LIGHT = 1;
  public static final int CERVICAL_MUCUS_AMOUNT_MEDIUM = 2;
  public static final int CERVICAL_MUCUS_TEXTURE_CREAMY = 3;
  public static final int CERVICAL_MUCUS_TEXTURE_DRY = 1;
  public static final int CERVICAL_MUCUS_TEXTURE_EGG_WHITE = 5;
  public static final int CERVICAL_MUCUS_TEXTURE_STICKY = 2;
  public static final int CERVICAL_MUCUS_TEXTURE_WATERY = 4;
  public static final int CERVICAL_POSITION_HIGH = 3;
  public static final int CERVICAL_POSITION_LOW = 1;
  public static final int CERVICAL_POSITION_MEDIUM = 2;
  public static final Field FIELD_BLOOD_GLUCOSE_LEVEL;
  public static final Field FIELD_BLOOD_GLUCOSE_SPECIMEN_SOURCE;
  public static final Field FIELD_BLOOD_PRESSURE_DIASTOLIC;
  public static final Field FIELD_BLOOD_PRESSURE_DIASTOLIC_AVERAGE;
  public static final Field FIELD_BLOOD_PRESSURE_DIASTOLIC_MAX;
  public static final Field FIELD_BLOOD_PRESSURE_DIASTOLIC_MIN;
  public static final Field FIELD_BLOOD_PRESSURE_MEASUREMENT_LOCATION;
  public static final Field FIELD_BLOOD_PRESSURE_SYSTOLIC = Field.zzf("blood_pressure_systolic");
  public static final Field FIELD_BLOOD_PRESSURE_SYSTOLIC_AVERAGE = Field.zzf("blood_pressure_systolic_average");
  public static final Field FIELD_BLOOD_PRESSURE_SYSTOLIC_MAX;
  public static final Field FIELD_BLOOD_PRESSURE_SYSTOLIC_MIN = Field.zzf("blood_pressure_systolic_min");
  public static final Field FIELD_BODY_POSITION;
  public static final Field FIELD_BODY_TEMPERATURE;
  public static final Field FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION;
  public static final Field FIELD_CERVICAL_DILATION = Field.zze("cervical_dilation");
  public static final Field FIELD_CERVICAL_FIRMNESS = Field.zze("cervical_firmness");
  public static final Field FIELD_CERVICAL_MUCUS_AMOUNT;
  public static final Field FIELD_CERVICAL_MUCUS_TEXTURE;
  public static final Field FIELD_CERVICAL_POSITION;
  public static final Field FIELD_MENSTRUAL_FLOW = Field.zze("menstrual_flow");
  public static final Field FIELD_OVULATION_TEST_RESULT = Field.zze("ovulation_test_result");
  public static final Field FIELD_OXYGEN_SATURATION;
  public static final Field FIELD_OXYGEN_SATURATION_AVERAGE;
  public static final Field FIELD_OXYGEN_SATURATION_MAX;
  public static final Field FIELD_OXYGEN_SATURATION_MEASUREMENT_METHOD;
  public static final Field FIELD_OXYGEN_SATURATION_MIN;
  public static final Field FIELD_OXYGEN_SATURATION_SYSTEM;
  public static final Field FIELD_OXYGEN_THERAPY_ADMINISTRATION_MODE;
  public static final Field FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE;
  public static final Field FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_AVERAGE;
  public static final Field FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MAX;
  public static final Field FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MIN;
  public static final Field FIELD_TEMPORAL_RELATION_TO_MEAL;
  public static final int FIELD_TEMPORAL_RELATION_TO_MEAL_AFTER_MEAL = 4;
  public static final int FIELD_TEMPORAL_RELATION_TO_MEAL_BEFORE_MEAL = 3;
  public static final int FIELD_TEMPORAL_RELATION_TO_MEAL_FASTING = 2;
  public static final int FIELD_TEMPORAL_RELATION_TO_MEAL_GENERAL = 1;
  public static final Field FIELD_TEMPORAL_RELATION_TO_SLEEP;
  public static final int MENSTRUAL_FLOW_HEAVY = 4;
  public static final int MENSTRUAL_FLOW_LIGHT = 2;
  public static final int MENSTRUAL_FLOW_MEDIUM = 3;
  public static final int MENSTRUAL_FLOW_SPOTTING = 1;
  public static final int OVULATION_TEST_RESULT_NEGATIVE = 1;
  public static final int OVULATION_TEST_RESULT_POSITIVE = 2;
  public static final int OXYGEN_SATURATION_MEASUREMENT_METHOD_PULSE_OXIMETRY = 1;
  public static final int OXYGEN_SATURATION_SYSTEM_PERIPHERAL_CAPILLARY = 1;
  public static final int OXYGEN_THERAPY_ADMINISTRATION_MODE_NASAL_CANULA = 1;
  public static final int TEMPORAL_RELATION_TO_SLEEP_BEFORE_SLEEP = 2;
  public static final int TEMPORAL_RELATION_TO_SLEEP_DURING_SLEEP = 4;
  public static final int TEMPORAL_RELATION_TO_SLEEP_FULLY_AWAKE = 1;
  public static final int TEMPORAL_RELATION_TO_SLEEP_ON_WAKING = 3;
  
  static
  {
    FIELD_BLOOD_PRESSURE_SYSTOLIC_MAX = Field.zzf("blood_pressure_systolic_max");
    FIELD_BLOOD_PRESSURE_DIASTOLIC = Field.zzf("blood_pressure_diastolic");
    FIELD_BLOOD_PRESSURE_DIASTOLIC_AVERAGE = Field.zzf("blood_pressure_diastolic_average");
    FIELD_BLOOD_PRESSURE_DIASTOLIC_MIN = Field.zzf("blood_pressure_diastolic_min");
    FIELD_BLOOD_PRESSURE_DIASTOLIC_MAX = Field.zzf("blood_pressure_diastolic_max");
    FIELD_BODY_POSITION = Field.zze("body_position");
    FIELD_BLOOD_PRESSURE_MEASUREMENT_LOCATION = Field.zze("blood_pressure_measurement_location");
    FIELD_BLOOD_GLUCOSE_LEVEL = Field.zzf("blood_glucose_level");
    FIELD_TEMPORAL_RELATION_TO_MEAL = Field.zze("temporal_relation_to_meal");
    FIELD_TEMPORAL_RELATION_TO_SLEEP = Field.zze("temporal_relation_to_sleep");
    FIELD_BLOOD_GLUCOSE_SPECIMEN_SOURCE = Field.zze("blood_glucose_specimen_source");
    FIELD_OXYGEN_SATURATION = Field.zzf("oxygen_saturation");
    FIELD_OXYGEN_SATURATION_AVERAGE = Field.zzf("oxygen_saturation_average");
    FIELD_OXYGEN_SATURATION_MIN = Field.zzf("oxygen_saturation_min");
    FIELD_OXYGEN_SATURATION_MAX = Field.zzf("oxygen_saturation_max");
    FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE = Field.zzf("supplemental_oxygen_flow_rate");
    FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_AVERAGE = Field.zzf("supplemental_oxygen_flow_rate_average");
    FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MIN = Field.zzf("supplemental_oxygen_flow_rate_min");
    FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MAX = Field.zzf("supplemental_oxygen_flow_rate_max");
    FIELD_OXYGEN_THERAPY_ADMINISTRATION_MODE = Field.zze("oxygen_therapy_administration_mode");
    FIELD_OXYGEN_SATURATION_SYSTEM = Field.zze("oxygen_saturation_system");
    FIELD_OXYGEN_SATURATION_MEASUREMENT_METHOD = Field.zze("oxygen_saturation_measurement_method");
    FIELD_BODY_TEMPERATURE = Field.zzf("body_temperature");
    FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION = Field.zze("body_temperature_measurement_location");
    FIELD_CERVICAL_MUCUS_TEXTURE = Field.zze("cervical_mucus_texture");
    FIELD_CERVICAL_MUCUS_AMOUNT = Field.zze("cervical_mucus_amount");
    FIELD_CERVICAL_POSITION = Field.zze("cervical_position");
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\HealthFields.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */