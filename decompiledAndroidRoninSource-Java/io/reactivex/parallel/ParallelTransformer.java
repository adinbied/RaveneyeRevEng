package io.reactivex.parallel;

public abstract interface ParallelTransformer<Upstream, Downstream>
{
  public abstract ParallelFlowable<Downstream> apply(ParallelFlowable<Upstream> paramParallelFlowable);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\io\reactivex\parallel\ParallelTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */