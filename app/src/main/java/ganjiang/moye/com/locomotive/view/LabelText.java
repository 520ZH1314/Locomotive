package ganjiang.moye.com.locomotive.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import ganjiang.moye.com.locomotive.R;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/26.
 * 项目标签的textView
 * 自定义 VIew
 */

public class LabelText extends android.support.v7.widget.AppCompatTextView {
    private int labelTextColor;//color
    private int labelTextSize;//字体大小
    private int labelTextStrokeColor;//边框颜色
    private int labelTextBorder;////边框大小
    private int labelTextBorderRound;////圆角
    private String  labelTextString;
    private static final int DEFULAT_COLOR = Color.BLACK;
    private static final int LABELTEXTSIZE =12;
    private static final int LABELTEXTBORDER =1;
    private static final int LABELTEXTBORDERROUND =10;
    private Paint paint;


    public LabelText(Context context) {
        this(context, null);
    }

    public LabelText(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LabelText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray array = context.obtainStyledAttributes(attrs, R.styleable.LabelText);
        labelTextColor = array.getColor(R.styleable.LabelText_labelTextColor, DEFULAT_COLOR);
        labelTextStrokeColor = array.getColor(R.styleable.LabelText_labelTextStrokeColor, DEFULAT_COLOR);
        labelTextBorder = array.getInt(R.styleable.LabelText_labelTextBorder, LABELTEXTBORDER);
        labelTextSize = (int) array.getDimension(R.styleable.LabelText_labelTextSize, LABELTEXTSIZE);
        labelTextString=array.getString(R.styleable.LabelText_labelText);
        labelTextBorderRound=array.getInt(R.styleable.LabelText_labelTextBorderRound,LABELTEXTBORDERROUND);
        array.recycle();
        paint=new Paint();
        initPaint(labelTextColor);
    }

     //初始化画笔
    private void initPaint(int labelTextColor ) {
         paint.reset();
         paint.setAntiAlias(true);//抗锯齿
         paint.setColor(labelTextColor);
         paint.setTextSize(labelTextSize);
    }

    //计算组件宽度
    private int measureWidth(int widthMeasureSpec, Rect rectText){
         int  mode=MeasureSpec.getMode(widthMeasureSpec);
         int size=MeasureSpec.getSize(widthMeasureSpec);
         int width=0;
         if (mode==MeasureSpec.EXACTLY){
             width=size;
         }else if(mode==MeasureSpec.AT_MOST){
             width=getPaddingLeft()+rectText.width()+getPaddingRight();
         }
            return width;
    }

    //计算组件高度
    private int measureHeight(int widthMeasureSpec, Rect rectText){
        int  mode=MeasureSpec.getMode(widthMeasureSpec);
        int size=MeasureSpec.getSize(widthMeasureSpec);
        int height=0;
        if (mode==MeasureSpec.EXACTLY){
            height=size;
        }else if(mode==MeasureSpec.AT_MOST){
            height=getPaddingTop()+rectText.height()+getPaddingBottom();
        }
        return height;
    }

    //获取文字所占的尺寸
    private Rect getTextRect(){
        Rect rect=new Rect();
        paint.getTextBounds(labelTextString,0,labelTextString.length(),rect);
        return rect;
    }


   //测量
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
       Rect rect=getTextRect();
       int width=measureWidth(widthMeasureSpec,rect);
       int height=measureHeight(heightMeasureSpec,rect);
       setMeasuredDimension(width,height);

    }

    //画
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=getMeasuredWidth();
        int height=getMeasuredHeight();
        Rect rect=new Rect(0,0,width,height);

        //绘制外围矩形
        paint.setColor(labelTextStrokeColor);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setStrokeWidth(labelTextBorder);

        RectF rect1=new RectF(rect);
        rect1.inset(2,2);
        canvas.drawRoundRect(rect1,labelTextBorderRound,labelTextBorderRound,paint);

         //绘制文字
         initPaint(labelTextColor);
         paint.setStyle(Paint.Style.FILL);
         Rect rect2=getTextRect();
         Paint.FontMetrics fontMetrics=paint.getFontMetrics();
         int x=(width-rect2.width())/2;
         int y=(int)(height/2+(fontMetrics.descent-fontMetrics.ascent)/2-fontMetrics.descent);
         canvas.drawText(labelTextString,x, y,paint);

    }


}
