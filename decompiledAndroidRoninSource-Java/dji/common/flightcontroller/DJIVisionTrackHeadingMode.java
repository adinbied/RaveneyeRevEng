package dji.common.flightcontroller;

public enum DJIVisionTrackHeadingMode
{
  private final int data;
  
  static
  {
    DJIVisionTrackHeadingMode localDJIVisionTrackHeadingMode = new DJIVisionTrackHeadingMode("OTHER", 2, 100);
    OTHER = localDJIVisionTrackHeadingMode;
    $VALUES = new DJIVisionTrackHeadingMode[] { FOLLOW, FORWARD, localDJIVisionTrackHeadingMode };
  }
  
  private DJIVisionTrackHeadingMode(int paramInt)
  {
    this.data = paramInt;
  }
  
  public static DJIVisionTrackHeadingMode find(int paramInt)
  {
    DJIVisionTrackHeadingMode localDJIVisionTrackHeadingMode1 = FOLLOW;
    DJIVisionTrackHeadingMode[] arrayOfDJIVisionTrackHeadingMode = values();
    int j = arrayOfDJIVisionTrackHeadingMode.length;
    int i = 0;
    while (i < j)
    {
      DJIVisionTrackHeadingMode localDJIVisionTrackHeadingMode2 = arrayOfDJIVisionTrackHeadingMode[i];
      if (localDJIVisionTrackHeadingMode2._equals(paramInt)) {
        return localDJIVisionTrackHeadingMode2;
      }
      i += 1;
    }
    return localDJIVisionTrackHeadingMode1;
  }
  
  public boolean _equals(int paramInt)
  {
    return this.data == paramInt;
  }
  
  public int value()
  {
    return this.data;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\flightcontroller\DJIVisionTrackHeadingMode.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */