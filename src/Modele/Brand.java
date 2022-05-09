package Modele;

public class Brand {
    // 扑克牌的类型 ：
    private Type type;
    private final Integer inttype;
    // 扑克牌的大小
    private Integer num;

    // 直接创建一个构造器用来 创建每一张扑克牌
    public Brand(Type type, Integer num,Integer inttype) {
        super();
        this.type = type;
        this.num = num;
        this.inttype=inttype;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Integer getNum() {
        return num;
    }

    public Integer getInttype() {
        return inttype;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Brand [type=" + type + ", num=" + num + "]";
    }
}
