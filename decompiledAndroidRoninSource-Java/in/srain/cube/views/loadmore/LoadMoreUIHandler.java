package in.srain.cube.views.loadmore;

public abstract interface LoadMoreUIHandler
{
  public abstract void onLoadError(LoadMoreContainer paramLoadMoreContainer, int paramInt, String paramString);
  
  public abstract void onLoadFinish(LoadMoreContainer paramLoadMoreContainer, boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void onLoading(LoadMoreContainer paramLoadMoreContainer);
  
  public abstract void onWaitToLoadMore(LoadMoreContainer paramLoadMoreContainer);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\loadmore\LoadMoreUIHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */