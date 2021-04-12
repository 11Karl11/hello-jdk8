package hello.concurrent.async.future;

import java.util.concurrent.CompletableFuture;

/**
 * @author karl xie
 */
public class CompletableFutureTest1 {

    public static void main(String[] args) throws Exception {
        CompletableFuture.supplyAsync(CompletableFutureTest1::getPrice)
                .thenAccept(result -> {
                    System.out.println("price: " + result);
                })
                .exceptionally(throwable -> {
                    throwable.printStackTrace();
                    return null;
                });
        Thread.sleep(200);
    }

    private static Double getPrice() {

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (Math.random() < 0.3) {
            throw new RuntimeException("Error when get price");
        }
        return Math.random() * 20;
    }
}