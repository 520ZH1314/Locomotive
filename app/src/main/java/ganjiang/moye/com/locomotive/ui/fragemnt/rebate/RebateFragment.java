package ganjiang.moye.com.locomotive.ui.fragemnt.rebate;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.databinding.RebateFragmentBinding;
import ganjiang.moye.com.locomotive.viewmodel.fragment.rebateViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/25.
 * 返利申报
 */

public class RebateFragment extends BaseFragment<RebateFragmentBinding,rebateViewModel> {
    @Override
    public int initContentView() {
        return R.layout.rebate_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.rebateModel;
    }

    @Override
    public rebateViewModel initViewModel() {
        return new rebateViewModel();
    }
}
