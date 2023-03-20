import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        List<CompletableFuture<Boolean>> list = new ArrayList<>();
        for(int i=0;i<10;i++){
            list.add(CompletableFuture.supplyAsync(()->{
                int random = ThreadLocalRandom.current().nextInt(10);
                if(random>0){
                    try{
                        TimeUnit.SECONDS.sleep(random);
                    }catch (Exception e){

                    }
                }
                System.err.println(random);
                return Boolean.TRUE;
            }));
        }
        CompletableFuture.allOf(list.toArray(new CompletableFuture[0])).join();
        System.err.println("bye");
    }
}
