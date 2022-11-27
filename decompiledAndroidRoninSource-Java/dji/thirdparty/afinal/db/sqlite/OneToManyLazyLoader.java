package dji.thirdparty.afinal.db.sqlite;

import dji.thirdparty.afinal.FinalDb;
import java.util.List;

public class OneToManyLazyLoader<O, M>
{
  FinalDb db;
  List<M> entities;
  Class<M> listItemClazz;
  Class<O> ownerClazz;
  O ownerEntity;
  
  public OneToManyLazyLoader(O paramO, Class<O> paramClass, Class<M> paramClass1, FinalDb paramFinalDb)
  {
    this.ownerEntity = paramO;
    this.ownerClazz = paramClass;
    this.listItemClazz = paramClass1;
    this.db = paramFinalDb;
  }
  
  public List<M> getList()
  {
    return null;
  }
  
  public void setList(List<M> paramList)
  {
    this.entities = paramList;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\afinal\db\sqlite\OneToManyLazyLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */