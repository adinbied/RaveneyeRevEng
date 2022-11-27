package dji.midware.data.model.hg702;

import dji.midware.util.BytesUtil;
import java.text.DecimalFormat;

public class EV
{
  private static DecimalFormat decimalFormatFloat = new DecimalFormat("0.0");
  private static DecimalFormat decimalFormatInt = new DecimalFormat("0");
  
  public static String valueToString(int paramInt)
  {
    if (paramInt == -1) {
      return "0";
    }
    byte[] arrayOfByte = BytesUtil.getBytes(paramInt);
    paramInt = ((Short)BytesUtil.get(arrayOfByte, 2, 2, Short.class)).shortValue();
    int i = ((Short)BytesUtil.get(arrayOfByte, 0, 2, Short.class)).shortValue();
    if (i == 0) {
      return "0";
    }
    if (paramInt % i == 0) {
      return decimalFormatInt.format(paramInt / i);
    }
    return decimalFormatFloat.format(paramInt / i);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\hg702\EV.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */