package ganjiang.moye.com.locomotive.ui.activity.WithDraw;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.base.MyBaseActivity;
import ganjiang.moye.com.locomotive.databinding.ActivityWithDrawBinding;
import ganjiang.moye.com.locomotive.ui.fragemnt.rebate.RebateFragment;
import ganjiang.moye.com.locomotive.ui.fragemnt.withdraw.WithDrawFragment;
import ganjiang.moye.com.locomotive.viewmodel.activity.withdraw.WithDrawViewModel;

/**
 *author:lovezh
 *params:
 *description:
 * 提现界面
 */
public class WithDrawActivity extends MyBaseActivity<ActivityWithDrawBinding,WithDrawViewModel> {
    private List<Fragment> list;

    private String[] titles = {"提现申请", "提现记录"};

    private MyAdapter adapter;
    private Toolbar adtoolbar;

    @Override
    public int initContentView() {
        return R.layout.activity_with_draw;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabLayout tablayout = binding.withTablayout;
        ViewPager viewpager = binding.withViewpager;
        adtoolbar = binding.withDrawToolbar;
        setToolBar(adtoolbar,"");

        //页面，数据源
        list = new ArrayList<>();
        list.add(new WithDrawFragment());
        list.add(new RebateFragment());
        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        //绑定
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public int initVariableId() {
        return BR.withdraweViewModel;
    }

    @Override
    public WithDrawViewModel initViewModel() {
        return new WithDrawViewModel();
    }

    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        adtoolbar.setNavigationIcon(R.drawable.bank);
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public Fragment getItem(int position) {
            return list.get(position);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        //重写这个方法，将设置每个Tab的标题
        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
