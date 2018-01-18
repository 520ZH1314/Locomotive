package ganjiang.moye.com.locomotive.ui.activity.bindbank;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.base.MyBaseActivity;
import ganjiang.moye.com.locomotive.databinding.ActivityOpenBankNumBinding;
import ganjiang.moye.com.locomotive.viewmodel.activity.bindbank.OpenBankNumViewModel;

public class OpenBankNumActivity extends MyBaseActivity<ActivityOpenBankNumBinding,OpenBankNumViewModel> {



    @Override
    public int initContentView() {
        return R.layout.activity_open_bank_num;
    }

    @Override
    public int initVariableId() {
        return BR.openBankViewModel;
    }

    @Override
    public OpenBankNumViewModel initViewModel() {
        return new OpenBankNumViewModel();
    }
}
