package ganjiang.moye.com.locomotive.http;

import ganjiang.moye.com.locomotive.bean.LunBoEnity;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/26.
 * 首页网络请求
 */

public interface HomeService {
    @FormUrlEncoded
    @POST("ui/app/getImage.action")
    Observable<LunBoEnity> goLunBoTu(@Field("terminal") int terminal, @Field("itino") int itino);

}
