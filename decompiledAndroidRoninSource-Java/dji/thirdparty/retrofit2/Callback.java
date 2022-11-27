package dji.thirdparty.retrofit2;

public abstract interface Callback<T>
{
  public abstract void onFailure(Call<T> paramCall, Throwable paramThrowable);
  
  public abstract void onResponse(Call<T> paramCall, Response<T> paramResponse);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\dji\thirdparty\retrofit2\Callback.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */