package ganjiang.moye.com.locomotive.ui.fragemnt.mine;

import ganjiang.moye.com.locomotive.BR;
import ganjiang.moye.com.locomotive.R;
import ganjiang.moye.com.locomotive.databinding.FragmentShenbaoBinding;
import ganjiang.moye.com.locomotive.viewmodel.fragment.mine.ShenBaoViewModel;
import me.goldze.mvvmhabit.base.BaseFragment;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2018/1/22.
 * 投资申报的 Fragment
 */

public class ShenBaoFragment extends BaseFragment<FragmentShenbaoBinding,ShenBaoViewModel> {

    @Override
    public int initContentView() {
        return R.layout.fragment_shenbao;
    }

    @Override
    public int initVariableId() {
        return BR.ShenBaoView;
    }

    @Override
    public ShenBaoViewModel initViewModel() {
        return new ShenBaoViewModel();
    }
}
