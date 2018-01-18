package ganjiang.moye.com.locomotive.ui.fragemnt.mine;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.databinding.MineFragmentBinding;
import ganjiang.moye.com.locomotive.viewmodel.fragment.mineViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/25.
 * 我的
 */

public class MineFragment extends BaseFragment<MineFragmentBinding,mineViewModel> {
    @Override
    public int initContentView() {
        return R.layout.mine_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.mineModel;
    }

    @Override
    public mineViewModel initViewModel() {
        return new mineViewModel(this) ;
    }
}
