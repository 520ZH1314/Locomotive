package ganjiang.moye.com.locomotive.viewmodel.activity.me;

import ganjiang.moye.com.locomotive.base.MyBaseViewModel;
import ganjiang.moye.com.locomotive.ui.activity.bindbank.OpenBankNumActivity;
import ganjiang.moye.com.locomotive.ui.activity.me.BindMailActivity;
import ganjiang.moye.com.locomotive.ui.activity.me.ModifyPhonePwdActivity;
import ganjiang.moye.com.locomotive.ui.activity.me.MyCenterActivity;
import me.goldze.mvvmhabit.binding.command.BindingCommand;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/25.
 * 个人中心的 ViewModel
 */

public class MyCenterViewModel extends MyBaseViewModel {

    public MyCenterViewModel(MyCenterActivity myCenterActivity) {
            super(myCenterActivity);
    }



    // 添加银行卡点击事件
     public BindingCommand AddBankClick =new BindingCommand(() -> startActivity(OpenBankNumActivity.class));

    // 修改登录密码点击事件
    public BindingCommand ModifyPhoneClick =new BindingCommand(() -> startActivity(ModifyPhonePwdActivity.class));

    // 绑定邮箱点击事件
    public BindingCommand BindMailClick =new BindingCommand(() -> startActivity(BindMailActivity.class));



}
