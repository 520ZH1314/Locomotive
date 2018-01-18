package ganjiang.moye.com.locomotive.ui.activity.bindbank;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.base.MyBaseActivity;
import ganjiang.moye.com.locomotive.databinding.ActivityBindBankBinding;
import ganjiang.moye.com.locomotive.viewmodel.activity.bindbank.BindBankViewModel;

/**
 *author:lovezh
 *params:
 *description:
 *  //绑定银行卡界面
 *
 */

public class BindBankActivity extends MyBaseActivity<ActivityBindBankBinding,BindBankViewModel> {


    private Toolbar adtoobar;

    @Override
    public int initContentView() {
        return R.layout.activity_bind_bank;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adtoobar = binding.bindBankToobar;
        setToolBar(adtoobar,"");
    }

    @Override
    public int initVariableId() {
        return BR.bindbankViewModel;
    }

    @Override
    public BindBankViewModel initViewModel() {
        return new BindBankViewModel(this);
    }
    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        adtoobar.setNavigationIcon(R.drawable.bank);
    }
}
