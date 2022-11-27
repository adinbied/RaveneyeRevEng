package lecho.lib.hellocharts.renderer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.provider.ColumnChartDataProvider;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;

public class ColumnChartRenderer
  extends AbstractChartRenderer
{
  public static final int DEFAULT_COLUMN_TOUCH_ADDITIONAL_WIDTH_DP = 4;
  public static final int DEFAULT_SUBCOLUMN_SPACING_DP = 1;
  private static final int MODE_CHECK_TOUCH = 1;
  private static final int MODE_DRAW = 0;
  private static final int MODE_HIGHLIGHT = 2;
  private float baseValue;
  private Paint columnPaint = new Paint();
  private ColumnChartDataProvider dataProvider;
  private RectF drawRect = new RectF();
  private float fillRatio;
  private int subcolumnSpacing;
  private Viewport tempMaximumViewport = new Viewport();
  private int touchAdditionalWidth;
  private PointF touchedPoint = new PointF();
  
  public ColumnChartRenderer(Context paramContext, Chart paramChart, ColumnChartDataProvider paramColumnChartDataProvider)
  {
    super(paramContext, paramChart);
    this.dataProvider = paramColumnChartDataProvider;
    this.subcolumnSpacing = ChartUtils.dp2px(this.density, 1);
    this.touchAdditionalWidth = ChartUtils.dp2px(this.density, 4);
    this.columnPaint.setAntiAlias(true);
    this.columnPaint.setStyle(Paint.Style.FILL);
    this.columnPaint.setStrokeCap(Paint.Cap.SQUARE);
  }
  
  private float calculateColumnWidth()
  {
    return 0.0F;
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
  private void calculateMaxViewportForStacked(lecho.lib.hellocharts.model.ColumnChartData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void calculateMaxViewportForSubcolumns(lecho.lib.hellocharts.model.ColumnChartData arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void calculateRectToDraw(lecho.lib.hellocharts.model.SubcolumnValue arg1, float arg2, float arg3, float arg4, float arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void checkRectToDraw(int arg1, int arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void checkTouchForStacked(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void checkTouchForSubcolumns(float arg1, float arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_3
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawColumnForStacked(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawColumnsForSubcolumns(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawLabel(Canvas arg1, lecho.lib.hellocharts.model.Column arg2, lecho.lib.hellocharts.model.SubcolumnValue arg3, boolean arg4, float arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawSubcolumn(Canvas arg1, lecho.lib.hellocharts.model.Column arg2, lecho.lib.hellocharts.model.SubcolumnValue arg3, boolean arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void highlightColumnForStacked(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void highlightColumnsForSubcolumns(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void highlightSubcolumn(Canvas arg1, lecho.lib.hellocharts.model.Column arg2, lecho.lib.hellocharts.model.SubcolumnValue arg3, int arg4, boolean arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void processColumnForStacked(Canvas arg1, lecho.lib.hellocharts.model.Column arg2, float arg3, int arg4, int arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void processColumnForSubcolumns(Canvas arg1, lecho.lib.hellocharts.model.Column arg2, float arg3, int arg4, int arg5)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
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
  
  public void onChartSizeChanged() {}
  
  /* Error */
  public void onChartViewportChanged()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\renderer\ColumnChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */