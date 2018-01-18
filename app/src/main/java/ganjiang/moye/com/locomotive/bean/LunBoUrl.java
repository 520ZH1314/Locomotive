package ganjiang.moye.com.locomotive.bean;

import me.goldze.mvvmhabit.binding.viewadapter.spinner.IKeyAndValue;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/26.
 * 轮播图的 bean
 */

public class LunBoUrl implements IKeyAndValue{

    //key是下拉显示的文字
    private String picUrl;
    //value是对应需要上传给后台的值, 这个可以根据具体业务具体定义
    private String titleUrl;

    public LunBoUrl(String picUrl, String titleUrl) {
        this.picUrl = picUrl;
        this.titleUrl = titleUrl;
    }

    @Override
    public String getKey() {
        return picUrl;
    }

    @Override
    public String getValue() {
        return titleUrl;
    }
}
