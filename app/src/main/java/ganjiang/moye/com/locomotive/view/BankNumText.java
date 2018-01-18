package ganjiang.moye.com.locomotive.view;

import android.content.Context;
import android.util.AttributeSet;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/15.
 */

public class BankNumText extends android.support.v7.widget.AppCompatTextView {
    public BankNumText(Context context) {
        this(context,null);
    }

    public BankNumText(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public BankNumText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {

    }
}
