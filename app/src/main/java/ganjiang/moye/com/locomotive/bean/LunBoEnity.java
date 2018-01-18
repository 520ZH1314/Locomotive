package ganjiang.moye.com.locomotive.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 项目名称:Locomotive
 * Created by lovezh
 * CreatedData: on 2017/12/28.
 */

public class LunBoEnity {

    /**
     * Msg : 成功
     * imgs : [{"hyperlink":"http://www.baidu.com","id":240,"issuetime":"2017-03-23","resume":"首页横幅4副标题1","subtitle1":"首页横幅4副标题1","subtitle2":"首页横幅4副标题2","subtitle3":"首页横幅4副标题3","title":"首页横幅4","titlepic":"http://my.ganjiangps.com/upload/1490252350355.png"},{"hyperlink":"http://www.niwodai.com/activity.mhtml?artId=5820160000006937&f&h&?intcmp=hompage_kv_1","id":81,"issuetime":"2017-03-23","title":"有道智投实用宝典","titlepic":"http://my.ganjiangps.com/upload/1490151429702.jpg"},{"hyperlink":"http://www.niwodai.com/Public/Static/nwd/active/2016/12/lastyear/pc/index.html?intcmp=hompage_kv_3","id":82,"issuetime":"2017-03-22","title":"以梦为马矩步方行","titlepic":"http://my.ganjiangps.com/upload/1489975686445.png"},{"hyperlink":"http://www.niwodai.com/tj2017.html?intcmp=hompage_kv_2","id":83,"issuetime":"2017-03-22","title":"双赢双益","titlepic":"http://my.ganjiangps.com/upload/1489046726562.jpeg"},{"hyperlink":"http://www.baidu.com","id":262,"issuetime":"2017-05-11","subtitle1":"电饭锅","subtitle2":"水电费","subtitle3":"水电费","title":"有道智投实用宝典","titlepic":"http://my.ganjiangps.com/upload/1494492630874.jpg"}]
     * status : 1
     */

    private String Msg;
    private int status;
    private List<ImgsBean> imgs;

    public String getMsg() {
        return Msg;
    }

    public void setMsg(String Msg) {
        this.Msg = Msg;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<ImgsBean> getImgs() {
        return imgs;
    }

    public void setImgs(List<ImgsBean> imgs) {
        this.imgs = imgs;
    }

    public static class ImgsBean implements Parcelable {
        /**
         * hyperlink : http://www.baidu.com
         * id : 240
         * issuetime : 2017-03-23
         * resume : 首页横幅4副标题1
         * subtitle1 : 首页横幅4副标题1
         * subtitle2 : 首页横幅4副标题2
         * subtitle3 : 首页横幅4副标题3
         * title : 首页横幅4
         * titlepic : http://my.ganjiangps.com/upload/1490252350355.png
         */

        private String hyperlink;
        private int id;
        private String issuetime;
        private String resume;
        private String subtitle1;
        private String subtitle2;
        private String subtitle3;
        private String title;
        private String titlepic;

        public ImgsBean(Parcel in) {
            hyperlink = in.readString();
            id = in.readInt();
            issuetime = in.readString();
            resume = in.readString();
            subtitle1 = in.readString();
            subtitle2 = in.readString();
            subtitle3 = in.readString();
            title = in.readString();
            titlepic = in.readString();
        }

        public static final Creator<ImgsBean> CREATOR = new Creator<ImgsBean>() {
            @Override
            public ImgsBean createFromParcel(Parcel in) {
                return new ImgsBean(in);
            }

            @Override
            public ImgsBean[] newArray(int size) {
                return new ImgsBean[size];
            }
        };

        public String getHyperlink() {
            return hyperlink;
        }

        public void setHyperlink(String hyperlink) {
            this.hyperlink = hyperlink;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getIssuetime() {
            return issuetime;
        }

        public void setIssuetime(String issuetime) {
            this.issuetime = issuetime;
        }

        public String getResume() {
            return resume;
        }

        public void setResume(String resume) {
            this.resume = resume;
        }

        public String getSubtitle1() {
            return subtitle1;
        }

        public void setSubtitle1(String subtitle1) {
            this.subtitle1 = subtitle1;
        }

        public String getSubtitle2() {
            return subtitle2;
        }

        public void setSubtitle2(String subtitle2) {
            this.subtitle2 = subtitle2;
        }

        public String getSubtitle3() {
            return subtitle3;
        }

        public void setSubtitle3(String subtitle3) {
            this.subtitle3 = subtitle3;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTitlepic() {
            return titlepic;
        }

        public void setTitlepic(String titlepic) {
            this.titlepic = titlepic;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(hyperlink);
            parcel.writeInt(id);
            parcel.writeString(issuetime);
            parcel.writeString(resume);
            parcel.writeString(subtitle1);
            parcel.writeString(subtitle2);
            parcel.writeString(subtitle3);
            parcel.writeString(title);
            parcel.writeString(titlepic);
        }
    }
}
