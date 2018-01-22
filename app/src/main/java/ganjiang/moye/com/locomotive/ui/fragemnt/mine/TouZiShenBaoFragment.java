package ganjiang.moye.com.locomotive.ui.fragemnt.mine;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.databinding.FragmentTouzishenbaoBinding;
import ganjiang.moye.com.locomotive.viewmodel.fragment.mine.TouZiHShenBaoViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/22.
 * 投资申报的 Fragment
 */

public class TouZiShenBaoFragment extends BaseFragment<FragmentTouzishenbaoBinding,TouZiHShenBaoViewModel> {


    @Override
    public int initContentView() {
        return R.layout.fragment_touzishenbao;
    }

    @Override
    public int initVariableId() {
        return BR.TouZiView;
    }

    @Override
    public TouZiHShenBaoViewModel initViewModel() {
        return new TouZiHShenBaoViewModel(this);
    }
}
