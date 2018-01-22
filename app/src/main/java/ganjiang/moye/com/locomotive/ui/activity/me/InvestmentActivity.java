package ganjiang.moye.com.locomotive.ui.activity.me;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.base.MyBaseActivity;
import ganjiang.moye.com.locomotive.databinding.ActivityInvestmentBinding;
import ganjiang.moye.com.locomotive.viewmodel.activity.me.InvestMentViewModel;

/**
 *author:lovezh
 *params:
 *description:投资界面
 */
public class InvestmentActivity extends MyBaseActivity<ActivityInvestmentBinding,InvestMentViewModel> {


    @Override
    public int initContentView() {
        return R.layout.activity_investment;
    }

    @Override
    public int initVariableId() {
        return BR.investment;
    }

    @Override
    public InvestMentViewModel initViewModel() {
        return new InvestMentViewModel();
    }
}
