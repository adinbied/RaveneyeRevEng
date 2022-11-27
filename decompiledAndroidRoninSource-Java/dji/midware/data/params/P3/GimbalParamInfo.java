package dji.midware.data.params.P3;

public class GimbalParamInfo
  extends ParamInfo
{
  public String strValue = "";
  
  public static GimbalParamInfo copyOf(ParamInfo paramParamInfo)
  {
    if (paramParamInfo == null) {
      return null;
    }
    GimbalParamInfo localGimbalParamInfo = new GimbalParamInfo();
    localGimbalParamInfo.index = paramParamInfo.index;
    localGimbalParamInfo.typeId = paramParamInfo.typeId;
    localGimbalParamInfo.type = paramParamInfo.type;
    localGimbalParamInfo.size = paramParamInfo.size;
    localGimbalParamInfo.attribute = paramParamInfo.attribute;
    localGimbalParamInfo.range = paramParamInfo.range;
    localGimbalParamInfo.value = paramParamInfo.value;
    localGimbalParamInfo.setvalue = paramParamInfo.setvalue;
    localGimbalParamInfo.name = paramParamInfo.name;
    return localGimbalParamInfo;
  }
  
  public String toString()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\params\P3\GimbalParamInfo.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */