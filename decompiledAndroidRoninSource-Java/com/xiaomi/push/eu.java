package com.xiaomi.push;

public enum eu
{
  public String a;
  
  static
  {
    jdField_a_of_type_ComXiaomiPushEu = new eu("ACTIVITY", 0, "activity");
    b = new eu("SERVICE_ACTION", 1, "service_action");
    c = new eu("SERVICE_COMPONENT", 2, "service_component");
    eu localeu = new eu("PROVIDER", 3, "provider");
    d = localeu;
    jdField_a_of_type_ArrayOfComXiaomiPushEu = new eu[] { jdField_a_of_type_ComXiaomiPushEu, b, c, localeu };
  }
  
  private eu(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\xiaomi\push\eu.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */