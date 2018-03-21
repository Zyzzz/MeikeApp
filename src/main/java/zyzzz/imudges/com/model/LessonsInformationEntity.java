package zyzzz.imudges.com.model;

/**
 * Created by Administrator on 2018/3/21.
 */

public class LessonsInformationEntity {


    /**
     * lessonsinformationEntity : {"time":20,"lid":3,"url":"http://ohnledfyz.bkt.clouddn.com/1.1.3%20%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%9A%84%E5%88%86%E7%B1%BB%20&%201.1.4%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%9A%84%E7%94%A8%E9%80%94.mp4","tname":"周炎","phone":"15184779853","tid":1,"cid":3,"cname":"计算机应用基础（蒙古语授课）","type":"计算机","lessonNumber":20,"organizationid":1,"lname":"计算机的用途","teacherid":1,"courseId":3,"vid":5}
     * pictureEntity : {"id":11,"url":"http://ohnledfyz.bkt.clouddn.com/java.jpg","pattern":3,"otherid":1}
     */

    private LessonsinformationEntityBean lessonsinformationEntity;
    private PictureEntityBean pictureEntity;

    public LessonsinformationEntityBean getLessonsinformationEntity() {
        return lessonsinformationEntity;
    }

    public void setLessonsinformationEntity(LessonsinformationEntityBean lessonsinformationEntity) {
        this.lessonsinformationEntity = lessonsinformationEntity;
    }

    public PictureEntityBean getPictureEntity() {
        return pictureEntity;
    }

    public void setPictureEntity(PictureEntityBean pictureEntity) {
        this.pictureEntity = pictureEntity;
    }

    public static class LessonsinformationEntityBean {
        /**
         * time : 20
         * lid : 3
         * url : http://ohnledfyz.bkt.clouddn.com/1.1.3%20%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%9A%84%E5%88%86%E7%B1%BB%20&%201.1.4%E8%AE%A1%E7%AE%97%E6%9C%BA%E7%9A%84%E7%94%A8%E9%80%94.mp4
         * tname : 周炎
         * phone : 15184779853
         * tid : 1
         * cid : 3
         * cname : 计算机应用基础（蒙古语授课）
         * type : 计算机
         * lessonNumber : 20
         * organizationid : 1
         * lname : 计算机的用途
         * teacherid : 1
         * courseId : 3
         * vid : 5
         */

        private int time;
        private int lid;
        private String url;
        private String tname;
        private String phone;
        private int tid;
        private int cid;
        private String cname;
        private String type;
        private int lessonNumber;
        private int organizationid;
        private String lname;
        private int teacherid;
        private int courseId;
        private int vid;

        public int getTime() {
            return time;
        }

        public void setTime(int time) {
            this.time = time;
        }

        public int getLid() {
            return lid;
        }

        public void setLid(int lid) {
            this.lid = lid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTname() {
            return tname;
        }

        public void setTname(String tname) {
            this.tname = tname;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getCname() {
            return cname;
        }

        public void setCname(String cname) {
            this.cname = cname;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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

        public int getVid() {
            return vid;
        }

        public void setVid(int vid) {
            this.vid = vid;
        }
    }

    public static class PictureEntityBean {
        /**
         * id : 11
         * url : http://ohnledfyz.bkt.clouddn.com/java.jpg
         * pattern : 3
         * otherid : 1
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
}
