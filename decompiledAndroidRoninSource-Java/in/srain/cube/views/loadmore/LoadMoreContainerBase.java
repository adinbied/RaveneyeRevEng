package in.srain.cube.views.loadmore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.LinearLayout;

public abstract class LoadMoreContainerBase
  extends LinearLayout
  implements LoadMoreContainer
{
  private AbsListView mAbsListView;
  private boolean mAutoLoadMore = true;
  private View mFooterView;
  private boolean mHasMore = false;
  private boolean mIsLoading;
  private boolean mListEmpty = true;
  private boolean mLoadError = false;
  private LoadMoreHandler mLoadMoreHandler;
  private LoadMoreUIHandler mLoadMoreUIHandler;
  private AbsListView.OnScrollListener mOnScrollListener;
  private boolean mShowLoadingForFirstPage = false;
  
  public LoadMoreContainerBase(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoadMoreContainerBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  /* Error */
  private void init()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void onReachBottom()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void tryToPerformLoadMore()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void addFooterView(View paramView);
  
  /* Error */
  public void loadMoreError(int arg1, String arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_2
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void loadMoreFinish(boolean arg1, boolean arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  protected void onFinishInflate()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  protected abstract void removeFooterView(View paramView);
  
  protected abstract AbsListView retrieveAbsListView();
  
  public void setAutoLoadMore(boolean paramBoolean)
  {
    this.mAutoLoadMore = paramBoolean;
  }
  
  public void setLoadMoreHandler(LoadMoreHandler paramLoadMoreHandler)
  {
    this.mLoadMoreHandler = paramLoadMoreHandler;
  }
  
  public void setLoadMoreUIHandler(LoadMoreUIHandler paramLoadMoreUIHandler)
  {
    this.mLoadMoreUIHandler = paramLoadMoreUIHandler;
  }
  
  /* Error */
  public void setLoadMoreView(View arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void setOnScrollListener(AbsListView.OnScrollListener paramOnScrollListener)
  {
    this.mOnScrollListener = paramOnScrollListener;
  }
  
  public void setShowLoadingForFirstPage(boolean paramBoolean)
  {
    this.mShowLoadingForFirstPage = paramBoolean;
  }
  
  /* Error */
  public void useDefaultFooter()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  @Deprecated
  public void useDefaultHeader()
  {
    useDefaultFooter();
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\loadmore\LoadMoreContainerBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */