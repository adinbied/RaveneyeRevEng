package dji.midware.data.model.base;

import dji.midware.data.model.P3.DataCameraGetIso.TYPE;
import dji.midware.interfaces.DJIDataSyncListener;

public abstract interface IExpISOSetter
  extends DJIDataSyncListener
{
  public abstract IExpISOSetter setAbsValue(DataCameraGetIso.TYPE paramTYPE);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\base\IExpISOSetter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */