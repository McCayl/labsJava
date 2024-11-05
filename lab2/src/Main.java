import task1.Cat;
import task1.Cow;
import task1.Dog;
import task1.IVoice;
import task3.ExtendedClass;
import task4.UsdRubConverter;
import task4.impl.UsdRubConverterImpl;

public class Main {
    public static void main(String[] args) {
        IVoice cat = new Cat();
        IVoice dog = new Dog();
        IVoice cow = new Cow();
        cat.voice();
        dog.voice();
        cow.voice();

        ExtendedClass obj = new ExtendedClass();
        obj.setB((byte) 1)
                .setD(1d)
                .setI(1)
                .setS("1");

        UsdRubConverter converter = new UsdRubConverterImpl();
        System.out.println(converter.convertRubToUsd(10));
        System.out.println(converter.convertUsdToRub(10));
    }
}