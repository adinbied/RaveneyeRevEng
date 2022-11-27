package dji.midware.interfaces;

import dji.midware.data.manager.P3.DataBase;

public abstract interface CmdIdInterface
{
  public abstract DataBase getDataBase();
  
  public abstract Class<? extends DataBase> getDataModel();
  
  public abstract boolean isBlock();
  
  public abstract boolean isMix();
  
  public abstract boolean isNeedCcode();
  
  public abstract int value();
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\midware\interfaces\CmdIdInterface.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */