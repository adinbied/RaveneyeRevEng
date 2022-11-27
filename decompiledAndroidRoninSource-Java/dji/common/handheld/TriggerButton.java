package dji.common.handheld;

public enum TriggerButton
{
  static
  {
    DOUBLE_CLICK = new TriggerButton("DOUBLE_CLICK", 2);
    TRIPLE_CLICK = new TriggerButton("TRIPLE_CLICK", 3);
    TriggerButton localTriggerButton = new TriggerButton("UNKNOWN", 4);
    UNKNOWN = localTriggerButton;
    $VALUES = new TriggerButton[] { IDLE, SINGLE_CLICK, DOUBLE_CLICK, TRIPLE_CLICK, localTriggerButton };
  }
  
  private TriggerButton() {}
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\handheld\TriggerButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */