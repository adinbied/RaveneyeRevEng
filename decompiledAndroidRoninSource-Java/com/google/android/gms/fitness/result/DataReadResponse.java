package com.google.android.gms.fitness.result;

import com.google.android.gms.common.api.Response;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.fitness.data.Bucket;
import com.google.android.gms.fitness.data.DataSet;
import com.google.android.gms.fitness.data.DataSource;
import com.google.android.gms.fitness.data.DataType;
import java.util.List;

public class DataReadResponse
  extends Response<DataReadResult>
{
  public DataReadResponse() {}
  
  protected DataReadResponse(DataReadResult paramDataReadResult)
  {
    super(paramDataReadResult);
  }
  
  public List<Bucket> getBuckets()
  {
    return ((DataReadResult)getResult()).getBuckets();
  }
  
  public DataSet getDataSet(DataSource paramDataSource)
  {
    return ((DataReadResult)getResult()).getDataSet(paramDataSource);
  }
  
  public DataSet getDataSet(DataType paramDataType)
  {
    return ((DataReadResult)getResult()).getDataSet(paramDataType);
  }
  
  public List<DataSet> getDataSets()
  {
    return ((DataReadResult)getResult()).getDataSets();
  }
  
  public Status getStatus()
  {
    return ((DataReadResult)getResult()).getStatus();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x89a2c000-dex2jar.jar!\com\google\android\gms\fitness\result\DataReadResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */