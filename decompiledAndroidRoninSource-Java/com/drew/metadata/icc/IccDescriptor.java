package com.drew.metadata.icc;

import com.drew.lang.ByteArrayReader;
import com.drew.metadata.TagDescriptor;
import java.io.IOException;

public class IccDescriptor
  extends TagDescriptor<IccDirectory>
{
  private static final int ICC_TAG_TYPE_CURV = 1668641398;
  private static final int ICC_TAG_TYPE_DESC = 1684370275;
  private static final int ICC_TAG_TYPE_MEAS = 1835360627;
  private static final int ICC_TAG_TYPE_MLUC = 1835824483;
  private static final int ICC_TAG_TYPE_SIG = 1936287520;
  private static final int ICC_TAG_TYPE_TEXT = 1952807028;
  private static final int ICC_TAG_TYPE_XYZ_ARRAY = 1482250784;
  
  public IccDescriptor(IccDirectory paramIccDirectory)
  {
    super(paramIccDirectory);
  }
  
  public static String formatDoubleAsString(double paramDouble, int paramInt, boolean paramBoolean)
  {
    String str = "";
    int i = 1;
    if (paramInt < 1)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append(Math.round(paramDouble));
      return ((StringBuilder)localObject1).toString();
    }
    long l3 = Math.abs(paramDouble);
    long l2 = (int)Math.round((Math.abs(paramDouble) - l3) * Math.pow(10.0D, paramInt));
    Object localObject1 = "";
    long l1 = l2;
    while (paramInt > 0)
    {
      int j = (byte)(int)Math.abs(l1 % 10L);
      l1 /= 10L;
      if ((((String)localObject1).length() <= 0) && (!paramBoolean) && (j == 0))
      {
        localObject2 = localObject1;
        if (paramInt != 1) {}
      }
      else
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(j);
        ((StringBuilder)localObject2).append((String)localObject1);
        localObject2 = ((StringBuilder)localObject2).toString();
      }
      paramInt -= 1;
      localObject1 = localObject2;
    }
    l1 = l3 + l1;
    if (paramDouble < 0.0D)
    {
      paramInt = i;
      if (l1 != 0L) {
        break label216;
      }
      if (l2 != 0L)
      {
        paramInt = i;
        break label216;
      }
    }
    paramInt = 0;
    label216:
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = str;
    if (paramInt != 0) {
      localObject2 = "-";
    }
    localStringBuilder.append((String)localObject2);
    localStringBuilder.append(l1);
    localStringBuilder.append(".");
    localStringBuilder.append((String)localObject1);
    return localStringBuilder.toString();
  }
  
  private static int getInt32FromString(String paramString)
    throws IOException
  {
    return new ByteArrayReader(paramString.getBytes()).getInt32(0);
  }
  
  private String getPlatformDescription()
  {
    return null;
  }
  
  private String getProfileClassDescription()
  {
    return null;
  }
  
  private String getProfileVersionDescription()
  {
    return null;
  }
  
  private String getRenderingIntentDescription()
  {
    return null;
  }
  
  private String getTagDataString(int paramInt)
  {
    return null;
  }
  
  public String getDescription(int paramInt)
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\drew\metadata\icc\IccDescriptor.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */