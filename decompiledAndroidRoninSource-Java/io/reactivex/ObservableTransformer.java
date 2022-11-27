package io.reactivex;

public abstract interface ObservableTransformer<Upstream, Downstream>
{
  public abstract ObservableSource<Downstream> apply(Observable<Upstream> paramObservable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\ObservableTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */