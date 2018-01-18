package ganjiang.moye.com.locomotive.ui.fragemnt.account;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/25.
 * 记账
 */

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.databinding.AccountFragmentBinding;
import ganjiang.moye.com.locomotive.viewmodel.fragment.accountViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;



/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/25.
 * 记账
 */

public class AccountFragment extends BaseFragment<AccountFragmentBinding, accountViewModel> {
    @Override
    public int initContentView() {
        return R.layout.account_fragment;
    }

    @Override
    public int initVariableId() {
        return BR.accountModel;
    }

    @Override
    public ganjiang.moye.com.locomotive.viewmodel.fragment.accountViewModel initViewModel() {
        return new accountViewModel();
    }
}

