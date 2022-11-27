package dji.common.airlink;

public class SDRHdOffsetParams
{
  public int pathLossOffset;
  public int rcLinkOffset;
  public int txPowerOffset;
  
  public SDRHdOffsetParams(int paramInt1, int paramInt2, int paramInt3)
  {
    this.pathLossOffset = paramInt1;
    this.rcLinkOffset = paramInt2;
    this.txPowerOffset = paramInt3;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\dji\common\airlink\SDRHdOffsetParams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */