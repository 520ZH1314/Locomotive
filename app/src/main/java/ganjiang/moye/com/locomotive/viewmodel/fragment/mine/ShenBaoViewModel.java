package ganjiang.moye.com.locomotive.viewmodel.fragment.mine;

import android.databinding.ObservableField;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import com.example.zhouwei.library.CustomPopWindow;

import java.util.Arrays;

import ganjiang.moye.com.locomotive.adapter.ListDropDown2Adapter;
import ganjiang.moye.com.locomotive.adapter.ListDropDownAdapter;
import ganjiang.moye.com.locomotive.base.MyBaseViewModel;
import ganjiang.moye.com.locomotive.databinding.FragmentShenbaoBinding;
import ganjiang.moye.com.locomotive.ui.fragemnt.mine.ShenBaoFragment;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/22.
 * 投资申报Fragment 的 ViewModel
 */

public class ShenBaoViewModel extends MyBaseViewModel {
    private CustomPopWindow mListPopWindow2;
    private ListDropDown2Adapter jiaoyiAdapter;
    private CustomPopWindow mListPopWindow;
    private ListDropDownAdapter ageAdapter;
    public ShenBaoFragment shenBaoFragment;
    public ObservableField<Boolean> Checked2 = new ObservableField<Boolean>();
    public ObservableField<Boolean> Checked1 = new ObservableField<Boolean>();
    private String shouyi[] = {"不限", "已提交", "处理中", "审核通过", "审核失败"};
    private String jiaoyi[] = {"不限", "男", "女"};
    private String[] headers = {"收益类型", "平台类型"};
    private FragmentShenbaoBinding binding;
    private CheckBox one;
    private int height;

    public ShenBaoViewModel(ShenBaoFragment shenBaoFragment, FragmentShenbaoBinding binding, int height) {
        super(shenBaoFragment);
        this.shenBaoFragment = shenBaoFragment;
        this.binding = binding;
        this.height = height;
    }


    //第一个筛选按钮
    public BindingCommand Check1Click = new BindingCommand(() -> {
        if (mListPopWindow2 != null) {
            mListPopWindow2.dissmiss();
        }
        one = this.binding.one;
        Checked1.set(true);
        Checked2.set(false);

        //init age menu
        final ListView ageView = new ListView(context);
        ageView.setDividerHeight(0);
        ageAdapter = new ListDropDownAdapter(context, Arrays.asList(shouyi));
        ageView.setAdapter(ageAdapter);
        mListPopWindow = new CustomPopWindow.PopupWindowBuilder(context)
                .setView(ageView)

                .setBgDarkAlpha(0.7f) // 控制亮度
                .enableOutsideTouchableDissmiss(true)
                .size(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)//显示大小
                .create()
                .showAsDropDown(one, 0, -height);
        ageView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ageAdapter.setCheckItem(position);
                one.setText(position == 0 ? headers[0] : shouyi[position]);
                mListPopWindow.dissmiss();
            }
        });

    });

    //第二个筛选按钮
    public BindingCommand Check2Click = new BindingCommand(() -> {
        if (mListPopWindow != null) {
            mListPopWindow.dissmiss();
        }
        Checked1.set(false);
        Checked2.set(true);
        CheckBox two = this.binding.two;
        //init age menu
        final ListView pingtaiView = new ListView(context);
        pingtaiView.setDividerHeight(0);
        jiaoyiAdapter = new ListDropDown2Adapter(context, Arrays.asList(jiaoyi));
        pingtaiView.setAdapter(jiaoyiAdapter);
        mListPopWindow2 = new CustomPopWindow.PopupWindowBuilder(context)
                .setView(pingtaiView)

                .setBgDarkAlpha(0.7f) // 控制亮度
                .size(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)//显示大小
                .create()
                .showAsDropDown(two, 0, -height);

        pingtaiView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                jiaoyiAdapter.setCheckItem(position);
                two.setText(position == 0 ? headers[1] : jiaoyi[position]);
                mListPopWindow2.dissmiss();
            }
        });
        KLog.a(Checked1.get());
        KLog.a(Checked2.get());

    });


}
