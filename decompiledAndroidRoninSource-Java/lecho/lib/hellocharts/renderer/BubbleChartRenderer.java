package lecho.lib.hellocharts.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import lecho.lib.hellocharts.formatter.BubbleChartValueFormatter;
import lecho.lib.hellocharts.model.BubbleValue;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.provider.BubbleChartDataProvider;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;

public class BubbleChartRenderer
  extends AbstractChartRenderer
{
  private static final int DEFAULT_TOUCH_ADDITIONAL_DP = 4;
  private static final int MODE_DRAW = 0;
  private static final int MODE_HIGHLIGHT = 1;
  private PointF bubbleCenter = new PointF();
  private Paint bubblePaint = new Paint();
  private RectF bubbleRect = new RectF();
  private float bubbleScaleX;
  private float bubbleScaleY;
  private BubbleChartDataProvider dataProvider;
  private boolean hasLabels;
  private boolean hasLabelsOnlyForSelected;
  private boolean isBubbleScaledByX = true;
  private float maxRadius;
  private float minRawRadius;
  private Viewport tempMaximumViewport = new Viewport();
  private int touchAdditional;
  private BubbleChartValueFormatter valueFormatter;
  
  public BubbleChartRenderer(Context paramContext, Chart paramChart, BubbleChartDataProvider paramBubbleChartDataProvider)
  {
    super(paramContext, paramChart);
    this.dataProvider = paramBubbleChartDataProvider;
    this.touchAdditional = ChartUtils.dp2px(this.density, 4);
    this.bubblePaint.setAntiAlias(true);
    this.bubblePaint.setStyle(Paint.Style.FILL);
  }
  
  /* Error */
  private void calculateMaxViewport()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawBubble(Canvas arg1, BubbleValue arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawBubbleShapeAndLabel(Canvas arg1, BubbleValue arg2, float arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawBubbles(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawLabel(Canvas arg1, BubbleValue arg2, float arg3, float arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void highlightBubble(Canvas arg1, BubbleValue arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void highlightBubbles(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private float processBubble(BubbleValue paramBubbleValue, PointF paramPointF)
  {
    return 0.0F;
  }
  
  public boolean checkTouch(float paramFloat1, float paramFloat2)
  {
    return false;
  }
  
  /* Error */
  public void draw(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  public void drawUnclipped(Canvas paramCanvas) {}
  
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
  
  /* Error */
  public void removeMargins()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\renderer\BubbleChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */