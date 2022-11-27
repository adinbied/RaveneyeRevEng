package dji.midware.data.model.hg702;

import java.text.DecimalFormat;

public class Aperture
{
  private static DecimalFormat decimalFormatFloat = new DecimalFormat("0.0");
  private static DecimalFormat decimalFormatInt = new DecimalFormat("0");
  
  public static String valueToString(int paramInt)
  {
    if (paramInt == -1) {
      return "0";
    }
    float f = paramInt / 100.0F;
    return decimalFormatFloat.format(f);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\hg702\Aperture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */