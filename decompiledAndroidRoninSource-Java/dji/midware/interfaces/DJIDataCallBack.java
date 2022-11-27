package dji.midware.interfaces;

import dji.midware.data.config.P3.Ccode;

public abstract interface DJIDataCallBack
{
  public abstract void onFailure(Ccode paramCcode);
  
  public abstract void onSuccess(Object paramObject);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\interfaces\DJIDataCallBack.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */