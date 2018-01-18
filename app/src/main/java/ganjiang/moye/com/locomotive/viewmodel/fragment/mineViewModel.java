package ganjiang.moye.com.locomotive.viewmodel.fragment;

import android.content.Context;

import ganjiang.moye.com.locomotive.ui.fragemnt.mine.MineFragment;
import ganjiang.moye.com.locomotive.view.CustomDialog;
import me.goldze.mvvmhabit.base.BaseViewModel;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import rx.functions.Action0;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/25.
 * 我的
 */

public class mineViewModel extends BaseViewModel{


    private  MineFragment mineFragment;

    public mineViewModel(MineFragment mineFragment) {
          this.mineFragment=mineFragment;
    }

    public mineViewModel(Context context) {
        super(context);
    }



    //提现的点击事件
    public BindingCommand TiXianClick = new BindingCommand(new Action0() {
        @Override
        public void call() {
            CustomDialog customDialog=CustomDialog.newIntance();
             customDialog.show(mineFragment.getActivity().getSupportFragmentManager(),"bindbank");

        }
    });
}
