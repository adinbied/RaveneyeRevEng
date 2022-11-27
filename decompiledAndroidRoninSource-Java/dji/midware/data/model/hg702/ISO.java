package dji.midware.data.model.hg702;

public class ISO
{
  public static String valueToString(int paramInt)
  {
    if (paramInt == -1) {
      return "0";
    }
    paramInt &= 0xFFFFFF;
    if (paramInt == 16777215) {
      return "AUTO";
    }
    return String.valueOf(paramInt);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\hg702\ISO.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */