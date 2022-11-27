package lecho.lib.hellocharts.renderer;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.view.Chart;

public class ComboChartRenderer
  extends AbstractChartRenderer
{
  protected List<ChartRenderer> renderers = new ArrayList();
  protected Viewport unionViewport = new Viewport();
  
  public ComboChartRenderer(Context paramContext, Chart paramChart)
  {
    super(paramContext, paramChart);
  }
  
  public boolean checkTouch(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  /* Error */
  public void clearTouch()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void draw(android.graphics.Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void drawUnclipped(android.graphics.Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onChartDataChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onChartSizeChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  public void onChartViewportChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\renderer\ComboChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */