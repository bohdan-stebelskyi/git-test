package lab2;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Lab2Test {

    @Test(dataProvider = "serializeToJSONTest")
    public void serializeJsonProviderTest(String fileName, JsonSerializer<Car> serializer, Car obj) throws IOException, ClassNotFoundException {
        serializer.serialize(obj, fileName);
        Car res = serializer.deserialize(fileName);
        assertEquals(res, obj);
    }

    @DataProvider
    public Object[][] serializeToJSONTest() {
        Car obj1 = new Car("red", "toyota", 123);
        Car obj2 = new Car("blue", "kia", 321);
        return new Object[][]
                {
                        {"JsonTest1.json", new JsonSerializer<Car>(Car.class), obj1},
                        {"JsonTest2.json", new JsonSerializer<Car>(Car.class), obj2}
                };
    }

    @Test(dataProvider = "serializeToXmlTest")
    public void serializeXmlProviderTest(String fileName, XmlSerializer<Car> serializer, Car obj) throws IOException, ClassNotFoundException {
        serializer.serialize(obj, fileName);
        Car res = serializer.deserialize(fileName);
        assertEquals(res, obj);
    }

    @DataProvider
    public Object[][] serializeToXmlTest() {
        Car obj1 = new Car("navy", "lincoln", 675);
        Car obj2 = new Car("purple", "mazda", 847);
        return new Object[][]
                {
                        {"XmlTest1.xml", new XmlSerializer<Car>(Car.class), obj1},
                        {"XmlTest2.xml", new XmlSerializer<Car>(Car.class), obj2}
                };
    }

    @Test(dataProvider = "serializeToTxtTest")
    public void serializeTxtProviderTest(String fileName, TxtSerializer<Car> serializer, Car obj) throws IOException, ClassNotFoundException {
        serializer.serialize(obj, fileName);
        Car res = serializer.deserialize(fileName);
        assertEquals(res, obj);
    }

    @DataProvider
    public Object[][] serializeToTxtTest() {
        Car obj1 = new Car("pink", "mitsubishi", 374);
        Car obj2 = new Car("maroon", "mercedes", 901);
        return new Object[][]
                {
                        {"TxtTest1.txt", new TxtSerializer<Car>(), obj1},
                        {"TxtTest2.txt", new TxtSerializer<Car>(), obj2}
                };
    }
}
