package ganjiang.moye.com.locomotive.ui.activity.me;

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
import ganjiang.moye.com.locomotive.databinding.ActivityInvestmentMoreBinding;
import ganjiang.moye.com.locomotive.ui.fragemnt.mine.ShenBaoFragment;
import ganjiang.moye.com.locomotive.ui.fragemnt.mine.TouZiShenBaoFragment;
import ganjiang.moye.com.locomotive.viewmodel.activity.me.InvestMentMoreViewModel;

/**
 *author:lovezh
 *params:
 *description:投资申报界面
 */

public class InvestmentMoreActivity extends MyBaseActivity<ActivityInvestmentMoreBinding,InvestMentMoreViewModel> {

    private List<Fragment> list;

    private String[] titles = {"投资申报", "申报记录"};

    private MyAdapter adapter;
    private Toolbar adtoolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TabLayout tablayout = binding.investmentMoreTablayout;
        ViewPager viewpager = binding.investmentMoreViewpager;
        adtoolbar = binding.investmentMoreToolbar;
        setToolBar(adtoolbar,"");

        //页面，数据源
        list = new ArrayList<>();
        list.add(new TouZiShenBaoFragment());
        list.add(new ShenBaoFragment());
        //ViewPager的适配器
        adapter = new MyAdapter(getSupportFragmentManager());
        viewpager.setAdapter(adapter);
        //绑定
        tablayout.setupWithViewPager(viewpager);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_investment_more;
    }

    @Override
    public int initVariableId() {
        return BR.InvestMentMore;
    }
    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        adtoolbar.setNavigationIcon(R.drawable.bank);
    }
    @Override
    public InvestMentMoreViewModel initViewModel() {
        return new InvestMentMoreViewModel();
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
