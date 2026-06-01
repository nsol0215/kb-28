package main.java.ch09_collection_generic.sec02.exam02;

public class CarAgency implements Rentable<Car>{
    @Override
    public Car rent(){
        return new Car();
    }
}
