package ganjiang.moye.com.locomotive.ui.activity.bindbank;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.base.MyBaseActivity;
import ganjiang.moye.com.locomotive.databinding.ActivityUnbindBankBinding;
import ganjiang.moye.com.locomotive.viewmodel.fragment.withdraw.UnbindBankViewModel;

public class UnbindBankActivity extends MyBaseActivity<ActivityUnbindBankBinding,UnbindBankViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Toolbar unbindToobar = binding.unbindToobar;
         setToolBar(unbindToobar,"");
    }

    @Override
    public int initContentView() {
        return R.layout.activity_unbind_bank;
    }

    @Override
    public int initVariableId() {
        return BR.unBindViewModel;
    }

    @Override
    public UnbindBankViewModel initViewModel() {
        return null;
    }

    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        toolbar.setNavigationIcon(R.drawable.bank);
    }
}
