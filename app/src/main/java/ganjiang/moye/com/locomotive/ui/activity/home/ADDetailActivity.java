package ganjiang.moye.com.locomotive.ui.activity.home;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.base.MyBaseActivity;
import ganjiang.moye.com.locomotive.databinding.ActivityAddetailBinding;
import ganjiang.moye.com.locomotive.viewmodel.activity.home.ADDetailViewModel;

public class ADDetailActivity extends MyBaseActivity<ActivityAddetailBinding,ADDetailViewModel> {

    private Toolbar adToobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adToobar = binding.adToobar;
        setToolBar(adToobar,"");
    }

    @Override
    public int initContentView() {
        return R.layout.activity_addetail;


    }

    @Override
    public int initVariableId() {
        return BR.adViewModel;
    }

    @Override
    public ADDetailViewModel initViewModel() {
        return new ADDetailViewModel();
    }

    @Override
    protected void setToolBar(Toolbar toolbar, String title) {
        super.setToolBar(toolbar, title);
        adToobar.setNavigationIcon(R.drawable.bank);
    }
}
