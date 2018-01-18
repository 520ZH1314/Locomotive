package ganjiang.moye.com.locomotive.ui.fragemnt.withdraw;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.databinding.FragmentWithDrawBinding;
import ganjiang.moye.com.locomotive.viewmodel.fragment.withdraw.FragmentWithDrawViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/15.
 * 提现申请界面
 */

public class WithDrawFragment extends BaseFragment<FragmentWithDrawBinding,FragmentWithDrawViewModel> {
    @Override
    public int initContentView() {
        return R.layout.fragment_with_draw;
    }

    @Override
    public int initVariableId() {
       return BR.fragment_with_draw;
    }

    @Override
    public FragmentWithDrawViewModel initViewModel() {
        return new FragmentWithDrawViewModel(this);
    }
}
