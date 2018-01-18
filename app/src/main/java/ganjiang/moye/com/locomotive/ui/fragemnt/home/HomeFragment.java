package ganjiang.moye.com.locomotive.ui.fragemnt.home;

import android.databinding.Observable;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.databinding.HomeFragmentBinding;
import ganjiang.moye.com.locomotive.viewmodel.fragment.homeViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/25.
 * 首页
 */

public class HomeFragment extends BaseFragment<HomeFragmentBinding, homeViewModel> {





    @Override
    public int initContentView() {
        return R.layout.home_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.homeModel;
    }


    @Override
    public homeViewModel initViewModel() {
        return new homeViewModel(this, 1, 61);
    }




    @Override
    public void initViewObservable() {

        //监听刷新界面
        viewModel.uc.isRequestSuccess.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {

            @Override
            public void onPropertyChanged(Observable observable, int i) {
                //调用刷新
                refreshLayout();
            }
        });
    }
}
