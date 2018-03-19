package zyzzz.imudges.com.model;

import java.util.List;

/**
 * Created by Administrator on 2018/3/19.
 */

public class CourseInformationModel extends BaseModel {

    private List<CourseInformationEntitiesBean> courseInformationEntities;

    public List<CourseInformationEntitiesBean> getCourseInformationEntities() {
        return courseInformationEntities;
    }

    public void setCourseInformationEntities(List<CourseInformationEntitiesBean> courseInformationEntities) {
        this.courseInformationEntities = courseInformationEntities;
    }

    public static class CourseInformationEntitiesBean {
        /**
         * courseEntity : {"id":2,"name":"sql数据库原理与应用","type":"程序员","lessonNumber":1,"organizationid":1,"description":"sql课程大家快来学习"}
         * pictureEntity : {"id":2,"url":"http://ohnledfyz.bkt.clouddn.com/u=4274574080,2120955030&fm=23&gp=0.jpg","pattern":1,"otherid":2}
         */

        private CourseEntityBean courseEntity;
        private PictureEntityBean pictureEntity;

        public CourseEntityBean getCourseEntity() {
            return courseEntity;
        }

        public void setCourseEntity(CourseEntityBean courseEntity) {
            this.courseEntity = courseEntity;
        }

        public PictureEntityBean getPictureEntity() {
            return pictureEntity;
        }

        public void setPictureEntity(PictureEntityBean pictureEntity) {
            this.pictureEntity = pictureEntity;
        }

        public static class CourseEntityBean {
            /**
             * id : 2
             * name : sql数据库原理与应用
             * type : 程序员
             * lessonNumber : 1
             * organizationid : 1
             * description : sql课程大家快来学习
             */

            private int id;
            private String name;
            private String type;
            private int lessonNumber;
            private int organizationid;
            private String description;

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

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }

        public static class PictureEntityBean {
            /**
             * id : 2
             * url : http://ohnledfyz.bkt.clouddn.com/u=4274574080,2120955030&fm=23&gp=0.jpg
             * pattern : 1
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
    }
}
