package lab1;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Objects;

public class Lab1Test
{
    @Test(dataProvider = "equalAnimal")
    public void equalAnimalTest(Animal obj1, Animal obj2, boolean res)
    {
        assertEquals(Objects.equals(obj1,obj2), res);
    }

    @DataProvider
    public Object[][] equalAnimal()
    {
        Animal fox = new AnimalBuilder().setName("Fox").setGroup(0).build();
        Animal wolf = new AnimalBuilder().setName("Wolf").setGroup(1).build();
        Animal snake = new AnimalBuilder().setName("Snake").setGroup(2).build();

        return new Object[][] {{fox, fox, true}, {fox, wolf,false}, {snake, fox, false}, {snake, snake, true}};
    }

    @Test(dataProvider = "hashEqualAnimal")
    public void hashEqualDeviceTest(Animal obj1, Animal obj2)
    {
        assertEquals(obj1.hashCode(),obj2.hashCode());
    }
    @DataProvider
    public Object[][] hashEqualAnimal()
    {
        Animal wolf1 = new AnimalBuilder().setName("Wolf").setGroup(0).build();
        Animal wolf2 = new AnimalBuilder().setName("Wolf").setGroup(0).build();
        return new Object[][]{ {wolf1, wolf2} };
    }

    @Test(dataProvider = "stringEqualAnimal")
    public void stringEqualDeviceTest(Animal obj1, Animal obj2)
    {
        assertEquals(obj1.toString(), obj2.toString());
    }
    @DataProvider
    public Object[][] stringEqualAnimal()
    {
        Animal fox1 = new AnimalBuilder().setName("Fox").setGroup(0).build();
        Animal fox2 = new AnimalBuilder().setName("Fox").setGroup(0).build();
        Animal wolf1 = new AnimalBuilder().setName("Wolf").setGroup(1).build();
        Animal wolf2 = new AnimalBuilder().setName("Wolf").setGroup(1).build();
        return new Object[][] {{fox1, fox2},{wolf1, wolf2}};
    }

}
