package com.google.android.gms.fitness.data;

public final class HealthDataTypes
{
  public static final DataType AGGREGATE_BASAL_BODY_TEMPERATURE_SUMMARY = new DataType("com.google.body.temperature.basal.summary", "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN, HealthFields.FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION });
  public static final DataType AGGREGATE_BLOOD_GLUCOSE_SUMMARY;
  public static final DataType AGGREGATE_BLOOD_PRESSURE_SUMMARY;
  public static final DataType AGGREGATE_BODY_TEMPERATURE_SUMMARY;
  public static final DataType AGGREGATE_OXYGEN_SATURATION_SUMMARY;
  public static final DataType TYPE_BASAL_BODY_TEMPERATURE;
  public static final DataType TYPE_BLOOD_GLUCOSE;
  public static final DataType TYPE_BLOOD_PRESSURE = new DataType("com.google.blood_pressure", "https://www.googleapis.com/auth/fitness.blood_pressure.read", "https://www.googleapis.com/auth/fitness.blood_pressure.write", new Field[] { HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC, HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC, HealthFields.FIELD_BODY_POSITION, HealthFields.FIELD_BLOOD_PRESSURE_MEASUREMENT_LOCATION });
  public static final DataType TYPE_BODY_TEMPERATURE;
  public static final DataType TYPE_CERVICAL_MUCUS;
  public static final DataType TYPE_CERVICAL_POSITION;
  public static final DataType TYPE_MENSTRUATION;
  public static final DataType TYPE_OVULATION_TEST;
  public static final DataType TYPE_OXYGEN_SATURATION;
  public static final DataType TYPE_VAGINAL_SPOTTING;
  
  static
  {
    TYPE_BLOOD_GLUCOSE = new DataType("com.google.blood_glucose", "https://www.googleapis.com/auth/fitness.blood_glucose.read", "https://www.googleapis.com/auth/fitness.blood_glucose.write", new Field[] { HealthFields.FIELD_BLOOD_GLUCOSE_LEVEL, HealthFields.FIELD_TEMPORAL_RELATION_TO_MEAL, Field.FIELD_MEAL_TYPE, HealthFields.FIELD_TEMPORAL_RELATION_TO_SLEEP, HealthFields.FIELD_BLOOD_GLUCOSE_SPECIMEN_SOURCE });
    TYPE_OXYGEN_SATURATION = new DataType("com.google.oxygen_saturation", "https://www.googleapis.com/auth/fitness.oxygen_saturation.read", "https://www.googleapis.com/auth/fitness.oxygen_saturation.write", new Field[] { HealthFields.FIELD_OXYGEN_SATURATION, HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE, HealthFields.FIELD_OXYGEN_THERAPY_ADMINISTRATION_MODE, HealthFields.FIELD_OXYGEN_SATURATION_SYSTEM, HealthFields.FIELD_OXYGEN_SATURATION_MEASUREMENT_METHOD });
    TYPE_BODY_TEMPERATURE = new DataType("com.google.body.temperature", "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", new Field[] { HealthFields.FIELD_BODY_TEMPERATURE, HealthFields.FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION });
    TYPE_BASAL_BODY_TEMPERATURE = new DataType("com.google.body.temperature.basal", "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { HealthFields.FIELD_BODY_TEMPERATURE, HealthFields.FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION });
    TYPE_CERVICAL_MUCUS = new DataType("com.google.cervical_mucus", "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { HealthFields.FIELD_CERVICAL_MUCUS_TEXTURE, HealthFields.FIELD_CERVICAL_MUCUS_AMOUNT });
    TYPE_CERVICAL_POSITION = new DataType("com.google.cervical_position", "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { HealthFields.FIELD_CERVICAL_POSITION, HealthFields.FIELD_CERVICAL_DILATION, HealthFields.FIELD_CERVICAL_FIRMNESS });
    TYPE_MENSTRUATION = new DataType("com.google.menstruation", "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { HealthFields.FIELD_MENSTRUAL_FLOW });
    TYPE_OVULATION_TEST = new DataType("com.google.ovulation_test", "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { HealthFields.FIELD_OVULATION_TEST_RESULT });
    TYPE_VAGINAL_SPOTTING = new DataType("com.google.vaginal_spotting", "https://www.googleapis.com/auth/fitness.reproductive_health.read", "https://www.googleapis.com/auth/fitness.reproductive_health.write", new Field[] { Field.FIELD_OCCURRENCES });
    AGGREGATE_BLOOD_PRESSURE_SUMMARY = new DataType("com.google.blood_pressure.summary", "https://www.googleapis.com/auth/fitness.blood_pressure.read", "https://www.googleapis.com/auth/fitness.blood_pressure.write", new Field[] { HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_AVERAGE, HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MAX, HealthFields.FIELD_BLOOD_PRESSURE_SYSTOLIC_MIN, HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_AVERAGE, HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MAX, HealthFields.FIELD_BLOOD_PRESSURE_DIASTOLIC_MIN, HealthFields.FIELD_BODY_POSITION, HealthFields.FIELD_BLOOD_PRESSURE_MEASUREMENT_LOCATION });
    AGGREGATE_BLOOD_GLUCOSE_SUMMARY = new DataType("com.google.blood_glucose.summary", "https://www.googleapis.com/auth/fitness.blood_glucose.read", "https://www.googleapis.com/auth/fitness.blood_glucose.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN, HealthFields.FIELD_TEMPORAL_RELATION_TO_MEAL, Field.FIELD_MEAL_TYPE, HealthFields.FIELD_TEMPORAL_RELATION_TO_SLEEP, HealthFields.FIELD_BLOOD_GLUCOSE_SPECIMEN_SOURCE });
    AGGREGATE_OXYGEN_SATURATION_SUMMARY = new DataType("com.google.oxygen_saturation.summary", "https://www.googleapis.com/auth/fitness.oxygen_saturation.read", "https://www.googleapis.com/auth/fitness.oxygen_saturation.write", new Field[] { HealthFields.FIELD_OXYGEN_SATURATION_AVERAGE, HealthFields.FIELD_OXYGEN_SATURATION_MAX, HealthFields.FIELD_OXYGEN_SATURATION_MIN, HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_AVERAGE, HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MAX, HealthFields.FIELD_SUPPLEMENTAL_OXYGEN_FLOW_RATE_MIN, HealthFields.FIELD_OXYGEN_THERAPY_ADMINISTRATION_MODE, HealthFields.FIELD_OXYGEN_SATURATION_SYSTEM, HealthFields.FIELD_OXYGEN_SATURATION_MEASUREMENT_METHOD });
    AGGREGATE_BODY_TEMPERATURE_SUMMARY = new DataType("com.google.body.temperature.summary", "https://www.googleapis.com/auth/fitness.body_temperature.read", "https://www.googleapis.com/auth/fitness.body_temperature.write", new Field[] { Field.FIELD_AVERAGE, Field.FIELD_MAX, Field.FIELD_MIN, HealthFields.FIELD_BODY_TEMPERATURE_MEASUREMENT_LOCATION });
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\data\HealthDataTypes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */