package DesignQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Insert_Delete_GetRandom {
     Map<Integer,Integer>position;
      List<Integer>elementList;
      Random random;
    public Insert_Delete_GetRandom() {
        position = new HashMap<>();
        elementList = new ArrayList<>();
        random = new Random();
    }
    
    public boolean insert(int val) {
       if(position.containsKey(val))
         return false;
          elementList.add(val);
       int size=elementList.size();
       position.put(val,size-1);
       return true;   
    }
    
    public boolean remove(int val) {
        if(!position.containsKey(val))
         return false;
        int val_index=position.get(val);
          //shift last element to that position
          int size = elementList.size();
          int last_element=elementList.get(size-1);
          elementList.set(val_index,last_element);
         //update map
           position.put(last_element,val_index);
           elementList.remove(size-1);
           position.remove(val);
           return true;
    }
    
    public int getRandom() {
       int randomIndex = random.nextInt(elementList.size());
       return elementList.get(randomIndex);
    }
}
