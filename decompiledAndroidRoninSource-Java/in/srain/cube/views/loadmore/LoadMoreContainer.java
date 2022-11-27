package in.srain.cube.views.loadmore;

import android.view.View;
import android.widget.AbsListView.OnScrollListener;

public abstract interface LoadMoreContainer
{
  public abstract void loadMoreError(int paramInt, String paramString);
  
  public abstract void loadMoreFinish(boolean paramBoolean1, boolean paramBoolean2);
  
  public abstract void setAutoLoadMore(boolean paramBoolean);
  
  public abstract void setLoadMoreHandler(LoadMoreHandler paramLoadMoreHandler);
  
  public abstract void setLoadMoreUIHandler(LoadMoreUIHandler paramLoadMoreUIHandler);
  
  public abstract void setLoadMoreView(View paramView);
  
  public abstract void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener);
  
  public abstract void setShowLoadingForFirstPage(boolean paramBoolean);
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\loadmore\LoadMoreContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */