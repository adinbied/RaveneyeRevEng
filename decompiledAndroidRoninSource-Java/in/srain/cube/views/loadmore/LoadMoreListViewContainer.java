package in.srain.cube.views.loadmore;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;

public class LoadMoreListViewContainer
  extends LoadMoreContainerBase
{
  private ListView mListView;
  
  public LoadMoreListViewContainer(Context paramContext)
  {
    super(paramContext);
  }
  
  public LoadMoreListViewContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void addFooterView(View paramView)
  {
    this.mListView.addFooterView(paramView);
  }
  
  protected void removeFooterView(View paramView)
  {
    this.mListView.removeFooterView(paramView);
  }
  
  protected AbsListView retrieveAbsListView()
  {
    return null;
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\in\srain\cube\views\loadmore\LoadMoreListViewContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */