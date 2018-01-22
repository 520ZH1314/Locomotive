package ganjiang.moye.com.locomotive.viewmodel.fragment;

import android.content.Context;
import android.databinding.ObservableBoolean;

import java.util.ArrayList;
import java.util.List;

import ganjiang.moye.com.locomotive.base.MyBaseViewModel;
import ganjiang.moye.com.locomotive.bean.LunBoEnity;
import ganjiang.moye.com.locomotive.bean.LunBoUrl;
import ganjiang.moye.com.locomotive.http.HomeService;
import ganjiang.moye.com.locomotive.ui.activity.home.ADDetailActivity;
import ganjiang.moye.com.locomotive.ui.fragemnt.home.HomeFragment;
import ganjiang.moye.com.locomotive.utils.RetrofitClients;
import me.goldze.mvvmhabit.binding.command.BindingCommand;
import me.goldze.mvvmhabit.binding.viewadapter.spinner.IKeyAndValue;
import me.goldze.mvvmhabit.utils.RxUtils;
import me.goldze.mvvmhabit.utils.ToastUtils;
import rx.Observer;
import rx.functions.Action0;


/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/25.\
 * 首页viewModel
 */

public class homeViewModel extends MyBaseViewModel {



    //用户名的绑定

    public List <IKeyAndValue>imags=new ArrayList<>();

    public String msg;
    public List<LunBoEnity.ImgsBean> imgs;



    public homeViewModel(HomeFragment homeFragment, int terminal, int itino) {
       super(homeFragment);
        //请求轮播图网络
        requestLunBoNet(terminal, itino);


    }



    //封装一个界面发生改变的观察者
    public UIChangeObservable uc = new UIChangeObservable();

    public homeViewModel(Context context, LunBoEnity.ImgsBean nn) {

    }


    public class UIChangeObservable {
        //请求成功的观察者
        public ObservableBoolean isRequestSuccess = new ObservableBoolean(false);
    }

    /**
     * author:lovezh
     * params:
     * description: //请求轮播图网络
     */
    private void requestLunBoNet(int terminal, int itino) {
        RetrofitClients.getInstance().create(HomeService.class)
                .goLunBoTu(terminal, itino)
                .compose(RxUtils.bindToLifecycle(context))
                .compose(RxUtils.schedulersTransformer())
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        showDialog();
                    }
                })
                .subscribe(new Observer<LunBoEnity>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        dismissDialog();
                        ToastUtils.showShort("请求异常");
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(LunBoEnity bean) {
                         dismissDialog();
                         imgs = bean.getImgs();
                        for (LunBoEnity.ImgsBean nn:imgs) {
                            msg=nn.getTitlepic();
                            imags.add(new LunBoUrl(nn.getTitlepic(),nn.getTitle()));
                        }
                        //回调到Fragment中刷新界面
                        uc.isRequestSuccess.set(!uc.isRequestSuccess.get());

                    }
                });
    }



    //银行系统升级维护按钮的点击事件
    public BindingCommand HomeADClick = new BindingCommand(() -> startActivity( ADDetailActivity.class));

    }


