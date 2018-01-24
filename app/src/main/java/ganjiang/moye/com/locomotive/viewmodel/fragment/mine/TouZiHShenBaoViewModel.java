package ganjiang.moye.com.locomotive.viewmodel.fragment.mine;

import android.databinding.ObservableField;
import android.graphics.Color;
import android.view.View;

import com.bigkoo.pickerview.TimePickerView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import ganjiang.moye.com.locomotive.base.MyBaseViewModel;
import ganjiang.moye.com.locomotive.ui.fragemnt.mine.TouZiShenBaoFragment;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/22.
 * 投资申报Fragment 的 ViewModel
 */

public class TouZiHShenBaoViewModel extends MyBaseViewModel {
    //投资平台名的绑定
    public ObservableField<String>  TouZIName = new ObservableField<>("");
    //平台用户名
    public ObservableField<String> Usename = new ObservableField<>("");

    //平台用户手机号的绑定
    public ObservableField<String> phoneNum = new ObservableField<>("");

    //标的名称绑定
    public ObservableField<String> biaoName = new ObservableField<>("");


    //投资金额的绑定
    public ObservableField<String> money = new ObservableField<>("");



    private TouZiShenBaoFragment touZiShenBaoFragment;
    //用户名的绑定
    public ObservableField<String> time = new ObservableField<>("");

    private TimePickerView pvTime;
    public List data1=new ArrayList();

    public TouZiHShenBaoViewModel(TouZiShenBaoFragment touZiShenBaoFragment) {

            super(touZiShenBaoFragment);
            this.touZiShenBaoFragment=touZiShenBaoFragment;

            requesstNet();//请求网络
    }

    private void requesstNet() {

        for (int i = 0; i <5 ; i++) {

            data1.add("聚车金融"+i);
        }

    }


    //日历点击事件
  public BindingCommand RiLiClick=new BindingCommand(() -> {
          if(pvTime==null){
              initTimer();
          }

             pvTime.show();

  });



    //初始化时间选择器
    private void initTimer() {
        //控制时间范围(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
        //因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
        Calendar selectedDate = Calendar.getInstance();
        Calendar startDate = Calendar.getInstance();
        startDate.set(2013, 0, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2019, 11, 28);
        //时间选择器
         pvTime = new TimePickerView.Builder(touZiShenBaoFragment.getContext(), new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                // 这里回调过来的v,就是show()方法里面所添加的 View 参数，如果show的时候没有添加参数，v则为null
                /*btn_Time.setText(getTime(date));*/
                      time.set(getTime(date));

            }
        })
                //年月日时分秒 的显示与否，不设置则默认全部显示
                .setType(new boolean[]{true, true, true, false, false, false})
                .setLabel("", "", "", "", "", "")
                .isCenterLabel(false)
                .setDividerColor(Color.DKGRAY)
                .setContentSize(21)
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
//                .setBackgroundId(0x00FFFFFF) //设置外部遮罩颜色
                .setDecorView(null)
                .build();
    }


      //格式化 time
    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(date);
    }


  //提交的点击事件
    public BindingCommand BtnGoClick=new BindingCommand(() -> {


    });



}
