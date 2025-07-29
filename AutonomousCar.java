import java.util.*;

public class AutonomousCar
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Car cars[]=new Car[4];
        for(int i=0;i<4;i++)
        {
            int id=sc.nextInt();
            sc.nextLine();
            String br=sc.nextLine();
            int tc=sc.nextInt();
            int tp=sc.nextInt();
            sc.nextLine();
            String env=sc.nextLine();
            cars[i]=new Car(id,br,tc,tp,env);
        }

        String env=sc.nextLine();
        int sum=findTestPassedByEnv(cars,env);
        if(sum>0)
            System.out.println(sum);
        else
            System.out.println("There are no test passed in this particular environment");
            
        String brand=sc.nextLine();
        String grade=updateCar(cars,brand);
        if(grade!=null)
            System.out.print(grade);
        else
            System.out.print("No car is available with the specific brand");
    }

    public static int findTestPassedByEnv(Car cars[],String env)
    {
        int sum=0;
        for(Car car:cars)
            if(car.getEnv().equalsIgnoreCase(env))
                sum+=car.getTestPass();
        return sum;
    }

    public static String updateCar(Car cars[],String brand)
    {
        for(Car car:cars)
        {
            if(car.getBrand().equalsIgnoreCase(brand))
            {
                int rating=(car.getTestPass()*100)/car.getTestCond();
                String grade=brand+"::";
                if(rating>=80)
                    grade+="A1";
                else
                    grade+="B2";
                return grade;
            }
        }
        return null;
    }
}

class Car
{
    private int carId,testPassed,testConducted;
    private String brand,environment;

    public Car(int id,String br,int tc,int tp,String env)
    {
        carId=id;
        brand=br;
        testConducted=tc;
        testPassed=tp;
        environment=env;
    }

    public int getId()
    {
        return carId;
    }

    public String getBrand()
    {
        return brand;
    }

    public int getTestCond()
    {
        return testConducted;
    }

    public int getTestPass()
    {
        return testPassed;
    }

    public String getEnv()
    {
        return environment;
    }
}
