package zyzzz.imudges.com.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2018/3/20.
 */

public class LessonInformationModel extends BaseModel{

    /**
     * landcviewEntities : [{"lid":2,"lname":"计算机的概念","teacherid":1,"courseId":3,"videoId":4,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":3,"lname":"计算机的用途","teacherid":1,"courseId":3,"videoId":5,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":4,"lname":"计算机硬件系统","teacherid":1,"courseId":3,"videoId":6,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":5,"lname":"计算机软件系统","teacherid":1,"courseId":3,"videoId":7,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":6,"lname":"进制的概念","teacherid":1,"courseId":3,"videoId":8,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":7,"lname":"进制之间的转换","teacherid":1,"courseId":3,"videoId":9,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":8,"lname":"字符数据的编码","teacherid":1,"courseId":3,"videoId":10,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":9,"lname":"多媒体信息编码","teacherid":1,"courseId":3,"videoId":11,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":10,"lname":" 操作系统的概念","teacherid":1,"courseId":3,"videoId":12,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":11,"lname":"操作系统的分类","teacherid":1,"courseId":3,"videoId":13,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":12,"lname":"引导过程","teacherid":1,"courseId":3,"videoId":14,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":13,"lname":"Windows操作系统","teacherid":1,"courseId":3,"videoId":15,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":14,"lname":"Unix操作系统","teacherid":1,"courseId":3,"videoId":16,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":15,"lname":"Linux操作系统","teacherid":1,"courseId":3,"videoId":17,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":16,"lname":"Android操作系统","teacherid":1,"courseId":3,"videoId":18,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":17,"lname":"IOS操作系统","teacherid":1,"courseId":3,"videoId":19,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":18,"lname":"应用程序管理","teacherid":1,"courseId":3,"videoId":20,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":19,"lname":"存储管理","teacherid":1,"courseId":3,"videoId":21,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":20,"lname":"文字处理软件","teacherid":1,"courseId":3,"videoId":22,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":21,"lname":"文字布局","teacherid":1,"courseId":3,"videoId":23,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":22,"lname":"长文档排版","teacherid":1,"courseId":3,"videoId":24,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":23,"lname":"数据计算","teacherid":1,"courseId":3,"videoId":25,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":24,"lname":"演示文稿与演示文稿软件","teacherid":1,"courseId":3,"videoId":26,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"},{"lid":28,"lname":"ss","teacherid":5,"courseId":3,"videoId":42,"time":20,"cid":3,"type":"计算机","cname":"计算机应用基础（蒙古语授课）","lessonNumber":20,"organizationid":2,"description":"蒙语计算机课程"}]
     * pictureEntity : {"id":21,"url":"http://ohnledfyz.bkt.clouddn.com/QQ%E6%88%AA%E5%9B%BE20170718092238.png","pattern":1,"otherid":3}
     * organizationEntity : {"result":null,"status":0,"id":2,"name":"内蒙古大学","information":"内蒙古呼和浩特内蒙古大学","address":"213","rank":0,"email":"456","password":"456","cookie":"990c76e2a3cbfc0bd3d038460d25312bb9d7cf31c05f2d41f4646efe8b0a247d","securityCode":null}
     * oPictureEntity : {"id":20,"url":"http://ohnledfyz.bkt.clouddn.com/QQ%E6%88%AA%E5%9B%BE20170718092238.png","pattern":2,"otherid":2}
     */

    private PictureEntityBean pictureEntity;
    private OrganizationEntityBean organizationEntity;
    private OPictureEntityBean oPictureEntity;
    private List<LandcviewEntitiesBean> landcviewEntities;

    public PictureEntityBean getPictureEntity() {
        return pictureEntity;
    }

    public void setPictureEntity(PictureEntityBean pictureEntity) {
        this.pictureEntity = pictureEntity;
    }

    public OrganizationEntityBean getOrganizationEntity() {
        return organizationEntity;
    }

    public void setOrganizationEntity(OrganizationEntityBean organizationEntity) {
        this.organizationEntity = organizationEntity;
    }

    public OPictureEntityBean getOPictureEntity() {
        return oPictureEntity;
    }

    public void setOPictureEntity(OPictureEntityBean oPictureEntity) {
        this.oPictureEntity = oPictureEntity;
    }

