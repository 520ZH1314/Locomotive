package ganjiang.moye.com.locomotive.ui.fragemnt.mine;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

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


    private LinearLayout checkLl;
    private int height;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        this.binding = DataBindingUtil.inflate(inflater, this.initContentView(), container, false);
        this.binding.setVariable(this.initVariableId(), this.viewModel = this.initViewModel());

         checkLl = binding.checkLl;
        return this.binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

         height = checkLl.getBottom();


    }

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



        return new ShenBaoViewModel(this,this.binding,height);
    }
}
