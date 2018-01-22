package ganjiang.moye.com.locomotive.ui.fragemnt.rebate;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.databinding.RebateFragmentBinding;
import ganjiang.moye.com.locomotive.ui.fragemnt.mine.ShenBaoFragment;
import ganjiang.moye.com.locomotive.ui.fragemnt.mine.TouZiShenBaoFragment;
import ganjiang.moye.com.locomotive.viewmodel.fragment.rebateViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/25.
 * 返利申报
 */

public class RebateFragment extends BaseFragment<RebateFragmentBinding,rebateViewModel> {
    private List<Fragment> list;

    private String[] titles = {"投资申报", "申报记录"};

    private MyAdapter adapter;
    @Override
    public int initContentView() {
        return R.layout.rebate_fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, this.initContentView(), container, false);
        this.binding.setVariable(this.initVariableId(), this.viewModel = this.initViewModel());
        TabLayout tablayout = binding.rebateTablayout;
        ViewPager viewpager = binding.rebateViewpager;
        //页面，数据源
        list = new ArrayList<>();
        list.add(new TouZiShenBaoFragment());
        list.add(new ShenBaoFragment());
        //ViewPager的适配器
        adapter = new MyAdapter(getChildFragmentManager());
        viewpager.setAdapter(adapter);
        //绑定
        tablayout.setupWithViewPager(viewpager);
        return this.binding.getRoot();
    }

    @Override
    public int initVariableId() {
        return BR.rebateModel;
    }

    @Override
    public rebateViewModel initViewModel() {
        return new rebateViewModel();
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