    public List<LandcviewEntitiesBean> getLandcviewEntities() {
        return landcviewEntities;
    }

    public void setLandcviewEntities(List<LandcviewEntitiesBean> landcviewEntities) {
        this.landcviewEntities = landcviewEntities;
    }

    public static class PictureEntityBean {
        /**
         * id : 21
         * url : http://ohnledfyz.bkt.clouddn.com/QQ%E6%88%AA%E5%9B%BE20170718092238.png
         * pattern : 1
         * otherid : 3
         */

        private int id;
        private String url;
        private int pattern;
        private int otherid;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getPattern() {
            return pattern;
        }

        public void setPattern(int pattern) {
            this.pattern = pattern;
        }

        public int getOtherid() {
            return otherid;
        }

        public void setOtherid(int otherid) {
            this.otherid = otherid;
        }
    }

    public static class OrganizationEntityBean {
        /**
         * result : null
         * status : 0
         * id : 2
         * name : 内蒙古大学
         * information : 内蒙古呼和浩特内蒙古大学
         * address : 213
         * rank : 0
         * email : 456
         * password : 456
         * cookie : 990c76e2a3cbfc0bd3d038460d25312bb9d7cf31c05f2d41f4646efe8b0a247d
         * securityCode : null
         */

        @SerializedName("result")
        private Object resultX;
        @SerializedName("status")
        private int statusX;
        private int id;
        private String name;
        private String information;
        private String address;
        private int rank;
        private String email;
        private String password;
        private String cookie;
        private Object securityCode;

        public Object getResultX() {
            return resultX;
        }

        public void setResultX(Object resultX) {
            this.resultX = resultX;
        }

        public int getStatusX() {
            return statusX;
        }

        public void setStatusX(int statusX) {
            this.statusX = statusX;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getInformation() {
            return information;
        }

        public void setInformation(String information) {
            this.information = information;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getRank() {
            return rank;
        }

        public void setRank(int rank) {
            this.rank = rank;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getCookie() {
            return cookie;
        }

        public void setCookie(String cookie) {
            this.cookie = cookie;
        }

        public Object getSecurityCode() {
            return securityCode;
        }

        public void setSecurityCode(Object securityCode) {
            this.securityCode = securityCode;
        }
    }

    public static class OPictureEntityBean {
        /**
         * id : 20
         * url : http://ohnledfyz.bkt.clouddn.com/QQ%E6%88%AA%E5%9B%BE20170718092238.png
         * pattern : 2
         * otherid : 2
         */

        private int id;
        private String url;
        private int pattern;
        private int otherid;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getPattern() {
            return pattern;
        }

        public void setPattern(int pattern) {
            this.pattern = pattern;
        }

        public int getOtherid() {
            return otherid;
        }

        public void setOtherid(int otherid) {
            this.otherid = otherid;
        }
    }

    public static class LandcviewEntitiesBean {
        /**
         * lid : 2
         * lname : 计算机的概念
         * teacherid : 1
         * courseId : 3
         * videoId : 4
         * time : 20
         * cid : 3
         * type : 计算机
         * cname : 计算机应用基础（蒙古语授课）
         * lessonNumber : 20
         * organizationid : 2
         * description : 蒙语计算机课程
         */

        private int lid;
        private String lname;
        private int teacherid;
        private int courseId;
        private int videoId;
        private int time;
        private int cid;
        private String type;
        private String cname;
        private int lessonNumber;
        private int organizationid;
        private String description;

        public int getLid() {
            return lid;
        }

        public void setLid(int lid) {
            this.lid = lid;
        }

        public String getLname() {
            return lname;
        }

        public void setLname(String lname) {
            this.lname = lname;
        }

        public int getTeacherid() {
            return teacherid;
        }

        public void setTeacherid(int teacherid) {
            this.teacherid = teacherid;
        }

        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public int getVideoId() {
            return videoId;
        }

        public void setVideoId(int videoId) {
            this.videoId = videoId;
        }

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public int getLessonNumber() {
            return lessonNumber;
        }

        public void setLessonNumber(int lessonNumber) {
            this.lessonNumber = lessonNumber;
        }

        public int getOrganizationid() {
            return organizationid;
        }

        public void setOrganizationid(int organizationid) {
            this.organizationid = organizationid;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
}
