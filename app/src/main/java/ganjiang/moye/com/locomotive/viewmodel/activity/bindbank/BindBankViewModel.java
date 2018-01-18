package ganjiang.moye.com.locomotive.viewmodel.activity.bindbank;

import ganjiang.moye.com.locomotive.base.MyBaseViewModel;
import ganjiang.moye.com.locomotive.ui.activity.bindbank.BindBankActivity;
import ganjiang.moye.com.locomotive.ui.activity.bindbank.OpenBankNumActivity;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import rx.functions.Action0;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/10.
 */

public class BindBankViewModel extends MyBaseViewModel {
  public BindBankActivity context;
    public BindBankViewModel(BindBankActivity bindBankActivity) {
             super(bindBankActivity);
             this.context=bindBankActivity;

    }



    //去输入银行卡信息界面
    public BindingCommand bindBankClick = new BindingCommand(new Action0() {
        @Override
        public void call() {
             startActivity(OpenBankNumActivity.class);
             context.finish();
        }
    });


}
