package rockets.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class RocketUnitTest {

    private Rocket target;



    @BeforeEach
    public void setUp() {
        target = new Rocket("Ariane","Mel","Monash");
    }


    @DisplayName("should throw exception when pass a empty to setName function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetNameToEmpty(String name) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setName(name));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }


    @DisplayName("should throw exception when pass null to setName function")
    @Test
    public void shouldThrowExceptionWhenSetNameToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setName(null));
        assertEquals("name cannot be null or empty", exception.getMessage());
    }



    @DisplayName("should throw exception when pass a empty country to setCountry function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhensetCountryToEmpty(String country) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setCountry(country));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }


    @DisplayName("should throw exception when pass null to setCountry function")
    @Test
    public void shouldThrowExceptionWhenSetCountryToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setCountry(null));
        assertEquals("country cannot be null or empty", exception.getMessage());
    }



    @DisplayName("should throw exception when pass a empty manufacturer to setManufacturer function")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhensetManufacturerToEmpty(String manufacturer) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> target.setManufacturer(manufacturer));
        assertEquals("manufacturer cannot be null or empty", exception.getMessage());
    }



    @DisplayName("should throw exception when pass null to setManufacturer function")
    @Test
    public void shouldThrowExceptionWhenSetManufacturerToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> target.setManufacturer(null));
        assertEquals("manufacturer cannot be null or empty", exception.getMessage());
    }


    @DisplayName("should return false when two Rockets have different name, country, manufacturer")
    @Test
    public void shouldReturnFalseWhenRocketHaveDifferentNameCountryManufacturer() {
        Rocket anotherRocket = new Rocket("Ariane6","Aus2","Test2");
        assertFalse(target.equals(anotherRocket));
    }


    @DisplayName("should return false when two Rockets have same name and different country, manufacturer")
    @Test
    public void shouldReturnFalseWhenRocketHaveDifferentCountryManufacturer() {
        Rocket anotherRocket = new Rocket("Ariane","Aus2","Test2");
        assertFalse(target.equals(anotherRocket));
    }

    @DisplayName("should return false when two Rockets have same  name, country and different manufacturer")
    @Test
    public void shouldReturnFalseWhenRocketHaveDifferentNameManufacturer() {
        Rocket anotherRocket = new Rocket("Ariane","Mel","Test2");
        assertFalse(target.equals(anotherRocket));
    }

    @DisplayName("should return true when two Rockets have same name, country, manufacturer")
    @Test
    public void shouldReturnTrueWhenUsersHaveSameEmail() {
        Rocket anotherRocket = new Rocket("Ariane","Mel","Monash");
        assertTrue(target.equals(anotherRocket));
    }

}
