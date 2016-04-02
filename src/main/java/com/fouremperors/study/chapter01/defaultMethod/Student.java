package com.fouremperors.study.chapter01.defaultMethod;

/**
 * Created by qianfanyanfa on 16/4/2.
 */
public class Student implements Person,Programmer {
    @Override
    public long getId() {

        return 12;
    }

    //因为两个接口中,都有默认方法,因此需要重写解决冲突
    @Override
    public String getName() {
        return null;
    }

    //如果,两个接口都有同名称和类型的方法,也需要重要
    public class XiaoMing implements Named,Programmer{

        @Override
        public String getName() {
            return null;
        }
    }

    //如果,只有一个默认方法不需要得写
    public class XiaoHong implements Programmer{


    }
    //如果是父类中有相同的方法的,就不用重写,不管是否接口有默认方法的实现,采用类优先的原刚
    public class ZenYou extends XiaoMing implements Programmer, Named{

    }
}
