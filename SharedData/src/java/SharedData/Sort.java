package SharedData;


public class Sort {
    
    
    
    public static void sort(ShiftIndex si, Tree t) {
        for(int i = 0; i < si.getSize(); i++){
            t.insert(si.getLine(i));
        }
    }
}
