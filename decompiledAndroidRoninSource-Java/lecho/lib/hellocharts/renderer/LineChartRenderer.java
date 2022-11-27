package lecho.lib.hellocharts.renderer;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Shader;
import lecho.lib.hellocharts.model.Line;
import lecho.lib.hellocharts.model.Viewport;
import lecho.lib.hellocharts.provider.LineChartDataProvider;
import lecho.lib.hellocharts.util.ChartUtils;
import lecho.lib.hellocharts.view.Chart;

public class LineChartRenderer
  extends AbstractChartRenderer
{
  private static final int DEFAULT_LINE_STROKE_WIDTH_DP = 3;
  private static final int DEFAULT_TOUCH_TOLERANCE_MARGIN_DP = 4;
  private static final float LINE_SMOOTHNESS = 0.16F;
  private static final int MODE_DRAW = 0;
  private static final int MODE_HIGHLIGHT = 1;
  private float baseValue;
  private int checkPrecision;
  private LineChartDataProvider dataProvider;
  private Paint linePaint = new Paint();
  private Path path = new Path();
  private Paint pointPaint = new Paint();
  private Bitmap softwareBitmap;
  private Canvas softwareCanvas = new Canvas();
  private Viewport tempMaximumViewport = new Viewport();
  private int touchToleranceMargin;
  
  public LineChartRenderer(Context paramContext, Chart paramChart, LineChartDataProvider paramLineChartDataProvider)
  {
    super(paramContext, paramChart);
    this.dataProvider = paramLineChartDataProvider;
    this.touchToleranceMargin = ChartUtils.dp2px(this.density, 4);
    this.linePaint.setAntiAlias(true);
    this.linePaint.setStyle(Paint.Style.STROKE);
    this.linePaint.setStrokeCap(Paint.Cap.ROUND);
    this.linePaint.setStrokeWidth(ChartUtils.dp2px(this.density, 3));
    this.pointPaint.setAntiAlias(true);
    this.pointPaint.setStyle(Paint.Style.FILL);
    this.checkPrecision = ChartUtils.dp2px(this.density, 2);
  }
  
  private int calculateContentRectInternalMargin()
  {
    return 0;
  }
  
  /* Error */
  private void calculateMaxViewport()
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean checkIfShouldDrawPoints(Line paramLine)
  {
    return false;
  }
  
  /* Error */
  private void drawArea(Canvas arg1, Line arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawLabel(Canvas arg1, Line arg2, lecho.lib.hellocharts.model.PointValue arg3, float arg4, float arg5, float arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawPath(Canvas arg1, Line arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawPoint(Canvas arg1, Line arg2, lecho.lib.hellocharts.model.PointValue arg3, float arg4, float arg5, float arg6)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawPoints(Canvas arg1, Line arg2, int arg3, int arg4)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawSmoothPath(Canvas arg1, Line arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void drawSquarePath(Canvas arg1, Line arg2)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void highlightPoint(Canvas arg1, Line arg2, lecho.lib.hellocharts.model.PointValue arg3, float arg4, float arg5, int arg6, int arg7)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  /* Error */
  private void highlightPoints(Canvas arg1)
  {
    // Byte code:
    //   0: return
    //   1: astore_1
    //   2: goto -2 -> 0
  }
  
  private boolean isInArea(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5)
  {
    return false;
  }
  
  /* Error */
  private void prepareLinePaint(Line arg1)
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
  
  /* Error */
  public void drawUnclipped(Canvas arg1)
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
  
  public void setShader(Shader paramShader)
  {
    this.linePaint.setShader(paramShader);
  }
}


/* Location:              C:\Users\adinb\Downloads\dex2jar-2.0\dex2jar-2.0\0x87b1d00c-dex2jar.jar!\lecho\lib\hellocharts\renderer\LineChartRenderer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */