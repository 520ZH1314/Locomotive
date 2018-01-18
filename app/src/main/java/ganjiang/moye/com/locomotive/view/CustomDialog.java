package ganjiang.moye.com.locomotive.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.ui.activity.WithDraw.WithDrawActivity;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/9.
 */

public class CustomDialog extends DialogFragment implements View.OnClickListener {


    private ImageView close;
    private Button go;

    public static CustomDialog newIntance(){
        CustomDialog customDialog=new CustomDialog();
        return customDialog;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_bind_bank, container, false);
         close = (ImageView) view.findViewById(R.id.bind_bank_dismiss);
         go = (Button) view.findViewById(R.id.bind_bank_go_to_bank);
         close.setOnClickListener(this);
         go.setOnClickListener(this);
         return view;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME,R.style.customDialog);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bind_bank_dismiss:
                dismiss();
                break;
            case R.id.bind_bank_go_to_bank:
                Intent intent=new Intent(getContext(), WithDrawActivity.class);
                startActivity(intent);
                dismiss();
                break;
            default:
                break;
        }

    }





    //    private Context context;
//    private int resId;
//    public CustomDialog(Context context, int resLayout) {
//        this(context,0,0);
//    }
//    public CustomDialog(Context context, int themeResId, int resLayout) {
//        super(context, themeResId);
//        this.context = context;
//        this.resId = resLayout;
//    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        this.setContentView(resId);
//    }





}
