package ganjiang.moye.com.locomotive;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import ganjiang.moye.com.locomotive.databinding.ActivityMainBinding;
import ganjiang.moye.com.locomotive.ui.fragemnt.home.HomeFragment;
import ganjiang.moye.com.locomotive.ui.fragemnt.mine.MineFragment;
import ganjiang.moye.com.locomotive.ui.fragemnt.rebate.RebateFragment;
import ganjiang.moye.com.locomotive.viewmodel.mainViewModel;
import me.goldze.mvvmhabit.base.BaseActivity;

public class MainActivity extends BaseActivity<ActivityMainBinding, mainViewModel> implements RadioGroup.OnCheckedChangeListener {

    private FrameLayout containFrame;
    private Fragment mFragment;//当前显示的 fragment
    private HomeFragment homefragment;

    private MineFragment mineFragment;
    private RebateFragment rebateFragment;
    private RadioButton mianHome;

    private RadioButton mianRebate;
    private RadioButton mianMine;
    private RadioGroup mianRadiogruop;
    private Fragment[] mFragments;
    private int mIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }

        initView();

        initListener();
    }

    private void initListener() {
        mianRadiogruop.setOnCheckedChangeListener(this);
    }

    /**
     * author:lovezh
     * params:
     * description:初始化容器
     */


    /**
     * author:lovezh
     * params:
     * description:初始化数据
     */
    private void initView() {
        containFrame = binding.mianFragment;
        mianHome = binding.mianHome;

        mianRebate = binding.mianRebate;
        mianMine = binding.mianMine;
        mianRadiogruop = binding.mianRadiogruop;

        homefragment = new HomeFragment();//首页

        mineFragment = new MineFragment();//我的
        rebateFragment = new RebateFragment();//返利申报
        mFragments = new Fragment[]{homefragment,
                rebateFragment,mineFragment};


        //开启事务

        FragmentTransaction ft =
                getSupportFragmentManager().beginTransaction();

        //添加首页
        ft.add(R.id.mian_fragment, homefragment).commit();

        //默认设置为第0个
        setIndexSelected(0);

    }

    private void setIndexSelected(int index) {
        if (mIndex == index) {
            return;
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();


        //隐藏
        ft.hide(mFragments[mIndex]);
        //判断是否添加
        if (!mFragments[index].isAdded()) {
            ft.add(R.id.mian_fragment, mFragments[index]).show(mFragments[index]);
        } else {
            ft.show(mFragments[index]);
        }

        ft.commit();
        //再次赋值
        mIndex = index;

    }

    @Override
    public int initContentView() {
        return R.layout.activity_main;
    }

    @Override
    public int initVariableId() {
        return ganjiang.moye.com.locomotive.BR.mainActivity;
    }

    @Override
    public mainViewModel initViewModel() {
        return new mainViewModel();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.mian_home:
                setIndexSelected(0);
                break;

            case R.id.mian_rebate:
                setIndexSelected(1);
                break;
            case R.id.mian_mine:
                setIndexSelected(2);
                break;
        }

    }
}
