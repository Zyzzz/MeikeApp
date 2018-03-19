package zyzzz.imudges.com.model;

/**
 * Created by Administrator on 2018/3/19.
 */

public class CourseModel {

    /**
     * id : 13
     * name : 蒙古文Web设计
     * type : 程序员
     * lessonNumber : 0
     * organizationid : 1
     * description :
     计算机课程（蒙古语授课）
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
