package dji.midware.data.model.hg702;

import dji.midware.util.BytesUtil;
import java.text.DecimalFormat;

public class Shutter
{
  private static final int SHUTTER_VALUE_BULB = 2047;
  private static DecimalFormat decimalFormatFloat = new DecimalFormat("0.0");
  private static DecimalFormat decimalFormatInt = new DecimalFormat("0");
  
  public static String valueToString(int paramInt)
  {
    if (paramInt == -1) {
      return "0";
    }
    if ((paramInt != 0) && (paramInt != 2047))
    {
      Object localObject = BytesUtil.getBytes(paramInt);
      paramInt = ((Integer)BytesUtil.get((byte[])localObject, 2, 2, Integer.class)).intValue();
      int i = ((Integer)BytesUtil.get((byte[])localObject, 0, 2, Integer.class)).intValue();
      if (i == 0) {
        return "0";
      }
      if (paramInt < i)
      {
        if ((i == 10) && (paramInt != 1))
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append(decimalFormatFloat.format(paramInt / i));
          ((StringBuilder)localObject).append("''");
          return ((StringBuilder)localObject).toString();
        }
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append("/");
        ((StringBuilder)localObject).append(i);
        return ((StringBuilder)localObject).toString();
      }
      if (paramInt % i == 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(decimalFormatInt.format(paramInt / i));
        ((StringBuilder)localObject).append("''");
        return ((StringBuilder)localObject).toString();
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(decimalFormatFloat.format(paramInt / i));
      ((StringBuilder)localObject).append("''");
      return ((StringBuilder)localObject).toString();
    }
    return "BULB";
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\hg702\Shutter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */