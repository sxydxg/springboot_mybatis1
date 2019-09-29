package sxy.dx.pojo.one2one;

/**
 * @auther 丁溪贵
 * @date 2019/9/29
 */
public class IDCard {
    private int id ;
    private String idcardNum ; // 这个字段本来就应该是主键，但是我为了让2个类有重复的字段（id）,故意增加点难度的。
    private People people ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdcardNum() {
        return idcardNum;
    }

    public void setIdcardNum(String idcardNum) {
        this.idcardNum = idcardNum;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }
}
