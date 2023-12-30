import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class RestaurantService{
    private static List<Restaurant> restaurants = new ArrayList<>();

    public Restaurant findRestaurantByName(String restaurantName) throws restaurantNotFoundException {
       // return null;
        //DELETE ABOVE STATEMENT AND WRITE CODE HERE
        int flag=0;
        for(Restaurant rest1:restaurants){
            if(rest1.getName().equals(restaurantName)){
                flag=1;
                return rest1;
            }
        }
        if(flag==0) {
            throw new restaurantNotFoundException(restaurantName);
        }
        return null;
    }


    public Restaurant addRestaurant(String name, String location, LocalTime openingTime, LocalTime closingTime) {
        Restaurant newRestaurant = new Restaurant(name, location, openingTime, closingTime);
        restaurants.add(newRestaurant);
        return newRestaurant;
    }

    public Restaurant removeRestaurant(String restaurantName) throws restaurantNotFoundException {
        Restaurant restaurantToBeRemoved = findRestaurantByName(restaurantName);
        restaurants.remove(restaurantToBeRemoved);
        return restaurantToBeRemoved;
    }

    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
