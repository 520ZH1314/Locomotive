package ganjiang.moye.com.locomotive.viewmodel.fragment.withdraw;

import ganjiang.moye.com.locomotive.base.MyBaseViewModel;
import ganjiang.moye.com.locomotive.ui.activity.bindbank.UnbindBankActivity;
import ganjiang.moye.com.locomotive.ui.fragemnt.withdraw.WithDrawFragment;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/15.
 * 提现申请 Fragment
 */

public class FragmentWithDrawViewModel extends MyBaseViewModel {
    private WithDrawFragment withDrawFragment;
    public FragmentWithDrawViewModel(WithDrawFragment withDrawFragment) {
        this.withDrawFragment=withDrawFragment;
    }


   // 跳转到解绑银行卡界面

   public BindingCommand UnbindBankClick =new BindingCommand(() ->

            startActivity(UnbindBankActivity.class)

   );


}
