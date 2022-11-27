package dji.midware.data.model.base;

import dji.midware.interfaces.DJIDataSyncListener;

public abstract interface IExpModeSetter
  extends DJIDataSyncListener
{
  public static final int expMode = 0;
  
  public abstract IExpModeSetter setExpMode(int paramInt);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\data\model\base\IExpModeSetter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */