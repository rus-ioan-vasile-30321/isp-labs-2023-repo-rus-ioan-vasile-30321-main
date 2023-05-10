package isp.lab9.exercise1.Users;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class userHandling {

    public static List<User> readUsers(){
        List<User> users=new ArrayList<>();
        try {
            Gson gson = new Gson();
            Reader reader = Files.newBufferedReader(Paths.get("src/main/java/isp/lab9/exercise1/Users/data.json"));
            users=gson.fromJson(reader, new TypeToken<List<User>>(){}.getType());
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return users;
    }

}
