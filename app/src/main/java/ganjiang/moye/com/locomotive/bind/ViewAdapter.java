package ganjiang.moye.com.locomotive.bind;

import android.databinding.BindingAdapter;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.transformer.CubeOutTransformer;

import java.util.ArrayList;
import java.util.List;

import ganjiang.moye.com.locomotive.utils.GlideImageLoader;
import me.goldze.mvvmhabit.binding.viewadapter.spinner.IKeyAndValue;
import me.goldze.mvvmhabit.utils.KLog;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/26.
 * bind 自定义适配器
 */

public final class ViewAdapter {


    private static int screenWidth;
    private static List<String> titles = new ArrayList<>();
    private static List<String> images = new ArrayList();

    @BindingAdapter(value = {"bannerurl"}, requireAll = false)
    public static void setImageUri(final Banner mBanner, final List <IKeyAndValue> bannerurl) {


        if (bannerurl != null && !bannerurl.isEmpty()) {
            if(images.size()>=4&&titles.size()>=4){
                images.clear();
                titles.clear();
            }
            for (IKeyAndValue iKeyAndValue : bannerurl) {


                images.add(iKeyAndValue.getKey());
            }
            for (IKeyAndValue iKeyAndValue : bannerurl) {

                titles.add(iKeyAndValue.getValue());
            }
            KLog.d("Titles", titles.size());
            KLog.d("images", images.size());


            mBanner.setImages(images);
            mBanner.setBannerTitles(titles);
            mBanner.setBannerAnimation(CubeOutTransformer.class);
            mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
            mBanner.setImageLoader(new GlideImageLoader());
            mBanner.start();


        }
    }
}