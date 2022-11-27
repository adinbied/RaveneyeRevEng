package dji.common.handheld;

public enum RecordAndShutterButtons
{
  static
  {
    RECORD_CLICK = new RecordAndShutterButtons("RECORD_CLICK", 2);
    SHUTTER_LONG_CLICK = new RecordAndShutterButtons("SHUTTER_LONG_CLICK", 3);
    RecordAndShutterButtons localRecordAndShutterButtons = new RecordAndShutterButtons("UNKNOWN", 4);
    UNKNOWN = localRecordAndShutterButtons;
    $VALUES = new RecordAndShutterButtons[] { IDLE, SHUTTER_CLICK, RECORD_CLICK, SHUTTER_LONG_CLICK, localRecordAndShutterButtons };
  }
  
  private RecordAndShutterButtons() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\handheld\RecordAndShutterButtons.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */